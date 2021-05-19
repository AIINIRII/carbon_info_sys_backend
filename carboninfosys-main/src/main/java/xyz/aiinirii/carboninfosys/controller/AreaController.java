package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.aiinirii.carboninfosys.common.api.CommonPage;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.domain.AreaParam;
import xyz.aiinirii.carboninfosys.model.Area;
import xyz.aiinirii.carboninfosys.service.AreaService;

/**
 * @author AIINIRII
 */
@RestController
@RequestMapping("/area")
@Api(value = "AreaController", tags = {"区域有关操作"})
public class AreaController {
    private AreaService areaService;

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @ApiOperation("获取所有地区")
    @GetMapping("")
    public CommonResult<CommonPage<Area>> getAreas(@RequestParam int pageNum, @RequestParam int pageSize) {
        CommonPage<Area> areas = areaService.getAreas(pageNum, pageSize);
        return CommonResult.success(areas);
    }

    @ApiOperation("根据id获取地区信息")
    @GetMapping("/{id}")
    public CommonResult<Area> getAreaById(@PathVariable Long id) {
        Area result = areaService.getAreaById(id);
        if (result == null) {
            return CommonResult.failed("id不存在");
        } else {
            return CommonResult.success(result);
        }
    }

    @ApiOperation("添加地区")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PostMapping("")
    public CommonResult<?> addArea(@RequestBody @Validated AreaParam areaParam, BindingResult bindingResult) {

        boolean addResult = areaService.addArea(areaParam);
        if (addResult) {
            return CommonResult.success(null, "地区数据插入成功");
        } else {
            return CommonResult.failed("地区数据插入失败");
        }
    }

    @ApiOperation("删除地区")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @DeleteMapping("/{areaId}")
    public CommonResult<?> deleteArea(@PathVariable("areaId") Long areaId) {
        boolean deleteResult = areaService.deleteAreaByAreaId(areaId);
        if (deleteResult) {
            return CommonResult.success(null, "地区数据删除成功");
        } else {
            return CommonResult.failed("地区数据删除失败");
        }
    }

    @ApiOperation("修改地区")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PostMapping("/{areaId}")
    public CommonResult<?> deleteArea(@PathVariable("areaId") Long areaId, @RequestBody @Validated AreaParam areaParam, BindingResult bindingResult) {
        boolean updateResult = areaService.updateAreaByAreaId(areaId, areaParam);
        if (updateResult) {
            return CommonResult.success(null, "地区数据修改成功");
        } else {
            return CommonResult.failed("地区数据修改失败");
        }
    }

}
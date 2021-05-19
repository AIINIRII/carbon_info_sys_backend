package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.domain.BuildingParam;
import xyz.aiinirii.carboninfosys.model.Building;
import xyz.aiinirii.carboninfosys.service.BuildingService;
import xyz.aiinirii.carboninfosys.service.ExportService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.List;

/**
 * @author AIINIRII
 */
@RestController
@RequestMapping("/building")
@Api(value = "BuildingController", tags = {"建筑相关操作"})
public class BuildingController {
    private BuildingService buildingService;
    private ExportService exportService;

    @Autowired
    public void setExportService(ExportService exportService) {
        this.exportService = exportService;
    }

    @Autowired
    public void setBuildingService(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @ApiOperation("获取对应建筑群下所有建筑")
    @GetMapping("")
    public CommonResult<List<Building>> getBuildings(@RequestParam("areaId") Long areaId,
                                                     @RequestParam("buildingGroupId") Integer buildingGroupId) {
        return CommonResult.success(buildingService.getBuildings(areaId, buildingGroupId), "建筑获取成功");
    }

    @ApiOperation("向对应建筑群下添加建筑")
    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public CommonResult<?> addBuilding(@RequestParam("areaId") Long areaId,
                                       @RequestParam("buildingGroupId") Integer buildingGroupId,
                                       @RequestBody @Validated BuildingParam buildingParam,
                                       BindingResult bindingResult) {
        String key = buildingService.addBuilding(areaId, buildingGroupId, buildingParam);
        if (key != null) {
            return CommonResult.success(key, "添加建筑成功");
        } else {
            return CommonResult.failed("添加建筑失败");
        }
    }

    @ApiOperation("删去建筑")
    @DeleteMapping("/{buildingId}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public CommonResult<?> deleteBuilding(@PathVariable("buildingId") Long buildingId) {
        boolean deleteResult = buildingService.deleteBuilding(buildingId);

        if (deleteResult) {
            return CommonResult.success(null, "删除建筑成功");
        } else {
            return CommonResult.failed("删除建筑失败");
        }
    }

    @ApiOperation("修改建筑信息")
    @PutMapping("/{buildingId}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public CommonResult<?> addBuilding(@PathVariable("buildingId") Long buildingId,
                                       @RequestBody @Validated BuildingParam buildingParam) {
        boolean updateResult = buildingService.updateBuilding(buildingId, buildingParam);
        if (updateResult) {
            return CommonResult.success(null, "修改建筑信息成功");
        } else {
            return CommonResult.failed("修改建筑信息失败");
        }
    }

    @ApiOperation("根据建筑id以Excel形式导出")
    @GetMapping("/{buildingId}/export")
    public void exportExcel(@PathVariable("buildingId") Long buildingId, HttpServletResponse httpServletResponse) throws IOException {
        SXSSFWorkbook sxssfWorkbook = exportService.getSheets(buildingId);
        Building building = buildingService.getBuilding(buildingId);
        // 下载导出
        String filename = building.getName();
        // 设置头信息
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/vnd.ms-excel");
        //一定要设置成xlsx格式
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "Content-Disposition,X-Suggested-Filename");
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename + ".xlsx", "UTF-8"));
        //创建一个输出流
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        //写入数据
        sxssfWorkbook.write(outputStream);
        // 关闭
        outputStream.close();
        sxssfWorkbook.close();
    }
}
package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.domain.EnvironmentInfoParam;
import xyz.aiinirii.carboninfosys.model.Building;
import xyz.aiinirii.carboninfosys.model.EnvironmentBuildingDetailedDate;
import xyz.aiinirii.carboninfosys.service.BuildingService;
import xyz.aiinirii.carboninfosys.service.EnvironmentService;
import xyz.aiinirii.carboninfosys.service.ExportService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author AIINIRII
 */
@RestController
@RequestMapping("/environment")
@Api(value = "EnvironmentController", tags = {"环境相关操作"})
public class EnvironmentController {
    private EnvironmentService environmentService;
    BuildingService buildingService;
    ExportService exportService;

    @Autowired
    public void setBuildingService(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @Autowired
    public void setExportService(ExportService exportService) {
        this.exportService = exportService;
    }


    @Autowired
    public void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @ApiOperation("给对应建筑添加信息")
    @PostMapping("/building/{buildingId}")
    public CommonResult<?> addEnvironmentInfo(@PathVariable("buildingId") Long buildingId, @RequestBody @Validated EnvironmentInfoParam environmentInfoParam) {
        boolean addResult = environmentService.postEnvironmentInfo(buildingId, environmentInfoParam.getKey(), environmentInfoParam);
        if (addResult) {
            return CommonResult.success(null, "添加信息成功");
        } else {
            return CommonResult.failed("添加信息失败");
        }
    }

    @ApiOperation("根据区域ID获取环境信息序列(当年)")
    @GetMapping("/area/{areaId}/list/year")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingTotalListByYear(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingTotalListByYear(areaId));
    }

    @ApiOperation("根据区域ID获取环境信息序列(所有)")
    @GetMapping("/area/{areaId}/list/all")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingTotalListByAll(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingTotalListByAll(areaId));
    }

    @ApiOperation("根据区域ID获取环境信息序列(当月)")
    @GetMapping("/area/{areaId}/list/month")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingTotalListByMonth(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingTotalListByMonth(areaId));
    }

    @ApiOperation("根据区域ID获取环境信息序列(当季)")
    @GetMapping("/area/{areaId}/list/season")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingTotalListBySeason(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingTotalListBySeason(areaId));
    }

    @ApiOperation("根据区域ID获取环境信息序列(当周)")
    @GetMapping("/area/{areaId}/list/week")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingTotalListByWeek(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingTotalListByWeek(areaId));
    }

    @ApiOperation("根据区域ID获取环境信息序列(当天)")
    @GetMapping("/area/{areaId}/list/today")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingTotalListByDay(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingTotalListByDay(areaId));
    }

    @ApiOperation("根据建筑ID获取环境信息序列(当年)")
    @GetMapping("/building/{buildingId}/list/year")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingByBuildingIdByYear(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingByBuildingIdByYear(buildingId));
    }

    @ApiOperation("根据建筑ID获取环境信息序列(所有)")
    @GetMapping("/building/{buildingId}/list/all")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingByBuildingIdByAll(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingByBuildingIdByAll(buildingId));
    }

    @ApiOperation("根据建筑ID获取环境信息序列(当月)")
    @GetMapping("/building/{buildingId}/list/month")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingByBuildingIdByMonth(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingByBuildingIdByMonth(buildingId));
    }

    @ApiOperation("根据建筑ID获取环境信息序列(当季)")
    @GetMapping("/building/{buildingId}/list/season")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingByBuildingIdBySeason(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingByBuildingIdBySeason(buildingId));
    }

    @ApiOperation("根据建筑ID获取环境信息序列(当周)")
    @GetMapping("/building/{buildingId}/list/week")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingByBuildingIdByWeek(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingByBuildingIdByWeek(buildingId));
    }

    @ApiOperation("根据建筑ID获取环境信息序列(当天)")
    @GetMapping("/building/{buildingId}/list/today")
    public CommonResult<List<EnvironmentBuildingDetailedDate>> getEnvironmentBuildingByBuildingIdByDay(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(environmentService.getEnvironmentBuildingByBuildingIdByDay(buildingId));
    }
    @ApiOperation("根据建筑id以Excel形式导出")
    @GetMapping("/{buildingId}/export")
    public void exportExcel(@PathVariable("buildingId") Long buildingId, HttpServletResponse httpServletResponse) throws IOException {
        SXSSFWorkbook sxssfWorkbook = exportService.getEnvironmentBuildingSheet(buildingId);
        Building building = buildingService.getBuilding(buildingId);
        // 下载导出
        String filename = building.getName() + " 环境监测";
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
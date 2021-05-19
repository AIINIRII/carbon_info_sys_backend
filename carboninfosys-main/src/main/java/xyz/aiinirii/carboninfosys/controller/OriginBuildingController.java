package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.model.Building;
import xyz.aiinirii.carboninfosys.model.CarbonBuildingDetailedDate;
import xyz.aiinirii.carboninfosys.service.BuildingService;
import xyz.aiinirii.carboninfosys.service.CarbonBuildingService;
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
@RequestMapping("/origin-info")
@Api(value = "OriginBuildingController", tags = {"建筑能耗相关操作"})
public class OriginBuildingController {
    CarbonBuildingService carbonBuildingService;
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
    public void setCarbonBuildingService(CarbonBuildingService carbonBuildingService) {
        this.carbonBuildingService = carbonBuildingService;
    }

    @ApiOperation("根据区域ID获取能耗信息序列(当年)")
    @GetMapping("/area/{areaId}/list/year")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingTotalListByYear(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingTotalListByYear(areaId));
    }

    @ApiOperation("根据区域ID获取能耗信息序列(所有)")
    @GetMapping("/area/{areaId}/list/all")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingTotalListByAll(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingTotalListByAll(areaId));
    }

    @ApiOperation("根据区域ID获取能耗信息序列(当月)")
    @GetMapping("/area/{areaId}/list/month")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingTotalListByMonth(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingTotalListByMonth(areaId));
    }

    @ApiOperation("根据区域ID获取能耗信息序列(当季)")
    @GetMapping("/area/{areaId}/list/season")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingTotalListBySeason(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingTotalListBySeason(areaId));
    }

    @ApiOperation("根据区域ID获取能耗信息序列(当周)")
    @GetMapping("/area/{areaId}/list/week")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingTotalListByWeek(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingTotalListByWeek(areaId));
    }

    @ApiOperation("根据区域ID获取能耗信息序列(当天)")
    @GetMapping("/area/{areaId}/list/today")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingTotalListByDay(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingTotalListByDay(areaId));
    }
    @ApiOperation("根据建筑ID获取能耗信息序列(当年)")
    @GetMapping("/building/{buildingId}/list/year")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingByBuildingIdByYear(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingByBuildingIdByYear(buildingId));
    }

    @ApiOperation("根据建筑ID获取能耗信息序列(所有)")
    @GetMapping("/building/{buildingId}/list/all")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingByBuildingIdByAll(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingByBuildingIdByAll(buildingId));
    }

    @ApiOperation("根据建筑ID获取能耗信息序列(当月)")
    @GetMapping("/building/{buildingId}/list/month")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingByBuildingIdByMonth(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingByBuildingIdByMonth(buildingId));
    }

    @ApiOperation("根据建筑ID获取能耗信息序列(当季)")
    @GetMapping("/building/{buildingId}/list/season")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingByBuildingIdBySeason(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingByBuildingIdBySeason(buildingId));
    }

    @ApiOperation("根据建筑ID获取能耗信息序列(当周)")
    @GetMapping("/building/{buildingId}/list/week")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingByBuildingIdByWeek(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingByBuildingIdByWeek(buildingId));
    }

    @ApiOperation("根据建筑ID获取能耗信息序列(当天)")
    @GetMapping("/building/{buildingId}/list/today")
    public CommonResult<List<CarbonBuildingDetailedDate>> getCarbonBuildingByBuildingIdByDay(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingByBuildingIdByDay(buildingId));
    }


    @ApiOperation("根据建筑id以Excel形式导出")
    @GetMapping("/{buildingId}/export")
    public void exportExcel(@PathVariable("buildingId") Long buildingId, HttpServletResponse httpServletResponse) throws IOException {
        SXSSFWorkbook sxssfWorkbook = exportService.getCarbonBuildingSheet(buildingId);
        Building building = buildingService.getBuilding(buildingId);
        // 下载导出
        String filename = building.getName() + " 能耗监测";
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
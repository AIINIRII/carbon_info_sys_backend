package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.domain.CarbonInfoParam;
import xyz.aiinirii.carboninfosys.enums.PeriodType;
import xyz.aiinirii.carboninfosys.model.*;
import xyz.aiinirii.carboninfosys.service.BuildingService;
import xyz.aiinirii.carboninfosys.service.CarbonBuildingService;
import xyz.aiinirii.carboninfosys.service.ExportService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author AIINIRII
 */
@RestController
@RequestMapping("/carbon-info")
@Api(value = "CarbonBuildingController", tags = {"建筑碳排放相关操作"})
public class CarbonBuildingController {
    CarbonBuildingService carbonBuildingService;
    BuildingService buildingService;
    ExportService exportService;

    @Autowired
    public void setExportService(ExportService exportService) {
        this.exportService = exportService;
    }

    @Autowired
    public void setBuildingService(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @Autowired
    public void setCarbonBuildingService(CarbonBuildingService carbonBuildingService) {
        this.carbonBuildingService = carbonBuildingService;
    }

    @ApiOperation("给对应建筑添加信息")
    @PostMapping("/building/{buildingId}")
    public CommonResult<?> addCarbonInfo(@PathVariable("buildingId") Long buildingId, @RequestBody @Validated CarbonInfoParam carbonInfoParam) {
        boolean addResult = carbonBuildingService.postCarbonInfo(buildingId, carbonInfoParam.getKey(), carbonInfoParam);
        if (addResult) {
            return CommonResult.success(null, "添加信息成功");
        } else {
            return CommonResult.failed("添加信息失败");
        }
    }

    @ApiOperation("统计区域最近碳排放量")
    @GetMapping("/area/{areaId}")
    public CommonResult<CarbonBuildingComputedInfoPeriodAvg> getCarbonInfoByAreaId(@PathVariable("areaId") Long areaId, @RequestParam int periodType) {
        return CommonResult.success(carbonBuildingService.getCarbonInfoByAreaId(areaId, PeriodType.getType(periodType)));
    }

    @ApiOperation("根据区域ID获取碳排放量信息序列(当年)")
    @GetMapping("/area/{areaId}/list/year")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedTotalListByYear(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedTotalListByYear(areaId));
    }

    @ApiOperation("根据区域ID获取碳排放量信息序列(所有)")
    @GetMapping("/area/{areaId}/list/all")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedTotalListByAll(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedTotalListByAll(areaId));
    }

    @ApiOperation("根据区域ID获取碳排放量信息序列(当月)")
    @GetMapping("/area/{areaId}/list/month")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedTotalListByMonth(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedTotalListByMonth(areaId));
    }

    @ApiOperation("根据区域ID获取碳排放量信息序列(当季)")
    @GetMapping("/area/{areaId}/list/season")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedTotalListBySeason(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedTotalListBySeason(areaId));
    }

    @ApiOperation("根据区域ID获取碳排放量信息序列(当周)")
    @GetMapping("/area/{areaId}/list/week")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedTotalListByWeek(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedTotalListByWeek(areaId));
    }

    @ApiOperation("根据区域ID获取碳排放量信息序列(当天)")
    @GetMapping("/area/{areaId}/list/today")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedTotalListByDay(@PathVariable("areaId") Long areaId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedTotalListByDay(areaId));
    }

    @ApiOperation("根据区域ID获取碳排放量信息序列(范围)")
    @GetMapping("/area/{areaId}/list/range")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>>  getCarbonBuildingComputedTotalList(@PathVariable("areaId") Long areaId,
                                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam("startDate") Date startDate,
                                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam("endDate") Date endDate) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedTotalList(areaId, startDate, endDate));
    }

    @ApiOperation("统计建筑最近碳排放量")
    @GetMapping("/building/{buildingId}")
    public CommonResult<CarbonBuildingComputedInfoPeriodAvg> getCarbonInfoByBuildingId(@PathVariable("buildingId") Long buildingId, @RequestParam int periodType) {
        return CommonResult.success(carbonBuildingService.getCarbonInfoByBuildingId(buildingId, PeriodType.getType(periodType)));
    }

    @ApiOperation("根据建筑ID获取碳排放量信息序列(当年)")
    @GetMapping("/building/{buildingId}/list/year")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedByBuildingIdByYear(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedByBuildingIdByYear(buildingId));
    }

    @ApiOperation("根据建筑ID获取碳排放量信息序列(所有)")
    @GetMapping("/building/{buildingId}/list/all")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedByBuildingIdByAll(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedByBuildingIdByAll(buildingId));
    }

    @ApiOperation("根据建筑ID获取碳排放量信息序列(当月)")
    @GetMapping("/building/{buildingId}/list/month")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedByBuildingIdByMonth(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedByBuildingIdByMonth(buildingId));
    }

    @ApiOperation("根据建筑ID获取碳排放量信息序列(当季)")
    @GetMapping("/building/{buildingId}/list/season")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedByBuildingIdBySeason(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedByBuildingIdBySeason(buildingId));
    }

    @ApiOperation("根据建筑ID获取碳排放量信息序列(当周)")
    @GetMapping("/building/{buildingId}/list/week")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedByBuildingIdByWeek(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedByBuildingIdByWeek(buildingId));
    }

    @ApiOperation("根据建筑ID获取碳排放量信息序列(当天)")
    @GetMapping("/building/{buildingId}/list/today")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedByBuildingIdByDay(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedByBuildingIdByDay(buildingId));
    }

    @ApiOperation("根据建筑ID获取碳排放量信息序列(范围)")
    @GetMapping("/building/{buildingId}/list/range")
    public CommonResult<List<CarbonBuildingComputedDetailedDate>> getCarbonBuildingComputedByBuildingId(@PathVariable("buildingId") Long buildingId,
                                                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam("startDate") Date startDate,
                                                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam("endDate") Date endDate) {
        return CommonResult.success(carbonBuildingService.getCarbonBuildingComputedByBuildingId(buildingId, startDate, endDate));
    }

    @ApiOperation("根据建筑id以Excel形式导出")
    @GetMapping("/building/{buildingId}/export")
    public void exportExcel(@PathVariable("buildingId") Long buildingId, HttpServletResponse httpServletResponse) throws IOException, ParseException {
        SXSSFWorkbook sxssfWorkbook = exportService.getCarbonBuildingComputedSheet(buildingId);
        Building building = buildingService.getBuilding(buildingId);
        // 下载导出
        String filename = building.getName() + " 碳排放检测数据";
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
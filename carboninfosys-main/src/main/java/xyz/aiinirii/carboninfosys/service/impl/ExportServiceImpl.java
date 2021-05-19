package xyz.aiinirii.carboninfosys.service.impl;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.model.CarbonBuilding;
import xyz.aiinirii.carboninfosys.model.CarbonBuildingComputed;
import xyz.aiinirii.carboninfosys.model.EnvironmentBuilding;
import xyz.aiinirii.carboninfosys.service.CarbonBuildingService;
import xyz.aiinirii.carboninfosys.service.EnvironmentService;
import xyz.aiinirii.carboninfosys.service.ExportService;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author AIINIRII
 */
@Service
public class ExportServiceImpl implements ExportService {

    CarbonBuildingService carbonBuildingService;
    EnvironmentService environmentService;

    @Autowired
    public void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @Autowired
    public void setCarbonBuildingService(CarbonBuildingService carbonBuildingService) {
        this.carbonBuildingService = carbonBuildingService;
    }

    @Override
    public SXSSFWorkbook getCarbonBuildingSheet(Long buildingId) {
        //创建poi导出数据对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
        createBuildingSheet(buildingId, sxssfWorkbook);
        return sxssfWorkbook;
    }

    private void createBuildingSheet(Long buildingId, SXSSFWorkbook sxssfWorkbook) {
        List<CarbonBuilding> carbonBuildings = carbonBuildingService.getCarbonBuildingByBuildingIdForExport(buildingId);
        //创建sheet页
        SXSSFSheet sheet = sxssfWorkbook.createSheet("能耗监测");
        //创建表头
        SXSSFRow headRow = sheet.createRow(0);
        //设置表头信息
        headRow.createCell(0).setCellValue("序号");
        headRow.createCell(1).setCellValue("时间");
        headRow.createCell(2).setCellValue("空调用电（kw）");
        headRow.createCell(3).setCellValue("照明插座用电（kw）");
        headRow.createCell(4).setCellValue("动力用电（kw）");
        headRow.createCell(5).setCellValue("特殊用电（kw）");
        headRow.createCell(6).setCellValue("供暖用气量（m³/h）");
        headRow.createCell(7).setCellValue("厨房用气量（m³/h）");
        headRow.createCell(8).setCellValue("总排水量（m³/h）");
        headRow.createCell(9).setCellValue("总供水量（m³/h）");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 遍历上面数据库查到的数据
        for (CarbonBuilding carbonBuilding : carbonBuildings) {
            SXSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(carbonBuilding.getId());
            dataRow.createCell(1).setCellValue(simpleDateFormat.format(carbonBuilding.getCreateTime()));
            dataRow.createCell(2).setCellValue(String.format("%.2f", carbonBuilding.getElAirCondition()));
            dataRow.createCell(3).setCellValue(String.format("%.2f", carbonBuilding.getElLight()));
            dataRow.createCell(4).setCellValue(String.format("%.2f", carbonBuilding.getElMotion()));
            dataRow.createCell(5).setCellValue(String.format("%.2f", carbonBuilding.getElSpecial()));
            dataRow.createCell(6).setCellValue(String.format("%.2f", carbonBuilding.getMeHeating()));
            dataRow.createCell(7).setCellValue(String.format("%.2f", carbonBuilding.getMeKitchen()));
            dataRow.createCell(8).setCellValue(String.format("%.2f", carbonBuilding.getWaDrain()));
            dataRow.createCell(9).setCellValue(String.format("%.2f", carbonBuilding.getWaSupply()));
        }
    }

    @Override
    public SXSSFWorkbook getCarbonBuildingComputedSheet(Long buildingId) {
        //创建poi导出数据对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
        createBuildingComputedSheet(buildingId, sxssfWorkbook);
        return sxssfWorkbook;
    }

    private void createBuildingComputedSheet(Long buildingId, SXSSFWorkbook sxssfWorkbook) {
        List<CarbonBuildingComputed> carbonBuildings = carbonBuildingService.getCarbonBuildingComputedByBuildingIdForExport(buildingId);
        //创建sheet页
        SXSSFSheet sheet = sxssfWorkbook.createSheet("碳排放监测");
        //创建表头
        SXSSFRow headRow = sheet.createRow(0);
        //设置表头信息
        headRow.createCell(0).setCellValue("序号");
        headRow.createCell(1).setCellValue("时间");
        headRow.createCell(2).setCellValue("空调用电碳排放量（kgCO₂/h）");
        headRow.createCell(3).setCellValue("照明插座用电排放量（kgCO₂/h）");
        headRow.createCell(4).setCellValue("动力用电碳排放量（kgCO₂/h）");
        headRow.createCell(5).setCellValue("特殊用电碳排放量（kgCO₂/h）");
        headRow.createCell(6).setCellValue("供暖用气碳排放量（kgCO₂/h）");
        headRow.createCell(7).setCellValue("厨房用气碳排放量（kgCO₂/h）");
        headRow.createCell(8).setCellValue("总排水碳排放量（kgCO₂/h）");
        headRow.createCell(9).setCellValue("总供水碳排放量（kgCO₂/h）");
        headRow.createCell(10).setCellValue("电力碳排放量（kgCO₂/h）");
        headRow.createCell(11).setCellValue("天然气碳排放量（kgCO₂/h）");
        headRow.createCell(12).setCellValue("水碳排放量（kgCO₂/h）");
        headRow.createCell(13).setCellValue("总碳排放量（kgCO₂/h）");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 遍历上面数据库查到的数据
        for (CarbonBuildingComputed carbonBuilding : carbonBuildings) {
            SXSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(carbonBuilding.getId());
            dataRow.createCell(1).setCellValue(simpleDateFormat.format(carbonBuilding.getCreateTime()));
            dataRow.createCell(2).setCellValue(String.format("%.2f", carbonBuilding.getElAirConditionComputed()));
            dataRow.createCell(3).setCellValue(String.format("%.2f", carbonBuilding.getElLightComputed()));
            dataRow.createCell(4).setCellValue(String.format("%.2f", carbonBuilding.getElMotionComputed()));
            dataRow.createCell(5).setCellValue(String.format("%.2f", carbonBuilding.getElSpecialComputed()));
            dataRow.createCell(6).setCellValue(String.format("%.2f", carbonBuilding.getMeHeatingComputed()));
            dataRow.createCell(7).setCellValue(String.format("%.2f", carbonBuilding.getMeKitchenComputed()));
            dataRow.createCell(8).setCellValue(String.format("%.2f", carbonBuilding.getWaDrainComputed()));
            dataRow.createCell(9).setCellValue(String.format("%.2f", carbonBuilding.getWaSupplyComputed()));
            dataRow.createCell(10).setCellValue(String.format("%.2f", carbonBuilding.getElTotalComputed()));
            dataRow.createCell(11).setCellValue(String.format("%.2f", carbonBuilding.getMeTotalComputed()));
            dataRow.createCell(12).setCellValue(String.format("%.2f", carbonBuilding.getWaTotalComputed()));
            dataRow.createCell(13).setCellValue(String.format("%.2f", carbonBuilding.getTotalComputed()));
        }
    }

    @Override
    public SXSSFWorkbook getEnvironmentBuildingSheet(Long buildingId) {
        //创建poi导出数据对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
        createEnvironmentBuildingSheet(buildingId, sxssfWorkbook);
        return sxssfWorkbook;
    }

    private void createEnvironmentBuildingSheet(Long buildingId, SXSSFWorkbook sxssfWorkbook) {
        List<EnvironmentBuilding> environmentBuildings = environmentService.getEnvironmentBuildingByBuildingIdForExport(buildingId);
        //创建sheet页
        SXSSFSheet sheet = sxssfWorkbook.createSheet("环境监测");
        //创建表头
        SXSSFRow headRow = sheet.createRow(0);
        //设置表头信息
        headRow.createCell(0).setCellValue("序号");
        headRow.createCell(1).setCellValue("时间");
        headRow.createCell(2).setCellValue("温度（℃）");
        headRow.createCell(3).setCellValue("湿度（%）");
        headRow.createCell(4).setCellValue("风速（m/s）");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 遍历上面数据库查到的数据
        for (EnvironmentBuilding environmentBuilding : environmentBuildings) {
            SXSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(environmentBuilding.getId());
            dataRow.createCell(1).setCellValue(simpleDateFormat.format(environmentBuilding.getCreateTime()));
            dataRow.createCell(2).setCellValue(String.format("%.2f", environmentBuilding.getTemperature()));
            dataRow.createCell(3).setCellValue(String.format("%.2f", environmentBuilding.getHumidity()));
            dataRow.createCell(4).setCellValue(String.format("%.2f", environmentBuilding.getWindSpeed()));
        }
    }

    @Override
    public SXSSFWorkbook getSheets(Long buildingId) {
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
        createBuildingComputedSheet(buildingId, sxssfWorkbook);
        createBuildingSheet(buildingId, sxssfWorkbook);
        createEnvironmentBuildingSheet(buildingId, sxssfWorkbook);
        return sxssfWorkbook;
    }
}
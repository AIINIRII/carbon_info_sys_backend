package xyz.aiinirii.carboninfosys.service;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * @author AIINIRII
 */
public interface ExportService {
    SXSSFWorkbook getCarbonBuildingSheet(Long buildingId);
    SXSSFWorkbook getCarbonBuildingComputedSheet(Long buildingId);
    SXSSFWorkbook getEnvironmentBuildingSheet(Long buildingId);
    SXSSFWorkbook getSheets(Long buildingId);
}

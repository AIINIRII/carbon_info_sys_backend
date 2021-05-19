package xyz.aiinirii.carboninfosys.service;

import org.springframework.transaction.annotation.Transactional;
import xyz.aiinirii.carboninfosys.domain.CarbonInfoParam;
import xyz.aiinirii.carboninfosys.domain.EnvironmentInfoParam;
import xyz.aiinirii.carboninfosys.enums.PeriodType;
import xyz.aiinirii.carboninfosys.model.*;

import java.util.List;

/**
 * @author AIINIRII
 */
public interface EnvironmentService {
    @Transactional
    boolean postEnvironmentInfo(Long buildingId, String key, EnvironmentInfoParam carbonInfoParam);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByYear(Long areaId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByAll(Long areaId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByMonth(Long areaId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListBySeason(Long areaId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByWeek(Long areaId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByDay(Long areaId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByYear(Long buildingId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByAll(Long buildingId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByMonth(Long buildingId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdBySeason(Long buildingId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByWeek(Long buildingId);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByDay(Long buildingId);

    List<EnvironmentBuilding> getEnvironmentBuildingByBuildingIdForExport(Long buildingId);
}

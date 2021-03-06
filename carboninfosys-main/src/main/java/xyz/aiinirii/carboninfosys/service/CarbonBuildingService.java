package xyz.aiinirii.carboninfosys.service;

import org.springframework.transaction.annotation.Transactional;
import xyz.aiinirii.carboninfosys.domain.CarbonInfoParam;
import xyz.aiinirii.carboninfosys.enums.PeriodType;
import xyz.aiinirii.carboninfosys.model.*;

import java.util.Date;
import java.util.List;

/**
 * @author AIINIRII
 */
public interface CarbonBuildingService {
    @Transactional
    boolean postCarbonInfo(Long buildingId, String key, CarbonInfoParam carbonInfoParam);

    CarbonBuildingComputedInfoPeriodAvg getCarbonInfoByAreaId(Long areaId, PeriodType periodType);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByYear(Long areaId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByMonth(Long areaId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListBySeason(Long areaId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByDay(Long areaId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByWeek(Long areaId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByAll(Long areaId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalList(Long areaId, Date startDate, Date endDate);

    List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByYear(Long areaId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByAll(Long areaId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByMonth(Long areaId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListBySeason(Long areaId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByWeek(Long areaId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByDay(Long areaId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingTotalList(Long areaId, Date startDate, Date endDate);

    CarbonBuildingComputedInfoPeriodAvg getCarbonInfoByBuildingId(Long buildingId, PeriodType type);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByYear(Long buildingId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByMonth(Long buildingId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdBySeason(Long buildingId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByDay(Long buildingId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByWeek(Long buildingId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByAll(Long buildingId);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingId(Long buildingId, Date startDate, Date endDate);

    List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByYear(Long buildingId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByAll(Long buildingId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByMonth(Long buildingId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdBySeason(Long buildingId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByWeek(Long buildingId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByDay(Long buildingId);

    List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingId(Long buildingId, Date startDate, Date endDate);

    List<CarbonBuilding> getCarbonBuildingByBuildingIdForExport(Long buildingId);

    List<CarbonBuildingComputed> getCarbonBuildingComputedByBuildingIdForExport(Long buildingId);


}

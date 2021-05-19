package xyz.aiinirii.carboninfosys.dao;

import xyz.aiinirii.carboninfosys.model.*;

import java.util.Date;
import java.util.List;


/**
 * @author AIINIRII
 */
public interface CarbonInfoPeriodDao {
    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedListByHours(Long areaId, Date from, Date to);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedListByDays(Long areaId, Date from, Date to);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedListByMonths(Long areaId, Date from, Date to);

    CarbonBuildingComputedInfoPeriodAvg getCarbonInfoPeriodsAVG(Long areaId, int periodId, Date now);

    List<CarbonBuildingDetailedDate> getCarbonBuildingListByHours(Long areaId, Date from, Date to);

    List<CarbonBuildingDetailedDate> getCarbonBuildingListByDays(Long areaId, Date from, Date to);

    List<CarbonBuildingDetailedDate> getCarbonBuildingListByMonths(Long areaId, Date from, Date to);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedListByBuildingIdByHours(Long buildingId, Date from, Date to);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedListByBuildingIdByDays(Long buildingId, Date from, Date to);

    List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedListByBuildingIdByMonths(Long buildingId, Date from, Date to);

    CarbonBuildingComputedInfoPeriodAvg getCarbonInfoPeriodsByBuildingIdAVG(Long buildingId, int periodId, Date now);

    List<CarbonBuildingDetailedDate> getCarbonBuildingListByBuildingIdByHours(Long buildingId, Date from, Date to);

    List<CarbonBuildingDetailedDate> getCarbonBuildingListByBuildingIdByDays(Long buildingId, Date from, Date to);

    List<CarbonBuildingDetailedDate> getCarbonBuildingListByBuildingIdByMonths(Long buildingId, Date from, Date to);
}

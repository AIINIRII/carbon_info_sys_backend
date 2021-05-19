package xyz.aiinirii.carboninfosys.dao;

import xyz.aiinirii.carboninfosys.model.EnvironmentBuildingDetailedDate;

import java.util.Date;
import java.util.List;


/**
 * @author AIINIRII
 */
public interface EnvironmentDao {
    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingListByHours(Long areaId, Date from, Date to);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingListByDays(Long areaId, Date from, Date to);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingListByMonths(Long areaId, Date from, Date to);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingListByBuildingIdByHours(Long buildingId, Date from, Date to);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingListByBuildingIdByDays(Long buildingId, Date from, Date to);

    List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingListByBuildingIdByMonths(Long buildingId, Date from, Date to);
}

package xyz.aiinirii.carboninfosys.service;

import org.springframework.transaction.annotation.Transactional;
import xyz.aiinirii.carboninfosys.domain.BuildingParam;
import xyz.aiinirii.carboninfosys.model.Building;

import java.util.List;

/**
 * @author AIINIRII
 */
public interface BuildingService {
    List<Building> getBuildings(Long areaId, Integer buildingGroupId);

    @Transactional
    String addBuilding(Long areaId, Integer buildingGroupId, BuildingParam buildingParam);

    @Transactional
    boolean deleteBuilding(Long buildingId);

    @Transactional
    boolean updateBuilding(Long buildingId, BuildingParam buildingParam);

    Building getBuilding(Long buildingId);
}

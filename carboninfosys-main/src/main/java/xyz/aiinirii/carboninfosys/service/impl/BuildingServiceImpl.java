package xyz.aiinirii.carboninfosys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.domain.BuildingParam;
import xyz.aiinirii.carboninfosys.mapper.BuildingMapper;
import xyz.aiinirii.carboninfosys.model.Building;
import xyz.aiinirii.carboninfosys.model.BuildingExample;
import xyz.aiinirii.carboninfosys.service.BuildingKeyService;
import xyz.aiinirii.carboninfosys.service.BuildingService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author AIINIRII
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    private BuildingMapper buildingMapper;
    private BuildingKeyService buildingKeyService;

    @Autowired
    public void setBuildingKeyService(BuildingKeyService buildingKeyService) {
        this.buildingKeyService = buildingKeyService;
    }

    @Resource
    public void setBuildingMapper(BuildingMapper buildingMapper) {
        this.buildingMapper = buildingMapper;
    }

    @Override
    public List<Building> getBuildings(Long areaId, Integer buildingGroupId) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria()
                .andAreaIdEqualTo(areaId)
                .andBgIdEqualTo(buildingGroupId);
        return buildingMapper.selectByExampleWithBLOBs(buildingExample);
    }

    @Override
    public String addBuilding(Long areaId, Integer buildingGroupId, BuildingParam buildingParam) {
        Building building = new Building();
        building.setName(buildingParam.getName());
        building.setAreaId(areaId);
        building.setBgId(buildingGroupId);
        building.setDescription(buildingParam.getDescription());
        buildingMapper.insert(building);
        return buildingKeyService.generateKey(building.getId());
    }

    @Override
    public boolean deleteBuilding(Long buildingId) {
        int deleteResult = buildingMapper.deleteByPrimaryKey(buildingId);
        return deleteResult == 1;
    }

    @Override
    public boolean updateBuilding(Long buildingId, BuildingParam buildingParam) {
        Building building = new Building();
        building.setId(buildingId);
        building.setDescription(buildingParam.getDescription());
        building.setName(buildingParam.getName());
        int result = buildingMapper.updateByPrimaryKeySelective(building);
        return result == 1;
    }

    @Override
    public Building getBuilding(Long buildingId) {
        return buildingMapper.selectByPrimaryKey(buildingId);
    }
}
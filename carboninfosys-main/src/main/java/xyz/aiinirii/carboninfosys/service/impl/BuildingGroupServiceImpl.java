package xyz.aiinirii.carboninfosys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.mapper.BuildingGroupMapper;
import xyz.aiinirii.carboninfosys.model.BuildingGroup;
import xyz.aiinirii.carboninfosys.model.BuildingGroupExample;
import xyz.aiinirii.carboninfosys.service.BuildingGroupService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author AIINIRII
 */
@Service
public class BuildingGroupServiceImpl implements BuildingGroupService {
    private BuildingGroupMapper buildingGroupMapper;

    @Resource
    public void setBuildingGroupMapper(BuildingGroupMapper buildingGroupMapper) {
        this.buildingGroupMapper = buildingGroupMapper;
    }

    @Override
    public List<BuildingGroup> getAllBuildingGroups() {
        return buildingGroupMapper.selectByExample(new BuildingGroupExample());
    }
}
package xyz.aiinirii.carboninfosys.service.impl;

import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.mapper.BuildingKeyMapper;
import xyz.aiinirii.carboninfosys.model.BuildingKey;
import xyz.aiinirii.carboninfosys.model.BuildingKeyExample;
import xyz.aiinirii.carboninfosys.service.BuildingKeyService;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author AIINIRII
 */
@Service
public class BuildingKeyServiceImpl implements BuildingKeyService {
    private BuildingKeyMapper buildingKeyMapper;

    @Resource
    public void setBuildingKeyMapper(BuildingKeyMapper buildingKeyMapper) {
        this.buildingKeyMapper = buildingKeyMapper;
    }

    @Override
    public String getBuildingKey(Long buildingId) {
        BuildingKeyExample buildingKeyExample = new BuildingKeyExample();
        buildingKeyExample.createCriteria().andBuildingIdEqualTo(buildingId);
        List<BuildingKey> buildingKeys = buildingKeyMapper.selectByExample(buildingKeyExample);
        BuildingKey buildingKey = buildingKeys.get(0);
        return buildingKey.getbKey();
    }

    @Override
    public String generateKey(Long id) {
        String generatedKey = UUID.randomUUID().toString();
        BuildingKey buildingKey = new BuildingKey();
        buildingKey.setBuildingId(id);
        buildingKey.setbKey(generatedKey);
        buildingKeyMapper.insert(buildingKey);
        return generatedKey;
    }

    @Override
    public boolean validateKey(Long buildingId, String key) {
        BuildingKeyExample buildingKeyExample = new BuildingKeyExample();
        buildingKeyExample.createCriteria().andBuildingIdEqualTo(buildingId);
        List<BuildingKey> buildingKeys = buildingKeyMapper.selectByExample(buildingKeyExample);
        return buildingKeys.stream().anyMatch(buildingKey -> buildingKey.getbKey().equals(key));
    }
}
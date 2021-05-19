package xyz.aiinirii.carboninfosys.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.common.api.CommonPage;
import xyz.aiinirii.carboninfosys.domain.AreaParam;
import xyz.aiinirii.carboninfosys.mapper.AreaMapper;
import xyz.aiinirii.carboninfosys.model.Area;
import xyz.aiinirii.carboninfosys.model.AreaExample;
import xyz.aiinirii.carboninfosys.service.AreaService;

import javax.annotation.Resource;

/**
 * @author AIINIRII
 */
@Service
public class AreaServiceImpl implements AreaService {
    private AreaMapper areaMapper;

    @Resource
    public void setAreaMapper(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    @Override
    public boolean addArea(AreaParam areaParam) {
        Area insertArea = new Area();
        insertArea.setAreaname(areaParam.getAreaname());
        insertArea.setDescription(areaParam.getDescription());
        int insertResult = areaMapper.insert(insertArea);
        return insertResult == 1;
    }

    @Override
    public CommonPage<Area> getAreas(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return CommonPage.restPage(areaMapper.selectByExampleWithBLOBs(new AreaExample()));
    }

    @Override
    public boolean deleteAreaByAreaId(Long areaId) {
        int deleteResult = areaMapper.deleteByPrimaryKey(areaId);
        return deleteResult == 1;
    }

    @Override
    public boolean updateAreaByAreaId(Long areaId, AreaParam areaParam) {
        Area updateArea = areaMapper.selectByPrimaryKey(areaId);
        updateArea.setAreaname(areaParam.getAreaname());
        updateArea.setDescription(areaParam.getDescription());
        int updateResult = areaMapper.updateByPrimaryKeyWithBLOBs(updateArea);
        return updateResult == 1;
    }

    @Override
    public Area getAreaById(Long id) {
        return areaMapper.selectByPrimaryKey(id);
    }
}
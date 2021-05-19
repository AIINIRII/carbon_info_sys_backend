package xyz.aiinirii.carboninfosys.service;

import org.springframework.transaction.annotation.Transactional;
import xyz.aiinirii.carboninfosys.common.api.CommonPage;
import xyz.aiinirii.carboninfosys.domain.AreaParam;
import xyz.aiinirii.carboninfosys.model.Area;

/**
 * @author AIINIRII
 */
public interface AreaService {

    @Transactional
    boolean addArea(AreaParam areaParam);

    CommonPage<Area> getAreas(int pageNum, int pageSize);

    @Transactional
    boolean deleteAreaByAreaId(Long areaId);

    @Transactional
    boolean updateAreaByAreaId(Long areaId, AreaParam areaParam);

    Area getAreaById(Long id);
}
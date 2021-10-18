package xyz.aiinirii.carboninfosys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.common.api.ResultCode;
import xyz.aiinirii.carboninfosys.common.exception.Asserts;
import xyz.aiinirii.carboninfosys.dao.EnvironmentDao;
import xyz.aiinirii.carboninfosys.domain.EnvironmentInfoParam;
import xyz.aiinirii.carboninfosys.mapper.EnvironmentBuildingMapper;
import xyz.aiinirii.carboninfosys.model.EnvironmentBuilding;
import xyz.aiinirii.carboninfosys.model.EnvironmentBuildingDetailedDate;
import xyz.aiinirii.carboninfosys.model.EnvironmentBuildingExample;
import xyz.aiinirii.carboninfosys.service.BuildingKeyService;
import xyz.aiinirii.carboninfosys.service.EnvironmentService;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author AIINIRII
 */
@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    private EnvironmentBuildingMapper environmentBuildingMapper;
    private EnvironmentDao environmentDao;
    private BuildingKeyService buildingKeyService;

    @Resource
    public void setEnvironmentBuildingMapper(EnvironmentBuildingMapper environmentBuildingMapper) {
        this.environmentBuildingMapper = environmentBuildingMapper;
    }

    @Resource
    public void setEnvironmentDao(EnvironmentDao environmentDao) {
        this.environmentDao = environmentDao;
    }

    @Autowired
    public void setBuildingKeyService(BuildingKeyService buildingKeyService) {
        this.buildingKeyService = buildingKeyService;
    }


    @Override
    public boolean postEnvironmentInfo(Long buildingId, String key, EnvironmentInfoParam carbonInfoParam) {
        EnvironmentBuilding carbonBuilding = new EnvironmentBuilding();
        boolean validateResult = buildingKeyService.validateKey(buildingId, key);
        if (validateResult) {
            setEnvironmentInfo(buildingId, carbonInfoParam, carbonBuilding);
            environmentBuildingMapper.insert(carbonBuilding);
            return true;
        } else {
            Asserts.fail(ResultCode.FORBIDDEN);
            return false;
        }
    }

    private void setEnvironmentInfo(Long buildingId, EnvironmentInfoParam environmentInfoParam, EnvironmentBuilding environmentBuilding) {
        environmentBuilding.setBuildingId(buildingId);
        Date date = environmentInfoParam.getDate();
        if (date == null) {
            date = new Date();
        }
        environmentBuilding.setCreateTime(date);
        environmentBuilding.setHumidity(environmentInfoParam.getHumidity());
        environmentBuilding.setWindSpeed(environmentInfoParam.getWindSpeed());
        environmentBuilding.setTemperature(environmentInfoParam.getTemperature());
        environmentBuilding.setCo2(environmentInfoParam.getCo2());
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByAll(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -10);
        return environmentDao.getEnvironmentBuildingListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByYear(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -1);
        return environmentDao.getEnvironmentBuildingListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListBySeason(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -4);
        return environmentDao.getEnvironmentBuildingListByDays(areaId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByMonth(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -1);
        return environmentDao.getEnvironmentBuildingListByDays(areaId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByWeek(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -7);
        return environmentDao.getEnvironmentBuildingListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalListByDay(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        return environmentDao.getEnvironmentBuildingListByHours(areaId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingTotalList(Long areaId, Date startDate, Date endDate) {
        if (startDate.before(endDate)) {
            if (endDate.getTime() - startDate.getTime() < (1000 * 60 * 60 * 24 * 7)) {
                return environmentDao.getEnvironmentBuildingListByHours(areaId, startDate, endDate);
            } else if (endDate.getTime() - startDate.getTime() < (1000 * 60 * 60 * 24 * 365L)) {
                return environmentDao.getEnvironmentBuildingListByDays(areaId, startDate, endDate);
            } else {
                return environmentDao.getEnvironmentBuildingListByMonths(areaId, startDate, endDate);
            }
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByAll(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -10);
        return environmentDao.getEnvironmentBuildingListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByYear(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -1);
        return environmentDao.getEnvironmentBuildingListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdBySeason(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -4);
        return environmentDao.getEnvironmentBuildingListByBuildingIdByDays(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByMonth(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -1);
        return environmentDao.getEnvironmentBuildingListByBuildingIdByDays(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByWeek(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -7);
        return environmentDao.getEnvironmentBuildingListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingIdByDay(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        return environmentDao.getEnvironmentBuildingListByBuildingIdByHours(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<EnvironmentBuildingDetailedDate> getEnvironmentBuildingByBuildingId(Long buildingId, Date startDate, Date endDate) {
        if (startDate.before(endDate)) {
            if (endDate.getTime() - startDate.getTime() < (1000 * 60 * 60 * 24 * 7)) {
                return environmentDao.getEnvironmentBuildingListByBuildingIdByHours(buildingId, startDate, endDate);
            } else if (endDate.getTime() - startDate.getTime() < (1000 * 60 * 60 * 24 * 365L)) {
                return environmentDao.getEnvironmentBuildingListByBuildingIdByDays(buildingId, startDate, endDate);
            } else {
                return environmentDao.getEnvironmentBuildingListByBuildingIdByMonths(buildingId, startDate, endDate);
            }
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<EnvironmentBuilding> getEnvironmentBuildingByBuildingIdForExport(Long buildingId) {
        EnvironmentBuildingExample environmentBuildingExample = new EnvironmentBuildingExample();
        environmentBuildingExample.createCriteria().andBuildingIdEqualTo(buildingId);
        return environmentBuildingMapper.selectByExample(environmentBuildingExample);
    }
}
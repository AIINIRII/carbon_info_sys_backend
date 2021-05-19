package xyz.aiinirii.carboninfosys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.common.api.ResultCode;
import xyz.aiinirii.carboninfosys.common.exception.Asserts;
import xyz.aiinirii.carboninfosys.dao.CarbonInfoPeriodDao;
import xyz.aiinirii.carboninfosys.domain.CarbonInfoParam;
import xyz.aiinirii.carboninfosys.enums.PeriodType;
import xyz.aiinirii.carboninfosys.mapper.CarbonBuildingComputedMapper;
import xyz.aiinirii.carboninfosys.mapper.CarbonBuildingMapper;
import xyz.aiinirii.carboninfosys.model.*;
import xyz.aiinirii.carboninfosys.service.BuildingKeyService;
import xyz.aiinirii.carboninfosys.service.CarbonBuildingService;
import xyz.aiinirii.carboninfosys.util.CarbonInfoCalculateUtil;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author AIINIRII
 */
@Service
public class CarbonBuildingServiceImpl implements CarbonBuildingService {
    private CarbonBuildingMapper carbonBuildingMapper;
    private CarbonInfoPeriodDao carbonInfoPeriodDao;
    private CarbonBuildingComputedMapper carbonBuildingComputedMapper;
    private BuildingKeyService buildingKeyService;

    @Resource
    public void setCarbonBuildingComputedMapper(CarbonBuildingComputedMapper carbonBuildingComputedMapper) {
        this.carbonBuildingComputedMapper = carbonBuildingComputedMapper;
    }

    @Autowired
    public void setBuildingKeyService(BuildingKeyService buildingKeyService) {
        this.buildingKeyService = buildingKeyService;
    }

    @Resource
    public void setCarbonBuildingMapper(CarbonBuildingMapper carbonBuildingMapper) {
        this.carbonBuildingMapper = carbonBuildingMapper;
    }

    @Resource
    public void setCarbonInfoPeriodDao(CarbonInfoPeriodDao carbonInfoPeriodDao) {
        this.carbonInfoPeriodDao = carbonInfoPeriodDao;
    }

    @Override
    public boolean postCarbonInfo(Long buildingId, String key, CarbonInfoParam carbonInfoParam) {
        CarbonBuilding carbonBuilding = new CarbonBuilding();
        boolean validateResult = buildingKeyService.validateKey(buildingId, key);
        if (validateResult) {
            setCarbonInfo(buildingId, carbonInfoParam, carbonBuilding);
            carbonBuildingMapper.insert(carbonBuilding);
            setCarbonInfoComputed(carbonBuilding);
            return true;
        } else {
            Asserts.fail(ResultCode.FORBIDDEN);
            return false;
        }
    }

    private void setCarbonInfoComputed(CarbonBuilding carbonBuilding) {
        CarbonBuildingComputed carbonBuildingComputed = new CarbonBuildingComputed();
        carbonBuildingComputed.setCreateTime(carbonBuilding.getCreateTime());
        carbonBuildingComputed.setBuildingId(carbonBuilding.getBuildingId());
        carbonBuildingComputed.setElLightComputed(
                CarbonInfoCalculateUtil.computeEl(carbonBuilding.getElLight())
        );
        carbonBuildingComputed.setElAirConditionComputed(
                CarbonInfoCalculateUtil.computeEl(carbonBuilding.getElAirCondition())
        );
        carbonBuildingComputed.setElMotionComputed(
                CarbonInfoCalculateUtil.computeEl(carbonBuilding.getElMotion())
        );
        carbonBuildingComputed.setElSpecialComputed(
                CarbonInfoCalculateUtil.computeEl(carbonBuilding.getElSpecial())
        );
        carbonBuildingComputed.setWaSupplyComputed(
                CarbonInfoCalculateUtil.computeWaSupply(carbonBuilding.getWaSupply())
        );
        carbonBuildingComputed.setWaDrainComputed(
                CarbonInfoCalculateUtil.computeWaDrain(carbonBuilding.getWaDrain())
        );
        carbonBuildingComputed.setMeKitchenComputed(
                CarbonInfoCalculateUtil.computeMe(carbonBuilding.getMeKitchen())
        );
        carbonBuildingComputed.setMeHeatingComputed(
                CarbonInfoCalculateUtil.computeMe(carbonBuilding.getMeHeating())
        );
        carbonBuildingComputed.setElTotalComputed(
                carbonBuildingComputed.getElLightComputed()
                        .add(carbonBuildingComputed.getElAirConditionComputed())
                        .add(carbonBuildingComputed.getElMotionComputed())
                        .add(carbonBuildingComputed.getElSpecialComputed())
        );
        carbonBuildingComputed.setWaTotalComputed(
                carbonBuildingComputed.getWaSupplyComputed()
                        .add(carbonBuildingComputed.getWaDrainComputed())
        );
        carbonBuildingComputed.setMeTotalComputed(
                carbonBuildingComputed.getMeHeatingComputed()
                        .add(carbonBuildingComputed.getMeKitchenComputed())
        );
        carbonBuildingComputed.setTotalComputed(
                carbonBuildingComputed.getElTotalComputed()
                        .add(carbonBuildingComputed.getWaTotalComputed())
                        .add(carbonBuildingComputed.getMeTotalComputed())
        );
        carbonBuildingComputedMapper.insert(carbonBuildingComputed);
    }

    private void setCarbonInfo(Long buildingId, CarbonInfoParam carbonInfoParam, CarbonBuilding carbonBuilding) {
        carbonBuilding.setBuildingId(buildingId);
        Date date = carbonInfoParam.getDate();
        if (date == null) date = new Date();
        carbonBuilding.setCreateTime(date);
        carbonBuilding.setElLight(carbonInfoParam.getElLight());
        carbonBuilding.setElAirCondition(carbonInfoParam.getElAirCondition());
        carbonBuilding.setElMotion(carbonInfoParam.getElMotion());
        carbonBuilding.setElSpecial(carbonInfoParam.getElSpecial());
        carbonBuilding.setWaSupply(carbonInfoParam.getWaSupply());
        carbonBuilding.setWaDrain(carbonInfoParam.getWaDrain());
        carbonBuilding.setMeKitchen(carbonInfoParam.getMeKitchen());
        carbonBuilding.setMeHeating(carbonInfoParam.getMeHeating());
    }

    @Override
    public CarbonBuildingComputedInfoPeriodAvg getCarbonInfoByAreaId(Long areaId, PeriodType periodType) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria().andAreaIdEqualTo(areaId);
        return carbonInfoPeriodDao.getCarbonInfoPeriodsAVG(areaId, periodType.getVal(), new Date());
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByAll(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -10);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByYear(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -1);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListBySeason(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -4);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByDays(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByMonth(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -1);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByDays(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByWeek(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -7);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedTotalListByDay(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByHours(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByAll(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -10);
        return carbonInfoPeriodDao.getCarbonBuildingListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByYear(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -1);
        return carbonInfoPeriodDao.getCarbonBuildingListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListBySeason(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -4);
        return carbonInfoPeriodDao.getCarbonBuildingListByDays(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByMonth(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -1);
        return carbonInfoPeriodDao.getCarbonBuildingListByDays(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByWeek(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -7);
        return carbonInfoPeriodDao.getCarbonBuildingListByMonths(areaId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingTotalListByDay(Long areaId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        return carbonInfoPeriodDao.getCarbonBuildingListByHours(areaId, calendar.getTime(), now);
    }

    @Override
    public CarbonBuildingComputedInfoPeriodAvg getCarbonInfoByBuildingId(Long buildingId, PeriodType periodType) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria().andIdEqualTo(buildingId);
        return carbonInfoPeriodDao.getCarbonInfoPeriodsByBuildingIdAVG(buildingId, periodType.getVal(), new Date());
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByAll(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -10);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByYear(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -1);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdBySeason(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -4);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByBuildingIdByDays(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByMonth(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -1);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByBuildingIdByDays(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByWeek(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -7);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingComputedDetailedDate> getCarbonBuildingComputedByBuildingIdByDay(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        return carbonInfoPeriodDao.getCarbonBuildingComputedListByBuildingIdByHours(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByAll(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -10);
        return carbonInfoPeriodDao.getCarbonBuildingListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByYear(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, -1);
        return carbonInfoPeriodDao.getCarbonBuildingListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdBySeason(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -4);
        return carbonInfoPeriodDao.getCarbonBuildingListByBuildingIdByDays(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByMonth(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, -1);
        return carbonInfoPeriodDao.getCarbonBuildingListByBuildingIdByDays(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByWeek(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -7);
        return carbonInfoPeriodDao.getCarbonBuildingListByBuildingIdByMonths(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuildingDetailedDate> getCarbonBuildingByBuildingIdByDay(Long buildingId) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        return carbonInfoPeriodDao.getCarbonBuildingListByBuildingIdByHours(buildingId, calendar.getTime(), now);
    }

    @Override
    public List<CarbonBuilding> getCarbonBuildingByBuildingIdForExport(Long buildingId) {
        CarbonBuildingExample carbonBuildingExample = new CarbonBuildingExample();
        carbonBuildingExample.createCriteria().andBuildingIdEqualTo(buildingId);
        return carbonBuildingMapper.selectByExample(carbonBuildingExample);
    }

    @Override
    public List<CarbonBuildingComputed> getCarbonBuildingComputedByBuildingIdForExport(Long buildingId) {
        CarbonBuildingComputedExample carbonBuildingComputedExample = new CarbonBuildingComputedExample();
        carbonBuildingComputedExample.createCriteria().andBuildingIdEqualTo(buildingId);
        return carbonBuildingComputedMapper.selectByExample(carbonBuildingComputedExample);
    }
}
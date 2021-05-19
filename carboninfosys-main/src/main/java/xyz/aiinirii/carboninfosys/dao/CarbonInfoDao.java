package xyz.aiinirii.carboninfosys.dao;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author AIINIRII
 */
public interface CarbonInfoDao {
    BigDecimal getElLightAnnuallyAVG(Date endTime, Long id);

    BigDecimal getElAirConditionAnnuallyAVG(Date endTime, Long id);

    BigDecimal getElMotionAnnuallyAVG(Date endTime, Long id);

    BigDecimal getElSpecialAnnuallyAVG(Date endTime, Long id);

    BigDecimal getWaSupplyAnnuallyAVG(Date endTime, Long id);

    BigDecimal getWaDrainAnnuallyAVG(Date endTime, Long id);

    BigDecimal getMeKitchenAnnuallyAVG(Date endTime, Long id);

    BigDecimal getMeHeatingAnnuallyAVG(Date endTime, Long id);

    BigDecimal getElLightWeeklyAVG(Date endTime, Long id);

    BigDecimal getElAirConditionWeeklyAVG(Date endTime, Long id);

    BigDecimal getElMotionWeeklyAVG(Date endTime, Long id);

    BigDecimal getElSpecialWeeklyAVG(Date endTime, Long id);

    BigDecimal getWaSupplyWeeklyAVG(Date endTime, Long id);

    BigDecimal getWaDrainWeeklyAVG(Date endTime, Long id);

    BigDecimal getMeKitchenWeeklyAVG(Date endTime, Long id);

    BigDecimal getMeHeatingWeeklyAVG(Date endTime, Long id);

    BigDecimal getElLightMonthlyAVG(Date endTime, Long id);

    BigDecimal getElAirConditionMonthlyAVG(Date endTime, Long id);

    BigDecimal getElMotionMonthlyAVG(Date endTime, Long id);

    BigDecimal getElSpecialMonthlyAVG(Date endTime, Long id);

    BigDecimal getWaSupplyMonthlyAVG(Date endTime, Long id);

    BigDecimal getWaDrainMonthlyAVG(Date endTime, Long id);

    BigDecimal getMeKitchenMonthlyAVG(Date endTime, Long id);

    BigDecimal getMeHeatingMonthlyAVG(Date endTime, Long id);

    BigDecimal getElLightSeasonallyAVG(Date endTime, Long id);

    BigDecimal getElAirConditionSeasonallyAVG(Date endTime, Long id);

    BigDecimal getElMotionSeasonallyAVG(Date endTime, Long id);

    BigDecimal getElSpecialSeasonallyAVG(Date endTime, Long id);

    BigDecimal getWaSupplySeasonallyAVG(Date endTime, Long id);

    BigDecimal getWaDrainSeasonallyAVG(Date endTime, Long id);

    BigDecimal getMeKitchenSeasonallyAVG(Date endTime, Long id);

    BigDecimal getMeHeatingSeasonallyAVG(Date endTime, Long id);

    BigDecimal getElLightDailyAVG(Date endTime, Long id);

    BigDecimal getElAirConditionDailyAVG(Date endTime, Long id);

    BigDecimal getElMotionDailyAVG(Date endTime, Long id);

    BigDecimal getElSpecialDailyAVG(Date endTime, Long id);

    BigDecimal getWaSupplyDailyAVG(Date endTime, Long id);

    BigDecimal getWaDrainDailyAVG(Date endTime, Long id);

    BigDecimal getMeKitchenDailyAVG(Date endTime, Long id);

    BigDecimal getMeHeatingDailyAVG(Date endTime, Long id);

}

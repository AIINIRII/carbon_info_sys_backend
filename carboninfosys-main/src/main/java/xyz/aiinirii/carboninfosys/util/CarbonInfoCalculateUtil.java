package xyz.aiinirii.carboninfosys.util;

import java.math.BigDecimal;

/**
 * @author AIINIRII
 */
public class CarbonInfoCalculateUtil {

    private final static double POWER_CARBON_EMISSION_FACTOR = 0.968;
    // 自来水供应排放因子，参考值：0.35kgCO2/m³
    private final static double WATER_SUPPLY_EMISSION_FACTOR = 0.35;
    // 污水排放系数 0.8~0.9
    private final static double EFFLUENT_DISCHARGE_COEFFICIENT = 0.8;
    // 污水处理排放因子，参考值：0.44kgCO2/m³
    private final static double SEWAGE_TREATMENT_DISCHARGE_FACTOR = 0.44;
    // 天然气碳排放因子 2.18kgCO2/m³
    private final static double NATURAL_GAS_CARBON_EMISSION_FACTOR = 2.18;

    /**
     * 计算总用电碳排放量
     * @param elLight 光照用电量
     * @param elAircondition 空调用电量
     * @param elMotion 动力设备用电量
     * @param elSpecial 特殊用电量
     * @return 碳排放量
     */
    public static BigDecimal computeElTotal(BigDecimal elLight, BigDecimal elAircondition, BigDecimal elMotion, BigDecimal elSpecial) {
        return elLight.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR))
                .add(elAircondition.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR)))
                .add(elMotion.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR)))
                .add(elSpecial.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR)));
    }

    /**
     * 计算总用水碳排放量
     * @param waSupply 供水量
     * @param waDrain 污水量
     * @return 碳排放量
     */
    public static BigDecimal computeWaTotal(BigDecimal waSupply, BigDecimal waDrain) {
        return waSupply.multiply(BigDecimal.valueOf(WATER_SUPPLY_EMISSION_FACTOR))
                .add(waDrain.multiply(BigDecimal.valueOf(EFFLUENT_DISCHARGE_COEFFICIENT))
                        .multiply(BigDecimal.valueOf(SEWAGE_TREATMENT_DISCHARGE_FACTOR)));
    }

    /**
     * 计算总天然气碳排放量
     * @param meKitchen 厨房天然气量
     * @param meHeating 热天然气量
     * @return 碳排放量
     */
    public static BigDecimal computeMeTotal(BigDecimal meKitchen, BigDecimal meHeating) {
        return meKitchen.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR))
                .add(meHeating.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR)));
    }

    /**
     * 计算天然气碳排放子项
     * @param methane 天然气量
     * @return 碳排放量
     */
    public static BigDecimal computeMe(BigDecimal methane) {
        return methane.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR));
    }

    /**
     * 计算供水逐时碳排放
     * @param waSupply 供水量
     * @return 碳排放量
     */
    public static BigDecimal computeWaSupply(BigDecimal waSupply) {
        return waSupply.multiply(BigDecimal.valueOf(WATER_SUPPLY_EMISSION_FACTOR));
    }

    /**
     * 计算污水逐时碳排放
     * @param waDrain 污水量
     * @return 碳排放量
     */
    public static BigDecimal computeWaDrain(BigDecimal waDrain) {
        return waDrain.multiply(BigDecimal.valueOf(EFFLUENT_DISCHARGE_COEFFICIENT))
                .multiply(BigDecimal.valueOf(SEWAGE_TREATMENT_DISCHARGE_FACTOR));
    }

    /**
     * 计算用电逐时碳排放子项
     * @param electricity 用电量
     * @return 碳排放量
     */
    public static BigDecimal computeEl(BigDecimal electricity) {
        return electricity.multiply(BigDecimal.valueOf(POWER_CARBON_EMISSION_FACTOR));
    }


}
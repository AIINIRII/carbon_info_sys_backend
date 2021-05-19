package xyz.aiinirii.carboninfosys.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author AIINIRII
 */
@Data
public class CarbonBuildingComputedInfoPeriodAvg implements Serializable {
    private Long buildingId;

    private BigDecimal elLightComputed;

    private BigDecimal elAirConditionComputed;

    private BigDecimal elMotionComputed;

    private BigDecimal elSpecialComputed;

    private BigDecimal waSupplyComputed;

    private BigDecimal waDrainComputed;

    private BigDecimal meKitchenComputed;

    private BigDecimal meHeatingComputed;

    private BigDecimal elTotalComputed;

    private BigDecimal waTotalComputed;

    private BigDecimal meTotalComputed;

    private BigDecimal totalComputed;
}
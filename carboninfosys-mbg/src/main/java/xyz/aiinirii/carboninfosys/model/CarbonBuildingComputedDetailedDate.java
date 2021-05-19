package xyz.aiinirii.carboninfosys.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author AIINIRII
 */
@Data
public class CarbonBuildingComputedDetailedDate {

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer hour;

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
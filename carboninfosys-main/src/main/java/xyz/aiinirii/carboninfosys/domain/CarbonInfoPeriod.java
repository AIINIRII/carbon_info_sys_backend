package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import xyz.aiinirii.carboninfosys.enums.PeriodType;

import java.math.BigDecimal;

/**
 * @author AIINIRII
 */
@Data
public class CarbonInfoPeriod {
    private Long areaId;
    /**
     * DAILY(0), WEEKLY(1), MONTHLY(2), SEASONAL(3), ANNUAL(4);
     */
    @ApiModelProperty(value = "DAILY(0), WEEKLY(1), MONTHLY(2), SEASONAL(3), ANNUAL(4);")
    private PeriodType periodType;

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
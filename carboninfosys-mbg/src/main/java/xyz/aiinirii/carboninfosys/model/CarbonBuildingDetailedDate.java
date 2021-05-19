package xyz.aiinirii.carboninfosys.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author AIINIRII
 */
@Data
public class CarbonBuildingDetailedDate implements Serializable {

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer hour;

    private BigDecimal elLight;

    private BigDecimal elAirCondition;

    private BigDecimal elMotion;

    private BigDecimal elSpecial;

    private BigDecimal waSupply;

    private BigDecimal waDrain;

    private BigDecimal meKitchen;

    private BigDecimal meHeating;
}
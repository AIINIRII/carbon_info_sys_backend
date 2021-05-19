package xyz.aiinirii.carboninfosys.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author AIINIRII
 */
@Data
public class EnvironmentBuildingDetailedDate implements Serializable {

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer hour;

    private BigDecimal temperature;

    private BigDecimal humidity;

    private BigDecimal windSpeed;

    private BigDecimal co2;
}
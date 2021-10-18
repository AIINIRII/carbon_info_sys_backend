package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author AIINIRII
 */
@Data
public class EnvironmentInfoParam {

    private String key;

    private BigDecimal temperature;

    private BigDecimal humidity;

    private BigDecimal windSpeed;

    private BigDecimal co2;

//    private BigDecimal pm25;

    @ApiModelProperty(value = "日期")
    private Date date;
}
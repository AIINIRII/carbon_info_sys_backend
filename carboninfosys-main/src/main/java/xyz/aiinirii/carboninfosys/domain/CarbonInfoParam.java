package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author AIINIRII
 */
@Data
public class CarbonInfoParam {

    private String key;

    /**
     * 照明插座用电量
     */
    @ApiModelProperty(value = "照明插座用电量")
    private BigDecimal elLight;

    /**
     * 空调用电
     */
    @ApiModelProperty(value = "空调用电")
    private BigDecimal elAirCondition;

    /**
     * 动力用电
     */
    @ApiModelProperty(value = "动力用电")
    private BigDecimal elMotion;

    /**
     * 特殊用电
     */
    @ApiModelProperty(value = "特殊用电")
    private BigDecimal elSpecial;

    /**
     * 总供水量
     */
    @ApiModelProperty(value = "总供水量")
    private BigDecimal waSupply;

    /**
     * 总排水量
     */
    @ApiModelProperty(value = "总排水量")
    private BigDecimal waDrain;

    /**
     * 厨房用气量
     */
    @ApiModelProperty(value = "厨房用气量")
    private BigDecimal meKitchen;

    /**
     * 供暖用气量
     */
    @ApiModelProperty(value = "供暖用气量")
    private BigDecimal meHeating;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private Date date;
}
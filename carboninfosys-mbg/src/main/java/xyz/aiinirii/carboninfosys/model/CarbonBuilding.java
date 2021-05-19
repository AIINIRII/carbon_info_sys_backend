package xyz.aiinirii.carboninfosys.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarbonBuilding implements Serializable {
    /**
     * 记录id
     */
    @ApiModelProperty(value = "记录id")
    private Long id;

    /**
     * 记录所属建筑id
     */
    @ApiModelProperty(value = "记录所属建筑id")
    private Long buildingId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

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

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getElLight() {
        return elLight;
    }

    public void setElLight(BigDecimal elLight) {
        this.elLight = elLight;
    }

    public BigDecimal getElAirCondition() {
        return elAirCondition;
    }

    public void setElAirCondition(BigDecimal elAirCondition) {
        this.elAirCondition = elAirCondition;
    }

    public BigDecimal getElMotion() {
        return elMotion;
    }

    public void setElMotion(BigDecimal elMotion) {
        this.elMotion = elMotion;
    }

    public BigDecimal getElSpecial() {
        return elSpecial;
    }

    public void setElSpecial(BigDecimal elSpecial) {
        this.elSpecial = elSpecial;
    }

    public BigDecimal getWaSupply() {
        return waSupply;
    }

    public void setWaSupply(BigDecimal waSupply) {
        this.waSupply = waSupply;
    }

    public BigDecimal getWaDrain() {
        return waDrain;
    }

    public void setWaDrain(BigDecimal waDrain) {
        this.waDrain = waDrain;
    }

    public BigDecimal getMeKitchen() {
        return meKitchen;
    }

    public void setMeKitchen(BigDecimal meKitchen) {
        this.meKitchen = meKitchen;
    }

    public BigDecimal getMeHeating() {
        return meHeating;
    }

    public void setMeHeating(BigDecimal meHeating) {
        this.meHeating = meHeating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", createTime=").append(createTime);
        sb.append(", elLight=").append(elLight);
        sb.append(", elAirCondition=").append(elAirCondition);
        sb.append(", elMotion=").append(elMotion);
        sb.append(", elSpecial=").append(elSpecial);
        sb.append(", waSupply=").append(waSupply);
        sb.append(", waDrain=").append(waDrain);
        sb.append(", meKitchen=").append(meKitchen);
        sb.append(", meHeating=").append(meHeating);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package xyz.aiinirii.carboninfosys.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarbonBuildingComputed implements Serializable {
    private Long id;

    private Date createTime;

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

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public BigDecimal getElLightComputed() {
        return elLightComputed;
    }

    public void setElLightComputed(BigDecimal elLightComputed) {
        this.elLightComputed = elLightComputed;
    }

    public BigDecimal getElAirConditionComputed() {
        return elAirConditionComputed;
    }

    public void setElAirConditionComputed(BigDecimal elAirConditionComputed) {
        this.elAirConditionComputed = elAirConditionComputed;
    }

    public BigDecimal getElMotionComputed() {
        return elMotionComputed;
    }

    public void setElMotionComputed(BigDecimal elMotionComputed) {
        this.elMotionComputed = elMotionComputed;
    }

    public BigDecimal getElSpecialComputed() {
        return elSpecialComputed;
    }

    public void setElSpecialComputed(BigDecimal elSpecialComputed) {
        this.elSpecialComputed = elSpecialComputed;
    }

    public BigDecimal getWaSupplyComputed() {
        return waSupplyComputed;
    }

    public void setWaSupplyComputed(BigDecimal waSupplyComputed) {
        this.waSupplyComputed = waSupplyComputed;
    }

    public BigDecimal getWaDrainComputed() {
        return waDrainComputed;
    }

    public void setWaDrainComputed(BigDecimal waDrainComputed) {
        this.waDrainComputed = waDrainComputed;
    }

    public BigDecimal getMeKitchenComputed() {
        return meKitchenComputed;
    }

    public void setMeKitchenComputed(BigDecimal meKitchenComputed) {
        this.meKitchenComputed = meKitchenComputed;
    }

    public BigDecimal getMeHeatingComputed() {
        return meHeatingComputed;
    }

    public void setMeHeatingComputed(BigDecimal meHeatingComputed) {
        this.meHeatingComputed = meHeatingComputed;
    }

    public BigDecimal getElTotalComputed() {
        return elTotalComputed;
    }

    public void setElTotalComputed(BigDecimal elTotalComputed) {
        this.elTotalComputed = elTotalComputed;
    }

    public BigDecimal getWaTotalComputed() {
        return waTotalComputed;
    }

    public void setWaTotalComputed(BigDecimal waTotalComputed) {
        this.waTotalComputed = waTotalComputed;
    }

    public BigDecimal getMeTotalComputed() {
        return meTotalComputed;
    }

    public void setMeTotalComputed(BigDecimal meTotalComputed) {
        this.meTotalComputed = meTotalComputed;
    }

    public BigDecimal getTotalComputed() {
        return totalComputed;
    }

    public void setTotalComputed(BigDecimal totalComputed) {
        this.totalComputed = totalComputed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", elLightComputed=").append(elLightComputed);
        sb.append(", elAirConditionComputed=").append(elAirConditionComputed);
        sb.append(", elMotionComputed=").append(elMotionComputed);
        sb.append(", elSpecialComputed=").append(elSpecialComputed);
        sb.append(", waSupplyComputed=").append(waSupplyComputed);
        sb.append(", waDrainComputed=").append(waDrainComputed);
        sb.append(", meKitchenComputed=").append(meKitchenComputed);
        sb.append(", meHeatingComputed=").append(meHeatingComputed);
        sb.append(", elTotalComputed=").append(elTotalComputed);
        sb.append(", waTotalComputed=").append(waTotalComputed);
        sb.append(", meTotalComputed=").append(meTotalComputed);
        sb.append(", totalComputed=").append(totalComputed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
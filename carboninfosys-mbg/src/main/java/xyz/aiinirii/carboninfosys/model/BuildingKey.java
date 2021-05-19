package xyz.aiinirii.carboninfosys.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class BuildingKey implements Serializable {
    private Long id;

    private Long buildingId;

    private String bKey;

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

    public String getbKey() {
        return bKey;
    }

    public void setbKey(String bKey) {
        this.bKey = bKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", bKey=").append(bKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
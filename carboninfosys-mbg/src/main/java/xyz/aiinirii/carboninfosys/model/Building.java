package xyz.aiinirii.carboninfosys.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Building implements Serializable {
    /**
     * 建筑id
     */
    @ApiModelProperty(value = "建筑id")
    private Long id;

    /**
     * 建筑名称，不超过64
     */
    @ApiModelProperty(value = "建筑名称，不超过64")
    private String name;

    /**
     * 所在区域id
     */
    @ApiModelProperty(value = "所在区域id")
    private Long areaId;

    /**
     * 所属建筑群id
     */
    @ApiModelProperty(value = "所属建筑群id")
    private Integer bgId;

    /**
     * 建筑描述
     */
    @ApiModelProperty(value = "建筑描述")
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Integer getBgId() {
        return bgId;
    }

    public void setBgId(Integer bgId) {
        this.bgId = bgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", areaId=").append(areaId);
        sb.append(", bgId=").append(bgId);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
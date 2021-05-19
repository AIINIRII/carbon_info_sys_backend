package xyz.aiinirii.carboninfosys.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Area implements Serializable {
    /**
     * 地区id
     */
    @ApiModelProperty(value = "地区id")
    private Long id;

    /**
     * 地区名称，64位以内
     */
    @ApiModelProperty(value = "地区名称，64位以内")
    private String areaname;

    /**
     * 描述，文本
     */
    @ApiModelProperty(value = "描述，文本")
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
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
        sb.append(", areaname=").append(areaname);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
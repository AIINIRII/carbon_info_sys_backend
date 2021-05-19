package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author AIINIRII
 */
@Data
public class BuildingParam {

    /**
     * 建筑名称，不超过64
     */
    @ApiModelProperty(value = "建筑名称，不超过64")
    @NotEmpty(message = "建筑名称不能为空")
    private String name;

    /**
     * 建筑描述
     */
    @ApiModelProperty(value = "建筑描述")
    private String description;
}
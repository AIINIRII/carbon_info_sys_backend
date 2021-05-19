package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author AIINIRII
 */
@Data
public class AreaParam {
    /**
     * 地区名称，64位以内
     */
    @Size(max = 64)
    @NotEmpty
    @ApiModelProperty(value = "地区名称，64位以内")
    private String areaname;

    /**
     * 描述，文本
     */
    @ApiModelProperty(value = "描述，文本")
    private String description;
}
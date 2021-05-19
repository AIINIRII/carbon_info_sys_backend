package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
/**
 * 用户登录封装数据
 *
 * @author AIINIRII
 */
@Data
public class UserLoginParam {

    @ApiModelProperty(value = "用户名（不超过64位）", required = true)
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 64, message = "用户名长度不能超过64")
    private String username;

    @ApiModelProperty(value = "密码（不超过128位）", required = true)
    @NotEmpty(message = "密码不能为空")
    @Size(max = 128, message = "密码长度不能超过128")
    private String password;
}
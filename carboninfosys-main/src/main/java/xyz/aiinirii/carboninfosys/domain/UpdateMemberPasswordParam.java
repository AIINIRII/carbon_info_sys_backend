package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author AIINIRII
 */
@Data
public class UpdateMemberPasswordParam {
    /**
     * 这个是每个用户的用户名user name. 数据类型为VARCHAR(64).\n注意用户名是唯一的unique,不允许重复.
     */
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 64, message = "用户名长度不能超过64")
    @ApiModelProperty(value = "用户名user name. 数据类型为VARCHAR(64).\n注意用户名是唯一的unique,不允许重复.")
    private String userName;

    /**
     * 这个是每个用户的登陆密码password. 数据类型VARCHAR(128).
     */
    @ApiModelProperty(value = "用户新的登陆密码password. 数据类型VARCHAR(128).")
    @NotEmpty(message = "密码不能为空")
    @Size(max = 128, message = "密码长度不能超过128")
    private String newPassword;

    /**
     * 这个是每个用户的登陆密码password. 数据类型VARCHAR(128).
     */
    @ApiModelProperty(value = "用户老的登陆密码password. 数据类型VARCHAR(128).")
    @NotEmpty(message = "密码不能为空")
    @Size(max = 128, message = "密码长度不能超过128")
    private String oldPassword;

}
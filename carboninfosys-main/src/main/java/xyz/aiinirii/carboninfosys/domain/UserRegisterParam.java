package xyz.aiinirii.carboninfosys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author AIINIRII
 */
@Data
public class UserRegisterParam {
    /**
     * 这个是每个用户的用户名user name. 数据类型为VARCHAR(64).\n注意用户名是唯一的unique,不允许重复.
     */
    @ApiModelProperty(value = "这个是每个用户的用户名user name. 数据类型为VARCHAR(64).\n注意用户名是唯一的unique,不允许重复.")
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 64, message = "用户名长度不能超过64")
    private String username;

    /**
     * 这个是每个用户的登陆密码password. 数据类型VARCHAR(128).
     */
    @ApiModelProperty(value = "这个是每个用户的登陆密码password. 数据类型VARCHAR(128).")
    @NotEmpty(message = "密码不能为空")
    @Size(max = 128, message = "密码长度不能超过128")
    private String password;

    /**
     * 这个是每个用户的注册邮箱email. 数据类型为VARCHAR(128).\n注意每个用户的注册邮箱是唯一的unique,不可以重复.
     */
    @ApiModelProperty(value = "这个是每个用户的注册邮箱email. 数据类型为VARCHAR(128).\n注意每个用户的注册邮箱是唯一的unique,不可以重复.")
    @Email(message = "请输入正确邮箱格式")
    @NotEmpty(message = "邮箱不能为空")
    @Size(max = 128, message = "邮箱长度不能超过128")
    private String email;
}
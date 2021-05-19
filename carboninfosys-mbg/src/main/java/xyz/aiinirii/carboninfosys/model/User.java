package xyz.aiinirii.carboninfosys.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long id;

    /**
     * 用户名，32位以内
     */
    @ApiModelProperty(value = "用户名，32位以内")
    private String username;

    /**
     * 密码，64位以内
     */
    @ApiModelProperty(value = "密码，64位以内")
    private String password;

    /**
     * 邮箱，255位以内
     */
    @ApiModelProperty(value = "邮箱，255位以内")
    private String email;

    /**
     * 创建的时间，默认为服务器时间
     */
    @ApiModelProperty(value = "创建的时间，默认为服务器时间")
    private Date createTime;

    /**
     * 0 -> 用户, 1 -> 管理员
     */
    @ApiModelProperty(value = "0 -> 用户, 1 -> 管理员")
    private Byte isAdmin;

    /**
     * 该用户是否开启
     */
    @ApiModelProperty(value = "该用户是否开启")
    private Byte isEnable;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", createTime=").append(createTime);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
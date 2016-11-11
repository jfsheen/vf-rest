package cc.aisc.business.model.auth;

import cc.aisc.commons.base.CommonModel;
import cc.aisc.commons.type.TypeEnums;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.*;

public class User extends CommonModel {

    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    @Length(min = 2, max = 64, message = "密码长度为2至64位")
    private String password;
    @NotNull(message = "昵称不能为空")
    private String nicename;

    private String mobile;

    /*
    * 十位：1=enable，0=disable
    * 个位：0=locked
    * */
    private TypeEnums status;

    private Date createAt;

    private Date lastLogin;

    private Date expiryAt;

    private Date restPswAt;

    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename == null ? null : nicename.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public TypeEnums getStatus() {
        return status;
    }

    public void setStatus(TypeEnums status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(Date expiryAt) {
        this.expiryAt = expiryAt;
    }

    public Date getRestPswAt() {
        return restPswAt;
    }

    public void setRestPswAt(Date restPswAt) {
        this.restPswAt = restPswAt;
    }
}
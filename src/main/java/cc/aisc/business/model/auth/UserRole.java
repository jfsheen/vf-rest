package cc.aisc.business.model.auth;

import cc.aisc.commons.base.CommonModel;

public class UserRole extends CommonModel {

    private User user;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
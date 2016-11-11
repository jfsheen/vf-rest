package cc.aisc.business.model.auth;

import cc.aisc.commons.base.CommonModel;

public class GroupRole extends CommonModel {

    private Group group;

    private Role role;

    public GroupRole() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
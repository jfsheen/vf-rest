package cc.aisc.business.model.auth;

import cc.aisc.commons.base.CommonModel;

public class UserGroup extends CommonModel {

    private User user;

    private Group group;

    public UserGroup() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
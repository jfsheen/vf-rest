package cc.aisc.business.model.auth;

import cc.aisc.commons.base.CommonModel;
import cc.aisc.commons.type.TypeEnums;
import cc.aisc.business.model.sys.Resource;

public class Permission extends CommonModel {
    private Role role;

    private Resource resource;

    private TypeEnums permType;

    private String description;

    public Permission() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public TypeEnums getPermType() {
        return permType;
    }

    public void setPermType(TypeEnums permType) {
        this.permType = permType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
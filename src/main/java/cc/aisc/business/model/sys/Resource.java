package cc.aisc.business.model.sys;

import cc.aisc.commons.base.CommonTreeNode;

public class Resource extends CommonTreeNode {

    private String name;

    private String funcPath;

    private String image;

    private Integer status;

    private String description;

    private Boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFuncPath() {
        return funcPath;
    }

    public void setFuncPath(String funcPath) {
        this.funcPath = funcPath == null ? null : funcPath.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
package cc.aisc.business.model.sys;

import cc.aisc.commons.base.BaseModelWithAudit;
import cc.aisc.commons.base.CommonTreeNode;
import cc.aisc.commons.type.TypeEnums;

import java.util.Date;

public class Category extends CommonTreeNode implements BaseModelWithAudit {

    private TypeEnums type;

    private String name;

    private String remark;

    private String createBy;

    private Date createAt;

    private String modifyBy;

    private Date modifyAt;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public TypeEnums getType() {
        return type;
    }

    public void setType(TypeEnums type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }
}
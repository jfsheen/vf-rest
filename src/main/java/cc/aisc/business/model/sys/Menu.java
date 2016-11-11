package cc.aisc.business.model.sys;

import cc.aisc.commons.base.BaseModelWithAudit;
import cc.aisc.commons.base.CommonTreeNode;
import cc.aisc.commons.type.TypeEnums;

import java.util.Date;

public class Menu extends CommonTreeNode implements BaseModelWithAudit {

    private TypeEnums status;

    private String sref;

    private String text;

    private String tooltip;

    private String icon;

    private Date createAt;

    private Date modifyAt;

    private String createBy;

    private String modifyBy;

    private String translate;

    public Menu() {
    }

    public TypeEnums getStatus() {
        return status;
    }

    public void setStatus(TypeEnums status) {
        this.status = status;
    }

    public String getSref() {
        return sref;
    }

    public void setSref(String sref) {
        this.sref = sref == null ? null : sref.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip == null ? null : tooltip.trim();
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate == null ? null : translate.trim();
    }
}
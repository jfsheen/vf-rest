package cc.aisc.business.model.sys;

import cc.aisc.commons.base.CommonTreeNode;

public class Vin extends CommonTreeNode{

    private String vin;       //VIN 1~8位

    private String description;

    public Vin() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }
}
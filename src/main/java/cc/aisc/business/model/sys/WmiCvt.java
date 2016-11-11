package cc.aisc.business.model.sys;

import cc.aisc.commons.base.CommonModel;

public class WmiCvt extends CommonModel {

    private String comName;

    private String wmi;

    private String vehBrand;

    private String comAddr;

    private String vehType;

    public WmiCvt() {
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public String getWmi() {
        return wmi;
    }

    public void setWmi(String wmi) {
        this.wmi = wmi == null ? null : wmi.trim();
    }

    public String getVehBrand() {
        return vehBrand;
    }

    public void setVehBrand(String vehBrand) {
        this.vehBrand = vehBrand == null ? null : vehBrand.trim();
    }

    public String getComAddr() {
        return comAddr;
    }

    public void setComAddr(String comAddr) {
        this.comAddr = comAddr == null ? null : comAddr.trim();
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType == null ? null : vehType.trim();
    }
}
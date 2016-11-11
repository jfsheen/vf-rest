package cc.aisc.business.model.sys;

import cc.aisc.commons.base.CommonModel;

import java.util.Date;

public class Wmi extends CommonModel{
    private String coNam;

    private String wmi;

    private String crfNo;

    private Date crfDate;

    public Wmi() {
    }

    public String getCoNam() {
        return coNam;
    }

    public void setCoNam(String coNam) {
        this.coNam = coNam;
    }

    public String getWmi() {
        return wmi;
    }

    public void setWmi(String wmi) {
        this.wmi = wmi == null ? null : wmi.trim();
    }

    public String getCrfNo() {
        return crfNo;
    }

    public void setCrfNo(String crfNo) {
        this.crfNo = crfNo == null ? null : crfNo.trim();
    }

    public Date getCrfDate() {
        return crfDate;
    }

    public void setCrfDate(Date crfDate) {
        this.crfDate = crfDate;
    }

}
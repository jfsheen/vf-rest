package cc.aisc.business.model.sys;

import cc.aisc.commons.base.CommonModel;

import java.util.Date;

/**
 * Created by sjf on 16-10-10.
 */
public class ScheduledJob extends CommonModel {

    private String jobNam;
    private String jobGrp;
    private String trgNam;
    private String trgGrp;
    private String cronExp;
    private String clsNam;
    private String mtdName;
    private Boolean isConcurrent;
    private String remark;
    private Date createAt;
    private Date modifyAt;

    public String getJobNam() {
        return jobNam;
    }

    public void setJobNam(String jobNam) {
        this.jobNam = jobNam;
    }

    public String getJobGrp() {
        return jobGrp;
    }

    public void setJobGrp(String jobGrp) {
        this.jobGrp = jobGrp;
    }

    public String getTrgNam() {
        return trgNam;
    }

    public void setTrgNam(String trgNam) {
        this.trgNam = trgNam;
    }

    public String getTrgGrp() {
        return trgGrp;
    }

    public void setTrgGrp(String trgGrp) {
        this.trgGrp = trgGrp;
    }

    public String getCronExp() {
        return cronExp;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    public String getClsNam() {
        return clsNam;
    }

    public void setClsNam(String clsNam) {
        this.clsNam = clsNam;
    }

    public String getMtdName() {
        return mtdName;
    }

    public void setMtdName(String mtdName) {
        this.mtdName = mtdName;
    }

    public Boolean getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(Boolean isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}

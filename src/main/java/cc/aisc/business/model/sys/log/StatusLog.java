package cc.aisc.business.model.sys.log;

import cc.aisc.commons.base.CommonModel;

public class StatusLog extends CommonModel {

    private String objId;

    private Integer stsCode;

    private Long stsTs;

    public StatusLog() {
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId == null ? null : objId.trim();
    }

    public Integer getStsCode() {
        return stsCode;
    }

    public void setStsCode(Integer stsCode) {
        this.stsCode = stsCode;
    }

    public Long getStsTs() {
        return stsTs;
    }

    public void setStsTs(Long stsTs) {
        this.stsTs = stsTs;
    }
}
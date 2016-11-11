package cc.aisc.business.model.sys.log;

import cc.aisc.commons.base.CommonModel;

public class OperationLog extends CommonModel {

    private String objId;

    private String usrId;

    private Long opTs;

    private OperationType opTp;

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId == null ? null : objId.trim();
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId == null ? null : usrId.trim();
    }

    public Long getOpTs() {
        return opTs;
    }

    public void setOpTs(Long opTs) {
        this.opTs = opTs;
    }

    public OperationType getOpTp() {
        return opTp;
    }

    public void setOpTp(OperationType opTp) {
        this.opTp = opTp;
    }
}
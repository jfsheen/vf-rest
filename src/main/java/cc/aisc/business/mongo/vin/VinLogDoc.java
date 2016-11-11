package cc.aisc.business.mongo.vin;

import javax.persistence.Id;

/**
 * Created by sjf on 16-11-9.
 */
public class VinLogDoc {
    @Id
    private String id;
    private long process;
    private String vin;
    private int errCode;
    private String reason;
    private Long ts;

    public VinLogDoc() {
    }

    public long getProcess() {
        return process;
    }

    public void setProcess(long process) {
        this.process = process;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }
}

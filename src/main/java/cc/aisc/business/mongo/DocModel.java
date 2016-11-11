package cc.aisc.business.mongo;

import javax.persistence.Id;
import java.util.HashMap;

/**
 * Created by sjf on 16-10-14.
 */
public class DocModel {

    @Id
    private String id;
    private Long ts;
    private Long createTs;
    private Long modifyTs;
    private String docName;
    private String docGroup;
    private HashMap<String, Object> docData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public Long getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Long createTs) {
        this.createTs = createTs;
    }

    public Long getModifyTs() {
        return modifyTs;
    }

    public void setModifyTs(Long modifyTs) {
        this.modifyTs = modifyTs;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocGroup() {
        return docGroup;
    }

    public void setDocGroup(String docGroup) {
        this.docGroup = docGroup;
    }

    public HashMap<String, Object> getDocData() {
        return docData;
    }

    public void setDocData(HashMap<String, Object> docData) {
        this.docData = docData;
    }
}

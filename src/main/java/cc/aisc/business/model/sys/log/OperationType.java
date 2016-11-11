package cc.aisc.business.model.sys.log;

import cc.aisc.commons.type.ValuedEnum;

/**
 * Created by sjf on 16-10-31.
 */
public enum OperationType implements ValuedEnum<OperationType>{

    CREATE(9901, "新建"),
    MODIFY(9902, "修改");

    private Integer code;
    private String description;

    OperationType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getIntValue() {
        return null;
    }
}

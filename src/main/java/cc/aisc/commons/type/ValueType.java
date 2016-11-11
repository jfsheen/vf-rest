package cc.aisc.commons.type;

/**
 * Created by sjf on 16-11-1.
 */
public enum ValueType implements ValuedEnum<ValueType> {
    INTEGER(9101,"整数"),
    BIGDECIMAL(9102,"小数"),
    LONG(9103,"长整数"),
    STRING(9104,"字符串"),
    BOOLEAN(9105,"是与否");

    private Integer code;
    private String description;

    ValueType(Integer code, String description) {
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
        return this.code;
    }
}

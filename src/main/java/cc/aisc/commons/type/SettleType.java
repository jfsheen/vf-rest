package cc.aisc.commons.type;

/**
 * Created by sjf on 16-10-18.
 */
public enum SettleType implements ValuedEnum<SettleType> {

    STT_CASH(9600,"现金结算"),
    STT_N1(9601,"N+1结算"),
    STT_N2(9602,"N+2结算"),
    STT_N3(9603,"N+3结算");

    private Integer code;
    private String description;

    SettleType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Integer getIntValue() {
        return this.code;
    }
}

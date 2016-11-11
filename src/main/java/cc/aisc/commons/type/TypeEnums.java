package cc.aisc.commons.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjf on 16-8-18.
 */
public enum TypeEnums implements ValuedEnum<TypeEnums> {

    UNKNOWN(0, "未知"),

    /*司机（人员），车辆状态*/
    AVAILABLE(10000001, "待令"),//包括本地和异地
    ONGOING(10000002, "任务中"),
    NOT_AVAILABLE(10000003,"不可用"),//维修保养，休假...
    RETIRED(10000004, "已退出"),//报废，退休...
    DISABLED(10000005, "已禁用"),//禁用，开除...
    DELETED(10000006, "已删除"),

    /*车辆 各部分 属性*/
    LIFT_1(10000111, "LIFT_1"),//提升
    LIFT_2(10000112, "LIFT_1"),
    LIFT_3(10000113, "LIFT_1"),
    LIFT_4(10000114, "LIFT_1"),
    LIFT_5(10000115, "LIFT_1"),
    TYRE_1(10000121, "TYRE_1"),//轮胎
    TYRE_2(10000122, "TYRE_1"),
    TYRE_3(10000123, "TYRE_1"),
    TYRE_4(10000124, "TYRE_1"),
    TYRE_5(10000125, "TYRE_1"),
    FRAME_1(10000131, "FRAME_1"),//框架
    FRAME_2(10000132, "FRAME_1"),
    FRAME_3(10000133, "FRAME_1"),
    FRAME_4(10000134, "FRAME_1"),
    FRAME_5(10000135, "FRAME_1"),
    SLOT_1(10000141, "SLOT_1"),//车位
    SLOT_2(10000142, "SLOT_1"),
    SLOT_3(10000143, "SLOT_1"),
    SLOT_4(10000144, "SLOT_1"),
    SLOT_5(10000145, "SLOT_1"),

    GB_I(100000201, "GB_I"),//排放
    GB_II(100000202, "GB_II"),
    GB_III(100000203, "GB_III"),
    GB_IV(100000204, "GB_IV"),
    GB_V(100000205, "GB_V"),
    EU_I(100000211, "EU_I"),
    EU_II(100000212, "EU_II"),
    EU_III(100000213, "EU_III"),
    EU_IV(100000214, "EU_IV"),
    EU_V(100000215, "EU_V"),

    A1(10000301, "A1"),//驾照
    A2(10000302, "A1"),
    A3(10000303, "A1"),
    B1(10000311, "B1"),
    B2(10000312, "B1"),
    C1(10000321, "C1"),
    C2(10000322, "C1"),
    C3(10000323, "C1"),

    /*地点 区域*/
    COUNTRY(901, ""),
    REGION(902, ""),
    PROVINCE(903, ""),
    MUNICIPAL(904, ""),
    COUNTY(905, ""),
    TOWNSHIP(906, ""),

    NORTH(100, "华北"),
    NORTHEAST(200, "东北"),
    EAST(300, "华东"),
    CENTRAL(400, "华中"),
    SOUTH(401, "华南"),
    SOUTHWEST(500, "西南"),
    NORTHWEST(600, "西北"),
    TAIWAN(700, "台湾"),
    HKMC(800, "港澳"),

    /*公司，会员 属性*/
    COLTD(20000001, "有限公司"),

    SUPPLIER(20000011, "资源方"),
    CARRIER(20000012, "承运方"),
    DEALER(20000013, "销售商（4S）"),
    MANUFACTURER(20000014, "生产商"),

    /*业务状态*/
    /*调度单状态*/
    /*SHDL_CREATED(30000001, "新建调度单"),
    SHDL_SETTLED(30000002, "结算完成"),
    SHDL_ACCOUNTED(30000003, "核算完成"),
    SHDL_PROCESSING(30000004, "任务进行中"),
    SHDL_COMPLETED(30000005, "任务完成"),
    SHDL_CANCELED(30000006, "任务取消"),*/

    /*运单、商品车状态*/
    BIZ_PENDING(31000001,"待运输"),
    BIZ_ASSIGNED(31000002,"已指派"),
    PARTIALLY_ASSIGNED(31100002,"部分已指派"),
    BIZ_SHIPPED(31000003,"已运输"),
    PARTIALLY_SHIPPED(31100003,"部分已运输"),
    BIZ_ACCIDENT(31000004,"发生事故"),
    PARTIALLY_ACCIDENT(31100004,"部分发生事故"),
    BIZ_FINISHED(31000005,"运输完成"),
    PARTIALLY_FINISHED(31100005,"部分运输完成"),

    /*业务类型*/
    BIZ_LOAD(30000011, "装车"),
    BIZ_UNLOAD(30000012, "卸车"),
    BIZ_ACCIDENT1(30000014, "事故"),

    /*结算类型*/
    FIXED(40000001,"固定费用"),
    CASH(40000002,"现金结算"),
    NP1(40000011,"N+1"),
    NP2(40000012,"N+2"),
    NP3(40000013,"N+3"),
    NP4(40000014,"N+4"),
    NP5(40000015,"N+5"),
    NP6(40000016,"N+6"),
    NP7(40000017,"N+7"),
    NP8(40000018,"N+8"),
    NP9(40000019,"N+9"),
    
    /*结算单位*/
    PER_KILOMETER(71000001,"每公里"),//每公里
    PER_TRUCK(71000002,"每台货车"),//每台货车
    PER_CARGO(71000003,"每台商品车"),//每台商品车
    PER_LOCATION(71000004,"每个地点"),//每个地点
    PER_SCHEDULE(71000005,"每调度任务"),//每次

    /*结算对象*/
    TAR_TRUCK(79000001,"轿运车"),
    TAR_CORP(79000002,"企业"),
    TAR_DRIVER(79000003,"司机"),

    /*时间周期*/
    YEAR(60000001,"年"),
    HALFYEAR(60000009,"半年"),
    QUARTER(60000002,"季"),
    MONTH(60000003,"月"),
    WEEK(60000004,"周"),
    DAY(60000005,"天"),
    HOUR(60000006,"时"),
    MINUTE(60000007,"分"),
    SECOND(60000008,"秒"),

    /*系统 属性*/
    /*系统资源权限类型*/
    NONE(8001,""),
    DISABLE(8002,""),
    ENABLE(8003,""),
    GRANT(8004,""),

    INTEGER(9101,"整数"),
    BIGDECIMAL(9102,"小数"),
    LONG(9103,"长整数"),
    STRING(9104,"字符串"),
    BOOLEAN(9105,"是与否"),
    
    /*逻辑关系*/
    AND(900001,"与"),
    OR(900002,"或"),
    NOT(900003,"非"),
    LT(910001,"小于"),
    LE(910002,"小于等于"),
    EQ(910003,"等于"),
    GE(910004,"大于等于"),
    GT(910005,"大于"),
    NE(910006,"不等于"),
    IN(910007,"在范围里"),
    BETWEEN(910008,"在范围间"),

    /*运算*/
    ADD(920001,"加"),
    SUBSTRACT(920002,"减"),
    MULTIPLY(920003,"乘"),
    DIVIDE(920004,"除"),
    SQRT(920005,"平方根");


    private Integer code;
    private String description;

    TypeEnums(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer, TypeEnums> typeMap = new HashMap<>();
    static {
        for (TypeEnums te : TypeEnums.values()){
            typeMap.put(te.code, te);
        }
    }
    public static TypeEnums fromInt(int code){
        TypeEnums type = typeMap.get(code);
        if (type == null){
            return TypeEnums.UNKNOWN;
        }
        return type;
    }

    @Override
    public Integer getIntValue() {
        return this.code;
    }
}

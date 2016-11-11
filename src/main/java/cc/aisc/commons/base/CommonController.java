package cc.aisc.commons.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sjf on 16-8-16.
 */
public class CommonController<T extends BaseModel> extends AbstractController<T, String> implements ICommonController<T>{

    protected Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final static String PATH_ROOT = "";
    private final static String PATH_TSPT = PATH_ROOT + "/tspt";
    private final static String PATH_AUTH = PATH_ROOT + "/auth";
    private final static String PATH_CORP = PATH_ROOT + "/corp";
    private final static String PATH_RUT = PATH_ROOT + "/rut";
    private final static String PATH_SYS = PATH_ROOT + "/sys";
    private final static String PATH_VEH = PATH_ROOT + "/veh";
    private final static String PATH_CNTR = PATH_ROOT + "/cntr";
    private final static String PATH_ACNT = PATH_ROOT + "/acnt";
    protected final static String PATH_QUERY = "/q";
    protected final static String PATH_QUERY_ALL = "/_qa";
    protected final static String PATH_TSPT_SCHEDULE = PATH_TSPT + "/schedules";
    protected final static String PATH_TSPT_WAYBILL = PATH_TSPT + "/waybills";
    protected final static String PATH_TSPT_TRANSPORT = PATH_TSPT + "/transports";
    protected final static String PATH_TSPT_TRANSPORT_CAR = PATH_TSPT + "/tspt-cars";
    protected final static String PATH_TSPT_PROCESS = PATH_TSPT + "/processes";
    protected final static String PATH_TSPT_CARGO = PATH_TSPT + "/cargos";
    protected final static String PATH_AUTH_USER = PATH_AUTH + "/users";
    protected final static String PATH_AUTH_ROLE = PATH_AUTH + "/roles";
    protected final static String PATH_AUTH_GROUP = PATH_AUTH + "/groups";
    protected final static String PATH_CORP_CORPORATION = PATH_CORP + "/corporations";
    protected final static String PATH_CORP_REG_INFO = PATH_CORP + "/reginfos";
    protected final static String PATH_RUT_LOCATION = PATH_RUT + "/locations";
    protected final static String PATH_RUT_DISTANCE = PATH_RUT + "/distances";
    protected final static String PATH_CNTR_INFO = PATH_CNTR + "/details";
    protected final static String PATH_CNTR_CONTRACT = PATH_CNTR + "/contracts";
    protected final static String PATH_SYS_MENU = PATH_SYS + "/menus";
    protected final static String PATH_SYS_CAR_MODEL = PATH_SYS + "/car/models";
    protected final static String PATH_SYS_RESOURCE = PATH_SYS + "/resources";
    protected final static String PATH_SYS_SCHEDULE = PATH_SYS + "/schedules";
    protected final static String PATH_SYS_VIN = PATH_SYS + "/vins";
    protected final static String PATH_VEH_DRIVER = PATH_VEH + "/drivers";
    protected final static String PATH_VEH_TRACTOR = PATH_VEH + "/tractors";
    protected final static String PATH_VEH_TRAILER = PATH_VEH + "/trailers";
    protected final static String PATH_VEH_TRUCK = PATH_VEH + "/trucks";
    protected static final String PATH_ACNT_CTGR = PATH_ACNT + "/catagories";
    protected static final String PATH_ACNT_PARAM = PATH_ACNT + "/parameters";
    protected static final String PATH_ACNT_STD = PATH_ACNT + "/standards";
    protected static final String PATH_ACNT_ITM = PATH_ACNT + "/items";

}

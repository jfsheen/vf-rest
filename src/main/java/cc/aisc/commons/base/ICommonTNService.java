package cc.aisc.commons.base;

import cc.aisc.commons.response.ResponseData;

import java.util.HashMap;

/**
 * Created by sjf on 16-10-21.
 */
@Deprecated
public interface ICommonTNService<T extends TNBaseModel> extends ICommonService<T> {
    ResponseData getTree(HashMap<String, Object> o, int page, int size) throws Exception;
}

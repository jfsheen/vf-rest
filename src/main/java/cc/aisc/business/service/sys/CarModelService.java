package cc.aisc.business.service.sys;

import cc.aisc.business.model.sys.CarModel;
import cc.aisc.commons.base.ICommonService;

/**
 * Created by sjf on 16-10-20.
 */
public interface CarModelService extends ICommonService<CarModel> {
    int findCarModelProp(String id, String prop) throws Exception;
}

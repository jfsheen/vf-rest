package cc.aisc.business.service.sys;

import cc.aisc.commons.base.ICommonService;
import cc.aisc.business.model.sys.Menu;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-13.
 */
public interface MenuService extends ICommonService<Menu> {
    Optional<List<Menu>> findByLevelLe(Integer lvl);
}

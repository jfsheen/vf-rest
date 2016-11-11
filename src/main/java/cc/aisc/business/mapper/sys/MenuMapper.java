package cc.aisc.business.mapper.sys;

import cc.aisc.commons.base.CommonMapper;
import cc.aisc.business.model.sys.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends CommonMapper<Menu> {
    List<Menu> selectAllByLevelLe(Integer lvl);
}
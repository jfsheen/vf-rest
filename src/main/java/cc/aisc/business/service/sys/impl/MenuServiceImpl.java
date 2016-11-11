package cc.aisc.business.service.sys.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.mapper.sys.MenuMapper;
import cc.aisc.business.model.sys.Menu;
import cc.aisc.business.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-13.
 */
@Service
@Transactional
public class MenuServiceImpl extends CommonService<Menu> implements MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public Optional<List<Menu>> findByLevelLe(Integer lvl) {
        return Optional.ofNullable(menuMapper.selectAllByLevelLe(lvl));
    }
}

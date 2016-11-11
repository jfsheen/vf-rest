package cc.aisc.business.service.auth.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.mapper.auth.RoleMapper;
import cc.aisc.business.model.auth.Permission;
import cc.aisc.business.model.auth.Role;
import cc.aisc.business.service.auth.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class RoleServiceImpl extends CommonService<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Permission> getPermissions(String roleId) throws Exception{
        Optional<Role> record = Optional.ofNullable(roleMapper.selectByPrimaryKey(roleId));
        if (record.isPresent()) {
            return roleMapper.selectByPrimaryKey(roleId).getPermissions();
        }
        return null;
    }
}

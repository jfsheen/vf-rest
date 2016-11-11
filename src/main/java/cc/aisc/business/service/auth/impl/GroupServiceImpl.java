package cc.aisc.business.service.auth.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.mapper.auth.GroupMapper;
import cc.aisc.business.mapper.auth.RoleMapper;
import cc.aisc.business.model.auth.Group;
import cc.aisc.business.model.auth.Role;
import cc.aisc.business.service.auth.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class GroupServiceImpl extends CommonService<Group> implements GroupService {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getRoles(String groupId) throws Exception{
        List<Role> list = new ArrayList<>();
        Optional<Group> record = Optional.ofNullable(groupMapper.selectByPrimaryKey(groupId));
        if (record.isPresent()) {
            int size = record.get().getRoles().size();
            for (int i = 0; i < size; i++){
                list.add(roleMapper.selectByPrimaryKey(record.get().getRoles().get(i).getId()));
            }
        }
        return list;
    }
}

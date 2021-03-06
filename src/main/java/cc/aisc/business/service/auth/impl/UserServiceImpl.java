package cc.aisc.business.service.auth.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.mapper.auth.UserMapper;
import cc.aisc.business.model.auth.User;
import cc.aisc.business.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class UserServiceImpl extends CommonService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*public List<Group> getGroups(Long userId) throws Exception{
        List<Group> list = new ArrayList<>();
        Optional<User> record = Optional.ofNullable(userMapper.selectByPrimaryKey(userId));
        if (record.isPresent()) {
            int size = record.get().getGroupIds().size();
            for (int i = 0; i < size; i++){
                list.add(groupMapper.selectByPrimaryKey(record.get().getGroupIds().get(i)));
            }
        }
        return list;
    }*/

    @Override
    public Optional<User> findByUsername(String username) throws Exception {
        HashMap<String,String> pm = new HashMap<>();
        pm.put("username", username);
        return  Optional.ofNullable(((List<User>)userMapper.selectValuedBySelective(pm)).get(0));
    }

    @Override
    public Optional<User> findDetailedByUsername(String username){
        return  Optional.ofNullable((userMapper.selectDetailedByUsername(username)).get(0));
    }
}

package cc.aisc.business.mapper.auth;

import cc.aisc.commons.base.CommonMapper;
import cc.aisc.business.model.auth.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends CommonMapper<User> {
    List<User> selectDetailedByUsername(String username);
}
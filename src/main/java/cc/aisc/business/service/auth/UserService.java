package cc.aisc.business.service.auth;

import cc.aisc.commons.base.ICommonService;
import cc.aisc.business.model.auth.User;

import java.util.Optional;

/**
 * Created by sjf on 16-7-4.
 */
public interface UserService extends ICommonService<User> {
    Optional<User> findByUsername(String username) throws Exception;
    Optional<User> findDetailedByUsername(String username);
}

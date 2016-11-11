package cc.aisc.business.service.auth.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.model.auth.UserGroup;
import cc.aisc.business.service.auth.UserGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class UserGroupServiceImpl extends CommonService<UserGroup> implements UserGroupService {
}

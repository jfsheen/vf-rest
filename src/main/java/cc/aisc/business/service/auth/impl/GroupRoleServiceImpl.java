package cc.aisc.business.service.auth.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.model.auth.GroupRole;
import cc.aisc.business.service.auth.GroupRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class GroupRoleServiceImpl extends CommonService<GroupRole> implements GroupRoleService {
}

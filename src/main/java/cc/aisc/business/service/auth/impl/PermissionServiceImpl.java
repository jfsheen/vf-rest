package cc.aisc.business.service.auth.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.model.auth.Permission;
import cc.aisc.business.service.auth.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-6.
 */
@Service
@Transactional
public class PermissionServiceImpl extends CommonService<Permission> implements PermissionService {
}

package cc.aisc.business.service.sys.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.model.sys.Resource;
import cc.aisc.business.service.sys.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class ResourceServiceImpl extends CommonService<Resource> implements ResourceService {
}

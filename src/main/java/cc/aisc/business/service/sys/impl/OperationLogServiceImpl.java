package cc.aisc.business.service.sys.impl;

import cc.aisc.business.model.sys.log.OperationLog;
import cc.aisc.business.service.sys.OperationLogService;
import cc.aisc.commons.base.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-10-31.
 */
@Service
@Transactional
public class OperationLogServiceImpl extends CommonService<OperationLog> implements OperationLogService {
}

package cc.aisc.business.service.sys.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.model.sys.ScheduledJob;
import cc.aisc.business.service.sys.ScheduledJobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-10-10.
 */
@Service
@Transactional
public class ScheduledJobServiceImpl extends CommonService<ScheduledJob> implements ScheduledJobService {
}

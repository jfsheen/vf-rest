package cc.aisc.business.service.sys.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.model.sys.Scheduling;
import cc.aisc.business.service.sys.SchedulingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-9-28.
 */
@Service
@Transactional
public class SchedulingServiceImpl extends CommonService<Scheduling> implements SchedulingService {
}

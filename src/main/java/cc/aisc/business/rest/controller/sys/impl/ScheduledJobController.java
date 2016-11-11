package cc.aisc.business.rest.controller.sys.impl;

import cc.aisc.business.rest.controller.sys.IScheduledJobController;
import cc.aisc.commons.base.CommonController;
import cc.aisc.business.model.sys.ScheduledJob;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sjf on 16-10-10.
 */
@RestController
public class ScheduledJobController extends CommonController<ScheduledJob> implements IScheduledJobController {
}

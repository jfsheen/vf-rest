package cc.aisc.business.service.sys;

import cc.aisc.business.model.sys.log.StatusLog;
import cc.aisc.commons.base.ICommonService;

import java.util.List;

/**
 * Created by sjf on 16-10-22.
 */
public interface StatusLogService extends ICommonService<StatusLog> {
    StatusLog logger(StatusLog log) throws Exception;
    List<StatusLog> batchLogger(List<StatusLog> logs) throws Exception;
    Integer findLastStatusCode(String objId) throws Exception;
}

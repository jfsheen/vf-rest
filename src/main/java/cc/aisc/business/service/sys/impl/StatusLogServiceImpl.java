package cc.aisc.business.service.sys.impl;

import cc.aisc.business.mapper.sys.log.StatusLogMapper;
import cc.aisc.business.model.sys.log.StatusLog;
import cc.aisc.business.service.sys.StatusLogService;
import cc.aisc.commons.base.BaseModelWithAudit;
import cc.aisc.commons.base.CommonService;
import cc.aisc.commons.exception.ResultAbsentException;
import cc.aisc.commons.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-10-22.
 */
@Service
@Transactional
public class StatusLogServiceImpl extends CommonService<StatusLog> implements StatusLogService {

    private final StatusLogMapper statusLogMapper;

    @Autowired
    public StatusLogServiceImpl(StatusLogMapper statusLogMapper) {
        this.statusLogMapper = statusLogMapper;
    }

    @Override
    public StatusLog logger(StatusLog log) throws Exception {
        try {
            log.setTs(new Date().getTime());
            log.setDs((short)0);
            int i = statusLogMapper.insert(log);
            return i > 0 ? log : null;
        } catch (Exception e) {
            throw new ServiceException("[Insert Entity 1] " + e.getMessage(), e);
        }
    }

    @Override
    public List<StatusLog> batchLogger(List<StatusLog> logs) throws Exception {
        try {
            for (StatusLog log : logs) {
                log.setTs(new Date().getTime());
                log.setDs((short) 0);
            }
            int i = statusLogMapper.insertBatch(logs);
            return i > 0 ? logs : null;
        } catch (Exception e) {
            throw new ServiceException("[Insert Entity 2] " + e.getMessage(), e);
        }
    }

    @Override
    public Integer findLastStatusCode(String objId) throws Exception {
        Optional<Integer> op;
        try {
            op = Optional.ofNullable(statusLogMapper.selectLastStsCodeByObjId(objId));
        }catch (Exception e){
            throw new ServiceException(e.getMessage(), e);
        }
        if (op.isPresent())
            return op.get();

        return -1;
    }
}

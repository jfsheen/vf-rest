package cc.aisc.config.aspect;

import cc.aisc.business.model.sys.log.StatusLog;
import cc.aisc.business.service.sys.OperationLogService;
import cc.aisc.business.service.sys.StatusLogService;
import cc.aisc.commons.base.*;
import cc.aisc.commons.exception.ServiceException;
import cc.aisc.commons.type.ValuedEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by sjf on 16-10-24.
 */
@Aspect
@Component
public class StsOprtLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(StsOprtLogAspect.class);

    ThreadLocal<Long> time = new ThreadLocal<>();

    private final StatusLogService statusLogService;
    private final OperationLogService operationLogService;

    @Autowired
    public StsOprtLogAspect(StatusLogService statusLogService, OperationLogService operationLogService) {
        this.statusLogService = statusLogService;
        this.operationLogService = operationLogService;
    }

    @Order(98)
    @Pointcut("execution(* cc.aisc.commons.base.CommonService.insert*(..))")
    public void pointcutInsert(){}

    @Order(98)
    @Pointcut("execution(* cc.aisc.commons.base.CommonService.update*(..))")
    public void pointcutUpdate(){}

    @Order(99)
    @Pointcut("@annotation(cc.aisc.config.aspect.anno.StatusLog)")
    public void pointcutStatusLog(){}

    @Around(value = "pointcutInsert() || pointcutUpdate()")
    public void aroundInsertOrUpdate(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Object re = point.proceed();
        doLog(args[0], re);
    }

    private void doLog(Object arg, Object ret) throws Exception {
        if (arg == null  || ret == null)
            return;

        //使用返回值(ret)，insert前参数(arg)中id为null
        if (ret instanceof List){
            Type[] types = ret.getClass().getGenericInterfaces();
            for (Type type : types){
                if (type instanceof ParameterizedType){
                    ParameterizedType t = (ParameterizedType) type;
                    if (BaseModel.class.isAssignableFrom((Class)t.getActualTypeArguments()[0])){
                        logn((List)ret);
                    }
                }
            }
        }else if (BaseModel.class.isAssignableFrom(ret.getClass())) {
            log1(ret);
        }else{
            LOGGER.info("未作任何记录");
        }
    }

    private StatusLog createStatusLog(Object o) {
        Type[] types = o.getClass().getGenericInterfaces();

        for (Type type : types) {
            if (type instanceof ParameterizedType) {   //status
                ParameterizedType t = (ParameterizedType) type;
                if (ValuedEnum.class.isAssignableFrom((Class) t.getActualTypeArguments()[0]) && BaseModelWithStatus.class.isAssignableFrom((Class) t.getRawType())) {
                    try {
                        //状态未发生变化，不记录，直接返回
                        if (((BaseModelWithStatus) o).getStatus().getIntValue().equals(statusLogService.findLastStatusCode(((BaseModel) o).getId())))
                            return null;
                        //参数状态码与status_log表中记录的最新状态码不同，则认为状态改变，记录
                        StatusLog sl = new StatusLog();
                        sl.setStsTs(new Date().getTime());
                        sl.setObjId(((BaseModel) o).getId());
                        sl.setStsCode(((BaseModelWithStatus) o).getStatus().getIntValue());

                        return sl;
                    } catch (Exception e) {
                        LOGGER.info("状态变化记录异常： {}", e.getMessage());
                    }
                }
            } else if (type instanceof Class) {   //audit
                Class t = (Class) type;
                if (BaseModelWithAudit.class.isAssignableFrom(t)) {
                    // TODO: 16-11-3 Audit数据记录，待完成
                    LOGGER.info("类 {} 的实例被改变", t.getSimpleName());
                }
            }
        }
        return null;
    }

    private void log1(Object o) throws Exception {
        try {
            StatusLog log = createStatusLog(o);
            if (log != null)
                statusLogService.logger(createStatusLog(o));   //避免使用statusService.insert方法时再次被aop
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private void logn(List os) throws Exception {
        try {
            List<StatusLog> logs = new ArrayList<>();
            for (Object o : os){
                StatusLog log = createStatusLog(o);
                if (log != null)
                    logs.add(createStatusLog(o));
            }
            if (logs.size() > 0)
                statusLogService.batchLogger(logs);   //避免使用statusService.insert方法时再次被aop
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}

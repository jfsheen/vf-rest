package cc.aisc.business.mapper.sys.log;

import cc.aisc.business.model.sys.log.StatusLog;
import cc.aisc.commons.base.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusLogMapper extends CommonMapper<StatusLog>{
    Integer selectLastStsCodeByObjId(@Param("objId")String objId) throws Exception;
}
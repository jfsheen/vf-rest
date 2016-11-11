package cc.aisc.business.mapper.sys;

import cc.aisc.business.model.sys.CarModel;
import cc.aisc.commons.base.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CarModelMapper extends CommonMapper<CarModel>{
    Integer selectModelInfoByPos(@Param("id")String id, @Param("pos")Integer pos);
}
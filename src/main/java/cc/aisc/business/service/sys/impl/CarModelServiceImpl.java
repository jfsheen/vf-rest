package cc.aisc.business.service.sys.impl;

import cc.aisc.business.mapper.sys.CarModelMapper;
import cc.aisc.business.model.sys.CarModel;
import cc.aisc.business.service.sys.CarModelService;
import cc.aisc.commons.base.CommonService;
import cc.aisc.commons.exception.ResultAbsentException;
import cc.aisc.commons.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by sjf on 16-10-20.
 */
@Service
@Transactional
public class CarModelServiceImpl extends CommonService<CarModel> implements CarModelService {

    private final CarModelMapper carModelMapper;

    @Autowired
    public CarModelServiceImpl(CarModelMapper carModelMapper) {
        this.carModelMapper = carModelMapper;
    }

    @Override
    @Cacheable(value = "serviceCache", keyGenerator = "redisKeyGenerator")
    @Transactional(rollbackFor = Exception.class)
    public int findCarModelProp(String id, String prop) throws Exception{
        int pos = prop.equals("weight")?1
                :prop.equals("engine")?2
                :prop.equals("wheelbase")?3
                :prop.equals("length")?4
                :prop.equals("width")?5
                :prop.equals("height")?6:1;
        Optional<Integer> op;
        try{
            op = Optional.ofNullable(carModelMapper.selectModelInfoByPos(id, pos));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

        if(!op.isPresent()) {
            throw new ResultAbsentException("未查询到数据");
        } else {
            return op.get();
        }
    }
}

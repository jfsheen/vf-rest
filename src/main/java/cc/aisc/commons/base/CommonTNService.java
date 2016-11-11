package cc.aisc.commons.base;

import cc.aisc.commons.response.ResponseData;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * Created by sjf on 16-10-21.
 */
@Deprecated
@Service
@Transactional
public abstract class CommonTNService<T extends TNBaseModel> extends TNAbstractService<T, String>{

    @Override
    @Cacheable(value = "serviceCache", keyGenerator = "redisKeyGenerator")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData getTree(HashMap<String, Object> o, int page, int size) throws Exception {
        return super.getTree(o, page, size);
    }
}

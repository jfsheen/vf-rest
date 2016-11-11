package cc.aisc.commons.base;

import cc.aisc.commons.exception.ServiceException;
import cc.aisc.commons.response.ResponseData;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-9-30.
 */
@Service
@Transactional
public abstract class CommonService<T extends BaseModel> extends AbstractService<T, String>{

    @Override
    @CacheEvict(value = "redisCache", key = "#entity.getId()")
    @Transactional(rollbackFor = Exception.class)
    public int delete(T entity) throws Exception {
        return super.delete(entity);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int delete(List<T> entities) throws Exception {
        return super.delete(entities);
    }

    @Override   // entity id 为 null
    //@Cacheable(value = "redisCache", key = "#entity.getId()")
    @Transactional(rollbackFor = Exception.class)
    public T insert(T entity) throws Exception {
        return super.insert(entity);
    }

    @Override
    //@Cacheable(value = "redisCache", key = "#entity.getId()")
    @Transactional(rollbackFor = Exception.class)
    public T insertSelective(T entity) throws Exception {
        return super.insertSelective(entity);
    }

    @Override
    //@CacheEvict(value = "redisCache", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public List<T> insert(List<T> entities) throws Exception {
        return super.insert(entities);
    }

    @Override
    @CacheEvict(value = "redisCache", key = "#entity.getId()")
    @Transactional(rollbackFor = Exception.class)
    public T updateWithBlobs(T entity) throws Exception {
        return super.updateWithBlobs(entity);
    }

    @Override
    @CacheEvict(value = "redisCache", key = "#entity.getId()")
    @Transactional(rollbackFor = Exception.class)
    public T update(T entity) throws Exception {
        return super.update(entity);
    }

    @Override
    @CacheEvict(value = "redisCache", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public List<T> update(List<T> entities) throws Exception {
        return super.update(entities);
    }

    @Override
    @Cacheable(value = "redisCache")
    @Transactional(rollbackFor = Exception.class)
    public T findById(String id) throws Exception {
        return super.findById(id);
    }

    @Override
    @Cacheable(value = "redisCache")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData findByModel(T entity, int page, int size) throws Exception {
        return super.findByModel(entity, page, size);
    }

    /**
     * 为什么之前去掉 keyGenerator？？
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    @Cacheable(value = "redisCache", keyGenerator = "redisKeyGenerator")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData findAll(int page, int size) throws Exception {
        return super.findAll(page, size);
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "redisKeyGenerator")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData findValid(int page, int size) throws Exception {
        return super.findValid(page, size);
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "redisKeyGenerator")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData findFuzzy(String o, int page, int size) throws Exception {
        return super.findFuzzy(o, page, size);
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "redisKeyGenerator")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData findValuedBySelective(HashMap<String, Object> o, int page, int size) throws Exception {
        return super.findValuedBySelective(o, page, size);
    }

    @Override
    @Cacheable(value = "redisCache", keyGenerator = "redisKeyGenerator")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData findDetailedBySelective(HashMap<String, Object> o, int page, int size) throws Exception {
        return super.findDetailedBySelective(o, page, size);
    }
}
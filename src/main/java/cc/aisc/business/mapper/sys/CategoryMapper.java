package cc.aisc.business.mapper.sys;

import cc.aisc.commons.base.CommonMapper;
import cc.aisc.business.model.sys.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper extends CommonMapper<Category> {
    /*List<Category> selectAllByType(CategoryType type);*/
}
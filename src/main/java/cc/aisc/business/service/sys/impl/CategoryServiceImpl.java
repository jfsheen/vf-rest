package cc.aisc.business.service.sys.impl;

import cc.aisc.commons.base.CommonService;
import cc.aisc.business.mapper.sys.CategoryMapper;
import cc.aisc.business.model.sys.Category;
import cc.aisc.business.service.sys.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-5-13.
 */
@Service
@Transactional
public class CategoryServiceImpl extends CommonService<Category> implements CategoryService {

    final
    CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /*@Override
    public Optional<List<Category>> findAllByType(CategoryType type) {
        return Optional.ofNullable(categoryMapper.selectAllByType(type));
    }*/
}

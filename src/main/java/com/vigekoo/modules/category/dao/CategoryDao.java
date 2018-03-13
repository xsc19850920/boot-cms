package com.vigekoo.modules.category.dao;

import com.vigekoo.modules.category.entity.Category;
import com.vigekoo.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseDao<Category> {
	
}

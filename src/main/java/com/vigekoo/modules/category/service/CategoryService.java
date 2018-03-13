package com.vigekoo.modules.category.service;

import com.vigekoo.modules.category.entity.Category;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(主题类别)
 * @date 2018-03-13 19:51:59
 */
public interface CategoryService {
	
	Category queryObject(Long categoryId);
	
	List<Category> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void delete(Long categoryId);
	
	void deleteBatch(Long[] categoryIds);

	void save(Category category, HttpServletRequest request);

	void update(Category category, HttpServletRequest request);

}

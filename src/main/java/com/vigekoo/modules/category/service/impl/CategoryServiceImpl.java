package com.vigekoo.modules.category.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.category.dao.CategoryDao;
import com.vigekoo.modules.category.entity.Category;
import com.vigekoo.modules.category.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Category queryObject(Long categoryId){
		return categoryDao.queryObject(categoryId);
	}
	
	@Override
	public List<Category> queryList(Map<String, Object> map){
		return categoryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return categoryDao.queryTotal(map);
	}
	
	@Override
	public void save(Category category,HttpServletRequest request){
		initCategory(category, request);
		categoryDao.save(category);
	}

	public void initCategory(Category category, HttpServletRequest request) {
		if(category.getDisplayOrder() == null){
			category.setDisplayOrder(0);
		}
		long currentTime = new Date().getTime();
		category.setCategoryId(Long.parseLong(IdGenUtil.get().nextId()));
		category.setCategoryType(1); //妈妈知道
		category.setCreateTime(currentTime);
		category.setDelFlag(0);
		category.setHotFlag(0);
		category.setHotOrder(0);
		category.setInfoQty(0);
		category.setMemo("");
		category.setModifyTime(currentTime);
		category.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		category.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		category.setStateType(1);
		category.setAllowDeleteFlag(1);
	}
	
	@Override
	public void update(Category category, HttpServletRequest request){
		long currentTime = new Date().getTime();
		category.setModifyTime(currentTime);
		category.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		category.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		categoryDao.update(category);
	}
	
	@Override
	public void delete(Long categoryId){
		categoryDao.delete(categoryId);
	}
	
	@Override
	public void deleteBatch(Long[] categoryIds){
		categoryDao.deleteBatch(categoryIds);
	}
	
}

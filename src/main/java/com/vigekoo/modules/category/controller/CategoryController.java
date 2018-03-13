package com.vigekoo.modules.category.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vigekoo.modules.category.entity.Category;
import com.vigekoo.modules.category.service.CategoryService;
import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(主题类别)
 * @date 2018-03-13 19:51:59
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractController{

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("category:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Category> categoryList = categoryService.queryList(query);
		int total = categoryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(categoryList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{categoryId}")
	@RequiresPermissions("category:info")
	public Result info(@PathVariable("categoryId") Long categoryId){
		Category category = categoryService.queryObject(categoryId);
		
		return Result.ok().put("category", category);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("category:save")
	public Result save(@RequestBody Category category,HttpServletRequest request){
		categoryService.save(category,request);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("category:update")
	public Result update(@RequestBody Category category,HttpServletRequest request){
		categoryService.update(category,request);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("category:delete")
	public Result delete(@RequestBody Long[] categoryIds){
		categoryService.deleteBatch(categoryIds);
		
		return Result.ok();
	}
	
}

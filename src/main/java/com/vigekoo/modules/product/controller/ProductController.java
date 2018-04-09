package com.vigekoo.modules.product.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.product.entity.Product;
import com.vigekoo.modules.product.service.ProductService;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(产品)
 * @date 2018-03-11 08:55:49
 */
@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController{

	@Autowired
	private ProductService productService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("product:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Product> productList = productService.queryList(query);
		int total = productService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(productList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{productId}")
	@RequiresPermissions("product:info")
	public Result info(@PathVariable("productId") Long productId){
		Product product = productService.queryObject(productId);
		
		return Result.ok().put("product", product);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("product:save")
	public Result save(@RequestBody Product product){
		productService.save(product);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("product:update")
	public Result update(@RequestBody Product product){
		productService.update(product);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("product:delete")
	public Result delete(@RequestBody Long[] productIds){
		productService.deleteBatch(productIds);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/import")
	@RequiresPermissions("product:import")
	public Result importData(){
		
		return Result.ok();
	}
	
}

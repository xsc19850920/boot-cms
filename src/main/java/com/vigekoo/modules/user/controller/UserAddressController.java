package com.vigekoo.modules.user.controller;

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
import com.vigekoo.modules.sys.controller.AbstractController;
import com.vigekoo.modules.user.entity.UserAddress;
import com.vigekoo.modules.user.service.UserAddressService;

/**
 * @author sxia
 * @Description: TODO(用户_收货地址)
 * @date 2018-03-10 20:51:13
 */
@RestController
@RequestMapping("/user/address")
public class UserAddressController extends AbstractController{

	@Autowired
	private UserAddressService userAddressService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:address:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserAddress> userAddressList = userAddressService.queryList(query);
		int total = userAddressService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userAddressList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userAddressId}")
	@RequiresPermissions("user:address:info")
	public Result info(@PathVariable("userAddressId") Long userAddressId){
		UserAddress userAddress = userAddressService.queryObject(userAddressId);
		
		return Result.ok().put("userAddress", userAddress);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:address:save")
	public Result save(@RequestBody UserAddress userAddress){
		userAddressService.save(userAddress);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:address:update")
	public Result update(@RequestBody UserAddress userAddress){
		userAddressService.update(userAddress);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:address:delete")
	public Result delete(@RequestBody Long[] userAddressIds){
		userAddressService.deleteBatch(userAddressIds);
		
		return Result.ok();
	}
	
}

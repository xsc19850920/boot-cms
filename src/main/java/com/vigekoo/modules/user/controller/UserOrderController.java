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
import com.vigekoo.modules.user.entity.UserOrder;
import com.vigekoo.modules.user.service.UserOrderService;

/**
 * @author sxia
 * @Description: TODO(订单（兑换）)
 * @date 2018-03-11 08:47:19
 */
@RestController
@RequestMapping("/order/userorder")
public class UserOrderController extends AbstractController{

	@Autowired
	private UserOrderService userOrderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("order:userOrder:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserOrder> userOrderList = userOrderService.queryList(query);
		int total = userOrderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userOrderList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userOrderId}")
	@RequiresPermissions("order:userOrder:info")
	public Result info(@PathVariable("userOrderId") Long userOrderId){
		UserOrder userOrder = userOrderService.queryObject(userOrderId);
		
		return Result.ok().put("userOrder", userOrder);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("order:userOrder:save")
	public Result save(@RequestBody UserOrder userOrder){
		userOrderService.save(userOrder);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("order:userOrder:update")
	public Result update(@RequestBody UserOrder userOrder){
		userOrderService.update(userOrder);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("order:userOrder:delete")
	public Result delete(@RequestBody Long[] userOrderIds){
		userOrderService.deleteBatch(userOrderIds);
		
		return Result.ok();
	}
	
}

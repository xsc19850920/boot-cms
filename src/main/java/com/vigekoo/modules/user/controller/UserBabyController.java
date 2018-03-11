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
import com.vigekoo.modules.user.entity.UserBaby;
import com.vigekoo.modules.user.service.UserBabyService;

/**
 * @author sxia
 * @Description: TODO(用户_宝宝信息)
 * @date 2018-03-11 10:45:11
 */
@RestController
@RequestMapping("/baby/baby")
public class UserBabyController extends AbstractController{

	@Autowired
	private UserBabyService userBabyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:baby:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserBaby> userBabyList = userBabyService.queryList(query);
		int total = userBabyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userBabyList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("user:baby:info")
	public Result info(@PathVariable("userId") Long userId){
		UserBaby userBaby = userBabyService.queryObject(userId);
		
		return Result.ok().put("userBaby", userBaby);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:baby:save")
	public Result save(@RequestBody UserBaby userBaby){
		userBabyService.save(userBaby);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:baby:update")
	public Result update(@RequestBody UserBaby userBaby){
		userBabyService.update(userBaby);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:baby:delete")
	public Result delete(@RequestBody Long[] userIds){
		userBabyService.deleteBatch(userIds);
		
		return Result.ok();
	}
	
}

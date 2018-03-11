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
import com.vigekoo.modules.user.entity.UserDetail;
import com.vigekoo.modules.user.service.UserDetailService;

/**
 * @author sxia
 * @Description: TODO(用户_详情)
 * @date 2018-03-11 13:46:15
 */
@RestController
@RequestMapping("//userdetail")
public class UserDetailController extends AbstractController{

	@Autowired
	private UserDetailService userDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:detail:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserDetail> userDetailList = userDetailService.queryList(query);
		int total = userDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userDetailList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("user:detail:info")
	public Result info(@PathVariable("userId") Long userId){
		UserDetail userDetail = userDetailService.queryObject(userId);
		
		return Result.ok().put("userDetail", userDetail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:detail:save")
	public Result save(@RequestBody UserDetail userDetail){
		userDetailService.save(userDetail);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:detail:update")
	public Result update(@RequestBody UserDetail userDetail){
		userDetailService.update(userDetail);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:detail:delete")
	public Result delete(@RequestBody Long[] userIds){
		userDetailService.deleteBatch(userIds);
		
		return Result.ok();
	}
	
}

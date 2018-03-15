package com.vigekoo.modules.user.controller;

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

import com.vigekoo.modules.user.entity.UserComment;
import com.vigekoo.modules.user.service.UserCommentService;
import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(用户_评论)
 * @date 2018-03-15 10:40:47
 */
@RestController
@RequestMapping("/user/comment")
public class UserCommentController extends AbstractController{

	@Autowired
	private UserCommentService userCommentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:comment:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserComment> userCommentList = userCommentService.queryList(query);
		int total = userCommentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userCommentList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userCommentId}")
	@RequiresPermissions("user:comment:info")
	public Result info(@PathVariable("userCommentId") Long userCommentId){
		UserComment userComment = userCommentService.queryObject(userCommentId);
		
		return Result.ok().put("userComment", userComment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:comment:save")
	public Result save(@RequestBody UserComment userComment,HttpServletRequest request){
		userCommentService.save(userComment,request);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:comment:update")
	public Result update(@RequestBody UserComment userComment,HttpServletRequest request){
		userCommentService.update(userComment,request);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:comment:delete")
	public Result delete(@RequestBody Long[] userCommentIds){
		userCommentService.deleteBatch(userCommentIds);
		
		return Result.ok();
	}
	
}

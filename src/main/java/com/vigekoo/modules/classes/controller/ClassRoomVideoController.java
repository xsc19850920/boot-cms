package com.vigekoo.modules.classes.controller;

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

import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.classes.entity.ClassRoomVideo;
import com.vigekoo.modules.classes.service.ClassRoomVideoService;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(绘画启蒙课堂视频)
 * @date 2018-03-13 09:07:48
 */
@RestController
@RequestMapping("/classes/room/video")
public class ClassRoomVideoController extends AbstractController{

	@Autowired
	private ClassRoomVideoService classRoomVideoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("classes:room:video:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ClassRoomVideo> classRoomVideoList = classRoomVideoService.queryList(query);
		int total = classRoomVideoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(classRoomVideoList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{classRoomVideoId}")
	@RequiresPermissions("classes:room:video:info")
	public Result info(@PathVariable("classRoomVideoId") Long classRoomVideoId){
		ClassRoomVideo classRoomVideo = classRoomVideoService.queryObject(classRoomVideoId);
		
		return Result.ok().put("classRoomVideo", classRoomVideo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("classes:room:video:save")
	public Result save(@RequestBody ClassRoomVideo classRoomVideo, HttpServletRequest request){
		classRoomVideoService.save(classRoomVideo,request);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("classes:room:video:update")
	public Result update(@RequestBody ClassRoomVideo classRoomVideo){
		classRoomVideoService.update(classRoomVideo);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("classes:room:video:delete")
	public Result delete(@RequestBody Long[] classRoomVideoIds){
		classRoomVideoService.deleteBatch(classRoomVideoIds);
		
		return Result.ok();
	}
	
}

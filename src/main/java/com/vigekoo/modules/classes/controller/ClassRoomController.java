package com.vigekoo.modules.classes.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
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
import com.vigekoo.modules.classes.entity.ClassRoom;
import com.vigekoo.modules.classes.service.ClassRoomService;
import com.vigekoo.modules.lecturer.service.LecturerService;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(绘画启蒙课堂)
 * @date 2018-03-11 17:52:30
 */
@RestController
@RequestMapping("/classes/room")
public class ClassRoomController extends AbstractController{

	@Autowired
	private ClassRoomService classRoomService;
	
	@Autowired
	private LecturerService lecturerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("classes:room:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ClassRoom> classRoomList = classRoomService.queryList(query);
		int total = classRoomService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(classRoomList, total, query.getLimit(), query.getPage());
		
		//init lecturer info list
		return Result.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{classRoomId}")
	@RequiresPermissions("classes:room:info")
	public Result info(@PathVariable("classRoomId") Long classRoomId){
		ClassRoom classRoom = classRoomService.queryObject(classRoomId);
		return Result.ok().put("classRoom", classRoom);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("classes:room:save")
	public Result save(@RequestBody ClassRoom classRoom,HttpServletRequest request){
		classRoomService.save(classRoom,request);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("classes:room:update")
	public Result update(@RequestBody ClassRoom classRoom){
		classRoomService.update(classRoom);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("classes:room:delete")
	public Result delete(@RequestBody String[] classRoomIds){
		
		Long[] tempInfoAudioIds = new Long[classRoomIds.length];
		if(ArrayUtils.isNotEmpty(classRoomIds)){
			for (int i = 0; i < classRoomIds.length; i++) {
				tempInfoAudioIds[i] = Long.parseLong(classRoomIds[i]);
			}
		}
		
		classRoomService.deleteBatch(tempInfoAudioIds);
		
		return Result.ok();
	}
	
}

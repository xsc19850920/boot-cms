package com.vigekoo.modules.lecturer.controller;

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
import com.vigekoo.modules.lecturer.entity.Lecturer;
import com.vigekoo.modules.lecturer.service.LecturerService;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(讲师)
 * @date 2018-03-12 19:40:41
 */
@RestController
@RequestMapping("/lecturer")
public class LecturerController extends AbstractController{

	@Autowired
	private LecturerService lecturerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("lecturer:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Lecturer> lecturerList = lecturerService.queryList(query);
		int total = lecturerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(lecturerList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{lecturerId}")
	@RequiresPermissions("lecturer:info")
	public Result info(@PathVariable("lecturerId") Long lecturerId){
		Lecturer lecturer = lecturerService.queryObject(lecturerId);
		
		return Result.ok().put("lecturer", lecturer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("lecturer:save")
	public Result save(@RequestBody Lecturer lecturer,HttpServletRequest request){
		lecturerService.save(lecturer,request);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("lecturer:update")
	public Result update(@RequestBody Lecturer lecturer){
		lecturerService.update(lecturer);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("lecturer:delete")
	public Result delete(@RequestBody Long[] lecturerIds){
		lecturerService.deleteBatch(lecturerIds);
		
		return Result.ok();
	}
	
}

package com.vigekoo.modules.info.controller;

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
import com.vigekoo.modules.info.entity.InfoPregnancyCheck;
import com.vigekoo.modules.info.service.InfoPregnancyCheckService;
import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(产检信息)
 * @date 2018-03-13 20:35:37
 */
@RestController
@RequestMapping("/info/pregnancycheck")
public class InfoPregnancyCheckController extends AbstractController{

	@Autowired
	private InfoPregnancyCheckService infoPregnancyCheckService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("info:pregnancycheck:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InfoPregnancyCheck> infoPregnancyCheckList = infoPregnancyCheckService.queryList(query);
		int total = infoPregnancyCheckService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(infoPregnancyCheckList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{infoPregnancyCheckId}")
	@RequiresPermissions("info:pregnancycheck:info")
	public Result info(@PathVariable("infoPregnancyCheckId") Long infoPregnancyCheckId){
		InfoPregnancyCheck infoPregnancyCheck = infoPregnancyCheckService.queryObject(infoPregnancyCheckId);
		
		return Result.ok().put("infoPregnancyCheck", infoPregnancyCheck);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("info:pregnancycheck:save")
	public Result save(@RequestBody InfoPregnancyCheck infoPregnancyCheck, HttpServletRequest request){
		infoPregnancyCheckService.save(infoPregnancyCheck,request);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("info:pregnancycheck:update")
	public Result update(@RequestBody InfoPregnancyCheck infoPregnancyCheck, HttpServletRequest request){
		infoPregnancyCheckService.update(infoPregnancyCheck,request);
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("info:pregnancycheck:delete")
	public Result delete(@RequestBody Long[] infoPregnancyCheckIds){
		infoPregnancyCheckService.deleteBatch(infoPregnancyCheckIds);
		
		return Result.ok();
	}
	
}

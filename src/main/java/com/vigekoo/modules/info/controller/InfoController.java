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
import com.vigekoo.modules.info.entity.Info;
import com.vigekoo.modules.info.service.InfoService;
import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(信息)
 * @date 2018-03-13 21:15:21
 */
@RestController
@RequestMapping("/info")
public class InfoController extends AbstractController{

	@Autowired
	private InfoService infoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("info:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Info> infoList = infoService.queryList(query);
		int total = infoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(infoList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{infoId}")
	@RequiresPermissions("info:info")
	public Result info(@PathVariable("infoId") Long infoId){
		Info info = infoService.queryObject(infoId);
		
		return Result.ok().put("info", info);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("info:save")
	public Result save(@RequestBody Info info,HttpServletRequest request){
		infoService.save(info,request);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("info:update")
	public Result update(@RequestBody Info info,HttpServletRequest request){
		infoService.update(info,request);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("info:delete")
	public Result delete(@RequestBody Long[] infoIds){
		infoService.deleteBatch(infoIds);
		
		return Result.ok();
	}
	
}

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
import com.vigekoo.modules.info.entity.InfoQa;
import com.vigekoo.modules.info.service.InfoQaService;
import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(一问一答)
 * @date 2018-03-14 20:17:57
 */
@RestController
@RequestMapping("/info/qa")
public class InfoQaController extends AbstractController{

	@Autowired
	private InfoQaService infoQaService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("info:qa:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InfoQa> infoQaList = infoQaService.queryList(query);
		int total = infoQaService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(infoQaList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{infoQaId}")
	@RequiresPermissions("info:qa:info")
	public Result info(@PathVariable("infoQaId") Long infoQaId){
		InfoQa infoQa = infoQaService.queryObject(infoQaId);
		
		return Result.ok().put("infoQa", infoQa);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("info:qa:save")
	public Result save(@RequestBody InfoQa infoQa,HttpServletRequest request){
		infoQaService.save(infoQa,request);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("info:qa:update")
	public Result update(@RequestBody InfoQa infoQa,HttpServletRequest request){
		infoQaService.update(infoQa,request);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("info:qa:delete")
	public Result delete(@RequestBody Long[] infoQaIds){
		infoQaService.deleteBatch(infoQaIds);
		
		return Result.ok();
	}
	
}

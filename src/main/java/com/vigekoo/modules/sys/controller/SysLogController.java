package com.vigekoo.modules.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.entity.SysLog;
import com.vigekoo.modules.sys.service.SysLogService;

/**
 * @author oplus
 * @Description: TODO(系统日志)
 * @date 2017-6-23 15:07
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:log:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SysLog> sysLogList = sysLogService.queryList(query);
		int total = sysLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysLogList, total, query.getLimit(), query.getPage());
		return Result.ok().put("page", pageUtil);
	}
	
	/**
	 * 附件信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:log:info")
	public Result info(@PathVariable("id") Long id) {
		 SysLog log = sysLogService.queryObject(id);
		return Result.ok().put("log", log);
	}
	
}

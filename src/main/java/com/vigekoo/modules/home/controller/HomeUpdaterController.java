package com.vigekoo.modules.home.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vigekoo.modules.home.entity.HomeUpdater;
import com.vigekoo.modules.home.service.HomeUpdaterService;
import com.vigekoo.common.utils.PageUtils;
import com.vigekoo.common.utils.Query;
import com.vigekoo.common.utils.Result;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(首页更新内容)
 * @date 2018-03-16 10:20:12
 */
@RestController
@RequestMapping("/homeupdater")
public class HomeUpdaterController extends AbstractController{

	@Autowired
	private HomeUpdaterService homeUpdaterService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("homeUpdater:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HomeUpdater> homeUpdaterList = homeUpdaterService.queryList(query);
		int total = homeUpdaterService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(homeUpdaterList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{homeUpdaterId}")
	@RequiresPermissions("homeUpdater:info")
	public Result info(@PathVariable("homeUpdaterId") Long homeUpdaterId){
		HomeUpdater homeUpdater = homeUpdaterService.queryObject(homeUpdaterId);
		
		return Result.ok().put("homeUpdater", homeUpdater);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("homeUpdater:save")
	public Result save(@RequestBody HomeUpdater homeUpdater){
		homeUpdaterService.save(homeUpdater);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("homeUpdater:update")
	public Result update(@RequestBody HomeUpdater homeUpdater){
		homeUpdaterService.update(homeUpdater);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("homeUpdater:delete")
	public Result delete(@RequestBody Long[] homeUpdaterIds){
		homeUpdaterService.deleteBatch(homeUpdaterIds);
		
		return Result.ok();
	}
	
}

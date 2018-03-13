package com.vigekoo.modules.banner.controller;

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
import com.vigekoo.modules.banner.entity.Banner;
import com.vigekoo.modules.banner.service.BannerService;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(轮播图)
 * @date 2018-03-13 10:40:07
 */
@RestController
@RequestMapping("/banner")
public class BannerController extends AbstractController{

	@Autowired
	private BannerService bannerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("banner:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Banner> bannerList = bannerService.queryList(query);
		int total = bannerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(bannerList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{bannerId}")
	@RequiresPermissions("banner:info")
	public Result info(@PathVariable("bannerId") Long bannerId){
		Banner banner = bannerService.queryObject(bannerId);
		
		return Result.ok().put("banner", banner);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("banner:save")
	public Result save(@RequestBody Banner banner,HttpServletRequest request){
		bannerService.save(banner,request);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("banner:update")
	public Result update(@RequestBody Banner banner){
		bannerService.update(banner);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("banner:delete")
	public Result delete(@RequestBody Long[] bannerIds){
		bannerService.deleteBatch(bannerIds);
		
		return Result.ok();
	}
	
}

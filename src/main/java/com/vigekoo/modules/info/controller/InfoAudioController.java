package com.vigekoo.modules.info.controller;

import java.util.List;
import java.util.Map;

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
import com.vigekoo.modules.info.entity.InfoAudio;
import com.vigekoo.modules.info.service.InfoAudioService;
import com.vigekoo.modules.sys.controller.AbstractController;

/**
 * @author sxia
 * @Description: TODO(信息_音频)
 * @date 2018-03-11 14:18:11
 */
@RestController
@RequestMapping("/info/audio")
public class InfoAudioController extends AbstractController{

	@Autowired
	private InfoAudioService infoAudioService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("info:audio:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InfoAudio> infoAudioList = infoAudioService.queryList(query);
		int total = infoAudioService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(infoAudioList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{infoAudioId}")
	@RequiresPermissions("info:audio:info")
	public Result info(@PathVariable("infoAudioId") Long infoAudioId){
		InfoAudio infoAudio = infoAudioService.queryObject(infoAudioId);
		
		return Result.ok().put("infoAudio", infoAudio);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("info:audio:save")
	public Result save(@RequestBody InfoAudio infoAudio){
		infoAudioService.save(infoAudio);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("info:audio:update")
	public Result update(@RequestBody InfoAudio infoAudio){
		infoAudioService.update(infoAudio);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("info:audio:delete")
	public Result delete(@RequestBody String[] infoAudioIds){
		Long[] tempInfoAudioIds = new Long[infoAudioIds.length];
		if(ArrayUtils.isNotEmpty(infoAudioIds)){
			for (int i = 0; i < infoAudioIds.length; i++) {
				tempInfoAudioIds[i] = Long.parseLong(infoAudioIds[i]);
			}
		}
		infoAudioService.deleteBatch(tempInfoAudioIds);
		
		return Result.ok();
	}
	
}

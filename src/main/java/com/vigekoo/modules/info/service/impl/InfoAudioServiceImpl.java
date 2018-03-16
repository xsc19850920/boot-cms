package com.vigekoo.modules.info.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.home.dao.HomeUpdaterDao;
import com.vigekoo.modules.home.entity.HomeUpdater;
import com.vigekoo.modules.info.dao.InfoAudioDao;
import com.vigekoo.modules.info.entity.InfoAudio;
import com.vigekoo.modules.info.service.InfoAudioService;

@Service("infoAudioService")
public class InfoAudioServiceImpl implements InfoAudioService {

	@Autowired
	private InfoAudioDao infoAudioDao;
	
	@Autowired
	private HomeUpdaterDao homeUpdaterDao;
	
	@Override
	public InfoAudio queryObject(Long infoAudioId){
		return infoAudioDao.queryObject(infoAudioId);
	}
	
	@Override
	public List<InfoAudio> queryList(Map<String, Object> map){
		return infoAudioDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return infoAudioDao.queryTotal(map);
	}
	
	@Override
	public void save(InfoAudio infoAudio){
		long time = new Date().getTime();
		
		
		initInfoAudio(infoAudio,time);
		infoAudioDao.save(infoAudio);
		
//		添加 音频信息（info_audio表）的时候，把信息添加到home_updater表
		HomeUpdater homeUpdater = new HomeUpdater();
		homeUpdater.setCreateTime(time);
		homeUpdater.setOperIp(IPUtils.Ip2Int(IPUtils.getLocalIP()));
		homeUpdater.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		homeUpdater.setDelFlag(0);
		homeUpdater.setHomeUpdaterId(Long.parseLong(IdGenUtil.get().nextId()));
		homeUpdater.setHomeUpdaterType(1); //更新内容类型(1音频 2产品) : 1音频 2产品
		homeUpdater.setModifyTime(time);
		homeUpdater.setUpdaterInfoId(NumberUtils.createLong(infoAudio.getInfoAudioId().toString()));
		homeUpdater.setUpdaterInfoImagePath(infoAudio.getCloudUrl());
		homeUpdater.setUpdaterInfoTitle(infoAudio.getTitle());
		homeUpdater.setUpdaterInfoType(infoAudio.getInfoType());//更新内容信息类型 : 1早安童诗 2晚安故事 3特色绘本 4古典音乐 0产品无分类
		homeUpdaterDao.save(homeUpdater);
	}

	
	@Override
	public void update(InfoAudio infoAudio){
		infoAudioDao.update(infoAudio);
	}
	
	@Override
	public void delete(Long infoAudioId){
		infoAudioDao.delete(infoAudioId);
	}
	
	@Override
	public void deleteBatch(Long[] infoAudioIds){
		infoAudioDao.deleteBatch(infoAudioIds);
	}
	
	
	private void initInfoAudio(InfoAudio infoAudio,long time) {
		
		infoAudio.setCreateTime(time);
		infoAudio.setModifyTime(time);
		infoAudio.setDelFlag(0);
		infoAudio.setDuration(1);
		infoAudio.setDurationText("01:10:20");
		infoAudio.setFavoriteQty(0);
		infoAudio.setFlagTop(0);
		infoAudio.setInfoAudioId(Long.parseLong(IdGenUtil.get().nextId()));
		infoAudio.setOperIp(IPUtils.Ip2Int(IPUtils.getLocalIP()));
		infoAudio.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		infoAudio.setPlayQty(0);
		infoAudio.setStateType(1);
	}
}

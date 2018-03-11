package com.vigekoo.modules.info.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.info.dao.InfoAudioDao;
import com.vigekoo.modules.info.entity.InfoAudio;
import com.vigekoo.modules.info.service.InfoAudioService;

@Service("infoAudioService")
public class InfoAudioServiceImpl implements InfoAudioService {

	@Autowired
	private InfoAudioDao infoAudioDao;
	
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
		
		initInfoAudio(infoAudio);
		infoAudioDao.save(infoAudio);
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
	
	
	private void initInfoAudio(InfoAudio infoAudio) {
		long time = new Date().getTime();
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

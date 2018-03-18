package com.vigekoo.modules.info.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.info.dao.InfoPregnancyCheckDao;
import com.vigekoo.modules.info.entity.InfoPregnancyCheck;
import com.vigekoo.modules.info.service.InfoPregnancyCheckService;

@Service("infoPregnancyCheckService")
public class InfoPregnancyCheckServiceImpl implements InfoPregnancyCheckService {

	@Autowired
	private InfoPregnancyCheckDao infoPregnancyCheckDao;
	
	@Override
	public InfoPregnancyCheck queryObject(Long infoPregnancyCheckId){
		return infoPregnancyCheckDao.queryObject(infoPregnancyCheckId);
	}
	
	@Override
	public List<InfoPregnancyCheck> queryList(Map<String, Object> map){
		return infoPregnancyCheckDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return infoPregnancyCheckDao.queryTotal(map);
	}
	
	@Override
	public void save(InfoPregnancyCheck infoPregnancyCheck, HttpServletRequest request){
		initCategory(infoPregnancyCheck,request);
		infoPregnancyCheckDao.save(infoPregnancyCheck);
	}
	
	public void initCategory(InfoPregnancyCheck infoPregnancyCheck, HttpServletRequest request) {
		if(infoPregnancyCheck.getDisplayOrder() == null){
			infoPregnancyCheck.setDisplayOrder(0);
		}
		long currentTime = new Date().getTime();
		infoPregnancyCheck.setModifyTime(currentTime);
		infoPregnancyCheck.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		infoPregnancyCheck.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		infoPregnancyCheck.setInfoPregnancyCheckId(Long.parseLong(IdGenUtil.get().nextId()));
		infoPregnancyCheck.setCreateTime(currentTime);
		infoPregnancyCheck.setDelFlag(0);
		infoPregnancyCheck.setStateType(1);
	}
	
	@Override
	public void update(InfoPregnancyCheck infoPregnancyCheck, HttpServletRequest request){
		long currentTime = new Date().getTime();
		infoPregnancyCheck.setModifyTime(currentTime);
		infoPregnancyCheck.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		infoPregnancyCheck.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		infoPregnancyCheckDao.update(infoPregnancyCheck);
	}
	
	@Override
	public void delete(Long infoPregnancyCheckId){
		infoPregnancyCheckDao.delete(infoPregnancyCheckId);
	}
	
	@Override
	public void deleteBatch(Long[] infoPregnancyCheckIds){
		infoPregnancyCheckDao.deleteBatch(infoPregnancyCheckIds);
	}
	
}

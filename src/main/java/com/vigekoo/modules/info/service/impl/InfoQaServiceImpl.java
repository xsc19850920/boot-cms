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
import com.vigekoo.modules.info.dao.InfoQaDao;
import com.vigekoo.modules.info.entity.InfoQa;
import com.vigekoo.modules.info.service.InfoQaService;

@Service("infoQaService")
public class InfoQaServiceImpl implements InfoQaService {

	@Autowired
	private InfoQaDao infoQaDao;
	
	@Override
	public InfoQa queryObject(Long infoQaId){
		return infoQaDao.queryObject(infoQaId);
	}
	
	@Override
	public List<InfoQa> queryList(Map<String, Object> map){
		return infoQaDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return infoQaDao.queryTotal(map);
	}
	
	@Override
	public void save(InfoQa infoQa,HttpServletRequest request){
		initInfoQa(infoQa, request);
		infoQaDao.save(infoQa);
	}

	public void initInfoQa(InfoQa infoQa, HttpServletRequest request) {
		long currentTime  = new Date().getTime();
		infoQa.setModifyTime(currentTime);
		infoQa.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		infoQa.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		infoQa.setInfoQaId(Long.parseLong(IdGenUtil.get().nextId()));
		infoQa.setCreateTime(currentTime);
		infoQa.setDelFlag(0);
		infoQa.setStateType(1);
	}
	
	@Override
	public void update(InfoQa infoQa ,HttpServletRequest request){
		long currentTime  = new Date().getTime();
		infoQa.setModifyTime(currentTime);
		infoQa.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		infoQa.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		infoQaDao.update(infoQa);
	}
	
	@Override
	public void delete(Long infoQaId){
		infoQaDao.delete(infoQaId);
	}
	
	@Override
	public void deleteBatch(Long[] infoQaIds){
		infoQaDao.deleteBatch(infoQaIds);
	}
	
}

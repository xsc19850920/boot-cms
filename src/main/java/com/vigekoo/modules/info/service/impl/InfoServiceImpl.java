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
import com.vigekoo.modules.info.dao.InfoDao;
import com.vigekoo.modules.info.entity.Info;
import com.vigekoo.modules.info.service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDao infoDao;
	
	@Override
	public Info queryObject(Long infoId){
		return infoDao.queryObject(infoId);
	}
	
	@Override
	public List<Info> queryList(Map<String, Object> map){
		return infoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return infoDao.queryTotal(map);
	}
	
	@Override
	public void save(Info info,HttpServletRequest request){
		initInfo(info, request);
		infoDao.save(info);
	}

	public void initInfo(Info info, HttpServletRequest request) {
		long currentTime  = new Date().getTime();
		info.setModifyTime(currentTime);
		info.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		info.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		info.setInfoId(Long.parseLong(IdGenUtil.get().nextId()));
		info.setCreateTime(currentTime);
		info.setDelFlag(0);
		info.setStateType(1);
		info.setCommentQty(0);
		info.setFavoriteQty(0);
		info.setFlagTop(0);
		info.setShareQty(0);
		info.setStateType(1);
		info.setViewQty(0);
		info.setAuthor(ShiroUtils.getUserEntity().getNickname());
	}
	
	@Override
	public void update(Info info,HttpServletRequest request){
		long currentTime  = new Date().getTime();
		info.setModifyTime(currentTime);
		info.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		infoDao.update(info);
	}
	
	@Override
	public void delete(Long infoId){
		infoDao.delete(infoId);
	}
	
	@Override
	public void deleteBatch(Long[] infoIds){
		infoDao.deleteBatch(infoIds);
	}
	
}

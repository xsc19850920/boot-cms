package com.vigekoo.modules.home.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.home.dao.HomeUpdaterDao;
import com.vigekoo.modules.home.entity.HomeUpdater;
import com.vigekoo.modules.home.service.HomeUpdaterService;

@Service("homeUpdaterService")
public class HomeUpdaterServiceImpl implements HomeUpdaterService {

	@Autowired
	private HomeUpdaterDao homeUpdaterDao;
	
	@Override
	public HomeUpdater queryObject(Long homeUpdaterId){
		return homeUpdaterDao.queryObject(homeUpdaterId);
	}
	
	@Override
	public List<HomeUpdater> queryList(Map<String, Object> map){
		return homeUpdaterDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return homeUpdaterDao.queryTotal(map);
	}
	
	@Override
	public void save(HomeUpdater homeUpdater){
		homeUpdater.setHomeUpdaterId(Long.parseLong(IdGenUtil.get().nextId()));
		homeUpdaterDao.save(homeUpdater);
	}
	
	@Override
	public void update(HomeUpdater homeUpdater){
		homeUpdaterDao.update(homeUpdater);
	}
	
	@Override
	public void delete(Long homeUpdaterId){
		homeUpdaterDao.delete(homeUpdaterId);
	}
	
	@Override
	public void deleteBatch(Long[] homeUpdaterIds){
		homeUpdaterDao.deleteBatch(homeUpdaterIds);
	}
	
}

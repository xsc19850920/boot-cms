package com.vigekoo.modules.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.user.dao.UserStatisticsDao;
import com.vigekoo.modules.user.entity.UserStatistics;
import com.vigekoo.modules.user.service.UserStatisticsService;

@Service("userStatisticsService")
public class UserStatisticsServiceImpl implements UserStatisticsService {

	@Autowired
	private UserStatisticsDao userStatisticsDao;
	
	@Override
	public UserStatistics queryObject(Long userStatisticsId){
		return userStatisticsDao.queryObject(userStatisticsId);
	}
	
	@Override
	public List<UserStatistics> queryList(Map<String, Object> map){
		return userStatisticsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userStatisticsDao.queryTotal(map);
	}
	
	@Override
	public void save(UserStatistics userStatistics){
		userStatistics.setUserStatisticsId(Long.parseLong(IdGenUtil.get().nextId()));
		userStatisticsDao.save(userStatistics);
	}
	
	@Override
	public void update(UserStatistics userStatistics){
		userStatisticsDao.update(userStatistics);
	}
	
	@Override
	public void delete(Long userStatisticsId){
		userStatisticsDao.delete(userStatisticsId);
	}
	
	@Override
	public void deleteBatch(Long[] userStatisticsIds){
		userStatisticsDao.deleteBatch(userStatisticsIds);
	}

	@Override
	public List<UserStatistics> queryListByUserId(String userId) {
		return userStatisticsDao.queryListByUserId(userId);
	}
	
}

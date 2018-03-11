package com.vigekoo.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.vigekoo.modules.user.dao.UserBabyDao;
import com.vigekoo.modules.user.entity.UserBaby;
import com.vigekoo.modules.user.service.UserBabyService;

@Service("userBabyService")
public class UserBabyServiceImpl implements UserBabyService {

	@Autowired
	private UserBabyDao userBabyDao;
	
	@Override
	public UserBaby queryObject(Long userId){
		return userBabyDao.queryObject(userId);
	}
	
	@Override
	public List<UserBaby> queryList(Map<String, Object> map){
		return userBabyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userBabyDao.queryTotal(map);
	}
	
	@Override
	public void save(UserBaby userBaby){
		userBabyDao.save(userBaby);
	}
	
	@Override
	public void update(UserBaby userBaby){
		userBabyDao.update(userBaby);
	}
	
	@Override
	public void delete(Long userId){
		userBabyDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userBabyDao.deleteBatch(userIds);
	}
	
}

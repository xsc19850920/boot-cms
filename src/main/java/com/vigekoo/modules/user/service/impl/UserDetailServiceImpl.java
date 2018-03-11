package com.vigekoo.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.vigekoo.modules.user.dao.UserDetailDao;
import com.vigekoo.modules.user.entity.UserDetail;
import com.vigekoo.modules.user.service.UserDetailService;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailDao userDetailDao;
	
	@Override
	public UserDetail queryObject(Long userId){
		return userDetailDao.queryObject(userId);
	}
	
	@Override
	public List<UserDetail> queryList(Map<String, Object> map){
		return userDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(UserDetail userDetail){
		userDetailDao.save(userDetail);
	}
	
	@Override
	public void update(UserDetail userDetail){
		userDetailDao.update(userDetail);
	}
	
	@Override
	public void delete(Long userId){
		userDetailDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userDetailDao.deleteBatch(userIds);
	}
	
}

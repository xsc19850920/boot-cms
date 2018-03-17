package com.vigekoo.modules.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.user.dao.UserDao;
import com.vigekoo.modules.user.dao.UserDetailDao;
import com.vigekoo.modules.user.entity.User;
import com.vigekoo.modules.user.entity.UserDetail;
import com.vigekoo.modules.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailDao userDetailDao;
	
	@Override
	public User queryObject(Long userId){
		return userDao.queryObject(userId);
	}
	
	@Override
	public List<User> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}
	
	@Override
	public void save(User user){
		user.setUserId(Long.parseLong(IdGenUtil.get().nextId()));
		userDao.save(user);
	}
	
	@Override
	@Transactional
	public void update(User user){
		userDao.update(user);
		//用户详细一起更改
		UserDetail userDetail = userDetailDao.queryObject(user.getUserId());
		if( null != userDetail){
			userDetail.setStateType(user.getStateType());
			userDetailDao.update(userDetail);
		}
	}
	
	@Override
	public void delete(Long userId){
		userDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userDao.deleteBatch(userIds);
	}

	@Override
	public int queryTotalUser() {
		return userDao.queryTotalUser();
	}

	@Override
	public int queryTotalUserToday() {
		// TODO Auto-generated method stub
		return userDao.queryTotalUserToday();
	}
	
}

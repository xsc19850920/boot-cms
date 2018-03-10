package com.vigekoo.modules.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.user.dao.UserDao;
import com.vigekoo.modules.user.entity.User;
import com.vigekoo.modules.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
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
	public void update(User user){
		userDao.update(user);
	}
	
	@Override
	public void delete(Long userId){
		userDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userDao.deleteBatch(userIds);
	}
	
}

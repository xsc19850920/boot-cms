package com.vigekoo.modules.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.user.dao.UserAddressDao;
import com.vigekoo.modules.user.entity.UserAddress;
import com.vigekoo.modules.user.service.UserAddressService;

@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	private UserAddressDao userAddressDao;
	
	@Override
	public UserAddress queryObject(Long userAddressId){
		return userAddressDao.queryObject(userAddressId);
	}
	
	@Override
	public List<UserAddress> queryList(Map<String, Object> map){
		return userAddressDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userAddressDao.queryTotal(map);
	}
	
	@Override
	public void save(UserAddress userAddress){
		userAddress.setUserAddressId(Long.parseLong(IdGenUtil.get().nextId()));
		userAddressDao.save(userAddress);
	}
	
	@Override
	public void update(UserAddress userAddress){
		userAddressDao.update(userAddress);
	}
	
	@Override
	public void delete(Long userAddressId){
		userAddressDao.delete(userAddressId);
	}
	
	@Override
	public void deleteBatch(Long[] userAddressIds){
		userAddressDao.deleteBatch(userAddressIds);
	}
	
}

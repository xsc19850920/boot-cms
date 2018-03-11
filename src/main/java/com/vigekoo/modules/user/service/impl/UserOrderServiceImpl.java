package com.vigekoo.modules.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.user.dao.UserOrderDao;
import com.vigekoo.modules.user.entity.UserOrder;
import com.vigekoo.modules.user.service.UserOrderService;

@Service("userOrderService")
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderDao userOrderDao;
	
	@Override
	public UserOrder queryObject(Long userOrderId){
		return userOrderDao.queryObject(userOrderId);
	}
	
	@Override
	public List<UserOrder> queryList(Map<String, Object> map){
		return userOrderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userOrderDao.queryTotal(map);
	}
	
	@Override
	public void save(UserOrder userOrder){
		userOrder.setUserOrderId(Long.parseLong(IdGenUtil.get().nextId()));
		userOrderDao.save(userOrder);
	}
	
	@Override
	public void update(UserOrder userOrder){
		userOrderDao.update(userOrder);
	}
	
	@Override
	public void delete(Long userOrderId){
		userOrderDao.delete(userOrderId);
	}
	
	@Override
	public void deleteBatch(Long[] userOrderIds){
		userOrderDao.deleteBatch(userOrderIds);
	}
	
}

package com.vigekoo.modules.user.service;

import com.vigekoo.modules.user.entity.UserOrder;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(订单（兑换）)
 * @date 2018-03-11 08:47:19
 */
public interface UserOrderService {
	
	UserOrder queryObject(Long userOrderId);
	
	List<UserOrder> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserOrder userOrder);
	
	void update(UserOrder userOrder);
	
	void delete(Long userOrderId);
	
	void deleteBatch(Long[] userOrderIds);

}

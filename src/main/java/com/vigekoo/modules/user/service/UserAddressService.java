package com.vigekoo.modules.user.service;

import com.vigekoo.modules.user.entity.UserAddress;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(用户_收货地址)
 * @date 2018-03-10 20:51:13
 */
public interface UserAddressService {
	
	UserAddress queryObject(Long userAddressId);
	
	List<UserAddress> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserAddress userAddress);
	
	void update(UserAddress userAddress);
	
	void delete(Long userAddressId);
	
	void deleteBatch(Long[] userAddressIds);

}

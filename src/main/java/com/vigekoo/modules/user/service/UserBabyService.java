package com.vigekoo.modules.user.service;

import com.vigekoo.modules.user.entity.UserBaby;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(用户_宝宝信息)
 * @date 2018-03-11 10:45:11
 */
public interface UserBabyService {
	
	UserBaby queryObject(Long userId);
	
	List<UserBaby> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserBaby userBaby);
	
	void update(UserBaby userBaby);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);

}

package com.vigekoo.modules.user.service;

import com.vigekoo.modules.user.entity.User;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(用户)
 * @date 2018-03-10 14:16:18
 */
public interface UserService {
	
	User queryObject(Long userId);
	
	List<User> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(User user);
	
	void update(User user);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);

}

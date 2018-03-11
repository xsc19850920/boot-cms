package com.vigekoo.modules.user.service;

import com.vigekoo.modules.user.entity.UserDetail;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(用户_详情)
 * @date 2018-03-11 13:46:15
 */
public interface UserDetailService {
	
	UserDetail queryObject(Long userId);
	
	List<UserDetail> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserDetail userDetail);
	
	void update(UserDetail userDetail);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);

}

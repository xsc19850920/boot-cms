package com.vigekoo.modules.user.service;

import com.vigekoo.modules.user.entity.UserStatistics;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(用户统计)
 * @date 2018-03-10 17:09:14
 */
public interface UserStatisticsService {
	
	UserStatistics queryObject(Long operUserId);
	
	List<UserStatistics> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserStatistics userStatistics);
	
	void update(UserStatistics userStatistics);
	
	void delete(Long userStatisticsId);
	
	void deleteBatch(Long[] userStatisticsIds);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<UserStatistics> queryListByUserId(String userId);

}

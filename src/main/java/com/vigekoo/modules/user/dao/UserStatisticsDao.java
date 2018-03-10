package com.vigekoo.modules.user.dao;

import com.vigekoo.modules.user.entity.UserStatistics;
import com.vigekoo.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserStatisticsDao extends BaseDao<UserStatistics> {
	/**
	 * 查询用户的所有菜单ID
	 */
	List<UserStatistics> queryListByUserId(String userId);
}

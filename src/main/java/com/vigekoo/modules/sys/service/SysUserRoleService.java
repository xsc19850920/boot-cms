package com.vigekoo.modules.sys.service;

import java.util.List;

public interface SysUserRoleService {
	
	void saveOrUpdate(String userId, List<String> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<String> queryRoleIdList(String userId);
	
	void delete(String userId);

	void deleteBatch(String[] userIds);

}

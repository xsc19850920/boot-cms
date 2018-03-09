package com.vigekoo.modules.sys.service;

import java.util.List;

public interface SysRoleMenuService {
	
	void saveOrUpdate(String roleId, List<String> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<String> queryMenuIdList(String roleId);

	void deleteBatch(String[] roleIds);
	
}

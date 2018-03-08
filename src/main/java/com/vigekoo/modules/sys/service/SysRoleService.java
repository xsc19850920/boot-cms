package com.vigekoo.modules.sys.service;

import com.vigekoo.modules.sys.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface SysRoleService {
	
	SysRole queryObject(String id);
	
	List<SysRole> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysRole role);
	
	void update(SysRole role);
	
	void deleteBatch(String[] ids);

}

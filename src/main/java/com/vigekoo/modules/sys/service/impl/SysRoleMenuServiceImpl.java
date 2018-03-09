package com.vigekoo.modules.sys.service.impl;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.sys.dao.SysRoleMenuDao;
import com.vigekoo.modules.sys.service.SysRoleMenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	@Transactional
	public void saveOrUpdate(String roleId, List<String> menuIdList) {
		//先删除角色与菜单关系
		sysRoleMenuDao.delete(roleId);

		if(menuIdList.isEmpty()){
			return ;
		}
		Map<String,String> idAndMenuIdMap = new HashMap<String, String>();
		for (String menuId : menuIdList) {
			idAndMenuIdMap.put(IdGenUtil.get().nextId(), menuId);
		}
		//保存角色与菜单关系
		Map<String, Object> map = new HashMap<>();
		map.put("roleId", roleId);
		map.put("idAndMenuIdMap", idAndMenuIdMap);
		sysRoleMenuDao.save(map);
	}

	@Override
	public List<String> queryMenuIdList(String roleId) {
		return sysRoleMenuDao.queryMenuIdList(roleId);
	}

	@Override
	public void deleteBatch(String[] roleIds) {
		sysRoleMenuDao.deleteBatch(roleIds);
	}

}

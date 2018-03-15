package com.vigekoo.modules.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.sys.dao.SysRoleDao;
import com.vigekoo.modules.sys.entity.SysRole;
import com.vigekoo.modules.sys.service.SysRoleMenuService;
import com.vigekoo.modules.sys.service.SysRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	@Autowired
	private SysRoleMenuService sysRoleMenuService;


	@Override
	public SysRole queryObject(String id) {
		return sysRoleDao.queryObject(id);
	}

	@Override
	public List<SysRole> queryList(Map<String, Object> map) {
		return sysRoleDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRoleDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysRole role) {
		role.setCreateTime(new Date());
		role.setId(IdGenUtil.get().nextId());
		sysRoleDao.save(role);
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void update(SysRole role) {
		sysRoleDao.update(role);
		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(String[] ids) {
		sysRoleDao.deleteBatch(ids);
		//删除角色与菜单关系
		sysRoleMenuService.deleteBatch(ids);
	}

}

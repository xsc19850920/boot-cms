package com.vigekoo.modules.sys.service.impl;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.sys.dao.SysUserRoleDao;
import com.vigekoo.modules.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Override
	@Transactional
	public void saveOrUpdate(String userId, List<String> roleIdList) {
		//先删除用户与角色关系
		this.delete(userId);

		if(roleIdList.isEmpty()){
			return ;
		}
		
		//保存用户与角色关系
		Map<String, Object> map = new HashMap<>();
		map.put("id", IdGenUtil.get().nextId());
		map.put("userId", userId);
		map.put("roleIdList", roleIdList);
		sysUserRoleDao.save(map);
	}

	@Override
	public List<String> queryRoleIdList(String userId) {
		return sysUserRoleDao.queryRoleIdList(userId);
	}

	@Override
	@Transactional
	public void delete(String userId) {
		sysUserRoleDao.delete(userId);
	}

	@Override
	public void deleteBatch(String[] userIds) {
		sysUserRoleDao.deleteBatch(userIds);
	}
}

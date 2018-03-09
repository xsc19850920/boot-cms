package com.vigekoo.modules.sys.service;

import com.vigekoo.modules.sys.entity.SysUserToken;

import java.util.Map;

public interface SysUserTokenService {

	SysUserToken queryByUserId(String userId);

	SysUserToken queryByToken(String token);
	
	void save(SysUserToken token);
	
	void update(SysUserToken token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	Map<String, Object> createToken(String userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(String userId);

}

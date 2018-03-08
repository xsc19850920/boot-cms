package com.vigekoo.modules.sys.dao;

import com.vigekoo.modules.sys.entity.SysUserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserToken> {
    
    SysUserToken queryByUserId(String userId);

    SysUserToken queryByToken(String token);
	
}

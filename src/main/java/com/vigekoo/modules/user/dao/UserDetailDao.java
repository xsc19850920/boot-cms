package com.vigekoo.modules.user.dao;

import com.vigekoo.modules.user.entity.UserDetail;
import com.vigekoo.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailDao extends BaseDao<UserDetail> {
	
}

package com.vigekoo.modules.info.dao;

import com.vigekoo.modules.info.entity.Info;
import com.vigekoo.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoDao extends BaseDao<Info> {
	
}

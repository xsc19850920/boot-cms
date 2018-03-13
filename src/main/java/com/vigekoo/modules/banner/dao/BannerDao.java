package com.vigekoo.modules.banner.dao;

import com.vigekoo.modules.banner.entity.Banner;
import com.vigekoo.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerDao extends BaseDao<Banner> {
	
}

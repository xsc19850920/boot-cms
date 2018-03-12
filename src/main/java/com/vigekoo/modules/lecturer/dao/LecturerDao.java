package com.vigekoo.modules.lecturer.dao;

import com.vigekoo.modules.lecturer.entity.Lecturer;
import com.vigekoo.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LecturerDao extends BaseDao<Lecturer> {
	
}

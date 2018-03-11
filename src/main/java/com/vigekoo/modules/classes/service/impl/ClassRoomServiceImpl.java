package com.vigekoo.modules.classes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.classes.dao.ClassRoomDao;
import com.vigekoo.modules.classes.entity.ClassRoom;
import com.vigekoo.modules.classes.service.ClassRoomService;

@Service("classRoomService")
public class ClassRoomServiceImpl implements ClassRoomService {

	@Autowired
	private ClassRoomDao classRoomDao;
	
	@Override
	public ClassRoom queryObject(Long classRoomId){
		return classRoomDao.queryObject(classRoomId);
	}
	
	@Override
	public List<ClassRoom> queryList(Map<String, Object> map){
		return classRoomDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return classRoomDao.queryTotal(map);
	}
	
	@Override
	public void save(ClassRoom classRoom){
		classRoom.setClassRoomId(Long.parseLong(IdGenUtil.get().nextId()));
		classRoomDao.save(classRoom);
	}
	
	@Override
	public void update(ClassRoom classRoom){
		classRoomDao.update(classRoom);
	}
	
	@Override
	public void delete(Long classRoomId){
		classRoomDao.delete(classRoomId);
	}
	
	@Override
	public void deleteBatch(Long[] classRoomIds){
		classRoomDao.deleteBatch(classRoomIds);
	}
	
}

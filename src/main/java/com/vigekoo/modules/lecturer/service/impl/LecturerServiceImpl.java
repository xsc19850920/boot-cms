package com.vigekoo.modules.lecturer.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.lecturer.dao.LecturerDao;
import com.vigekoo.modules.lecturer.entity.Lecturer;
import com.vigekoo.modules.lecturer.service.LecturerService;

@Service("lecturerService")
public class LecturerServiceImpl implements LecturerService {

	@Autowired
	private LecturerDao lecturerDao;
	
	@Override
	public Lecturer queryObject(Long lecturerId){
		return lecturerDao.queryObject(lecturerId);
	}
	
	@Override
	public List<Lecturer> queryList(Map<String, Object> map){
		return lecturerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return lecturerDao.queryTotal(map);
	}
	
	@Override
	public void save(Lecturer lecturer,HttpServletRequest request){
		initLecturer(lecturer, request);
		lecturerDao.save(lecturer);
	}

	
	@Override
	public void update(Lecturer lecturer){
		lecturerDao.update(lecturer);
	}
	
	@Override
	public void delete(Long lecturerId){
		lecturerDao.delete(lecturerId);
	}
	
	@Override
	public void deleteBatch(Long[] lecturerIds){
		lecturerDao.deleteBatch(lecturerIds);
	}
	
	public void initLecturer(Lecturer lecturer, HttpServletRequest request) {
		long currentTime  = new Date().getTime();
		lecturer.setLecturerId(Long.parseLong(IdGenUtil.get().nextId()));
		lecturer.setCreateTime(currentTime);
		lecturer.setDelFlag(0);
		lecturer.setModifyTime(currentTime);
		lecturer.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		lecturer.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		lecturer.setStateType(1);
	}
	
}

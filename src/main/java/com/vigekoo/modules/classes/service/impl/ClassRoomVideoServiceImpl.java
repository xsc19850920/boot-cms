package com.vigekoo.modules.classes.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.classes.dao.ClassRoomVideoDao;
import com.vigekoo.modules.classes.entity.ClassRoomVideo;
import com.vigekoo.modules.classes.service.ClassRoomVideoService;

@Service("classRoomVideoService")
public class ClassRoomVideoServiceImpl implements ClassRoomVideoService {

	@Autowired
	private ClassRoomVideoDao classRoomVideoDao;
	
	@Override
	public ClassRoomVideo queryObject(Long classRoomVideoId){
		return classRoomVideoDao.queryObject(classRoomVideoId);
	}
	
	@Override
	public List<ClassRoomVideo> queryList(Map<String, Object> map){
		return classRoomVideoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return classRoomVideoDao.queryTotal(map);
	}
	
	@Override
	public void save(ClassRoomVideo classRoomVideo,HttpServletRequest request){
		initClassRoomVideo(classRoomVideo,request);
		classRoomVideoDao.save(classRoomVideo);
	}
	
	@Override
	public void update(ClassRoomVideo classRoomVideo){
		classRoomVideoDao.update(classRoomVideo);
	}
	
	@Override
	public void delete(Long classRoomVideoId){
		classRoomVideoDao.delete(classRoomVideoId);
	}
	
	@Override
	public void deleteBatch(Long[] classRoomVideoIds){
		classRoomVideoDao.deleteBatch(classRoomVideoIds);
	}
	
	
	public void initClassRoomVideo(ClassRoomVideo classRoomVideo, HttpServletRequest request) {
		long currentTime  = new Date().getTime();
		classRoomVideo.setClassRoomVideoId(Long.parseLong(IdGenUtil.get().nextId()));
		classRoomVideo.setCreateTime(currentTime);
		classRoomVideo.setDelFlag(0);
		classRoomVideo.setDisplayOrder(0);
		classRoomVideo.setDuration(0);
		classRoomVideo.setDurationText("01:10:20");
		classRoomVideo.setModifyTime(currentTime);
		classRoomVideo.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		classRoomVideo.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		classRoomVideo.setStateType(1);
		classRoomVideo.setViewQty(0);
		
		
	}
	
}

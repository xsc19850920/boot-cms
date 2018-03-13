package com.vigekoo.modules.classes.service;

import com.vigekoo.modules.classes.entity.ClassRoomVideo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(绘画启蒙课堂视频)
 * @date 2018-03-13 09:07:48
 */
public interface ClassRoomVideoService {
	
	ClassRoomVideo queryObject(Long classRoomVideoId);
	
	List<ClassRoomVideo> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	
	void update(ClassRoomVideo classRoomVideo);
	
	void delete(Long classRoomVideoId);
	
	void deleteBatch(Long[] classRoomVideoIds);

	void save(ClassRoomVideo classRoomVideo, HttpServletRequest request);

}

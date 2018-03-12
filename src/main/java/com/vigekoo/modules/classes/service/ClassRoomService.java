package com.vigekoo.modules.classes.service;

import com.vigekoo.modules.classes.entity.ClassRoom;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(绘画启蒙课堂)
 * @date 2018-03-11 17:52:30
 */
public interface ClassRoomService {
	
	ClassRoom queryObject(Long classRoomId);
	
	List<ClassRoom> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void update(ClassRoom classRoom);
	
	void delete(Long classRoomId);
	
	void deleteBatch(Long[] classRoomIds);

	void save(ClassRoom classRoom, HttpServletRequest request);

}

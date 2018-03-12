package com.vigekoo.modules.lecturer.service;

import com.vigekoo.modules.lecturer.entity.Lecturer;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(讲师)
 * @date 2018-03-12 19:40:41
 */
public interface LecturerService {
	
	Lecturer queryObject(Long lecturerId);
	
	List<Lecturer> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void update(Lecturer lecturer);
	
	void delete(Long lecturerId);
	
	void deleteBatch(Long[] lecturerIds);

	void save(Lecturer lecturer, HttpServletRequest request);

}

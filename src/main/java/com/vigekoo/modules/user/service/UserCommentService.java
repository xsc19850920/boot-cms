package com.vigekoo.modules.user.service;

import com.vigekoo.modules.user.entity.UserComment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(用户_评论)
 * @date 2018-03-15 10:40:47
 */
public interface UserCommentService {
	
	UserComment queryObject(Long userCommentId);
	
	List<UserComment> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserComment userComment,HttpServletRequest request);
	
	void update(UserComment userComment,HttpServletRequest request);
	
	void delete(Long userCommentId);
	
	void deleteBatch(Long[] userCommentIds);

}

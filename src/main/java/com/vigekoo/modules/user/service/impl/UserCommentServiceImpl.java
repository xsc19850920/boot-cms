package com.vigekoo.modules.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.user.dao.UserCommentDao;
import com.vigekoo.modules.user.entity.UserComment;
import com.vigekoo.modules.user.service.UserCommentService;

@Service("userCommentService")
public class UserCommentServiceImpl implements UserCommentService {

	@Autowired
	private UserCommentDao userCommentDao;
	
	@Override
	public UserComment queryObject(Long userCommentId){
		return userCommentDao.queryObject(userCommentId);
	}
	
	@Override
	public List<UserComment> queryList(Map<String, Object> map){
		return userCommentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userCommentDao.queryTotal(map);
	}
	
	@Override
	public void save(UserComment userComment,HttpServletRequest request){
		userComment.setUserCommentId(Long.parseLong(IdGenUtil.get().nextId()));
		userCommentDao.save(userComment);
	}
	
	@Override
	public void update(UserComment userComment,HttpServletRequest request){
		userCommentDao.update(userComment);
	}
	
	@Override
	public void delete(Long userCommentId){
		userCommentDao.delete(userCommentId);
	}
	
	@Override
	public void deleteBatch(Long[] userCommentIds){
		userCommentDao.deleteBatch(userCommentIds);
	}
	
}

package com.vigekoo.modules.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigekoo.common.shiro.TokenGenerator;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.api.utils.JwtUtils;
import com.vigekoo.modules.sys.dao.SysUserTokenDao;
import com.vigekoo.modules.sys.entity.SysUserToken;
import com.vigekoo.modules.sys.redis.SysUserTokenRedis;
import com.vigekoo.modules.sys.service.SysUserTokenService;

@Service("sysUserTokenService")
public class SysUserTokenServiceImpl implements SysUserTokenService {

	@Autowired
	private SysUserTokenDao sysUserTokenDao;

	@Autowired
	private SysUserTokenRedis sysUserTokenRedis;
	
	@Autowired
    private JwtUtils jwtUtils;
	
	//24小时后过期
	private final static int EXPIRE = 86400;

	@Override
	public SysUserToken queryByUserId(String userId) {
		SysUserToken sysUserToken=sysUserTokenRedis.get(userId);
		if(sysUserToken==null){
			sysUserToken=sysUserTokenDao.queryByUserId(userId);
			sysUserTokenRedis.saveOrUpdate(sysUserToken);
		}
		return sysUserToken;
	}

	@Override
	public SysUserToken queryByToken(String token) {
		SysUserToken sysUserToken=sysUserTokenRedis.get(token);
		if(sysUserToken==null){
			sysUserToken=sysUserTokenDao.queryByToken(token);
			sysUserTokenRedis.saveOrUpdate(sysUserToken);
		}
		return sysUserToken;
	}

	@Override
	@Transactional
	public void save(SysUserToken token){
		token.setId(IdGenUtil.get().nextId());
		sysUserTokenDao.save(token);
		sysUserTokenRedis.saveOrUpdate(token);
	}

	@Override
	@Transactional
	public void update(SysUserToken token){
		sysUserTokenRedis.delete(token);
		sysUserTokenDao.update(token);
	}

	@Override
	public Map<String, Object> createToken(String userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();
		
//		String token =  jwtUtils.generateToken(userId);
		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		SysUserToken tokenEntity = queryByUserId(userId);
		if(tokenEntity == null){
			tokenEntity = new SysUserToken();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			save(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			update(tokenEntity);
		}

		Map<String, Object> result = new HashMap<>();
		result.put("token", token);
		result.put("userId", userId);
		result.put("expire", EXPIRE);
		return result;
	}

	@Override
	public void logout(String userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();
//		String token =  jwtUtils.generateToken(userId);
		//修改token
		SysUserToken tokenEntity = new SysUserToken();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		update(tokenEntity);
	}

}

package com.vigekoo.modules.info.service;

import com.vigekoo.modules.info.entity.Info;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(信息)
 * @date 2018-03-13 21:15:21
 */
public interface InfoService {
	
	Info queryObject(Long infoId);
	
	List<Info> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Info info,HttpServletRequest request);
	
	void update(Info info,HttpServletRequest request);
	
	void delete(Long infoId);
	
	void deleteBatch(Long[] infoIds,HttpServletRequest request);

}

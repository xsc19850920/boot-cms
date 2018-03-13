package com.vigekoo.modules.info.service;

import com.vigekoo.modules.info.entity.InfoPregnancyCheck;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(产检信息)
 * @date 2018-03-13 20:35:37
 */
public interface InfoPregnancyCheckService {
	
	InfoPregnancyCheck queryObject(Long infoPregnancyCheckId);
	
	List<InfoPregnancyCheck> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InfoPregnancyCheck infoPregnancyCheck, HttpServletRequest request);
	
	void update(InfoPregnancyCheck infoPregnancyCheck, HttpServletRequest request);
	
	void delete(Long infoPregnancyCheckId);
	
	void deleteBatch(Long[] infoPregnancyCheckIds);

}

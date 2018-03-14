package com.vigekoo.modules.info.service;

import com.vigekoo.modules.info.entity.InfoQa;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(一问一答)
 * @date 2018-03-14 20:17:57
 */
public interface InfoQaService {
	
	InfoQa queryObject(Long infoQaId);
	
	List<InfoQa> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InfoQa infoQa,HttpServletRequest request);
	
	void update(InfoQa infoQa,HttpServletRequest request);
	
	void delete(Long infoQaId);
	
	void deleteBatch(Long[] infoQaIds);

}

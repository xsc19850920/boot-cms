package com.vigekoo.modules.home.service;

import com.vigekoo.modules.home.entity.HomeUpdater;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(首页更新内容)
 * @date 2018-03-16 10:20:12
 */
public interface HomeUpdaterService {
	
	HomeUpdater queryObject(Long homeUpdaterId);
	
	List<HomeUpdater> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HomeUpdater homeUpdater);
	
	void update(HomeUpdater homeUpdater);
	
	void delete(Long homeUpdaterId);
	
	void deleteBatch(Long[] homeUpdaterIds);

}

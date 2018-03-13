package com.vigekoo.modules.banner.service;

import com.vigekoo.modules.banner.entity.Banner;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sxia
 * @Description: TODO(轮播图)
 * @date 2018-03-13 10:40:07
 */
public interface BannerService {
	
	Banner queryObject(Long bannerId);
	
	List<Banner> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void update(Banner banner);
	
	void delete(Long bannerId);
	
	void deleteBatch(Long[] bannerIds);

	void save(Banner banner, HttpServletRequest request);

}

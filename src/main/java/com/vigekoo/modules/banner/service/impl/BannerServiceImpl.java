package com.vigekoo.modules.banner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.banner.dao.BannerDao;
import com.vigekoo.modules.banner.entity.Banner;
import com.vigekoo.modules.banner.service.BannerService;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerDao bannerDao;
	
	@Override
	public Banner queryObject(Long bannerId){
		return bannerDao.queryObject(bannerId);
	}
	
	@Override
	public List<Banner> queryList(Map<String, Object> map){
		return bannerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bannerDao.queryTotal(map);
	}
	
	@Override
	public void save(Banner banner,HttpServletRequest request){
		initBanner(banner,request);
		bannerDao.save(banner);
	}
	
	private void initBanner(Banner banner, HttpServletRequest request) {
		long time  = new Date().getTime();
		banner.setBannerId(Long.parseLong(IdGenUtil.get().nextId()));
		banner.setBannerType(0);
		banner.setBannerTypeId(0l);
		banner.setDelFlag(0);
		banner.setModifyTime(time);
		banner.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		banner.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		banner.setCreateTime(time);
		banner.setViewQty(0);
		banner.setStateType(1);
	}

	@Override
	public void update(Banner banner){
		bannerDao.update(banner);
	}
	
	@Override
	public void delete(Long bannerId){
		bannerDao.delete(bannerId);
	}
	
	@Override
	public void deleteBatch(Long[] bannerIds){
		bannerDao.deleteBatch(bannerIds);
	}
	
}

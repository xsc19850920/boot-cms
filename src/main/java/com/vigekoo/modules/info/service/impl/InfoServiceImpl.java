package com.vigekoo.modules.info.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.category.dao.CategoryDao;
import com.vigekoo.modules.category.entity.Category;
import com.vigekoo.modules.info.dao.InfoDao;
import com.vigekoo.modules.info.entity.Info;
import com.vigekoo.modules.info.service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDao infoDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Info queryObject(Long infoId){
		return infoDao.queryObject(infoId);
	}
	
	@Override
	public List<Info> queryList(Map<String, Object> map){
		return infoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return infoDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(Info info,HttpServletRequest request){
		long currentTime  = new Date().getTime();
		initInfo(info, currentTime,request);
		infoDao.save(info);
		
		//添加 文章信息（info表）的时候，要更新类别表（category）的memo字段，更新的内容是：yyyy-mm-dd|信息标题
		Category category = categoryDao.queryObject(info.getCategoryId());
		category.setMemo(DateFormatUtils.format(new Date(), "yyyy-MM-dd") + "|" + info.getTitle());
		category.setInfoQty(category.getInfoQty() + 1);
		category.setModifyTime(currentTime);
		category.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		category.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		categoryDao.update(category);
	}

	public void initInfo(Info info,long currentTime, HttpServletRequest request) {
		
		info.setModifyTime(currentTime);
		info.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		info.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		info.setInfoId(Long.parseLong(IdGenUtil.get().nextId()));
		info.setCreateTime(currentTime);
		info.setDelFlag(0);
		info.setStateType(1);
		info.setCommentQty(0);
		info.setFavoriteQty(0);
		info.setFlagTop(0);
		info.setShareQty(0);
		info.setStateType(1);
		info.setViewQty(0);
//		info.setIntro("");
//		info.setAuthor(ShiroUtils.getUserEntity().getNickname());
	}
	
	@Override
	public void update(Info info,HttpServletRequest request){
		long currentTime  = new Date().getTime();
		
		Long infoId = info.getInfoId();
		Info infoFromDB = infoDao.queryObject(infoId);
		//这个商品原来的分类下产品数量-1 最小0
		Category oldCategory = categoryDao.queryObject(infoFromDB.getCategoryId());
//		oldCcategory.setMemo(DateFormatUtils.format(new Date(), "yyyy-MM-dd") + "|" + info.getTitle());
		oldCategory.setInfoQty((oldCategory.getInfoQty() -1 >= 0) ? oldCategory.getInfoQty() -1  : 0);
		oldCategory.setModifyTime(currentTime);
		oldCategory.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		oldCategory.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		categoryDao.update(oldCategory);
		
		//更新商品信息
		info.setModifyTime(currentTime);
		info.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		infoDao.update(info);
		
		//这个商品新的分类下产品数量+1
		Category category = categoryDao.queryObject(info.getCategoryId());
		category.setMemo(DateFormatUtils.format(new Date(), "yyyy-MM-dd") + "|" + info.getTitle());
		category.setInfoQty(category.getInfoQty() + 1);
		category.setModifyTime(currentTime);
		category.setOperIp(IPUtils.Ip2Int(IPUtils.getIpAddr(request)));
		category.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
		categoryDao.update(category);
	}
	
	@Override
	public void delete(Long infoId){
		infoDao.delete(infoId);
	}
	
	@Override
	public void deleteBatch(Long[] infoIds){
		infoDao.deleteBatch(infoIds);
	}
	
}

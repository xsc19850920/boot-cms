package com.vigekoo.modules.product.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.home.dao.HomeUpdaterDao;
import com.vigekoo.modules.home.entity.HomeUpdater;
import com.vigekoo.modules.product.dao.ProductDao;
import com.vigekoo.modules.product.entity.Product;
import com.vigekoo.modules.product.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private HomeUpdaterDao homeUpdaterDao;
	
	@Override
	public Product queryObject(Long productId){
		return productDao.queryObject(productId);
	}
	
	@Override
	public List<Product> queryList(Map<String, Object> map){
		return productDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return productDao.queryTotal(map);
	}
	
	@Override
	public void save(Product product){
		product.setProductId(Long.parseLong(IdGenUtil.get().nextId()));
		productDao.save(product);
	}
	
	@Override
	public void update(Product product){
		productDao.update(product);
		
		if(product.getHotFlag().equals(1)){
			
			Product productFromDb = productDao.queryObject(product.getProductId());
		
	//		更新 产品表的推荐（热门）标识，如果是推荐状态，则把信息添加到home_updater表
			long time = new Date().getTime();
			HomeUpdater homeUpdater = new HomeUpdater();
			homeUpdater.setCreateTime(time);
			homeUpdater.setOperIp(IPUtils.Ip2Int(IPUtils.getLocalIP()));
			homeUpdater.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
			homeUpdater.setDelFlag(0);
			homeUpdater.setHomeUpdaterId(Long.parseLong(IdGenUtil.get().nextId()));
			homeUpdater.setHomeUpdaterType(2); //更新内容类型(1音频 2产品) : 1音频 2产品
			homeUpdater.setModifyTime(time);
			homeUpdater.setUpdaterInfoId(NumberUtils.createLong(productFromDb.getProductId().toString()));
			homeUpdater.setUpdaterInfoImagePath(productFromDb.getImagePath());
			homeUpdater.setUpdaterInfoTitle(productFromDb.getTitle());
			homeUpdater.setUpdaterInfoType(0);//更新内容信息类型 : 1早安童诗 2晚安故事 3特色绘本 4古典音乐 0产品无分类
			homeUpdaterDao.save(homeUpdater);
		}
	}
	
	@Override
	public void delete(Long productId){
		productDao.delete(productId);
	}
	
	@Override
	public void deleteBatch(Long[] productIds){
		productDao.deleteBatch(productIds);
	}
	
}

package com.vigekoo.modules.product.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vigekoo.common.exception.AppException;
import com.vigekoo.common.utils.BOSUtil;
import com.vigekoo.common.utils.IPUtils;
import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.common.utils.OkHttpUtils;
import com.vigekoo.common.utils.ShiroUtils;
import com.vigekoo.modules.home.dao.HomeUpdaterDao;
import com.vigekoo.modules.home.entity.HomeUpdater;
import com.vigekoo.modules.product.dao.ProductDao;
import com.vigekoo.modules.product.entity.Product;
import com.vigekoo.modules.product.entity.ResultFromAPI;
import com.vigekoo.modules.product.entity.TypeEnumForParseAPI;
import com.vigekoo.modules.product.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductDao productDao;

	@Autowired
	private HomeUpdaterDao homeUpdaterDao;

	// @Value("api.url")
	// private String apiUrl;

	@Override
	public Product queryObject(Long productId) {
		return productDao.queryObject(productId);
	}

	@Override
	public List<Product> queryList(Map<String, Object> map) {
		return productDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return productDao.queryTotal(map);
	}

	@Override
	public void save(Product product) {
		product.setProductId(Long.parseLong(IdGenUtil.get().nextId()));
		productDao.save(product);
	}

	@Override
	@Transactional
	public void update(Product product) {
		productDao.update(product);

		if (product.getHotFlag().equals(1)) {

			Product productFromDb = productDao.queryObject(product.getProductId());

			// 更新 产品表的推荐（热门）标识，如果是推荐状态，则把信息添加到home_updater表
			long time = new Date().getTime();
			HomeUpdater homeUpdater = new HomeUpdater();
			homeUpdater.setCreateTime(time);
			homeUpdater.setOperIp(IPUtils.Ip2Int(IPUtils.getLocalIP()));
			homeUpdater.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));
			homeUpdater.setDelFlag(0);
			homeUpdater.setHomeUpdaterId(Long.parseLong(IdGenUtil.get().nextId()));
			homeUpdater.setHomeUpdaterType(2); // 更新内容类型(1音频 2产品) : 1音频 2产品
			homeUpdater.setModifyTime(time);
			homeUpdater.setUpdaterInfoId(NumberUtils.createLong(productFromDb.getProductId().toString()));
			homeUpdater.setUpdaterInfoImagePath(productFromDb.getImagePath());
			homeUpdater.setUpdaterInfoTitle(productFromDb.getTitle());
			homeUpdater.setUpdaterInfoType(0);// 更新内容信息类型 : 1早安童诗 2晚安故事 3特色绘本
												// 4古典音乐 0产品无分类
			homeUpdaterDao.save(homeUpdater);
		}

		if (product.getHotFlag().equals(0)) {
			// 取消推荐
			HomeUpdater homeUpdaterFromDb = homeUpdaterDao.findByProductId(product.getProductId());
			if (null != homeUpdaterFromDb) {
				homeUpdaterDao.delete(homeUpdaterFromDb.getHomeUpdaterId());
			}
		}
	}

	@Override
	public void delete(Long productId) {
		productDao.delete(productId);
	}

	@Override
	public void deleteBatch(Long[] productIds) {
		productDao.deleteBatch(productIds);
	}
	
	/**
	 * 商品信息同步
	 */
	@Override
	public void syncProductInfo() {
		List<ResultFromAPI> list = null;
        
		// step 1 : get product data from API
		JSONObject cmdparam = new JSONObject();
		cmdparam.put("table", 23180);
		cmdparam.put("start", 1);
		cmdparam.put("range", 99999);
		cmdparam.put("count", true);
		
		JSONObject params = new JSONObject();
        params.put("column", "ISACTIVE");
        params.put("condition", "=Y");
        cmdparam.put("params", params);
        
		HashMap<String, Object> hm = BOSUtil.getCMDParams("Query", cmdparam);

		String response = OkHttpUtils.get("http://106.14.57.1:120/servlets/binserv/Rest", hm);
		if (StringUtils.isNotBlank(response)) {

			try {
				list = JSONArray.parseArray(response, ResultFromAPI.class);
				for (ResultFromAPI resultFromAPI : list) {
					resultFromAPI.setProductList(resultFromAPI.getRows(), TypeEnumForParseAPI.INFO);
				}
			} catch (Exception e) {
				logger.error("同步产品信息出错: " + e.getMessage());
			}
		}
		//
		if (CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(list.stream().findFirst().get().getProductList())) {
			logger.error("同步产品信息出错.");
			throw new AppException("同步产品信息出错.");
		}
		List<Product> productListFromAPI = list.get(0).getProductList();

		// step 2 : get all exist product data from system db
		List<Product> productListFromDB = productDao.queryAllObject();
		// step 3 : merge all api data to system db

		for (Product productFromAPI : productListFromAPI) {
			boolean updateFlag = false;

			for (Product productFromDB : productListFromDB) {
				if (productFromDB.getProductCode().equals(productFromAPI.getProductCode())) {
					productFromAPI.setProductId(productFromDB.getProductId()); // set
																				// product
																				// id
					updateFlag = true;
					break;
				}
			}

			long time = new Date().getTime();
			productFromAPI.setModifyTime(time);
			productFromAPI.setOperIp(IPUtils.Ip2Int(IPUtils.getLocalIP()));
			productFromAPI.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));

			if (updateFlag) { // update
				productDao.update(productFromAPI);
			} else { // insert

				productFromAPI.setCreateTime(time);
				productFromAPI.setDelFlag(0);
				productFromAPI.setHotFlag(0);
				productFromAPI.setHotOrder(0);
				productFromAPI.setImagePath("");
				productFromAPI.setImagePathMult("");
				productFromAPI.setInventoryQty(0);
				productFromAPI.setLookQty(0);
				productFromAPI.setOrderQty(0);
				productFromAPI.setProductId(Long.parseLong(IdGenUtil.get().nextId()));
				productFromAPI.setStateType(1);
				productFromAPI.setTopFlag(0);
				productFromAPI.setTopOrder(0);
				productDao.save(productFromAPI);
			}
		}

	}

	/**
	 * 库存同步
	 */
	@Override
	public void syncInventoryQty() {
		List<ResultFromAPI> list = null;

		// step 1 : get product data from API
		JSONObject cmdparam = new JSONObject();
		cmdparam.put("table", 23181);
		cmdparam.put("start", 1);
		cmdparam.put("range", 99999);
		cmdparam.put("count", true);
		
		JSONObject params = new JSONObject();
        params.put("column", "ISACTIVE");
        params.put("condition", "=Y");
        cmdparam.put("params", params);
        
		HashMap<String, Object> hm = BOSUtil.getCMDParams("Query", cmdparam);

		String response = OkHttpUtils.get("http://106.14.57.1:120/servlets/binserv/Rest", hm);
		if (StringUtils.isNotBlank(response)) {

			try {
				list = JSONArray.parseArray(response, ResultFromAPI.class);
				for (ResultFromAPI resultFromAPI : list) {
					resultFromAPI.setProductList(resultFromAPI.getRows(), TypeEnumForParseAPI.INVENTORY);
				}
			} catch (Exception e) {
				logger.error("同步库存信息出错: " + e.getMessage());
			}
		}
		if (CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(list.stream().findFirst().get().getProductList())) {
			logger.error("同步库存信息出错.");
			throw new AppException("同步库存信息出错.");
		}
		List<Product> productListFromAPI = list.get(0).getProductList();
		// step 2 : get all exist product data from system db
		List<Product> productListFromDB = productDao.queryAllObject();
		// step 3 : merge all api data to system db

		for (Product productFromAPI : productListFromAPI) {
			boolean updateFlag = false;

			for (Product productFromDB : productListFromDB) {
				if (productFromDB.getProductCode().equals(productFromAPI.getProductCode())) {
					productFromAPI.setProductId(productFromDB.getProductId()); 
					updateFlag = true;
					break;
				}
			}

			long time = new Date().getTime();
			productFromAPI.setModifyTime(time);
			productFromAPI.setOperIp(IPUtils.Ip2Int(IPUtils.getLocalIP()));
			productFromAPI.setOperUserId(Long.parseLong(ShiroUtils.getUserId()));

			if (updateFlag) { // update
				productDao.update(productFromAPI);
			} else { // insert

				//待确认，是否更新库存的时候，当前系统数据库中没有的记录是否创建
//				productFromAPI.setCreateTime(time);
//				productFromAPI.setDelFlag(0);
//				productFromAPI.setHotFlag(0);
//				productFromAPI.setHotOrder(0);
//				productFromAPI.setImagePath("");
//				productFromAPI.setImagePathMult("");
//				productFromAPI.setLookQty(0);
//				productFromAPI.setOrderQty(0);
//				productFromAPI.setProductId(Long.parseLong(IdGenUtil.get().nextId()));
//				productFromAPI.setStateType(1);
//				productFromAPI.setTopFlag(0);
//				productFromAPI.setTopOrder(0);
//				
//				
//				productFromAPI.setTitle(title);
//				productFromAPI.setPriceText(priceText);
//				productFromAPI.setDetail(detail);
//				productFromAPI.setPoints(points);
				
//				productDao.save(productFromAPI);
			}
		}

	}

}

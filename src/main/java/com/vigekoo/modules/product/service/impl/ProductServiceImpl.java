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
import org.springframework.beans.factory.annotation.Value;
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
import com.vigekoo.modules.product.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private HomeUpdaterDao homeUpdaterDao;
	
	@Value("api.url")
	private String apiUrl;
	
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
	@Transactional
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
		
		
		if(product.getHotFlag().equals(0)){ 
	//		取消推荐
			HomeUpdater homeUpdaterFromDb = homeUpdaterDao.findByProductId(product.getProductId());
			if(null != homeUpdaterFromDb){
				homeUpdaterDao.delete(homeUpdaterFromDb.getHomeUpdaterId());
			}
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
	
	@Override
	public void importDataFromAPI(){
		List<ResultFromAPI> list  = null;
		
		
		// step 1 : get product data from API
		JSONObject cmdparam = new JSONObject();
        cmdparam.put("table", 23180);
        cmdparam.put("start", 1);
        cmdparam.put("range", 99999);
        cmdparam.put("count", true);
        HashMap<String, Object> hm = BOSUtil.getCMDParams("Query", cmdparam);
        
        String response = OkHttpUtils.get("http://106.14.57.1:120/servlets/binserv/Rest", hm);
        if (StringUtils.isNotBlank(response)) {
        	
            try {
            	 list = JSONArray.parseArray(response, ResultFromAPI.class);
            	for (ResultFromAPI resultFromAPI : list) {
            		resultFromAPI.setProductList(resultFromAPI.getRows());
				}
            } catch (Exception e) {
            	logger.error("同步产品信息出错: " + e.getMessage());
            }
        }
        // 
        List<Product> productListFromAPI = list.get(0).getProductList();
        if(CollectionUtils.isEmpty(productListFromAPI)){
        	logger.error("可以同步的产品数量为0." );
        	throw new AppException("可以同步的产品数量为0.");
        }
        
        
        //step 2 : get all exist product  data from system db
       List<Product> productListFromDB = productDao.queryAllObject();
        // step 3 : merge all api data to system db
       //step 3.1 find product need to update
       
       
	}
	
}

package com.vigekoo.modules.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigekoo.common.utils.IdGenUtil;
import com.vigekoo.modules.product.dao.ProductDao;
import com.vigekoo.modules.product.entity.Product;
import com.vigekoo.modules.product.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
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

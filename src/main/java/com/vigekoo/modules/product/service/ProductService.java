package com.vigekoo.modules.product.service;

import com.vigekoo.modules.product.entity.Product;
import java.util.List;
import java.util.Map;

/**
 * @author sxia
 * @Description: TODO(产品)
 * @date 2018-03-11 08:55:49
 */
public interface ProductService {
	
	Product queryObject(Long productId);
	
	List<Product> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Product product);
	
	void update(Product product);
	
	void delete(Long productId);
	
	void deleteBatch(Long[] productIds);

}

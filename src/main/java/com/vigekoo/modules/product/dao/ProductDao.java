package com.vigekoo.modules.product.dao;

import com.vigekoo.modules.product.entity.Product;
import com.vigekoo.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseDao<Product> {
	List<Product> queryAllObject();
}

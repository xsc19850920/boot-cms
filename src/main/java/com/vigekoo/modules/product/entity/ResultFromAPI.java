package com.vigekoo.modules.product.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultFromAPI {
	private int  code;
	private int  count;
	private String id;
	private String message;
	private List<Product> productList;
	private List<String> rows;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<String> strList,TypeEnumForParseAPI type ) {
		List<Product> productFromAPIList = new ArrayList<Product>();
		for (String str : strList) {
			//去掉[] 和双引号
			str = str.substring(1, str.length()-1).replaceAll("\"", "");
			productFromAPIList.add(new Product(str.split(","),type));
		}
		this.productList = productFromAPIList;
	}
	public List<String> getRows() {
		return rows;
	}
	public void setRows(List<String> rows) {
		this.rows = rows;
	}
	
	
	
}
package com.vigekoo.modules.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductFromAPI implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品编号
	 */
	private String pdtCode;
	/**
	 * 商品名称
	 */
	private String value;
	/**
	 * 单价
	 */
	private BigDecimal priceList;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 商品详细介绍
	 */
	private String marketdes;
	/**
	 * 写入时间
	 */
	private Date writeTime;
	/**
	 * 提取时间
	 */
	private Date readTime;
	/**
	 * 接口标记
	 */
	private int ediflag;
	/**
	 * 问题原因
	 */
	private String results;
	/**
	 * 创建人
	 */
	private String ownerId;
	/**
	 * 修改人
	 */
	private String modifierId;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 修改时间
	 */
	private Date modifiedDate;
	/**
	 * 是否可用
	 */
	private String isActive;
	public String getPdtCode() {
		return pdtCode;
	}
	public void setPdtCode(String pdtCode) {
		this.pdtCode = pdtCode;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public BigDecimal getPriceList() {
		return priceList;
	}
	public void setPriceList(BigDecimal priceList) {
		this.priceList = priceList;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getMarketdes() {
		return marketdes;
	}
	public void setMarketdes(String marketdes) {
		this.marketdes = marketdes;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	public Date getReadTime() {
		return readTime;
	}
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	public int getEdiflag() {
		return ediflag;
	}
	public void setEdiflag(int ediflag) {
		this.ediflag = ediflag;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getModifierId() {
		return modifierId;
	}
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}

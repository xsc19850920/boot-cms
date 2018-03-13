package com.vigekoo.modules.banner.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(轮播图)
 * @date 2018-03-13 10:40:07
 */
public class Banner implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//添加时间
	@JSONField(serializeUsing= DateCodec.class)
	private Long createTime;
	//更新时间
	@JSONField(serializeUsing= DateCodec.class)
	private Long modifyTime;
	//操作ip
	private Integer operIp;
	//操作用户id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long operUserId;
	//删除标识
	private Integer delFlag;
	//轮播图id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long bannerId;
	//标题
	private String title;
	//类别 : 1首页 2妈妈知道
	private Integer bannerCategory;
	//图片路径
	private String imagePath;
	//url链接
	private String urlLink;
	//类型
	private Integer bannerType;
	
	//类型
	private Integer displayOrder;
	//类型id
	private Long bannerTypeId;
	//开始时间
	@JSONField(serializeUsing= DateCodec.class)
	private Long startTime;
	//结束时间
	@JSONField(serializeUsing= DateCodec.class)
	private Long endTime;
	//查看次数
	private Integer viewQty;
	//状态类型 : 0未处_无效 1已处_有效
	private Integer stateType;

	/**
	 * 设置：添加时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Long getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Long getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：操作ip
	 */
	public void setOperIp(Integer operIp) {
		this.operIp = operIp;
	}
	/**
	 * 获取：操作ip
	 */
	public Integer getOperIp() {
		return operIp;
	}
	/**
	 * 设置：操作用户id
	 */
	public void setOperUserId(Long operUserId) {
		this.operUserId = operUserId;
	}
	/**
	 * 获取：操作用户id
	 */
	public Long getOperUserId() {
		return operUserId;
	}
	/**
	 * 设置：删除标识
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标识
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：轮播图id
	 */
	public void setBannerId(Long bannerId) {
		this.bannerId = bannerId;
	}
	/**
	 * 获取：轮播图id
	 */
	public Long getBannerId() {
		return bannerId;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：类别 : 1首页 2妈妈知道
	 */
	public void setBannerCategory(Integer bannerCategory) {
		this.bannerCategory = bannerCategory;
	}
	/**
	 * 获取：类别 : 1首页 2妈妈知道
	 */
	public Integer getBannerCategory() {
		return bannerCategory;
	}
	/**
	 * 设置：图片路径
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * 获取：图片路径
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * 设置：url链接
	 */
	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}
	/**
	 * 获取：url链接
	 */
	public String getUrlLink() {
		return urlLink;
	}
	/**
	 * 设置：类型
	 */
	public void setBannerType(Integer bannerType) {
		this.bannerType = bannerType;
	}
	/**
	 * 获取：类型
	 */
	public Integer getBannerType() {
		return bannerType;
	}
	/**
	 * 设置：类型id
	 */
	public void setBannerTypeId(Long bannerTypeId) {
		this.bannerTypeId = bannerTypeId;
	}
	/**
	 * 获取：类型id
	 */
	public Long getBannerTypeId() {
		return bannerTypeId;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Long getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Long getEndTime() {
		return endTime;
	}
	/**
	 * 设置：查看次数
	 */
	public void setViewQty(Integer viewQty) {
		this.viewQty = viewQty;
	}
	/**
	 * 获取：查看次数
	 */
	public Integer getViewQty() {
		return viewQty;
	}
	/**
	 * 设置：状态类型 : 0未处_无效 1已处_有效
	 */
	public void setStateType(Integer stateType) {
		this.stateType = stateType;
	}
	/**
	 * 获取：状态类型 : 0未处_无效 1已处_有效
	 */
	public Integer getStateType() {
		return stateType;
	}
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	
	

}

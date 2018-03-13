package com.vigekoo.modules.category.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(主题类别)
 * @date 2018-03-13 19:51:59
 */
public class Category implements Serializable {
	
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
	//操作IP(保留0)
	private Integer operIp;
	//操作用户ID
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long operUserId;
	//删除标识
	private Integer delFlag;
	//类别id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long categoryId;
	//类别的类型(1妈妈知道)
	private Integer categoryType;
	//标题
	private String title;
	//简介
	private String intro;
	//图片路径
	private String cloudUrl;
	//显示排序
	private Integer displayOrder;
	//允许删除标识
	private Integer allowDeleteFlag;
	//热门标识
	private Integer hotFlag;
	//热门排序
	private Integer hotOrder;
	//信息数量
	private Integer infoQty;
	//备注
	private String memo;
	//状态(未处_无效 已处_有效)
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
	 * 设置：操作IP(保留0)
	 */
	public void setOperIp(Integer operIp) {
		this.operIp = operIp;
	}
	/**
	 * 获取：操作IP(保留0)
	 */
	public Integer getOperIp() {
		return operIp;
	}
	/**
	 * 设置：操作用户ID
	 */
	public void setOperUserId(Long operUserId) {
		this.operUserId = operUserId;
	}
	/**
	 * 获取：操作用户ID
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
	 * 设置：类别id
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：类别id
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：类别的类型(1妈妈知道)
	 */
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	/**
	 * 获取：类别的类型(1妈妈知道)
	 */
	public Integer getCategoryType() {
		return categoryType;
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
	 * 设置：简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：简介
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：图片路径
	 */
	public void setCloudUrl(String cloudUrl) {
		this.cloudUrl = cloudUrl;
	}
	/**
	 * 获取：图片路径
	 */
	public String getCloudUrl() {
		return cloudUrl;
	}
	/**
	 * 设置：显示排序
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	/**
	 * 获取：显示排序
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	/**
	 * 设置：允许删除标识
	 */
	public void setAllowDeleteFlag(Integer allowDeleteFlag) {
		this.allowDeleteFlag = allowDeleteFlag;
	}
	/**
	 * 获取：允许删除标识
	 */
	public Integer getAllowDeleteFlag() {
		return allowDeleteFlag;
	}
	/**
	 * 设置：热门标识
	 */
	public void setHotFlag(Integer hotFlag) {
		this.hotFlag = hotFlag;
	}
	/**
	 * 获取：热门标识
	 */
	public Integer getHotFlag() {
		return hotFlag;
	}
	/**
	 * 设置：热门排序
	 */
	public void setHotOrder(Integer hotOrder) {
		this.hotOrder = hotOrder;
	}
	/**
	 * 获取：热门排序
	 */
	public Integer getHotOrder() {
		return hotOrder;
	}
	/**
	 * 设置：信息数量
	 */
	public void setInfoQty(Integer infoQty) {
		this.infoQty = infoQty;
	}
	/**
	 * 获取：信息数量
	 */
	public Integer getInfoQty() {
		return infoQty;
	}
	/**
	 * 设置：备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：状态(未处_无效 已处_有效)
	 */
	public void setStateType(Integer stateType) {
		this.stateType = stateType;
	}
	/**
	 * 获取：状态(未处_无效 已处_有效)
	 */
	public Integer getStateType() {
		return stateType;
	}

}

package com.vigekoo.modules.info.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.vigekoo.modules.category.entity.Category;

/**
 * @author sxia
 * @Description: TODO(信息)
 * @date 2018-03-13 21:15:21
 */
public class Info implements Serializable {
	
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
	//信息id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long infoId;
	//类别id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long categoryId;
	
	private Category category;
	//作者
	private String author;
	//标题
	private String title;
	//标题
	private String detail;
	//简介
	private String intro;
	//图片路径
	private String cloudUrl;
	//置顶标识
	private Integer flagTop;
	//查看次数
	private Integer viewQty;
	//收藏次数
	private Integer favoriteQty;
	//评论次数
	private Integer commentQty;
	//分享次数
	private Integer shareQty;
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
	 * 设置：信息id
	 */
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：信息id
	 */
	public Long getInfoId() {
		return infoId;
	}
	
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
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
	 * 设置：置顶标识
	 */
	public void setFlagTop(Integer flagTop) {
		this.flagTop = flagTop;
	}
	/**
	 * 获取：置顶标识
	 */
	public Integer getFlagTop() {
		return flagTop;
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
	 * 设置：收藏次数
	 */
	public void setFavoriteQty(Integer favoriteQty) {
		this.favoriteQty = favoriteQty;
	}
	/**
	 * 获取：收藏次数
	 */
	public Integer getFavoriteQty() {
		return favoriteQty;
	}
	/**
	 * 设置：评论次数
	 */
	public void setCommentQty(Integer commentQty) {
		this.commentQty = commentQty;
	}
	/**
	 * 获取：评论次数
	 */
	public Integer getCommentQty() {
		return commentQty;
	}
	/**
	 * 设置：分享次数
	 */
	public void setShareQty(Integer shareQty) {
		this.shareQty = shareQty;
	}
	/**
	 * 获取：分享次数
	 */
	public Integer getShareQty() {
		return shareQty;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}

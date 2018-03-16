package com.vigekoo.modules.home.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(首页更新内容)
 * @date 2018-03-16 10:20:12
 */
public class HomeUpdater implements Serializable {
	
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
	//更新内容id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long homeUpdaterId;
	//更新内容类型(1音频 2产品) : 1音频 2产品
	private Integer homeUpdaterType;
	//更新内容信息类型 : 1早安童诗 2晚安故事 3特色绘本 4古典音乐 0产品无分类
	private Integer updaterInfoType;
	//更新内容信息id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long updaterInfoId;
	//更新内容信息标题
	private String updaterInfoTitle;
	//更新内容信息图片地址
	private String updaterInfoImagePath;

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
	 * 设置：更新内容id
	 */
	public void setHomeUpdaterId(Long homeUpdaterId) {
		this.homeUpdaterId = homeUpdaterId;
	}
	/**
	 * 获取：更新内容id
	 */
	public Long getHomeUpdaterId() {
		return homeUpdaterId;
	}
	/**
	 * 设置：更新内容类型(1音频 2产品) : 1音频 2产品
	 */
	public void setHomeUpdaterType(Integer homeUpdaterType) {
		this.homeUpdaterType = homeUpdaterType;
	}
	/**
	 * 获取：更新内容类型(1音频 2产品) : 1音频 2产品
	 */
	public Integer getHomeUpdaterType() {
		return homeUpdaterType;
	}
	/**
	 * 设置：更新内容信息类型 : 1早安童诗 2晚安故事 3特色绘本 4古典音乐
0产品无分类
	 */
	public void setUpdaterInfoType(Integer updaterInfoType) {
		this.updaterInfoType = updaterInfoType;
	}
	/**
	 * 获取：更新内容信息类型 : 1早安童诗 2晚安故事 3特色绘本 4古典音乐
0产品无分类
	 */
	public Integer getUpdaterInfoType() {
		return updaterInfoType;
	}
	/**
	 * 设置：更新内容信息id
	 */
	public void setUpdaterInfoId(Long updaterInfoId) {
		this.updaterInfoId = updaterInfoId;
	}
	/**
	 * 获取：更新内容信息id
	 */
	public Long getUpdaterInfoId() {
		return updaterInfoId;
	}
	/**
	 * 设置：更新内容信息标题
	 */
	public void setUpdaterInfoTitle(String updaterInfoTitle) {
		this.updaterInfoTitle = updaterInfoTitle;
	}
	/**
	 * 获取：更新内容信息标题
	 */
	public String getUpdaterInfoTitle() {
		return updaterInfoTitle;
	}
	/**
	 * 设置：更新内容信息图片地址
	 */
	public void setUpdaterInfoImagePath(String updaterInfoImagePath) {
		this.updaterInfoImagePath = updaterInfoImagePath;
	}
	/**
	 * 获取：更新内容信息图片地址
	 */
	public String getUpdaterInfoImagePath() {
		return updaterInfoImagePath;
	}

}

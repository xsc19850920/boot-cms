package com.vigekoo.modules.info.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(产检信息)
 * @date 2018-03-13 20:35:37
 */
public class InfoPregnancyCheck implements Serializable {
	
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
	//产检信息id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long infoPregnancyCheckId;
	//标题
	private String title;
	//详情
	private String detail;
	//显示顺序
	private Integer displayOrder;
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
	 * 设置：产检信息id
	 */
	public void setInfoPregnancyCheckId(Long infoPregnancyCheckId) {
		this.infoPregnancyCheckId = infoPregnancyCheckId;
	}
	/**
	 * 获取：产检信息id
	 */
	public Long getInfoPregnancyCheckId() {
		return infoPregnancyCheckId;
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
	 * 设置：详情
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：详情
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：显示顺序
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	/**
	 * 获取：显示顺序
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
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

}

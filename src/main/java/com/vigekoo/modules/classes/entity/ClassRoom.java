package com.vigekoo.modules.classes.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(绘画启蒙课堂)
 * @date 2018-03-11 17:52:30
 */
public class ClassRoom implements Serializable {
	
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
	//会话课堂id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long classRoomId;
	//讲师id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long lecturerId;
	//标题
	private String title;
	//图片路径
	private String cloudUrl;
	//简介
	private String intro;
	//适用人群
	private String apply;
	//视频数量
	private Integer videoQty;
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
	 * 设置：会话课堂id
	 */
	public void setClassRoomId(Long classRoomId) {
		this.classRoomId = classRoomId;
	}
	/**
	 * 获取：会话课堂id
	 */
	public Long getClassRoomId() {
		return classRoomId;
	}
	/**
	 * 设置：讲师id
	 */
	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}
	/**
	 * 获取：讲师id
	 */
	public Long getLecturerId() {
		return lecturerId;
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
	 * 设置：适用人群
	 */
	public void setApply(String apply) {
		this.apply = apply;
	}
	/**
	 * 获取：适用人群
	 */
	public String getApply() {
		return apply;
	}
	/**
	 * 设置：视频数量
	 */
	public void setVideoQty(Integer videoQty) {
		this.videoQty = videoQty;
	}
	/**
	 * 获取：视频数量
	 */
	public Integer getVideoQty() {
		return videoQty;
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

}

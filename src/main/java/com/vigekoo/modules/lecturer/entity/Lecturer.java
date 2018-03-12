package com.vigekoo.modules.lecturer.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(讲师)
 * @date 2018-03-12 19:40:41
 */
public class Lecturer implements Serializable {
	
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
	//讲师id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long lecturerId;
	//讲师姓名
	private String lecturerName;
	//讲师职称
	private String lecturerTitle;
	//图片路径
	private String cloudUrl;
	//简介
	private String intro;
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
	 * 设置：讲师姓名
	 */
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	/**
	 * 获取：讲师姓名
	 */
	public String getLecturerName() {
		return lecturerName;
	}
	/**
	 * 设置：讲师职称
	 */
	public void setLecturerTitle(String lecturerTitle) {
		this.lecturerTitle = lecturerTitle;
	}
	/**
	 * 获取：讲师职称
	 */
	public String getLecturerTitle() {
		return lecturerTitle;
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

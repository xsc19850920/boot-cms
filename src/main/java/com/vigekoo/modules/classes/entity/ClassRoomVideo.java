package com.vigekoo.modules.classes.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(绘画启蒙课堂视频)
 * @date 2018-03-13 09:07:48
 */
public class ClassRoomVideo implements Serializable {
	
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
	//视频id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long classRoomVideoId;
	//会话课堂id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long classRoomId;
	//标题
	private String title;
	//文件路径
	private String fileSrc;
	//音视频秒数
	private Integer duration;
	//音视频秒数文本 : 01:10:20
	private String durationText;
	//显示顺序
	private Integer displayOrder;
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
	 * 设置：视频id
	 */
	public void setClassRoomVideoId(Long classRoomVideoId) {
		this.classRoomVideoId = classRoomVideoId;
	}
	/**
	 * 获取：视频id
	 */
	public Long getClassRoomVideoId() {
		return classRoomVideoId;
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
	 * 设置：文件路径
	 */
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}
	/**
	 * 获取：文件路径
	 */
	public String getFileSrc() {
		return fileSrc;
	}
	/**
	 * 设置：音视频秒数
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	/**
	 * 获取：音视频秒数
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * 设置：音视频秒数文本 : 01:10:20
	 */
	public void setDurationText(String durationText) {
		this.durationText = durationText;
	}
	/**
	 * 获取：音视频秒数文本 : 01:10:20
	 */
	public String getDurationText() {
		return durationText;
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

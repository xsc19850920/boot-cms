package com.vigekoo.modules.user.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(用户_评论)
 * @date 2018-03-15 10:40:47
 */
public class UserComment implements Serializable {
	
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
	//评论id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long userCommentId;
	//信息id
	private Long infoId;
	//评论用户id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long userId;
	//评论用户
	private UserDetail commentUserDetail;
	//消息接收者用户
	private UserDetail receiverUserDetail;
	//消息接收者用户id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long receiver;
	//详情100
	private String detail;
	//父类id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long parentId;
	//父类评论
	private String parentDetail;

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
	 * 设置：评论id
	 */
	public void setUserCommentId(Long userCommentId) {
		this.userCommentId = userCommentId;
	}
	/**
	 * 获取：评论id
	 */
	public Long getUserCommentId() {
		return userCommentId;
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
	 * 设置：评论用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：评论用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：消息接收者用户id
	 */
	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}
	/**
	 * 获取：消息接收者用户id
	 */
	public Long getReceiver() {
		return receiver;
	}
	/**
	 * 设置：详情100
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：详情100
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：父类id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父类id
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：父类评论
	 */
	public void setParentDetail(String parentDetail) {
		this.parentDetail = parentDetail;
	}
	/**
	 * 获取：父类评论
	 */
	public String getParentDetail() {
		return parentDetail;
	}
	public UserDetail getCommentUserDetail() {
		return commentUserDetail;
	}
	public void setCommentUserDetail(UserDetail commentUserDetail) {
		this.commentUserDetail = commentUserDetail;
	}
	public UserDetail getReceiverUserDetail() {
		return receiverUserDetail;
	}
	public void setReceiverUserDetail(UserDetail receiverUserDetail) {
		this.receiverUserDetail = receiverUserDetail;
	}
	
	
	

}

package com.vigekoo.modules.user.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(用户统计)
 * @date 2018-03-10 17:09:14
 */
public class UserStatistics implements Serializable {
	
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
	private Long operUserId;
	//删除标识
	private Integer delFlag;
	//用户统计id
		
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long userStatisticsId;
	//key : 1 用户注册时间yyyyMMdd 2积分 3收藏文章  4收藏音频 5兑换记录 6转发次数 7新消息提醒 
	private Integer statisticsKey;
	//value
	private Integer statisticsValue;

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
	 * 设置：用户统计id
	 */
	public void setUserStatisticsId(Long userStatisticsId) {
		this.userStatisticsId = userStatisticsId;
	}
	/**
	 * 获取：用户统计id
	 */
	public Long getUserStatisticsId() {
		return userStatisticsId;
	}
	/**
	 * 设置：key : 1 用户注册时间yyyyMMdd 2积分 3收藏文章 
4收藏音频 5兑换记录 6转发次数 
7新消息提醒 
	 */
	public void setStatisticsKey(Integer statisticsKey) {
		this.statisticsKey = statisticsKey;
	}
	/**
	 * 获取：key : 1 用户注册时间yyyyMMdd 2积分 3收藏文章 
4收藏音频 5兑换记录 6转发次数 
7新消息提醒 
	 */
	public Integer getStatisticsKey() {
		return statisticsKey;
	}
	/**
	 * 设置：value
	 */
	public void setStatisticsValue(Integer statisticsValue) {
		this.statisticsValue = statisticsValue;
	}
	/**
	 * 获取：value
	 */
	public Integer getStatisticsValue() {
		return statisticsValue;
	}

}

package com.vigekoo.modules.user.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(用户_宝宝信息)
 * @date 2018-03-11 10:45:11
 */
public class UserBaby implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long userId;
	//图片路径
	private String cloudUrl;
	//昵称-姓名
	private String nickname;
	//性别(1男2女)
	private Integer gender;
	//出生日期
	private String birthday;
	//提醒标识
	private Integer tipFlag;

	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
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
	 * 设置：昵称-姓名
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称-姓名
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：性别(1男2女)
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别(1男2女)
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生日期
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 设置：提醒标识
	 */
	public void setTipFlag(Integer tipFlag) {
		this.tipFlag = tipFlag;
	}
	/**
	 * 获取：提醒标识
	 */
	public Integer getTipFlag() {
		return tipFlag;
	}

}

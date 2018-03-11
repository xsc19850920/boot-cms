package com.vigekoo.modules.user.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(用户_详情)
 * @date 2018-03-11 13:46:15
 */
public class UserDetail implements Serializable {
	
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
	//手机号码
	private String tel;
	//状态类型 : 0未处_无效 1已处_有效
	private Integer stateType;

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
	 * 设置：手机号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：手机号码
	 */
	public String getTel() {
		return tel;
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

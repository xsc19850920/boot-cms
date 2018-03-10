package com.vigekoo.modules.user.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(用户_收货地址)
 * @date 2018-03-10 20:51:13
 */
public class UserAddress implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户收货地址id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long userAddressId;
	//用户id
	private Long userId;
	//昵称-姓名
	private String nickname;
	//手机号码
	private String tel;
	//详细地址
	private String address;
	//邮编
	private String postCode;
	//默认使用标识
	private Integer defaultFlag;

	/**
	 * 设置：用户收货地址id
	 */
	public void setUserAddressId(Long userAddressId) {
		this.userAddressId = userAddressId;
	}
	/**
	 * 获取：用户收货地址id
	 */
	public Long getUserAddressId() {
		return userAddressId;
	}
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
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：邮编
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * 获取：邮编
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 设置：默认使用标识
	 */
	public void setDefaultFlag(Integer defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	/**
	 * 获取：默认使用标识
	 */
	public Integer getDefaultFlag() {
		return defaultFlag;
	}

}

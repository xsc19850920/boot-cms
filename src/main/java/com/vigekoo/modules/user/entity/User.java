package com.vigekoo.modules.user.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(用户)
 * @date 2018-03-10 14:16:18
 */
public class User implements Serializable {
	
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
	private Long operUserId;
	//删除标识
	private Integer delFlag;
	//用户id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long userId;
	//手机号码
	private String tel;
	//胡椒面
	private Long salt;
	//密码
	private String password;
	//微信
	private String openidWeixin;
	//微博
	private String openidWeibo;
	//QQ
	private String openidQq;
	//用户类型(保留)
	private Integer userType;
	//用户类型时效
	private Integer userTypeExpiresIn;
	//状态类型 : 0未处_无效 1已处_有效
	private Integer stateType;
	
	private UserDetail userDetail;

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
	 * 设置：胡椒面
	 */
	public void setSalt(Long salt) {
		this.salt = salt;
	}
	/**
	 * 获取：胡椒面
	 */
	public Long getSalt() {
		return salt;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：微信
	 */
	public void setOpenidWeixin(String openidWeixin) {
		this.openidWeixin = openidWeixin;
	}
	/**
	 * 获取：微信
	 */
	public String getOpenidWeixin() {
		return openidWeixin;
	}
	/**
	 * 设置：微博
	 */
	public void setOpenidWeibo(String openidWeibo) {
		this.openidWeibo = openidWeibo;
	}
	/**
	 * 获取：微博
	 */
	public String getOpenidWeibo() {
		return openidWeibo;
	}
	/**
	 * 设置：QQ
	 */
	public void setOpenidQq(String openidQq) {
		this.openidQq = openidQq;
	}
	/**
	 * 获取：QQ
	 */
	public String getOpenidQq() {
		return openidQq;
	}
	/**
	 * 设置：用户类型(保留)
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	/**
	 * 获取：用户类型(保留)
	 */
	public Integer getUserType() {
		return userType;
	}
	/**
	 * 设置：用户类型时效
	 */
	public void setUserTypeExpiresIn(Integer userTypeExpiresIn) {
		this.userTypeExpiresIn = userTypeExpiresIn;
	}
	/**
	 * 获取：用户类型时效
	 */
	public Integer getUserTypeExpiresIn() {
		return userTypeExpiresIn;
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
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	

}

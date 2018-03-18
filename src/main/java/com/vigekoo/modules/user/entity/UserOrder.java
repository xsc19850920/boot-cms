package com.vigekoo.modules.user.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.vigekoo.modules.product.entity.Product;

/**
 * @author sxia
 * @Description: TODO(订单（兑换）)
 * @date 2018-03-11 08:47:19
 */
public class UserOrder implements Serializable {
	
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
	//订单id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long userOrderId;
	//用户id
	private Long userId;
	
	//产品id
	private Long productId;
	
	private Product product;
	//商品编号
	private String productCode;
	//标题
	private String title;
	//积分点数
	private Integer points;
	
	//积分点数
	private Integer qty;
	//昵称-姓名
	private String nickname;
	//手机号码
	private String tel;
	//详细地址
	private String address;
	//邮编
	private String postCode;
	//快递单号
	private String trackingNo;
	//订单状态（1兑换中 2已发货 3已收货） : （1兑换中 2已发货 3已收货）
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
	 * 设置：订单id
	 */
	public void setUserOrderId(Long userOrderId) {
		this.userOrderId = userOrderId;
	}
	/**
	 * 获取：订单id
	 */
	public Long getUserOrderId() {
		return userOrderId;
	}
	
	/**
	 * 设置：商品编号
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * 获取：商品编号
	 */
	public String getProductCode() {
		return productCode;
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
	 * 设置：积分点数
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}
	/**
	 * 获取：积分点数
	 */
	public Integer getPoints() {
		return points;
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
	 * 设置：快递单号
	 */
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	/**
	 * 获取：快递单号
	 */
	public String getTrackingNo() {
		return trackingNo;
	}
	/**
	 * 设置：订单状态（1兑换中 2已发货 3已收货） : （1兑换中 2已发货 3已收货）
	 */
	public void setStateType(Integer stateType) {
		this.stateType = stateType;
	}
	/**
	 * 获取：订单状态（1兑换中 2已发货 3已收货） : （1兑换中 2已发货 3已收货）
	 */
	public Integer getStateType() {
		return stateType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	

}

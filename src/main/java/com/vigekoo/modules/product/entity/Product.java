package com.vigekoo.modules.product.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.ArrayUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.vigekoo.common.Constant;

/**
 * @author sxia
 * @Description: TODO(产品)
 * @date 2018-03-11 08:55:49
 */
public class Product implements Serializable {
	
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
	//产品id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long productId;
	//商品编号
	private String productCode;
	//标题
	private String title;
	//单价文本
	private String priceText;
	//积分点数
	private Integer points;
	//详情
	private String detail;
	//图片路径
	private String imagePath;
	//图片路径
	private String imagePathMult;
	//库存数量
	private Integer inventoryQty;
	//兑换量
	private Integer orderQty;
	//查看次数
	private Integer lookQty;
	//置顶标识
	private Integer topFlag;
	//置顶排序
	private Integer topOrder;
	//热门标识
	private Integer hotFlag;
	//热门排序
	private Integer hotOrder;
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
	 * 设置：产品id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品id
	 */
	public Long getProductId() {
		return productId;
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
	 * 设置：单价文本
	 */
	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}
	/**
	 * 获取：单价文本
	 */
	public String getPriceText() {
		return priceText;
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
	 * 设置：详情
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：详情
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：图片路径
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * 获取：图片路径
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * 设置：图片路径
	 */
	public void setImagePathMult(String imagePathMult) {
		this.imagePathMult = imagePathMult;
	}
	/**
	 * 获取：图片路径
	 */
	public String getImagePathMult() {
		return imagePathMult;
	}
	/**
	 * 设置：库存数量
	 */
	public void setInventoryQty(Integer inventoryQty) {
		this.inventoryQty = inventoryQty;
	}
	/**
	 * 获取：库存数量
	 */
	public Integer getInventoryQty() {
		return inventoryQty;
	}
	/**
	 * 设置：兑换量
	 */
	public void setOrderQty(Integer orderQty) {
		this.orderQty = orderQty;
	}
	/**
	 * 获取：兑换量
	 */
	public Integer getOrderQty() {
		return orderQty;
	}
	/**
	 * 设置：查看次数
	 */
	public void setLookQty(Integer lookQty) {
		this.lookQty = lookQty;
	}
	/**
	 * 获取：查看次数
	 */
	public Integer getLookQty() {
		return lookQty;
	}
	/**
	 * 设置：置顶标识
	 */
	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}
	/**
	 * 获取：置顶标识
	 */
	public Integer getTopFlag() {
		return topFlag;
	}
	/**
	 * 设置：置顶排序
	 */
	public void setTopOrder(Integer topOrder) {
		this.topOrder = topOrder;
	}
	/**
	 * 获取：置顶排序
	 */
	public Integer getTopOrder() {
		return topOrder;
	}
	/**
	 * 设置：热门标识
	 */
	public void setHotFlag(Integer hotFlag) {
		this.hotFlag = hotFlag;
	}
	/**
	 * 获取：热门标识
	 */
	public Integer getHotFlag() {
		return hotFlag;
	}
	/**
	 * 设置：热门排序
	 */
	public void setHotOrder(Integer hotOrder) {
		this.hotOrder = hotOrder;
	}
	/**
	 * 获取：热门排序
	 */
	public Integer getHotOrder() {
		return hotOrder;
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
	
	public Product() {
	}
	
	//only for init product object from api
	public Product(String[] array,TypeEnumForParseAPI type) {
		if(ArrayUtils.isNotEmpty(array)){
			if(TypeEnumForParseAPI.INFO == type){ //解析json 成产品信息
				this.productCode = array[0];//PDTCODE
				this.title = array[1]; //VALUE
				this.priceText = array[2]; //PRICELIST 
				this.detail = array[4]; //MARKETDES
				this.points = new BigDecimal(this.priceText).multiply(BigDecimal.valueOf(50)).intValue();  //PRICELIST * 50
				this.imagePath = this.productCode + Constant.JPG_EXT;
//				this.imagePathMult = String.format("%s_1.jpg,%s_2.jpg,%s_3.jpg,%s_4.jpg,%s_5.jpg", array[0],array[0],array[0],array[0],array[0]);
			}else if(TypeEnumForParseAPI.INVENTORY == type){ //解析json 成产品库存 
				this.productCode = array[0];//PDTCODE
				if(Integer.parseInt(array[1]) < 0){
					this.inventoryQty = 0;
				}else{
					this.inventoryQty = Integer.parseInt(array[1]); //QTYCAN
				}
			}else{
				
			}
			
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((delFlag == null) ? 0 : delFlag.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((hotFlag == null) ? 0 : hotFlag.hashCode());
		result = prime * result + ((hotOrder == null) ? 0 : hotOrder.hashCode());
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((imagePathMult == null) ? 0 : imagePathMult.hashCode());
		result = prime * result + ((inventoryQty == null) ? 0 : inventoryQty.hashCode());
		result = prime * result + ((lookQty == null) ? 0 : lookQty.hashCode());
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		result = prime * result + ((operIp == null) ? 0 : operIp.hashCode());
		result = prime * result + ((operUserId == null) ? 0 : operUserId.hashCode());
		result = prime * result + ((orderQty == null) ? 0 : orderQty.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((priceText == null) ? 0 : priceText.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((stateType == null) ? 0 : stateType.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((topFlag == null) ? 0 : topFlag.hashCode());
		result = prime * result + ((topOrder == null) ? 0 : topOrder.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
//		if (productId == null) {
//			if (other.productId != null)
//				return false;
//		} else if (!productId.equals(other.productId))
//			return false;
		
		return true;
	}
	
	
	
	

}

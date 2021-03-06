package com.vigekoo.modules.sys.entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author sxia
 * @Description: TODO(系统配置信息)
 * @date 2017-6-23 15:07
 */
public class SysConfig {

	private String id;

	@NotBlank(message="参数名不能为空")
	private String key;

	@NotBlank(message="参数值不能为空")
	private String value;

	private String remark;
	
	/**
	 * 状态  0：隐藏  1：显示
	 */
	private Integer status;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

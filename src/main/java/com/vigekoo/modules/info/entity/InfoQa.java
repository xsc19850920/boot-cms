package com.vigekoo.modules.info.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(一问一答)
 * @date 2018-03-14 20:17:57
 */
public class InfoQa implements Serializable {
	
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
	//一问一答id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long infoQaId;
	//一问一答分类 : 1新生儿期 2婴儿期 3幼儿期 4学龄前期
	private Integer infoQaType;
	//标题
	private String title;
	//问题
	private String question;
	//作者
	private String author;
	//作者职称
	private String authorTitle;
	//回答内容
	private String answerDetail;
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
	 * 设置：一问一答id
	 */
	public void setInfoQaId(Long infoQaId) {
		this.infoQaId = infoQaId;
	}
	/**
	 * 获取：一问一答id
	 */
	public Long getInfoQaId() {
		return infoQaId;
	}
	/**
	 * 设置：一问一答分类 : 1新生儿期 2婴儿期 3幼儿期 4学龄前期
	 */
	public void setInfoQaType(Integer infoQaType) {
		this.infoQaType = infoQaType;
	}
	/**
	 * 获取：一问一答分类 : 1新生儿期 2婴儿期 3幼儿期 4学龄前期
	 */
	public Integer getInfoQaType() {
		return infoQaType;
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
	 * 设置：问题
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 获取：问题
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：作者职称
	 */
	public void setAuthorTitle(String authorTitle) {
		this.authorTitle = authorTitle;
	}
	/**
	 * 获取：作者职称
	 */
	public String getAuthorTitle() {
		return authorTitle;
	}
	/**
	 * 设置：回答内容
	 */
	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
	}
	/**
	 * 获取：回答内容
	 */
	public String getAnswerDetail() {
		return answerDetail;
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

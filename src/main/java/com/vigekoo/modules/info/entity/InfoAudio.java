package com.vigekoo.modules.info.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author sxia
 * @Description: TODO(信息_音频)
 * @date 2018-03-11 14:18:11
 */
public class InfoAudio implements Serializable {
	
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
	//信息id
	@JSONField(serializeUsing= ToStringSerializer.class)
	private Long infoAudioId;
	//信息分类 : 1早安童诗 2晚安故事 3古文小故事 4特色绘本
	private Integer infoType;
	//标题
	private String title;
	//图片路径
	private String cloudUrl;
	//文件路径
	private String fileSrc;
	//音视频秒数
	private Integer duration;
	//音视频秒数文本 : 01:10:20
	private String durationText;
	//置顶标识
	private Integer flagTop;
	//收藏次数
	private Integer favoriteQty;
	//收听次数
	private Integer playQty;
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
	 * 设置：信息id
	 */
	public void setInfoAudioId(Long infoAudioId) {
		this.infoAudioId = infoAudioId;
	}
	/**
	 * 获取：信息id
	 */
	public Long getInfoAudioId() {
		return infoAudioId;
	}
	/**
	 * 设置：信息分类 : 1早安童诗 2晚安故事 3古文小故事 4特色绘本
	 */
	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}
	/**
	 * 获取：信息分类 : 1早安童诗 2晚安故事 3古文小故事 4特色绘本
	 */
	public Integer getInfoType() {
		return infoType;
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
	 * 设置：文件路径
	 */
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}
	/**
	 * 获取：文件路径
	 */
	public String getFileSrc() {
		return fileSrc;
	}
	/**
	 * 设置：音视频秒数
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	/**
	 * 获取：音视频秒数
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * 设置：音视频秒数文本 : 01:10:20
	 */
	public void setDurationText(String durationText) {
		this.durationText = durationText;
	}
	/**
	 * 获取：音视频秒数文本 : 01:10:20
	 */
	public String getDurationText() {
		return durationText;
	}
	/**
	 * 设置：置顶标识
	 */
	public void setFlagTop(Integer flagTop) {
		this.flagTop = flagTop;
	}
	/**
	 * 获取：置顶标识
	 */
	public Integer getFlagTop() {
		return flagTop;
	}
	/**
	 * 设置：收藏次数
	 */
	public void setFavoriteQty(Integer favoriteQty) {
		this.favoriteQty = favoriteQty;
	}
	/**
	 * 获取：收藏次数
	 */
	public Integer getFavoriteQty() {
		return favoriteQty;
	}
	/**
	 * 设置：收听次数
	 */
	public void setPlayQty(Integer playQty) {
		this.playQty = playQty;
	}
	/**
	 * 获取：收听次数
	 */
	public Integer getPlayQty() {
		return playQty;
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

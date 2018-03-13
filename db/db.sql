/*
Navicat MySQL Data Transfer

Source Server         : db&util
Source Server Version : 50710
Source Host           : 192.168.0.88:3306
Source Database       : boot-cms

Target Server Type    : MYSQL
Target Server Version : 50599
File Encoding         : 65001

Date: 2018-03-13 23:09:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `banner`
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`banner_id`  bigint(20) UNSIGNED NOT NULL COMMENT '轮播图id' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`banner_category`  tinyint(3) UNSIGNED NOT NULL COMMENT '类别 : 1首页 2妈妈知道' ,
`image_path`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`url_link`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'url链接' ,
`banner_type`  tinyint(4) NOT NULL COMMENT '类型' ,
`banner_type_id`  bigint(20) UNSIGNED NOT NULL COMMENT '类型id' ,
`start_time`  bigint(20) UNSIGNED NOT NULL COMMENT '开始时间' ,
`end_time`  bigint(20) UNSIGNED NOT NULL COMMENT '结束时间' ,
`view_qty`  int(10) UNSIGNED NOT NULL COMMENT '查看次数' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
`display_order`  int(11) NOT NULL COMMENT '显示顺序' ,
PRIMARY KEY (`banner_id`, `create_time`),
UNIQUE INDEX `banner_id` (`banner_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='轮播图'

;

-- ----------------------------
-- Records of banner
-- ----------------------------
BEGIN;
INSERT INTO `banner` VALUES ('1520938454000', '1520938454000', '0', '1', '0', '973512553218965504', '123', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', '1234', '0', '0', '1520870400000', '1521129599000', '0', '0', '2');
COMMIT;

-- ----------------------------
-- Table structure for `bind`
-- ----------------------------
DROP TABLE IF EXISTS `bind`;
CREATE TABLE `bind` (
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`device_no`  char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备No' ,
`mi_regid`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'mi_regid' ,
PRIMARY KEY (`device_no`),
UNIQUE INDEX `device_no` (`device_no`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='绑定信息'

;

-- ----------------------------
-- Records of bind
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`category_id`  bigint(20) UNSIGNED NOT NULL COMMENT '类别id' ,
`category_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '类别的类型(1妈妈知道)' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`intro`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介' ,
`cloud_url`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`display_order`  int(10) UNSIGNED NOT NULL COMMENT '显示排序' ,
`allow_delete_flag`  tinyint(1) NOT NULL COMMENT '允许删除标识' ,
`hot_flag`  tinyint(1) NOT NULL COMMENT '热门标识' ,
`hot_order`  int(10) UNSIGNED NOT NULL COMMENT '热门排序' ,
`info_qty`  int(10) UNSIGNED NOT NULL COMMENT '信息数量' ,
`memo`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态(未处_无效 已处_有效)' ,
PRIMARY KEY (`category_id`),
UNIQUE INDEX `category_id` (`category_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='主题类别'

;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES ('1520943649000', '1520944211010', '0', '1', '0', '973534341814550528', '1', '标题测试', '简介', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', '0', '0', '0', '0', '0', '', '1'), ('1520943679000', '1520944206039', '0', '1', '0', '973534470529351680', '1', '标题测试2', '测试二', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', '0', '0', '0', '0', '0', '', '1');
COMMIT;

-- ----------------------------
-- Table structure for `class_room`
-- ----------------------------
DROP TABLE IF EXISTS `class_room`;
CREATE TABLE `class_room` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`class_room_id`  bigint(20) UNSIGNED NOT NULL COMMENT '会话课堂id' ,
`lecturer_id`  bigint(20) UNSIGNED NOT NULL COMMENT '讲师id' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`cloud_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`intro`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介' ,
`apply`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '适用人群' ,
`video_qty`  int(10) UNSIGNED NOT NULL COMMENT '视频数量' ,
`view_qty`  int(10) UNSIGNED NOT NULL COMMENT '查看次数' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`class_room_id`),
FOREIGN KEY (`lecturer_id`) REFERENCES `lecturer` (`lecturer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `class_room_id` (`class_room_id`) USING BTREE ,
INDEX `lecturer_id` (`lecturer_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='绘画启蒙课堂'

;

-- ----------------------------
-- Records of class_room
-- ----------------------------
BEGIN;
INSERT INTO `class_room` VALUES ('1520861605000', '1520861605000', '0', '1', '0', '973190226551767040', '973172690552619008', '课程标题测试', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/3654fea38349430caf55b82cc72b8f27.jpg?Expires=1836221591&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=VwRek77cxnSSP7ZfupsUXbPnxzs%3D', '我就是测试一下', '使用人去测试', '0', '0', '1');
COMMIT;

-- ----------------------------
-- Table structure for `class_room_video`
-- ----------------------------
DROP TABLE IF EXISTS `class_room_video`;
CREATE TABLE `class_room_video` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`class_room_video_id`  bigint(20) UNSIGNED NOT NULL COMMENT '视频id' ,
`class_room_id`  bigint(20) UNSIGNED NOT NULL COMMENT '会话课堂id' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`file_src`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径' ,
`duration`  int(10) UNSIGNED NOT NULL COMMENT '音视频秒数' ,
`duration_text`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '音视频秒数文本 : 01:10:20' ,
`display_order`  int(10) UNSIGNED NOT NULL COMMENT '显示顺序' ,
`view_qty`  int(10) UNSIGNED NOT NULL COMMENT '查看次数' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`class_room_video_id`),
FOREIGN KEY (`class_room_id`) REFERENCES `class_room` (`class_room_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `class_room_video_id` (`class_room_video_id`) USING BTREE ,
INDEX `class_room_id` (`class_room_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='绘画启蒙课堂视频'

;

-- ----------------------------
-- Records of class_room_video
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `home_updater`
-- ----------------------------
DROP TABLE IF EXISTS `home_updater`;
CREATE TABLE `home_updater` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`home_updater_id`  bigint(20) UNSIGNED NOT NULL COMMENT '更新内容id' ,
`home_updater_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '更新内容类型(1音频 2产品) : 1音频 2产品' ,
`updater_info_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '更新内容信息类型 : 1早安童诗 2晚安故事 3特色绘本 4古典音乐\r\n0产品无分类' ,
`updater_info_id`  bigint(20) UNSIGNED NOT NULL COMMENT '更新内容信息id' ,
`updater_info_title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新内容信息标题' ,
`updater_info_image_path`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新内容信息图片地址' ,
PRIMARY KEY (`home_updater_id`),
UNIQUE INDEX `home_updater_id` (`home_updater_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='首页更新内容'

;

-- ----------------------------
-- Records of home_updater
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `info`
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`info_id`  bigint(20) UNSIGNED NOT NULL COMMENT '信息id' ,
`category_id`  bigint(20) UNSIGNED NOT NULL COMMENT '类别id' ,
`author`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`intro`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介' ,
`cloud_url`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`flag_top`  tinyint(1) NOT NULL COMMENT '置顶标识' ,
`view_qty`  int(10) UNSIGNED NOT NULL COMMENT '查看次数' ,
`favorite_qty`  int(10) UNSIGNED NOT NULL COMMENT '收藏次数' ,
`comment_qty`  int(10) UNSIGNED NOT NULL COMMENT '评论次数' ,
`share_qty`  int(10) UNSIGNED NOT NULL COMMENT '分享次数' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`info_id`),
FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `info_id` (`info_id`) USING BTREE ,
INDEX `category_id` (`category_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='信息'

;

-- ----------------------------
-- Records of info
-- ----------------------------
BEGIN;
INSERT INTO `info` VALUES ('1520951210000', '1520951399816', '0', '1', '0', '973566057585311744', '973534341814550528', '超级管理员', '测试文章1', '111', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', '0', '0', '0', '0', '0', '1'), ('1520952453000', '1520952573927', '0', '1', '0', '973571268425023488', '973534470529351680', '超级管理员', '123', '1111', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', '0', '0', '0', '0', '0', '1');
COMMIT;

-- ----------------------------
-- Table structure for `info_audio`
-- ----------------------------
DROP TABLE IF EXISTS `info_audio`;
CREATE TABLE `info_audio` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`info_audio_id`  bigint(20) UNSIGNED NOT NULL COMMENT '信息id' ,
`info_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '信息分类 : 1早安童诗 2晚安故事 3古文小故事 4特色绘本' ,
`title`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`cloud_url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`file_src`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径' ,
`duration`  int(10) UNSIGNED NOT NULL COMMENT '音视频秒数' ,
`duration_text`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '音视频秒数文本 : 01:10:20' ,
`flag_top`  tinyint(1) NOT NULL COMMENT '置顶标识' ,
`favorite_qty`  int(10) UNSIGNED NOT NULL COMMENT '收藏次数' ,
`play_qty`  int(10) UNSIGNED NOT NULL COMMENT '收听次数' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`info_audio_id`),
UNIQUE INDEX `info_audio_id` (`info_audio_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='信息_音频'

;

-- ----------------------------
-- Records of info_audio
-- ----------------------------
BEGIN;
INSERT INTO `info_audio` VALUES ('1520761404000', '1520761404000', '1694542016', '1', '0', '972769953541259264', '1', '321', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/8c9cbc2c02f744e292c001b1a827a376.jpg?Expires=1836121455&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=talSvdwtRd2GVZ0h8ffgNLKxTZs%3D', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/925033e34fbd44c8832885a84306a705.mp3?Expires=1836121395&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=p%2BKpP5e%2FSp6AfKpmlgluS0Dy3Es%3D', '1', '01:10:20', '0', '0', '0', '1');
COMMIT;

-- ----------------------------
-- Table structure for `info_daily`
-- ----------------------------
DROP TABLE IF EXISTS `info_daily`;
CREATE TABLE `info_daily` (
`info_daily_id`  bigint(20) UNSIGNED NOT NULL COMMENT '家中常备id' ,
`info_daily_type`  int(10) UNSIGNED NOT NULL COMMENT '家中常备类型' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`cloud_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`intro`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介' ,
`detail`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情100' ,
`display_order`  int(10) UNSIGNED NOT NULL COMMENT '显示顺序' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`info_daily_id`),
UNIQUE INDEX `info_daily_id` (`info_daily_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='家中常备'

;

-- ----------------------------
-- Records of info_daily
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `info_development`
-- ----------------------------
DROP TABLE IF EXISTS `info_development`;
CREATE TABLE `info_development` (
`info_development_id`  bigint(20) UNSIGNED NOT NULL COMMENT '发展指标id' ,
`info_development_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '发展指标类型' ,
`detail`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情100' ,
`display_order`  int(10) UNSIGNED NOT NULL COMMENT '显示顺序' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`info_development_id`),
UNIQUE INDEX `info_development_id` (`info_development_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='发展指标'

;

-- ----------------------------
-- Records of info_development
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `info_pregnancy_check`
-- ----------------------------
DROP TABLE IF EXISTS `info_pregnancy_check`;
CREATE TABLE `info_pregnancy_check` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`info_pregnancy_check_id`  bigint(20) UNSIGNED NOT NULL COMMENT '产检信息id' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`detail`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情' ,
`display_order`  int(10) UNSIGNED NOT NULL COMMENT '显示顺序' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`info_pregnancy_check_id`),
UNIQUE INDEX `info_pregnancy_check_id` (`info_pregnancy_check_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产检信息'

;

-- ----------------------------
-- Records of info_pregnancy_check
-- ----------------------------
BEGIN;
INSERT INTO `info_pregnancy_check` VALUES ('1520946443000', '1520946451938', '0', '1', '0', '973546062612529152', '孕检报告测试', '详细1', '0', '1'), ('1520946485828', '1520946485828', '0', '1', '0', '973546239750569984', '123', '123', '0', '1');
COMMIT;

-- ----------------------------
-- Table structure for `info_qa`
-- ----------------------------
DROP TABLE IF EXISTS `info_qa`;
CREATE TABLE `info_qa` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`info_qa_id`  bigint(20) UNSIGNED NOT NULL COMMENT '一问一答id' ,
`info_qa_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '一问一答分类 : 1新生儿期 2婴儿期 3幼儿期 4学龄前期' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`question`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题' ,
`author`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者' ,
`author_title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者职称' ,
`answer_detail`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回答内容' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`info_qa_id`),
UNIQUE INDEX `info_qa_id` (`info_qa_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='一问一答'

;

-- ----------------------------
-- Records of info_qa
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `lecturer`
-- ----------------------------
DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE `lecturer` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`lecturer_id`  bigint(20) UNSIGNED NOT NULL COMMENT '讲师id' ,
`lecturer_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '讲师姓名' ,
`lecturer_title`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '讲师职称' ,
`cloud_url`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`intro`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`lecturer_id`),
UNIQUE INDEX `lecturer_id` (`lecturer_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='讲师'

;

-- ----------------------------
-- Records of lecturer
-- ----------------------------
BEGIN;
INSERT INTO `lecturer` VALUES ('1520857424759', '1520857424759', '0', '1', '0', '973172690552619008', '马老师', '中一', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/1a344ce244754dbe992f4fa3af87d48f.jpg?Expires=1836217419&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=SkWCgRT7Uwai5bTvcZ0WRhKc4ok%3D', '中一老师', '1'), ('1520857441554', '1520857441554', '0', '1', '0', '973172760995954688', '李老师', '中二', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/52dcfcb22c674891b6e823558faa4c83.jpg?Expires=1836217438&amp;OSSAccessKeyId=LTAIqcXTcQ4gdiKi&amp;Signature=MTW14pGGxxGGlCUIpaLBK3pXZ3c%3D', '中二老师', '1');
COMMIT;

-- ----------------------------
-- Table structure for `log_point`
-- ----------------------------
DROP TABLE IF EXISTS `log_point`;
CREATE TABLE `log_point` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作IP' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`log_point_id`  bigint(20) UNSIGNED NOT NULL COMMENT '日志_点数_id' ,
`point_type`  tinyint(4) NOT NULL COMMENT '点数类型 : 1增加 2减少' ,
`point`  int(11) NOT NULL COMMENT '点数' ,
`balance`  int(11) NOT NULL COMMENT '余额' ,
`channel`  tinyint(3) UNSIGNED NOT NULL COMMENT '渠道' ,
`channel_text`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道文本（方便查询）' ,
`memo`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'memo_100' ,
PRIMARY KEY (`log_point_id`),
UNIQUE INDEX `log_point_id` (`log_point_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='日志_用户点数'

;

-- ----------------------------
-- Records of log_point
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `log_sign`
-- ----------------------------
DROP TABLE IF EXISTS `log_sign`;
CREATE TABLE `log_sign` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`log_sign_id`  bigint(20) UNSIGNED NOT NULL COMMENT '日志登录id' ,
`sign_account_type`  tinyint(4) NOT NULL COMMENT '登录账户类型 : 1weixin 2weibo 3fb 4email' ,
`sign_account_info`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账户信息' ,
`sign_city`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地理位置' ,
`device`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备' ,
`device_platform`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备平台' ,
`device_platform_version`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备平台版本' ,
`client_channel`  int(11) NOT NULL COMMENT '客户端渠道' ,
`client_version`  int(11) NOT NULL COMMENT '客服端版本' ,
`sign_type`  tinyint(4) NOT NULL COMMENT '登录类型(1登录 2退出)' ,
PRIMARY KEY (`log_sign_id`),
UNIQUE INDEX `log_sign_id` (`log_sign_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='日志_登录'

;

-- ----------------------------
-- Records of log_sign
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `log_verify_code`
-- ----------------------------
DROP TABLE IF EXISTS `log_verify_code`;
CREATE TABLE `log_verify_code` (
`log_verify_code_id`  bigint(20) UNSIGNED NOT NULL COMMENT '日志验证码id' ,
`verify_type`  tinyint(4) NOT NULL COMMENT '验证类型(1注册 2忘记密码)' ,
`verify_value`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '验证信息' ,
`verify_code`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '验证码' ,
`expires_in`  bigint(20) UNSIGNED NOT NULL COMMENT '失效时间' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`log_verify_code_id`),
UNIQUE INDEX `log_verify_code_id` (`log_verify_code_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='日志_验证码'

;

-- ----------------------------
-- Records of log_verify_code
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`product_id`  bigint(20) UNSIGNED NOT NULL COMMENT '产品id' ,
`product_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号' ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`price_text`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单价文本' ,
`points`  int(10) UNSIGNED NOT NULL COMMENT '积分点数' ,
`detail`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情' ,
`image_path`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`image_path_mult`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`inventory_qty`  int(10) UNSIGNED NOT NULL COMMENT '库存数量' ,
`order_qty`  int(10) UNSIGNED NOT NULL COMMENT '兑换量' ,
`look_qty`  int(10) UNSIGNED NOT NULL COMMENT '查看次数' ,
`top_flag`  tinyint(1) NOT NULL COMMENT '置顶标识' ,
`top_order`  int(10) UNSIGNED NOT NULL COMMENT '置顶排序' ,
`hot_flag`  tinyint(1) NOT NULL COMMENT '热门标识' ,
`hot_order`  int(10) UNSIGNED NOT NULL COMMENT '热门排序' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`product_id`),
UNIQUE INDEX `product_id` (`product_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品'

;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES ('1520731199712', '1520731199712', '0', '972643264328892416', '0', '97264326432889241', '972643264328892416', 'product title', '123', '100', 'detail', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'), ('1520731199712', '1520731199712', '0', '972368875804950528', '0', '972680105824354304', '972680105824354304', 'product title 2', 'price text 2', '100', 'detail2', '2', '2', '2', '2', '2', '2', '2', '1', '2', '1');
COMMIT;

-- ----------------------------
-- Table structure for `sys_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `sys_attachment`;
CREATE TABLE `sys_attachment` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`title`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '标题' ,
`user_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户ID' ,
`path`  varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径' ,
`mime_type`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'mime' ,
`suffix`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件的后缀' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`),
INDEX `user_id` (`user_id`) USING BTREE ,
INDEX `mime_type` (`mime_type`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='附件'

;

-- ----------------------------
-- Records of sys_attachment
-- ----------------------------
BEGIN;
INSERT INTO `sys_attachment` VALUES ('972111052810485760', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-09 22:05:11'), ('972740808828518400', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/d61d0b43500f483db2b24111f2a1d680.mp3?Expires=1836114456&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=zPysE5kxI9s1tJ0LUcVBWgai8q0%3D', 'audio/mp3', '.mp3', '2018-03-11 15:47:36'), ('972747196350857216', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/22869e9290884eccace801134886bfdf.jpg?Expires=1836115979&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=CcTLPM%2FeBnRnvYIxElTlAxY4ps4%3D', 'image/jpeg', '.jpg', '2018-03-11 16:12:59'), ('972747465918775297', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/652861f764b145c58c21fdb9a24e0f88.jpg?Expires=1836116043&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=CBFCr6DvC8VoA%2FIql5%2BxrF9FS2o%3D', 'image/jpeg', '.jpg', '2018-03-11 16:14:03'), ('972747798879404032', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/7e44bb1435e64037939d5bcbf42041e4.mp3?Expires=1836116122&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=mRjHK2IWGuN7V2CupQoptbBdCEw%3D', 'audio/mp3', '.mp3', '2018-03-11 16:15:23'), ('972753305753092096', 'u=1384458373,3382268492&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/0063ada8b2cf4a07bdadb06ce296a498.jpg?Expires=1836117435&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=QH95T34zAmKPyJLTulYK5EpMfro%3D', 'image/jpeg', '.jpg', '2018-03-11 16:37:16'), ('972754075076526080', 'u=1384458373,3382268492&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/44dae75feee24d6da26d7d02a3529a64.jpg?Expires=1836117619&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=5tOv5cR0jSXvPlQeDN4xusdhM0I%3D', 'image/jpeg', '.jpg', '2018-03-11 16:40:19'), ('972762630911426560', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/07689ba9374441929188938edbfd8571.jpg?Expires=1836119658&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=4f%2Fpt7yP5P1PCV0eHoYReIELzOg%3D', 'image/jpeg', '.jpg', '2018-03-11 17:14:19'), ('972762714617151488', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/c2cd711eb6824c498c2e866bccd5c4bb.mp3?Expires=1836119678&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=5%2F7XXJFvb8wf%2BKWqRh5pVYwlT1U%3D', 'audio/mp3', '.mp3', '2018-03-11 17:14:39'), ('972764010904551424', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/657b4348e8db4e53b6e1143a6840bbb3.mp3?Expires=1836119987&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=%2Fw%2BK72aJbZEM1SA3pJ2wdRvCoYI%3D', 'audio/mp3', '.mp3', '2018-03-11 17:19:48'), ('972765693160194048', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/1a717d58d78647a28082a3d90fc3b2d3.mp3?Expires=1836120388&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=WNyxktzCgPrsDIfJKUspxuVyf7U%3D', 'audio/mp3', '.mp3', '2018-03-11 17:26:29'), ('972766618985693184', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/d54c5c4bf16040639c0da57159966115.mp3?Expires=1836120609&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=qlwgLecOcbByT7iJ7BrlSyeqR0w%3D', 'audio/mp3', '.mp3', '2018-03-11 17:30:10'), ('972768490639327232', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/c380252ddbad4a05997741c6a2cb1e8c.mp3?Expires=1836121055&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=ZbbPTiyKJkAkq%2BVdkoQlv2yzuKg%3D', 'audio/mp3', '.mp3', '2018-03-11 17:37:36'), ('972769916534915073', '冯提莫 - 说散就散.mp3', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/925033e34fbd44c8832885a84306a705.mp3?Expires=1836121395&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=p%2BKpP5e%2FSp6AfKpmlgluS0Dy3Es%3D', 'audio/mp3', '.mp3', '2018-03-11 17:43:16'), ('972770167836639232', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/8c9cbc2c02f744e292c001b1a827a376.jpg?Expires=1836121455&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=talSvdwtRd2GVZ0h8ffgNLKxTZs%3D', 'image/jpeg', '.jpg', '2018-03-11 17:44:16'), ('973170069511077888', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/0b65b3da45dc45f8a544d0da0715f4ab.jpg?Expires=1836216799&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=cbtviY7TDaPLCBEY%2Fd5uqymhDbI%3D', 'image/jpeg', '.jpg', '2018-03-12 20:13:20'), ('973172237001555968', 'u=1384458373,3382268492&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e4260663b2eb4b3ba4a247c4b2ba8fed.jpg?Expires=1836217316&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=F%2BUyUZte7ZdonFtNrYhlsVfeGek%3D', 'image/jpeg', '.jpg', '2018-03-12 20:21:57'), ('973172667286814720', 'u=1384458373,3382268492&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/1a344ce244754dbe992f4fa3af87d48f.jpg?Expires=1836217419&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=SkWCgRT7Uwai5bTvcZ0WRhKc4ok%3D', 'image/jpeg', '.jpg', '2018-03-12 20:23:39'), ('973172747486101504', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/52dcfcb22c674891b6e823558faa4c83.jpg?Expires=1836217438&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=MTW14pGGxxGGlCUIpaLBK3pXZ3c%3D', 'image/jpeg', '.jpg', '2018-03-12 20:23:58'), ('973188808629551104', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/ac0a61ee6c2b4cf68565a2f52052ab50.jpg?Expires=1836221267&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=UXLJO%2Fuug1nal5ze3sua10fzB6s%3D', 'image/jpeg', '.jpg', '2018-03-12 21:27:48'), ('973190168506793984', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/3654fea38349430caf55b82cc72b8f27.jpg?Expires=1836221591&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=VwRek77cxnSSP7ZfupsUXbPnxzs%3D', 'image/jpeg', '.jpg', '2018-03-12 21:33:12'), ('973510541840482304', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 18:46:15'), ('973511634733498368', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 18:50:35'), ('973512548110303232', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 18:54:13'), ('973534230099263488', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 20:20:22'), ('973534468058906624', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 20:21:19'), ('973560753388781568', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:05:46'), ('973563420529917952', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:16:22'), ('973564077655719936', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:18:59'), ('973564102934790144', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:19:05'), ('973565179990114304', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:23:22'), ('973565197232898048', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:23:26'), ('973566899038191616', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:30:11'), ('973568044565528576', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:34:45'), ('973568076337381376', 'u=1384458373,3382268492&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:34:52'), ('973570346227597312', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:43:53'), ('973570367417221121', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:43:58'), ('973570829709213696', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:45:49'), ('973570844481552384', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:45:52'), ('973572975955542016', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:54:20'), ('973572990040014848', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:54:24'), ('973573756846866432', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:57:26'), ('973573779122814976', 'u=1391502477,158380109&fm=27&gp=0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 22:57:32'), ('973575626373988352', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 23:04:52'), ('973575644329803777', '2011121609514415935.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-13 23:04:56');
COMMIT;

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`key`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'key' ,
`value`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'value' ,
`status`  tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示' ,
`remark`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `key` (`key`) USING BTREE ,
INDEX `status` (`status`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='系统配置信息表'

;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` VALUES ('972108156811345920', 'key', 'value', '0', '12321');
COMMIT;

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`username`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名' ,
`operation`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作' ,
`method`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方法' ,
`params`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求参数' ,
`ip`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址' ,
`time`  bigint(20) NULL DEFAULT NULL COMMENT '执行时长(毫秒)' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='系统日志'

;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_log` VALUES ('972083659517460480', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"1\",\"name\":\"系统管理员角色\",\"remark\":\"系统管理员角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\",\"12\",\"15\",\"16\",\"13\",\"14\",\"17\",\"20\",\"21\",\"18\",\"19\",\"22\",\"24\",\"25\",\"26\",\"23\",\"27\",\"31\",\"29\",\"30\",\"28\",\"32\",\"33\",\"54\"],\"createTime\":\"Mar 9, 2018 6:44:37 PM\"}', '0:0:0:0:0:0:0:1', '2853', '2018-03-09 20:16:20'), ('972083716341891072', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"1\",\"name\":\"系统管理员角色\",\"remark\":\"系统管理员角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\",\"12\",\"15\",\"16\",\"13\",\"14\",\"17\",\"20\",\"21\",\"18\",\"19\",\"22\",\"24\",\"25\",\"26\",\"23\",\"27\",\"31\",\"29\",\"30\",\"28\",\"32\",\"33\",\"54\",\"50\",\"51\",\"53\",\"52\"],\"createTime\":\"Mar 9, 2018 6:44:37 PM\"}', '0:0:0:0:0:0:0:1', '2372', '2018-03-09 20:16:33'), ('972092002919251968', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"32\",\"parentName\":\"系统日志\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '14350', '2018-03-09 20:49:29'), ('972092567334158336', 'admin', '保存角色', 'com.vigekoo.modules.sys.controller.SysRoleController.save()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"27\",\"28\",\"31\",\"29\",\"30\",\"32\",\"54\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3932', '2018-03-09 20:51:43'), ('972092655183855616', 'admin', '删除用户', 'com.vigekoo.modules.sys.controller.SysUserController.delete()', '[\"3\",\"971641717683912704\"]', '0:0:0:0:0:0:0:1', '17', '2018-03-09 20:52:04'), ('972092683239555072', 'admin', '修改用户', 'com.vigekoo.modules.sys.controller.SysUserController.update()', '{\"id\":\"2\",\"username\":\"om\",\"nickname\":\"运营用户\",\"salt\":\"RECllptZzR0yxVi2Bgpx\",\"status\":1,\"roleIdList\":[\"972092550984761344\"],\"createTime\":\"Mar 6, 2018 7:40:31 AM\"}', '0:0:0:0:0:0:0:1', '2246', '2018-03-09 20:52:11'), ('972093458309185536', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3337', '2018-03-09 20:55:16'), ('972093664031408128', 'admin', '修改用户', 'com.vigekoo.modules.sys.controller.SysUserController.update()', '{\"id\":\"2\",\"username\":\"om\",\"nickname\":\"运营用户\",\"salt\":\"RECllptZzR0yxVi2Bgpx\",\"status\":1,\"roleIdList\":[\"972092550984761344\"],\"createTime\":\"Mar 6, 2018 7:40:31 AM\"}', '0:0:0:0:0:0:0:1', '9776', '2018-03-09 20:56:05'), ('972102130817040384', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\",\"12\",\"15\",\"16\",\"13\",\"14\",\"17\",\"20\",\"21\",\"18\",\"19\",\"22\",\"24\",\"25\",\"26\",\"23\",\"27\",\"28\",\"31\",\"29\",\"30\",\"32\",\"54\",\"33\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3657', '2018-03-09 21:29:43'), ('972107559387267072', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3296', '2018-03-09 21:51:18'), ('972107897196511232', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"27\",\"parentName\":\"资源管理\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '12094', '2018-03-09 21:52:38'), ('972107956432666624', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"32\",\"parentName\":\"系统日志\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-09 21:52:52'), ('972108156840706048', 'admin', '保存配置', 'com.vigekoo.modules.sys.controller.SysConfigController.save()', '{\"id\":\"972108156811345920\",\"key\":\"key\",\"value\":\"value\",\"remark\":\"12321\",\"status\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-09 21:53:40'), ('972109310718902272', 'admin', '修改配置', 'com.vigekoo.modules.sys.controller.SysConfigController.update()', '{\"id\":\"972108156811345920\",\"key\":\"key\",\"value\":\"value\",\"remark\":\"12321\",\"status\":0}', '127.0.0.1', '10', '2018-03-09 21:58:15'), ('972111865813401600', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"27\",\"parentName\":\"资源管理\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-09 22:08:24'), ('972111933324918784', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"32\",\"parentName\":\"系统日志\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-09 22:08:41'), ('972332641388855296', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"2\",\"6\",\"3\",\"4\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '56', '2018-03-10 12:45:41'), ('972352025767444480', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972352025666781184\",\"parentId\":\"0\",\"parentName\":\"一级菜单\",\"name\":\"用户管理\",\"type\":0,\"icon\":\"fa fa-user\",\"orderNum\":0}', '0:0:0:0:0:0:0:1', '34', '2018-03-10 14:02:43'), ('972353737081225216', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972353737039282176\",\"parentId\":\"972352025666781184\",\"parentName\":\"用户管理\",\"name\":\"用户列表\",\"url\":\"models/user/user.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '25608', '2018-03-10 14:09:31'), ('972361601946484736', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972353737039282176\",\"parentId\":\"972352025666781184\",\"parentName\":\"用户管理\",\"name\":\"用户列表\",\"url\":\"modules/user/user.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '6739', '2018-03-10 14:40:46'), ('972362472235204608', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972353737039282176\",\"parentId\":\"972352025666781184\",\"parentName\":\"用户管理\",\"name\":\"用户列表\",\"url\":\"modules/user/user.html\",\"perms\":\"user:list,user:info\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-10 14:44:14'), ('972363078018531328', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972363077989171200\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"新增\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-10 14:46:38'), ('972363158331064320', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972363158259761152\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"查看\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '18', '2018-03-10 14:46:57'), ('972363222722019328', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972363222688464896\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"修改\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '9', '2018-03-10 14:47:13'), ('972363266439249920', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972363266422472704\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"删除\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '5', '2018-03-10 14:47:23'), ('972363460920737792', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972363266422472704\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"删除\",\"perms\":\"user:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-10 14:48:09'), ('972363649798635520', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972363077989171200\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"新增\",\"perms\":\"user:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-10 14:48:54'), ('972363701963194368', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972363158259761152\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"查看\",\"perms\":\"user:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-10 14:49:07'), ('972363753708322816', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972363222688464896\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"修改\",\"perms\":\"user:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-10 14:49:19'), ('972363810335621120', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972353737039282176\",\"parentId\":\"972352025666781184\",\"parentName\":\"用户管理\",\"name\":\"用户列表\",\"url\":\"modules/user/user.html\",\"perms\":\"\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '9', '2018-03-10 14:49:33'), ('972365191419265024', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972353737039282176\",\"parentId\":\"972352025666781184\",\"parentName\":\"用户管理\",\"name\":\"用户列表\",\"url\":\"modules/user/user.html\",\"perms\":\"\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '27', '2018-03-10 14:55:02'), ('972365454184022016', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972353737039282176\",\"parentId\":\"972352025666781184\",\"parentName\":\"用户管理\",\"name\":\"用户列表\",\"url\":\"modules/user/user.html\",\"perms\":\"\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '39', '2018-03-10 14:56:05'), ('972365600183549952', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972353737039282176\",\"parentId\":\"972352025666781184\",\"parentName\":\"用户管理\",\"name\":\"用户列表\",\"url\":\"modules/user/user.html\",\"perms\":\"\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-10 14:56:39'), ('972366577783537664', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972363158259761152\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"查看\",\"perms\":\"user:info,user:list\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-10 15:00:32'), ('972474299422081024', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972363158259761152\",\"parentId\":\"972353737039282176\",\"parentName\":\"用户列表\",\"name\":\"查看\",\"perms\":\"user:info,user:list,user:address:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '24', '2018-03-10 22:08:35'), ('972672828446867456', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972672828342009856\",\"parentId\":\"0\",\"parentName\":\"一级菜单\",\"name\":\"商品管理\",\"type\":0,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '35', '2018-03-11 11:17:28'), ('972673411849388032', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972673411820027904\",\"parentId\":\"972672828342009856\",\"parentName\":\"商品管理\",\"name\":\"商品列表\",\"url\":\"modules/product/product.html\",\"type\":1,\"orderNum\":0}', '127.0.0.1', '13', '2018-03-11 11:19:47'), ('972673540459331584', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972673540434165760\",\"parentId\":\"972673411820027904\",\"parentName\":\"商品列表\",\"name\":\"列表\",\"perms\":\"product:list\",\"type\":2,\"orderNum\":0}', '127.0.0.1', '8', '2018-03-11 11:20:18'), ('972680693425373184', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972673540434165760\",\"parentId\":\"972673411820027904\",\"parentName\":\"商品列表\",\"name\":\"列表\",\"perms\":\"product:list,product:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '34', '2018-03-11 11:48:44'), ('972684495415148544', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972673540434165760\",\"parentId\":\"972673411820027904\",\"parentName\":\"商品列表\",\"name\":\"列表\",\"perms\":\"product:list,product:update,product:importdata\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-11 12:03:50'), ('972685558398582784', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972685558365028352\",\"parentId\":\"972673411820027904\",\"parentName\":\"商品列表\",\"name\":\"导入商品数据\",\"perms\":\"product:importdata\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '11', '2018-03-11 12:08:03'), ('972687635212402688', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"972672828342009856\",\"972673411820027904\",\"972673540434165760\",\"1\",\"2\",\"4\",\"6\",\"3\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '89', '2018-03-11 12:16:19'), ('972687863055384576', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"972672828342009856\",\"972673411820027904\",\"972673540434165760\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '17', '2018-03-11 12:17:13'), ('972688055477469184', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972673540434165760\",\"parentId\":\"972673411820027904\",\"parentName\":\"商品列表\",\"name\":\"列表\",\"perms\":\"product:list,product:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-11 12:17:59'), ('972720182013198336', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972720181895757824\",\"parentId\":\"0\",\"parentName\":\"一级菜单\",\"name\":\"宝宝教育\",\"type\":0,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '21', '2018-03-11 14:25:38'), ('972720443066679296', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972720443024736256\",\"parentId\":\"972720181895757824\",\"parentName\":\"宝宝教育\",\"name\":\"音频内容\",\"url\":\"modules/info/audio.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '14', '2018-03-11 14:26:41'), ('972721031816937472', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972720443024736256\",\"parentId\":\"972720181895757824\",\"parentName\":\"宝宝教育\",\"name\":\"音频内容\",\"url\":\"modules/info/audio.html\",\"perms\":\"info:audio:list\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-11 14:29:01'), ('972724081059168256', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972724081034002432\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"音频列表\",\"url\":\"modules/info/audio.html\",\"perms\":\"info:audio:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-11 14:41:08'), ('972751683769597952', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972720443024736256\",\"parentId\":\"972720181895757824\",\"parentName\":\"宝宝教育\",\"name\":\"音频内容\",\"url\":\"modules/info/audio.html\",\"perms\":\"info:audio:list\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '11', '2018-03-11 16:30:49'), ('972751835519516672', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972724081034002432\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"音频列表\",\"url\":\"modules/info/audio.html\",\"perms\":\"info:audio:save,info:audio:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-11 16:31:25'), ('972753601040482304', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972724081034002432\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"音频列表\",\"url\":\"\",\"perms\":\"info:audio:save,info:audio:info,info:audio:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '5', '2018-03-11 16:38:26'), ('972758184773025792', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972724081034002432\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"音频列表\",\"url\":\"\",\"perms\":\"info:audio:save,info:audio:info,info:audio:update,info:audio:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '19', '2018-03-11 16:56:39'), ('972758389773828096', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972720443024736256\",\"parentId\":\"972720181895757824\",\"parentName\":\"宝宝教育\",\"name\":\"音频内容\",\"url\":\"modules/info/audio.html\",\"perms\":\"info:audio:list,info:audio:delete\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-11 16:57:28'), ('972758457021104128', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972724081034002432\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"音频列表\",\"url\":\"\",\"perms\":\"info:audio:save,info:audio:info,info:audio:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-11 16:57:44'), ('972777389278887936', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972777389236944896\",\"parentId\":\"972720181895757824\",\"parentName\":\"宝宝教育\",\"name\":\"课程列表\",\"url\":\"modules/classes/room.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-11 18:12:58'), ('972777932571279360', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972777932558696448\",\"parentId\":\"972777389236944896\",\"parentName\":\"课程列表\",\"name\":\"查看\",\"perms\":\"classes:room:list\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '5', '2018-03-11 18:15:07'), ('972778053027495936', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972778053006524416\",\"parentId\":\"972777389236944896\",\"parentName\":\"课程列表\",\"name\":\"修改\",\"perms\":\"classes:room:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '5', '2018-03-11 18:15:36'), ('972778164134608896', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972778164109443072\",\"parentId\":\"972777389236944896\",\"parentName\":\"课程列表\",\"name\":\"删除\",\"perms\":\"classes:room:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-11 18:16:02'), ('972778335471927296', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"972778335455150080\",\"parentId\":\"972777389236944896\",\"parentName\":\"课程列表\",\"name\":\"查看\",\"perms\":\"classes:room:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '5', '2018-03-11 18:16:43'), ('972778392501878784', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"1\",\"name\":\"系统管理员角色\",\"remark\":\"系统管理员角色\",\"menuIdList\":[\"1\",\"2\",\"6\",\"3\",\"4\",\"5\",\"12\",\"14\",\"15\",\"16\",\"13\",\"17\",\"18\",\"19\",\"20\",\"21\",\"22\",\"26\",\"23\",\"24\",\"25\",\"27\",\"30\",\"28\",\"31\",\"29\",\"32\",\"54\",\"33\",\"972672828342009856\",\"972673411820027904\",\"972673540434165760\",\"972685558365028352\",\"972720181895757824\",\"972720443024736256\",\"972724081034002432\",\"972777389236944896\",\"972777932558696448\",\"972778053006524416\",\"972778164109443072\",\"972778335455150080\",\"972352025666781184\",\"972353737039282176\",\"972363266422472704\",\"972363077989171200\",\"972363158259761152\",\"972363222688464896\",\"50\",\"51\",\"52\",\"53\"],\"createTime\":\"Mar 9, 2018 6:44:37 PM\"}', '0:0:0:0:0:0:0:1', '59', '2018-03-11 18:16:57'), ('972779581620617216', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972778335455150080\",\"parentId\":\"972777389236944896\",\"parentName\":\"课程列表\",\"name\":\"保存\",\"perms\":\"classes:room:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-11 18:21:40'), ('972779684481728512', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972777932558696448\",\"parentId\":\"972777389236944896\",\"parentName\":\"课程列表\",\"name\":\"查看\",\"perms\":\"classes:room:list,classes:room:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '6', '2018-03-11 18:22:05'), ('973167019295768576', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973167019228659712\",\"parentId\":\"972720181895757824\",\"parentName\":\"宝宝教育\",\"name\":\"讲师列表\",\"url\":\"modules/lecturer/lecturer.html\",\"perms\":\"\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '23', '2018-03-12 20:01:13'), ('973167138304950272', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973167138279784448\",\"parentId\":\"973167019228659712\",\"parentName\":\"讲师列表\",\"name\":\"查看\",\"perms\":\"lecturer:list,lecturer:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-12 20:01:41'), ('973167211571052544', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973167211554275328\",\"parentId\":\"973167019228659712\",\"parentName\":\"讲师列表\",\"name\":\"更新\",\"perms\":\"lecturer:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '7', '2018-03-12 20:01:58'), ('973167274863099904', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973167274825351168\",\"parentId\":\"973167019228659712\",\"parentName\":\"讲师列表\",\"name\":\"删除\",\"perms\":\"lecturer:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '11', '2018-03-12 20:02:14'), ('973167861411348480', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"1\",\"name\":\"系统管理员角色\",\"remark\":\"系统管理员角色\",\"menuIdList\":[\"972720181895757824\",\"973167019228659712\",\"973167211554275328\",\"973167274825351168\",\"973167138279784448\",\"972720443024736256\",\"972724081034002432\",\"972777389236944896\",\"972778053006524416\",\"972778164109443072\",\"972778335455150080\",\"972777932558696448\",\"972352025666781184\",\"972353737039282176\",\"972363222688464896\",\"972363266422472704\",\"972363077989171200\",\"972363158259761152\",\"972672828342009856\",\"972673411820027904\",\"972673540434165760\",\"972685558365028352\",\"1\",\"2\",\"5\",\"6\",\"3\",\"4\",\"12\",\"16\",\"13\",\"14\",\"15\",\"17\",\"20\",\"21\",\"18\",\"19\",\"22\",\"24\",\"25\",\"26\",\"23\",\"27\",\"29\",\"30\",\"28\",\"31\",\"32\",\"54\",\"33\",\"50\",\"51\",\"53\",\"52\"],\"createTime\":\"Mar 9, 2018 6:44:37 PM\"}', '0:0:0:0:0:0:0:1', '95', '2018-03-12 20:04:33'), ('973168058572996608', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973168058535247872\",\"parentId\":\"973167019228659712\",\"parentName\":\"讲师列表\",\"name\":\"新增\",\"perms\":\"lecturer:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-12 20:05:20'), ('973530250589765632', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973530250531045376\",\"parentId\":\"0\",\"parentName\":\"一级菜单\",\"name\":\"妈妈知道\",\"type\":0,\"icon\":\"fas fa-assistive-listening-systems\",\"orderNum\":0}', '0:0:0:0:0:0:0:1', '12', '2018-03-13 20:04:34'), ('973530535743717376', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973530535718551552\",\"parentId\":\"973530250531045376\",\"parentName\":\"妈妈知道\",\"name\":\"主题列表\",\"url\":\"modules/category/category.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '9', '2018-03-13 20:05:42'), ('973530626231631872', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973530626214854656\",\"parentId\":\"973530535718551552\",\"parentName\":\"主题列表\",\"name\":\"查看\",\"perms\":\"category:list,category:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '6', '2018-03-13 20:06:03'), ('973530695848689664', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973530695831912448\",\"parentId\":\"973530535718551552\",\"parentName\":\"主题列表\",\"name\":\"修改\",\"perms\":\"category:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '6', '2018-03-13 20:06:20'), ('973530757840502784', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973530757819531264\",\"parentId\":\"973530535718551552\",\"parentName\":\"主题列表\",\"name\":\"删除\",\"perms\":\"category:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '5', '2018-03-13 20:06:35'), ('973530819551297536', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973530819517743104\",\"parentId\":\"973530535718551552\",\"parentName\":\"主题列表\",\"name\":\"新增\",\"perms\":\"category:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-13 20:06:49'), ('973530960467329024', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"973530250531045376\",\"parentId\":\"0\",\"parentName\":\"一级菜单\",\"name\":\"妈妈知道\",\"type\":0,\"icon\":\"fa fa-th-list\",\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-13 20:07:23'), ('973545526488203264', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973545526416900096\",\"parentId\":\"973530250531045376\",\"parentName\":\"妈妈知道\",\"name\":\"孕检报告\",\"url\":\"modules/info/infoPregnancyCheck.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '21', '2018-03-13 21:05:16'), ('973545745124687872', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973545745091133440\",\"parentId\":\"973545526416900096\",\"parentName\":\"孕检报告\",\"name\":\"查看\",\"perms\":\"info:pregnancycheck:list,info:pregnancycheck:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '8', '2018-03-13 21:06:08'), ('973545824191512576', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973545824149569536\",\"parentId\":\"973545526416900096\",\"parentName\":\"孕检报告\",\"name\":\"新增\",\"perms\":\"info:pregnancycheck:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '12', '2018-03-13 21:06:27'), ('973545886128799744', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973545886107828224\",\"parentId\":\"973545526416900096\",\"parentName\":\"孕检报告\",\"name\":\"删除\",\"perms\":\"info:pregnancycheck:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '7', '2018-03-13 21:06:42'), ('973545941103542272', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973545941074182144\",\"parentId\":\"973545526416900096\",\"parentName\":\"孕检报告\",\"name\":\"更新\",\"perms\":\"info:pregnancycheck:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-13 21:06:55'), ('973546958125793280', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972720443024736256\",\"parentId\":\"972720181895757824\",\"parentName\":\"宝宝教育\",\"name\":\"音频内容\",\"url\":\"modules/info/audio.html\",\"perms\":\"\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '9', '2018-03-13 21:10:57'), ('973547348070236160', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973547348049264640\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"修改\",\"perms\":\"info:audio:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '6', '2018-03-13 21:12:30'), ('973547502424817664', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"972724081034002432\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"查看\",\"url\":\"\",\"perms\":\"info:audio:info,info:audio:list\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '9', '2018-03-13 21:13:07'), ('973547635468140544', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973547635438780416\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"增加\",\"perms\":\"info:audio:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '9', '2018-03-13 21:13:39'), ('973547706771308544', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973547706750337024\",\"parentId\":\"972720443024736256\",\"parentName\":\"音频内容\",\"name\":\"删除\",\"perms\":\"info:audio:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '5', '2018-03-13 21:13:56'), ('973559366487638016', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973559366403751936\",\"parentId\":\"973530250531045376\",\"parentName\":\"妈妈知道\",\"name\":\"文章列表\",\"url\":\"modules/info/info.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '24', '2018-03-13 22:00:15'), ('973559522880651264', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973559522851291136\",\"parentId\":\"973559366403751936\",\"parentName\":\"文章列表\",\"name\":\"查看\",\"perms\":\"info:list,info:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-13 22:00:53'), ('973559598382317568', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973559598348763136\",\"parentId\":\"973559366403751936\",\"parentName\":\"文章列表\",\"name\":\"增加\",\"perms\":\"info:add\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '12', '2018-03-13 22:01:11'), ('973559711100043264', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973559711079071744\",\"parentId\":\"973559366403751936\",\"parentName\":\"文章列表\",\"name\":\"更新\",\"perms\":\"info:update\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '6', '2018-03-13 22:01:38'), ('973559898509934592', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"973559598348763136\",\"parentId\":\"973559366403751936\",\"parentName\":\"文章列表\",\"name\":\"增加\",\"perms\":\"info:save\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-13 22:02:22'), ('973560018051792896', 'admin', '保存菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.save()', '{\"id\":\"973560018005655552\",\"parentId\":\"973559366403751936\",\"parentName\":\"文章列表\",\"name\":\"删除\",\"perms\":\"info:delete\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-13 22:02:51');
COMMIT;

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`parent_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0' ,
`name`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称' ,
`url`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单URL' ,
`perms`  varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)' ,
`type`  tinyint(4) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮' ,
`icon`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标' ,
`order_num`  int(11) NULL DEFAULT NULL COMMENT '排序号' ,
PRIMARY KEY (`id`),
INDEX `parent_id` (`parent_id`) USING BTREE ,
INDEX `type` (`type`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='菜单管理'

;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cogs', '0'), ('12', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '3'), ('13', '12', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0'), ('14', '12', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0'), ('15', '12', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0'), ('16', '12', '删除', null, 'sys:role:delete', '2', null, '0'), ('17', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '4'), ('18', '17', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0'), ('19', '17', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0'), ('2', '1', '用户管理', 'modules/sys/user.html', null, '1', 'fa fa-user', '1'), ('20', '17', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0'), ('21', '17', '删除', null, 'sys:menu:delete', '2', null, '0'), ('22', '1', '字典管理', 'modules/sys/config.html', null, '1', 'fa fa-sun-o', '5'), ('23', '22', '查看', null, 'sys:config:list,sys:config:info', '2', null, '0'), ('24', '22', '新增', null, 'sys:config:save', '2', null, '0'), ('25', '22', '修改', null, 'sys:config:update', '2', null, '0'), ('26', '22', '删除', null, 'sys:config:delete', '2', null, '0'), ('27', '1', '资源管理', 'modules/sys/attachment.html', '', '1', 'fa fa-file-image-o', '6'), ('28', '27', '查看', null, 'sys:attachment:list,sys:attachment:info', '2', null, '0'), ('29', '27', '删除', null, 'sys:attachment:delete', '2', null, '0'), ('3', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0'), ('30', '27', '上传文件', null, 'sys:attachment:upload', '2', null, '0'), ('31', '27', '下载文件', null, 'sys:attachment:download', '2', null, '0'), ('32', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-pencil', '7'), ('33', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '8'), ('4', '2', '新增', null, 'sys:user:save,sys:role:select,sys:dept:select,sys:dept:list', '2', null, '0'), ('5', '2', '修改', null, 'sys:user:update,sys:role:select,sys:dept:select,sys:dept:list', '2', null, '0'), ('50', '0', '代码生成器', null, null, '0', 'fa fa-support', '2'), ('51', '50', '代码生成', 'modules/sys/generator.html', null, '1', 'fa fa-rocket', '1'), ('52', '51', '查看', null, 'sys:generator:list', '2', null, '0'), ('53', '51', '生成代码', null, 'sys:generator:code', '2', null, '0'), ('54', '32', '查看', null, 'sys:log:info', '2', null, '0'), ('6', '2', '删除', null, 'sys:user:delete', '2', null, '0'), ('972352025666781184', '0', '用户管理', null, null, '0', 'fa fa-user', '0'), ('972353737039282176', '972352025666781184', '用户列表', 'modules/user/user.html', '', '1', null, '0'), ('972363077989171200', '972353737039282176', '新增', null, 'user:save', '2', null, '0'), ('972363158259761152', '972353737039282176', '查看', null, 'user:info,user:list,user:address:update', '2', null, '0'), ('972363222688464896', '972353737039282176', '修改', null, 'user:update', '2', null, '0'), ('972363266422472704', '972353737039282176', '删除', null, 'user:delete', '2', null, '0'), ('972672828342009856', '0', '商品管理', null, null, '0', 'fa fa-th-list', '0'), ('972673411820027904', '972672828342009856', '商品列表', 'modules/product/product.html', null, '1', null, '0'), ('972673540434165760', '972673411820027904', '列表', null, 'product:list,product:update', '2', null, '0'), ('972685558365028352', '972673411820027904', '导入商品数据', null, 'product:importdata', '2', null, '0'), ('972720181895757824', '0', '宝宝教育', null, null, '0', 'fa fa-th-list', '0'), ('972720443024736256', '972720181895757824', '音频内容', 'modules/info/audio.html', '', '1', null, '0'), ('972724081034002432', '972720443024736256', '查看', '', 'info:audio:info,info:audio:list', '2', null, '0'), ('972777389236944896', '972720181895757824', '课程列表', 'modules/classes/classRoom.html', null, '1', null, '0'), ('972777932558696448', '972777389236944896', '查看', null, 'classes:room:list,classes:room:info', '2', null, '0'), ('972778053006524416', '972777389236944896', '修改', null, 'classes:room:update', '2', null, '0'), ('972778164109443072', '972777389236944896', '删除', null, 'classes:room:delete', '2', null, '0'), ('972778335455150080', '972777389236944896', '保存', null, 'classes:room:save', '2', null, '0'), ('973167019228659712', '972720181895757824', '讲师列表', 'modules/lecturer/lecturer.html', '', '1', null, '0'), ('973167138279784448', '973167019228659712', '查看', null, 'lecturer:list,lecturer:info', '2', null, '0'), ('973167211554275328', '973167019228659712', '更新', null, 'lecturer:update', '2', null, '0'), ('973167274825351168', '973167019228659712', '删除', null, 'lecturer:delete', '2', null, '0'), ('973168058535247872', '973167019228659712', '新增', null, 'lecturer:save', '2', null, '0'), ('973378461085204480', '972720181895757824', '视频列表', 'modules/classes/classRoomVideo.html', null, '1', null, '0'), ('973378638273576960', '973378461085204480', '查看', null, 'classes:room:video:list,classes:room:video:info', '2', null, '0'), ('973378737091379200', '973378461085204480', '修改', null, 'classes:room:video:update', '2', null, '0'), ('973378844645916672', '973378461085204480', '新增', null, 'classes:room:video:save', '2', null, '0'), ('973378927433089024', '973378461085204480', '删除', null, 'classes:room:video:delete', '2', null, '0'), ('973433225743433728', '0', '广告管理', '', null, '0', 'fa fa-th-list', '0'), ('973433399811244032', '973435430147981312', '查看', null, 'banner:list,banner:info', '2', null, '0'), ('973433566761320448', '973435430147981312', '更新', null, 'banner:update', '2', null, '0'), ('973433650831949824', '973435430147981312', '删除', null, 'banner:delete', '2', null, '0'), ('973433972765753344', '973435430147981312', '上下线', null, 'banner:upordown', '2', null, '0'), ('973434072833458176', '973435430147981312', '置顶', null, 'banner:top', '2', null, '0'), ('973435430147981312', '973433225743433728', '广告列表', 'modules/banner/banner.html', null, '1', null, '0'), ('973436677840175104', '973435430147981312', '新增', null, 'banner:save', '2', null, '0'), ('973530250531045376', '0', '妈妈知道', null, null, '0', 'fa fa-th-list', '0'), ('973530535718551552', '973530250531045376', '主题列表', 'modules/category/category.html', null, '1', null, '0'), ('973530626214854656', '973530535718551552', '查看', null, 'category:list,category:info', '2', null, '0'), ('973530695831912448', '973530535718551552', '修改', null, 'category:update', '2', null, '0'), ('973530757819531264', '973530535718551552', '删除', null, 'category:delete', '2', null, '0'), ('973530819517743104', '973530535718551552', '新增', null, 'category:save', '2', null, '0'), ('973545526416900096', '973530250531045376', '孕检报告', 'modules/info/infoPregnancyCheck.html', null, '1', null, '0'), ('973545745091133440', '973545526416900096', '查看', null, 'info:pregnancycheck:list,info:pregnancycheck:info', '2', null, '0'), ('973545824149569536', '973545526416900096', '新增', null, 'info:pregnancycheck:save', '2', null, '0'), ('973545886107828224', '973545526416900096', '删除', null, 'info:pregnancycheck:delete', '2', null, '0'), ('973545941074182144', '973545526416900096', '更新', null, 'info:pregnancycheck:update', '2', null, '0'), ('973547348049264640', '972720443024736256', '修改', null, 'info:audio:update', '2', null, '0'), ('973547635438780416', '972720443024736256', '增加', null, 'info:audio:save', '2', null, '0'), ('973547706750337024', '972720443024736256', '删除', null, 'info:audio:delete', '2', null, '0'), ('973559366403751936', '973530250531045376', '文章列表', 'modules/info/info.html', null, '1', null, '0'), ('973559522851291136', '973559366403751936', '查看', null, 'info:list,info:info', '2', null, '0'), ('973559598348763136', '973559366403751936', '增加', null, 'info:save', '2', null, '0'), ('973559711079071744', '973559366403751936', '更新', null, 'info:update', '2', null, '0'), ('973560018005655552', '973559366403751936', '删除', null, 'info:delete', '2', null, '0');
COMMIT;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称' ,
`remark`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`),
INDEX `name` (`name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='角色'

;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '系统管理员角色', '系统管理员角色', '2018-03-09 18:44:37'), ('972092550984761344', '运营角色', '运营角色', '2018-03-09 20:51:39');
COMMIT;

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`role_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色ID' ,
`menu_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单ID' ,
PRIMARY KEY (`id`),
INDEX `role_id` (`role_id`) USING BTREE ,
INDEX `menu_id` (`menu_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='角色与菜单对应关系'

;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES ('972687863042801664', '972092550984761344', '972672828342009856'), ('972687863042801665', '972092550984761344', '972673411820027904'), ('972687863042801666', '972092550984761344', '972673540434165760'), ('973167861369405440', '1', '972720181895757824'), ('973167861369405441', '1', '973167019228659712'), ('973167861369405442', '1', '973167211554275328'), ('973167861369405443', '1', '973167274825351168'), ('973167861369405444', '1', '973167138279784448'), ('973167861369405445', '1', '972720443024736256'), ('973167861369405446', '1', '972724081034002432'), ('973167861369405447', '1', '972777389236944896'), ('973167861369405448', '1', '972778053006524416'), ('973167861369405449', '1', '972778164109443072'), ('973167861369405450', '1', '972778335455150080'), ('973167861369405451', '1', '972777932558696448'), ('973167861369405452', '1', '972352025666781184'), ('973167861369405453', '1', '972353737039282176'), ('973167861369405454', '1', '972363222688464896'), ('973167861369405455', '1', '972363266422472704'), ('973167861369405456', '1', '972363077989171200'), ('973167861369405457', '1', '972363158259761152'), ('973167861369405458', '1', '972672828342009856'), ('973167861369405459', '1', '972673411820027904'), ('973167861369405460', '1', '972673540434165760'), ('973167861369405461', '1', '972685558365028352'), ('973167861369405462', '1', '1'), ('973167861369405463', '1', '2'), ('973167861369405464', '1', '5'), ('973167861369405465', '1', '6'), ('973167861369405466', '1', '3'), ('973167861369405467', '1', '4'), ('973167861369405468', '1', '12'), ('973167861369405469', '1', '16'), ('973167861369405470', '1', '13'), ('973167861369405471', '1', '14'), ('973167861369405472', '1', '15'), ('973167861369405473', '1', '17'), ('973167861369405474', '1', '20'), ('973167861369405475', '1', '21'), ('973167861369405476', '1', '18'), ('973167861369405477', '1', '19'), ('973167861369405478', '1', '22'), ('973167861369405479', '1', '24'), ('973167861369405480', '1', '25'), ('973167861369405481', '1', '26'), ('973167861369405482', '1', '23'), ('973167861369405483', '1', '27'), ('973167861369405484', '1', '29'), ('973167861369405485', '1', '30'), ('973167861369405486', '1', '28'), ('973167861369405487', '1', '31'), ('973167861369405488', '1', '32'), ('973167861369405489', '1', '54'), ('973167861369405490', '1', '33'), ('973167861369405491', '1', '50'), ('973167861369405492', '1', '51'), ('973167861369405493', '1', '53'), ('973167861369405494', '1', '52');
COMMIT;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`username`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名' ,
`nickname`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '别名' ,
`password`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码' ,
`salt`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐' ,
`email`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱' ,
`mobile`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码' ,
`status`  tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `username` (`username`) USING BTREE ,
INDEX `email` (`email`) USING BTREE ,
INDEX `mobile` (`mobile`) USING BTREE ,
INDEX `status` (`status`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='系统用户'

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', '超级管理员', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', null, null, '1', '2016-11-11 11:11:11'), ('2', 'om', '运营用户', 'c1744d470b46a119fba1ed088ada71e9c6229d621de4628d3357193caa1f77f2', 'RECllptZzR0yxVi2Bgpx', null, null, '1', '2018-03-06 07:40:31');
COMMIT;

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户ID' ,
`role_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色ID' ,
PRIMARY KEY (`id`),
INDEX `user_id` (`user_id`) USING BTREE ,
INDEX `role_id` (`role_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='用户与角色对应关系'

;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('4', '1', '1'), ('972093623032086528', '2', '972092550984761344');
COMMIT;

-- ----------------------------
-- Table structure for `sys_user_token`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_id`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户ID' ,
`token`  varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token' ,
`expire_time`  datetime NULL DEFAULT NULL COMMENT '过期时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
PRIMARY KEY (`id`),
INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='系统用户Token'

;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_token` VALUES ('972060654275919872', '1', '97fab071546dfd3941c7c73ce9e62c60', '2018-03-14 21:03:32', '2018-03-13 21:03:32'), ('972092769633828864', '2', '73e32573dd4558367398c7a0fed30a01', '2018-03-12 12:18:18', '2018-03-11 12:18:18');
COMMIT;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`tel`  char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码' ,
`salt`  bigint(20) UNSIGNED NOT NULL COMMENT '胡椒面' ,
`password`  char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
`openid_weixin`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信' ,
`openid_weibo`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微博' ,
`openid_qq`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'QQ' ,
`user_type`  tinyint(4) NOT NULL COMMENT '用户类型(保留)' ,
`user_type_expires_in`  int(10) UNSIGNED NOT NULL COMMENT '用户类型时效' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`user_id`),
UNIQUE INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户'

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1520666805778', '1520666805778', '1', '1', '0', '972367289095553024', '1', '1', '1', '1', '1', '1', '1', '1', '0'), ('1520666805778', '1520666805778', '5', '5', '0', '972368875804950528', '5', '5', '5', '5', '5', '5', '5', '5', '1');
COMMIT;

-- ----------------------------
-- Table structure for `user_address`
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
`user_address_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户收货地址id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`nickname`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称-姓名' ,
`tel`  char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码' ,
`address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址' ,
`post_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮编' ,
`default_flag`  tinyint(1) NOT NULL COMMENT '默认使用标识' ,
PRIMARY KEY (`user_address_id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_address_id` (`user_address_id`) USING BTREE ,
INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_收货地址'

;

-- ----------------------------
-- Records of user_address
-- ----------------------------
BEGIN;
INSERT INTO `user_address` VALUES ('1', '972368875804950528', '逗你玩', '15542578070', '大连', '138001', '1'), ('2', '972368875804950528', '再次逗你玩', '15842606424', '北京', '130000', '1');
COMMIT;

-- ----------------------------
-- Table structure for `user_baby`
-- ----------------------------
DROP TABLE IF EXISTS `user_baby`;
CREATE TABLE `user_baby` (
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`cloud_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`nickname`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称-姓名' ,
`gender`  tinyint(4) NOT NULL COMMENT '性别(1男2女)' ,
`birthday`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出生日期' ,
`tip_flag`  tinyint(1) NOT NULL COMMENT '提醒标识' ,
PRIMARY KEY (`user_id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_宝宝信息'

;

-- ----------------------------
-- Records of user_baby
-- ----------------------------
BEGIN;
INSERT INTO `user_baby` VALUES ('972368875804950528', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'baby nick name', '1', '1985-09-20', '1');
COMMIT;

-- ----------------------------
-- Table structure for `user_comment`
-- ----------------------------
DROP TABLE IF EXISTS `user_comment`;
CREATE TABLE `user_comment` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_comment_id`  bigint(20) UNSIGNED NOT NULL COMMENT '评论id' ,
`info_id`  bigint(20) UNSIGNED NOT NULL COMMENT '信息id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '评论用户id' ,
`receiver`  bigint(20) UNSIGNED NOT NULL COMMENT '消息接收者用户id' ,
`detail`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情100' ,
`parent_id`  bigint(20) UNSIGNED NOT NULL COMMENT '父类id' ,
`parent_detail`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父类评论' ,
PRIMARY KEY (`user_comment_id`),
FOREIGN KEY (`info_id`) REFERENCES `info` (`info_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_comment_id` (`user_comment_id`) USING BTREE ,
INDEX `info_id` (`info_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_评论'

;

-- ----------------------------
-- Records of user_comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `user_detail`
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`cloud_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`nickname`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称-姓名' ,
`gender`  tinyint(4) NOT NULL COMMENT '性别(1男2女)' ,
`birthday`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出生日期' ,
`tel`  char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`user_id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_详情'

;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
BEGIN;
INSERT INTO `user_detail` VALUES ('972368875804950528', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'user detail nick name', '1', '1985-09-20', '15542578070', '1');
COMMIT;

-- ----------------------------
-- Table structure for `user_favorite_audio`
-- ----------------------------
DROP TABLE IF EXISTS `user_favorite_audio`;
CREATE TABLE `user_favorite_audio` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_favorite_audio_id`  bigint(20) UNSIGNED NOT NULL COMMENT '收藏id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`info_audio_id`  bigint(20) UNSIGNED NOT NULL COMMENT '信息id' ,
PRIMARY KEY (`user_favorite_audio_id`),
FOREIGN KEY (`info_audio_id`) REFERENCES `info_audio` (`info_audio_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_favorite_audio_id` (`user_favorite_audio_id`) USING BTREE ,
INDEX `info_audio_id` (`info_audio_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_收藏_音频'

;

-- ----------------------------
-- Records of user_favorite_audio
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `user_favorite_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_favorite_info`;
CREATE TABLE `user_favorite_info` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_favorite_info_id`  bigint(20) UNSIGNED NOT NULL COMMENT '收藏id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`info_id`  bigint(20) UNSIGNED NOT NULL COMMENT '信息id' ,
PRIMARY KEY (`user_favorite_info_id`),
FOREIGN KEY (`info_id`) REFERENCES `info` (`info_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_favorite_info_id` (`user_favorite_info_id`) USING BTREE ,
INDEX `info_id` (`info_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_收藏_文章'

;

-- ----------------------------
-- Records of user_favorite_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `user_login`
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
`user_login_id`  bigint(20) UNSIGNED NOT NULL COMMENT '主键' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`rong_token`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '融云token' ,
`login_token`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录toke键' ,
`login_salt`  bigint(20) UNSIGNED NOT NULL COMMENT '登录胡椒面' ,
`login_expires_in`  int(10) UNSIGNED NOT NULL COMMENT '失效时间' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`user_login_id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_login_id` (`user_login_id`) USING BTREE ,
INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户登录'

;

-- ----------------------------
-- Records of user_login
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `user_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_message_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户消息id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`message_type`  tinyint(4) NOT NULL COMMENT '消息类型' ,
`message_type_id`  bigint(20) UNSIGNED NOT NULL COMMENT '消息类型id' ,
`message_detail`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`user_message_id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_message_id` (`user_message_id`) USING BTREE ,
INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_消息'

;

-- ----------------------------
-- Records of user_message
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `user_order`
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_order_id`  bigint(20) UNSIGNED NOT NULL COMMENT '订单id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`product_id`  bigint(20) UNSIGNED NOT NULL COMMENT '产品id' ,
`product_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号' ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`points`  int(10) UNSIGNED NOT NULL COMMENT '积分点数' ,
`nickname`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称-姓名' ,
`tel`  char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码' ,
`address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址' ,
`post_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮编' ,
`tracking_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递单号' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '订单状态（1兑换中 2已发货 3已收货） : （1兑换中 2已发货 3已收货）' ,
PRIMARY KEY (`user_order_id`),
FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_order_id` (`user_order_id`) USING BTREE ,
INDEX `product_id` (`product_id`) USING BTREE ,
INDEX `user_id` (`user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='订单（兑换）'

;

-- ----------------------------
-- Records of user_order
-- ----------------------------
BEGIN;
INSERT INTO `user_order` VALUES ('1520731199712', '1520731199712', '0', '972643264328892416', '0', '972643264328892416', '972368875804950528', '97264326432889241', '972643264328892416', '1', '100', 'nick name', '15542578070', '大连', '15842606424', '5555555', '1');
COMMIT;

-- ----------------------------
-- Table structure for `user_play_audio`
-- ----------------------------
DROP TABLE IF EXISTS `user_play_audio`;
CREATE TABLE `user_play_audio` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_play_audio_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户播放音频id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`info_audio_id`  bigint(20) UNSIGNED NOT NULL COMMENT '信息id' ,
PRIMARY KEY (`user_play_audio_id`),
FOREIGN KEY (`info_audio_id`) REFERENCES `info_audio` (`info_audio_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_play_audio_id` (`user_play_audio_id`) USING BTREE ,
INDEX `info_audio_id` (`info_audio_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_播放_音频'

;

-- ----------------------------
-- Records of user_play_audio
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `user_share`
-- ----------------------------
DROP TABLE IF EXISTS `user_share`;
CREATE TABLE `user_share` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作ip' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户id' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_share_audio_id`  bigint(20) UNSIGNED NOT NULL COMMENT '分享id' ,
`user_share_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '用户分享类型(1音频 2文章)' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`info_id`  bigint(20) UNSIGNED NOT NULL COMMENT '分享的信息id' ,
PRIMARY KEY (`user_share_audio_id`),
UNIQUE INDEX `user_share_audio_id` (`user_share_audio_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_分享'

;

-- ----------------------------
-- Records of user_share
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `user_statistics`
-- ----------------------------
DROP TABLE IF EXISTS `user_statistics`;
CREATE TABLE `user_statistics` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_statistics_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户统计id' ,
`statistics_key`  tinyint(3) UNSIGNED NOT NULL COMMENT 'key : 1 用户注册时间yyyyMMdd 2积分 3收藏文章 \r\n4收藏音频 5兑换记录 6转发次数 \r\n7新消息提醒 ' ,
`statistics_value`  int(10) UNSIGNED NOT NULL COMMENT 'value' ,
PRIMARY KEY (`user_statistics_id`),
UNIQUE INDEX `user_statistics_id` (`user_statistics_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户统计'

;

-- ----------------------------
-- Records of user_statistics
-- ----------------------------
BEGIN;
INSERT INTO `user_statistics` VALUES ('2', '2', '2', '972368875804950528', '0', '972367289095553000', '4', '200'), ('3', '3', '3', '972368875804950528', '0', '972367289095553001', '5', '400'), ('4', '4', '4', '972368875804950528', '0', '972367289095553002', '6', '300'), ('5', '5', '5', '972368875804950528', '0', '972367289095553005', '2', '105'), ('6', '6', '6', '972368875804950528', '0', '972367289095553008', '1', '20180310'), ('1', '1', '1', '972368875804950528', '0', '972367289095553030', '3', '100');
COMMIT;

-- ----------------------------
-- Table structure for `user_vaccine`
-- ----------------------------
DROP TABLE IF EXISTS `user_vaccine`;
CREATE TABLE `user_vaccine` (
`create_time`  bigint(20) UNSIGNED NOT NULL COMMENT '添加时间' ,
`modify_time`  bigint(20) UNSIGNED NOT NULL COMMENT '更新时间' ,
`oper_ip`  int(10) UNSIGNED NOT NULL COMMENT '操作IP(保留0)' ,
`oper_user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '操作用户ID' ,
`del_flag`  tinyint(1) NOT NULL COMMENT '删除标识' ,
`user_vaccine_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户疫苗id' ,
`user_id`  bigint(20) UNSIGNED NOT NULL COMMENT '用户id' ,
`vaccine_id`  bigint(20) UNSIGNED NOT NULL COMMENT '疫苗id' ,
PRIMARY KEY (`user_vaccine_id`),
FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`vaccine_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_vaccine_id` (`user_vaccine_id`) USING BTREE ,
INDEX `vaccine_id` (`vaccine_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户_疫苗'

;

-- ----------------------------
-- Records of user_vaccine
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `vaccine`
-- ----------------------------
DROP TABLE IF EXISTS `vaccine`;
CREATE TABLE `vaccine` (
`vaccine_id`  bigint(20) UNSIGNED NOT NULL COMMENT '疫苗id' ,
`title`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`intro`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介' ,
`vaccine_month`  int(10) UNSIGNED NOT NULL COMMENT '接种月份' ,
`times`  int(10) UNSIGNED NOT NULL COMMENT '次数' ,
`must_flag`  tinyint(1) NOT NULL COMMENT '必须标识' ,
`display_order`  int(10) UNSIGNED NOT NULL COMMENT '显示排序' ,
`yufang_jibing`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预防疾病' ,
`jiezhong_yuanyin`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接种原因' ,
`buliang_fanying`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '不良反应' ,
`jiezhong_jinji`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接种禁忌' ,
`state_type`  tinyint(3) UNSIGNED NOT NULL COMMENT '状态类型 : 0未处_无效 1已处_有效' ,
PRIMARY KEY (`vaccine_id`),
UNIQUE INDEX `vaccine_id` (`vaccine_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='疫苗'

;

-- ----------------------------
-- Records of vaccine
-- ----------------------------
BEGIN;
COMMIT;

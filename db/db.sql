/*
Navicat MySQL Data Transfer

Source Server         : db&util
Source Server Version : 50710
Source Host           : 192.168.0.88:3306
Source Database       : boot-cms

Target Server Type    : MYSQL
Target Server Version : 50599
File Encoding         : 65001

Date: 2018-03-09 22:14:43
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `sys_attachment` VALUES ('972111052810485760', '91529822720e0cf3bde5ab8f0c46f21fbe09aab0.jpg', '1', 'http://knowledge-master.oss-cn-hangzhou.aliyuncs.com/knowledge/e1fc9287548e48bd86a654423277adda.jpg?Expires=1835964310&OSSAccessKeyId=LTAIqcXTcQ4gdiKi&Signature=0uH74fRipx%2Bhqd%2B7tXG1mQe8Xn4%3D', 'image/jpeg', '.jpg', '2018-03-09 22:05:11');
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
INSERT INTO `sys_log` VALUES ('972083659517460480', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"1\",\"name\":\"系统管理员角色\",\"remark\":\"系统管理员角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\",\"12\",\"15\",\"16\",\"13\",\"14\",\"17\",\"20\",\"21\",\"18\",\"19\",\"22\",\"24\",\"25\",\"26\",\"23\",\"27\",\"31\",\"29\",\"30\",\"28\",\"32\",\"33\",\"54\"],\"createTime\":\"Mar 9, 2018 6:44:37 PM\"}', '0:0:0:0:0:0:0:1', '2853', '2018-03-09 20:16:20'), ('972083716341891072', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"1\",\"name\":\"系统管理员角色\",\"remark\":\"系统管理员角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\",\"12\",\"15\",\"16\",\"13\",\"14\",\"17\",\"20\",\"21\",\"18\",\"19\",\"22\",\"24\",\"25\",\"26\",\"23\",\"27\",\"31\",\"29\",\"30\",\"28\",\"32\",\"33\",\"54\",\"50\",\"51\",\"53\",\"52\"],\"createTime\":\"Mar 9, 2018 6:44:37 PM\"}', '0:0:0:0:0:0:0:1', '2372', '2018-03-09 20:16:33'), ('972092002919251968', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"32\",\"parentName\":\"系统日志\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '14350', '2018-03-09 20:49:29'), ('972092567334158336', 'admin', '保存角色', 'com.vigekoo.modules.sys.controller.SysRoleController.save()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"27\",\"28\",\"31\",\"29\",\"30\",\"32\",\"54\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3932', '2018-03-09 20:51:43'), ('972092655183855616', 'admin', '删除用户', 'com.vigekoo.modules.sys.controller.SysUserController.delete()', '[\"3\",\"971641717683912704\"]', '0:0:0:0:0:0:0:1', '17', '2018-03-09 20:52:04'), ('972092683239555072', 'admin', '修改用户', 'com.vigekoo.modules.sys.controller.SysUserController.update()', '{\"id\":\"2\",\"username\":\"om\",\"nickname\":\"运营用户\",\"salt\":\"RECllptZzR0yxVi2Bgpx\",\"status\":1,\"roleIdList\":[\"972092550984761344\"],\"createTime\":\"Mar 6, 2018 7:40:31 AM\"}', '0:0:0:0:0:0:0:1', '2246', '2018-03-09 20:52:11'), ('972093458309185536', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3337', '2018-03-09 20:55:16'), ('972093664031408128', 'admin', '修改用户', 'com.vigekoo.modules.sys.controller.SysUserController.update()', '{\"id\":\"2\",\"username\":\"om\",\"nickname\":\"运营用户\",\"salt\":\"RECllptZzR0yxVi2Bgpx\",\"status\":1,\"roleIdList\":[\"972092550984761344\"],\"createTime\":\"Mar 6, 2018 7:40:31 AM\"}', '0:0:0:0:0:0:0:1', '9776', '2018-03-09 20:56:05'), ('972102130817040384', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\",\"12\",\"15\",\"16\",\"13\",\"14\",\"17\",\"20\",\"21\",\"18\",\"19\",\"22\",\"24\",\"25\",\"26\",\"23\",\"27\",\"28\",\"31\",\"29\",\"30\",\"32\",\"54\",\"33\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3657', '2018-03-09 21:29:43'), ('972107559387267072', 'admin', '修改角色', 'com.vigekoo.modules.sys.controller.SysRoleController.update()', '{\"id\":\"972092550984761344\",\"name\":\"运营角色\",\"remark\":\"运营角色\",\"menuIdList\":[\"1\",\"2\",\"4\",\"5\",\"6\",\"3\"],\"createTime\":\"Mar 9, 2018 8:51:39 PM\"}', '0:0:0:0:0:0:0:1', '3296', '2018-03-09 21:51:18'), ('972107897196511232', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"27\",\"parentName\":\"资源管理\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '12094', '2018-03-09 21:52:38'), ('972107956432666624', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"32\",\"parentName\":\"系统日志\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-09 21:52:52'), ('972108156840706048', 'admin', '保存配置', 'com.vigekoo.modules.sys.controller.SysConfigController.save()', '{\"id\":\"972108156811345920\",\"key\":\"key\",\"value\":\"value\",\"remark\":\"12321\",\"status\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-09 21:53:40'), ('972109310718902272', 'admin', '修改配置', 'com.vigekoo.modules.sys.controller.SysConfigController.update()', '{\"id\":\"972108156811345920\",\"key\":\"key\",\"value\":\"value\",\"remark\":\"12321\",\"status\":0}', '127.0.0.1', '10', '2018-03-09 21:58:15'), ('972111865813401600', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"27\",\"parentName\":\"资源管理\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '10', '2018-03-09 22:08:24'), ('972111933324918784', 'admin', '修改菜单', 'com.vigekoo.modules.sys.controller.SysMenuController.update()', '{\"id\":\"54\",\"parentId\":\"32\",\"parentName\":\"系统日志\",\"name\":\"查看\",\"perms\":\"sys:log:info\",\"type\":2,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '13', '2018-03-09 22:08:41');
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
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cogs', '0'), ('12', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '3'), ('13', '12', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0'), ('14', '12', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0'), ('15', '12', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0'), ('16', '12', '删除', null, 'sys:role:delete', '2', null, '0'), ('17', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '4'), ('18', '17', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0'), ('19', '17', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0'), ('2', '1', '用户管理', 'modules/sys/user.html', null, '1', 'fa fa-user', '1'), ('20', '17', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0'), ('21', '17', '删除', null, 'sys:menu:delete', '2', null, '0'), ('22', '1', '字典管理', 'modules/sys/config.html', null, '1', 'fa fa-sun-o', '5'), ('23', '22', '查看', null, 'sys:config:list,sys:config:info', '2', null, '0'), ('24', '22', '新增', null, 'sys:config:save', '2', null, '0'), ('25', '22', '修改', null, 'sys:config:update', '2', null, '0'), ('26', '22', '删除', null, 'sys:config:delete', '2', null, '0'), ('27', '1', '资源管理', 'modules/sys/attachment.html', '', '1', 'fa fa-file-image-o', '6'), ('28', '27', '查看', null, 'sys:attachment:list,sys:attachment:info', '2', null, '0'), ('29', '27', '删除', null, 'sys:attachment:delete', '2', null, '0'), ('3', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0'), ('30', '27', '上传文件', null, 'sys:attachment:upload', '2', null, '0'), ('31', '27', '下载文件', null, 'sys:attachment:download', '2', null, '0'), ('32', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-pencil', '7'), ('33', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '8'), ('4', '2', '新增', null, 'sys:user:save,sys:role:select,sys:dept:select,sys:dept:list', '2', null, '0'), ('5', '2', '修改', null, 'sys:user:update,sys:role:select,sys:dept:select,sys:dept:list', '2', null, '0'), ('50', '0', '代码生成器', null, null, '0', 'fa fa-support', '2'), ('51', '50', '代码生成', 'modules/sys/generator.html', null, '1', 'fa fa-rocket', '1'), ('52', '51', '查看', null, 'sys:generator:list', '2', null, '0'), ('53', '51', '生成代码', null, 'sys:generator:code', '2', null, '0'), ('54', '32', '查看', null, 'sys:log:info', '2', null, '0'), ('6', '2', '删除', null, 'sys:user:delete', '2', null, '0');
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
INSERT INTO `sys_role_menu` VALUES ('972083706434945024', '1', '1'), ('972083706434945025', '1', '2'), ('972083706434945026', '1', '4'), ('972083706434945027', '1', '5'), ('972083706434945028', '1', '6'), ('972083706434945029', '1', '3'), ('972083706434945030', '1', '12'), ('972083706434945031', '1', '15'), ('972083706434945032', '1', '16'), ('972083706434945033', '1', '13'), ('972083706434945034', '1', '14'), ('972083706434945035', '1', '17'), ('972083706434945036', '1', '20'), ('972083706434945037', '1', '21'), ('972083706434945038', '1', '18'), ('972083706434945039', '1', '19'), ('972083706434945040', '1', '22'), ('972083706434945041', '1', '24'), ('972083706434945042', '1', '25'), ('972083706434945043', '1', '26'), ('972083706434945044', '1', '23'), ('972083706434945045', '1', '27'), ('972083706434945046', '1', '31'), ('972083706434945047', '1', '29'), ('972083706434945048', '1', '30'), ('972083706434945049', '1', '28'), ('972083706434945050', '1', '32'), ('972083706434945051', '1', '33'), ('972083706434945052', '1', '54'), ('972083706434945053', '1', '50'), ('972083706434945054', '1', '51'), ('972083706434945055', '1', '53'), ('972083706434945056', '1', '52'), ('972107545730613248', '972092550984761344', '1'), ('972107545730613249', '972092550984761344', '2'), ('972107545730613250', '972092550984761344', '4'), ('972107545730613251', '972092550984761344', '5'), ('972107545730613252', '972092550984761344', '6'), ('972107545730613253', '972092550984761344', '3');
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
INSERT INTO `sys_user_token` VALUES ('972060654275919872', '1', 'bd636455749d4eae7a333b27fdd8f869', '2018-03-10 21:51:58', '2018-03-09 21:51:58'), ('972092769633828864', '2', '00b2f5e5f071da22ebfd5b784e237db5', '2018-03-10 21:51:28', '2018-03-09 21:51:28');
COMMIT;

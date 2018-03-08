DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(256) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(256) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单管理';


DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `username` varchar(128) NOT NULL COMMENT '用户名',
  `nickname` varchar(128) DEFAULT NULL COMMENT '别名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `email` (`email`),
  KEY `mobile` (`mobile`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL ,
  `user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `token` varchar(500) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
--  UNIQUE KEY `token` (`token`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户Token';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `name` varchar(128) COMMENT '角色名称',
  `remark` varchar(256) COMMENT '备注',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色';

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `role_id` varchar(50) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色对应关系';

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL ,
  `role_id` varchar(50) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(50) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `menu_id` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色与菜单对应关系';

DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
	`id` varchar(50) CHARACTER SET utf8 NOT NULL ,
	`key` varchar(128) COMMENT 'key',
	`value` text COMMENT 'value',
	`status` tinyint DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
	`remark` varchar(256) COMMENT '备注',
	PRIMARY KEY (`id`),
	UNIQUE INDEX (`key`),
	KEY `status` (`status`)
) ENGINE=`InnoDB` DEFAULT CHARSET=utf8mb4 COMMENT='系统配置信息表';

DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `username` varchar(128) COMMENT '用户名',
  `operation` varchar(128) COMMENT '用户操作',
  `method` varchar(256) COMMENT '请求方法',
  `params` text COMMENT '请求参数',
  `ip` varchar(64) COMMENT 'IP地址',
  `time` bigint COMMENT '执行时长(毫秒)',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARSET=utf8mb4 COMMENT='系统日志';

DROP TABLE IF EXISTS `sys_attachment`;
CREATE TABLE `sys_attachment` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `title` text COMMENT '标题',
  `user_id` varchar(50) COMMENT '用户ID',
  `path` varchar(512) COMMENT '路径',
  `mime_type` varchar(128) COMMENT 'mime',
  `suffix` varchar(32) COMMENT '附件的后缀',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `mime_type` (`mime_type`)
) ENGINE=`InnoDB` DEFAULT CHARSET=utf8mb4 COMMENT='附件';



INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', NULL, NULL, 0, 'fa fa-cogs', 0);
INSERT INTO `sys_menu` VALUES ('12', '1', '角色管理', 'modules/sys/role.html', NULL, 1, 'fa fa-user-secret', 3);
INSERT INTO `sys_menu` VALUES ('13', '12', '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('14', '12', '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('15', '12', '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('16', '12', '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('17', '1', '菜单管理', 'modules/sys/menu.html', NULL, 1, 'fa fa-th-list', 4);
INSERT INTO `sys_menu` VALUES ('18', '17', '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('19', '17', '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', 'modules/sys/user.html', NULL, 1, 'fa fa-user', 1);
INSERT INTO `sys_menu` VALUES ('20', '17', '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('21', '17', '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('22', '1', '字典管理', 'modules/sys/config.html', NULL, 1, 'fa fa-sun-o', 5);
INSERT INTO `sys_menu` VALUES ('23', '22', '查看', NULL, 'sys:config:list,sys:config:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('24', '22', '新增', NULL, 'sys:config:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('25', '22', '修改', NULL, 'sys:config:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('26', '22', '删除', NULL, 'sys:config:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('27', '1', '资源管理', 'modules/sys/attachment.html', '', 1, 'fa fa-file-image-o', 6);
INSERT INTO `sys_menu` VALUES ('28', '27', '查看', NULL, 'sys:attachment:list,sys:attachment:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('29', '27', '删除', NULL, 'sys:attachment:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('3', '2', '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('30', '27', '上传文件', NULL, 'sys:attachment:upload', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('31', '27', '下载文件', NULL, 'sys:attachment:download', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('32', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', 1, 'fa fa-pencil', 7);
INSERT INTO `sys_menu` VALUES ('33', '1', 'SQL监控', 'druid/sql.html', NULL, 1, 'fa fa-bug', 8);
INSERT INTO `sys_menu` VALUES ('4', '2', '新增', NULL, 'sys:user:save,sys:role:select,sys:dept:select,sys:dept:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('5', '2', '修改', NULL, 'sys:user:update,sys:role:select,sys:dept:select,sys:dept:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('50', '0', '代码生成器', NULL, NULL, 0, 'fa fa-support', 2);
INSERT INTO `sys_menu` VALUES ('51', '50', '代码生成', 'modules/sys/generator.html', NULL, 1, 'fa fa-rocket', 1);
INSERT INTO `sys_menu` VALUES ('52', '51', '查看', NULL, 'sys:generator:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('53', '51', '生成代码', NULL, 'sys:generator:code', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('54', '33', '查看', NULL, 'sys:log:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES ('6', '2', '删除', NULL, 'sys:user:delete', 2, NULL, 0);


INSERT INTO `sys_user` VALUES ('1', 'admin', '超级管理员', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', NULL, NULL, 1, '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'om', '运营用户', 'c1744d470b46a119fba1ed088ada71e9c6229d621de4628d3357193caa1f77f2', 'RECllptZzR0yxVi2Bgpx', NULL, NULL, 1, '2018-3-6 07:40:31');
INSERT INTO `sys_user` VALUES ('3', 'user1', '普通用户', '6d6d38dc3bdd008b80750d75d6074faf82ab5b3c7f6b524340798f433feb5382', 'N2eB7cSetiW6iCkn0Fbe', NULL, NULL, 1, '2018-3-6 07:59:25');
INSERT INTO `sys_user` VALUES ('971641717683912704', 'test', '测试用户', '397a81a01fcb48f813830a6f199c85512d5666a50d16f1ae299c1c6916bd58e6', 'uHqkPjwypPCeBm2J3aP8', NULL, NULL, 1, '2018-3-8 15:00:12');

INSERT INTO `sys_user_role` VALUES ('10', '2', '2');
INSERT INTO `sys_user_role` VALUES ('11', '971641717683912704', '3');
INSERT INTO `sys_user_role` VALUES ('13', '3', '3');
INSERT INTO `sys_user_role` VALUES ('4', '1', '1');


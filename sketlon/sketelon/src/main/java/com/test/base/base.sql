-- -------------------------------------------------------------------
--  操作日志表（用于记录系统的请求）
-- -------------------------------------------------------------------
CREATE TABLE `oper_log` (
  `oper_log_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '日志Id',
  `log_time` datetime NOT NULL COMMENT '日志时间',
  `log_oper` varchar(32) DEFAULT NULL COMMENT '日志操作-message国际化',
  `log_status` tinyint(1) DEFAULT NULL COMMENT '日志状态-成功/失败',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `user_ip` varchar(32) DEFAULT NULL COMMENT '用户ip',
  `log_location` varchar(255) DEFAULT NULL COMMENT '登录地点',
  `log_device` varchar(255) DEFAULT NULL COMMENT '登录设备',
  `log_code` int(11) DEFAULT NULL COMMENT '状态码',
  `spend_time` int(11) DEFAULT NULL COMMENT '响应时间-方便调试',
  `log_desc` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`oper_log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
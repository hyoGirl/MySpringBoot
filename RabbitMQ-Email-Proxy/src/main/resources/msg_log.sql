/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : databook

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-09-08 21:47:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for msg_log
-- ----------------------------
DROP TABLE IF EXISTS `msg_log`;
CREATE TABLE `msg_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `msg_id` varchar(255) NOT NULL DEFAULT '' COMMENT '消息唯一标识',
  `try_count` int(11) NOT NULL DEFAULT '0' COMMENT '重试次数',
  `msg` text COMMENT '消息体, json格式化',
  `exchange` varchar(255) NOT NULL DEFAULT '' COMMENT '交换机',
  `routing_key` varchar(255) NOT NULL DEFAULT '' COMMENT '路由键',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态: 0投递中 1投递成功 2投递失败 3已消费',
  `next_try_time` datetime DEFAULT NULL COMMENT '下一次重试时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_msg_id` (`msg_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='消息投递日志';

-- ----------------------------
-- Records of msg_log
-- ----------------------------
INSERT INTO `msg_log` VALUES ('1', '5d74321d44764fc2a9092994c1cab163', '0', '{\"content\":\"测试MQ代码001\",\"msgId\":\"5d74321d44764fc2a9092994c1cab163\",\"title\":\"测试MQ代码001\",\"to\":\"xulei912@163.com\"}', 'mail.exchange', 'mail.routing.key', '0', '2019-09-08 18:35:47', '2019-09-08 18:34:47', '2019-09-08 18:34:47');
INSERT INTO `msg_log` VALUES ('2', 'fe774daf282f461d8313e0423f526cf8', '0', '{\"content\":\"测试MQ代码001\",\"msgId\":\"fe774daf282f461d8313e0423f526cf8\",\"title\":\"测试MQ代码001\",\"to\":\"xulei912@163.com\"}', 'mail.exchange', 'mail.routing.key', '1', '2019-09-08 18:46:47', '2019-09-08 18:45:47', '2019-09-08 18:45:47');
INSERT INTO `msg_log` VALUES ('3', 'f9c8f0ac703349d5801aafdbac11884c', '3', '{\"content\":\"测试MQ代码001\",\"msgId\":\"f9c8f0ac703349d5801aafdbac11884c\",\"title\":\"测试MQ代码001\",\"to\":\"xulei912@163.com\"}', 'mail.exchange', 'mail.routing.key', '3', '2019-09-08 18:54:28', '2019-09-08 18:53:28', '2019-09-08 18:53:31');
INSERT INTO `msg_log` VALUES ('5', '2235c46092e54dafbd8a70510e98bf29', '3', '{\"content\":\"测试MQ代码001\",\"msgId\":\"2235c46092e54dafbd8a70510e98bf29\",\"title\":\"测试MQ代码001\",\"to\":\"xulei912@163.com\"}', 'mail.exchange', 'mail.routing.key', '0', '2019-09-08 21:18:51', '2019-09-08 21:17:51', '2019-09-08 21:17:51');
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `msg_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '消息ID',
  `type` int(11) NOT NULL COMMENT '日志类型:1登录 2登出',
  `description` varchar(255) DEFAULT NULL COMMENT '日志描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2047 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登录日志表';


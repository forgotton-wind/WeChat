/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : WeChat

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 02/11/2021 18:03:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend` (
  `f_id` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `f_uid` int DEFAULT NULL,
  `f_fid` int DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_friend
-- ----------------------------
BEGIN;
INSERT INTO `t_friend` VALUES (1, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `g_id` int NOT NULL AUTO_INCREMENT,
  `g_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `g_time` datetime DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_group
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_groupmessage
-- ----------------------------
DROP TABLE IF EXISTS `t_groupmessage`;
CREATE TABLE `t_groupmessage` (
  `gm_id` int NOT NULL AUTO_INCREMENT,
  `gm_content` text COLLATE utf8_bin,
  `gm_time` datetime DEFAULT NULL,
  `gm_uid` int DEFAULT NULL,
  `gm_gid` int DEFAULT NULL,
  `gm_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`gm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_groupmessage
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_content` text CHARACTER SET utf8 COLLATE utf8_bin,
  `m_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `m_time` datetime DEFAULT NULL,
  `m_typeid` int DEFAULT NULL,
  `m_fromuid` int DEFAULT NULL,
  `m_touid` int DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_messagetype
-- ----------------------------
DROP TABLE IF EXISTS `t_messagetype`;
CREATE TABLE `t_messagetype` (
  `mt_id` int NOT NULL AUTO_INCREMENT,
  `mt_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`mt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_messagetype
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `u_account` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_state` int DEFAULT NULL,
  `u_gravatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_birthday` datetime(6) DEFAULT NULL,
  `u_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_schoolname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `u_bloodtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'mlj', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (2, 'mlj1', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_usergroup
-- ----------------------------
DROP TABLE IF EXISTS `t_usergroup`;
CREATE TABLE `t_usergroup` (
  `ug_id` int NOT NULL AUTO_INCREMENT,
  `ug_gid` int DEFAULT NULL,
  `ug_uid` int DEFAULT NULL,
  PRIMARY KEY (`ug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_usergroup
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

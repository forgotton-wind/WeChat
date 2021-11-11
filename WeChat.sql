/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : wechat

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 11/11/2021 20:33:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend`  (
  `f_id` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `f_uid` int NULL DEFAULT NULL,
  `f_fid` int NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_friend
-- ----------------------------
INSERT INTO `t_friend` VALUES (87, NULL, 3, 1);
INSERT INTO `t_friend` VALUES (88, NULL, 1, 3);
INSERT INTO `t_friend` VALUES (89, NULL, 3, 2);
INSERT INTO `t_friend` VALUES (90, NULL, 2, 3);
INSERT INTO `t_friend` VALUES (91, NULL, 1, 2);
INSERT INTO `t_friend` VALUES (92, NULL, 2, 1);

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group`  (
  `g_id` int NOT NULL AUTO_INCREMENT,
  `g_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `g_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`g_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES (1, '交流群1', '2021-11-10 17:01:37');
INSERT INTO `t_group` VALUES (2, '交流群2', '2021-11-10 17:01:53');
INSERT INTO `t_group` VALUES (3, '交流群3', '2021-11-10 17:02:00');

-- ----------------------------
-- Table structure for t_groupmessage
-- ----------------------------
DROP TABLE IF EXISTS `t_groupmessage`;
CREATE TABLE `t_groupmessage`  (
  `gm_id` int NOT NULL AUTO_INCREMENT,
  `gm_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gm_time` datetime NULL DEFAULT NULL,
  `gm_uid` int NULL DEFAULT NULL,
  `gm_gid` int NULL DEFAULT NULL,
  `gm_type` int NULL DEFAULT NULL,
  PRIMARY KEY (`gm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_groupmessage
-- ----------------------------

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `m_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `m_time` datetime NULL DEFAULT NULL,
  `m_typeid` int NULL DEFAULT NULL,
  `m_fromuid` int NULL DEFAULT NULL,
  `m_touid` int NULL DEFAULT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_messagetype
-- ----------------------------
DROP TABLE IF EXISTS `t_messagetype`;
CREATE TABLE `t_messagetype`  (
  `mt_id` int NOT NULL AUTO_INCREMENT,
  `mt_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`mt_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_messagetype
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `u_account` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_state` int NULL DEFAULT NULL,
  `u_gravatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_birthday` datetime(6) NULL DEFAULT NULL,
  `u_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_schoolname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `u_bloodtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'mlj', '202cb962ac59075b964b07152d234b70', 1, 'https://ptpimg.me/r1xl4k.jpg', '小明', NULL, NULL, '2021-11-08 07:37:41.000000', NULL, NULL, 'bj', NULL);
INSERT INTO `t_user` VALUES (2, 'mlj1', '202cb962ac59075b964b07152d234b70', 1, 'https://ptpimg.me/em60mw.jpg', '老王', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (3, 'qwer', '202cb962ac59075b964b07152d234b70', 1, 'https://ptpimg.me/0knvl8.jpg', '测试', 'aaa', '男', NULL, NULL, NULL, NULL, 'C');

-- ----------------------------
-- Table structure for t_usergroup
-- ----------------------------
DROP TABLE IF EXISTS `t_usergroup`;
CREATE TABLE `t_usergroup`  (
  `ug_id` int NOT NULL AUTO_INCREMENT,
  `ug_gid` int NULL DEFAULT NULL,
  `ug_uid` int NULL DEFAULT NULL,
  PRIMARY KEY (`ug_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_usergroup
-- ----------------------------
INSERT INTO `t_usergroup` VALUES (23, 1, 3);
INSERT INTO `t_usergroup` VALUES (24, 2, 3);
INSERT INTO `t_usergroup` VALUES (25, 3, 3);
INSERT INTO `t_usergroup` VALUES (26, 1, 1);
INSERT INTO `t_usergroup` VALUES (27, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;

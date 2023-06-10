/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3307
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3307
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 10/06/2023 19:29:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cpjm
-- ----------------------------
DROP TABLE IF EXISTS `cpjm`;
CREATE TABLE `cpjm`  (
  `notes` int NULL DEFAULT NULL,
  `device` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` datetime NULL DEFAULT NULL,
  `number` int NULL DEFAULT NULL,
  `maker` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cpjm
-- ----------------------------

-- ----------------------------
-- Table structure for gcjm
-- ----------------------------
DROP TABLE IF EXISTS `gcjm`;
CREATE TABLE `gcjm`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `scxname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productxh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productgg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gcjm
-- ----------------------------
INSERT INTO `gcjm` VALUES (2, 'dad', 'dad', NULL, NULL, NULL);
INSERT INTO `gcjm` VALUES (3, 'dad', 'ad', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for invitegg
-- ----------------------------
DROP TABLE IF EXISTS `invitegg`;
CREATE TABLE `invitegg`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invitegg
-- ----------------------------
INSERT INTO `invitegg` VALUES (1, 'zx', 'zxzs', '2023-06-15 14:51:10');
INSERT INTO `invitegg` VALUES (2, 'ad', 'wad', '2023-06-08 14:51:32');
INSERT INTO `invitegg` VALUES (3, 'da', 'ads', '2023-06-04 14:51:53');

-- ----------------------------
-- Table structure for inviteyg
-- ----------------------------
DROP TABLE IF EXISTS `inviteyg`;
CREATE TABLE `inviteyg`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inviteyg
-- ----------------------------
INSERT INTO `inviteyg` VALUES (2, 'ad', 'wad', '2023-06-08 14:51:32');
INSERT INTO `inviteyg` VALUES (3, 'wda', 'dad', '2023-06-22 18:12:20');
INSERT INTO `inviteyg` VALUES (4, 'awdx', 'awd', '2023-06-15 18:12:30');
INSERT INTO `inviteyg` VALUES (5, NULL, '张鑫', '1999-10-21 11:10:10');

-- ----------------------------
-- Table structure for nxyj
-- ----------------------------
DROP TABLE IF EXISTS `nxyj`;
CREATE TABLE `nxyj`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `pointname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pointaddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `timepower` float NULL DEFAULT NULL,
  `timevoltage` float NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Reportingtime` date NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nxyj
-- ----------------------------
INSERT INTO `nxyj` VALUES (1, 'po', NULL, 0, 0, NULL, NULL, NULL);
INSERT INTO `nxyj` VALUES (2, 'ghda', 'addw', 12.8, 12, 'adwdwad', '2023-05-16', 'ad');
INSERT INTO `nxyj` VALUES (3, 'gh', NULL, 0, 0, NULL, NULL, NULL);
INSERT INTO `nxyj` VALUES (4, 'po', NULL, 0, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for processmodel
-- ----------------------------
DROP TABLE IF EXISTS `processmodel`;
CREATE TABLE `processmodel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `guige` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `unit` int NULL DEFAULT NULL,
  `prow` int NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `product` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of processmodel
-- ----------------------------
INSERT INTO `processmodel` VALUES (2, 'myq', '`dakl', 'djkal', 45, 26, 'dadh', 'kdalj', 'da');
INSERT INTO `processmodel` VALUES (3, 'das', NULL, NULL, NULL, 1, 'awd', 'wda', 'wad');

-- ----------------------------
-- Table structure for qiyegg
-- ----------------------------
DROP TABLE IF EXISTS `qiyegg`;
CREATE TABLE `qiyegg`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qiyegg
-- ----------------------------
INSERT INTO `qiyegg` VALUES (1, 'zx', 'zxzs', '2023-06-15 14:51:10');
INSERT INTO `qiyegg` VALUES (2, 'ad', 'wad', '2023-06-08 14:51:32');
INSERT INTO `qiyegg` VALUES (3, 'da', 'ads', '2023-06-04 14:51:53');
INSERT INTO `qiyegg` VALUES (4, 'dawd', 'ad', '2023-06-06 18:12:09');
INSERT INTO `qiyegg` VALUES (5, 'wda', 'dad', '2023-06-22 18:12:20');
INSERT INTO `qiyegg` VALUES (6, 'awdx', 'awd', '2023-06-15 18:12:30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin1', '$2a$10$dWL24wjqpNroS1GmcjjRsO.OFJfyWfyQlttpc/EKX3hGXFsM/Eoh6');

-- ----------------------------
-- Table structure for wlda
-- ----------------------------
DROP TABLE IF EXISTS `wlda`;
CREATE TABLE `wlda`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `specs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `units` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wlda
-- ----------------------------

-- ----------------------------
-- Table structure for xmwh
-- ----------------------------
DROP TABLE IF EXISTS `xmwh`;
CREATE TABLE `xmwh`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `header` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start` datetime NULL DEFAULT NULL,
  `end` datetime NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `duction` varchar(255) CHARACTER SET ujis COLLATE ujis_japanese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xmwh
-- ----------------------------
INSERT INTO `xmwh` VALUES (2, 'addwd', '', '1923-01-01 00:00:00', '9999-12-31 00:00:00', '', NULL);
INSERT INTO `xmwh` VALUES (3, 'addad', 'dawda', '2023-05-09 16:07:52', '2023-05-20 16:07:57', 'adaw', 'wdaw');
INSERT INTO `xmwh` VALUES (4, '', '', '1922-12-31 16:00:00', '9999-12-30 16:00:00', '', '3bd2133a97364b0aa8c4fd2c270cb7ea.png');

-- ----------------------------
-- Table structure for zhongbgg
-- ----------------------------
DROP TABLE IF EXISTS `zhongbgg`;
CREATE TABLE `zhongbgg`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhongbgg
-- ----------------------------
INSERT INTO `zhongbgg` VALUES (1, 'zx', 'zxzs', '2023-06-15 14:51:10');
INSERT INTO `zhongbgg` VALUES (2, 'ad', 'wad', '2023-06-08 14:51:32');
INSERT INTO `zhongbgg` VALUES (3, 'da', 'ads', '2023-06-04 14:51:53');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : meeting_rest

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 01/08/2019 17:07:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for source_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `source_dict_t`;
CREATE TABLE `source_dict_t` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `show_name` varchar(100) DEFAULT NULL COMMENT '显示名称',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='区域信息表';

-- ----------------------------
-- Records of source_dict_t
-- ----------------------------
BEGIN;
INSERT INTO `source_dict_t` VALUES (1, '大陆');
INSERT INTO `source_dict_t` VALUES (2, '美国');
INSERT INTO `source_dict_t` VALUES (3, '韩国');
INSERT INTO `source_dict_t` VALUES (4, '日本');
INSERT INTO `source_dict_t` VALUES (5, '中国香港');
INSERT INTO `source_dict_t` VALUES (6, '中国台湾');
INSERT INTO `source_dict_t` VALUES (7, '印度');
INSERT INTO `source_dict_t` VALUES (8, '法国');
INSERT INTO `source_dict_t` VALUES (9, '英国');
INSERT INTO `source_dict_t` VALUES (10, '俄罗斯');
INSERT INTO `source_dict_t` VALUES (11, '意大利');
INSERT INTO `source_dict_t` VALUES (12, '西班牙');
INSERT INTO `source_dict_t` VALUES (13, '德国');
INSERT INTO `source_dict_t` VALUES (14, '波兰');
INSERT INTO `source_dict_t` VALUES (15, '澳大利亚');
INSERT INTO `source_dict_t` VALUES (16, '伊朗');
INSERT INTO `source_dict_t` VALUES (99, '全部');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

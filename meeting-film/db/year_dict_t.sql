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

 Date: 01/08/2019 17:09:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for year_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `year_dict_t`;
CREATE TABLE `year_dict_t` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `show_name` varchar(100) DEFAULT NULL COMMENT '显示名称',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='年代信息表';

-- ----------------------------
-- Records of year_dict_t
-- ----------------------------
BEGIN;
INSERT INTO `year_dict_t` VALUES (1, '更早');
INSERT INTO `year_dict_t` VALUES (2, '70年代');
INSERT INTO `year_dict_t` VALUES (3, '80年代');
INSERT INTO `year_dict_t` VALUES (4, '90年代');
INSERT INTO `year_dict_t` VALUES (5, '2000-2010');
INSERT INTO `year_dict_t` VALUES (6, '2011');
INSERT INTO `year_dict_t` VALUES (7, '2012');
INSERT INTO `year_dict_t` VALUES (8, '2013');
INSERT INTO `year_dict_t` VALUES (9, '2014');
INSERT INTO `year_dict_t` VALUES (10, '2015');
INSERT INTO `year_dict_t` VALUES (11, '2016');
INSERT INTO `year_dict_t` VALUES (12, '2017');
INSERT INTO `year_dict_t` VALUES (13, '2018');
INSERT INTO `year_dict_t` VALUES (14, '2018以后');
INSERT INTO `year_dict_t` VALUES (99, '全部');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

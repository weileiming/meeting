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

 Date: 01/08/2019 16:51:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner_t
-- ----------------------------
DROP TABLE IF EXISTS `banner_t`;
CREATE TABLE `banner_t` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `banner_address` varchar(50) DEFAULT NULL COMMENT 'banner图存放路径',
  `banner_url` varchar(200) DEFAULT NULL COMMENT 'banner点击跳转url',
  `is_valid` int(11) DEFAULT '0' COMMENT '是否弃用 0-失效,1-失效',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='banner信息表';

-- ----------------------------
-- Records of banner_t
-- ----------------------------
BEGIN;
INSERT INTO `banner_t` VALUES (2, 'banners/9d75708ae91d5fc918369b76e9e2edba197666.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `banner_t` VALUES (3, 'banners/15b3730838f35d56a76d88a1787aaaa5186414.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `banner_t` VALUES (4, 'banners/51afa73f0347e9b98957c53fa971d41491652.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `banner_t` VALUES (5, 'banners/6605d3518e2bba10f29a6f9ae32b361987015.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `banner_t` VALUES (6, 'banners/c1a713981cabef02c88ae5f42888de70183835.jpg', 'www.meetingshop.cn', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

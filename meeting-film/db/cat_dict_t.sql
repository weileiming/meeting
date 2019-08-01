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

 Date: 01/08/2019 17:03:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cat_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `cat_dict_t`;
CREATE TABLE `cat_dict_t` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `show_name` varchar(100) DEFAULT NULL COMMENT '显示名称',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='类型信息表';

-- ----------------------------
-- Records of cat_dict_t
-- ----------------------------
BEGIN;
INSERT INTO `cat_dict_t` VALUES (1, '爱情');
INSERT INTO `cat_dict_t` VALUES (2, '喜剧');
INSERT INTO `cat_dict_t` VALUES (3, '动画');
INSERT INTO `cat_dict_t` VALUES (4, '剧情');
INSERT INTO `cat_dict_t` VALUES (5, '恐怖');
INSERT INTO `cat_dict_t` VALUES (6, '惊悚');
INSERT INTO `cat_dict_t` VALUES (7, '科幻');
INSERT INTO `cat_dict_t` VALUES (8, '动作');
INSERT INTO `cat_dict_t` VALUES (9, '悬疑');
INSERT INTO `cat_dict_t` VALUES (10, '犯罪');
INSERT INTO `cat_dict_t` VALUES (11, '冒险');
INSERT INTO `cat_dict_t` VALUES (12, '战争');
INSERT INTO `cat_dict_t` VALUES (13, '奇幻');
INSERT INTO `cat_dict_t` VALUES (14, '运动');
INSERT INTO `cat_dict_t` VALUES (15, '家庭');
INSERT INTO `cat_dict_t` VALUES (16, '古装');
INSERT INTO `cat_dict_t` VALUES (17, '武侠');
INSERT INTO `cat_dict_t` VALUES (18, '西部');
INSERT INTO `cat_dict_t` VALUES (19, '历史');
INSERT INTO `cat_dict_t` VALUES (20, '传记');
INSERT INTO `cat_dict_t` VALUES (21, '歌舞');
INSERT INTO `cat_dict_t` VALUES (22, '短片');
INSERT INTO `cat_dict_t` VALUES (23, '纪录片');
INSERT INTO `cat_dict_t` VALUES (24, '黑色电影');
INSERT INTO `cat_dict_t` VALUES (99, '全部');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

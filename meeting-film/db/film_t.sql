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

 Date: 01/08/2019 17:10:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for film_t
-- ----------------------------
DROP TABLE IF EXISTS `film_t`;
CREATE TABLE `film_t` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `film_name` varchar(100) DEFAULT NULL COMMENT '影片名称',
  `film_type` int(11) DEFAULT NULL COMMENT '片源类型: 0-2D,1-3D,2-3DIMAX,4-无',
  `img_address` varchar(200) DEFAULT NULL COMMENT '影片主图地址',
  `film_score` varchar(20) DEFAULT NULL COMMENT '影片评分',
  `film_preSaleNum` int(11) DEFAULT NULL COMMENT '影片预售数量',
  `film_box_office` int(11) DEFAULT NULL COMMENT '影片票房：每日更新，以万为单位',
  `film_source` int(11) DEFAULT NULL COMMENT '影片片源，参照片源字典表',
  `film_cats` varchar(50) DEFAULT NULL COMMENT '影片分类，参照分类表,多个分类以#分割',
  `film_area` int(11) DEFAULT NULL COMMENT '影片区域，参照区域表',
  `film_date` int(11) DEFAULT NULL COMMENT '影片上映年代，参照年代表',
  `film_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '影片上映时间',
  `film_status` int(11) DEFAULT NULL COMMENT '影片状态,1-正在热映，2-即将上映，3-经典影片',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='影片主表';

-- ----------------------------
-- Records of film_t
-- ----------------------------
BEGIN;
INSERT INTO `film_t` VALUES (2, '我不是药神', 0, 'films/238e2dc36beae55a71cabfc14069fe78236351.jpg', '9.7', 231432491, 309600, 1, '#2#4#22#', 1, 13, '2018-07-05 00:00:00', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

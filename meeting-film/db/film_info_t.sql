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

 Date: 01/08/2019 17:12:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for film_info_t
-- ----------------------------
DROP TABLE IF EXISTS `film_info_t`;
CREATE TABLE `film_info_t` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `film_id` varchar(100) DEFAULT NULL COMMENT '影片编号',
  `film_en_name` varchar(50) DEFAULT NULL COMMENT '影片英文名称',
  `film_score` varchar(20) DEFAULT NULL COMMENT '影片评分',
  `film_score_num` int(11) DEFAULT NULL COMMENT '评分人数,以万为单位',
  `film_length` int(11) DEFAULT NULL COMMENT '播放时长，以分钟为单位，不足取整',
  `biography` text COMMENT '影片介绍',
  `director_id` int(11) DEFAULT NULL COMMENT '导演编号',
  `film_imgs` text COMMENT '影片图片集地址,多个图片以逗号分隔',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='影片主表';

-- ----------------------------
-- Records of film_info_t
-- ----------------------------
BEGIN;
INSERT INTO `film_info_t` VALUES (2, '2', 'Dying To Survive', '9.7', 225, 117, '一位不速之客的意外到访，打破了神油店老板程勇（徐峥 饰）的平凡人生，他从一个交不起房租的男性保健品商贩，一跃成为印度仿制药“格列宁”的独家代理商。收获巨额利润的他，生活剧烈变化，被病患们冠以“药神”的称号。但是，一场关于救赎的拉锯战也在波涛暗涌中慢慢展开......', 1, 'films/3065271341357040f5f5dd988550951e586199.jpg,films/6b2b3fd6260ac37e5ad44d00ea474ea3651419.jpg,films/4633dd44c51ff15fc7e939679d7cdb67561602.jpg,films/df2d30b1a3bd58fb1d38b978662ae844648169.jpg,films/c845f6b04aa49059951fd55e6b0eddac454036.jpg');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

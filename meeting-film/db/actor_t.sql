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

 Date: 01/08/2019 17:31:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actor_t
-- ----------------------------
DROP TABLE IF EXISTS `actor_t`;
CREATE TABLE `actor_t` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `actor_name` varchar(50) DEFAULT NULL COMMENT '演员名称',
  `actor_img` varchar(200) DEFAULT NULL COMMENT '演员图片位置',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='演员表';

-- ----------------------------
-- Records of actor_t
-- ----------------------------
BEGIN;
INSERT INTO `actor_t` VALUES (1, '徐峥', 'actors/2b98c9d2e6d23a7eff25dcac8b584b0136045.jpg');
INSERT INTO `actor_t` VALUES (2, '王传君', 'actors/b782d497577baffb5ed14de52841dcb164365.jpg');
INSERT INTO `actor_t` VALUES (3, '谭卓', 'actors/acf7db57456cb1aed1a42f7ebffedaa842002.jpg');
INSERT INTO `actor_t` VALUES (4, '黄渤', 'actors/c6594ef2705dcaf7d9df857d228b5e1645712.jpg');
INSERT INTO `actor_t` VALUES (5, '舒淇', 'actors/6b32a489467283bb739a2bac3b2b929742175.jpg');
INSERT INTO `actor_t` VALUES (6, '张艺兴', 'actors/b738d5e78a1f5c3379d9d42a9b18286f32246.jpeg');
INSERT INTO `actor_t` VALUES (7, '强森', 'actors/7e3067d066c1e285b0cc17bfd5f1b34e108474.jpg');
INSERT INTO `actor_t` VALUES (8, '杰森·斯坦森', 'actors/7ec0c90aec03c7904c1db3af1153162f77864.jpg');
INSERT INTO `actor_t` VALUES (9, '李冰冰', 'actors/d2258cd0529950cf5099206519d91d0e51803.jpg');
INSERT INTO `actor_t` VALUES (10, '汤姆·克鲁斯', 'actors/6afaea1cb4ca2b346e86e265347c78b833970.jpg');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

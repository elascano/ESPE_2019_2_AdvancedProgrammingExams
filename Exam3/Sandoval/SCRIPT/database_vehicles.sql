/*
Navicat MySQL Data Transfer

Source Server         : movilProjectTransport
Source Server Version : 50505
Source Host           : freigthtransport.ddns.net:3306
Source Database       : database_vehicles

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-01-27 13:14:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vehicles
-- ----------------------------
DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE `vehicles` (
  `id` varchar(32) NOT NULL,
  `brand` varchar(32) DEFAULT NULL,
  `model` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicles
-- ----------------------------
INSERT INTO `vehicles` VALUES ('1', 'ford', 'fiesta');
INSERT INTO `vehicles` VALUES ('10', 'chevrolet', 'sz');
INSERT INTO `vehicles` VALUES ('2', 'chevrolet', 'vitara');
INSERT INTO `vehicles` VALUES ('3', 'chevrolet', 'dmax');
INSERT INTO `vehicles` VALUES ('4', 'chevrolet', 'aveo');
INSERT INTO `vehicles` VALUES ('5', 'chevrolet', 'sail');
INSERT INTO `vehicles` VALUES ('6', 'ford', 'scape');
INSERT INTO `vehicles` VALUES ('7', 'ferrari', 'spider');
INSERT INTO `vehicles` VALUES ('8', 'ferrari', 'portofino');
INSERT INTO `vehicles` VALUES ('9', 'porsche', 'macan');

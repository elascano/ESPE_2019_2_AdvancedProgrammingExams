/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-12-09 12:59:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `idproduct` varchar(12) NOT NULL,
  `nameproduct` varchar(32) DEFAULT NULL,
  `typeproduct` varchar(32) DEFAULT NULL,
  `quantity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'martillo', 'construccion', '4');
INSERT INTO `products` VALUES ('2', 'clavos', 'construccion', '3');
INSERT INTO `products` VALUES ('3', 'sierra', 'construccion', '2');
INSERT INTO `products` VALUES ('4', 'taladro', 'construccion', '3');
INSERT INTO `products` VALUES ('5', 'destornillador', 'construccion', '5');

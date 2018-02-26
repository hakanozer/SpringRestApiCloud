/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100130
 Source Host           : localhost:3306
 Source Schema         : jsoncloud

 Target Server Type    : MySQL
 Target Server Version : 100130
 File Encoding         : 65001

 Date: 26/02/2018 19:42:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `asurname` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `amail` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `apassword` varchar(32) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `remember_me` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `aphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `apicpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE,
  UNIQUE INDEX `unique_admin_mail`(`amail`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (1, 'Ali', 'Bilmem', 'ali@ali.com', '827ccb0eea8a706c4c34a16891f84e7b', '', NULL, NULL);
INSERT INTO `admins` VALUES (2, 'Veli', 'Bilir', 'veli@veli.com', '827ccb0eea8a706c4c34a16891f84e7b', '', NULL, NULL);

-- ----------------------------
-- Table structure for adress
-- ----------------------------
DROP TABLE IF EXISTS `adress`;
CREATE TABLE `adress`  (
  `adressid` int(11) NOT NULL AUTO_INCREMENT,
  `adresstitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `adresscityid` int(255) NULL DEFAULT NULL,
  `adresstownid` int(11) NULL DEFAULT NULL,
  `adressneighborhoodid` int(255) NULL DEFAULT NULL,
  `adressdescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `adressinformation` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `adressdistrictid` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adressid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for campaigns
-- ----------------------------
DROP TABLE IF EXISTS `campaigns`;
CREATE TABLE `campaigns`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `ctitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `cdetail` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `cdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categorycompanyid` int(11) NULL DEFAULT NULL,
  `categoryparentid` int(11) NULL DEFAULT NULL,
  `categorytitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `categorydescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `categorysort` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `categorylink` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`categoryid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for companies
-- ----------------------------
DROP TABLE IF EXISTS `companies`;
CREATE TABLE `companies`  (
  `companyid` int(11) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `companyphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `companyfax` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `companymail` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `companyadressid` int(11) NULL DEFAULT NULL,
  `companyapikey` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`companyid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers`  (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `customercompanyid` int(11) NULL DEFAULT NULL,
  `customername` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `customersurname` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `customerpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `customermail` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `customerphone` varchar(10) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customerid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderid` int(11) NOT NULL,
  `ordercustomerid` int(11) NULL DEFAULT NULL,
  `orderproductids` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ordercounts` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ordertotalprice` decimal(10, 2) NULL DEFAULT NULL,
  `orderstatus` bit(1) NULL DEFAULT NULL,
  `orderdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pcid` int(11) NULL DEFAULT NULL,
  `ptitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `pcatid` int(11) NULL DEFAULT NULL,
  `pdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `pdetail` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `pprice` decimal(10, 2) NULL DEFAULT NULL,
  `ptype` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `pcomid` int(11) NULL DEFAULT NULL,
  `padressesid` int(255) NULL DEFAULT NULL,
  `platitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `plongtitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `pmap` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sample
-- ----------------------------
DROP TABLE IF EXISTS `sample`;
CREATE TABLE `sample`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `stitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `sdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ssprice` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sample
-- ----------------------------
INSERT INTO `sample` VALUES (2, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (3, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (4, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (5, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (6, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (7, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (8, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (9, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (10, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (11, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (22, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (23, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (24, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (25, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (26, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (27, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (28, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (29, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (30, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (31, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (32, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (33, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (34, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (35, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (36, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (37, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (38, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (39, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (40, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (41, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (42, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (43, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (44, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (45, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (46, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (47, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (48, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (49, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (50, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (51, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (52, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (53, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (54, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (55, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (56, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (57, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (58, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (59, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (60, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (61, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (62, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (63, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (64, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (65, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (66, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (67, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (68, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (69, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (70, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (71, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (72, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (73, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (74, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (75, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (76, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (77, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (78, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (79, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (80, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (81, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (82, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (83, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (84, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (85, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (86, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (87, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (88, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (89, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (90, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (91, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (92, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (93, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (94, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (95, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (96, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (98, 'aa', 'bb', 10.00);
INSERT INTO `sample` VALUES (102, 'aa', 'bb', 10.00);

SET FOREIGN_KEY_CHECKS = 1;

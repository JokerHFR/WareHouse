/*
Navicat MySQL Data Transfer

Source Server         : HFR
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : warehouse

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-05-06 23:29:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `w_cuscontactman`
-- ----------------------------
DROP TABLE IF EXISTS `w_cuscontactman`;
CREATE TABLE `w_cuscontactman` (
  `CusContactID` bigint(20) NOT NULL auto_increment,
  `CusContactName` varchar(10) NOT NULL,
  `CusContactTitle` varchar(10) default NULL,
  `CusContactTele` varchar(20) default NULL,
  `CusContactMob` varchar(20) default NULL,
  `FK_CustomerID` bigint(20) default NULL,
  PRIMARY KEY  (`CusContactID`),
  KEY `FK_CustomerID_Customer` (`FK_CustomerID`),
  CONSTRAINT `FK_CustomerID_Customer` FOREIGN KEY (`FK_CustomerID`) REFERENCES `w_customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_cuscontactman
-- ----------------------------

-- ----------------------------
-- Table structure for `w_customer`
-- ----------------------------
DROP TABLE IF EXISTS `w_customer`;
CREATE TABLE `w_customer` (
  `CustomerID` bigint(20) NOT NULL auto_increment,
  `CustomerSimpleName` varchar(30) NOT NULL,
  `CustomerName` varchar(60) default NULL,
  `CustomerOwner` varchar(20) default NULL,
  `CustomerTele` varchar(20) default NULL,
  `CustomerMob` varchar(20) default NULL,
  `CustomerFax` varchar(20) default NULL,
  `CustomerAddress` varchar(100) default NULL,
  `DeliveryAddress` varchar(100) default NULL,
  `InvoiceAddress` varchar(100) default NULL,
  `LastDeliveryDate` datetime default NULL,
  PRIMARY KEY  (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_customer
-- ----------------------------
INSERT INTO `w_customer` VALUES ('1', '永辉超市', '永辉超市下沙店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-05-06 20:22:58');
INSERT INTO `w_customer` VALUES ('2', '永辉超市', '永辉超市西湖店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('3', '永辉超市', '永辉超市滨江店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('4', '永辉超市', '永辉超市余杭店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('5', '物美超市', '物美超市下沙店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('6', '物美超市', '物美超市西湖店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('7', '物美超市', '物美超市余杭店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('8', '物美超市', '物美超市滨江店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('9', '华联超市', '华联超市下沙店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('10', '华联超市', '华联超市西湖店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('11', '华联超市', '华联超市余杭店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('12', '华联超市', '永华联超市滨江店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('13', '大润发超市', '大润发超市下沙店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_customer` VALUES ('15', '大润发超市', '大润发超市余杭店', '小胡', '123456', '123456', '123456', '浙江省杭州市', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');

-- ----------------------------
-- Table structure for `w_deliverydetail`
-- ----------------------------
DROP TABLE IF EXISTS `w_deliverydetail`;
CREATE TABLE `w_deliverydetail` (
  `FK_DeliveryID` bigint(20) NOT NULL,
  `FK_ProductID` bigint(20) NOT NULL,
  `SalesQua` bigint(20) NOT NULL,
  `SalesPrice` double(20,2) NOT NULL,
  KEY `FK_DeliveryID_Delivery` (`FK_DeliveryID`),
  KEY `FK_ProductID_Product` (`FK_ProductID`),
  CONSTRAINT `FK_DeliveryID_Delivery` FOREIGN KEY (`FK_DeliveryID`) REFERENCES `w_deliverymaster` (`DeliveryID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProductID_Product` FOREIGN KEY (`FK_ProductID`) REFERENCES `w_product` (`ProductID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_deliverydetail
-- ----------------------------
INSERT INTO `w_deliverydetail` VALUES ('120180505211345', '1', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180505211345', '3', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180505211345', '2', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506001109', '1', '100', '100.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506001109', '1', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506001321', '1', '100', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506001321', '2', '50', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506001642', '2', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506001642', '1', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506202258', '1', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506202258', '1', '0', '0.00');
INSERT INTO `w_deliverydetail` VALUES ('120180506232042', '2', '10', '10.00');

-- ----------------------------
-- Table structure for `w_deliverymaster`
-- ----------------------------
DROP TABLE IF EXISTS `w_deliverymaster`;
CREATE TABLE `w_deliverymaster` (
  `DeliveryID` bigint(20) NOT NULL auto_increment,
  `DeliveryPro` int(2) NOT NULL,
  `DeliveryDate` datetime NOT NULL,
  `FK_CustomerID` bigint(20) NOT NULL,
  `FK_SalesManID` bigint(20) default NULL,
  `DeliveryAddress` varchar(100) default NULL,
  `DelMoney` double(20,2) NOT NULL,
  PRIMARY KEY  (`DeliveryID`),
  KEY `FK_SalesManID` (`FK_SalesManID`),
  KEY `FK_CustomerID` (`FK_CustomerID`),
  CONSTRAINT `FK_CustomerID` FOREIGN KEY (`FK_CustomerID`) REFERENCES `w_customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_SalesManID` FOREIGN KEY (`FK_SalesManID`) REFERENCES `w_salesman` (`SalesManID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=220180505204936 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_deliverymaster
-- ----------------------------
INSERT INTO `w_deliverymaster` VALUES ('1', '1', '2018-05-05 20:44:50', '1', '1', '123', '13000.00');
INSERT INTO `w_deliverymaster` VALUES ('10', '1', '2018-05-05 20:44:50', '1', null, null, '100.00');
INSERT INTO `w_deliverymaster` VALUES ('120180505211022', '1', '2018-05-05 21:10:22', '1', '1', '1234', '0.00');
INSERT INTO `w_deliverymaster` VALUES ('120180505211345', '1', '2018-05-05 21:13:45', '1', '1', '1234', '0.00');
INSERT INTO `w_deliverymaster` VALUES ('120180506001109', '1', '2018-05-06 00:11:09', '1', '1', '1234', '10000.00');
INSERT INTO `w_deliverymaster` VALUES ('120180506001321', '1', '2018-05-06 00:13:21', '1', '1', '', '0.00');
INSERT INTO `w_deliverymaster` VALUES ('120180506001642', '1', '2018-05-06 00:16:42', '1', '1', '', '0.00');
INSERT INTO `w_deliverymaster` VALUES ('120180506202258', '1', '2018-05-06 20:22:58', '1', '1', '1234', '0.00');
INSERT INTO `w_deliverymaster` VALUES ('120180506232042', '-1', '2018-05-06 23:20:42', '1', null, null, '100.00');
INSERT INTO `w_deliverymaster` VALUES ('220180505204935', '1', '2018-05-05 20:49:35', '2', '3', '123', '0.00');

-- ----------------------------
-- Table structure for `w_product`
-- ----------------------------
DROP TABLE IF EXISTS `w_product`;
CREATE TABLE `w_product` (
  `ProductID` bigint(20) NOT NULL auto_increment,
  `ProductName` varchar(30) NOT NULL,
  `ProductUnit` varchar(10) default NULL,
  `SafeStock` bigint(10) NOT NULL,
  `LastPurDate` datetime default NULL,
  `LastDelDate` datetime default NULL,
  `Quantity` bigint(10) NOT NULL,
  `SuggestBuyPrice` double default NULL,
  `SuggestSalePrice` double default NULL,
  `FK_SupplierID` bigint(20) NOT NULL,
  PRIMARY KEY  (`ProductID`),
  KEY `FK_Supplier` (`FK_SupplierID`),
  CONSTRAINT `FK_Supplier` FOREIGN KEY (`FK_SupplierID`) REFERENCES `w_supplier` (`SupplierID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_product
-- ----------------------------
INSERT INTO `w_product` VALUES ('1', '可口可乐', '箱', '100', '2018-04-05 13:21:25', '2018-05-06 20:22:58', '400', '100', '120', '1');
INSERT INTO `w_product` VALUES ('2', '雪碧', '箱', '100', '2018-04-05 13:21:25', '2018-05-06 00:16:42', '960', '100', '120', '1');
INSERT INTO `w_product` VALUES ('3', '芬达', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '700', '100', '120', '1');
INSERT INTO `w_product` VALUES ('4', '美年达', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '800', '100', '120', '1');
INSERT INTO `w_product` VALUES ('5', '激活', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '1');
INSERT INTO `w_product` VALUES ('6', '伊利淡牛奶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '2');
INSERT INTO `w_product` VALUES ('7', '伊利雪糕', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '2');
INSERT INTO `w_product` VALUES ('8', '伊利奶粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '2');
INSERT INTO `w_product` VALUES ('9', '伊利酸奶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '2');
INSERT INTO `w_product` VALUES ('10', '黄豆酱', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '3');
INSERT INTO `w_product` VALUES ('11', '豆瓣酱', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '3');
INSERT INTO `w_product` VALUES ('12', '辣酱', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '3');
INSERT INTO `w_product` VALUES ('13', '番茄酱', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '3');
INSERT INTO `w_product` VALUES ('14', '王中王', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '4');
INSERT INTO `w_product` VALUES ('15', '肉粒多', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '4');
INSERT INTO `w_product` VALUES ('16', '鱼肠', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '4');
INSERT INTO `w_product` VALUES ('17', '牛肉肠', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '4');
INSERT INTO `w_product` VALUES ('18', '小麦', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '5');
INSERT INTO `w_product` VALUES ('19', '大豆', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '5');
INSERT INTO `w_product` VALUES ('20', '黑豆', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '5');
INSERT INTO `w_product` VALUES ('21', '面粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '5');
INSERT INTO `w_product` VALUES ('22', '维生素A片', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '6');
INSERT INTO `w_product` VALUES ('23', '维生素B片', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '6');
INSERT INTO `w_product` VALUES ('24', '维生素C片', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '6');
INSERT INTO `w_product` VALUES ('25', '牛乳粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '6');
INSERT INTO `w_product` VALUES ('26', '小面包', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '7');
INSERT INTO `w_product` VALUES ('27', '欧包', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '7');
INSERT INTO `w_product` VALUES ('28', '菠萝包', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '7');
INSERT INTO `w_product` VALUES ('29', '吐司', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '7');
INSERT INTO `w_product` VALUES ('30', '光明淡牛奶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '8');
INSERT INTO `w_product` VALUES ('31', '光明奶粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '8');
INSERT INTO `w_product` VALUES ('32', '光明雪糕', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '8');
INSERT INTO `w_product` VALUES ('33', '光明甜牛奶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '8');
INSERT INTO `w_product` VALUES ('34', '小鱼片', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '9');
INSERT INTO `w_product` VALUES ('35', '小鱿鱼', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '9');
INSERT INTO `w_product` VALUES ('36', '炸带鱼', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '9');
INSERT INTO `w_product` VALUES ('37', '鱼丸', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '9');
INSERT INTO `w_product` VALUES ('38', '脱脂奶粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '10');
INSERT INTO `w_product` VALUES ('39', '全脂奶粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '10');
INSERT INTO `w_product` VALUES ('40', '加钙奶粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '10');
INSERT INTO `w_product` VALUES ('41', '老年奶粉', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '10');
INSERT INTO `w_product` VALUES ('42', '罐装凉茶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '11');
INSERT INTO `w_product` VALUES ('43', '盒装凉茶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '11');
INSERT INTO `w_product` VALUES ('44', '瓶装凉茶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '11');
INSERT INTO `w_product` VALUES ('45', '袋装凉茶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '11');
INSERT INTO `w_product` VALUES ('46', '花生油', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '12');
INSERT INTO `w_product` VALUES ('47', '芝麻油', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '12');
INSERT INTO `w_product` VALUES ('48', '胡椒油', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '12');
INSERT INTO `w_product` VALUES ('49', '花椒油', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '12');
INSERT INTO `w_product` VALUES ('50', '二锅头', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '13');
INSERT INTO `w_product` VALUES ('51', '番薯烧', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '13');
INSERT INTO `w_product` VALUES ('52', '白酒', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '13');
INSERT INTO `w_product` VALUES ('53', '黄酒', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '13');
INSERT INTO `w_product` VALUES ('54', '阿萨姆奶茶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '14');
INSERT INTO `w_product` VALUES ('55', '红烧牛肉面', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '14');
INSERT INTO `w_product` VALUES ('56', '番茄牛肉面', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '14');
INSERT INTO `w_product` VALUES ('57', '酱汁拌面', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '14');
INSERT INTO `w_product` VALUES ('58', '旺旺雪饼', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '15');
INSERT INTO `w_product` VALUES ('59', '旺旺甜牛奶', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '15');
INSERT INTO `w_product` VALUES ('60', '旺旺大礼包', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '15');
INSERT INTO `w_product` VALUES ('61', '旺旺海苔饼', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '15');
INSERT INTO `w_product` VALUES ('62', '小面包', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '16');
INSERT INTO `w_product` VALUES ('63', '奶黄包', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '16');
INSERT INTO `w_product` VALUES ('64', '软面包', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '16');
INSERT INTO `w_product` VALUES ('65', '饼干', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '16');
INSERT INTO `w_product` VALUES ('66', '饼干', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '17');
INSERT INTO `w_product` VALUES ('67', '红烧牛肉面', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '17');
INSERT INTO `w_product` VALUES ('68', '炸酱面', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '100', '120', '17');
INSERT INTO `w_product` VALUES ('69', '火鸡面', '箱', '100', '2018-04-05 13:21:25', '2018-04-05 13:21:25', '500', '69', '120', '17');

-- ----------------------------
-- Table structure for `w_purchasedetail`
-- ----------------------------
DROP TABLE IF EXISTS `w_purchasedetail`;
CREATE TABLE `w_purchasedetail` (
  `FK_PurchaseID` bigint(20) NOT NULL,
  `FK_ProductID` bigint(20) NOT NULL,
  `PurchaseQua` bigint(20) NOT NULL,
  `PurchasePrice` double(20,2) NOT NULL,
  KEY `FK_PurchaseID` (`FK_PurchaseID`),
  KEY `FK_ProductID` (`FK_ProductID`),
  CONSTRAINT `FK_ProductID` FOREIGN KEY (`FK_ProductID`) REFERENCES `w_product` (`ProductID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_PurchaseID` FOREIGN KEY (`FK_PurchaseID`) REFERENCES `w_purchasemaster` (`PurchaseID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_purchasedetail
-- ----------------------------
INSERT INTO `w_purchasedetail` VALUES ('1', '1', '100', '100.00');
INSERT INTO `w_purchasedetail` VALUES ('1', '1', '100', '200.00');

-- ----------------------------
-- Table structure for `w_purchasemaster`
-- ----------------------------
DROP TABLE IF EXISTS `w_purchasemaster`;
CREATE TABLE `w_purchasemaster` (
  `PurchaseID` bigint(20) NOT NULL auto_increment,
  `PurchaseDate` datetime default NULL,
  `PurchasePro` int(1) default NULL,
  `PurMoney` double(20,2) NOT NULL,
  PRIMARY KEY  (`PurchaseID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_purchasemaster
-- ----------------------------
INSERT INTO `w_purchasemaster` VALUES ('1', '2018-04-02 19:15:29', '1', '100.00');

-- ----------------------------
-- Table structure for `w_salesman`
-- ----------------------------
DROP TABLE IF EXISTS `w_salesman`;
CREATE TABLE `w_salesman` (
  `SalesManID` bigint(20) NOT NULL auto_increment,
  `SalesManName` varchar(10) NOT NULL,
  `SalesManTele` varchar(20) default NULL,
  `SalesManMob` varchar(20) default NULL,
  `SalesManAdd` varchar(50) default NULL,
  `SalesManEmail` varchar(30) default NULL,
  PRIMARY KEY  (`SalesManID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_salesman
-- ----------------------------
INSERT INTO `w_salesman` VALUES ('1', '小明', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('2', '小王', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('3', '小戴', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('4', '小李', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('5', '小胡', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('6', '小四', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('7', '小高', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('8', '小徐', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('9', '小叶', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('10', '小张', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('11', '张三', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('12', '赵四', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('40', '小钱', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('41', '小唐', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('42', '小小', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('43', '小黄', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('44', '小周', '123456', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('45', '小刘', '1234567', '123456', '浙江省杭州市', '123456@qq.com');
INSERT INTO `w_salesman` VALUES ('46', '小虎', '123456', '123456', '浙江省杭州市', '123456@qq.com');

-- ----------------------------
-- Table structure for `w_supcontact`
-- ----------------------------
DROP TABLE IF EXISTS `w_supcontact`;
CREATE TABLE `w_supcontact` (
  `SupContactID` bigint(20) NOT NULL auto_increment,
  `SupContactName` varchar(10) NOT NULL,
  `SupContactTitle` varchar(10) default NULL,
  `SupContactTele` varchar(20) default NULL,
  `SupContactMob` varchar(20) default NULL,
  `FK_SupplierID` bigint(20) default NULL,
  PRIMARY KEY  (`SupContactID`),
  KEY `FK_SupplierID_Supplier` (`FK_SupplierID`),
  CONSTRAINT `FK_SupplierID_Supplier` FOREIGN KEY (`FK_SupplierID`) REFERENCES `w_supplier` (`SupplierID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_supcontact
-- ----------------------------

-- ----------------------------
-- Table structure for `w_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `w_supplier`;
CREATE TABLE `w_supplier` (
  `SupplierID` bigint(20) NOT NULL auto_increment,
  `SupplierSimpleName` varchar(20) NOT NULL,
  `SupplierName` varchar(60) default NULL,
  `SupplierOwner` varchar(30) default NULL,
  `SupplierTele` varchar(20) default NULL,
  `SupplierMob` varchar(20) default NULL,
  `SupplierFax` varchar(20) default NULL,
  `SuppliercomAddress` varchar(60) default NULL,
  `SupplierFacAddress` varchar(60) default NULL,
  `SupplierLastPurDate` datetime default NULL,
  PRIMARY KEY  (`SupplierID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_supplier
-- ----------------------------
INSERT INTO `w_supplier` VALUES ('1', '可口可乐公司', '可口可乐有限公司', '张三', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('2', '伊利股份', '伊利股份有限公司', '李彦龙', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('3', '海天味业', '海天味业有限公司', '李浩鹏', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('4', '双汇发展', '双汇发展有限公司', '李天一', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('5', '中粮屯河', '中粮屯河有限公司', '李铁刚', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('6', '汤臣倍健', '汤臣倍健有限公司', '李君昊', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('7', '桃李面包', '桃李面包有限公司', '王满', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('8', '光明乳业', '光明乳业有限公司', '王琳', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('9', '皇氏集团', '皇氏集团有限公司', '王琳', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('10', '贝因美', '贝因美有限公司', '王艺博', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('11', '加多宝', '加多宝有限公司', '王伟', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('12', '鲁花', '鲁花有限公司', '胡泽洋', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('13', '五粮液集团', '五粮液集团有限公司', '张欣竹', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('14', '统一企业', '统一企业有限公司', '张欣阳', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('15', '中国旺旺', '中国旺旺有限公司', '胡煜曦', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('16', '达利食品', '达利食品有限公司', '胡晓', '123', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');
INSERT INTO `w_supplier` VALUES ('17', '今麦郎', '今麦郎有限公司', '张靖阳', '1234', '123', '123', '浙江省杭州市', '浙江省杭州市', '2018-04-27 15:22:11');

-- ----------------------------
-- Table structure for `w_user`
-- ----------------------------
DROP TABLE IF EXISTS `w_user`;
CREATE TABLE `w_user` (
  `UserID` bigint(20) NOT NULL auto_increment COMMENT '用户编号',
  `UserName` varchar(30) NOT NULL,
  `PasswordCode` varchar(128) NOT NULL COMMENT '用户密码',
  `IsUse` int(11) default NULL COMMENT '正常为1，禁用-1',
  PRIMARY KEY  (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_user
-- ----------------------------
INSERT INTO `w_user` VALUES ('1', 'king', '123', '1');
INSERT INTO `w_user` VALUES ('2', 'jack', '1234', '0');
INSERT INTO `w_user` VALUES ('6', 'bob', '1234', '0');
INSERT INTO `w_user` VALUES ('7', 'mini', '1234', '0');

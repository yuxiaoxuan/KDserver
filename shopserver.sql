/*
MySQL Data Transfer
Source Host: localhost
Source Database: shopserver
Target Host: localhost
Target Database: shopserver
Date: 2014/4/15 0:39:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admins
-- ----------------------------
CREATE TABLE `admins` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(30) default NULL,
  `password` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for bz
-- ----------------------------
CREATE TABLE `bz` (
  `id` int(11) NOT NULL auto_increment,
  `bname` varchar(30) default NULL,
  `desc1` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cars
-- ----------------------------
CREATE TABLE `cars` (
  `id` int(11) NOT NULL auto_increment,
  `cx` varchar(30) default NULL,
  `gurl` varchar(200) default NULL,
  `gs` varchar(30) default NULL,
  `jl` varchar(30) default NULL,
  `jg` varchar(30) default NULL,
  `tb` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for dingdan
-- ----------------------------
CREATE TABLE `dingdan` (
  `id` int(11) NOT NULL auto_increment,
  `myid` int(11) default NULL,
  `totle` double default NULL,
  `dates` datetime default NULL,
  `phone` varchar(50) default NULL,
  `address` varchar(100) default NULL,
  `type` varchar(10) default NULL,
  `state` varchar(10) default '未发货',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for dingdanmore
-- ----------------------------
CREATE TABLE `dingdanmore` (
  `id` int(11) NOT NULL auto_increment,
  `dingdanid` int(11) default NULL,
  `gname` varchar(30) default NULL,
  `count` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
CREATE TABLE `goods` (
  `id` int(11) NOT NULL auto_increment,
  `gname` varchar(30) default NULL,
  `gurl` varchar(100) default NULL,
  `gprice` double default NULL,
  `gcount` int(11) default NULL,
  `gtype` varchar(10) default NULL,
  `lx` varchar(30) default NULL,
  `gs` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for gs
-- ----------------------------
CREATE TABLE `gs` (
  `id` int(11) NOT NULL auto_increment,
  `gname` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `address` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for gwc
-- ----------------------------
CREATE TABLE `gwc` (
  `id` int(11) NOT NULL auto_increment,
  `userid` int(11) default NULL,
  `goodsName` varchar(30) default NULL,
  `gcount` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for lx
-- ----------------------------
CREATE TABLE `lx` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE TABLE `users` (
  `id` int(10) NOT NULL auto_increment,
  `userName` varchar(30) default NULL,
  `password` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `address` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admins` VALUES ('2', '1', '1');
INSERT INTO `bz` VALUES ('4', '2', '2');
INSERT INTO `bz` VALUES ('5', 'r', 'r');
INSERT INTO `dingdan` VALUES ('3', '6', '35', '2014-03-31 03:00:30', '11', '11', '网银直接支付', '未发货');
INSERT INTO `dingdan` VALUES ('4', '0', '24', '2014-03-31 03:00:30', '2', '2', '网银直接支付', '未发货');
INSERT INTO `dingdan` VALUES ('5', '7', '35', '2014-03-31 03:00:30', '11', '11', '网银直接支付', '未发货');
INSERT INTO `dingdan` VALUES ('6', '9', '77', '2014-04-15 00:27:43', '1111', '111', '信用卡支付', '未发货');
INSERT INTO `dingdanmore` VALUES ('4', '3', '1', '1');
INSERT INTO `dingdanmore` VALUES ('5', '3', '2', '1');
INSERT INTO `dingdanmore` VALUES ('6', '4', '1', '2');
INSERT INTO `dingdanmore` VALUES ('7', '4', '2', '0');
INSERT INTO `dingdanmore` VALUES ('8', '5', '1', '1');
INSERT INTO `dingdanmore` VALUES ('9', '5', '2', '1');
INSERT INTO `dingdanmore` VALUES ('10', '6', '222', '1');
INSERT INTO `dingdanmore` VALUES ('11', '6', '5555', '1');
INSERT INTO `goods` VALUES ('10', '3', 'http://10.0.2.2:8080/CarServer/goods/9.jpg', '33', '33', '1', '2', '2');
INSERT INTO `goods` VALUES ('11', '5', 'http://10.0.2.2:8080/CarServer/goods/1.jpg', '55', '55', '1', '2', '3');
INSERT INTO `goods` VALUES ('12', '222', 'http://192.168.0.101:8080/ShopServer/goods/3.jpg', '22', '21', '1', null, null);
INSERT INTO `goods` VALUES ('13', '2222', 'http://192.168.0.101:8080/ShopServer/goods/', '22222', '2222', '1', null, null);
INSERT INTO `goods` VALUES ('14', '5555', 'http://192.168.0.101:8080/ShopServer/goods/4.jpg', '55', '54', '1', null, null);
INSERT INTO `gs` VALUES ('3', '123', '1', '1');
INSERT INTO `gs` VALUES ('5', 't', '3', '3');
INSERT INTO `gwc` VALUES ('8', '6', '1', '1');
INSERT INTO `gwc` VALUES ('9', '6', '2', '1');
INSERT INTO `gwc` VALUES ('10', '0', '1', '2');
INSERT INTO `gwc` VALUES ('11', '0', '2', '0');
INSERT INTO `gwc` VALUES ('12', '7', '1', '1');
INSERT INTO `gwc` VALUES ('13', '7', '2', '1');
INSERT INTO `gwc` VALUES ('14', '9', '222', '1');
INSERT INTO `gwc` VALUES ('15', '9', '5555', '1');
INSERT INTO `lx` VALUES ('1', '12');
INSERT INTO `lx` VALUES ('2', '越野');
INSERT INTO `users` VALUES ('5', '1', '1', '1', '1');
INSERT INTO `users` VALUES ('6', '3', '3', '3', '3');
INSERT INTO `users` VALUES ('7', 't', 't', '123', 'rt');
INSERT INTO `users` VALUES ('8', '111', '111', '111', '111');
INSERT INTO `users` VALUES ('9', '66', '66', '66266', '588');
INSERT INTO `users` VALUES ('10', '8888', '8888', '8888', '8888');

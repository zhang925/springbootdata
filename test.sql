/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-04-20 10:28:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_classic
-- ----------------------------
DROP TABLE IF EXISTS `t_classic`;
CREATE TABLE `t_classic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` int(11) DEFAULT NULL COMMENT '上传人id(实体)',
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8_bin COMMENT '内容',
  `createtime` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_classic
-- ----------------------------
INSERT INTO `t_classic` VALUES ('1', '5201314', '缘分', 0xE4BABAE7949FE5B0B1E5838FE892B2E585ACE88BB13C62722F3E0D0AE79C8BE4BCBCE887AAE794B13C62722F3EE58DB4E8BAABE4B88DE794B1E5B7B13C62722F3E0D0AE8AEB8E5A49AE4BABAE38081E8AEB8E5A49AE4BA8B3C62722F3E0D0AE6988EE6988EE5BE88E59CA8E4B98E3C62722F3E0D0AE58FAFE58F88E883BDE6808EE6A0B7E591A23C62722F3E0D0AE7BC98E58886E69DA5E4BA863C62722F3E0D0AE5B0B1E69DA5E4BA863C62722F3E, ' 2016:07:05 15:58:34 ');
INSERT INTO `t_classic` VALUES ('3', '5201314', '当幸福来时', 0xE4BABAE59CA8E99DA2E4B8B4E5B9B8E7A68FE697B63C62722F3E3C62722F3EE4BC9AE58F98E5BE97E5BE88E88386E680AF3C62722F3E3C62722F3EE68A93E4BD8FE5B9B8E7A68F3C62722F3E3C62722F3EE6AF94E5BF8DE58F97E7979BE88BA6E69BB4E99C80E8A681E58B87E6B0943C62722F3E, '2016:07:07 11:39:52 ');
INSERT INTO `t_classic` VALUES ('6', '5201314', '等待', 0xE4BDA0E8AFB4E4BDA0E79BB8E4BFA1E7BC98E588863C62722F3E3C62722F3E0D0AE58FAFE698AFE4B88DE883BDE680BBE7AD89E79D80E7BC98E58886E982A33C62722F3E3C62722F3E0D0AE69C89E4BA9BE8AF9DEFBC8CE69C89E4BA9BE4BA8B3C62722F3E3C62722F3E0D0AE59CA8E4B88DE8AFB4EFBC8CE59CA8E4B88DE5819A3C62722F3E3C62722F3E0D0AE58F88E8A681E7AD89E5A49AE5B091E5B9B43C62722F3E3C62722F3E, '2016:07:07 14:36:18 ');
INSERT INTO `t_classic` VALUES ('7', '5201314', '明天过后', 0x0D0AE698AFE590A6E4B8A4E4B8AAE4BABAE8B6B3E5A49FE68D95E68D89E788B1E79A84E9959CE5A4B4203C62722F3E0D0AE997ADE4B88AE4BA86E79CBCE79D9BE8AEB0E5BE97E4BDA0E79A84E7AC91E5AEB9203C62722F3E0D0AE5B9B8E7A68FE79A84E4BB8EE5AEB9E5B086E781B5E9AD82E983BDE68E8FE7A9BA203C62722F3E0D0AE4BAABE58F97E4B880E58886E9929FE79A84E6849FE58AA8203C62722F3E3C62722F3E0D0A0D0AE698AFE590A6E788B1E4B88AE4B880E4B8AAE4BABAE4B88DE997AEE6988EE5A4A9E8BF87E5908E203C62722F3E0D0AE5B1B1E6988EE5928CE6B0B4E7A780E4B88DE6AF94E4BDA0E69C89E79C8BE5A4B4203C62722F3E0D0AE789B5E79D80E4BDA0E79A84E6898BEFBC8CE4B880E79BB4E8B5B0E588B0E69C80E5908E203C62722F3E0D0AE8BF99E4B880E588BBE6808EE4B988E59B9EE5A4B4203C62722F3E3C62722F3E0D0A, '2016:07:25 14:47:56 ');
INSERT INTO `t_classic` VALUES ('8', '5201314', '大鱼海棠', 0xE4BDA0E79BB8E4BFA1E5A587E8BFB9E590973C62722F3E0D0A0D0AE7949FE591BDE698AFE4B880E59CBAE69785E7A88B3C62722F3E0D0A0D0AE68891E4BBACE7AD89E4BA86E5A49AE5B091E4B8AAE8BDAEE59B9E3C62722F3E0D0A0D0AE6898DE69C89E69CBAE4BC9AE4BAABE58F97E8BF99E4B880E6ACA1E79A84E69785E7A88B3C62722F3E0D0A0D0AE8BF99E79FADE79FADE79A84E4B880E7949F3C62722F3E0D0A0D0AE68891E4BBACE69C80E7BB88E983BDE4BC9AE5A4B1E58EBB3C62722F3E0D0A0D0AE4BDA0E4B88DE5A6A8E5A4A7E88386E4B880E4BA9B3C62722F3E0D0A0D0AE788B1E4B880E4B8AAE4BABA3C62722F3E0D0A0D0AE69480E4B880E5BAA7E5B1B13C62722F3E0D0A0D0AE8BFBDE4B880E4B8AAE6A2A63C62722F3E0D0A0D0AE698AFE79A843C62722F3E0D0A0D0AE4B88DE5A6A8E5A4A7E88386E4B880E4BA9B3C62722F3E0D0A0D0AE5BE88E5A49AE4BA8BE68891E983BDE4B88DE4BA86E8A7A33C62722F3E0D0A0D0AE5BE88E5A49AE997AEE9A298E4B99FE6B2A1E69C89E7AD94E6A1883C62722F3E0D0A0D0AE4BD86E68891E79BB8E4BFA13C62722F3E0D0A0D0AE4B88AE5A4A9E7BB99E68891E4BBACE7949FE591BD3C62722F3E0D0A0D0AE4B880E5AE9AE698AFE4B8BAE4BA86E8AEA9E68891E4BBACE5889BE980A0E5A587E8BFB9E79A843C62722F3E0D0A0D0A2D2DE3808AE5A4A7E9B1BCE6B5B7E6A3A0E3808B, '2016:07:26 15:06:21 ');
INSERT INTO `t_classic` VALUES ('9', '5201314', '夏洛特烦恼 经典歌曲', 0xE58F8CE88A82E6A38D3C62722F3E0D0AE88F8AE88AB1E58FB03C62722F3E0D0AE4B880E589AAE6A2853C62722F3E0D0AE4B880E6ACA1E5B0B1E5A5BD3C62722F3E0D0AE5BF83E5A4AAE8BDAF3C62722F3E0D0AE4BABAE59CA8E69785E980943C62722F3E0D0AE5A48FE6B49BE789B9E783A6E681BC3C62722F3E0D0AE79BB8E7BAA639383C62722F3E0D0AE68891E5928CE4BDA03C62722F3E0D0AE592B1E4BBACE5B1AFE9878CE79A84E4BABA3C62722F3E0D0AE69C89E4B8AAE788B1E4BDA0E79A84E4BABAE4B88DE5AEB9E698933C62722F3E0D0A3C62722F3E0D0AE7A9B7E697B6E586ACE6A285E5A5BDE5AF8CE697B6E7A78BE99B85E9A6993C62722F3E, '2016:07:26 15:19:26 ');
INSERT INTO `t_classic` VALUES ('10', '5201314', '学着尝试', 0x0D0AE5BE88E5A49AE683B3E8A681E5819AE79A84E4BA8BEFBC8C3C62722F3E0D0A0D0AE5928CE5819AE587BAE79A84E4BA8BE68385EFBC8C3C62722F3E0D0A0D0AE4BBA5E58F8AE69C80E5908EE79A84E7BB93E69E9CEFBC8C3C62722F3E0D0A0D0AE5BE80E5BE80E4B88DE4B880E6A0B7E380823C62722F3E0D0A0D0AE8B68AE683B3E6808EE4B988E6A0B7EFBC8C3C62722F3E0D0A0D0AE7BB93E69E9CE4BC9AE8B68AE5A4B1E69C9BE380823C62722F3E0D0A0D0AE4BABAE7949FE58FAFE4BBA5E69C89E5908EE68294EFBC8C3C62722F3E0D0A0D0AE4BD86E698AFE4B88DE883BDE79599E4B88BE98197E686BEE380823C62722F3E0D0A0D0AE588ABE5868DE7AD89E5BE85E4BA86EFBC8C3C62722F3E0D0A0D0AE887B3E5B091E8A681E58EBBE8AF95E4B880E8AF95E380823C62722F3E, '2016:07:26 15:43:38 ');
INSERT INTO `t_classic` VALUES ('11', '5201314', '当你失去1了所有之后，就会得到了。', 0xE5A484E59CA8E5B1B1E8B0B7E4BD8EE782B9E5B9B6E4B88DE58FAFE68095EFBC8C3C62722F3E0D0AE58FAFE68095E79A84E698AFE8B9B2E59CA8E5B1B1E8B0B7E9878CE8A3B9E8B6B3E4B88DE5898DE380823C62722F3E0D0AE5B1B1E8B0B7E79A84E4BD8EE782B9E6ADA3E698AFE4BABAE7949FE79A84E8B5B7E782B9EFBC8C3C62722F3E0D0AE58FAAE8A681E6B2BFE79D80E8B5B7E782B9E5BC80E5A78BE8B5B7E6ADA5EFBC8C3C62722F3E0D0AE4B880E5AE9AE883BDE799BBE4B88AE4BABAE7949FE79A84E69C80E9AB98E5B3B0E380823C62722F3E0D0A0D0A, '2016:08:11 10:20:04 ');
INSERT INTO `t_classic` VALUES ('12', '5201314', '顺其自然', 0xE69198E4B88DE588B0E79A84E6989FE6989FEFBC8CE680BBE698AFE69C80E997AAE4BAAEE79A84E380823C62722F3E0D0AE6BA9CE68E89E79A84E5B08FE9B1BCEFBC8CE680BBE698AFE69C80E7BE8EE4B8BDE79A84E380823C62722F3E0D0AE99499E8BF87E79A84E794B5E5BDB1EFBC8CE680BBE698AFE69C80E5A5BDE79C8BE79A84E380823C62722F3E0D0AE5A4B1E58EBBE79A84E68385E4BABAEFBC8CE680BBE698AFE69C80E68782E4BDA0E79A84E380823C62722F3E0D0AE8BF99E4B896E7958CE4B88AEFBC8CE6AF8FE4B8AAE4BABAE983BDE69C89E4B8AAE683B3E8A681E5AFBBE689BEE79A84E4BABAE380823C62722F3E0D0AE4B880E4BD86E99499E8BF87E4BA86EFBC8CE5B0B1E59CA8E4B99FE4B88DE4BC9AE59B9EE69DA5E380823C62722F3E0D0AE5BE97E4B98BE68891E5B9B8EFBC8CE5A4B1E4B98BE68891E591BDE380823C62722F3E0D0AE8AFA5E69DA5E79A84E680BBE4BC9AE69DA5EFBC8C3C62722F3E0D0AE8AFA5E8B5B0E79A84E680BBE4BC9AE8B5B0E380823C62722F3E, '2016:08:11 10:20:34 ');
INSERT INTO `t_classic` VALUES ('17', '5201314', '缘分123', 0x3C703EE9AD94E99D9EE9AD9420E98193E99D9EE9819320E59684E681B6E59CA8E4BABAE5BF833C62722F3EE6ACB2E99D9EE6ACB220E68385E99D9EE6838520E7BC98E58886E5A4A9E6B3A8E5AE9A3C2F703E3C703E3C62722F3E3C2F703E3C703EE4BDA0E5A682E88AB1E5BC8020E89DB4E89DB6E887AAE69DA53C62722F3EE4BDA0E88BA5E7B2BEE5BDA920E5A4A9E887AAE5AE89E68E923C2F703E, '2016:09:02 17:45:15 ');
INSERT INTO `t_classic` VALUES ('20', '5211314', '缘分', 0x3C703EE4BDA0E68891E983BDE8A681E79BB8E4BFA13C2F703E3C703EE8BF99E698AFE5A4A9E6848F3C2F703E3C703EE4B99FE698AFE4BCA0E8AFB4E4B8ADE79A843C2F703E3C703EE7BC98E588863C62722F3E3C2F703E3C703E3C62722F3E3C2F703E, '2016:10:08 16:28:57 ');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5211315 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张无忌', '华山');
INSERT INTO `user` VALUES ('2', '小飞侠', '超神学院');
INSERT INTO `user` VALUES ('22', '2', '2召唤者峡谷');
INSERT INTO `user` VALUES ('5201314', '微笑', '北京');
INSERT INTO `user` VALUES ('5211314', '张小凡', '昆仑需');

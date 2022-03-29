/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : forum

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-12-17 10:55:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(1024) DEFAULT NULL,
  `content` varchar(1024) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `useful` bit(1) NOT NULL,
  `id_topic` bigint DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjyya1ipmyfw7iea1kr80c43h1` (`id_topic`),
  KEY `FK8ddy56hrr3tsqi29o3i5q48al` (`id_user`),
  CONSTRAINT `FK8ddy56hrr3tsqi29o3i5q48al` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FKjyya1ipmyfw7iea1kr80c43h1` FOREIGN KEY (`id_topic`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('144', null, '给自己回复下', '2021-12-14 09:08:04', '\0', '93', '24');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) NOT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('61', 'http://r47obsdx5.hn-bkt.clouddn.com/1330460499a64e1fae27efbc5bea1fe2.jpg', '24');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `from_id` bigint DEFAULT NULL,
  `to_id` bigint DEFAULT NULL,
  `content` text,
  `created_date` datetime DEFAULT NULL,
  `id_topic` bigint DEFAULT NULL,
  `has_read` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('81', '23', '22', '用户admin评论你的话题！', '2021-12-14 02:33:03', '91', '1');
INSERT INTO `message` VALUES ('82', '23', '22', '用户admin评论你的话题！', '2021-12-14 11:10:42', '91', '1');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(16) NOT NULL,
  `code` varchar(1024) DEFAULT NULL,
  `content` varchar(1024) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `title` varchar(32) NOT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6br5a7f1rn1bi94rkmi38mcln` (`id_user`),
  CONSTRAINT `FK6br5a7f1rn1bi94rkmi38mcln` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('70', 'se', null, '啊啊啊', '2021-12-14 01:51:48', '啊啊啊啊', '22');
INSERT INTO `topic` VALUES ('71', 'se', null, '巴巴爸爸', '2021-12-14 01:51:59', '巴巴爸爸', '22');
INSERT INTO `topic` VALUES ('72', 'ee', null, '巴巴爸爸不不', '2021-12-14 01:52:07', '巴巴爸爸', '22');
INSERT INTO `topic` VALUES ('73', 'se', null, ' 是多少', '2021-12-14 01:52:16', '是的都是的', '22');
INSERT INTO `topic` VALUES ('74', 'se', '啊洒啊啊 asas asasasas洒啊\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n', '洒啊 啊', '2021-12-14 01:52:49', '啊啊撒', '22');
INSERT INTO `topic` VALUES ('75', 'se', null, '1111', '2021-12-14 01:52:57', '1111', '22');
INSERT INTO `topic` VALUES ('76', 'se', '111111111', '111', '2021-12-14 01:53:06', '11111', '22');
INSERT INTO `topic` VALUES ('77', 'se', null, '22222', '2021-12-14 01:53:12', '2222', '22');
INSERT INTO `topic` VALUES ('78', 'se', '222', '2222', '2021-12-14 01:53:19', '22222', '22');
INSERT INTO `topic` VALUES ('81', 'se', '1231231231', '3213123123123', '2021-12-14 01:53:47', '2113123123', '22');
INSERT INTO `topic` VALUES ('82', 'se', null, '3123123123123', '2021-12-14 01:53:55', '12312312312', '22');
INSERT INTO `topic` VALUES ('83', 'se', null, '23123123', '2021-12-14 01:54:11', '1231231', '22');
INSERT INTO `topic` VALUES ('84', 'se', null, '无穷诶群翁', '2021-12-14 01:54:43', '无穷诶群翁群无', '22');
INSERT INTO `topic` VALUES ('85', 'se', null, '诶请问群翁无群额', '2021-12-14 01:54:59', '无穷诶群翁群无', '22');
INSERT INTO `topic` VALUES ('86', 'se', null, '奇尔韦尔且请问', '2021-12-14 01:55:08', '诶请问群翁群无额', '22');
INSERT INTO `topic` VALUES ('87', 'se', null, '请问请问', '2021-12-14 01:55:15', '诶请问群翁', '22');
INSERT INTO `topic` VALUES ('88', 'se', null, '企鹅王群', '2021-12-14 01:55:20', '诶请问群', '22');
INSERT INTO `topic` VALUES ('89', 'se', null, '诶请问群恶', '2021-12-14 01:55:27', '诶请问群恶', '22');
INSERT INTO `topic` VALUES ('90', 'ee', null, '恶趣味去', '2021-12-14 01:55:35', '诶请问群翁', '22');
INSERT INTO `topic` VALUES ('91', 'se', null, '恶趣味 ', '2021-12-14 01:55:44', '恶趣味无群二', '22');
INSERT INTO `topic` VALUES ('92', 'other', ' <main layout:fragment=\"content\">\r\n        <article class=\"container\" style=\"padding: 3% 0 2%;\">\r\n            <header class=\"row\">\r\n                <div class=\"col s12\">\r\n                    <blockquote class=\"flow-text left\" th:text=\"|选择一个目录并创建相应的话题： |\">Add topic</blockquote>\r\n                </div>\r\n            </header>\r\n            <section>\r\n                <form th:action=\"@{/addTopic}\" method=\"post\">\r\n                    <div class=\"row\">\r\n                        <div class=\"col s12\">\r\n                            <p>\r\n                                <input value=\"se\" name=\"category\" class=\"with-gap\" type=\"radio\" id=\"se\" required=\"required\"/>\r\n                                <label for=\"se\">Java Standard Edition</label>\r\n                            </p>\r\n                            <p>\r\n                                <input value=\"ee\" name=\"category\" class=\"with-gap\" type=\"radio\" id=\"ee\" required=\"required\"/>\r\n                                <label for=\"ee\">Java Enterprise Edition</label>', '这是分享的内容', '2021-12-14 13:35:24', '分享', '22');
INSERT INTO `topic` VALUES ('93', 'se', '代码在这呢', '这是内容哦', '2021-12-14 09:07:48', '我叫吴弘博', '24');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `introduction` varchar(16) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `username` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('22', '2021-12-13 08:00:00', '我是xxmy', '$2a$10$5/5cFmJ5oL.BbUfj.jrZWuEXFTY6lMjyMu8woeRNbVgGoMvrROhr2', 'xxmy');
INSERT INTO `user` VALUES ('23', '2021-12-14 01:57:14', null, '$2a$10$z08wNFW8NPY65.uRAjr9PekGuYX9Vi0aWMQR9y.fsUADeM/Dr6psq', 'admin');
INSERT INTO `user` VALUES ('24', '2021-12-14 09:07:05', null, '$2a$10$UsbbZolSQft1ILTcoiY9Ue7WZfGOUTDNFrvA9QNFXXB1N.bxPxmHS', 'whb');
INSERT INTO `user` VALUES ('29', null, '密码123456', '$2a$10$XhyPdUd76MEc9ClnGIiwGeGv8P9ZY3KTeosKdzlVgxwcXRyc9YK4S', '测试');

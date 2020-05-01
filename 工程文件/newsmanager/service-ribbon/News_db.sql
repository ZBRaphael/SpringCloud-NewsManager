/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : News_db

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 14/11/2019 23:01:29
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) NOT NULL,
  `admin_pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for Column
-- ----------------------------
DROP TABLE IF EXISTS `Column`;
CREATE TABLE `Column` (
  `column_id` int(11) NOT NULL AUTO_INCREMENT,
  `column_name` varchar(20) NOT NULL,
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for Comment
-- ----------------------------
DROP TABLE IF EXISTS `Comment`;
CREATE TABLE `Comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for Keywords
-- ----------------------------
DROP TABLE IF EXISTS `Keywords`;
CREATE TABLE `Keywords` (
  `key_id` int(11) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(20) NOT NULL,
  PRIMARY KEY (`key_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for News
-- ----------------------------
DROP TABLE IF EXISTS `News`;
CREATE TABLE `News` (
  `news_id` int(11) NOT NULL,
  `news_title` varchar(100) NOT NULL,
  `news_intro` longtext NOT NULL,
  `news_content` longtext NOT NULL,
  `news_author` varchar(20) NOT NULL,
  `columns_id` int(11) NOT NULL,
  `news_data` datetime NOT NULL,
  `browse_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`news_id`),
  KEY `column_id_key` (`columns_id`),
  CONSTRAINT `column_id_key` FOREIGN KEY (`columns_id`) REFERENCES `column` (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for NewsCom
-- ----------------------------
DROP TABLE IF EXISTS `NewsCom`;
CREATE TABLE `NewsCom` (
  `newsCom_id` int(11) NOT NULL,
  `news_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  `comment_count` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`newsCom_id`),
  KEY `news_id_key` (`news_id`),
  KEY `comment_id_key` (`comment_id`),
  KEY `user_id_key` (`user_id`),
  CONSTRAINT `comment_id_key` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`),
  CONSTRAINT `news_id_key` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`),
  CONSTRAINT `user_id_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for NewsLike
-- ----------------------------
DROP TABLE IF EXISTS `NewsLike`;
CREATE TABLE `NewsLike` (
  `like_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `news_id` int(11) NOT NULL,
  PRIMARY KEY (`like_id`),
  KEY `like_user_id_key` (`user_id`),
  KEY `like_news_id_key` (`news_id`),
  CONSTRAINT `like_news_id_key` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`),
  CONSTRAINT `like_user_id_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for Users
-- ----------------------------
DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号，自增长',
  `user_name` varchar(20) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  `users_sex` varchar(20) NOT NULL,
  `full_name` varchar(20) DEFAULT NULL COMMENT '真实姓名\n',
  `question` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `answer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_pic` longblob COMMENT '头像',
  `forbidden` bit(1) DEFAULT NULL COMMENT '是否被禁止',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

SET FOREIGN_KEY_CHECKS = 1;

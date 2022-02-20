/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : blogs

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 20/02/2022 14:17:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blogs_article
-- ----------------------------
DROP TABLE IF EXISTS `blogs_article`;
CREATE TABLE `blogs_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `classify_id` int(11) NOT NULL COMMENT '分类',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `write_time` datetime(0) NOT NULL COMMENT '写入时间',
  `author_id` int(11) NOT NULL COMMENT '作者',
  `flag` int(11) NULL DEFAULT 1 COMMENT '是否显示(1显示,0删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `classify_id`(`classify_id`) USING BTREE,
  INDEX `author_id`(`author_id`) USING BTREE,
  CONSTRAINT `blogs_article_ibfk_1` FOREIGN KEY (`classify_id`) REFERENCES `blogs_article_classify` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `blogs_article_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `blogs_author` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blogs_article_classify
-- ----------------------------
DROP TABLE IF EXISTS `blogs_article_classify`;
CREATE TABLE `blogs_article_classify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `classify` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类标题',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blogs_author
-- ----------------------------
DROP TABLE IF EXISTS `blogs_author`;
CREATE TABLE `blogs_author`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `headAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UNIQUE1`(`author`) USING BTREE,
  UNIQUE INDEX `UNIQUE2`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blogs_comment
-- ----------------------------
DROP TABLE IF EXISTS `blogs_comment`;
CREATE TABLE `blogs_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `blogsId` int(11) NOT NULL COMMENT '博客编号(关联)',
  `authorId` int(11) NOT NULL COMMENT '作者评论',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `release_time` datetime(0) NOT NULL COMMENT '发布时间',
  `flag` int(11) NULL DEFAULT 1 COMMENT '是否删除(1显示,0删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `authorId`(`authorId`) USING BTREE,
  INDEX `blogsId`(`blogsId`) USING BTREE,
  CONSTRAINT `blogs_comment_ibfk_1` FOREIGN KEY (`authorId`) REFERENCES `blogs_author` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `blogs_comment_ibfk_2` FOREIGN KEY (`blogsId`) REFERENCES `blogs_article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 147 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

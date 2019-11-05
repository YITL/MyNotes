/*
 Navicat Premium Data Transfer

 Source Server         : Mysql_CentOS7
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:33066
 Source Schema         : my_test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 02/10/2019 00:33:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course`  (
  `cid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Course
-- ----------------------------
INSERT INTO `Course` VALUES ('01', '语文', '02');
INSERT INTO `Course` VALUES ('02', '数学', '01');
INSERT INTO `Course` VALUES ('03', '英语', '03');

-- ----------------------------
-- Table structure for SC
-- ----------------------------
DROP TABLE IF EXISTS `SC`;
CREATE TABLE `SC`  (
  `sid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` decimal(18, 1) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of SC
-- ----------------------------
INSERT INTO `SC` VALUES ('01', '01', 80.0);
INSERT INTO `SC` VALUES ('01', '02', 90.0);
INSERT INTO `SC` VALUES ('01', '03', 99.0);
INSERT INTO `SC` VALUES ('02', '01', 70.0);
INSERT INTO `SC` VALUES ('02', '02', 60.0);
INSERT INTO `SC` VALUES ('02', '03', 80.0);
INSERT INTO `SC` VALUES ('03', '01', 80.0);
INSERT INTO `SC` VALUES ('03', '02', 80.0);
INSERT INTO `SC` VALUES ('03', '03', 80.0);
INSERT INTO `SC` VALUES ('04', '01', 50.0);
INSERT INTO `SC` VALUES ('04', '02', 30.0);
INSERT INTO `SC` VALUES ('04', '03', 20.0);
INSERT INTO `SC` VALUES ('05', '01', 76.0);
INSERT INTO `SC` VALUES ('05', '02', 87.0);
INSERT INTO `SC` VALUES ('06', '01', 31.0);
INSERT INTO `SC` VALUES ('06', '03', 34.0);
INSERT INTO `SC` VALUES ('07', '02', 89.0);
INSERT INTO `SC` VALUES ('07', '03', 98.0);
INSERT INTO `SC` VALUES ('123', '04', 234.0);

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student`  (
  `sid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sage` datetime(0) NULL DEFAULT NULL,
  `ssex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Student
-- ----------------------------
INSERT INTO `Student` VALUES ('01', '赵雷', '1990-01-01 00:00:00', '男');
INSERT INTO `Student` VALUES ('02', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO `Student` VALUES ('03', '孙风', '1990-05-20 00:00:00', '男');
INSERT INTO `Student` VALUES ('04', '李云', '1990-08-06 00:00:00', '男');
INSERT INTO `Student` VALUES ('05', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO `Student` VALUES ('06', '吴兰', '1992-03-01 00:00:00', '女');
INSERT INTO `Student` VALUES ('07', '郑竹', '1989-07-01 00:00:00', '女');
INSERT INTO `Student` VALUES ('08', '王菊', '1990-01-20 00:00:00', '女');

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher`  (
  `tid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO `Teacher` VALUES ('01', '张三');
INSERT INTO `Teacher` VALUES ('02', '李四');
INSERT INTO `Teacher` VALUES ('03', '王五');

SET FOREIGN_KEY_CHECKS = 1;

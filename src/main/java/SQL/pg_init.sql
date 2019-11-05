/*
 Navicat Premium Data Transfer

 Source Server         : Postgres_CentOS7
 Source Server Type    : PostgreSQL
 Source Server Version : 90224
 Source Host           : 127.0.0.1:54322
 Source Catalog        : my_test
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90224
 File Encoding         : 65001

 Date: 02/10/2019 00:34:54
*/


-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS "public"."Course";
CREATE TABLE "public"."Course" (
  "cid" varchar(10) COLLATE "pg_catalog"."default",
  "cname" varchar(10) COLLATE "pg_catalog"."default",
  "tid" varchar(10) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of Course
-- ----------------------------
INSERT INTO "public"."Course" VALUES ('01', '语文', '02');
INSERT INTO "public"."Course" VALUES ('02', '数学', '01');
INSERT INTO "public"."Course" VALUES ('03', '英语', '03');

-- ----------------------------
-- Table structure for SC
-- ----------------------------
DROP TABLE IF EXISTS "public"."SC";
CREATE TABLE "public"."SC" (
  "sid" varchar(10) COLLATE "pg_catalog"."default",
  "cid" varchar(10) COLLATE "pg_catalog"."default",
  "score" numeric(18,1)
)
;

-- ----------------------------
-- Records of SC
-- ----------------------------
INSERT INTO "public"."SC" VALUES ('01', '01', 80.0);
INSERT INTO "public"."SC" VALUES ('01', '02', 90.0);
INSERT INTO "public"."SC" VALUES ('01', '03', 99.0);
INSERT INTO "public"."SC" VALUES ('02', '01', 70.0);
INSERT INTO "public"."SC" VALUES ('02', '02', 60.0);
INSERT INTO "public"."SC" VALUES ('02', '03', 80.0);
INSERT INTO "public"."SC" VALUES ('03', '01', 80.0);
INSERT INTO "public"."SC" VALUES ('03', '02', 80.0);
INSERT INTO "public"."SC" VALUES ('03', '03', 80.0);
INSERT INTO "public"."SC" VALUES ('04', '01', 50.0);
INSERT INTO "public"."SC" VALUES ('04', '02', 30.0);
INSERT INTO "public"."SC" VALUES ('04', '03', 20.0);
INSERT INTO "public"."SC" VALUES ('05', '01', 76.0);
INSERT INTO "public"."SC" VALUES ('05', '02', 87.0);
INSERT INTO "public"."SC" VALUES ('06', '01', 31.0);
INSERT INTO "public"."SC" VALUES ('06', '03', 34.0);
INSERT INTO "public"."SC" VALUES ('07', '02', 89.0);
INSERT INTO "public"."SC" VALUES ('07', '03', 98.0);

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS "public"."Student";
CREATE TABLE "public"."Student" (
  "sid" varchar(10) COLLATE "pg_catalog"."default",
  "sname" varchar(10) COLLATE "pg_catalog"."default",
  "sage" timestamp(6),
  "ssex" varchar(10) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of Student
-- ----------------------------
INSERT INTO "public"."Student" VALUES ('01', '赵雷', '1990-01-01 00:00:00', '男');
INSERT INTO "public"."Student" VALUES ('02', '钱电', '1990-12-21 00:00:00', '男');
INSERT INTO "public"."Student" VALUES ('03', '孙风', '1990-05-20 00:00:00', '男');
INSERT INTO "public"."Student" VALUES ('04', '李云', '1990-08-06 00:00:00', '男');
INSERT INTO "public"."Student" VALUES ('05', '周梅', '1991-12-01 00:00:00', '女');
INSERT INTO "public"."Student" VALUES ('06', '吴兰', '1992-03-01 00:00:00', '女');
INSERT INTO "public"."Student" VALUES ('07', '郑竹', '1989-07-01 00:00:00', '女');
INSERT INTO "public"."Student" VALUES ('08', '王菊', '1990-01-20 00:00:00', '女');

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS "public"."Teacher";
CREATE TABLE "public"."Teacher" (
  "tid" varchar(10) COLLATE "pg_catalog"."default",
  "tname" varchar(10) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO "public"."Teacher" VALUES ('01', '张三');
INSERT INTO "public"."Teacher" VALUES ('02', '李四');
INSERT INTO "public"."Teacher" VALUES ('03', '王五');

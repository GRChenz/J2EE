/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : j2ee

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 29/02/2024 18:40:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件类型',
  `size` bigint(20) NULL DEFAULT NULL COMMENT '文件大小(kb)',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '下载链接',
  `md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件md5',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `enable` tinyint(1) NULL DEFAULT 1 COMMENT '是否禁用链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES (1, NULL, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `sys_file` VALUES (23, '20210103.pdf', 'pdf', 37, 'http://localhost:9090/file/be0022c2f6aa4bf38450a0934d73c660.pdf', 'f95c47bd2f696f9a2b8219ec7504f0dd', 1, 1);
INSERT INTO `sys_file` VALUES (24, 'logo.jpg', 'jpg', 9, 'http://localhost:9090/file/861d8e8996894d0da4dc8ab000a7b36d.jpg', 'c6a1dbe5bd83c55398b4e69588026dea', 1, 1);
INSERT INTO `sys_file` VALUES (25, '2023612114450.bmp', 'bmp', 577, 'http://localhost:9090/file/d0fbf8d64f654fdab12394f77532c9d6.bmp', '5ef352966736f8496a3589d20c80958d', 1, 1);
INSERT INTO `sys_file` VALUES (26, '2023612114450.bmp', 'bmp', 577, 'http://localhost:9090/file/d0fbf8d64f654fdab12394f77532c9d6.bmp', '5ef352966736f8496a3589d20c80958d', 1, 1);
INSERT INTO `sys_file` VALUES (27, '2023612114450.jpg', 'jpg', 577, 'http://localhost:9090/file/d0fbf8d64f654fdab12394f77532c9d6.bmp', '5ef352966736f8496a3589d20c80958d', 1, 1);
INSERT INTO `sys_file` VALUES (28, '2023612114450.jpg', 'jpg', 577, 'http://localhost:9090/file/d0fbf8d64f654fdab12394f77532c9d6.bmp', '5ef352966736f8496a3589d20c80958d', 1, 1);
INSERT INTO `sys_file` VALUES (29, '2023612114450.jpg', 'jpg', 577, 'http://localhost:9090/file/d0fbf8d64f654fdab12394f77532c9d6.bmp', '5ef352966736f8496a3589d20c80958d', 1, 1);
INSERT INTO `sys_file` VALUES (30, 'Cache_c888134ea4c173b..jpg', 'jpg', 133, 'http://localhost:9090/file/62fe70c83bfe4b09a5eff0e75ddf6ca7.jpg', '405de626a7eaa3a185a877698a846c54', 1, 1);
INSERT INTO `sys_file` VALUES (31, 'white.webp', 'webp', 1, 'http://localhost:9090/file/09c43a1dd82f4982b85f64ae7310a471.webp', '1fd0965cd808daeb5d8d8a015609f6cf', 1, 1);
INSERT INTO `sys_file` VALUES (32, 'Cache_c888134ea4c173b..jpg', 'jpg', 133, 'http://localhost:9090/file/62fe70c83bfe4b09a5eff0e75ddf6ca7.jpg', '405de626a7eaa3a185a877698a846c54', 0, 1);
INSERT INTO `sys_file` VALUES (33, 'f1471c462272e45a6c13fb3e8c1814dffd546f04.jpg', 'jpg', 775, 'http://localhost:9090/file/156d761736a24de99fa955f1626f7dcd.jpg', '7d810737c6bee2ee90dd1293d9763f7a', 1, 1);
INSERT INTO `sys_file` VALUES (34, '1.jpg', 'jpg', 98, 'http://localhost:9090/file/5946b4eccd7d4e4bb89999eeaa13998d.jpg', '805fbdd27c136ec6a573992158cf0db7', 1, 1);
INSERT INTO `sys_file` VALUES (35, '1.jpg', 'jpg', 98, 'http://localhost:9090/file/5946b4eccd7d4e4bb89999eeaa13998d.jpg', '805fbdd27c136ec6a573992158cf0db7', 1, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `avatarurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '熊', '123456', '管理员', '2023-06-10 20:07:37', 'http://localhost:9090/file/d0fbf8d64f654fdab12394f77532c9d6.bmp');
INSERT INTO `sys_user` VALUES (2, '付', '123456', '付总', '2023-06-10 16:26:08', '0');
INSERT INTO `sys_user` VALUES (3, '胡', '123456', '胡总', '2023-06-10 16:26:10', '0');
INSERT INTO `sys_user` VALUES (4, '肖', '123456', '肖总', '2023-06-10 20:48:34', NULL);
INSERT INTO `sys_user` VALUES (5, '刘', '123456', '刘总', '2023-06-10 20:48:42', NULL);
INSERT INTO `sys_user` VALUES (6, '郭', '1234567', '郭总', '2023-06-10 20:48:52', NULL);

-- ----------------------------
-- Table structure for t_dataprocessing
-- ----------------------------
DROP TABLE IF EXISTS `t_dataprocessing`;
CREATE TABLE `t_dataprocessing`  (
  `rid` int(20) UNSIGNED NOT NULL COMMENT '教室ID',
  `address` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `electricalconsume` int(40) NULL DEFAULT NULL COMMENT '总电能消耗量',
  `correcttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `datadif` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前日期与月初相差的天数',
  `classnum` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '教室号',
  `comnum` int(20) NULL DEFAULT NULL COMMENT '电脑设备数量',
  `lignum` int(20) NULL DEFAULT NULL COMMENT 'LED设备数量',
  `fannum` int(20) NULL DEFAULT NULL COMMENT '风扇设备数量',
  `airnum` int(20) NULL DEFAULT NULL COMMENT '空调设备数量',
  PRIMARY KEY (`rid`) USING BTREE,
  INDEX `rid`(`rid`, `address`, `electricalconsume`, `correcttime`, `datadif`, `classnum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dataprocessing
-- ----------------------------
INSERT INTO `t_dataprocessing` VALUES (20103, 'B栋一层103室', 530, '2023-06-07 18:06:45', '7', 'B103', 1, 8, 6, 2);
INSERT INTO `t_dataprocessing` VALUES (40101, 'D栋一层101室', 2810, '2023-06-09 18:25:07', '5', 'D101', 45, 12, 6, 2);
INSERT INTO `t_dataprocessing` VALUES (50101, 'E栋一层101室', 610, '2023-06-06 21:32:06', '6', 'E101', 1, 12, 6, 2);
INSERT INTO `t_dataprocessing` VALUES (50102, 'E栋一层102室', 610, '2023-06-07 13:09:06', '7', 'E102', 1, 12, 6, 2);
INSERT INTO `t_dataprocessing` VALUES (50103, 'E栋一层103室', 610, '2023-06-07 13:09:42', '8', 'E103', 1, 12, 6, 2);
INSERT INTO `t_dataprocessing` VALUES (50104, 'E栋一层104室', 610, '2023-06-07 13:09:53', '9', 'E104', 1, 12, 6, 2);
INSERT INTO `t_dataprocessing` VALUES (50105, 'E栋一层105室', 610, '2023-06-07 13:10:10', '6', 'E105', 1, 12, 6, 2);
INSERT INTO `t_dataprocessing` VALUES (50106, 'E栋一层106室', 610, '2023-06-07 18:06:19', '4', 'E106', 1, 12, 6, 2);

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project`  (
  `pid` int(20) NOT NULL COMMENT '任务id',
  `project` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务',
  `paddress` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务地址',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务描述',
  `ptime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '任务发布时间',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES (1, '电器损坏', 'E层102室', 'E102投影仪损坏需更换', '2023-06-07 19:37:07');
INSERT INTO `t_project` VALUES (2, '电器损坏', 'E层103室', 'E103麦克风损坏需更换', '2023-06-07 19:40:27');

SET FOREIGN_KEY_CHECKS = 1;

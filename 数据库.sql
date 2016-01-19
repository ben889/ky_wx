/*
SQLyog Ultimate v8.4 
MySQL - 5.6.11 : Database - myframe
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `roles` */

CREATE TABLE `roles` (
  `roleid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `rolename` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述',
  `icon` varchar(200) DEFAULT NULL COMMENT '图标',
  `createdbyuserid` int(11) DEFAULT '0' COMMENT '创建者ID',
  `createdtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tabpermission` */

CREATE TABLE `tabpermission` (
  `tabpermissionid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '标签权限ID',
  `tabid` int(11) DEFAULT NULL COMMENT '标签ID',
  `permissionid` int(11) DEFAULT NULL COMMENT '权限ID',
  `allowAccess` tinyint(1) DEFAULT '1' COMMENT '允许访问:1允许,0不允许',
  `roleid` int(11) DEFAULT NULL COMMENT '角色ID',
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `createdbyuserid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `createdtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`tabpermissionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tabs` */

CREATE TABLE `tabs` (
  `tabid` int(10) unsigned NOT NULL COMMENT 'tab ID',
  `tabname` varchar(50) NOT NULL COMMENT 'tab名称',
  `taburl` varchar(200) DEFAULT NULL COMMENT '链接',
  `parentid` int(11) DEFAULT NULL COMMENT '父级ID',
  `level` int(11) DEFAULT NULL COMMENT '级别',
  `orderby` int(11) DEFAULT NULL COMMENT '排序',
  `icon` varchar(200) DEFAULT NULL COMMENT '图标',
  `display` tinyint(1) DEFAULT '1' COMMENT '显示:0不显示,1显示',
  `tabkey` varchar(30) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`tabid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `users` */

CREATE TABLE `users` (
  `userid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(80) NOT NULL COMMENT '用户名',
  `password` varchar(80) NOT NULL COMMENT '密码',
  `displayname` varchar(80) DEFAULT NULL COMMENT '显示名称',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) DEFAULT '0' COMMENT '状态:0默认',
  `usertype` varchar(32) DEFAULT '2' COMMENT '用户类型:0超级管理员,1系统管理员,普通用户',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除:0默认,1删除',
  `locked` tinyint(1) DEFAULT '0' COMMENT '锁定:0默认,1锁定',
  `createuserid` int(11) DEFAULT '0' COMMENT '创建人ID',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述',
  `lasttime` datetime DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

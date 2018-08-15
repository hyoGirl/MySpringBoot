/*
SQLyog Ultimate v8.32 
MySQL - 5.5.21 : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis`;

/*Table structure for table `datasource` */

DROP TABLE IF EXISTS `datasource`;

CREATE TABLE `datasource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `databasename` varchar(100) DEFAULT NULL COMMENT '数据库标志',
  `url` varchar(300) DEFAULT NULL COMMENT 'url',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `driverClassName` varchar(200) DEFAULT NULL COMMENT '驱动',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `datasource` */

LOCK TABLES `datasource` WRITE;

insert  into `datasource`(`id`,`databasename`,`url`,`username`,`password`,`driverClassName`) values (12,'datauser','jdbc:mysql://127.0.0.1:3306/datauser?characterEncoding=utf8&serverTimezone=UTC&useSSL=true','root','root','com.mysql.jdbc.Driver'),(13,'databook','jdbc:mysql://127.0.0.1:3306/databook?characterEncoding=utf8&serverTimezone=UTC&useSSL=true','root','root','com.mysql.jdbc.Driver'),(14,'chunjieboot','jdbc:mysql://127.0.0.1:3306/chunjieboot?characterEncoding=utf8&serverTimezone=UTC&useSSL=true','root','root','com.mysql.jdbc.Driver');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.12 : Database - compass
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`compass` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `compass`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values (1,'手机'),(2,'Java'),(3,'maven'),(4,'Oracle'),(5,'Android'),(6,'图书');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `descption` varchar(20) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED8DCCEFC1122627` (`category_id`),
  CONSTRAINT `FKED8DCCEFC1122627` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`price`,`descption`,`category_id`) values (1,'maven实战',88,'maven实战',3),(2,'JavaSwing开发指南',88,'JavaSwing开发指南',2),(3,'Oracle10g开发指南',108,'Oracle10g开发指南',4),(5,'Iphone4',1000,'Iphone4',1),(12,'maven权威指南',68,'maven权威指南',3),(13,'Oracle9i',108,'Oracle9i',4),(14,'Android应用揭秘',89,'Android应用揭秘',5),(15,'Oracle专家权威指南',108,'Oracle专家权威指南',4),(17,'摩托罗拉手机',108,'摩托罗拉手机L7',1),(18,'Junit in Action',102,'Junit in Action',2),(19,'平凡是世界',102,'路遥',6),(20,'人生',102,'贾平凹',6),(21,'西游记',102,'吴承恩',6),(22,'书剑恩仇录',102,'金庸',6),(23,'笑傲江湖',108,'金庸',6),(24,'萧十一郎',78,'金庸',6),(26,'射雕英雄传',78,'金庸',6),(27,'云计算',77,'冯靖',2),(28,'Pro git',88,'git',6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

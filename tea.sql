/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 5.7.41 : Database - tea
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tea` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `tea`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帳號',
  `password` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密碼',
  `sex` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '性別',
  `tel` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '電話',
  `email` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `userState` int(11) NOT NULL DEFAULT '1',
  `userType` int(11) NOT NULL DEFAULT '1',
  `uid01` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `uid02` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '創建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `member` */

insert  into `member`(`id`,`username`,`password`,`sex`,`tel`,`email`,`userState`,`userType`,`uid01`,`uid02`,`created_time`) values 
(1,'admin','25d55ad283aa400af464c76d713c07ad','男','0000000000','xxxxxx@gmail',1,100,'050dc2d7-68d5-4618-9848-00908436bf92','eefadebc-59d5-4ff8-ad87-c1fc03446bbc','2023-05-15 23:42:30'),
(16,'owner01','25d55ad283aa400af464c76d713c07ad','女','0988787883','sdfsdf5fsd@gmail.com',0,1,'69d7957b-63aa-4a61-82db-adf8abaf3519','f3341a53-b829-42c0-a2d9-f7e4dd9d5f21','2023-05-24 23:24:04'),
(17,'owner02','25d55ad283aa400af464c76d713c07ad','女','0998789787','56f4s56ds4fsdf@gmail.com',1,1,'','','2023-05-25 21:10:09');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `orderNo` bigint(11) NOT NULL,
  `name` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '品名',
  `price` int(11) DEFAULT NULL COMMENT '價格',
  `num` int(11) NOT NULL COMMENT '數量',
  `points` int(11) NOT NULL DEFAULT '5' COMMENT '紅利點數',
  `sweet` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '甜度',
  `temp` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '溫度',
  `size` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '容量(大中小)',
  `totalPrice` int(11) DEFAULT NULL COMMENT '小計',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '創建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `order` */

insert  into `order`(`id`,`userId`,`orderNo`,`name`,`price`,`num`,`points`,`sweet`,`temp`,`size`,`totalPrice`,`created_time`) values 
(12,1,1685099742250,'青檸香茶',50,1,5,'半糖','少冰','XL',50,'2023-05-26 19:15:50'),
(14,1,1685099748626,'原片初露青茶',50,1,5,'半糖','少冰','XL',50,'2023-05-26 19:15:50');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '品名',
  `img` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '圖片',
  `information` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '產品介紹',
  `price` int(11) NOT NULL COMMENT '價格',
  `point` int(11) NOT NULL DEFAULT '5' COMMENT '紅利點數',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '創建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`img`,`information`,`price`,`point`,`created_time`) values 
(1,'冰糖洛神梅','photo/drink.jpg','good',25,5,'2023-02-02 01:51:08'),
(2,'養樂多綠','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(3,'冬瓜青茶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:08'),
(4,'冬瓜檸檬　','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(5,'白甘蔗青茶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:08'),
(6,'香柚綠茶　','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(7,'青檸香茶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:08'),
(8,'冬瓜麥茶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(9,'冰萃檸檬　','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(10,'蜂蜜檸檬晶凍','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(11,'原鄉冬瓜茶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(12,'焙香決明大麥','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(13,'琥珀高峰烏龍','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(14,'原片初露青茶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(15,'娜杯紅茶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(16,'伯爵紅茶拿鐵','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(17,'娜杯紅茶拿鐵','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(18,'琥珀烏龍拿鐵','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(19,'焙香大麥拿鐵','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(20,'伯爵可可拿鐵','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(21,'蜂蜜麥茶拿鐵','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(22,'大正紅茶拿鐵','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(23,'茉香綠茶拿鐵','photo/drink.jpg','好喝',55,5,'2023-02-02 01:51:11'),
(24,'珍珠鮮奶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(25,'嫩仙草凍奶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(26,'法芙娜純可可鮮奶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(27,'芋頭鮮奶','photo/drink.jpg','好喝',60,5,'2023-02-02 01:51:11'),
(28,'手炒黑糖鮮奶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(29,'小資生活鮮奶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(30,'鮮奶可可','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11'),
(31,'黑糖珍珠鮮奶','photo/drink.jpg','好喝',50,5,'2023-02-02 01:51:11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

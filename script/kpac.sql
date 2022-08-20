/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.29 : Database - kpac_dev
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kpac_dev` /*!40100 DEFAULT CHARACTER SET utf16 COLLATE utf16_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `kpac_dev`;

/*Table structure for table `knowledgepackage` */

DROP TABLE IF EXISTS `knowledgepackage`;

CREATE TABLE `knowledgepackage` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(250) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `creationDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `knowledgepackageset` */

DROP TABLE IF EXISTS `knowledgepackageset`;

CREATE TABLE `knowledgepackageset` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `knowledge_package_with_set` */

DROP TABLE IF EXISTS `knowledge_package_with_set`;

CREATE TABLE `knowledge_package_with_set` (
                                              `know_package_setid` bigint NOT NULL,
                                              `know_package_id` bigint NOT NULL,
                                              PRIMARY KEY (`know_package_setid`,`know_package_id`),
                                              KEY `knowledge_package_with_set_key` (`know_package_id`),
                                              CONSTRAINT `know_package_id_fk` FOREIGN KEY (`know_package_id`) REFERENCES `knowledgepackage` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                              CONSTRAINT `know_package_setid_fk` FOREIGN KEY (`know_package_setid`) REFERENCES `knowledgepackageset` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

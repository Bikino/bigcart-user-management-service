-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: db_bigcart_admin
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'2020-11-05 17:19:04.124000','oabdeltwab@miu.edu','Omar','Abdeltwab',NULL,2),(2,'2020-11-05 17:19:06.563000','fozbudak@miu.edu','Furkan','Ozbudak',NULL,0),(3,'2020-11-05 17:19:08.139000','mghatas@miu.edu','Mark','Ghatas',NULL,0),(4,'2020-11-05 17:19:09.779000','MAbdelzaher@miu.edu','Mohamed','Abdelzaher',NULL,2),(5,'2020-11-05 17:19:11.730000','ymar@miu.edu','Youssoupha','Mar',NULL,0),(6,'2020-11-05 17:19:13.336000','MFarahat@miu.edu','Mohamed','Farahat',NULL,2),(7,'2020-11-05 17:19:15.005000','DuongNguyen@miu.edu','Duong','Nguyen',NULL,2);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `buyer`
--

LOCK TABLES `buyer` WRITE;
/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
INSERT INTO `buyer` VALUES (NULL,'$2a$10$oxzVRzMJje4Wr8E5miQXXuWJmnGXePvTg/olv5vz00.Re/Twj8tne','mfarahat',6),(NULL,'$2a$10$HcvWj/8g0Z/.JqirnsrnhuGZxnhI4k75NSHZcs0fVUKGLxsCyCvrW','dnguyen',7);
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (_binary '','$2a$10$3uvRxroS2H8FGsqDeQmmMOfiPn0J8JpWTWGOmfhn8Yv2RSNBDWFm6',NULL,5000,'messam',4),(_binary '\0','$2a$10$ZajB431oPkNNJ7JjeoaD3OZyYa1x/jXDh29/OfLEjulBJ4hN3/os.',NULL,10000,'youss',5);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `guest`
--

LOCK TABLES `guest` WRITE;
/*!40000 ALTER TABLE `guest` DISABLE KEYS */;
/*!40000 ALTER TABLE `guest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8),(8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (25000,NULL,'$2a$10$KXhT05/C.HYrJ311zhWxGuvdaYG/UP4UIvzx.ARcnL6BBhyEza3NK',NULL,'omar',1),(NULL,NULL,'$2a$10$87yigKRit0HmjqNYDsOMjeRpd04A0V20Q2dWieDkcaWJT9AcftOBy',NULL,'furk',2),(NULL,NULL,'$2a$10$BgS.9HRL/c56Y1fYqh9WquNqa/1t3TAKlET2NDyENCygCYaTOecgO',NULL,'mrk',3);
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-05 12:25:48

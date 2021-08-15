CREATE DATABASE  IF NOT EXISTS `lesson_six` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lesson_six`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: lesson_six
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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id_orders` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `product_version` int NOT NULL,
  `person_id` int NOT NULL,
  PRIMARY KEY (`id_orders`),
  KEY `fk_orders_persons_idx` (`person_id`),
  KEY `fk_orders_product_id_idx` (`product_id`,`product_version`),
  CONSTRAINT `fk_orders_persons` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id_persons`),
  CONSTRAINT `fk_orders_product` FOREIGN KEY (`product_id`, `product_version`) REFERENCES `products` (`id_products`, `product_version`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,1,4),(2,1,1,6),(3,1,2,4),(4,1,2,5),(6,2,1,5),(7,2,1,8),(8,3,1,8),(9,3,1,7),(10,3,1,4),(11,4,1,6),(12,4,2,6),(13,4,2,8),(14,4,2,5),(15,5,1,4),(16,5,1,5),(17,5,2,4),(18,5,2,6),(19,5,3,6),(25,1,3,6),(26,1,3,7),(27,1,3,4),(28,1,3,5);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `id_persons` int NOT NULL AUTO_INCREMENT,
  `person_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `person_mail` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_persons`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (4,'Joey','joey@mail.ru'),(5,'Ross','ross@mail.ru'),(6,'Chandler','chandler@mail.ru'),(7,'Raichel','raichel@mail.ru'),(8,'Monica','monica@mail.ru'),(9,'Phoebe','phoebe@mail.ru');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id_products` int NOT NULL,
  `product_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `product_price` decimal(6,2) NOT NULL,
  `product_version` int NOT NULL,
  PRIMARY KEY (`id_products`,`product_version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Banana',10.20,1),(1,'Banana',11.50,2),(1,'Banana',10.90,3),(2,'Apple',8.10,1),(3,'Cheese ',20.20,1),(4,'Bread',5.50,1),(4,'Bread',6.00,2),(5,'Steak',18.80,1),(5,'Steak',17.20,2),(5,'Steak',16.50,3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'lesson_six'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-09 21:15:02

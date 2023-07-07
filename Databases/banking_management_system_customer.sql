-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: banking_management_system
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cusID` int NOT NULL AUTO_INCREMENT,
  `AccNumber` int DEFAULT NULL,
  `AccName` varchar(255) DEFAULT NULL,
  `AccType` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `MaritalStatus` varchar(45) DEFAULT NULL,
  `Occupation` varchar(45) DEFAULT NULL,
  `NomineeName` varchar(255) DEFAULT NULL,
  `NomineeRelation` varchar(45) DEFAULT NULL,
  `Branch` varchar(45) DEFAULT NULL,
  `DateOfBirth` varchar(30) DEFAULT NULL,
  `placeBirth` varchar(45) DEFAULT NULL,
  `Qualification` varchar(45) DEFAULT NULL,
  `aadharCard` varchar(45) DEFAULT NULL,
  `pancard` varchar(45) DEFAULT NULL,
  `emailID` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `alterMobile` varchar(45) DEFAULT NULL,
  `Room/Block` varchar(50) DEFAULT NULL,
  `Apartment/Area` varchar(45) DEFAULT NULL,
  `Landmark` varchar(55) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `Pincode` int DEFAULT NULL,
  `State` varchar(45) DEFAULT NULL,
  `Nationality` varchar(45) DEFAULT NULL,
  `DateOfJoining` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cusID`),
  UNIQUE KEY `AccNumber_UNIQUE` (`AccNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1008,86009444,'Smriti D Singh','SAVING','Female',24,'Single','Service','Nikhilesh D Singh','Brother','Majiwada','16/12/2021','','POST GRADUATION','4231 4234 2421','AUX1919OI','ssmritisingh66@gmail.com','9320202892','80801323213','A/902 Urvi Park','Opp Oswal Park','Pokhran rd no 2','Thane',400610,'Maharashtra','INDIAN','04/12/2021');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 17:54:41

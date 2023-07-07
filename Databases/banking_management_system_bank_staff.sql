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
-- Table structure for table `bank_staff`
--

DROP TABLE IF EXISTS `bank_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_staff` (
  `staff_id` int NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(1000) DEFAULT NULL,
  `staff_gender` varchar(45) NOT NULL,
  `staff_date_of_birth` varchar(45) NOT NULL,
  `staff_department` varchar(45) NOT NULL,
  `staff_designation` varchar(45) NOT NULL,
  `staff_branch` varchar(45) NOT NULL,
  `staff_state` varchar(45) NOT NULL,
  `staff_zipcode` varchar(45) NOT NULL,
  `staff_mobile` varchar(45) NOT NULL,
  `staff_qualification` varchar(45) NOT NULL,
  `staff_email` varchar(45) NOT NULL,
  `staff_pan_card` varchar(45) NOT NULL,
  `staff_aadhar_card` varchar(45) NOT NULL,
  `staff_username` varchar(45) NOT NULL,
  `staff_password` varchar(45) NOT NULL,
  `staff_date_of_joining` varchar(45) NOT NULL,
  PRIMARY KEY (`staff_id`),
  UNIQUE KEY `staff_email_UNIQUE` (`staff_email`),
  UNIQUE KEY `staff_pan_card_UNIQUE` (`staff_pan_card`),
  UNIQUE KEY `staff_aadhar_card_UNIQUE` (`staff_aadhar_card`),
  UNIQUE KEY `staff_username_UNIQUE` (`staff_username`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_staff`
--

LOCK TABLES `bank_staff` WRITE;
/*!40000 ALTER TABLE `bank_staff` DISABLE KEYS */;
INSERT INTO `bank_staff` VALUES (114,'Nikhil D Singh','Male','15-Nov-2000','Staff','Management','Thane','Maharashtra','400610','8080171039','Post Graduation','nikhilsingh0745@gmail.com','AMUW7652LK','0983 3450 8762','Nikhil0715','Nikhil15','22-Oct-2021'),(118,'Smriti D Singh','Female','17-Dec-1997','Staff','Tech Support','Majiwada','Mahararashtra','400610','9230348123','Post Graduation','ssmritisingh66@gmail.com','AJG01831UO','4234 6873 4124','Smriti0210','Smriti12','04-Dec-2021');
/*!40000 ALTER TABLE `bank_staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 17:54:44

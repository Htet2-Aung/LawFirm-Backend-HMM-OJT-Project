CREATE DATABASE  IF NOT EXISTS `mylawfirm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mylawfirm`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mylawfirm
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `court`
--

DROP TABLE IF EXISTS `court`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `court` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `court_name` varchar(255) DEFAULT NULL,
  `township` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `court`
--

LOCK TABLES `court` WRITE;
/*!40000 ALTER TABLE `court` DISABLE KEYS */;
INSERT INTO `court` VALUES (1,'မဟာဗန္ဓုလပန်းခြံလမ်း',' ရန်ကုန်','ရန်ကုန်တိုင်းဒေသကြီးတရားလွှတ်တော်','ကျောက်တံတားမြို့နယ်'),(2,'မင်းနန္ဒာလမ်း၊ ဘားမားအေးရပ်ကွက်','ရန်ကုန်','ရန်ကုန်အရှေ့ပိုင်းခရိုင်တရားရုံး','ဒေါပုံ'),(3,'၃၀လမ်း၊ ၆၈လမ်း နှင့် ၇၀လမ်း ကြား၊ ရုံးကြီး အတွင်း၊ ပတ်ကုန်းပျော်ဘွယ်၊','မန္တလေး','မန္တလေးတိုင်းဒေသကြီး တရားရုံး','ချမ်းအေးသာစံမြို့နယ်'),(4,'၆၅လမ်း၊ ၃၄လမ်း နှင့် ၃၅လမ်း ကြား၊ ပြည်ကြီးမျက်ရှင်','မန္တလေး','မန္တလေးခရိုင်တရားရုံးချုပ်','ချမ်းအေးသာစံမြို့နယ်'),(5,'သာယာဝတီ မင်းကြီးလမ်း၊ အမှတ် ၆၀ နှင့် ၆၁ ကြား',' မန္တလေး','ပြည်ကြီးတံခွန်မြို့နယ် တရားရုံး','ပြည်ကြီးတံခွန်မြို့နယ်'),(6,'Address1','Mdy','Court Name 1','Township1');
/*!40000 ALTER TABLE `court` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-19 17:05:15

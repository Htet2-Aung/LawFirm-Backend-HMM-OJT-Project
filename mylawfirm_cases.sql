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
-- Table structure for table `cases`
--

DROP TABLE IF EXISTS `cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cases` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `atten_court_room` int NOT NULL,
  `case_status` varchar(255) DEFAULT NULL,
  `case_title` varchar(255) DEFAULT NULL,
  `description` text,
  `end_date` date DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `lawyer_name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `contract_id` bigint DEFAULT NULL,
  `court_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtneklsnpcutbqyc0cqadg0ft7` (`category_id`),
  KEY `FKbm7n6v74rf9gxlk3f2cdv9v03` (`contract_id`),
  KEY `FKh1wk1sp203goasyqyg2iw8goy` (`court_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cases`
--

LOCK TABLES `cases` WRITE;
/*!40000 ALTER TABLE `cases` DISABLE KEYS */;
INSERT INTO `cases` VALUES (1,1,'Current','နိုင်ငံခြားပညာတော်သင်','နိုင်ငံခြားပညာတော်သင်သွားရာတွင် လေဆိပ်မှ ပိတ်ပင်ခြင်းပြုလုပ်ခဲ့သော လေဆိပ်ဝန်ထမ်းများကို တရားဆွဲဆိုမှု ပြုလုပ်ခြင်းဖြစ်ပါသည်။\n၂၃-၃-၂၀၂၃ ရက်နေ့တွင် ပထမအကြိမ် ရုံးချိန်းတက်ရောက် ခဲ့ပါသည်။  တရားပြိုင်ဘက်မှ ရှေ့နေမှ ဦးစွာ တရားစွဲဆိုမှုနှင့် ပတ်သက်၍ ဦးတိုက်လျှောက်ထားမှုများ ပြုလုပ်ခဲ့ပြီး ၂၉-၄-၂၀၂၃ရက်နေ့ကို ထပ်မံရုံးချိန်းရက် သတ်မှတ်ခဲ့ပါသည်။\n',NULL,NULL,'choLaw@gmail.com','2023-03-23','09:57:00','pan@gmail.com',4,1,5),(2,1,'Current',' Online လုပ်ငန်းနာမည် ဆင်တူယိုးမှားဖြစ်ခြင်း','ပထဆုံး လုပ်ငန်းလိုင်စဉ် အတည်ပြုရန် ရန်ကုန်အရှေ့ပိုင်း ခရိုင်ရုံးသို. နေ.လည် ၁၂နာရီ အရောက်သွားရောက်ခဲ့ပါသည်။',NULL,NULL,'myatLaw@gmail.com','2023-03-20','12:24:00','user23@gmail.com',6,3,2),(3,1,'Current','Case title 1','case description................. owfnogn  fsgegee ',NULL,NULL,'minLaw@gmail.com','2023-03-17','12:42:00','htet@gmail.com',7,2,6);
/*!40000 ALTER TABLE `cases` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-19 17:05:16

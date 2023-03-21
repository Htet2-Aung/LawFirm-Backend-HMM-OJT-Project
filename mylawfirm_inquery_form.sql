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
-- Table structure for table `inquery_form`
--

DROP TABLE IF EXISTS `inquery_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquery_form` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `appointment_status` varchar(255) DEFAULT NULL,
  `description` text,
  `lawyer_name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcv9g9omwo34gx7yvpgakowu6t` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquery_form`
--

LOCK TABLES `inquery_form` WRITE;
/*!40000 ALTER TABLE `inquery_form` DISABLE KEYS */;
INSERT INTO `inquery_form` VALUES (1,'CREATED','ပညာရေးအာမခံနှင့် ပတ်သက်သောအကြောင်းအရာများကို ဆွေးနွေးချင်ပါတယ်။','choLaw@gmail.com','09969610229','pan@gmail.com',8),(2,'CREATED','ယခုလက်ရှိလုပ်ကိုင်နေသော အထည်ချုပ်လုပ်ငန်း အသေးစားလုပ်ငန်းအား အထည်ချုပ်စက်ရုံအကြီးစားလုပ်ငန်းအဖြစ်ပြောင်းလဲ လုပ်ကိုင်လိုပါသည်။ ထိုအကြောင်းအရာနှင့်ပတ်သက်၍ ရှေ့နေနှင့် တိုင်ပင်ဆွေးနွေးဌားရမ်းလိုပါသည်။','minLaw@gmail.com','09989877165','htet@gmail.com',9),(3,'NO_CREATE','For cyber','myatLaw@gmail.com','09969610229','pan@gmail.com',8),(4,'CREATED','လက်ရှိတွင် online တရားဝင်မှတ်ပုံတင်ပြီး ရောင်းချထားသော ကျွန်မတို၏ ရွှေပလောင် ခေါက်ဆွဲအား တခြားသော လုပ်ငန်းများမှ နာမည် ဆင်တူယိုးမှားဖြစ်သော ပလောင်ကြီး ခေါက်ဆွဲ အမည်ဖြင့် ထုတ်လုပ်ရောင်းချနေမှုနှင့် ပတ်သက်ပြီး ဖြေရှင်းချင်ပါသည်။ ကျွမ်းကျင်ရှေ့နေနှင့် ဆွေးနွေးပြောဆို အကြံဉာဏ်ရချင်ပါသည်။\n','myatLaw@gmail.com','09-123456789225','user23@gmail.com',12);
/*!40000 ALTER TABLE `inquery_form` ENABLE KEYS */;
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

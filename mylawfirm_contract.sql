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
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `case_created` varchar(255) DEFAULT NULL,
  `con_description` text,
  `contract_date` date DEFAULT NULL,
  `lawyer_name` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `appointment_id` bigint DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  `payment_id` bigint DEFAULT NULL,
  `lawyer_landing_fees` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjdjg4yao98ct18b7ifnapfe9e` (`appointment_id`),
  KEY `FK7oed42b5ny5bf0guyns5tv28u` (`case_id`),
  KEY `FK7cvb5qyribwre9sdruy102qee` (`payment_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'CREATED','နိုင်ငံခြားပညာတော်သင်နှင့်ပတ်သက်၍ဥပဒေပိုင်းဆိုင်ရာများကို မချိုချိုသော်မှ ကိုပန်သုကျော်အား ဝန်ဆောင်မှုပေးရန် အပြီးအစီးစာချုပ်ချုပ်ဆိုခြင်း။','2023-03-19','choLaw@gmail.com','CREATED','pan@gmail.com',1,1,1,1100000),(2,'CREATED','အထည်ချုပ်လုပ်ငန်း အသေးစားလုပ်ငန်းအား အထည်ချုပ်စက်ရုံအကြီးစားလုပ်ငန်းအဖြစ်ပြောင်းလဲ လုပ်ကိုင်လိုပါသည်။ ထိုအကြောင်းအရာနှင့်ပတ်သက်၍ ရှေ့နေနှင့် တိုင်ပင်ဆွေးနွေးဌားရမ်းပြီးဖြစ်ပါသည်။ ရှေ.နေဌားရမ်းခ ၁၄သိန်း (စာဖြင့် တစ်ဆယ့်လေးသိန်းကျပ်တိတိ) ဖြင့် စာချုပ်ချုပ်ဆိုပါသည်။ \nupdate update ','2023-03-20','minLaw@gmail.com','NO_CREATE','htet@gmail.com',2,3,NULL,1800000),(3,'CREATED','လက်ရှိတွင် တရားဝင်မှတ်ပုံတင်ပြီး ရောင်းချထားသော ကျွန်မတို့၏ ရွှေပလောင် ခေါက်ဆွဲအား တခြားသော လုပ်ငန်းများမှ နာမည် ဆင်တူယိုးမှားဖြစ်သော ပလောင်ကြီး ခေါက်ဆွဲ အမည်ဖြင့် ထုတ်လုပ်ရောင်းချနေမှုနှင့် ပတ်သက်ပြီး ဖြေရှင်းပေးပါမည်။ ကျွမ်းကျင်ရှေ့နေနှင့် ဆွေးနွေးပြောဆိုပြီး ရှေ့နေ အကြံဉာဏ်အတိုင်း ဆက်လက် လုပ်ဆောင်သွားမည် ဖြစ်ပါသည်။ ထိုအမှုကိစ္စအတွက် ရှေ့နေဝန်ဆောင်ခ ၃,၅၀၀,၀၀၀ ကျပ် (စာဖြင့် သုံးဆယ့်ငါးသိန်းကျပ်တိတိ)ဖြင့် သဘောတူ ဌားရမ်းပါမည်။','2023-03-31','myatLaw@gmail.com','CREATED','user23@gmail.com',3,2,2,3500000);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
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

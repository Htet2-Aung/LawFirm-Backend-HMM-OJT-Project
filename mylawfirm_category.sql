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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'စီးပွားရေးဥပဒေ','စီးပွားရေးရှေ့နေ—ကော်ပိုရိတ်ရှေ့နေ၊ ကော်ပိုရိတ်ရှေ့နေ သို့မဟုတ် စီးပွားရေးရှေ့နေ- သည် စီးပွားရေးပြဿနာများကို အာရုံစိုက်သည့် ဥပဒေပညာရှင်တစ်ဦးဖြစ်သည်။'),(2,'နိုင်ငံသားဥပဒေ','အရပ်ဘက်တရားစွဲဆိုမှုများတွင် ကိုယ်ရေးကိုယ်တာထိခိုက်မှု၊ စီးပွားရေးအငြင်းပွားမှုများ၊ မြေယာအပေးအယူများ၊ အသရေဖျက်ခြင်းနှင့် ဆဲဆိုခြင်း၊ နှင့် အခြားစီးပွားရေးဆိုင်ရာ အကျိုးစီးပွားများ ပါဝင်သည်။'),(3,'မိသားစုဥပဒေ','မိသားစုဥပဒေ၊ အိမ်ထောင်ရေးနှင့် ကွာရှင်းပြတ်စဲမှု၊ ကလေးဆက်ဆံမှုနှင့် စီးပွားရေးဆိုင်ရာ ကိစ္စများအပါအဝင် မိသားစုဆက်ဆံရေးကို ထိန်းညှိပေးသည့် ဥပဒေဖြစ်သည်။'),(4,'ပညာရေးဥပဒေ','ပညာရေးဥပဒေတွင် ဆင်းရဲနွမ်းပါးသော ကလေးများကို ကိုယ်စားပြုခြင်းမှ ပညာရေးဆိုင်ရာ အထူးပညာရေးဥပဒေအထိ ပညာရေးပြုပြင်ပြောင်းလဲမှုအထိ အမျိုးမျိုးသော ပြဿနာများစွာ ပါဝင်ပါသည်။'),(5,'ပြစ်မှုဆိုင်ရာဥပဒေ','ရာဇ၀တ်မှုဥပဒေသည် ပြစ်မှုကျူးလွန်သူများအား သက်ဆိုင်သည့်ဥပဒေများနှင့် သက်ဆိုင်သည့် ဥပဒေတစ်ရပ်ဖြစ်သည်။'),(6,'ဆိုက်ဘာဥပဒေ','ဆိုက်ဘာဥပဒေသည် အင်တာနက်နှင့် အင်တာနက်ဆိုင်ရာနည်းပညာများနှင့် သက်ဆိုင်သည့် မည်သည့်ဥပဒေဖြစ်ပြီး တရားရေးစနစ်၏ နောက်ဆုံးပေါ်နယ်ပယ်များထဲမှ တစ်ခုဖြစ်သည်။'),(7,'Properties Law','Law for Properties');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
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

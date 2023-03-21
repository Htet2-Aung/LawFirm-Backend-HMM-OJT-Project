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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `certificate` varchar(255) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `description` text,
  `field` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `license_expire_date` date DEFAULT NULL,
  `license_no` varchar(255) DEFAULT NULL,
  `nrc` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `statuss` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'$2a$10$xFtXLJ80I6q8zTH9YDTTdOosGU7IXD0t3NhXit6wReARRGTicfMwi',NULL,'Admin',NULL,'admin@gmail.com'),(10,'ဖြူရှင်းသန့်','Mandalay','Lumière Lyon III University, Master of Private Fundamental Law,\nLumière Lyon II University, Bachelor of Private Law,\nRoyal University of Laws and Economics, Bachelor of Law\n',700000,'လက်ရှိတွင် သူမသည် ကုန်အမှတ်တံဆိပ်တရားစွဲဆိုမှု၊ မူပိုင်ခွင့်များနှင့် ဖောက်သည်များကို ကိုယ်စားပြုခြင်းအတွက် အကန့်အသတ်မရှိ ကန့်သတ်ခြင်းအပါအဝင် ကုန်သွယ်မှုအမှတ်တံဆိပ်တရားစွဲဆိုမှုများနှင့် သက်ဆိုင်သည့် ဉာဏပစ္စည်းမူပိုင်ခွင့်ဆိုင်ရာကိစ္စရပ်များကိုလည်း ကိုင်တွယ်ဆောင်ရွက်လျက်ရှိသည်။','နိုင်ငံသားဥပဒေ','ဖြူရှင်း','FEMALE','https://bnglegal.com/wp-content/uploads/2023/03/Seakkeang-LIM.jpeg','သန့်','2029-11-17','M1270','9/...................','$2a$10$JARMzfaz1ahCmeEzS9t4iu53IZksGytKlCARt81BAZPHwIhOMEZfK','09989877412','Lawyer','FOLLOW_THE_CASE','phyuLaw@gmail.com'),(3,'မင်းဇော်ဟိန်း','Yangon','Master’s Degree in Commercial Law,\nBachelor’s Degree from Royal University of Law and Economic',800000,'သူသည် လုပ်ငန်းအမျိုးအစားအားလုံးကို ဖျက်သိမ်းခြင်းအထိ လုပ်ငန်းအမျိုးအစားအားလုံးကို သတ်မှတ်ခြင်းမှ ကော်ပိုရိတ်ကိစ္စရပ်များနှင့်သက်ဆိုင်သည့် ကျယ်ပြန့်သော တရားဝင်အလုပ်များတွင် အတွေ့အကြုံများရှိပြီး နိုင်ငံခြားဖောက်သည်များကို ပေါင်းစည်းခြင်းနှင့် ဝယ်ယူခြင်း၊ စီးပွားဖြစ်စာချုပ်များ၊ သက်ဆိုင်ရာလိုင်စင်များ၊ သတ္တုတူးဖော်ရေး၊ စွမ်းအင်၊ ကူးသန်းရောင်းဝယ်ရေး၊ ကွန်ဒိုမီနီယံ ဆောက်လုပ်ရေး ကုမ္ပဏီနှင့် အခြားကဏ္ဍများတွင် ရင်းနှီးမြှုပ်နှံမှု ကုမ္ပဏီများအား လုံ့လစိုက်ထုတ်ဆောင်ရွက်လျက်ရှိသည်။','စီးပွားရေးဥပဒေ','မင်းဇော်','MALE','https://bnglegal.com/wp-content/uploads/2018/12/Thavsothaly-TOK_F.jpg','ဟိန်း','2030-12-17','M1234','12/................','$2a$10$YlUBxTjHbwHnMl16VHaZBu3l1favSQipdhEVWtlpjmJu4ZUghz22G','09989877654','Lawyer','FOLLOW_THE_CASE','minLaw@gmail.com'),(5,'အောင်မျိုးကျော်','Mandalay',' Bachelor’s Degree in Law, Paññāsāstra University of Cambodia,\nMaster’s Degree, Burapha University, Thailand',8000000,' သူနှင့်သင့်ကွာရှင်းပြတ်စဲမှု၊ ကလေးထိန်းကျောင်းမှု သို့မဟုတ် အခြားမိသားစုဥပဒေပြဿနာကို ဖြေရှင်းရန် ကျွမ်းကျင်မှုနှင့် အတွေ့အကြုံရှိသောကြောင့် သင်သည် သင့်ဘဝ၏ ကဏ္ဍသစ်တစ်ခုသို့ ရှေ့ဆက်သွားနိုင်မည်ဖြစ်သည်။သူအကြောင်းပိုမိုလေ့လာရန်နှင့် သူကူညီနိုင်ပုံကို ယနေ့တိုင်ပင်ဆွေးနွေးရန် စီစဉ်ပါ။','မိသားစုဥပဒေ','အောင်မျိုး','MALE','https://bnglegal.com/wp-content/uploads/2022/10/Seyha-MEAK.jpg','ကျော်','2030-10-17','M4367','8/..........','$2a$10$Kl5pDy2aSjtgnaNodP8mluqXfhS0LrvxjbpSMNT395zns/svVDA5i','09985623115','Lawyer','FOLLOW_THE_CASE','aungLaw@gmail.com'),(6,'နေသူအောင်','Yangon',' JD University of Hawaii,\nMA University of San Diego,\nAB Georgetown University',600000,'သူသည် မှုခင်းအခင်းအကျင်းတစ်ခုစီတိုင်းကို တရားလိုရှေ့နေများအဖြစ် နှစ်ပေါင်းများစွာ အတွေ့အကြုံရှိသောကြောင့် ခိုင်လုံသောရာထူးမှ ချဉ်းကပ်သည်။ သူသည် ရာဇ၀တ်မှု ဖမ်းဆီးခံရပြီးနောက် လူတွေရဲ့ အသက်ကို တာဝန်ခံဖို့ ဘယ်လို ကူညီရမလဲဆိုတာ သိပါသည်။','ပြစ်မှုဆိုင်ရာဥပဒေ','နေသူ','MALE','https://bnglegal.com/wp-content/uploads/2022/07/Ruwan-Hulugalle.jpg','အောင်','2030-09-25','M9854','12/........','$2a$10$3E92mBhJV6zyDS8k3ja1WeDPHOocXnyA5XcOwgeR.Pjk6srrdpYya','09412534566','Lawyer','FOLLOW_THE_CASE','nayLaw@gmail.com'),(7,'ချိုချိုသော်','Shwe Bo',' Diploma of Business Administration,\nBachelor of Accounting from Latrobe University of Australia,\nTaxation course at CamEd Business School in Phnom Penh.',700000,'သူမသည် ပညာရေးဥပဒေနှင့် စည်းမျဉ်းစည်းကမ်းများနှင့်အညီ ပညာရေးအဖွဲ့အစည်းများအား လမ်းညွှန်မှုပေးသည်။ ကျောင်းသားများအား အရည်အသွေးရှိသော ပညာရေးကို ရရှိစေရန်နှင့် အထူးသဖြင့် ပညာရေးစနစ်၏ အဓိကအစိတ်အပိုင်းဖြစ်သော ကျောင်းသားများနှင့် ပညာရေးဆိုင်ရာ ကျွမ်းကျင်ပညာရှင်များအား တရားမျှတစွာနှင့် ဥပဒေနှင့်အညီ ဆက်ဆံကြောင်း သေချာစေပါသည်။','ပညာရေးဥပဒေ','ချိုချို','FEMALE','https://bnglegal.com/wp-content/uploads/2019/09/Nguyen-Thituyet_F.jpg','သော်','2030-02-21','M5778','5/........','$2a$10$iT4Pxdr0.BDyDZ4XTFEg.OhxaS6mNsMPdx4pJkZbpj27G2UTMPT.2','09945625400','Lawyer','FOLLOW_THE_CASE','choLaw@gmail.com'),(8,'ပန်သုကျော်','ချမ်းမြသာစည်၊မန္တလေး',NULL,NULL,NULL,NULL,'ပန်သု','MALE','https://lh4.googleusercontent.com/6pfOgWD5NJQSXnCYhGzY5taneayE46kGUBbCHKrjDFANELnhKEjHi0u948qLei40jWw=w2400','ကျော်',NULL,NULL,'9/.........','$2a$10$3FnIsQHJ412cackBW0bThONq10CRTqOpejrBe1B6X1u51gCKzh1jK','09969610229','User',NULL,'pan@gmail.com'),(9,'ထက်ထက်အောင်','ပြည်ကြီးတံခွန်၊မန္တလေး',NULL,NULL,NULL,NULL,'ထက်ထက်','FEMALE','https://lh3.googleusercontent.com/5CmNpz84qbyaNKELl2Bg1pZyPi2DLyeFkAzsYi9IGxv8ZnNlPnh-A_R0FTRwAAV-7VA=w2400','အောင်',NULL,NULL,'5/........','$2a$10$8Q5vojVdYkDmYcPS5i8Hou9YW.to/6gvd1PZNu5yqgDodLHa6YptW','09989877165','User',NULL,'htet@gmail.com'),(12,'Htet Htet','Mdy',NULL,NULL,NULL,NULL,'Htet Htet','FEMALE','https://lh3.googleusercontent.com/dTeDpYPeylaruISTF8LTlUeeidcFssfvxtLqW-VZRaIUuRCeuzepRfoMozLvz7fwp_8=w2400','Aung',NULL,NULL,'5/..............','$2a$10$yOC3NgY1XT.aS6xnPs43K.O1eA4.klfzhwjqOPwZIUr7ydMFKA38e','09-123456789225','User',NULL,'user23@gmail.com'),(13,'Ei Mon Aung','Mdy','LLB, Business IT , Diploma in English (MUFL)',150000,'expert in business and it. many experience in business law .','မိသားစု ဉပဒေ','Ei Mon','FEMALE','http://localhost:3000/static/media/about.4a57855e0211994f1f3f.jpg ','Aung','2023-03-24','MR00945','5/.......................','$2a$10$dK2j5NIsTFolfD90M26tZuR0mltG/vrlU52hin5hCpI2ubCxQRob6','09-5678456789','Lawyer','FOLLOW_THE_CASE','eimonaung@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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

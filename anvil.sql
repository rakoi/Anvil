-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: anvil
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.21.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(24) DEFAULT NULL,
  `acc` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'Cash','ch0012'),(2,'Revenue','RN001'),(3,'A/R','AR001');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anvil (1)`
--

DROP TABLE IF EXISTS `anvil (1)`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anvil (1)` (
  `C1` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anvil (1)`
--

LOCK TABLES `anvil (1)` WRITE;
/*!40000 ALTER TABLE `anvil (1)` DISABLE KEYS */;
INSERT INTO `anvil (1)` VALUES ('-- phpMyAdmin SQL Dump'),('-- version 4.6.4'),('-- https://www.phpmyadmin.net/'),('--'),('-- Host: 127.0.0.1'),('-- Generation Time: May 25, 2021 at 02:19 PM'),('-- Server version: 5.7.14'),('-- PHP Version: 5.6.25'),(NULL),('SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\";'),('SET time_zone = \"+00:00\";'),(NULL),(NULL),('/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;'),('/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;'),('/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;'),('/*!40101 SET NAMES utf8mb4 */;'),(NULL),('--'),('-- Database: `anvil`'),('--'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `client`'),('--'),(NULL),('CREATE TABLE `client` ('),('  `id` int(3) NOT NULL,'),('  `first_name` varchar(25) NOT NULL,'),('  `last_name` varchar(25) NOT NULL,'),('  `email` varchar(25) NOT NULL,'),('  `id_number` varchar(26) NOT NULL,'),('  `phone_number` varchar(26) NOT NULL'),(') ENGINE=MyISAM DEFAULT CHARSET=latin1;'),(NULL),('--'),('-- Dumping data for table `client`'),('--'),(NULL),('INSERT INTO `client` (`id`, `first_name`, `last_name`, `email`, `id_number`, `phone_number`) VALUES'),('(1, \'Brian\', \'Rakoi\', \'brianrakoi@gmail.com\', \'32589845\', \'0702164611\');'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `expense`'),('--'),(NULL),('CREATE TABLE `expense` ('),('  `id` int(3) NOT NULL,'),('  `trip_id` int(3) NOT NULL,'),('  `description` varchar(25) NOT NULL,'),('  `cost` float NOT NULL,'),('  `timestamp` varchar(26) NOT NULL'),(') ENGINE=MyISAM DEFAULT CHARSET=latin1;'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `parcel`'),('--'),(NULL),('CREATE TABLE `parcel` ('),('  `id` int(3) NOT NULL,'),('  `client_id` int(3) NOT NULL,'),('  `trip_id` int(3) NOT NULL,'),('  `destination` varchar(25) NOT NULL,'),('  `origin` varchar(26) NOT NULL,'),('  `description` varchar(26) NOT NULL,'),('  `quantity` int(4) NOT NULL,'),('  `price` float NOT NULL,'),('  `amount_paid` float NOT NULL,'),('  `payment_method` varchar(25) NOT NULL,'),('  `kilograms` int(4) NOT NULL,'),('  `timestamp` varchar(25) NOT NULL'),(') ENGINE=MyISAM DEFAULT CHARSET=latin1;'),(NULL),('--'),('-- Dumping data for table `parcel`'),('--'),(NULL),('INSERT INTO `parcel` (`id`, `client_id`, `trip_id`, `destination`, `origin`, `description`, `quantity`, `price`, `amount_paid`, `payment_method`, `kilograms`, `timestamp`) VALUES'),('(1, 1, 1, \'Nairobi\', \'Oloitokitok\', \'Old Small Tv\', 1, 500, 500, \'CASH\', 3, \'12/04/2021\');'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `role`'),('--'),(NULL),('CREATE TABLE `role` ('),('  `id` int(3) NOT NULL,'),('  `name` varchar(35) NOT NULL'),(') ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;'),(NULL),('--'),('-- Dumping data for table `role`'),('--'),(NULL),('INSERT INTO `role` (`id`, `name`) VALUES'),('(1, \'user\'),'),('(2, \'admin\');'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `trip`'),('--'),(NULL),('CREATE TABLE `trip` ('),('  `id` int(3) NOT NULL,'),('  `destination` varchar(25) NOT NULL,'),('  `origin` varchar(25) NOT NULL,'),('  `vehicle_id` int(4) NOT NULL,'),('  `depature` varchar(25) NOT NULL,'),('  `arrival` varchar(26) NOT NULL,'),('  `timestamp` varchar(25) NOT NULL'),(') ENGINE=MyISAM DEFAULT CHARSET=latin1;'),(NULL),('--'),('-- Dumping data for table `trip`'),('--'),(NULL),('INSERT INTO `trip` (`id`, `destination`, `origin`, `vehicle_id`, `depature`, `arrival`, `timestamp`) VALUES'),('(1, \'Nairobi\', \'Oloitokitok\', 1, \'12:00 \', \'15:48\', \'\');'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `user`'),('--'),(NULL),('CREATE TABLE `user` ('),('  `id` int(3) NOT NULL,'),('  `email` varchar(25) NOT NULL,'),('  `username` varchar(25) NOT NULL,'),('  `password` varchar(60) NOT NULL,'),('  `active` tinyint(1) NOT NULL,'),('  `expired` tinyint(1) NOT NULL,'),('  `roles` varchar(25) NOT NULL'),(') ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;'),(NULL),('--'),('-- Dumping data for table `user`'),('--'),(NULL),('INSERT INTO `user` (`id`, `email`, `username`, `password`, `active`, `expired`, `roles`) VALUES'),('(1, \'brianrakoi@gmail.com\', \'brianrakoi\', \'fsociety\', 1, 1, \'user_admin\');'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `user_role`'),('--'),(NULL),('CREATE TABLE `user_role` ('),('  `id` int(2) NOT NULL,'),('  `user_id` int(3) NOT NULL,'),('  `role_id` int(3) NOT NULL'),(') ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;'),(NULL),('--'),('-- Dumping data for table `user_role`'),('--'),(NULL),('INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES'),('(1, 1, 1);'),(NULL),('-- --------------------------------------------------------'),(NULL),('--'),('-- Table structure for table `vehicle`'),('--'),(NULL),('CREATE TABLE `vehicle` ('),('  `id` int(3) NOT NULL,'),('  `reg_no` varchar(25) NOT NULL,'),('  `make` varchar(25) NOT NULL,'),('  `user_id` varchar(25) NOT NULL,'),('  `date_assigned` varchar(25) NOT NULL'),(') ENGINE=MyISAM DEFAULT CHARSET=latin1;'),(NULL),('--'),('-- Dumping data for table `vehicle`'),('--'),(NULL),('INSERT INTO `vehicle` (`id`, `reg_no`, `make`, `user_id`, `date_assigned`) VALUES'),('(1, \'KCL 100P\', \'Hilux\', \'1\', \'12/2/2021\');'),(NULL),('--'),('-- Indexes for dumped tables'),('--'),(NULL),('--'),('-- Indexes for table `client`'),('--'),('ALTER TABLE `client`'),('  ADD PRIMARY KEY (`id`);'),(NULL),('--'),('-- Indexes for table `expense`'),('--'),('ALTER TABLE `expense`'),('  ADD PRIMARY KEY (`id`);'),(NULL),('--'),('-- Indexes for table `parcel`'),('--'),('ALTER TABLE `parcel`'),('  ADD PRIMARY KEY (`id`),'),('  ADD KEY `client_id` (`client_id`),'),('  ADD KEY `trip_id` (`trip_id`);'),(NULL),('--'),('-- Indexes for table `role`'),('--'),('ALTER TABLE `role`'),('  ADD PRIMARY KEY (`id`);'),(NULL),('--'),('-- Indexes for table `trip`'),('--'),('ALTER TABLE `trip`'),('  ADD PRIMARY KEY (`id`),'),('  ADD KEY `vehicle_id` (`vehicle_id`);'),(NULL),('--'),('-- Indexes for table `user`'),('--'),('ALTER TABLE `user`'),('  ADD PRIMARY KEY (`id`);'),(NULL),('--'),('-- Indexes for table `user_role`'),('--'),('ALTER TABLE `user_role`'),('  ADD PRIMARY KEY (`id`),'),('  ADD KEY `user_id` (`user_id`),'),('  ADD KEY `role_id` (`role_id`);'),(NULL),('--'),('-- Indexes for table `vehicle`'),('--'),('ALTER TABLE `vehicle`'),('  ADD PRIMARY KEY (`id`),'),('  ADD UNIQUE KEY `reg_no_index` (`reg_no`),'),('  ADD KEY `user_id` (`user_id`);'),(NULL),('--'),('-- AUTO_INCREMENT for dumped tables'),('--'),(NULL),('--'),('-- AUTO_INCREMENT for table `client`'),('--'),('ALTER TABLE `client`'),('  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;'),('--'),('-- AUTO_INCREMENT for table `expense`'),('--'),('ALTER TABLE `expense`'),('  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;'),('--'),('-- AUTO_INCREMENT for table `parcel`'),('--'),('ALTER TABLE `parcel`'),('  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;'),('--'),('-- AUTO_INCREMENT for table `role`'),('--'),('ALTER TABLE `role`'),('  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;'),('--'),('-- AUTO_INCREMENT for table `trip`'),('--'),('ALTER TABLE `trip`'),('  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;'),('--'),('-- AUTO_INCREMENT for table `user`'),('--'),('ALTER TABLE `user`'),('  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;'),('--'),('-- AUTO_INCREMENT for table `user_role`'),('--'),('ALTER TABLE `user_role`'),('  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;'),('--'),('-- AUTO_INCREMENT for table `vehicle`'),('--'),('ALTER TABLE `vehicle`'),('  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;'),('--'),('-- Constraints for dumped tables'),('--'),(NULL),('--'),('-- Constraints for table `user_role`'),('--'),('ALTER TABLE `user_role`'),('  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),'),('  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);'),(NULL),('/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;'),('/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;'),('/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;');
/*!40000 ALTER TABLE `anvil (1)` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(24) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `email` varchar(24) DEFAULT NULL,
  `id_number` varchar(24) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `type` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Brian ','Rakoi','brakoi@gmail.com','32589845','+254702164611',1),(2,'James','Bond','jb@gmail.com','333333','+25476969688',1),(15,'Winnny','Auwor','winnerauwor@gmail.coms','38135375','+254769580534',1),(16,'James','Bond','jb@gmail.com','333333','076969688',1),(17,'James','Bond','jb@gmail.com','333333','076969688',1),(18,'James','Bond','jb@gmail.com','333333','076969688',1),(19,'James','Bond','jb@gmail.com','333333','076969688',1),(20,'James','Bond','jb@gmail.com','333333','076969688',1),(21,'James','Bond','jb@gmail.com','333333','076969688',1),(22,'James','Bond','jb@gmail.com','333333','076969688',1),(23,'James','Bond','jb@gmail.com','333333','076969688',1),(24,'thanos','Okwany','thanosokwany@gmail.com','24187183','+254776821638',1),(25,'Greg','Ducetter','gducett@ymail.com','12121233','+254722232323',1),(26,'philion','live','philionlive@gmail.com','121212','+25478999999',1),(27,'Naivas',NULL,NULL,NULL,'+25479999999',1),(28,'KSL KENYA',NULL,NULL,NULL,'+254711223344',1),(29,'Aimsoft',NULL,NULL,NULL,'+2547222222222',1),(30,'Coveffe',NULL,NULL,NULL,'+25472222222',1),(31,'Naivassd',NULL,NULL,NULL,'+25472121212',1),(32,'termiantor',NULL,NULL,NULL,'+25478888888',1),(33,'DDR KENYA',NULL,NULL,NULL,'+2547211221222',1),(34,'tavis scott',NULL,NULL,NULL,'+2547987642587',1),(35,'Soujaboy',NULL,NULL,NULL,'+254744421212',2),(36,'Testing add',NULL,NULL,NULL,'+254722121212',2);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense`
--

DROP TABLE IF EXISTS `expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
INSERT INTO `expense` VALUES (1,'Fuel','Fuel for the trip'),(2,'Loaders','Loading and offloading charges'),(3,'Bribes','Police bribes'),(4,'Airtime','Airtime during transit'),(5,'Repairs','Vehicle Serviceing'),(6,'Accomodation','Drivers Accomodation'),(7,'Others',NULL);
/*!40000 ALTER TABLE `expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trip_id` int NOT NULL,
  `expense_id` int DEFAULT NULL,
  `description` varchar(25) NOT NULL,
  `cost` float NOT NULL,
  `timestamp` varchar(26) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses`
--

LOCK TABLES `expenses` WRITE;
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parcel_id` int DEFAULT NULL,
  `date` varchar(23) DEFAULT NULL,
  `status` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parcel_id` (`parcel_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`parcel_id`) REFERENCES `parcel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,38,'now()','NOT PAID'),(2,54,'20220114112114','Not Paid'),(3,55,'20220114112446','Not Paid'),(4,59,'20220114115457','Not Paid');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal`
--

DROP TABLE IF EXISTS `journal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `debit` double DEFAULT '0',
  `credit` double DEFAULT '0',
  `parcel_id` int DEFAULT NULL,
  `expense_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `expense_id` (`expense_id`),
  KEY `parcel_id` (`parcel_id`),
  CONSTRAINT `journal_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  CONSTRAINT `journal_ibfk_2` FOREIGN KEY (`expense_id`) REFERENCES `expenses` (`id`),
  CONSTRAINT `journal_ibfk_3` FOREIGN KEY (`parcel_id`) REFERENCES `parcel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal`
--

LOCK TABLES `journal` WRITE;
/*!40000 ALTER TABLE `journal` DISABLE KEYS */;
INSERT INTO `journal` VALUES (2,1,100,0,26,NULL);
/*!40000 ALTER TABLE `journal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mpesatransactions`
--

DROP TABLE IF EXISTS `mpesatransactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mpesatransactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `phone_number` varchar(25) DEFAULT NULL,
  `mpesa_receipt_number` varchar(55) DEFAULT NULL,
  `merchant_requestid` varchar(55) DEFAULT NULL,
  `parcel_id` int DEFAULT NULL,
  `date` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parcel_id` (`parcel_id`),
  CONSTRAINT `mpesatransactions_ibfk_1` FOREIGN KEY (`parcel_id`) REFERENCES `parcel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mpesatransactions`
--

LOCK TABLES `mpesatransactions` WRITE;
/*!40000 ALTER TABLE `mpesatransactions` DISABLE KEYS */;
INSERT INTO `mpesatransactions` VALUES (1,1,'254702164611','PLV3XGQI9B','15321-40079386-1',NULL,'20211231173427'),(2,1,'254702164611','QA90DBO6B0','10462-6200498-1',NULL,'20220109'),(3,1,'254702164611','QA91DCIEZ9','101307-42662256-1',NULL,'20220109180804'),(4,2,'254702164611','QAA2EAULRU','33601-3141581-1',40,'20220110120832'),(5,1,'254702164611','QAA4ECJT1Y','51695-44801637-1',NULL,'20220110113753'),(6,1,'254702164611','QAA0ECMSNG','3521-33032581-1',NULL,'20220110113908'),(9,0,NULL,NULL,NULL,38,NULL),(10,1,'254702164611',NULL,NULL,43,'20220110125338'),(11,12,'0702164611','testrec','test',NULL,NULL),(12,12,'0702164611','testrec','test',NULL,NULL),(13,1,'254702164611','QAE4KY98AI','16830-3031676-1',NULL,'20220114105954'),(14,1,'254702164611','QAE0KYYV6U','10481-17252539-1',NULL,'20220114111229'),(15,1,'254702164611','QUALSU12',NULL,NULL,'20220114112114');
/*!40000 ALTER TABLE `mpesatransactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcel`
--

DROP TABLE IF EXISTS `parcel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parcel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reciever` int NOT NULL,
  `trip_id` int DEFAULT NULL,
  `destination_id` varchar(25) NOT NULL,
  `origin_id` varchar(26) NOT NULL,
  `description` varchar(26) NOT NULL,
  `quantity` int NOT NULL,
  `price` float NOT NULL,
  `amount_paid` float NOT NULL,
  `payment_method` varchar(25) NOT NULL,
  `kilograms` int NOT NULL,
  `collected` binary(1) DEFAULT '0',
  `timestamp` varchar(25) NOT NULL,
  `collection_point` varchar(20) DEFAULT NULL,
  `sender` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`reciever`),
  KEY `trip_id` (`trip_id`),
  KEY `sender_id` (`sender`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcel`
--

LOCK TABLES `parcel` WRITE;
/*!40000 ALTER TABLE `parcel` DISABLE KEYS */;
INSERT INTO `parcel` VALUES (8,15,NULL,'1','3','TECHNO MOBILE PHONE',1,500,500,'invoice',1,_binary '0','2021/11/26 11:06:34',NULL,2),(9,15,NULL,'3','1','test',1,200,1000,'cash',1,_binary '0','2021/07/12 07:53:39',NULL,1),(11,15,NULL,'3','1','ONE MOBILE PHONE',1,200,479,'cash',11,_binary '0','2021/07/12 07:57:15',NULL,1),(13,15,NULL,'1','3','ONE MOBILE PHONE',1,200,479,'cash',11,_binary '1','2021/11/25 17:13:56',NULL,1),(14,15,NULL,'1','3','ONE MOBILE PHONE',1,500,500,'cash',1,_binary '0','2021/07/07 08:34:56',NULL,2),(15,15,NULL,'3','1','ONE MOBILE PHONE',1,200,479,'cash',11,_binary '0','2021/07/12 07:56:04',NULL,1),(16,15,NULL,'3','1','ONE MOBILE PHONE',1,200,479,'cash',11,_binary '0','2021/07/12 07:56:04',NULL,1),(17,15,NULL,'3','1','test',1,200,1000,'cash',1,_binary '0','2021/07/12 07:53:39',NULL,1),(19,15,NULL,'3','1','ONE MOBILE PHONE',1,200,479,'cash',11,_binary '0','2021/07/12 07:56:04',NULL,1),(21,15,NULL,'3','1','test',1,200,1000,'cash',1,_binary '0','2021/07/12 07:53:39',NULL,1),(23,15,NULL,'2','1','Candles',1,300,300,'invoice',1,NULL,'2021/11/24 16:20:54',NULL,1),(24,24,NULL,'2','1','Chrismas tree',1,300,300,'cash',2,NULL,'2021/11/26 12:43:30',NULL,1),(25,24,NULL,'2','1','Chrismas tree',1,500,500,'cash',2,NULL,'2021/11/26 12:53:18',NULL,1),(26,25,NULL,'2','1','Protein Suppliments',1,100,100,'cash',12,NULL,'2021/12/13 12:50:41',NULL,26),(27,27,NULL,'2','1','Sweets',2,2400,2400,'cash',12,NULL,'2021/12/13 12:56:58',NULL,28),(28,29,NULL,'2','1','Sweets',1,1,21,'cash',1,NULL,'2021/12/13 13:02:29',NULL,30),(29,31,NULL,'2','1','Sweets',1,1,1,'cash',1,NULL,'2021/12/13 13:07:59',NULL,32),(30,1,NULL,'2','1','121',1,100,100,'cash',12,NULL,'2021/12/13 13:13:15',NULL,33),(31,1,NULL,'2','1','12',12,12,12,'cash',22,NULL,'2021/12/13 13:17:04',NULL,34),(32,35,NULL,'2','1','12',12,12,12,'cash',12,NULL,'2021/12/13 13:21:31',NULL,36),(33,1,NULL,'2','1','description',1,200,200,'M-PESA',1,NULL,'2022/01/10 11:46:13',NULL,15),(34,15,NULL,'2','1','wwesd',23,23,23,'M-PESA',1,NULL,'2022/01/10 11:49:04',NULL,1),(35,15,NULL,'2','1','12',1,1,1,'M-PESA',112,NULL,'2022/01/10 12:13:23',NULL,1),(36,15,NULL,'2','1','test',12,12,12,'M-PESA',12,NULL,'2022/01/10 12:29:26',NULL,1),(37,15,NULL,'2','1','ds',1,1,1,'M-PESA',1,NULL,'2022/01/10 12:34:39',NULL,1),(38,15,NULL,'2','1','sesd',12,12,12,'M-PESA',12,NULL,'2022/01/10 12:39:24',NULL,1),(39,1,NULL,'2','1','dssdd',1,1,1,'M-PESA',1,NULL,'2022/01/10 12:41:27',NULL,15),(40,1,NULL,'2','1','dssd',23,23,12,'M-PESA',12,NULL,'2022/01/10 12:46:47',NULL,15),(41,15,NULL,'2','1','DFDFD',1,1,1,'M-PESA',1,NULL,'2022/01/10 12:48:48',NULL,1),(42,15,NULL,'2','1','sdsd',12,12,12,'M-PESA',12,NULL,'2022/01/10 12:51:44',NULL,1),(43,15,NULL,'2','1','ewew',1,1,1,'M-PESA',1,NULL,'2022/01/10 12:53:36',NULL,1),(44,15,NULL,'2','1','sds',1,1,1200,'cash',1,NULL,'2022/01/10 12:55:05',NULL,1),(45,1,NULL,'2','1','Sweets',1,1,1,'M-PESA',1,NULL,'2022/01/14 10:49:39',NULL,15),(46,1,NULL,'2','1','test',2,1,1,'M-PESA',1,NULL,'2022/01/14 10:53:22',NULL,1),(47,15,NULL,'2','1','dsjns',1,1,1,'M-PESA',1,NULL,'2022/01/14 11:00:58',NULL,1),(48,15,NULL,'2','1','dsjns',1,1,1,'M-PESA',1,NULL,'2022/01/14 11:00:49',NULL,1),(49,15,NULL,'2','1','12',1,1,1,'M-PESA',1,NULL,'2022/01/14 11:07:02',NULL,1),(50,1,NULL,'2','1','1',1,1,1,'M-PESA',1,NULL,'2022/01/14 11:09:40',NULL,15),(51,15,NULL,'2','1','1',1,1,1,'M-PESA',1,NULL,'2022/01/14 11:13:23',NULL,1),(52,15,7,'2','1','edsd',2,1,1,'M-PESA',1,NULL,'2022/01/14 11:16:24',NULL,1),(53,15,NULL,'2','1','snjsnd',1,1,1,'M-PESA',1,NULL,'2022/01/14 11:18:05',NULL,1),(54,15,NULL,'2','1','dsdsdsd',1,1,1,'M-PESA',1,NULL,'2022/01/14 11:21:14',NULL,1),(55,15,NULL,'2','1','test saving',1,1,1,'M-PESA',11,NULL,'2022/01/14 11:48:58',NULL,1),(56,15,NULL,'2','1','dssd',1,1,1,'invoice',1,NULL,'2022/01/14 11:50:15',NULL,1),(57,15,NULL,'2','1','ddsndsk',1,1,1,'invoice',1,NULL,'2022/01/14 11:52:35',NULL,1),(58,15,NULL,'2','1','test',1,1,1,'cash',1,NULL,'2022/01/14 11:53:46',NULL,1),(59,15,NULL,'2','1','test',1,1,1,'invoice',1,NULL,'2022/01/14 11:54:57',NULL,1);
/*!40000 ALTER TABLE `parcel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES (1,'MPESA'),(2,'CASH'),(3,'INVOICE'),(4,'NOT PAID');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'user'),(2,'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'Nairobi'),(2,'Kisumu'),(3,'Mwea');
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `destination` varchar(25) NOT NULL,
  `origin` varchar(25) NOT NULL,
  `vehicle_id` int NOT NULL,
  `depature` varchar(25) NOT NULL,
  `arrival` varchar(20) DEFAULT NULL,
  `timestamp` varchar(25) NOT NULL,
  `completed` varchar(2) DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `vehicle_id` (`vehicle_id`)
) ENGINE=MyISAM AUTO_INCREMENT=149 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (6,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(7,'Nairobi','Kisumu',1,'12:00 ','2021/12/13 11:38:50','','Y'),(8,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(9,'Nairobi','Kisumu',1,'12:00 ','2021/11/22 11:47:43','','Y'),(10,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(11,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 13:15:13','','Y'),(12,'Nairobi','Kisumu',2,'12:00 ','2021/11/18 12:53:24','','Y'),(13,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 12:55:17','','Y'),(14,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(15,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 12:54:34','','Y'),(16,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(18,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(30,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(34,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(36,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(37,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 13:15:21','','Y'),(38,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(39,'Nairobi','Kisumu',1,'12:00 ','2021/12/13 11:44:24','','Y'),(42,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(43,'Nairobi','Kisumu',1,'12:00 ','2021/12/13 11:43:49','','Y'),(44,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(45,'Nairobi','Kisumu',1,'12:00 ',NULL,'','N'),(46,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(47,'Nairobi','Kisumu',1,'12:00 ',NULL,'','N'),(48,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(49,'Nairobi','Kisumu',1,'12:00 ',NULL,'','N'),(50,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(51,'Nairobi','Kisumu',1,'12:00 ',NULL,'','N'),(52,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(54,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(55,'Nairobi','Kisumu',1,'12:00 ',NULL,'','N'),(56,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(57,'Nairobi','Kisumu',1,'12:00 ',NULL,'','N'),(58,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(59,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 13:16:00','','Y'),(60,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(61,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 13:15:54','','Y'),(62,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(63,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 13:15:48','','Y'),(64,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(66,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(67,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 13:15:41','','Y'),(68,'Nairobi','Kisumu',2,'12:00 ','15:48','','N'),(69,'Nairobi','Kisumu',1,'12:00 ','2021/11/18 13:09:50','','Y'),(70,'Nairobi','Kisumu',2,'12:00 ','15:48','','N');
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(60) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `roles` varchar(25) NOT NULL,
  `station_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `station_fk` (`station_id`),
  CONSTRAINT `station_fk` FOREIGN KEY (`station_id`) REFERENCES `station` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'brianrakoi@gmail.com','brianrakoi','fsociety',1,1,'user_admin',1),(2,'brayoleposo@gmail.com','brayoleposo','fsociety',1,1,'user_admin',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reg_no` varchar(25) NOT NULL,
  `make` varchar(25) NOT NULL,
  `user_id` varchar(25) NOT NULL,
  `date_assigned` varchar(25) NOT NULL,
  `driver_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reg_no_index` (`reg_no`),
  KEY `user_id` (`user_id`),
  KEY `driver_id` (`driver_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'KCL 100P','Hilux','1','12/2/2021','1'),(2,'KDD 240J','Hilux','2','12/2/2021','2');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-14 12:40:14

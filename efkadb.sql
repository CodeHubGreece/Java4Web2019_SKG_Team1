-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: efkadb
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `citizen_id` int(10) unsigned NOT NULL,
  `doctor_id` int(10) unsigned NOT NULL,
  `datetime` datetime NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `notes` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  KEY `cit_app_idx` (`citizen_id`),
  KEY `doc_app_idx` (`doctor_id`),
  CONSTRAINT `cit_app` FOREIGN KEY (`citizen_id`) REFERENCES `citizen` (`id`),
  CONSTRAINT `doc_app` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citizen`
--

DROP TABLE IF EXISTS `citizen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citizen` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `AMKA` bigint(11) unsigned NOT NULL,
  `first_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AMKA_UNIQUE` (`AMKA`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  CONSTRAINT `cit_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizen`
--

LOCK TABLES `citizen` WRITE;
/*!40000 ALTER TABLE `citizen` DISABLE KEYS */;
INSERT INTO `citizen` VALUES (67,79,12149512345,'Κωνσταντίνος','Βιτουλαδίτης','koninos95@gmail.com','6987985255'),(68,80,22019645667,'Αλέξανδρος','Διαμαντής','diamantisalex@gmail.com','6912345678');
/*!40000 ALTER TABLE `citizen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `first_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `specialty_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `fk_spec_idx` (`specialty_id`),
  CONSTRAINT `doc_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_spec` FOREIGN KEY (`specialty_id`) REFERENCES `specialty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (57,71,'Κυριάκος','Μητσοτάκης',58),(58,68,'Ιάσωνας','Παπαμιχαήλ',33),(59,69,'Γρηγόρης','Σπίτης',49),(60,70,'Gregory','House',25),(61,72,'Ιπποκράτης','Ιπποκράτους',28),(62,73,'Πάτροκλος','Παπαπέτρου',86),(63,74,'Γιώργος','Γιατρός',60),(64,75,'Γιάννης','Παπαδόπουλος',26),(65,76,'Κώστας','Δημητρόπουλος',49),(66,77,'Μάρκος','Καλησπέρης',57),(67,78,'Ανδρέας','Μούσιας',53);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (52),(52),(52),(52);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialty`
--

DROP TABLE IF EXISTS `specialty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialty` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `specialty` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialty`
--

LOCK TABLES `specialty` WRITE;
/*!40000 ALTER TABLE `specialty` DISABLE KEYS */;
INSERT INTO `specialty` VALUES (21,'Αγγειοχειρουργός - Αγγειολόγος'),(22,'Αθλητίατρος'),(23,'Αιματολόγος'),(24,'Αλλεργιολόγος'),(25,'Αναισθησιολόγος'),(26,'Βελονιστής'),(27,'Γαστρεντερολόγος'),(28,'Γενικός Γιατρός'),(29,'Γενικός Χειρουργός'),(30,'Γιατρός Υπερβαρικής - Καταδυτικής Ιατρικής'),(31,'Γναθολόγος'),(32,'Γναθοχειρουργός'),(33,'Γυναικολόγος - Μαιευτήρας'),(34,'Δερματολόγος - Αφροδισιολόγος'),(35,'Διαβητολόγος'),(36,'Διαιτολόγος - Διατροφολόγος'),(37,'Ειδικός Παιδαγωγός'),(38,'Εμβρυολόγος'),(39,'Ενδοδοντολόγος'),(40,'Ενδοκρινολόγος'),(41,'Εργοθεραπευτής'),(42,'Ηπατολόγος'),(43,'Καρδιολόγος'),(44,'Καρδιοχειρουργός'),(45,'Κοινωνικός λειτουργός'),(46,'Λογοθεραπευτής'),(47,'Μαστολόγος'),(48,'Νευρολόγος'),(49,'Νευροχειρουργός'),(50,'Νευροψυχολόγος'),(51,'Νεφρολόγος'),(52,'Ογκολόγος'),(53,'Οδοντίατρος'),(54,'Ομοιοπαθητικός'),(55,'Ορθοδοντικός'),(56,'Ορθοπαιδικός - Ορθοπαιδικός Χειρουργός'),(57,'Ουρολόγος - Ανδρολόγος'),(58,'Οφθαλμίατρος'),(59,'Παθολόγος'),(60,'Παιδίατρος'),(61,'Παιδογαστρεντερολόγος'),(62,'Παιδοδιαβητολόγος'),(63,'Παιδοδοντίατρος'),(64,'Παιδοενδοκρινολόγος'),(65,'Παιδοκαρδιολόγος'),(66,'Παιδοορθοπαιδικός'),(67,'Παιδοπνευμονολόγος'),(68,'Παιδορευματολόγος'),(69,'Παιδοχειρουργός'),(70,'Παιδοψυχίατρος'),(71,'Παιδοψυχολόγος'),(72,'Παιδο-ΩΡΛ'),(73,'Περιοδοντολόγος'),(74,'Πλαστικός Χειρουργός'),(75,'Πνευμονολόγος - Φυματιολόγος'),(76,'Ποδολόγος'),(77,'Προσθετολόγος'),(78,'Ρευματολόγος'),(79,'Στοματολόγος'),(80,'Φυσίατρος'),(81,'Φυσικοθεραπευτής'),(82,'Χειρουργός Ενδοκρινών Αδένων'),(83,'Χειρουργός στόματος'),(84,'Ψυχίατρος'),(85,'Ψυχολόγος - Ψυχοθεραπευτής'),(86,'Ωτορινολαρυγγολόγος');
/*!40000 ALTER TABLE `specialty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `pwd` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (68,'d','iasonas32','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(69,'d','doctorhouse','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(70,'d','greghousemd','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(71,'d','who','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(72,'d','ipokratis','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(73,'d','patroklos','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(74,'d','giorgosogiatros','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(75,'d','doctor','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(76,'d','kostas','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(77,'d','mark','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(78,'d','mousias','$2a$10$jZKxf7EDJKtDR9kr2naBDuImJRTIUmZWCCGdD5LZSjT5zeuO8ZrVC'),(79,'c','koninos','$2a$10$Pgh4/01FKYEghzGH9Uef4.Si5dPfrXsOb.QCj/ti3x644dG1Sif6W'),(80,'c','alex','$2a$10$1K7hIx8MKHffza8W3Kh9Duzx/GNCpGddl4yR2J3fsFUoFDPBTsCjK');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'efkadb'
--

--
-- Dumping routines for database 'efkadb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-19 19:29:43

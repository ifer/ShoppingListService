-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.19

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
  `catid` int NOT NULL AUTO_INCREMENT,
  `descr` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`catid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Γαλακτοκομικά'),(2,'Ροφήματα, ποτά, αναψυκτικά'),(4,'Κρέας, αλλαντικά, ψάρια'),(6,'Ψωμί και αρτοσκευάσματα'),(7,'Ξηροί καρποί και ζαχαρώδη'),(8,'Δημητριακά, κράκερς, μπισκότα'),(10,'Υλικά μαγειρικής, μπαχαρικά'),(11,'Ζυμαρικά, ρύζια, όσπρια'),(16,'Φρούτα και λαχανικά'),(17,'Κατεψυγμένα και κονσέρβες'),(20,'Καθαριστικά, απορρυπαντικά, οικιακά'),(22,'Χαρτικά'),(23,'Υγιεινή και περιποίηση σώματος');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `prodid` int NOT NULL AUTO_INCREMENT,
  `descr` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `catid` int NOT NULL,
  PRIMARY KEY (`prodid`,`descr`),
  KEY `fk_product_category_idx` (`catid`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`catid`) REFERENCES `category` (`catid`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Γάλα Όλυμπος χωρίς λακτόζη',1),(2,'Γιαούρτι Όλυμπος Freelact 2%',1),(3,'Γιαούρτι Όλυμπος Στραγγιστό 2%',1),(4,'Κατίκι Δομοκού',1),(5,'Τυρί φέτα Όλυμπος ή Δωδώνη',1),(6,'Τυρί Τρικαλινό Ελαφρύ σε Φέτες ΦΑΓΕ',1),(7,'Τυρί φέτες Milner',1),(8,'Τυρί Parmigiano Reggiano κομμάτι',1),(9,'Τυρί  Parmigiano Reggiano τριμμένο',1),(15,'Χαμομήλι',2),(40,'Καφές γαλλικός',2),(41,'Χυμός γκρέιπφρουτ',2),(38,'Γαλοπούλα βραστή φέτες',4),(39,'Σολωμός καπνιστός',4),(12,'Ψωμί Κατσέλης Γερμανικού τύπου (κόκκινο)',6),(13,'Παξιμάδια χαρουπιού',6),(14,'Σοκολατάκια υγείας',7),(27,'Παστέλι',7),(10,'Δημητριακά All-Bran Fibre Plus',8),(11,'Δημητριακά All Bran Flakes',8),(32,'Κράκερς',8),(21,'Αλεύρι για όλες τις χρήσεις',10),(22,'Ζάχαρη',10),(23,'Σόδα μαγειρική',10),(24,'Ρίγανη',10),(28,'Αλάτι',10),(29,'Σπαγγέτι Νο 6 ',11),(30,'Πένες',11),(31,'Φακές',11),(18,'Πορτοκάλια',16),(19,'Σαλάτα έτοιμη',16),(20,'Τομάτες',16),(16,'Κονσέρβες τόνου μικρές σε αλατόνερο',17),(17,'Σακούλες Απορριμμάτων Ultra Strong Μεγάλες Sanitas (52x75cm)',20),(33,'Ajaz Chloron',20),(34,'Ajax για τζάμια',20),(35,'Cif',20),(36,'Απορρυπαντικό πλυντηρίου πιάτων',20),(37,'Απορρυπαντικό πλυντηρίου ρούχων DIXAN',20),(42,'Χαρτιά υγείας',22),(43,'Χαρτί κουζίνας',22),(44,'Χαρτοπετσέτες',22),(45,'Χαρτομάντηλα πακέτο',22),(46,'Χαρτομάντηλα κουτί',22),(25,'Αποσμητικό Noxema',23),(26,'Αφροντούς Petite Marseillese',23);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopitem`
--

DROP TABLE IF EXISTS `shopitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopitem` (
  `itemid` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(200) DEFAULT NULL,
  `quantity` varchar(30) NOT NULL,
  `prodid` int NOT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fk_list_product1_idx` (`prodid`),
  CONSTRAINT `fk_list_product1` FOREIGN KEY (`prodid`) REFERENCES `product` (`prodid`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopitem`
--

LOCK TABLES `shopitem` WRITE;
/*!40000 ALTER TABLE `shopitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `passwdhash` varchar(100) NOT NULL,
  `roles` varchar(80) DEFAULT NULL,
  `version` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `nameidx` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ifer','lGrjiDtLeoHfUSjoBo2n3bK4+ohQnk1V','ROLE_USER,ROLE_ADMIN',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-22 10:56:07

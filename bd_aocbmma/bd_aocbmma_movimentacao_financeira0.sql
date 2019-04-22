-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: 31.220.61.60    Database: bd_aocbmma
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movimentacao_financeira`
--

DROP TABLE IF EXISTS `movimentacao_financeira`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimentacao_financeira` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path_arquivo` varchar(255) DEFAULT NULL,
  `periodo_final` date NOT NULL,
  `periodo_inicial` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacao_financeira`
--

LOCK TABLES `movimentacao_financeira` WRITE;
/*!40000 ALTER TABLE `movimentacao_financeira` DISABLE KEYS */;
INSERT INTO `movimentacao_financeira` VALUES (6,'/uploads/files/financeiro/2017/Financeiro out - dez 2017.pdf','2017-12-31','2017-10-01'),(7,'/uploads/files/financeiro/2018/Financeiro jul - set 2018.pdf','2018-09-30','2018-07-01'),(8,'/uploads/files/financeiro/2017/Financeiro jul - set 2017.pdf','2017-09-30','2017-07-01'),(9,'/uploads/files/financeiro/2018/Financeiro jan - mar 2018.pdf','2018-03-31','2018-01-01'),(10,'/uploads/files/financeiro/2018/Financeiro abr - jun 2018.pdf','2018-06-30','2018-04-01');
/*!40000 ALTER TABLE `movimentacao_financeira` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-21 12:44:13

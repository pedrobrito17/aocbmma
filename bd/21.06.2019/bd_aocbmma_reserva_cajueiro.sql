-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
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
-- Table structure for table `reserva_cajueiro`
--

DROP TABLE IF EXISTS `reserva_cajueiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva_cajueiro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_reserva` date NOT NULL,
  `data_solicitacao` date NOT NULL,
  `pagamento` varchar(255) DEFAULT NULL,
  `periodo` varchar(255) NOT NULL,
  `valor_reserva` float NOT NULL,
  `socio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKka1cqk15jejufmpfge1mu6rfw` (`socio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_cajueiro`
--

LOCK TABLES `reserva_cajueiro` WRITE;
/*!40000 ALTER TABLE `reserva_cajueiro` DISABLE KEYS */;
INSERT INTO `reserva_cajueiro` VALUES (1,'2019-04-06','2019-04-04','realizado','diária',250,2),(2,'2019-04-13','2019-04-04','realizado','diurno',100,3),(3,'2019-04-27','2019-04-06','realizado','diária',250,6),(4,'2019-05-25','2019-05-04','realizado','diurno',100,45),(5,'2019-06-15','2019-05-21','vencido','diurno',100,96),(6,'2019-12-21','2019-05-27','realizado','diurno',100,99),(7,'2019-06-15','2019-05-30','realizado','diurno',100,96),(8,'2019-07-06','2019-05-31','realizado','noturno',150,23),(10,'2019-06-22','2019-06-02','realizado','diurno',100,23),(12,'2019-07-13','2019-06-05','vencido','diurno',100,96),(13,'2019-09-06','2019-06-06','vencido','noturno',150,109),(14,'2019-08-23','2019-06-19','realizado','noturno',150,158);
/*!40000 ALTER TABLE `reserva_cajueiro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-21 18:19:57

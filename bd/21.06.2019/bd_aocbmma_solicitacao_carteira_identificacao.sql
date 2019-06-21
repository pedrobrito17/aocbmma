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
-- Table structure for table `solicitacao_carteira_identificacao`
--

DROP TABLE IF EXISTS `solicitacao_carteira_identificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacao_carteira_identificacao` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `data_solicitacao` date NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `socio_id` int(11) NOT NULL,
  PRIMARY KEY (`cod`),
  KEY `FKrgv09ln6ms36kirgul0o3ykdf` (`socio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao_carteira_identificacao`
--

LOCK TABLES `solicitacao_carteira_identificacao` WRITE;
/*!40000 ALTER TABLE `solicitacao_carteira_identificacao` DISABLE KEYS */;
INSERT INTO `solicitacao_carteira_identificacao` VALUES (1,'2019-05-30','/uploads/files/carteira/Foto 3x4.jpg','solicitado',101),(2,'2019-06-07','/uploads/files/carteira/15599333650004582484950295261511.jpg','solicitado',15),(3,'2019-06-11','/uploads/files/carteira/15602616590299014074011311330013.jpg','solicitado',126),(4,'2019-06-19','/uploads/files/carteira/IMG_20190619_101320.jpg','solicitado',34),(5,'2019-06-19','/uploads/files/carteira/122.jpg','solicitado',94),(6,'2019-06-19','/uploads/files/carteira/foto jefferson.jpeg','solicitado',161),(7,'2019-06-19','/uploads/files/carteira/foto carteira de socio AOC.jpg','solicitado',60),(8,'2019-06-19','/uploads/files/carteira/WhatsApp Image 2019-06-19 at 11.27.17.jpeg','solicitado',20),(9,'2019-06-19','/uploads/files/carteira/Screenshot_20190619-170049_Instagram.jpg','solicitado',124),(10,'2019-06-20','/uploads/files/carteira/foto.jpg','solicitado',83),(11,'2019-06-21','/uploads/files/carteira/IMG_20190621_092339284.jpg','solicitado',102),(12,'2019-06-21','/uploads/files/carteira/rg funcional(2).jpg','solicitado',184),(13,'2019-06-21','/uploads/files/carteira/20190521_144400.jpg','solicitado',119);
/*!40000 ALTER TABLE `solicitacao_carteira_identificacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-21 18:21:01

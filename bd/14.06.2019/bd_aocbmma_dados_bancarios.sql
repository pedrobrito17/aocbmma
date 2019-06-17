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
-- Table structure for table `dados_bancarios`
--

DROP TABLE IF EXISTS `dados_bancarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_bancarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agencia` varchar(255) NOT NULL,
  `banco` varchar(255) NOT NULL,
  `conta_corrente` varchar(255) NOT NULL,
  `socio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcfwqjpuoh88wlm2m45bgm4bjl` (`socio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=142 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_bancarios`
--

LOCK TABLES `dados_bancarios` WRITE;
/*!40000 ALTER TABLE `dados_bancarios` DISABLE KEYS */;
INSERT INTO `dados_bancarios` VALUES (1,'5821-1','Banco do Brasil S.A.','24973-4',1),(2,'232-1','Banco do Brasil S.A.','23423-2',2),(3,'2342-2','Banco do Brasil S.A.','2342-3',3),(4,'1638-1','Banco do Brasil S.A.','58350-2',4),(5,'1878','Banco do Brasil S.A.','29343',5),(6,'1638-1','Banco do Brasil S.A.','39947-7',6),(7,'5794-0','Banco do Brasil S.A.','5655-3',7),(8,'1638-1','Banco do Brasil S.A.','38385-6',8),(9,'1307','Caixa Econômica Federal','3709-5',9),(10,'2953x','Banco do Brasil S.A.','217069',10),(11,'0895-8','Banco do Brasil S.A.','40203-6',11),(12,'36501','Banco do Brasil S.A.','259187',12),(13,'4323-0','Banco do Brasil S.A.','29.327-x',13),(14,'36501','Banco do Brasil S.A.','32180x',14),(15,'1307','Caixa Econômica Federal','20938-4',15),(16,'5789-4','Banco do Brasil S.A.','26219-6',16),(17,'4322','Banco do Brasil S.A.','15668-X',17),(18,'1611-X','Banco do Brasil S.A.','28821-7',18),(19,'12345','Banco do Brasil S.A.','12345',19),(20,'0895-8','Banco do Brasil S.A.','57890-8',20),(21,'18783','Banco do Brasil S.A.','125164',21),(22,'1878-3','Banco do Brasil S.A.','412946-6',22),(23,'020-5','Banco do Brasil S.A.','49754-1',23),(24,'1639-X','Banco do Brasil S.A.','83049-6',24),(25,'5716-9','Banco do Brasil S.A.','2468-6',25),(26,'5784-3','Banco do Brasil S.A.','4279-x',26),(28,'57169','Banco do Brasil S.A.','200808',28),(29,'57843','Banco do Brasil S.A.','42811',29),(30,'42889','Banco do Brasil S.A.','195022',30),(31,'1638-1','Banco do Brasil S.A.','55306-9',31),(32,'4445-8','Banco do Brasil S.A.','12119-3',32),(33,'5784-3','Banco do Brasil S.A.','5891-2',33),(34,'57894','Banco do Brasil S.A.','302112',34),(35,'57843','Banco do Brasil S.A.','42765',35),(36,'1414','Banco do Brasil S.A.','29229x',36),(37,'4288-9','Banco do Brasil S.A.','16340-6',37),(38,'0562-2','Banco do Brasil S.A.','40967-7',38),(39,'57894','Banco do Brasil S.A.','487147',39),(40,'1414-1','Banco do Brasil S.A.','30975-3',40),(41,'1693-x','Banco do Brasil S.A.','27242-6',41),(42,'5784-3','Banco do Brasil S.A.','4278-1',42),(43,'14141','Banco do Brasil S.A.','309680',43),(44,'1414-1','Banco do Brasil S.A.','27814-9',44),(45,'1612 8','Banco do Brasil S.A.','20 453 6',45),(46,'5784-3','Banco do Brasil S.A.','655-6',46),(47,'1612-8','Banco do Brasil S.A.','24652-2',47),(48,'1638-1','Banco do Brasil S.A.','36883-0',48),(49,'42889','Banco do Brasil S.A.','135615',49),(50,'5821-1','Banco do Brasil S.A.','26306-0',50),(51,'3786','Banco Bradesco S.A.','33697-1',51),(52,'5789-4','Banco do Brasil S.A.','30218-X',52),(53,'0027','Caixa Econômica Federal','0027983-3',53),(54,'1611-x','Banco do Brasil S.A.','22999-7',54),(55,'14141','Banco do Brasil S.A.','292206',55),(56,'4288-9','Banco do Brasil S.A.','10881-2',56),(57,'16128','Banco do Brasil S.A.','246557',57),(58,'1639-x','Banco do Brasil S.A.','22487-1',58),(59,'57843','Banco do Brasil S.A.','2143',59),(60,'1414-1','Banco do Brasil S.A.','18563-9',60),(61,'2954-8','Banco do Brasil S.A.','13.515-1',61),(62,'4288 - 9','Banco do Brasil S.A.','9842-6',62),(63,'1639-X','Banco do Brasil S.A.','22586-X',63),(64,'57843','Banco do Brasil S.A.','81051',64),(65,'1638-1','Banco do Brasil S.A.','16911-0',65),(66,'2954-8','Banco do Brasil S.A.','20021-2',66),(67,'44458','Banco do Brasil S.A.','208094',67),(68,'2726-X','Banco do Brasil S.A.','41585-5',68),(69,'5789-4','Banco do Brasil S.A.','30246-5',69),(70,'16381','Banco do Brasil S.A.','283444',70),(71,'5784-3','Banco do Brasil S.A.','8111-6',71),(72,'1638-1','Banco do Brasil S.A.','583456',72),(73,'1576','Caixa Econômica Federal','30873-4',73),(74,'5675-8','Banco do Brasil S.A.','6296-0',74),(75,'5784-3','Banco do Brasil S.A.','4274-9',75),(76,'57894','Banco do Brasil S.A.','38142-x',76),(77,'0020-5','Banco do Brasil S.A.','52445-0',77),(78,'1414-1','Banco do Brasil S.A.','29.284-2',78),(79,'57169','Banco do Brasil S.A.','111910',79),(80,'5789-4','Banco do Brasil S.A.','30256-2',80),(81,'1638-1','Banco do Brasil S.A.','56642-x',81),(82,'5716-9','Banco do Brasil S.A.','1883-X',82),(83,'1611-X','Banco do Brasil S.A.','37253-6',83),(84,'16381','Banco do Brasil S.A.','535575',84),(85,'2004-4','Banco do Brasil S.A.','23671-3',85),(86,'1878-3','Banco do Brasil S.A.','27492-5',86),(87,'5716-9','Banco do Brasil S.A.','510-x',87),(88,'4288-9','Banco do Brasil S.A.','23214-9',88),(89,'57169','Banco do Brasil S.A.','338958',89),(90,'4288-9','Banco do Brasil S.A.','15314-1',90),(91,'2645-X','Banco do Brasil S.A.','17975-2',91),(92,'56758','Banco do Brasil S.A.','79359',92),(93,'20-5','Banco do Brasil S.A.','130845-9',93),(94,'1612-8','Banco do Brasil S.A.','24649-2',94),(95,'1638-1','Banco do Brasil S.A.','53669-5',95),(96,'16128','Banco do Brasil S.A.','1552791',96),(97,'1612-8','Banco do Brasil S.A.','24659-X',97),(98,'1180','Banco Bradesco S.A.','12610-1',98),(99,'4288-9','Banco do Brasil S.A.','20486-2',99),(100,'57843','Banco do Brasil S.A.','42757',100),(101,'8618-5','Banco do Brasil S.A.','20107-3',101),(102,'2972-1','Banco do Brasil S.A.','42447-1',102),(103,'42889','Banco do Brasil S.A.','12671-3',103),(104,'14141','Banco do Brasil S.A.','292648',104),(105,'2645-X','Banco do Brasil S.A.','17974-4',105),(106,'3650-1','Banco do Brasil S.A.','25008-2',106),(107,'57843','Banco do Brasil S.A.','43117',107),(108,'1638-1','Banco do Brasil S.A.','58347-2',108),(109,'8648-5','Banco do Brasil S.A.','29.419-5 ',109),(110,'8618-5','Banco do Brasil S.A.','10.759-X',110),(111,'16381','Banco do Brasil S.A.','586056',111),(112,'5821-1','Banco do Brasil S.A.','26229-x',115),(113,'16381','Banco do Brasil S.A.','347515',116),(114,'5789-4','Banco do Brasil S.A.','30221-x',117),(115,'44458','Banco do Brasil S.A.','165050',118),(116,'2953-X ','Banco do Brasil S.A.','28.073-9',119),(117,'2953-x','Banco do Brasil S.A.','51315-6',120),(118,'43230','Banco do Brasil S.A.','125172',121),(119,'1414-1','Banco do Brasil S.A.','5501-8',122),(120,'2645-X','Banco do Brasil S.A.','17975-2',123),(121,'5789-4','Banco do Brasil S.A.','30222-8',124),(122,'1878-3','Banco do Brasil S.A.','12944-5',125),(123,'0566-5','Banco do Brasil S.A.','32750-6',126),(131,'16381','Banco do Brasil S.A.','223034',133),(125,'2953-X','Banco do Brasil S.A.','39964-7',127),(126,'1638-1','Banco do Brasil S.A.','34803-1',128),(127,'5789-4','Banco do Brasil S.A.','30220-1',129),(128,'4404-0','Banco do Brasil S.A.','13105-9',130),(129,'4323-0','Banco do Brasil S.A.','12518-0',131),(130,'1638-1','Banco do Brasil S.A.','28.293-6',132),(132,'5716-9','Banco do Brasil S.A.','32.173-7',134),(133,'5716-9','Banco do Brasil S.A.','29208-7',136),(134,'16381','Banco do Brasil S.A.','537942',137),(138,'57894','Banco do Brasil S.A.','394211',140),(139,'16128','Banco do Brasil S.A.','293288',141),(140,'16128','Banco do Brasil S.A.','293288',140),(141,'020-5','Banco do Brasil S.A.','1180371',142);
/*!40000 ALTER TABLE `dados_bancarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-14 11:03:00

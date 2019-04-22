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
-- Table structure for table `dados_oficial`
--

DROP TABLE IF EXISTS `dados_oficial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_oficial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corporacao` varchar(255) NOT NULL,
  `lotacao` varchar(255) NOT NULL,
  `matricula` varchar(255) NOT NULL,
  `nome_guerra` varchar(255) NOT NULL,
  `posto` varchar(255) NOT NULL,
  `quadro` varchar(255) DEFAULT NULL,
  `rg_militar` varchar(255) NOT NULL,
  `socio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh4qorct2myv4shneb8xdxb8kx` (`socio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_oficial`
--

LOCK TABLES `dados_oficial` WRITE;
/*!40000 ALTER TABLE `dados_oficial` DISABLE KEYS */;
INSERT INTO `dados_oficial` VALUES (1,'CBMMA','2º Batalhão de Bombeiros Militar','419271-00','Aragão','Capitão','QOC','2170',1),(2,'CBMMA','REFORMADO','32423','Robério','Coronel','QOC','3242',2),(3,'CBMMA','REFORMADO','234-2','Constantino','2º Tenente','QOA','423',3),(4,'CBMMA','Diretoria de Pessoal','816985-0','Claudio','1º Tenente','QOC','2306',4),(5,'CBMMA','BM/2','418752-1','ANTONIO DE','Tenente Coronel','QOC','0128',5),(6,'CBMMA','Diretoria de Pessoal','2222479','SILVA FILHO','1º Tenente','QOC','2289',6),(7,'CBMMA','ABMJM','00152042-02','QUADROS','Cadete','','2667',7),(8,'PMMA','CFAP','416857','Josemar','Major','QOC','14979',8),(9,'CBMMA','ABMJM','419311-01','Giovane','1º Tenente','QOC','2193/CBMMA ',9),(10,'CBMMA','Ciops','1712538','Diogo Antonio','Capitão','QOC','2148',10),(11,'CBMMA','4BBM','1578830','Willys','Major','QOC','2010',11),(12,'CBMMA','Comissão Setorial de Licitação','41740102','Romeu Costa','1º Tenente','QOC','2299',12),(13,'CBMMA','Ciops','419307-00','Pablo','1º Tenente','QOC','2208',13),(14,'CBMMA','ABMJM','00856608-00','Gabriela','Cadete','QOC','2675',14),(15,'CBMMA','2° CIBM Paço Lumiar','129692','S. Mendes','2º Tenente','QOA','0571',15),(16,'CBMMA','Terceira seção','419107-00','Janildo dos','Major','QOC','0170',16),(17,'CBMMA','12° BBM','419137-2','Isael','Major','QOC','2013',17),(18,'CBMMA','DP - CTA/SSP MA','811437-00','Nunes','1º Tenente','QOC','2296',18),(19,'CBMMA','BBMAR ','2020','Munilso ','Major','QOC','2020',19),(20,'CBMMA','ABMJM','866364-00','Lincon','Cadete','QOC','2740',20),(21,'CBMMA','Reserva Remunerada','0030064','Lauro','Coronel','QOC','0013',21),(22,'CBMMA','COCB-1','0132985','Robert','Coronel','QOC','0119',22),(23,'CBMMA','GAB COMANDO','0133090','AMARAL','Tenente Coronel','QOC','1038',23),(24,'CBMMA','7° BBM','1578822','HÉLIO','Major','QOC','2015',24),(25,'CBMMA','ABMJM','866359-0','Celso Filho','Cadete','','2748',25),(26,'CBMMA','Diretoria de inteligência ','823480','Ackson celso','1º Tenente','QOC','2478',26),(28,'CBMMA','6º BBM','849201-0','Ribamar','2º Tenente','QOC','2602',28),(29,'CBMMA','ABMJM','823490-00','ALLAN KARDEC','2º Tenente','QOC','2482',29),(30,'CBMMA','BBMAR','0084918700','Mendonça ','2º Tenente','QOC','2606',30),(31,'CBMMA','Diretoria de Inteligência','811443-00','Santos','1º Tenente','QOC','2287',31),(32,'CBMMA','ABMJM','1690569','Laurinalva Nívea Ferreira de','Major','QOC','2089',32),(33,'CBMMA','9ª CIBM - Santa INês','833724','FELIPE','2º Tenente','QOC','2442',33),(34,'CBMMA','4 Companhia Independente de Bombeiros Militar','00419296-00','Alécio','Capitão','QOC','2167',34),(35,'CBMMA','DP','82349300','ROBSON','1º Tenente','QOC','2486',35),(36,'CBMMA','R/R','0041816700','Jackson','Capitão','QOA','0118',36),(37,'CBMMA','RESERVA REMUNERADA´- CONTRATO COMANDO GERAL','862377-4','DELMIRO','Capitão','QOA','0026CBMMA',37),(38,'CBMMA','11 BATALHÃO DE BOMBEIROS MILITAR','419126-00','PATRÍCIO','Major','QOC','2018',38),(39,'CBMMA','Gabinete do cmdo','129189','Teixeira','Tenente Coronel','QOC','0183',39),(40,'CBMMA','csl/cbmma','419136-1','ALONSO RICARDO FURTADO DA SILVA','Major','QOC','2011',40),(41,'CBMMA','16 Companhia Independente de Bombeiros','418748-00','Lima','Major','QOC','1058',41),(42,'CBMMA','8° BBM','823487-0','ANDERSON','2º Tenente','QOC','2480',42),(43,'CBMMA','DIRETORIA DE FINANÇAS','00419127','Helton','Major','QOC','2023',43),(44,'CBMMA','4 BBM','00419303-00','Marcio Fernando','1º Tenente','QOC','2200',44),(45,'CBMMA','Coordenadoria Odontológica ','0041904800','Capitão Leudo','Capitão','QOE','0812 CBMMA ',45),(46,'CBMMA','Comissão Setorial de Licitação - CSL CBMMA','2311546','Brício','1º Tenente','QOC','2305',46),(47,'CBMMA','8°BBM Pinheiro','419252-00','Azevedo','Major','QOC','2158',47),(48,'CBMMA','BBMAR','419203-01','Jefferson','Capitão','QOC','2084 cbmma',48),(49,'CBMMA','2º BBM','419265-0','RENATO','Capitão','QOC','2163',49),(50,'CBMMA','1 Seção','133173','Walber','Major','QOC','0167',50),(51,'CBMMA','2º Batalhão de Bombeiros Militar','00817007','GENILSON','1º Tenente','QOC','2317',51),(52,'CBMMA','DIRETORIA DE APOIO LOGISTICO','419278-00','COQUEIRO','Capitão','QOC','2176',52),(53,'CBMMA','CMCB ROSÁRIO','0126391','BEZERRA','Tenente Coronel','QOC','0621',53),(54,'CBMMA','DAL','418463-0','Estácio','2º Tenente','QOE','0702',54),(55,'CBMMA','R/R','0041814500','Durans','Coronel','QOC','0014CBMMA',55),(56,'CBMMA','COMANDO GERAL ','418364','RODRIGUES ','Tenente Coronel','QOC','0276',56),(57,'CBMMA','CIOPS','1712447','Wenzel','Capitão','QOC','2153',57),(58,'CBMMA','QCG ','4185250','COSTA FILHO ','Tenente Coronel','QOC','167',58),(59,'CBMMA','DPM','104463','Rocha Silva ','Coronel','QOC','64',59),(60,'CBMMA','Bbem','1712504','Leonardo','Capitão','QOC','2156',60),(61,'CBMMA','COLÉGIO MILITAR 2 DE JULHO','00418917-00','MACEDO','Tenente Coronel','QOC','616 CBMMA',61),(62,'CBMMA','CIOPS BM','081331','GERSON CELSO','Tenente Coronel','QOC','0041 CBMMA',62),(63,'CBMMA','AJUDANCIA GERAL','131631','AMORIM','Tenente Coronel','QOC','856',63),(64,'CBMMA','São Luís','00856602-00','José Carlos','Cadete','QOC','2672',64),(65,'CBMMA','QCG','00418316-00','José Ribamar dos Santos','Coronel','QOC','035',65),(66,'CBMMA','DAL','00418386-00','P.JUNIOR','Capitão','QOE','0895',66),(67,'CBMMA','5ª Seção do EMG','1690692','Lisboa','Capitão','QOC','2114',67),(68,'CBMMA','5º Batalhão de Bombeiros Militar','00849192-00','Vinícius','2º Tenente','QOC','2605',68),(69,'CBMMA','CIOPS','00419282-00','Moraes ','Capitão','QOC','2180',69),(70,'CBMMA','BATALHÃO DE BOMBEIROS AMBIENTAL - BBA','0041927000','ALMEIDA','Capitão','QOC','2169',70),(71,'CBMMA','ABMJM','85659900','PAULO JOSÉ','Cadete','QOC','2666',71),(72,'CBMMA','10º BBM','00817001','EDUARDO','1º Tenente','QOC','2311603',72),(73,'PMMA','1a USC','1146919','HOLANDA','Major','QOC','14551',73),(74,'CBMMA','2 CIA Paço do Lumiar','828983-0','Laécio','2º Tenente','QOC','2447',74),(75,'CBMMA','11º Batalhão de Bombeiros Militar','00823491-00','Elenilton','2º Tenente','QOC','2483 CBMMA',75),(76,'CBMMA','Diretoria de Ensino e Pesquisa','816987','Guilherme','1º Tenente','QOC','2307',76);
/*!40000 ALTER TABLE `dados_oficial` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-21 12:44:17

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
-- Table structure for table `dependente`
--

DROP TABLE IF EXISTS `dependente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `parentesco` varchar(255) NOT NULL,
  `socio_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55e64w6iac9fsxw4l03kx46v` (`socio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=147 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependente`
--

LOCK TABLES `dependente` WRITE;
/*!40000 ALTER TABLE `dependente` DISABLE KEYS */;
INSERT INTO `dependente` VALUES (1,'Thais Maira Barbosa Brito','Cônjuge',1),(2,'Abraão Barbosa Brito','Filho(a)',1),(4,'Celiane Gracielle Pereira de Meneses Silva','Cônjuge',4),(5,'ClaudioAugusto Costa Pereira Filho','Filho(a)',4),(6,'NELIANA COSTA PINTO','Cônjuge',5),(7,'ARTHUR EVERTON PINTO COSTA','Filho(a)',5),(8,'JÉSSICA EVERTON PINTO COSTA','Filho(a)',5),(9,'Ediane Araujo Martins','Cônjuge',6),(10,'Luenny Maria Moraes Pinheiro Gomes','Cônjuge',10),(11,'MARCIELLI DA SILVA COELHO','Cônjuge',11),(12,'Luiziana Cunha Cosra','Cônjuge',12),(13,'Aylla Marjorie Cunha Costa','Filho(a)',12),(14,'Nicolas Romeu Cunha Costa','Filho(a)',12),(15,'Aron Sales Cunha Costa','Filho(a)',12),(16,'Sirlene Vieira da Silva','Cônjuge',15),(17,'Sérgio Murilo Soeiro Mendes Júnior','Filho(a)',15),(18,'Stephany Camilly Silva Mendes','Filho(a)',15),(19,'','Filho(a)',16),(20,'Isabela Tinoco Ribeiro','Cônjuge',18),(21,'Gabriel Tinoco Moreira','Filho(a)',18),(22,'Flávia Letícia Batista de Melo','Cônjuge',21),(23,'Lauro Enzo Batista de Melo','Filho(a)',21),(24,'Maria Cecília Batista de Melo','Filho(a)',21),(25,'Sergiane de Jesus','Cônjuge',22),(26,'Tacio Robert','Filho(a)',22),(27,'Mirela Sofia','Filho(a)',22),(28,'Giselle Mattteucci Vasconcelos Aamaral','Cônjuge',23),(29,'Miguel M. Vasconcelos Aamaral','Filho(a)',23),(30,'LILIAN DE SOUSA SENA','Cônjuge',24),(31,'ARTUR DE SOUSA SENA','Filho(a)',24),(32,'ALICE DE SOUSA SENA','Filho(a)',24),(33,'Alcionete Amarante Rodrigues','Cônjuge',28),(34,'Agatha Isabela Rodrigues Nascimento','Filho(a)',28),(35,'Heitor Aioros Rodrigues Nascimento','Filho(a)',28),(36,'01','Mãe',30),(37,'Anthony de Melo Silva','Filho(a)',32),(38,'Arthur de Melo Silva','Filho(a)',32),(39,'','Mãe',36),(40,'MARIA NASCIMENTO','Mãe',37),(41,'DAVI CHRISTHIAN DA GUIA PENHA','Filho(a)',38),(42,'PATRICIO SAMUEL DOS PASSOS PENHA','Filho(a)',38),(43,'FRANCISCO PATROCÍNIO DA SILVA PENHA','Pai',38),(44,'MANUELLA NOBRE DE SOUZA PENHA','Cônjuge',38),(45,'THIAGO SOUZA DE OLIVEIRA','Filho(a)',38),(46,'Isabel Rodrigues dos Santos','Cônjuge',39),(47,'Arthur Marlos dos Santos Teixeira','Filho(a)',39),(48,'Davi Marc dos Santos Teixeira ','Filho(a)',39),(49,'Walter Alves dos Santos','Pai',39),(65,'Ligia Fernanda Martins Costa Pereira','Cônjuge',49),(51,'carla rabelo pinheiro pinho furtado','Cônjuge',40),(52,'heitor pinheiro pinho furtado','Filho(a)',40),(53,'Herica Euslaide Dutra Lima','Cônjuge',41),(54,'Hallana Meykerlen Dutra Lima','Filho(a)',41),(55,'Wellington Nunes Lima Filho','Filho(a)',41),(56,'Erick Samuel Dutra Lima','Filho(a)',41),(57,'TAMARA CASTRO MACIEL PEREIRA','Cônjuge',42),(58,'Fabíola Andrade Lima Pereira','Cônjuge',43),(59,'Raphael Lorenzzo Lima Pereira','Filho(a)',43),(60,'Benício Lima Pereira','Filho(a)',43),(61,'','Filho(a)',45),(62,'Maria Vicente de Sousa','Cônjuge',47),(63,'Patricia Polyanna Nascimento Silva ','Cônjuge',48),(64,'Vinicius Silva Serra ','Filho(a)',48),(66,'Renata Costa Pereira','Filho(a)',49),(67,'Vandercleia de jesus sousa martins','Cônjuge',50),(68,'Anne caroline sousa martins','Filho(a)',50),(69,'José victor sousa martins','Filho(a)',50),(70,'Ana Maria Pereira de Carvalho','Mãe',51),(71,'Rayza Rayra Pinheiro Dias','Cônjuge',51),(72,'Sirley Rodrigues Galvao','Cônjuge',53),(73,'Ana Paula Galvao Gomes','Filho(a)',53),(74,'Ana Clara Galvao Pereira','Filho(a)',53),(75,'Vicente Borges Pereira','Pai',53),(76,'Natividade Bezerra Pereira','Mãe',53),(77,'Rafael Nascimento Rodrigues','Filho(a)',54),(78,'4','Filho(a)',55),(114,'JANE AZEVEDO RODRIGUES ','Cônjugue',56),(80,'PEDRO RAMON AZEVEDO RODRIGUES ','Filho(a)',56),(81,'RENAN FELIPE AZEVEDO RODRIGUES','Filho(a)',56),(82,'JOÃO GABRIEL LINHARES RODRIGUES ','Filho(a)',56),(83,'Diana Maria Chaves Silva Nicacio','Cônjugue',57),(84,'','Filho(a)',58),(85,'Irlene S L Silva','Cônjugue',59),(86,'Levi L R Silva','Filho(a)',59),(87,'TAISE BARROS MACEDO','Cônjugue',61),(88,'SENDY BARROS GONÇALVES','Filho(a)',61),(89,'ABEL RAIMUNDO MARTINS','Pai',61),(90,'MARIA DAS DORES MACEDO MARTINS','Mãe',61),(91,'Nelma Maria Cardoso Carvalho','Cônjugue',62),(92,'ZIMA FONSECA FRANÇA AMORIM','Cônjugue',63),(93,'ARTHUR FRANÇA AMORIM','Filho(a)',63),(94,'AMANDA ÍSIS FRANÇA AMORIM','Filho(a)',63),(95,'Ana Beatriz Brandão Loureiro','Cônjugue',65),(96,'Giovanna Loureiro dos Santos','Filho(a)',65),(97,'Joaquim Loureiro dos Santos','Filho(a)',65),(98,'Manoel Ferreira dos Santos','Pai',65),(99,'Patrícia Maciel de Aragão','Mãe',65),(100,'GARDENIA PEREIRA PIRES','Cônjugue',66),(101,'DIEGO HENRIQUE PEREIRA PIRES','Filho(a)',66),(102,'AMANDA CECÍLIA PEREIRA PIRES','Filho(a)',66),(103,'Thays de Sousa Lucena','Cônjugue',68),(104,'Letícia Lucena Moura','Filho(a)',68),(105,'Cintya Raquel Lima Pires Soares ','Cônjugue',69),(106,'Bruno Ricardo Lima Moraes ','Filho(a)',69),(107,'MARIANNA KATCHMAZENSKI VIANA','Filho(a)',71),(108,'enzo moreira sousa','Filho(a)',72),(109,'eva moreira sousa','Filho(a)',72),(110,'leticia d\'angelo moreira sousa','Cônjugue',72),(111,'RONAIRA PEREIRA HOLANDA SANTOS','Cônjugue',73),(112,'VANESSA NUNES HOLANDA SANTOS','Filho(a)',73),(113,'JOAO HOLANDA SANTOS FILHO','Filho(a)',73),(115,'Heitor Dominices Siqueira de Souza','Filho(a)',76),(116,'Thainá Paiva Siqueira de Souza','Cônjugue',76),(117,'Jane Rodrigues Pinto Mota','Cônjugue',78),(118,'Yasmin Rodrigues Pinto Mota','Filho(a)',78),(119,'Júlia Emily Rodrigues Pinto Mota','Filho(a)',78),(120,'Pedro lucas Oliveira melo','Filho(a)',80),(121,'Davi Luís Oliveira melo','Filho(a)',80),(122,'Joselea Oliveira costa','Cônjugue',80),(123,'Paulo César Coelho Pereira','Cônjugue',82),(124,'Samira Gusmão Oliveira ','Filho(a)',83),(125,'Geisa Amorim de Sousa Oliveira ','Cônjugue',83),(126,'Celene Letícia Barros Alves','Filho(a)',86),(127,'janilde de morais lopes','Cônjugue',87),(128,'ana carolina de morais lopes','Filho(a)',87),(129,'Nathalia Duarte Gomes','Cônjugue',89),(130,'2','Filho(a)',90),(131,'Maria de Jesus Sodré','Mãe',92),(132,'SILMARA MOREIRA COSTA','Cônjugue',93),(133,'Arthur de Melo Silva','Filho(a)',94),(134,'Anthony de Melo Silva','Filho(a)',94),(137,'CLAUDENICE SOUSA FROTA MOREIRA','Cônjuge',97),(138,'YURI RAFAEL FROTA MOREIRA','Filho(a)',97),(139,'Silmayre da Costa Vieira Siqueira','Cônjugue',99),(140,'Tiago de Oliveira Siqueira Junior','Filho(a)',99),(141,'Rstanyllea Cunha do Espirito Santo','Cônjugue',101),(142,'Rebecca Cunha do Espirito Santo','Filho(a)',101),(143,'Carlos Augusto Dourado do Espirito Santo','Pai',101),(144,'Ediluzia Cruz do Espirito Santo','Mãe',101),(145,'JOÃO ASLAN LEITE FERREIRA','Filho(a)',102),(146,'Isabela Ribeiro Nascimento Pereira','Cônjugue',103);
/*!40000 ALTER TABLE `dependente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-31 11:53:37

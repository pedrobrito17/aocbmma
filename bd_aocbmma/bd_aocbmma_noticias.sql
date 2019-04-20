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
-- Table structure for table `noticias`
--

DROP TABLE IF EXISTS `noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noticias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_postagem` datetime NOT NULL,
  `imagem` varchar(255) NOT NULL,
  `noticia` longtext NOT NULL,
  `titulo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticias`
--

LOCK TABLES `noticias` WRITE;
/*!40000 ALTER TABLE `noticias` DISABLE KEYS */;
INSERT INTO `noticias` VALUES (1,'2019-04-04 00:00:00','/uploads/img/noticias/2019/4/A AOCBMMA comparece a ALEMA para dialogar na Comissão de Segurança Pública.jpg','<p><span style=\"color: rgb(29, 33, 41); font-family: Helvetica, Arial, sans-serif; font-size: 14px;\">Estivemos presentes ontem na Assembleia Legislativa do MA dialogando na reunião da Comissão de Segurança Publica. No nosso entender a parte social do servidor militar deve ser também observada. Assistência social, Auxilio Fardamento, Auxilio Creche, Salario Família, etc devem ter atenção especial do Poder Legislativo, prc em razão do cumprimento das leis já em vigor. Alem da elaboração das leis o Legislativo deve primar pela fiscalização dos atos do Poder Executivo.</span><br></p>','A AOCBMMA comparece a ALEMA para dialogar na Comissão de Segurança Pública'),(2,'2019-04-03 03:00:00','/uploads/img/noticias/2019/4/AOCBMMA apresenta pedido para Comissão de Direito Militar da OAB.jpg','<p><span style=\"color: rgb(29, 33, 41); font-family: Helvetica, Arial, sans-serif; font-size: 14px;\">Estivemos ontem com a presidente da comissão de direito militar da OAB/MA dra Ana Carina e solicitamos que se faça um pedido de celeridade no IRDR que suspendeu as promoções por Ressarcimento por Preterição dos militares estaduais e apresentaremos pedido formal para apreciação da legislação em face de certas promoções somente pelo critério de merecimento.</span><br></p>','AOCBMMA apresenta pedido para Comissão de Direito Militar da OAB'),(3,'2019-04-03 03:00:00','/uploads/img/noticias/2019/4/Convocação para Assembleia Geral.jpg','<p>O Diretor Presidente da Associação dos Oficiais do Corpo de Bombeiros Militar do Maranhão (AOCBMMA), no uso de suas atribuições e obedecendo ao que preceitua os artigos 15, 16, 17, 18, 19, 20, 38, 39 e 40 do estatuto e os artigos 23, 36, incisos IV e 67 do regimento interno, todos pertencentes a AOCBMMA, convoca todos os sócios para reunirem-se em Assembleia Geral Extraordinária, a qual ocorrerá às 09h00min do dia 10 de abril de 2019, no Colégio Militar 2 de Julho, situado a avenida dos Franceses, Bairro da Vila Palmeira em São Luís - MA.</p>','Convocação para Assembleia Geral'),(4,'2019-04-03 03:00:00','/uploads/img/noticias/2019/4/Comunicado Público.jpg','<p>A Associação dos Oficiais do Corpo de Bombeiros Militar do Maranhão (AOCBMMA) em virtude de algumas dúvidas e queixas rotineiras informa ao público em geral que não tem ligação, não participa e nem apoia à venda de quaisquer cartelas do tipo bingo, sorteio ou similar com qualquer outra entidade associativa de cunho militar. </p><p>A intimidação velada ou direta para essa compra pode suscitar crime do tipo constrangimento ilegal ou ameaça a depender da situação. Antes de tudo solicite a identificação das pessoas que as oferecem.</p><p><br></p><p style=\"line-height: 1;\">Islandy Matões Amaral - Tenente Coronel Bombeiro Militar</p><p style=\"line-height: 1;\">Diretor Presidente da AOCBMMA</p>','Comunicado Público'),(6,'2019-04-13 00:00:00','/uploads/img/noticias/2019/4/Deputado Estadual apresenta emenda  à Constituição Estadual com vício de iniciativa.jpg','<p style=\"line-height: 1.4;\"><span style=\"text-align: justify; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; font-size: 18px; line-height: 107%; font-family: Arial, sans-serif;\">O\r\ndeputado estadual Rigo Teles (veja o link do vídeo abaixo) apresentou na última\r\nsemana uma emenda&nbsp;à Constituição do Estado do Maranhão tentando beneficiar\r\nos militares estaduais. Ocorre que existem detalhes importantes para que isso\r\nrealmente vire realidade. Primeiramente, a iniciativa desse assunto é de\r\ncompetência privativa do Governador do Estado. </span></p><p style=\"line-height: 1.4;\"><span style=\"text-align: justify; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; font-size: 18px; line-height: 107%; font-family: Arial, sans-serif;\">Al</span><span style=\"text-align: justify; font-size: 18px;\">é</span><span style=\"text-align: justify; font-size: 18px;\">m do mais vai gerar aumento de despesa. Outro aspecto, a apresentação de\r\nproposta de emenda&nbsp;</span><span style=\"text-align: justify; font-size: 18px;\">à</span><span style=\"text-align: justify; font-size: 18px;\">&nbsp;</span><span style=\"text-align: justify; font-size: 18px;\">constituição</span><span style=\"text-align: justify; font-size: 18px;\">&nbsp;estadual depende&nbsp;</span><span style=\"text-align: justify; font-size: 18px;\">de um terço, no mínimo, dos membros da Assembléia\r\nLegislativa. Quais os deputados que assinaram essa proposta</span><span style=\"text-align: justify; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; font-size: 18px; line-height: 107%; font-family: Arial, sans-serif; color: rgb(84, 84, 84);\">? A proposta de emenda nasce morta. É lamentável.</span><span style=\"font-size: 0.9em;\">&nbsp;</span></p><p style=\"line-height: 1.4;\"><span style=\"font-size: 0.9em;\"><br></span><a href=\"https://luiscardoso.com.br/politica/2019/04/rigo-teles-apresenta-emenda-a-constituicao-para-garantir-adicional-noturno-aos-militares-confira-no-video/\" target=\"_blank\" style=\"background-color: rgb(255, 255, 255); font-size: 0.9em;\">https://luiscardoso.com.br/politica/2019/04/rigo-teles-apresenta-emenda-a-constituicao-para-garantir-adicional-noturno-aos-militares-confira-no-video/</a><span style=\"font-size: 0.9em;\">&nbsp;</span></p><p class=\"MsoNormal\" style=\"text-align:justify\"><br></p>','Deputado Estadual apresenta emenda  à Constituição Estadual com vício de iniciativa');
/*!40000 ALTER TABLE `noticias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-14 22:10:00

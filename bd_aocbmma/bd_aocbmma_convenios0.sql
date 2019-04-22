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
-- Table structure for table `convenios`
--

DROP TABLE IF EXISTS `convenios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beneficio` longtext NOT NULL,
  `nome_empresa` varchar(255) NOT NULL,
  `path_logo` varchar(255) NOT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsvikbp9ekqaurflca60joqnto` (`categoria_id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenios`
--

LOCK TABLES `convenios` WRITE;
/*!40000 ALTER TABLE `convenios` DISABLE KEYS */;
INSERT INTO `convenios` VALUES (1,'<p style=\"line-height: 1;\">Ryan\r\n</p><p style=\"line-height: 1;\">(98) 9961-4786\r\n</p><p style=\"line-height: 1;\">(98) 98179-7480</p><p style=\"line-height: 1;\"><a href=\"https://www.extramed.com.br/entidade/cbmma\" target=\"_blank\">Acesse o site exclusivo para a AOCBMMA</a><br></p>','SulAmérica - plano de saúde e odontológico','/uploads/img/convenios/sulamerica.jpg',3),(2,'Desconto de 15% nas mensalidades.','Colégio Adventista','/uploads/img/convenios/adventista.png',1),(3,'<p style=\"line-height: 1;\"><span style=\"font-size: 14px;\">Desconto de 10% nos cursos abertos.</span></p><p style=\"margin-bottom: 0cm; line-height: 1;\"><font face=\"Arial, serif\"><font size=\"1\" style=\"font-size: 8pt\"><span style=\"font-size: 14px;\">Tel 98\r\n32121809</span></font></font></p><p style=\"line-height: 1;\"><span style=\"font-size: 14px;\">\r\n	\r\n	\r\n	</span><style type=\"text/css\"><span style=\"font-size: 14px;\">\r\n		@page { margin: 2cm }\r\n		p { margin-bottom: 0.25cm; direction: ltr; line-height: 115%; text-align: left; orphans: 2; widows: 2 }\r\n		a:link { color: #0000ff }\r\n	</span></style><span style=\"font-size: 14px;\">\r\n\r\n\r\n\r\n</span></p><p style=\"margin-bottom: 0cm; line-height: 1;\"><font face=\"Arial, serif\" style=\"\"><font style=\"font-size: 8pt\"><span style=\"font-size: 14px;\">Fax\r\n</span></font></font><font face=\"Times New Roman, serif\" style=\"\"><font style=\"font-size: 9pt;\"><span style=\"font-size: 14px;\">98\r\n3212 1887</span></font></font></p>','Instituto Euvaldo Ludi - IEL','/uploads/img/convenios/parceiro-iel.jpg',1),(4,'<p style=\"line-height: 1;\"><span style=\"font-size: 14px;\">Seguro de automóvel: 10% de desconto</span></p><p style=\"line-height: 1;\"><span style=\"font-size: 14px;\">Seguro residencial: 30% de desconto</span></p><p style=\"line-height: 1;\"><span style=\"font-size: 14px;\">Seguro de aparelhos portáteis: 15% de desconto\r\n</span></p><p style=\"line-height: 1;\"><span style=\"font-size: 14px;\">Seguro viagem: 15% de desconto\r\n</span></p><p style=\"line-height: 1;\"><span style=\"font-size: 14px;\">Demais ramos: 10%</span></p>','Champoudry Corretora','/uploads/img/convenios/champoudry.png',4),(5,'Desconto de 10% nos cursos.','SENAC','/uploads/img/convenios/senac.jpg',1),(6,'<p>Titula / Conveniado = R$ 75,00</p><p>Dependente / Conveniado (40%) - R$ 30,00</p><p>Expedição da 2ª via da carteira para Conveniado e Dependente = R$ 20,00</p>','SESC','/uploads/img/convenios/sesc.jpg',2),(7,'<p>Desconto de até 50% sobre o valor real do titulo\r\n</p><p>Desconto de 30% na bilheteria física no Valparaíso</p>','Valparaíso AcquaPark','/uploads/img/convenios/valparaiso.jpg',2),(8,'Desconto de 15% na diária.','Pousada Porto dos Ventos','/uploads/img/convenios/pousada.jpg',2),(9,'oberdan.costa@unicesumar.edu.br','UNICESUMAR - Centro de Ensino Superior de Marigá','/uploads/img/convenios/unicesumar.jpg',1),(10,'<p>Luiz Flávio Lopes</p><p>(98) 98318-0110</p>','Universidade Estácio de Sá','/uploads/img/convenios/estacio.jpg',1),(11,'Desconto de 10% a 30% sob a mensalidade.','Escola Educallis','/uploads/img/convenios/educallis.jpg',1),(12,'<p>Selmo</p><p>4003-6333</p>','Hapvida','/uploads/img/convenios/hapvida.jpg',3),(13,'<p>Dona Jesus</p><p>(98) 98815-9578</p><p>(98) 98115-0704</p><p>(98) 98728-2078</p><p>jesusconsultoriadesaude@hotmail.com</p><p>jesusconsultoriadesaude@hotmail.com</p>','AMIL','/uploads/img/convenios/amil.png',3),(15,'<p><a href=\"http://www.assego.com.br\" target=\"_blank\">acesse o site</a></p>','Associação dos Subtenentes e Sargentos do Estado de Goiás','/uploads/img/convenios/assego.png',2),(16,'<p>Dona Jesus</p><p><a href=\"http://www.aocbmma.com.br/files/tabela_amil.pdf\" target=\"_blank\">Clique aqui</a> e veja os planos.</p>','Allcare Benefícios','/uploads/img/convenios/allcare.png',3),(17,'Desconto de 15% nos planos mensais de musculação e 10% nos planos mensais de pilates.','Academia The Club','/uploads/img/convenios/academia_the_club.jpg',3),(18,'Desconto de 20% em qualquer produto ou serviço.','Espaço Mirian Eventos','/uploads/img/convenios/aluguel_brinquedos.jpg',4),(19,'<p><a href=\"http://www.aocbmma.com.br/files/tarifa_hotel.pdf\" target=\"_blank\">tabela de desconto</a><br></p>','Calhau Praia Hotel','/uploads/img/convenios/calhau.png',2),(20,'<p>Descontos:</p><p>15% residencial Porto Seguro</p><p>15% equipamentos portáteis (celular, máquina fotográfica, computador e tablet)</p><p>15% seguro viagem nacional ou internacional</p><p>Contato:</p><p>ryan.souza@pricecorretoradeseguros.com.br</p><p>(98) 98179-7480 whatsapp</p><p>(98) 98274-1111</p><p><a href=\"http://www.pricecorretoradeseguros.com.br\" target=\"_blank\">acesse o site</a><br></p>','Price Empresarial','/uploads/img/convenios/seguros.jpg',4),(21,'<p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b style=\"color: black;\">TARIFA (LINEAR) PROMO NET</b><span style=\"color: black;\">&nbsp;(sem COMISSÕES quaisquer) – a ser aplicada, junto</span><br></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">a&nbsp;<b>AOCBMMA em todo o ano de 2019.</b>&nbsp;&nbsp;</span><span style=\"color: rgb(31, 73, 125);\"><u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><u><span style=\"color: black;\">Todas elas INCLUEM CAFÉ(S) da MANHÃ, servido (s) no RESTAURANTE, e sobre elas, incidem 5%</span><span style=\"color: rgb(31, 73, 125);\"><u></u><u></u></span></u></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><u><span style=\"color: black;\">de ISS.<u></u><u></u></span></u></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\"><u></u>&nbsp;<u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">Apartamentos tipo LAGOA da LUA:<u></u><u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">SINGLE: R$ 198,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">DOUBLE: R$ 238,00.<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">Suítes tipo LAGOA BONITA:<u></u><u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">SINGLE: R$ 356,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">DOUBLE: R$ 396,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">TRIPLO: R$ 436,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">QUÁDRUPLO: R$ 475,00.<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\"><u></u>&nbsp;<u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">Em FERIADOS como CARNAVAL, PÁSCOA, PÁTRIA, CRIANÇAS, REPÚBLICA, bem como nos meses de<u></u><u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">JUNHO, JULHO e AGOSTO(ALTA ESTAÇÃO),&nbsp;<u>tais VALORES não são aplicados</u>, devendo estes NOVOS,<u></u><u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">serem tratados em iguais CONDIÇÕES, citadas acima:<u></u><u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\"><u></u>&nbsp;<u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">Apartamentos tipo LAGOA da LUA:<u></u><u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">SINGLE: R$ 277,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">DOUBLE: R$ 317,00.<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">Suítes tipo LAGOA BONITA:<u></u><u></u></span></b></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">SINGLE: R$ 436,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">DOUBLE: R$ 475,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">TRIPLO: R$ 515,00,<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\">QUÁDRUPLO: R$ 554,00.<u></u><u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><span style=\"color: black;\"><u></u>&nbsp;<u></u></span></p><p class=\"MsoNormal\" style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; color: rgb(34, 34, 34); font-family: Arial, Helvetica, sans-serif; font-size: small;\"><b><span style=\"color: black;\">TARIFAS do REVEILLON 2019/2020</span></b><span style=\"color: black;\">&nbsp;- SOB CONSULTAS, desde as RESERVAS e VENDAS.</span></p>','Gran Lençóis Flat Residence','/uploads/img/convenios/Gran Lençóis Flat Residence.jpg',2);
/*!40000 ALTER TABLE `convenios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-21 12:43:45

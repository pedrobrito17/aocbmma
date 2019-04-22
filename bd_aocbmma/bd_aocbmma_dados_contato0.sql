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
-- Table structure for table `dados_contato`
--

DROP TABLE IF EXISTS `dados_contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_contato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `cep` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `uf` varchar(255) NOT NULL,
  `whatsapp` varchar(255) NOT NULL,
  `socio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmaya97s6b9fevkbr122ulv0yq` (`socio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_contato`
--

LOCK TABLES `dados_contato` WRITE;
/*!40000 ALTER TABLE `dados_contato` DISABLE KEYS */;
INSERT INTO `dados_contato` VALUES (1,'Recanto dos Vinhais','','65070-400','São Luís','Condomínio Park Vinhais Bloco 06 Apartamento 802','aragao@cbm.ma.gov.br','Rua Plutão','','MA','(98) 98204-5453',1),(2,'Vila Bacanga','','65080-805','São Luís','','roberio@gmail.com','Avenida dos Portugueses','','MA','(98) 98204-5574',2),(3,'Vila Bacanga','','65080-805','São Luís','','constantino@gmail.com','Avenida dos Portugueses','','MA','(98) 92823-4278',3),(4,'','','65110-000','São José de Ribamar','Cond. Gran village Aracagi I Bl 4b ap 306','claudio.acp77@hotmail.com','','106','MA','(98) 98144-0718',4),(5,'Vila Embratel','(98) 99153-7622','65081-321','São Luís','','coronellisboa@outlook.com','Rua Oito','11','MA','(98) 98172-9955',5),(6,'Areinha','(98) 99212-2337','65030-015','São Luís','Cond. Village do atlantico','sebastianbastossilva@gmail.com','Avenida Senador Vitorino Freire','04','MA','(98) 98736-9355',6),(7,'','','65110-000','São José de Ribamar','ESTRADA DA MAIOBA, COND VILLAGE JARDINS 1','jribamar30@hotmail.com','','S/N','MA','(98) 98417-1983',7),(8,'Tirirical','(98) 98821-0998','65056-020','São Luís','Rua 07, Quadra 39, Casa 19 - Ipem São Cristóvão','josemar.junior84@gmail.com','Conjunto Henrique de La Roque','19','MA','(98) 98117-2030',8),(9,'','','65110-000','São José de Ribamar','','giovanems@hotmail.com','','05','MA','(99) 99906-3037',9),(10,'Vinhais','(98) 98703-7808','65070-780','São Luís','','diogoapg@hotmail.com','Rua Trinta e Dois','21','MA','(98) 98703-7808',10),(11,'','(99) 98816-9474','65800-000','Balsas','','wplnascimento1@gmail.com','','886','MA','(99) 98816-9474',11),(12,'Vila Vicente Fialho','','65070-280','São Luís','Cond. Pacifico 2','romecost@hotmail.com','Rua Laerte Santos','301 bl 14','MA','(98) 98848-5457',12),(13,'','(98) 99188-0507','65110-000','São José de Ribamar','Altos do jaguarema','pablomourabm@gmil.com','','16','MA','(98) 99188-0507',13),(14,'Cidade Operária','(98) 99608-1949','65058-111','São Luís','(Unidade 103)','gaby.nv@hotmail.com','Rua 06','65','MA','(98) 98188-7410',14),(15,'Turu','(98) 98848-3696','65066-320','São Luís','Cd Green Park Village','murilomendes1970@gmail.com','Rua General Artur Carvalho','502','MA','(98) 98449-8718',15),(16,'Recanto Fialho','(98) 98112-9945','65073-720','São Luís','Majestic residence','terann@gmail.com','Travessa Retiro Natal','26','MA','(98) 98812-9945',16),(17,'Santa Rita','(99) 98832-5663','65919-050','Imperatriz','','isaelbm@gmail.com','Avenida Newton Bello','683','MA','(99) 98832-5663',17),(18,'Jardim São Cristóvão','(98) 98736-8160','65055-370','São Luís','Quadra 128','bmnunes90@gmail.com','Rua Nova Betel','11','MA','(98) 98102-9849',18),(19,'Calhau','','65071-383','São Luís','306 ST Varandas Grand Park ','munilso@hotmail.com','Avenida Neiva Moreira','SN','MA','(98) 98776-0591',19),(20,'Jardim São Cristóvão II','(98) 98107-1582','65055-376','São Luís','Bloco 3 apt. 204','deolhonofuturo@outlook.com','Rua Dez','Condominio village del\'este1','MA','(98) 98107-1582',20),(21,'','','65130-000','Paço do Lumiar','Estrada da Maioba','ljrmelo.advogado@outlook.com','','127','MA','(98) 98768-8811',21),(22,'Recanto dos Vinhais','','65078-340','São Luís','','tcoronel_robert@hotmail.com','Rua Sirius','200','MA','(98) 98858-2240',22),(23,'Vinhais','','65070-170','São Luís','','tcoronelamaral@gmail.com','Residencial Juliana','01','MA','(98) 98912-7666',23),(24,'Parque Alvorada','','65634-590','Timon','','heliocleidilson@hotmail.com','Rua Poeta Castro Alves','660','MA','(86) 98869-3377',24),(25,'Alemanha','(98) 98894-9645','65036-815','São Luís','BL C AP 304','cjmalvesfilho@hotmail.com','Residencial Novo Tempo I','3981','MA','(98) 98228-3001',25),(26,'Monte Castelo','(98) 98735-1930','65030-280','São Luís','','ackson.celso@gmail.com','Rua Tolentino Machado','38','MA','(98) 98735-1930',26),(28,'','','65700-000','Bacabal','Rua 02, Alto Assunção','ribamarnascimento249@hotmail.com','','50','MA','(99) 98416-3262',28),(29,'Jardim São Cristóvão','(98) 98127-3147','65055-399','São Luís','Qd 211','allankardecmsn@gmail.com','1ª Travessa Nova Jerusalém','19','MA','(98) 98127-3147',29),(30,'','(98) 98185-5206','65110-000','São José de Ribamar','Rua 01 casa 14 1quadra 02 jardim aracagy 01 - cohatrac','thiagodutramendes@gmail.com','','14','MA','(98) 98185-5206',30),(31,'Pirapora','(98) 99906-1570','65046-090','São Luís','Quadra I','filipe9muniz@hotmail.com','Rua Oliveiras','17','MA','(98) 98130-7204',31),(32,'','(98) 99178-9568','65130-000','Paço do Lumiar','Condomínio Amaral de Matos','nivea_melo@hotmail.com','','6','MA','(98) 98886-3068',32),(33,'Turu','(98) 99232-3889','65066-260','São Luís','cond. Acquare Village','felipecosta187bm@outlook.com','Rua Coronel Eurípedes Bezerra','14','MA','(98) 99232-3889',33),(34,'Santa Cruz','','65046-040','São Luís','','aleciomesquita@hotmail.com','Rua do Muro','09','MA','(98) 99993-8540',34),(35,'COHAB Anil III','(98) 98254-6307','65051-360','São Luís','RUA 28 PRAÇA 20','ivanrobson111@gmail.com','Praça Júlio Jacobsen','04','MA','(98) 98822-2925',35),(36,'Bacuri','(98) 99153-8327','65901-020','Imperatriz','','jacksoncostabm@gmail.com','Rua Leôncio Pires Dourado','1286','MA','(98) 99153-8327',36),(37,'Cohatrac IV','(98) 99908-1188','65054-780','São Luís','','delqobm@yahoo.com.br','Rua Vinte e Seis','24','MA','(98) 99908-1188',37),(38,'Calhau','(98) 98878-0819','65071-383','São Luís','BL Cerejeira Apto 208 Cond PQ das Árvores','patriciodanielpenha@gmail.com','Avenida Neiva Moreira','300','MA','(98) 98878-0819',38),(39,'Turu','(98) 98813-7933','65066-440','São Luís','','ts0970@hotmail.com','Rua da Vitória','234','MA','(98) 98415-8221',39),(40,'','(98) 98866-4250','65110-000','São José de Ribamar','','alonso.ricardo@hotmail.com','','03','MA','(98) 98866-4250',40),(41,'','(98) 98881-0860','65110-000','São José de Ribamar','','majbmlima@gmail.com','','25','MA','(98) 99181-7766',41),(42,'Cidade Operária','(98) 98819-6951','65058-039','São Luís','(Unidade 101)','lad.pereir@gmail.com','Rua 06','18','MA','(98) 98819-6951',42),(43,'','(98) 98804-4853','65110-000','São José de Ribamar','Rua 5 QD 12 LT alto do jaguarema','heltonpereira2@hotmail.com','','cs 9','MA','(98) 98804-4853',43),(44,'','(99) 98827-9997','65065-000','','Qd 51 casa 7','marciofernando007@hotmail.com','','Rua 13','','(98) 98791-4502',44),(45,'Fátima','(98) 98287-0447','65030-001','São Luís','de 446 a 474 - lado par','laleudo@gmail.com','Avenida Kennedy','1570','MA','(98) 98287-0447',45),(46,'Solar dos Lusitanos','(98) 98807-2880','65065-690','São Luís','Condomínio Jardim Europa, casa 125','bricio.almeida@yahoo.com.br','Rua Desterro','18','MA','(98) 98807-2880',46),(47,'João Paulo','(98) 98208-7017','65040-430','São Luís','','maurelioef@gmail.com','Rua da Cerâmica','757','MA','(98) 98208-7014',47),(48,'','(98) 98100-4774','65074-625','','Quadra 03','jefferaonfserra@gmail.com','','18','','(98) 98100-4774',48),(49,'Jardim das Margaridas','','65052-866','São Luís','Quadra 06','renato_3670@hotmail.com','Avenida Principal','06','MA','(98) 98194-5326',49),(50,'Vila Vicente Fialho','(98) 98877-4749','65070-290','São Luís','Bloco 02 apt 04','walber.bene@gmail.com','Rua Luís Rocha','3537','MA','(98) 98877-4749',50),(51,'','(98) 98715-6064','65110-000','São José de Ribamar','Gran Village Aracagy II','tengenilson06@gmail.com','','Bloco-5 AP-04','MA','(98) 99968-3498',51),(52,'Chácara Brasil','','65066-873','São Luís','','LEONARDO_FC19@HOTMAIL.COM','Rua Piauí','37','MA','(98) 98735-8947',52),(53,'Anjo da Guarda','(98) 98845-7410','65086-060','São Luís','','bezerracbm98@gmail.com','Rua Canadá','35','MA','(98) 98289-4108',53),(54,'São Bernardo','(98) 98827-0938','65056-220','São Luís','Próximo a igreja quadrangular','estaciobm@gmail.com','Rua São Francisco','47','MA','(98) 98827-0938',54),(55,'Turu','','65066-190','São Luís','Condomínio Zeus III','jonasdurans@yahoo.com','Rua Boa Esperança','5, Qd 6','MA','(98) 98911-7491',55),(56,'Residencial São Domingos','(98) 98804-4869','65064-530','São Luís','Presidencial  São Domingos I','jrodriguesbm@hotmail.com','Rua A','18','MA','(98) 98804-4869',56),(57,'Jordoa','(98) 98466-1554','65040-730','São Luís','C','wenzelnicacio@hotmail.com','Rua Jesus Gomes','17','MA','(98) 98466-1554',57),(58,'','(98) 99618-2881','65077-115','','','majcfilho@gmail.com','','','','(98) 99618-2881',58),(59,'Calhau','','65071-415','São Luís','Cond. Jardins','coronelrochasilva@hotmail.com','Avenida Deputado Luís Eduardo Magalhães','S/n','MA','(98) 98502-4025',59),(60,'Angelim','(98) 99971-3892','65060-641','São Luís','Cond vite torre castanheira ap 601','retr0back@gmail.com','Avenida Jerônimo de Albuquerque Maranhão','0','MA','(98) 99971-3892',60),(61,'Cohama','(98) 98864-4963','65074-115','São Luís','ILHA PARQUE RESIDENCE','arnaldobmadv@gmail.com','Avenida Daniel de La Touche','APT 406, TORRE 4','MA','(98) 98118-6610',61),(62,'','981465969','65054-730','','Cohatrac IV','celsoamorimcelso@gmail.com','','15','','',62),(63,'Cohatrac IV','','65054-520','São Luís','QUADRA 35','smacbm@gmail.com','Rua Vinte','30','MA','(98) 98844-7571',63),(64,'São Bernardo','(98) 98248-8667','65055-710','São Luís','Quadra 15','zecajota@hotmail.com','Parque Sabiá','25','MA','(98) 98805-9102',64),(65,'Santa Cruz','','65045-290','São Luís','','ribaragao@oi.com.br','Rua Dezessete de Agosto','42','MA','(98) 98449-4127',65),(66,'Cidade Operária','(98) 98812-0188','65058-123','São Luís','(Res Ilhéus)','ALBYERY@HOTMAIL.COM','Rua 10 E','1','MA','(98) 98812-0188',66),(67,'Quitandinha','(98) 98125-8335','65070-628','São Luís','','jr.lisboa@hotmail.com','Alameda E','Condominio Brisas Life apto 705 Torre LAGO','MA','(98) 98125-8335',67),(68,'Dinir Silva','(86) 99965-2884','65605-325','Caxias','Quadra A','vncscarvalho10@gmail.com','Rua Grajaú','06','MA','(86) 99965-2884',68),(69,'Cutim Anil','(98) 98879-5709','65045-380','São Luís','Conde Eco Park bl 15','moraes.bm25@gmail.com','Avenida Edson Brandão','Apto 102','MA','(98) 98879-5709',69),(70,'Cidade Operária','(98) 99193-0659','65058-068','São Luís','(Unidade 103)','FDSALMEIDA@HOTMAIL.COM','Rua 13 D','04','MA','(98) 99193-0659',70),(71,'Vila Bacanga','(98) 99101-1953','65080-830','São Luís','','paulojoserv@hotmail.com','Rua Pereira Ramos','10','MA','(98) 98738-9811',71),(72,'Alameda dos Sonhos','(98) 98256-6619','65055-465','São Luís','','eduardofsbm@gmail.com','Rua Quarenta e Cinco','06','MA','(98) 98256-6619',72),(73,'Anil','(98) 98860-8018','65045-180','São Luís','','ykeira@gmail.com','Avenida Casemiro Júnior','221','MA','(98) 98860-8018',73),(74,'Cidade Operária','(98) 98201-7956','65058-185','São Luís','(Unidade 203)','laecio_10@hotmail.com','Rua 04','17','MA','(98) 98540-4948',74),(75,'','','65110-000','São José de Ribamar','Rua 06, quadra 12, Novo Cohatrac','elenilton.sousa@hotmail.com','','06','MA','(98) 98707-7956',75),(76,'Calhau','(98) 98434-6027','65071-383','São Luís','Cond GrandPark','guilherme_dominices@hotmail.com','Avenida Neiva Moreira','400','MA','(98) 98434-6027',76);
/*!40000 ALTER TABLE `dados_contato` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-21 12:43:37

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
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ativo` int(11) DEFAULT NULL,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `path_foto_perfil` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `situacao` varchar(255) DEFAULT NULL,
  `tipo_socio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (1,1,'001.881.933-83','1988-04-17','Pedro Ítalo Aragão Brito','/uploads/img/perfil/1.jpg','$2a$10$pTVTAp1yMo8OSdBdg3rpbO/cy.iLp4/yFRDcNg/Ip5C23RmFHtZ/a','ativo','efetivo'),(2,1,'766.632.692-08','1980-09-21','Roberio',NULL,'$2a$10$qZZGqQ5mSJqzjhWQoy8ht.0abDLAFIyFHWywx6xFMfxc9sRtxy9fW','ativo','efetivo'),(3,1,'766.632.692-08','1970-11-02','Constantino',NULL,'$2a$10$KPVl/F.ZiVM3tRhu4GlFt./h.10z0gJkjapg7rCz7IdBbvSn6qdwK','ativo','efetivo'),(4,1,'021.467.443-67','1985-05-24','Claudio Augusto Costa Pereira ',NULL,'$2a$10$QDKktjpUvfpF5baaGQk.UOExIjarzXF/j/6hevL3WYbG/r0SwQ18a','ativo','efetivo'),(5,1,'471.049.453-34','1972-03-31','ANTONIO DE LISBOA COSTA',NULL,'$2a$10$qxOETlxFobmkHgpsQmC5puSghaduedcLzPV2Teht7i1FK.S4ZkJAW','ativo','efetivo'),(6,1,'006.653.353-85','1984-12-19','Sebastiao bastos Silva filho','','$2a$10$MF/ySofboY448SyOp2zNTeHvw9b8uSMqP2z7FkZ7TsJ2xMpz8gXy2','ativo','efetivo'),(7,1,'037.311.213-01','1989-03-16','JOSÉ RIBAMAR PEREIRA QUADROS','/uploads/img/perfil/7.jpg','$2a$10$pv2VTuoJl/.qm1CE5kxJO.TAwJ.Ltwi/Pe/tZoSvjHamIElPrEcP.','ativo','efetivo'),(8,1,'005.129.013-84','1984-03-22','Josemar Costa Pinto Junior',NULL,'$2a$10$xS4s36qN6M1LrfxDz6P77.BXSzfqnKyjh2knAcO.VbSTG.px.w4O.','ativo','contribuinte'),(9,1,'972.890.353-72','1984-05-14','Giovane Mendonça Silva','/uploads/img/perfil/9jpeg','$2a$10$MVj1/6B7pUsXuT31N1xnAOFWHK4.ERnNCzKkPNzbIQquci/MlHTX2','ativo','efetivo'),(10,1,'019.535.433-83','1986-04-26','Diogo Antonio Paiva Gomes',NULL,'$2a$10$.g4s0CzgqdwQ7ljQnEIYM.zfvUfaVbT4c7U3sNtv8NySAnpMo9fcO','ativo','efetivo'),(11,1,'023.620.883-75','1987-08-20','Willys Pablo Leite do Nascimento',NULL,'$2a$10$OHIs1LLvc8CjYhD5tlYUBuJEeA4u/NUZRVxLi1WcOE3iq81GRfenG','ativo','efetivo'),(12,1,'959.551.513-20','1981-09-22','Leno Romeu Coelho Costa',NULL,'$2a$10$/kM.ocZI1TXzJ/Lam0hFbe0jmqDzxWxWNQq5dhBSqPP/eBCyREqaa','ativo','efetivo'),(13,1,'020.659.363-55','1987-07-01','Pablo moura machado',NULL,'$2a$10$fVff2zPUjqjt/KrrxVlprudxrCOt2uvLn8LL5VH6yR0cg79B0t5NO','ativo','efetivo'),(14,1,'602.665.693-66','1990-05-18','Ana Gabriela Nojosa Viegas',NULL,'$2a$10$b7QnHqPqIzcaTANlsJHV3OQv4tnR/WozBQvmtT/5ysoiaV//lYFpe','ativo','efetivo'),(15,1,'453.118.623-00','1970-11-05','Sergio Murilo Soeiro Mendes',NULL,'$2a$10$MREeIt9dBcyIGvUIAjXQu.EY.haYCmklHk3y8VATaaaUBBwgzhH92','ativo','efetivo'),(16,1,'751.801.973-68','1975-09-13','Janildo dos Santos Almeida',NULL,'$2a$10$KSinoBw3BiUe13chnUYpLumIK8v6iONdWf98iGzH0StHmWT1zvpMW','ativo','fundador'),(17,1,'854.823.153-04','1980-09-16','Isael Aguiar clChaves',NULL,'$2a$10$LHQJJ0Wg8xiVHzy6CCcqTuapuXbXACEtGCXDx06mbkbTIcUKvlKIK','ativo','efetivo'),(18,1,'937.070.613-53','1982-04-23','Cleyston José Raimundo Nunes Moreira',NULL,'$2a$10$x5kY6pVkolM9l6MnmR8Q8u2HTHs3LEXA7Z0CErffpQnHYhML2wwk2','ativo','efetivo'),(19,1,'754.199.473-15','2019-05-20','Munilso Rocha Costa Ferreira ',NULL,'$2a$10$VPhayVY5JUhmF37e76CG4uev9lP28nRy1xdLP9k89HdX8zR/AltxO','ativo','efetivo'),(20,1,'610.137.053-43','1999-09-20','Leandro Lincon de Sousa Silva',NULL,'$2a$10$eqQP9u0fkJR/jb8Mx79rZ.leQaUNNxumrUmUuIFwWwsfF5DZMJQS.','ativo','efetivo'),(21,1,'088.810.903-25','1958-12-25','Lauro de jesus Ribeiro de Melo',NULL,'$2a$10$HkwGndgIcwQxZ3Amgl0lxOaP1jJKwVA7i8SHv.E5/QD52pBdDtRtq','ativo','fundador'),(22,1,'508.720.013-34','1974-07-03','Márcio Robert Feitosa de Araújo ',NULL,'$2a$10$c.mlhMNOwRRkktQ5nTg6wOffK0i1QRZoCefIs1mucX.uO9La0PohC','ativo','fundador'),(23,1,'673.950.583-72','1975-05-23','ISLANDY MATOES AMARAL',NULL,'$2a$10$c8x8HmUpvy5M0k1AkSNKL.nbvkBdjXrfpk3x1TLdhYK1g463Xbbp6','ativo','fundador'),(24,1,'673.575.122-15','1982-04-20','HELIO CLEIDILSON DE OLIVEIRA SENA',NULL,'$2a$10$rC07bldjv5ksD7HCL2sQEODqNXHPdbSkAjsMfozsYgkgMUtf/MHc2','ativo','efetivo'),(25,1,'610.769.783-71','1998-01-27','Celso de Jesus Moraes Alves Filho',NULL,'$2a$10$i5ursU4o8HAV65kPyLyUE.zprJPJyCR6LzJms/ayq7PE1ddOBEyrW','ativo','efetivo'),(26,1,'036.668.573-29','1988-07-24','Ackson celso ribeiro pereira',NULL,'$2a$10$DtJUp2yHLh6RNandnaqP8ut.gPADzLLVj./cUA83g.rg0zqmkOSqi','ativo','efetivo'),(28,1,'044.891.183-33','1990-12-20','José de Ribamar Nascimento Silva Filho',NULL,'$2a$10$1xL8dyrgZ9sowbbDm.vT0.LI7VGhCB8hFLNIsCG6uvEiNQ7AYk5aa','ativo','efetivo'),(29,1,'050.432.503-56','1994-02-06','ALLAN KARDEC GARCEZ DE SOUSA',NULL,'$2a$10$EtOeqUbD.UDHWR20FqWNB.fW4oGuiIBjtMe1HId3ZNfsvwQ1Xo5r6','ativo','efetivo'),(30,1,'055.910.703-02','1995-02-07','THIAGO DUTRA MENDONCA',NULL,'$2a$10$LUGqRd7ApOEKLj9FHkW12O6gyMLg6niBCDh7/981GpsxHjw36zOIC','ativo','efetivo'),(31,1,'034.502.553-98','1989-07-29','Filipe dos Santos Muniz',NULL,'$2a$10$iApVbjh1kpxUmEuBw71oeuMDavmsS6EGqZO/9XQzIxrhNEZarqeVO','ativo','efetivo'),(32,1,'903.533.743-34','1981-11-10','Laurinalva Nívea Ferreira de Melo Silva',NULL,'$2a$10$9DlRFyavfcdYysl5ouiPf.biazzJ6iWrE.11xHeiXGPZx6chFpfqy','ativo','efetivo'),(33,1,'051.359.833-25','1994-04-17','FELIPE COSTA MENDES',NULL,'$2a$10$wJCIpbymGv405WQk0F.hY.KRd5q53oZ3/pUfv/buPCz35kWLjCBke','ativo','efetivo'),(34,1,'015.289.593-02','1987-08-13','Alécio Luan de Araújo Mesquita',NULL,'$2a$10$FQK4JDIMQ5vjLvV/JbNCfOh2gkVg/1kpNeu0mQN9j043o6rdz6pdu','ativo','efetivo'),(35,1,'034.036.413-09','1992-12-03','IVAN ROBSON RODRIGUES SILVA',NULL,'$2a$10$kTlyP5IT07gMpx9tvu2TB.kXcVfupzzPRvJ85vbMhsvgLirl8OkBC','ativo','efetivo'),(36,1,'250.738.773-49','1963-10-29','Jackson Nelson Reis Costa',NULL,'$2a$10$.mvkCfA4IOa1CgHgyKvvZuzzH3CgX48CtP9KutWhu5NRpLI4kJsKG','ativo','fundador'),(37,1,'125.471.823-00','1954-05-10','Delmiro Nascimento Mendes','','$2a$10$FCZbH22dk1dOfc7G0a9jCOSRorgbnMLEbirVWStNg/oBOzM0zvIxO','ativo','fundador'),(38,1,'012.734.661-95','1987-03-23','PATRÍCIO DANIEL DOS PASSOS PENHA',NULL,'$2a$10$Wl8QuTUZVnxXINYgvLuYmuxUMXEVlamHb2VDDP4aV3Yj2bHXY8YiG','ativo','efetivo'),(40,1,'008.803.303-17','1983-11-20','ALONSO RICARDO FURTADO DA SILVA ALONSO',NULL,'$2a$10$TIvm1RR8QKs7G7Uqa9.Ak./cqxwZx/noTuf0pFmeBx2DfZDsGijzi','ativo','efetivo'),(39,1,'700.825.881-04','1970-09-28','Manoel Teixeira Santos','','$2a$10$hEhQjJQ0OzHFnZEbMB/Tl.Aqj7/qDifdgCdphtLIKHFIzDJ35zRde','ativo','fundador'),(41,1,'719.701.183-34','1975-09-06','Wellington Nunes Lima',NULL,'$2a$10$Q2CJHYUxUcLEztkdK5OyFew52niPnM5wAvwGq2bm.rNDvtXj4NNhm','ativo','fundador'),(42,1,'012.731.643-42','1986-05-05','LEO ANDERSON DINIZ PEREIRA',NULL,'$2a$10$aHxn8GVACBKekPlrBomlOOJ9fMER/OVRTUWckh05PgZWxm9xpFpEe','ativo','efetivo'),(43,1,'004.637.143-50','1984-07-16','Helton Carlos Rodrigues Pereira',NULL,'$2a$10$bt8fZJVrA1Awo.EpYYllie1KGFYabnAXJYhPpkss/pVzxk17QFVIG','ativo','efetivo'),(44,1,'993.091.653-91','1982-09-15','Marcio fernando castro serra',NULL,'$2a$10$Hw9LgusgUKSw.qMVCf9FHu1UGKJhkCpgYux71ffN3cmyVoWKS6mtu','ativo','efetivo'),(45,1,'459.775.853-49','1972-09-15','Leudo Aquiles Ferreira de Sousa ',NULL,'$2a$10$/HixtubhaubZdkwJJzOCC.tC7uKrs33cMdjd14caYssVheRxBFieq','ativo','efetivo'),(46,1,'019.264.583-89','1993-06-03','Brício Vieira Almeida',NULL,'$2a$10$mo2SSbuaVAYVrG9kvQADA.3d1UvSIffnQb.UmLVcpDQvhpOYpvEd6','ativo','efetivo'),(47,1,'628.044.483-04','1979-06-17','Marcos Aurélio Azevedo Pereira',NULL,'$2a$10$vH9.bhYrmq51weUCu7IuNeY5g6samBkAVO0AGTdmbq.q5jMmLdGw6','ativo','efetivo'),(48,1,'964.201.623-00','1983-02-21','Jefferson Ferreira Serra ',NULL,'$2a$10$uNglEYzGwqk.aWKObxN.4uLiJ3dk8d6NEw52afEhY7NllYN33bh8.','ativo','efetivo'),(50,1,'562.856.473-72','1971-10-10','Walber Benedito dos Santoas Martins',NULL,'$2a$10$AjO5nx49lKklgI0fVbl7muYIacv4sg6LBKmb1Wu8a22rCdaDlOym.','ativo','efetivo'),(49,1,'025.496.393-59','1985-03-01','RENATO SOUSA PEREIRA',NULL,'$2a$10$xuDrMZvwrj6vnY7eFryeQOX57W9CjmI8Y8tm/RCw/1oirChUjjw5q','ativo','efetivo'),(51,1,'018.131.403-75','1986-01-06','GENILSON CARVALHO DIAS',NULL,'$2a$10$2C5RP3/EuJyos701urBb5OC3o5g4GJa4MDUucb8wPn5FyZm/JFoN.','ativo','efetivo'),(52,1,'018.372.543-38','1987-08-14','LEONARDO FURTADO COQUEIRO',NULL,'$2a$10$iIDiwG3pbUTk5vu61vDfE.ltAVSupDlCoXu5jNqIUoVdg18OvY88K','ativo','efetivo'),(53,1,'401.891.202-15','1971-10-20','JOSE CLAUDIO BEZERRA PEREIRA',NULL,'$2a$10$SNO1hRLNPPy1mv2nd5z1uu5831r1jJKuHEKZRyu2uYRJcLbc7mU5i','ativo','fundador'),(54,1,'705.077.323-91','1973-04-14','Estácio Pereira Rodrigues',NULL,'$2a$10$yz/cN/i7WUbIR7DbdWZWzusH93l3Q/wOc672zZ6yBps1aHFTi1QL6','ativo','efetivo'),(55,1,'288.974.043-91','1964-09-10','Jonas Batista Durans',NULL,'$2a$10$UDz7Oqw4iCWNBvocXNv1/emahUUlS22eP8iVz2pqZWVupe2I/VFeG','ativo','fundador'),(56,1,'444.603.253-49','2019-04-03','JUCIRAN RODRIGUES','','$2a$10$JsZWY4ybeqQmfEya6ioRy.9GiHVyOz5XGHX9Ny2qpD8TWjbzEe.uq','ativo','fundador'),(57,1,'961.585.903-63','1984-01-15','Wenzel Souza Nicacio',NULL,'$2a$10$n3lMedR9sQ97k/ndvsT9cO7oII.Ognb4Av4YTufzUP88tMQQycu9.','ativo','efetivo'),(58,1,'698.296.833-20','1975-12-17','JOSÉ RAIMUNDO COSTA FILHO ',NULL,'$2a$10$sOz21cpyrUWpuBrpYdtwveHVvHORbiq94idsJUTLUEHY4P9XQw0ta','ativo','fundador'),(59,1,'563.350.833-53','1970-12-03','Marco antonio rocha silva',NULL,'$2a$10$mXw6GeUjezan.tIbd161s.MbsmCf.HoYxe7upUFXaEy28QogajBSK','ativo','fundador'),(60,1,'011.176.433-52','1985-03-25','Leonardo Silva Mendonca',NULL,'$2a$10$xea.rLtc1MwgPJSDZ6Ev1eNSZzYeDZCpdcF33xY1gZfrVeu1PjvBu','ativo','efetivo'),(61,1,'352.865.393-00','1969-07-21','ARNALDO MARTINS MACEDO',NULL,'$2a$10$vDlWJ3A4Fxz.m2yRQSwDEOXGGWGjz8e0A9JsyYWBrjHSltwKjm/8a','ativo','efetivo'),(62,1,'26844966334','1969-07-13','GERSON CELSO AMORIM CARVALHO',NULL,'$2a$10$6hkTJ/oGKgQmsQ4zWG5YduJ6JUiheP9XSJ/.OmSvW4APAEcW3tO6G','ativo','fundador'),(63,1,'688.179.163-15','1975-04-15','SANDRO MACHADO AMORIM',NULL,'$2a$10$MZgwOj7Kh.sgbYf3aS6gI.T/f/.XG1BoTAQlqNJ1uWL9kMt7Vhbpq','ativo','fundador'),(64,1,'033.016.223-30','1990-06-06','José Carlos Araújo Ribeiro Júnior ',NULL,'$2a$10$TT0XAQYzpcKvSi7F11oqaeKcGH63kSEMEywPYByFPxnv5/D8wh7Ia','ativo','efetivo'),(65,1,'471.548.883-34','1971-11-05','José Ribamar dos Santos',NULL,'$2a$10$5YlSf5UyHO5bzRBxEg9Ch.37sat31i34vvA/hwcJ8FYS1C9bvfKIy','ativo','efetivo'),(66,1,'488.160.603-44','1973-04-01','ALBERTO HENRIQUE PIRES JUNIOR',NULL,'$2a$10$TCFqwH1ZkX61CpRxjBJjyeQn6xFazBGavAd6ZlqsLOfj3XtutEqd.','ativo','efetivo'),(67,1,'964.733.393-53','1984-04-18','José de Ribamar Mendes Lisboa',NULL,'$2a$10$RVMHTcvEjLYp6enhJyylBuEC4qkQUkxpv4AoVPVqI1dtl7txYuDuq','ativo','efetivo'),(68,1,'042.763.143-21','1990-12-24','Vinícius de Carvalho Moura',NULL,'$2a$10$KhqGoayHR5nM7evFWKha9uVNgHqxRPIVZGcC1OeMEqcGocArfxrTG','ativo','efetivo'),(69,1,'937.845.463-15','1982-06-28','Ricardo José de Moraes Soares ',NULL,'$2a$10$ILa.w0L9fDtG9qIdt18.3equBHrAAasRK6cgfF1HQ4dPJn3c211dK','ativo','efetivo'),(70,1,'020.601.963-70','1987-01-10','FABIANO DOS SANTOS ALMEIDA','/uploads/img/perfil/70.jpg','$2a$10$05t4B7FIr.e/ErhACE98QOyZPs/lhyrgCCDoiuXE79iUP4CCMSEde','ativo','efetivo'),(71,1,'968.628.233-53','1981-10-16','PAULO JOSE ROSA VIANA',NULL,'$2a$10$Ywxo9OwsiAvTchMmNNxIseJBSJpqTkytzMsDnQ0q8d8RXe1RWiPPS','ativo','efetivo'),(72,1,'051.618.083-57','1994-01-04','Eduardo furtado sosa',NULL,'$2a$10$pChOGTWo253bfSxeSJlFLekKlueSXTjisjyIQvEdajFsEGr5YIj/K','ativo','efetivo'),(73,1,'999.693.513-20','1984-03-04','JOAO HOLANDA SANTOS',NULL,'$2a$10$K04fFlVeB.A5IYyaAuLWSuJmiDYCr9yPaQuk5xZAu8E6UaFM5uewi','ativo','contribuinte'),(74,1,'035.193.563-09','1990-10-18','Laécio Gil Coelho Santos',NULL,'$2a$10$U3uWgrD6p058BnLjVxY2fOBdLsMVy1A22ANi1EwxHzaw23kZogYQO','ativo','efetivo'),(75,1,'037.057.243-20','1993-05-28','Elenilton Ribeiro de Sousa',NULL,'$2a$10$uFWoKH8NN/7/zuGGEjWe3eYbXwFP.7LpZyhAedjfnnfxkx/93fWc2','ativo','efetivo'),(76,1,'045.955.653-30','1994-04-27','Guilherme Dominices Baía Gomes de Souza',NULL,'$2a$10$Lu3wLxcbUBEdCDVd8RAY/e3JNGk4UKhPpDBmhyp6JHPltOrvwSj8y','ativo','efetivo');
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-21 12:43:28
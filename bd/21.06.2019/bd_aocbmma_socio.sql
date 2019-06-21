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
) ENGINE=MyISAM AUTO_INCREMENT=191 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (1,1,'001.881.933-83','1988-04-17','Pedro Ítalo Aragão Brito','/uploads/img/perfil/1.jpg','$2a$10$YSwILXvYdUWF38lhZ7WY/eQVielu8zy4DeQHaRcymXks0yU6uzDRi','ativo','efetivo'),(2,1,'766.632.692-08','1980-09-21','Roberio',NULL,'$2a$10$qZZGqQ5mSJqzjhWQoy8ht.0abDLAFIyFHWywx6xFMfxc9sRtxy9fW','ativo','efetivo'),(3,1,'766.632.692-08','1970-11-02','Constantino',NULL,'$2a$10$KPVl/F.ZiVM3tRhu4GlFt./h.10z0gJkjapg7rCz7IdBbvSn6qdwK','ativo','efetivo'),(4,1,'021.467.443-67','1985-05-24','Claudio Augusto Costa Pereira ',NULL,'$2a$10$QDKktjpUvfpF5baaGQk.UOExIjarzXF/j/6hevL3WYbG/r0SwQ18a','ativo','efetivo'),(5,1,'471.049.453-34','1972-03-31','ANTONIO DE LISBOA COSTA',NULL,'$2a$10$MD6BeLDdvksKERDTUpP0p.mb8nEp0X9EoET9Zq9jZ3M3U9SN3Youu','ativo','efetivo'),(6,1,'006.653.353-85','1984-12-19','Sebastiao bastos Silva filho','','$2a$10$MF/ySofboY448SyOp2zNTeHvw9b8uSMqP2z7FkZ7TsJ2xMpz8gXy2','ativo','efetivo'),(7,1,'037.311.213-01','1989-03-16','JOSÉ RIBAMAR PEREIRA QUADROS','/uploads/img/perfil/7.jpg','$2a$10$pv2VTuoJl/.qm1CE5kxJO.TAwJ.Ltwi/Pe/tZoSvjHamIElPrEcP.','ativo','efetivo'),(8,1,'005.129.013-84','1984-03-22','Josemar Costa Pinto Junior',NULL,'$2a$10$xS4s36qN6M1LrfxDz6P77.BXSzfqnKyjh2knAcO.VbSTG.px.w4O.','ativo','contribuinte'),(9,1,'972.890.353-72','1984-05-14','Giovane Mendonça Silva','/uploads/img/perfil/9.jpeg','$2a$10$MVj1/6B7pUsXuT31N1xnAOFWHK4.ERnNCzKkPNzbIQquci/MlHTX2','ativo','efetivo'),(10,1,'019.535.433-83','1986-04-26','Diogo Antonio Paiva Gomes',NULL,'$2a$10$.g4s0CzgqdwQ7ljQnEIYM.zfvUfaVbT4c7U3sNtv8NySAnpMo9fcO','ativo','efetivo'),(11,1,'023.620.883-75','1987-08-20','Willys Pablo Leite do Nascimento',NULL,'$2a$10$OHIs1LLvc8CjYhD5tlYUBuJEeA4u/NUZRVxLi1WcOE3iq81GRfenG','ativo','efetivo'),(12,1,'959.551.513-20','1981-09-22','Leno Romeu Coelho Costa','','$2a$10$D6FA2.lPlK4nY7wvuUY9f.SO8tA0zJ7jwfbVtSgsMRvt13KcQMlES','ativo','efetivo'),(13,1,'020.659.363-55','1987-07-01','Pablo moura machado','','$2a$10$fVff2zPUjqjt/KrrxVlprudxrCOt2uvLn8LL5VH6yR0cg79B0t5NO','ativo','efetivo'),(14,1,'602.665.693-66','1990-05-18','Ana Gabriela Nojosa Viegas',NULL,'$2a$10$b7QnHqPqIzcaTANlsJHV3OQv4tnR/WozBQvmtT/5ysoiaV//lYFpe','ativo','efetivo'),(15,1,'453.118.623-00','1970-11-05','Sergio Murilo Soeiro Mendes','','$2a$10$4OtrDSAOuyQp3j4AjFOxi.BfHRxjOkVoJC5fD2g.sfWfgDb8mkw5G','ativo','efetivo'),(16,1,'751.801.973-68','1975-09-13','Janildo dos Santos Almeida',NULL,'$2a$10$KSinoBw3BiUe13chnUYpLumIK8v6iONdWf98iGzH0StHmWT1zvpMW','ativo','fundador'),(17,1,'854.823.153-04','1980-09-16','Isael Aguiar clChaves',NULL,'$2a$10$LHQJJ0Wg8xiVHzy6CCcqTuapuXbXACEtGCXDx06mbkbTIcUKvlKIK','ativo','efetivo'),(18,1,'937.070.613-53','1982-04-23','Cleyston José Raimundo Nunes Moreira',NULL,'$2a$10$uWuMsQTPCdM5n2bVHyi2bOojrN7dPE0lUZA05WqrUM4uqdQu8GQc2','ativo','efetivo'),(19,1,'754.199.473-15','2019-05-20','Munilso Rocha Costa Ferreira ',NULL,'$2a$10$VPhayVY5JUhmF37e76CG4uev9lP28nRy1xdLP9k89HdX8zR/AltxO','ativo','efetivo'),(20,1,'610.137.053-43','1999-09-20','Leandro Lincon de Sousa Silva','/uploads/img/perfil/20.jpeg','$2a$10$eqQP9u0fkJR/jb8Mx79rZ.leQaUNNxumrUmUuIFwWwsfF5DZMJQS.','ativo','efetivo'),(21,1,'088.810.903-25','1958-12-25','Lauro de jesus Ribeiro de Melo','','$2a$10$HkwGndgIcwQxZ3Amgl0lxOaP1jJKwVA7i8SHv.E5/QD52pBdDtRtq','ativo','fundador'),(22,1,'508.720.013-34','1974-07-03','Márcio Robert Feitosa de Araújo ',NULL,'$2a$10$c.mlhMNOwRRkktQ5nTg6wOffK0i1QRZoCefIs1mucX.uO9La0PohC','ativo','fundador'),(23,1,'673.950.583-72','1975-05-23','ISLANDY MATOES AMARAL',NULL,'$2a$10$c8x8HmUpvy5M0k1AkSNKL.nbvkBdjXrfpk3x1TLdhYK1g463Xbbp6','ativo','fundador'),(24,1,'673.575.122-15','1982-04-20','HELIO CLEIDILSON DE OLIVEIRA SENA',NULL,'$2a$10$rC07bldjv5ksD7HCL2sQEODqNXHPdbSkAjsMfozsYgkgMUtf/MHc2','ativo','efetivo'),(25,1,'610.769.783-71','1998-01-27','Celso de Jesus Moraes Alves Filho',NULL,'$2a$10$i5ursU4o8HAV65kPyLyUE.zprJPJyCR6LzJms/ayq7PE1ddOBEyrW','ativo','efetivo'),(26,1,'036.668.573-29','1988-07-24','Ackson celso ribeiro pereira',NULL,'$2a$10$DtJUp2yHLh6RNandnaqP8ut.gPADzLLVj./cUA83g.rg0zqmkOSqi','ativo','efetivo'),(77,1,'020.742.153-63','1988-02-26','Giovane Costa Barros',NULL,'$2a$10$VwZFTKcUpXdNDdpxg4aNKeA5srhPRMAV3bp9HqsCseYaty.4LSeYG','ativo','efetivo'),(28,1,'044.891.183-33','1990-12-20','José de Ribamar Nascimento Silva Filho',NULL,'$2a$10$1xL8dyrgZ9sowbbDm.vT0.LI7VGhCB8hFLNIsCG6uvEiNQ7AYk5aa','ativo','efetivo'),(29,1,'050.432.503-56','1994-02-06','ALLAN KARDEC GARCEZ DE SOUSA','','$2a$10$R9N43fue0kQ7RXfIsvDuHe9deyxRlepvRDaR7eHWJxJNRxwqHJ30K','ativo','efetivo'),(30,1,'055.910.703-02','1995-02-07','THIAGO DUTRA MENDONCA',NULL,'$2a$10$Vk6U996ZlEsIO/QvTq9oKuP6RBREJaKZXsAqD9CEyKGTXySzbhoma','ativo','efetivo'),(31,1,'034.502.553-98','1989-07-29','Filipe dos Santos Muniz',NULL,'$2a$10$iApVbjh1kpxUmEuBw71oeuMDavmsS6EGqZO/9XQzIxrhNEZarqeVO','ativo','efetivo'),(32,1,'903.533.743-34','1981-11-10','Laurinalva Nívea Ferreira de Melo Silva',NULL,'$2a$10$9DlRFyavfcdYysl5ouiPf.biazzJ6iWrE.11xHeiXGPZx6chFpfqy','ativo','efetivo'),(33,1,'051.359.833-25','1994-04-17','FELIPE COSTA MENDES',NULL,'$2a$10$wJCIpbymGv405WQk0F.hY.KRd5q53oZ3/pUfv/buPCz35kWLjCBke','ativo','efetivo'),(34,1,'015.289.593-02','1987-08-13','Alécio Luan de Araújo Mesquita',NULL,'$2a$10$FQK4JDIMQ5vjLvV/JbNCfOh2gkVg/1kpNeu0mQN9j043o6rdz6pdu','ativo','efetivo'),(35,1,'034.036.413-09','1992-12-03','IVAN ROBSON RODRIGUES SILVA',NULL,'$2a$10$kTlyP5IT07gMpx9tvu2TB.kXcVfupzzPRvJ85vbMhsvgLirl8OkBC','ativo','efetivo'),(36,1,'250.738.773-49','1963-10-29','Jackson Nelson Reis Costa',NULL,'$2a$10$.mvkCfA4IOa1CgHgyKvvZuzzH3CgX48CtP9KutWhu5NRpLI4kJsKG','ativo','fundador'),(37,1,'125.471.823-00','1954-05-10','Delmiro Nascimento Mendes','','$2a$10$FCZbH22dk1dOfc7G0a9jCOSRorgbnMLEbirVWStNg/oBOzM0zvIxO','ativo','fundador'),(38,1,'012.734.661-95','1987-03-23','PATRÍCIO DANIEL DOS PASSOS PENHA',NULL,'$2a$10$Wl8QuTUZVnxXINYgvLuYmuxUMXEVlamHb2VDDP4aV3Yj2bHXY8YiG','ativo','efetivo'),(40,1,'008.803.303-17','1983-11-20','ALONSO RICARDO FURTADO DA SILVA ALONSO',NULL,'$2a$10$TIvm1RR8QKs7G7Uqa9.Ak./cqxwZx/noTuf0pFmeBx2DfZDsGijzi','ativo','efetivo'),(39,1,'700.825.881-04','1970-09-28','Manoel Teixeira Santos','','$2a$10$hEhQjJQ0OzHFnZEbMB/Tl.Aqj7/qDifdgCdphtLIKHFIzDJ35zRde','ativo','fundador'),(41,1,'719.701.183-34','1975-09-06','Wellington Nunes Lima','','$2a$10$Q2CJHYUxUcLEztkdK5OyFew52niPnM5wAvwGq2bm.rNDvtXj4NNhm','ativo','fundador'),(42,1,'012.731.643-42','1986-05-05','LEO ANDERSON DINIZ PEREIRA',NULL,'$2a$10$aHxn8GVACBKekPlrBomlOOJ9fMER/OVRTUWckh05PgZWxm9xpFpEe','ativo','efetivo'),(43,1,'004.637.143-50','1984-07-16','Helton Carlos Rodrigues Pereira',NULL,'$2a$10$bt8fZJVrA1Awo.EpYYllie1KGFYabnAXJYhPpkss/pVzxk17QFVIG','ativo','efetivo'),(44,1,'993.091.653-91','1982-09-15','Marcio fernando castro serra','','$2a$10$sAtPmcyatzVw7T4ZT7UWz.38J.9LKYM6J3/eCwEuEGBJoCFwQIgWG','ativo','efetivo'),(45,1,'459.775.853-49','1972-09-15','Leudo Aquiles Ferreira de Sousa ','/uploads/img/perfil/45.jpeg','$2a$10$/HixtubhaubZdkwJJzOCC.tC7uKrs33cMdjd14caYssVheRxBFieq','ativo','efetivo'),(46,1,'019.264.583-89','1993-06-03','Brício Vieira Almeida','','$2a$10$mo2SSbuaVAYVrG9kvQADA.3d1UvSIffnQb.UmLVcpDQvhpOYpvEd6','ativo','efetivo'),(47,1,'628.044.483-04','1979-06-17','Marcos Aurélio Azevedo Pereira',NULL,'$2a$10$vH9.bhYrmq51weUCu7IuNeY5g6samBkAVO0AGTdmbq.q5jMmLdGw6','ativo','efetivo'),(48,1,'964.201.623-00','1983-02-21','Jefferson Ferreira Serra ',NULL,'$2a$10$uNglEYzGwqk.aWKObxN.4uLiJ3dk8d6NEw52afEhY7NllYN33bh8.','ativo','efetivo'),(50,1,'562.856.473-72','1971-10-10','Walber Benedito dos Santoas Martins',NULL,'$2a$10$AjO5nx49lKklgI0fVbl7muYIacv4sg6LBKmb1Wu8a22rCdaDlOym.','ativo','efetivo'),(49,1,'025.496.393-59','1985-03-01','RENATO SOUSA PEREIRA',NULL,'$2a$10$IxUTjtnQUqOowzM2npKSlOciTSavN5dMCMPkHQWSiFjJz2OpykdwW','ativo','efetivo'),(51,1,'018.131.403-75','1986-01-06','GENILSON CARVALHO DIAS',NULL,'$2a$10$2C5RP3/EuJyos701urBb5OC3o5g4GJa4MDUucb8wPn5FyZm/JFoN.','ativo','efetivo'),(52,1,'018.372.543-38','1987-08-14','LEONARDO FURTADO COQUEIRO','','$2a$10$iIDiwG3pbUTk5vu61vDfE.ltAVSupDlCoXu5jNqIUoVdg18OvY88K','ativo','efetivo'),(53,1,'401.891.202-15','1971-10-20','JOSE CLAUDIO BEZERRA PEREIRA',NULL,'$2a$10$SNO1hRLNPPy1mv2nd5z1uu5831r1jJKuHEKZRyu2uYRJcLbc7mU5i','ativo','fundador'),(54,1,'705.077.323-91','1973-04-14','Estácio Pereira Rodrigues',NULL,'$2a$10$L6Vmy9xCJV/VpgVayglfDe0B7GtAgBDCA45X9fAP27ZcRvlK6bdhq','ativo','efetivo'),(55,1,'288.974.043-91','1964-09-10','Jonas Batista Durans',NULL,'$2a$10$UDz7Oqw4iCWNBvocXNv1/emahUUlS22eP8iVz2pqZWVupe2I/VFeG','ativo','fundador'),(56,1,'444.603.253-49','2019-04-03','JUCIRAN RODRIGUES','/uploads/img/perfil/56.jpg','$2a$10$JsZWY4ybeqQmfEya6ioRy.9GiHVyOz5XGHX9Ny2qpD8TWjbzEe.uq','ativo','fundador'),(57,1,'961.585.903-63','1984-01-15','Wenzel Souza Nicacio','','$2a$10$BG4q1arrDeAoVv9h995/auVqAVg50I8MHV486LAyIwSgpjLKAf/7a','ativo','efetivo'),(58,1,'698.296.833-20','1975-12-17','JOSÉ RAIMUNDO COSTA FILHO ',NULL,'$2a$10$sOz21cpyrUWpuBrpYdtwveHVvHORbiq94idsJUTLUEHY4P9XQw0ta','ativo','fundador'),(59,1,'563.350.833-53','1970-12-03','Marco antonio rocha silva',NULL,'$2a$10$mXw6GeUjezan.tIbd161s.MbsmCf.HoYxe7upUFXaEy28QogajBSK','ativo','fundador'),(60,1,'011.176.433-52','1985-03-25','Leonardo Silva Mendonca',NULL,'$2a$10$xea.rLtc1MwgPJSDZ6Ev1eNSZzYeDZCpdcF33xY1gZfrVeu1PjvBu','ativo','efetivo'),(61,1,'352.865.393-00','1969-07-21','ARNALDO MARTINS MACEDO',NULL,'$2a$10$u2OcQNMg26T0QjVrygyM5.KoANUNTyvO4a/2W4HSQDugqpD5xLSqe','ativo','efetivo'),(62,1,'268.449.663-34','1969-07-13','GERSON CELSO AMORIM CARVALHO','','$2a$10$6hkTJ/oGKgQmsQ4zWG5YduJ6JUiheP9XSJ/.OmSvW4APAEcW3tO6G','ativo','fundador'),(63,1,'688.179.163-15','1975-04-15','SANDRO MACHADO AMORIM',NULL,'$2a$10$MZgwOj7Kh.sgbYf3aS6gI.T/f/.XG1BoTAQlqNJ1uWL9kMt7Vhbpq','ativo','fundador'),(64,1,'033.016.223-30','1990-06-06','José Carlos Araújo Ribeiro Júnior ',NULL,'$2a$10$TT0XAQYzpcKvSi7F11oqaeKcGH63kSEMEywPYByFPxnv5/D8wh7Ia','ativo','efetivo'),(65,1,'471.548.883-34','1971-11-05','José Ribamar dos Santos',NULL,'$2a$10$5YlSf5UyHO5bzRBxEg9Ch.37sat31i34vvA/hwcJ8FYS1C9bvfKIy','ativo','efetivo'),(66,1,'488.160.603-44','1973-04-01','ALBERTO HENRIQUE PIRES JUNIOR',NULL,'$2a$10$7RdrJVcUF2GtRIzERpMD7eauVvaCAa/i19TX.znTfJc6m.DIS9UMa','ativo','efetivo'),(67,1,'964.733.393-53','1984-04-18','José de Ribamar Mendes Lisboa',NULL,'$2a$10$e3yy.Ovc8eZ4ro2gW0ZCHOsKxcxeV81JUbf8a4diTWzZlAmWMvFyW','ativo','efetivo'),(68,1,'042.763.143-21','1990-12-24','Vinícius de Carvalho Moura',NULL,'$2a$10$JZKKm/SQhkqfGq.SYWGIPuU3cTu3PUWEIATapqBMK1Ji3RNATdsPq','ativo','efetivo'),(69,1,'937.845.463-15','1982-06-28','Ricardo José de Moraes Soares ',NULL,'$2a$10$KJgx68lnUuTBs36vwiWN6.Y2ZF87c5AJlboJWAafmLFNj9SXrxMCa','ativo','efetivo'),(70,1,'020.601.963-70','1987-01-10','FABIANO DOS SANTOS ALMEIDA','/uploads/img/perfil/70.jpg','$2a$10$05t4B7FIr.e/ErhACE98QOyZPs/lhyrgCCDoiuXE79iUP4CCMSEde','ativo','efetivo'),(71,1,'968.628.233-53','1981-10-16','PAULO JOSE ROSA VIANA',NULL,'$2a$10$Ywxo9OwsiAvTchMmNNxIseJBSJpqTkytzMsDnQ0q8d8RXe1RWiPPS','ativo','efetivo'),(72,1,'051.618.083-57','1994-01-04','Eduardo furtado sosa',NULL,'$2a$10$pChOGTWo253bfSxeSJlFLekKlueSXTjisjyIQvEdajFsEGr5YIj/K','ativo','efetivo'),(73,1,'999.693.513-20','1984-03-04','JOAO HOLANDA SANTOS',NULL,'$2a$10$K04fFlVeB.A5IYyaAuLWSuJmiDYCr9yPaQuk5xZAu8E6UaFM5uewi','ativo','contribuinte'),(74,1,'035.193.563-09','1990-10-18','Laécio Gil Coelho Santos',NULL,'$2a$10$K.bbskuPuMK/yuyaxXffFeq3cEQP1IMrEATRTuraN06ohHm2WLjEG','ativo','efetivo'),(75,1,'037.057.243-20','1993-05-28','Elenilton Ribeiro de Sousa',NULL,'$2a$10$TYFVPjXL0v2CQkIseizj/uEc6QpMf3D1BpiJnkfZhkw7HjrqKaFv6','ativo','efetivo'),(76,1,'045.955.653-30','1994-04-27','Guilherme Dominices Baía Gomes de Souza',NULL,'$2a$10$Lu3wLxcbUBEdCDVd8RAY/e3JNGk4UKhPpDBmhyp6JHPltOrvwSj8y','ativo','efetivo'),(78,1,'476.089.353-91','1971-05-18','Carlos Joaquim Mota',NULL,'$2a$10$5S7e9M6g94VoRHhx4lIlQOsgxO8WMeJknVdRv198YHMd6Eq1yYzzy','ativo','efetivo'),(79,1,'004.148.313-81','1991-01-07','Sarah raquel Pinto Alves','/uploads/img/perfil/79.jpeg','$2a$10$CytCPuVUkJcDpJSyJ/G0z.9d.z51tvpS7GMNQGS7BrCl1vF5/oMya','ativo','efetivo'),(80,1,'961.829.463-34','1987-05-17','Claudio Roberto Rodrigues Melo ',NULL,'$2a$10$VewZ.lSQ3AldCClYr06kaOH9D14mhPvMM68oVzyFzn/toVldZIQDW','ativo','efetivo'),(81,1,'054.006.773-39','1992-07-06','Rafael Ferreira do Nascimento',NULL,'$2a$10$.eF8UgJqlfojmVEf6ZV1DuGTiQ0Zrm7n.yiGrFeAsqYCQDCnHX4z.','ativo','efetivo'),(82,1,'001.196.082-51','1990-03-30','Mayara Verusca do Nascimento Moreira',NULL,'$2a$10$T0T4CR5yH56BW9gExJ4HVOSyskkkBEvabyQODdSa3CDpGHwIaHtB6','ativo','efetivo'),(83,1,'405.419.403-68','1969-12-14','Emmanoel Ferreira Oliveira ',NULL,'$2a$10$6KDOKWgL8mDQ4ZY5bBanZuFnqRZ69LjPZLqm.QZ4wij/cIiF.KQV2','ativo','efetivo'),(84,1,'837.793.613-53','1979-08-20','GILZIMARY DE JESUS SOBRINHO PRIVADO',NULL,'$2a$10$J09oGoZwTr3P5c990j4tQ.gyYXNc/bxfy1PZbg2pvnfsu5UB6Iqc6','ativo','efetivo'),(85,1,'013.807.573-55','1985-11-17','Manuel Alves de Sousa Filho ',NULL,'$2a$10$Lp8HWnyS6mcwJivaswiSeuLpHSINTXHuKJqF7KO2AW56wsYO14xbq','ativo','efetivo'),(86,1,'418.354.683-49','2019-05-24','Celso de Jesus Moraes Alves',NULL,'$2a$10$nLT9pCRCsK9DxH46f4lcmed5AGmmX.5O.ivlFhaPfbxwikAu37r36','ativo','efetivo'),(87,1,'354.623.453-72','1970-02-01','paulo henrique fontes lopes',NULL,'$2a$10$VBDb9wtIzN.8NeSuv9JcOex/hd8lkbdy52OAOj7WSR4/gW4Xgf23C','ativo','efetivo'),(88,1,'054.593.163-08','1991-11-04','Adailson Raimundo Moreira Garcez Junior',NULL,'$2a$10$.le22ukcWn5yOkznkSWYZuyUh1p.6drApnFY9qsLn6ysl3BHKMARO','ativo','efetivo'),(89,1,'028.111.503-66','1988-05-10','Yuri Maia Pinheiro',NULL,'$2a$10$WzYb5UFJisVp42qkRkvrk.pHyxbzfsba0CT/6fAfscHtykQAHn4uC','ativo','efetivo'),(90,1,'968.383.613-53','1983-12-12','Josué Pereira Pinheiro',NULL,'$2a$10$Fo4B6NgvEQWoxSk7Yt/D5.J/1kMoK5ViuSpiSZrQp.o2gSKYI3KWu','ativo','efetivo'),(91,1,'281.965.113-53','1966-11-06','Paulo Sergio Reis Nascimento ',NULL,'$2a$10$81pbOzeyqUVjkJJO/QwwH.HThRfYo89xLma3eQZRYwgFM1jIrhxni','ativo','efetivo'),(92,1,'052.103.813-82','1993-08-19','Alessandro Sodré',NULL,'$2a$10$nyKFYDWxI/9ubN3DQ4df4.LV4MBkv0IjB0S81dwIj4jsIlzhL4AV.','ativo','efetivo'),(93,1,'003.922.773-10','1983-12-23','Cleiverlan Dias Freitas',NULL,'$2a$10$yH.Ht1V0GwTmKrEGd0UM8O4GbZXfPbmR4GPoJu7SL.LphR16v.7oW','ativo','efetivo'),(94,1,'000.461.793-21','1987-07-17','Ariosvaldo CAMPOS da Silva Júnior','/uploads/img/perfil/94.jpg','$2a$10$m/pnG5cH34Xixrr640BuvOBvFOuvH3CEVP0NtTpPdvqp38S7znEry','ativo','efetivo'),(95,1,'021.669.423-00','2019-05-13','YURY RIBEIRO CALISTO',NULL,'$2a$10$OxxQtMa9SOhsz.AUiysHVeDa.B130/nBjDIpwjGQSH1UWrjRkEX4C','ativo','efetivo'),(96,1,'246.753.503-72','1966-06-03','Maria Áurea Lira Feitosa',NULL,'$2a$10$hJ2IZ2CC1UkMzoGUSD4Ym.jrpD9jcbEA3yifyaEHnV5NDmk9edZiG','ativo','efetivo'),(97,1,'014.380.523-16','1983-07-10','MARCOS ALEXANDRE GONÇALVES MOREIRA',NULL,'$2a$10$nTVuWES6c2J.EB/ULAwzi.uJXs27T0RaaZZ8YCU2Qd.uhKE2MicZa','ativo','efetivo'),(98,1,'009.688.293-09','1986-09-28','RONES DA COSTA DE AQUINO',NULL,'$2a$10$J9UOM2avIMbWAOkxnDG4vOEH8LiDfnEU6ud/tCUtJXAxfV5DmRDLe','ativo','efetivo'),(99,1,'013.129.903-41','2019-06-30','TIAGO DE OLIVEIRA SIQUEIRA','','$2a$10$wz6BklXem0m0JibUTkTFyO6cGzSLKZaeTcafxXQTYegWWp3U2h0uO','ativo','efetivo'),(100,1,'038.770.583-02','1991-09-10','Júlio Cesar Barbosa Marins',NULL,'$2a$10$6tOZIUsjXFFtvenlwMCQu.sSJzrxL2bZENMz.Y.uaytrTWR2Y/Jp.','ativo','efetivo'),(101,1,'008.101.143-13','1984-12-04','CLEYTON CRUZ DO ESPIRITO SANTO','','$2a$10$SY3oAYpPqE4PcRTJMk0zae8LstECKdNw1KeUWCJcuIoNosv6KRD2.','ativo','efetivo'),(102,1,'048.333.393-07','1991-07-17','FLAVIO RICARDO SAMPAIO FERREIRA',NULL,'$2a$10$rShy5PCAqCo.cHifMuZVwOHY/RxDWCxloULDe3nB1khQaOXLGanje','ativo','efetivo'),(103,1,'025.496.373-05','1987-05-15','Thiago Sousa Pereira',NULL,'$2a$10$H6T5q2D6QiyhdkgHWsWsDOIeTQyKwmugHdlSlTvL6zhAxTRFHWAJi','ativo','efetivo'),(104,1,'215.242.543-04','1962-09-19','LISIANE BARROS PINHEIRO','','$2a$10$h3JIADEFmmvhVZfMLYrWmeSisgUEONr4S2.Q2LVYx/HuqF/tWZzM.','ativo','efetivo'),(105,1,'257.951.473-20','1964-04-07','Walterlino Epifanio Ferreira',NULL,'$2a$10$BNFsd8COTxR2i3kStaXz0.XrYU4EE096oHv1Y2yzQUpGHBfvDhfli','ativo','efetivo'),(106,1,'428.460.563-15','1969-12-15','RONILSON COSTA PEREIRA',NULL,'$2a$10$fN2txWaea8BVLlUM92tyFOxqRXzFmKqM8vTceeaTdoSGHO51Z2VaG','ativo','efetivo'),(107,1,'038.213.163-06','1990-10-29','ESDRAS EVANGELISTA MAIA SANTOS',NULL,'$2a$10$KuMchN2zkHvbXNkubq1hOOp7f2VehrNMl2nKTGMQKoKg0UbMro..y','ativo','efetivo'),(108,1,'029.807.913-50','1991-11-28','Nayane Priscilla Castro Nunes ',NULL,'$2a$10$C9XOM98mjdsqjNEFPCqACeEZfH4kttrUjwLLn9u91vJTv2yeZ2kNS','ativo','efetivo'),(109,1,'471.993.693-87','1973-07-15','Abner Ferreira de Carvalho ',NULL,'$2a$10$xGrhO66ZrP8ynFjyBM9tLe9BcUpeBFeX7oYI8r2heWHHCpxRG7x7y','ativo','fundador'),(110,1,'376.872.713-00','1969-08-04','Wibirajá Figueiredo Urbano',NULL,'$2a$10$qkC2UZ.jSEV4eSNk8VZRmO9QUxVW8AX3PUHRmgQJQaY5olZlUV0U6','ativo','fundador'),(111,1,'011.199.953-70','1984-11-17','Aquiles Batista dos Santos Soares',NULL,'$2a$10$1ATFfyzDq6.mimKmSZYEv.ps4m1dssTk9EcLBs1Eg91vMBLwVsAZ6','ativo','efetivo'),(118,1,'983.072.583-91','1983-03-06','Josimar Pinheiro Silva ',NULL,'$2a$10$um.qDDwr26dIi4SCjF0eyeXUxsqA7UoyXvyvnksmHC8aR4GOPpgoO','ativo','efetivo'),(117,1,'996.948.323-49','1983-05-19','Carlos Antonio Santos e Santos','','$2a$10$5x4qL1Ae6MxCa4j5.u/gu.Ql8WyqRGuIi.kj5n4qIIuNbUlMeT1C2','ativo','efetivo'),(116,1,'863.415.293-68','1980-09-07','WESCLEY PENHA SANTOS',NULL,'$2a$10$w3Hnx2qDCS8IhTLLlE6yVebcu3alGhQ1mY6ig7Z2WfJDgvLpgkndS','ativo','efetivo'),(115,1,'724.922.603-72','1974-09-17','ROBSON LEANDRO GOMES FERREIRA',NULL,'$2a$10$hCNy/gGp9iBWLHR425W0RO2m20hBuNBvE0x6fSokvJXcsJ.OqOqNS','ativo','efetivo'),(119,1,'257.424.503-20','1966-11-12','itamaracy rio preto monteiro de sousa',NULL,'$2a$10$3oTLmxWcz7kTRk5wo28vqO6U7YahLgLNh1tOPnZiVE2LW59wz4oFK','ativo','efetivo'),(145,1,'943.767.943-68','1969-06-29','LUZINALDO COLINS ALGARVIO',NULL,'$2a$10$6J3ICnVs.A3uDOX1TBxJY.HJbxAwRNBv1LWxXVog.GRz4jYnORNra','ativo','efetivo'),(121,1,'351.418.593-04','1968-12-24','João Luís Gonçalves Lima',NULL,'$2a$10$SBBWCIbzJNqzOJCPAO4AGutEpqWjSa1tZuKqwNc1/kDJtv3o1N7fS','ativo','fundador'),(122,1,'420.565.783-87','1971-01-06','MARCELLO SOARES SANTOS',NULL,'$2a$10$PJtm8ERI266qmqw2FquFCe0KpBJINikPVrAZ11mW1HaGmFupL5XSu','ativo','fundador'),(123,1,'281.965.113-53','1966-11-06','Paulo Sergio Reis Nascimento ',NULL,'$2a$10$q5KNN20iCcuaRRnEGh5mFOHRUqA/tFlhcCJbPTtXyPzzQ1Q8GBaVi','ativo','efetivo'),(124,1,'621.641.983-87','1981-09-09','MARCELO MARTINS RIBEIRO','/uploads/img/perfil/124.jpg','$2a$10$DtJsn4YfZHgPKslkvO4ze.n2yt0To1Pd8J1bs6Q.xepTH.uKjLwHu','ativo','efetivo'),(125,1,'081.049.303-97','1956-08-23','Getúlio da Silva Pereira',NULL,'$2a$10$aV8Yvpvj8Fx8Ip30FFhaV.PkvuptH6JiiqUqOYxQyfXa0uZz7r2Hm','ativo','fundador'),(126,1,'324.737.373-04','1963-07-29','Cláudio Pereira Balata ','','$2a$10$6QObcvyGJ5jVY.eTR9334OPAZM0yK4D/glGd90DiafcFsMEiAQb6O','ativo','efetivo'),(127,1,'021.199.743-90','1987-04-11','Yuri Beethovens Dutra Viana',NULL,'$2a$10$rzvpJ0T1F97APAeI28ZjE.w.0yh26j7MtPfr0KhssK6n6160bbEEm','ativo','efetivo'),(128,1,'176.342.373-53','1961-03-14','Pedro Neres de Sousa',NULL,'$2a$10$Cp63SUHWFHtAoxDNknXiSeHXSI4z/iX4b2EOzzj6jLEATStVGSbhe','ativo','efetivo'),(129,1,'969.280.773-87','1982-12-20','Paulo Rogério dos Santos Ribeiro',NULL,'$2a$10$aoiXR6q0kgYSJ3YY8oD3POAfhSAFBYscO8qGp9oyXa33srj6xrLES','ativo','efetivo'),(130,1,'474.520.053-68','1974-03-26','AURINALDO RODRIGUES COUTINHO',NULL,'$2a$10$yXaLySyA0irXlwSxBbcVWOwJva16SP2tGL52e8dtoy8ZNA4/N/WAm','ativo','efetivo'),(131,1,'292.734.393-49','1968-04-02','JOSÉ HENRIQUE PESSOA DE BRITO',NULL,'$2a$10$zYaINKQQHccFdz7KXju6kOYi/bg3SO/tHITicD7WMNsYvj1DtOwJO','ativo','fundador'),(132,1,'004.455.893-70','1985-01-08','Carlos Alberto Batista Júnior ','','$2a$10$YpSEj7MjgX5KzR85c3X5xOCr4CmVwW/Z6YBYnCXN7uBQbbdT61TMC','ativo','efetivo'),(133,1,'003.809.333-22','1983-01-03','Elzagno Viana dos Santos',NULL,'$2a$10$YNa8JP0rVZFO/a00ev5preLYnJTDs/YOcMA0WNgDwMn/YXdTDSGKO','ativo','efetivo'),(134,1,'268.912.983-34','1966-10-22','Mauro Roberto Ribeiro Silva',NULL,'$2a$10$VVIXsC4ZypQjGcSx0uhguO8HvrUR4IN7AxWJrYJkZH0oo/F.zeE1i','ativo','fundador'),(143,1,'001.834.572-77','1990-06-21','ROMEU LIMA PEREIRA',NULL,'$2a$10$hJb1GVzYqqqvf/VyhxdD1ONiaFUQv3ij7RIIk/VtpFM.AU2iEx5wK','ativo','efetivo'),(136,1,'095.275.243-34','1951-12-20','Domingos Pereira Santos',NULL,'$2a$10$RzRKPbmZMsxPN99i30.S4OxIp1xtmP45oVIg6TP.asaUc2JIyMRj6','ativo','efetivo'),(137,1,'853.939.322-00','2019-01-10','jonh carvalho correa',NULL,'$2a$10$3uHS/afa2cGfzRWZFoUOj.Sp1XvYxHdnsuxSK8ljuar1uhDC8ExhO','ativo','efetivo'),(142,0,'459.541.193-68','1970-09-07','GERSON DE NAZARE RIBEIRO FIGUEIREDO',NULL,'$2a$10$MGdwmC1D9BDxM1Y.JVs6NOKLbSUjLBsrx1qF76MMbdpmpiHInDJEu','inativo','efetivo'),(144,1,'459.541.193-68','1970-09-07','GERSON DE NAZARE RIBEIRO FIGUEIREDO',NULL,'$2a$10$BHqLDN573YNKRrogguQy5.oVK/BUqVOIpP5Cq5EeXntqkKso.BdwO','ativo','efetivo'),(155,1,'516.061.863-53','1973-07-11','WELLINGTON SOARES ARAUJO',NULL,'$2a$10$XS3IpompJWpbaxNCmNf0HOn4fKEg61b8LSC0k6lcGIoHg74f1p9AG','ativo','fundador'),(146,1,'706.439.203-82','1975-01-09','Ivaldo França Gonçalves','','$2a$10$NNqbix5JGOfkgR25ZLT42uDH8.y/aFYxbX3xXMKM0PNx/9KtBskmS','ativo','efetivo'),(147,1,'004.047.183-70','1982-11-28','Marcus Fernandes Neves ',NULL,'$2a$10$hHSVqk9QPbKwQqIRSpyFbu24k1gZi17Tv63hQOCJsJhKgBJimtGoi','ativo','efetivo'),(148,1,'044.483.973-94','1992-09-01','MATHEUS GOMES DE BARROS VASCONCELOS',NULL,'$2a$10$pCBUx9yUPOi3ao3FrFewUOLgquU90KiZbo4Z7HrmGAGwMuwkwRn3i','ativo','efetivo'),(149,0,'444.837.403-34','1972-04-16','ISRAEL LOPES ARAUJO',NULL,'$2a$10$JkOdXW2/dPMCXuBtsEii3uO0EQkhifHVKcFiiKUt3.gF8RgNXssGa','inativo','efetivo'),(150,1,'444.837.403-34','1972-04-16','ISRAEL LOPES ARAUJO',NULL,'$2a$10$wXoaQSTki4f.7eoShXRHeOT31wVpjiFxBDC2iIFZVldHPUq.vVLpC','ativo','efetivo'),(151,1,'475.939.973-91','1972-10-24','ADERBAL MALHEIROS FRANÇA NETO',NULL,'$2a$10$E1nZB.hzMXZ6bCIgJR4xRexhZFN70tsqtzyEJ8U0LMKBFGG2VMtEa','ativo','efetivo'),(152,1,'020.420.553-01','1986-03-07','WTSON RONATAS ROSA PEREIRA',NULL,'$2a$10$GVBbjuN2U6/Og5YoTT8cfe5slRGR2D9R7VkvfqH8h.V7Uc93d6h6K','ativo','efetivo'),(153,1,'026.483.763-05','1987-09-07','Deborah Thais Machado Barbosa','','$2a$10$HuoyyHpZsqGI1PcsbhAoFuC6YIaC/93EQKAODLOw25cEH/.s2a4ia','ativo','efetivo'),(154,1,'020.694.023-80','1984-10-08','FRANCK RONIEL FURTADO ARAÚJO',NULL,'$2a$10$WP4ZCMJpg.Eh3u8O6GutSeQCwVoCIhgJJxCKRBhaOrUd9.hPLKjQe','ativo','efetivo'),(156,1,'028.354.653-08','1988-08-01','DANILO FIGUEIREDO DA DANILO','','$2a$10$yCWBkbhAxC7qEeO90d2szOIBBNCsMkP.ub8gm9oB0E8/5EZhL77Qu','ativo','efetivo'),(157,1,'409.029.353-72','1971-03-03','Bernardo Cardoso dos Santos Filho',NULL,'$2a$10$hGWWnlXGDIxdwLiTs2s.5OZnSLPSpT9WJlGskX4.w3.ded8AEDIfO','ativo','efetivo'),(158,1,'418.489.003-25','1970-08-23','Gilberto Santos Rodrigues','/uploads/img/perfil/158.jpg','$2a$10$kCwHeAEIcY7/UJNXIHytP..dh8keMxtbUDbCM2hNLhUAOtiSmYktu','ativo','efetivo'),(159,1,'737.611.172-72','1981-12-08','Ricardo Cruz de castro ',NULL,'$2a$10$6b3qtCvWFuk/k5ZlRhLClOeQDACsb28cTyQot8PBqnYhGpa9r5EiG','ativo','efetivo'),(160,1,'010.160.803-95','1984-12-09','MARLISON SOARES CUNHA','','$2a$10$C5LBt4WWuxZboCWDsMb23.61S8dS/fdCf8n2DLoRWpII/1TLwi71i','ativo','efetivo'),(161,1,'964.201.623-00','1983-02-21','jefferson ferreira serra',NULL,'$2a$10$cHLihHNvf1wHf7auSmSc2e4ZE/IaeRPe.plBRT6givFvVfNss//yO','ativo','efetivo'),(162,1,'830.567.933-00','1980-09-30','Flaviano Farias Júnior',NULL,'$2a$10$XoTK.6YZNJJucxuKfHhImusxvmSu5jhH623WPPj63k8oeKELSaPjW','ativo','efetivo'),(163,1,'116.336.997-73','1985-10-11','MÁRCIO COSTA NASCIMENTO',NULL,'$2a$10$rNE.SAue.DHJXbusxh0NWeaNWsMDyM6mDileEw9ge2jvNu6x88YX.','ativo','efetivo'),(164,1,'661.834.213-91','1981-07-22','Francisco Robertt Sousa Pacheco',NULL,'$2a$10$ln/JOC2Ri5S0/ywJG1SPJO/XBfY134YNRqBnqGeGZJUk7i5Xq1dbS','ativo','efetivo'),(165,1,'647.008.103-78','1983-08-18','geovan aguiar rios',NULL,'$2a$10$V.A7EzWnVYCbQowKkp5tf.KFbAkiNF5HDCYOYlLhjBuOFbuq0ZKW6','ativo','efetivo'),(166,1,'288.405.693-91','1967-07-14','IZAC MUNIZ MATOS',NULL,'$2a$10$rK1otZsDqHT6FuFIa.prsu8Cm8TuVRlM23j/m/0QdGKZyH3PL5ogu','ativo','fundador'),(167,1,'000.049.143-84','1983-05-27','PAULO HENRIQUE FERNANDES OLIVEIRA',NULL,'$2a$10$bPDJjTBg/nLCECUPYCpTfuP4BuLyTTktHt2XFJMkv/vf5IA8rpiYK','ativo','efetivo'),(168,1,'614.958.403-87','1974-10-28','Nicolau Sauaia Junior',NULL,'$2a$10$8p.p8rgP4osWJ/xIXsoE8OT7zQY1HUzkfgSDP2Z9/A8wQVYRyAKoO','ativo','contribuinte'),(169,1,'602.230.373-70','1990-06-19','Marcel Soares mouzinho',NULL,'$2a$10$JPc3P7sAjvi96XwsMn/G/uJmeiDAJCSHRnIfeuoiWdIUIeFLLGfTm','ativo','efetivo'),(170,1,'012.926.983-22','1991-09-23','Jhéssyka Yasminni Lôbo Ferreira Fernandes Felicio ',NULL,'$2a$10$GB/E3e/wSreOEo6XuXK7H.WC4xt5nJB2FXgsC/wMGABLsF7K6/vdy','ativo','efetivo'),(171,1,'01174227389','1985-11-19','Sandra Raquel Pereira Santos',NULL,'$2a$10$xLqXSh5gVCRtY4jx75yVi.Aov5hfjACF2hJ7vLMoHFsTVqA0gvC/C','ativo','efetivo'),(172,1,'743.420.533-49','1978-05-12','Luis Cesar Silva Martins','','$2a$10$XRHJJVsDZ8r0obU2afA.te3fd0dg3rAHwUZRkGvxMeU3PAYSb72uO','ativo','efetivo'),(173,1,'035.278.203-02','1987-11-11','Aquiles Borges Braga',NULL,'$2a$10$/CJMkGs5VSfzyrioudV0wuJ94ldVl4c/ukp2GlDHt6NEeGBKYDCRG','ativo','efetivo'),(174,1,'959.665.443-87','1982-11-18','fernando fernandes de almeida','','$2a$10$FCAUhdX9NZ1aNLd2fL5Lse25BHG1AoPb.ANVMRXetd/npMCA49Spi','ativo','contribuinte'),(175,1,'970.110.373-49','1984-03-28','WEKESLEY DE ARAUJO CUTRIM',NULL,'$2a$10$I53MXlh8n1aeR0KC79YYhep/45entGvSZfgRTNLxSKXPCURP.GVYW','ativo','efetivo'),(176,1,'376.910.313-00','1970-05-20','Jone nascimento Rodrigues',NULL,'$2a$10$Pch0zcCE6iBPeTVJFg2HwuoR7A3BKCyyGRsqhDf0r8C/pgBrW6qSS','ativo','fundador'),(177,1,'693.509.733-91','2019-07-13','José Ribamar Silva Junior ',NULL,'$2a$10$aVPCO/D9RAyebZ5SEKY8.eZYxy08Nyv1jdTI4e54lL.cPyV/FCAWa','ativo','fundador'),(178,1,'003.309.413-64','1983-12-06','dante oliveira maia ',NULL,'$2a$10$8VH/3dS5UnAMcGuxs123VuPGZggBxXf/qWS.7rgLmnizsr1y4fRvW','ativo','efetivo'),(179,1,'505.273.393-34','1973-09-17','JHONWILSON NASCIMENTO RODRIGUES',NULL,'$2a$10$e1yvPm3k5lTKcYfTUcqtBuyV5QtBuGvPRkSRCb9d65Kvs7TCn/gmi','ativo','fundador'),(180,1,'477.322.372-34','1973-06-27','wellington oliveira dos reis',NULL,'$2a$10$xHxBViMibI2Ms6c63ToLCuTDEo9f9Hse93L59JWEbYuwULnlY/pNS','ativo','efetivo'),(181,1,'827.239.151-15','1978-04-09','DJANEIDE VIEIRA DA LUZ DOS REIS',NULL,'$2a$10$vb2Tyad5zR4y.a7CMGu.G.7M5S6tcq5T5ah6wu00OrBhniZ5zYcKq','ativo','efetivo'),(182,1,'017.277.773-95','1987-11-04','ERICA VANESSA DOS SANTOS LINDOSO',NULL,'$2a$10$6PCejCM5lSrQPzxE9/Ruqu6qbQrSyViO9KaOSo74zmH63a7/gc1bO','ativo','efetivo'),(183,1,'018.035.593-73','1988-08-18','André Silva Leite',NULL,'$2a$10$z3./.mn5N8jp2dsVgfvIq.I.9DjNKPTMRgalWL7QiQoN6DVhBnB8m','ativo','efetivo'),(184,1,'055.155.833-45','1993-02-27','CLAUDIO LENON SILVA NUNES','/uploads/img/perfil/184.jpg','$2a$10$j.4ELE4L/bapRiIDlb8MQumXyxJAHisKB9uwd8Y3VOqpFPX9Njwo2','ativo','efetivo'),(185,1,'271.954.223-72','1966-09-08','Luis Claudio dos Santos Milen',NULL,'$2a$10$/TfSoYcKaBxEppWW0.UE2ODNQx5xTAIcI0ROUwfCejRYwBe5IH70W','ativo','efetivo'),(186,1,'019.588.243-13','1991-01-12','Rennyson Marlon da Cruz Corrêa ',NULL,'$2a$10$bBIFQCG11.Qa9JQN621vcOcBKCWvWj2BTd7FXrCEBuJLOfL2nxolG','ativo','efetivo'),(187,1,'007.873.333-28','1985-07-28','Carlos Vinicius Souza ',NULL,'$2a$10$mSooY0rcbhK5/ZZixvLqk.3QbR5H3BoLYg1fkm.zO7Pa.ZZ1O.EXm','ativo','efetivo'),(188,1,'000.030.227-90','1969-01-24','MARCELO HENRIQUE SPINDOLA ',NULL,'$2a$10$IvMarldTXfBcR6UHXDo2puaj1zBBkN.gJc4YWvX.5Boe4n256Vram','ativo','fundador'),(189,1,'432.189.203-10','1975-02-05','Jacson Rodrigues Ribeiro ',NULL,'$2a$10$vGIc4tYA/H.i2jhcr14EmuhklgEgZ7Ke.W5Z1x984HZewUEsP5flm','ativo','efetivo'),(190,1,'459.435.083-68','1972-12-15','Paulo Cesar Mendes Santos',NULL,'$2a$10$sAoUi6h9Nd7RGfOe2u9e..myMycFqOL7IwwJP18Cz.kO7msZ94KYa','ativo','efetivo');
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

-- Dump completed on 2019-06-21 18:20:21

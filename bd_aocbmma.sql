CREATE DATABASE bd_aocbmma;

USE bd_aocbmma;

CREATE TABLE noticias(
	id int(10) NOT NULL primary key auto_increment,
    titulo varchar(255) NOT NULL,
    data_postagem date NOT NULL,
    imagem longblob NOT NULL,
    noticia text
);
CREATE DATABASE bd_aocbmma;

USE bd_aocbmma;

CREATE TABLE noticias(
	id int(10) NOT NULL primary key auto_increment,
    titulo varchar(255) NOT NULL,
    data_postagem date NOT NULL,
    imagem longblob NOT NULL,
    noticia longtext
);

CREATE TABLE convenios(
	id int(10) NOT NULL primary key auto_increment,
    nome_empresa varchar(255) NOT NULL,
    path_logo varchar(255) NOT NULL,
    beneficio text
);

CREATE TABLE categoria_convenios(
	id int(10) NOT NULL primary key auto_increment,
    categoria varchar(255) NOT NULL
);

select id, data_postagem, titulo from noticias order by id desc limit 4;

select * from convenios;
select * from categoria_convenio;
insert into categoria_convenio(categoria) values('Educação'),('Lazer'),('Saúde'),('Outros');

alter table convenios modify column beneficio longtext;

select * from noticias where titulo like '%reunião%'  ORDER BY id DESC;





INSERT INTO role(id,role) VALUES(1, 'SOCIO'),(2, 'ADMIN');
insert into categoria_convenio(categoria) values('Educação'),('Lazer'),('Saúde'),('Outros');
insert into chale(disponivel,preco_atual) values(true,30),(true,30),(false,30),(false,30);
insert into campo_futebol(disponivel,preco_atual_diurno,preco_atual_noturno) values(true,100,150);
insert into espaco_cajueiro(disponivel,preco_atual_diurno,preco_atual_noturno,preco_atual_diaria) values(true,100,150,250);

-- ALTER TABLE dados_oficial CHANGE COLUMN rg_militar rg_militar VARCHAR(255) NULL;
-- ALTER TABLE dados_oficial CHANGE COLUMN corporacao corporacao VARCHAR(255) NULL;
-- ALTER TABLE dados_oficial CHANGE COLUMN lotacao lotacao VARCHAR(255) NULL;
-- ALTER TABLE dados_oficial CHANGE COLUMN matricula matricula VARCHAR(255) NULL;
-- ALTER TABLE dados_oficial CHANGE COLUMN nome_guerra nome_guerra VARCHAR(255) NULL;
-- ALTER TABLE dados_oficial CHANGE COLUMN posto posto VARCHAR(255) NULL;
-- ALTER TABLE dados_oficial CHANGE COLUMN quadro quadro VARCHAR(255) NULL;

insert into socio_role values(1,2);
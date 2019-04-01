

INSERT INTO role(id,role) VALUES(1, 'SOCIO'),(2, 'ADMIN');
insert into categoria_convenio(categoria) values('Educação'),('Lazer'),('Saúde'),('Outros');
insert into chale(disponivel,preco_atual) values(true,30),(true,30),(false,30),(false,30);
insert into campo_futebol(disponivel,preco_atual_diurno,preco_atual_noturno) values(true,100,150);
insert into espaco_cajueiro(disponivel,preco_atual_diurno,preco_atual_noturno,preco_atual_diaria) values(true,100,150,250);

update socio set ativo=1,situacao='ativo' where id=1;
insert into socio_role values(1,2);

-- 06/04 (diaria) - cel roberio
-- 13/04 (diurno) - ten constantino
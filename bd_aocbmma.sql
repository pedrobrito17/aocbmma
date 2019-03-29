CREATE DATABASE bd_aocbmma;

USE bd_aocbmma;

select * from reserva_campo_futebol;

select * from reserva_chale;

insert into reserva_chale(data_entrada,data_saida,pagamento,chale_cod,socio_id) values('2019-04-01','2019-04-10','pendente',1,1);
insert into reserva_chale(data_entrada,data_saida,pagamento,chale_cod,socio_id) values('2019-04-05','2019-04-10','pendente',2,1);

select * from reserva_chale where data_entrada between '01/04/2019' and '08/04/2019' OR data_saida between '01/04/2019' and '11/04/2019';


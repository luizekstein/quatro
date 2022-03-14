create database 4four;

use 4four;

create table cliente(
id_cliente int primary key auto_increment,
nome_empresa varchar(45),
nicho varchar(45),
cnpj varchar(14),
plano varchar(45)
) auto_increment = 100;

create table usuario (
id_usuario int primary key auto_increment,
nome varchar(45),
login varchar(45),
senha varchar(45),
permissao varchar(45),
fk_cliente int,
foreign key (fk_cliente) references Cliente(id_cliente)
)auto_increment = 200;

create table ocorrencia (
id_ocorrencia int primary key auto_increment,
tipo_ocorrencia varchar(45),
descricao varchar(45),
statusOcorrencia varchar(45),
fk_usuario int,
fk_cliente int,
foreign key (fk_usuario) references usuario(id_usuario),
foreign key (fk_cliente) references cliente(id_cliente)
)auto_increment = 300;

create table servidor (
id_servidor int primary key auto_increment,
nome_servidor varchar(45),
memoria int,
ram int,
disco int,
fk_cliente int,
foreign key (fk_cliente) references cliente(id_cliente)
)auto_increment = 400;

create table copia_seguranca (
id_copia int primary key auto_increment,
conteudo varchar(1000),
data_geracao datetime,
fk_servidor int,
foreign key (fk_servidor) references servidor(id_servidor)
)auto_increment 500;

create table requisicao (
id_requisicao int primary key auto_increment,
tipoRequisicao varchar(45),
dtRequisicao datetime,
fk_servidor int,
foreign key (fk_servidor) references servidor(id_servidor)
)auto_increment = 600;

create table dado (
id_dado int primary key auto_increment,
registroMemoria int,
registroRam int,
registroDisco int,
dataRegistro datetime,
fk_servidor int,
foreign key (fk_servidor) references servidor(id_servidor)
)auto_increment = 700;

create table relatorio (
id_relatorio int primary key auto_increment,
analise varchar(1000),
data_relatorio datetime,
fk_dado int,
fk_servidor int,
foreign key (fk_dado) references dado(id_dado),
foreign key (fk_servidor) references servidor(id_servidor)
)auto_increment = 800;

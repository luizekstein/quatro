create database 4four;
use 4four;

create table dbo_client(
id_client int primary key auto_increment,
client_name varchar(45),
market_segment varchar(45),
cnpj varchar(14),
plan varchar(45),
client_password varchar(45),
proprietor varchar(45)
) auto_increment = 100;

select * from dbo_client;
insert into dbo_client values 
(null,'juan','teste','123','teste','teste','teste');

create table dbo_user(
id_user int primary key auto_increment,
user_name varchar(45),
email varchar(45),
user_password varchar(45),
fk_client int,
foreign key (fk_client) references dbo_client(id_client)
)auto_increment = 200;
	select * from dbo_user;
    select * from dbo_server;
    select * from dbo_client;	
create table dbo_server (
id_server int primary key auto_increment,
server_name varchar(45),
operational_system varchar(45),
ip varchar(45),
location varchar(45),
fk_client int,
foreign key (fk_client) references dbo_client(id_client)
)auto_increment = 300;

create table dbo_request (
id_request int primary key auto_increment,
location varchar(45),
request_date datetime,
fk_server int,
foreign key (fk_server) references dbo_server(id_server)
)auto_increment = 400;

create table dbo_unit_of_measurement(
id_unit_of_measurement int primary key auto_increment,
unit varchar(45)
)auto_increment = 500;

create table dbo_component(
id_component int primary key auto_increment,
item varchar(45),
size int,
temperature double,
speed float,
fk_server int,
foreign key (fk_server) references dbo_server(id_server)
) auto_increment = 600;

create table dbo_measurement(
id_measurement int primary key auto_increment,
measurement_usage double,
temperature double,
measurement_date datetime,
fk_unit int,
fk_component int,
foreign key (fk_unit) references dbo_unit_of_measurement(id_unit_of_measurement),
foreign key (fk_component) references dbo_component(id_component)
)auto_increment = 700;

create table dbo_alert(
id_alert int primary key auto_increment,
log varchar(1000),
alert_date datetime,
fk_measurement int,
foreign key (fk_measurement) references dbo_measurement(id_measurement)
)auto_increment = 800;


create database if not exists JavaWebApi56405;
use JavaWebApi56405;
-- drop table if exists usuarios;
create table if not exists usuarios(
	correo varchar(100) not null primary key,
	clave blob,-- poder encriptar la informacion 
	fechaCreacion date not null,
	fechaModificacion datetime not null
); 

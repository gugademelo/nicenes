create database nicenes;
use nicenes;
create table perfil (
	id_perfil int not null auto_increment,
    nome varchar(255),
    primary key (id_perfil)
);
CREATE TABLE usuario (
	id_usuario int not null auto_increment,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    id_perfil int not null,
    primary key (id_usuario),
    foreign key (id_perfil) references perfil (id_perfil)
);
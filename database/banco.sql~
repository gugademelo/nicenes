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

insert into perfil(nome) values("Adm");
insert into perfil(nome) values("Visitante");
insert into usuario(nome,email,senha,id_perfil) values ("UserTeste","admin@admin","admin",1);

create table categoria (
	id_categoria int not null auto_increment,
    categoria varchar(255),
    primary key (id_categoria)
);

create table editora(
	id_editora int not null auto_increment,
    nome varchar(255),
	endereco varchar(255),
	cidade varchar(255),
	uf varchar(255),
	pais varchar(255),
	cep varchar(255),
	fone varchar(255),
	cnpj varchar(255),
	razao varchar(255),
	web varchar(255),
    primary key (id_editora)
);





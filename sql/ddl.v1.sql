create table aluno (
	id int auto_increment primary key,
	nome varchar(20) not null,
	telefone varchar(14),
	endereco varchar(255),
	email varchar(40),
	matricula varchar(5) not null,
	cpf varchar(11)
);

create table professor (
	id int auto_increment primary key,
	nome varchar(20) not null,
	telefone varchar(14),
	endereco varchar(255),
	email varchar(40),
	registro varchar(5) not null,
	cpf varchar(11),
	salario float
);

create table disciplina (
	id int auto_increment primary key,
	nome varchar(20) not null,
	codigo varchar(10) not null,
	id_professor int not null,
	cargaHoraria int,
	foreign key (id_professor) references professor (id)
);

create table nota (
	id int auto_increment primary key,
	nota1 float,
	nota2 float,
	nota3 float,
	id_disciplina int not null,
	id_aluno int not null,
	foreign key (id_disciplina) references disciplina (id),
	foreign key (id_aluno) references aluno (id)
);
create table remedio(

	id bigint not null auto_increment,
	nome varchar(100) not null,
	via varchar(100) not null,
	lote varchar(100) not null,
    quantidade int not null,
	validade varchar(100) not null,
	laboratorio varchar(100) not null,
	boolean ativo not null default 1,
	primary key(id)
	);

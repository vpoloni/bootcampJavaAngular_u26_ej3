	drop table if exists venta;
	drop table if exists cajeros;
	drop table if exists productos;
	drop table if exists maquinas_registradoras;
	drop table if exists usuario;
	
	create table productos(
	id int auto_increment primary key,
	nombre varchar(255),
	precio int
	);
	
	create table maquinas_registradoras(
	id int auto_increment primary key,
	piso int
	);
	
	create table cajeros(
	id int auto_increment primary key,
	nombre varchar(255)
	);
	
	create table venta(
	id int auto_increment primary key,
	producto int,
	maquina_registradora int,
	cajero int,
	foreign key (producto) references productos(id)
	on update cascade on delete cascade,
	foreign key (maquina_registradora) references maquinas_registradoras(id)
	on update cascade on delete cascade,
	foreign key (cajero) references cajeros(id)
	on update cascade on delete cascade
	);
	
	create table usuario (
	id int primary key auto_increment,
	username varchar (300),
	password varchar (300),
	role varchar (300)
);
	
	
	insert into productos (nombre, precio) values
	('Producto A', 10),
	('Producto B', 20),
	('Producto C', 30),
	('Producto D', 40),
	('Producto E', 50);
	
	
	insert into maquinas_registradoras (piso) values (1), (2), (3), (4), (5);
	
	insert into cajeros (nombre) values
	('Veronika'),
	('Isidre'),
	('Marc'),
	('Jose'),
	('Adria');
	
	insert into venta (producto, maquina_registradora, cajero) values
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 5);

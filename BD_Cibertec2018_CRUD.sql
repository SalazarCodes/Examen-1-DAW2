use cibertec2018;

drop table Productos;

/*CREANDO TABLA PRODUCTO*/
create table Productos
(
idProducto varchar(20) primary key not null,
descripcion varchar(20) not null,
precio varchar(20) not null,
stock varchar(20) not null
);

/*CREANDO PROCEDIMIENTO ALMACENADO LISTADO*/
delimiter //
create procedure listar_productos()
begin
select * from Productos;
end; //

call listar_productos();


/*CREANDO PROCEDIMIENTO ALMACENADO AGREGAR*/
delimiter //
create procedure inserta_producto
(
id varchar(20),
descr varchar(20),
prec varchar(20),
stk varchar(20)
)
begin
insert into Productos(idProducto, descripcion, precio, stock)values(id,descr,prec,stk);
end; //

/*CREANDO PROCEDIMIENTO ALMACENADO MODIFICAR*/
delimiter //
create procedure editar_producto
(
id varchar(20),
descr varchar(20),
prec varchar(20),
stk varchar(20)
)
begin
update Productos set descripcion=descr,precio=prec,stock=stk where idProducto=id;
end; //

/*CREANDO PROCEDIMIENTO ALMACENADO ELIMINAR*/
delimiter //
create procedure elimina_producto(id varchar(20))
begin
	delete from Productos where idProducto=id;
end; //

/*CREANDO PROCEDIMIENTO ALMACENADO BUSCAR*/
delimiter //
create procedure buscar_producto(id varchar(20))
begin
	select * from Productos where idProducto = id;
end; //

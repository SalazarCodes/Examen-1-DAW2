use cibertec2018;

drop table Productos;

/*CREANDO TABLA PRODUCTO*/
create table Productos
(
IdProducto varchar(20) primary key not null,
Descripcion varchar(20) not null,
PrecioUnidad double not null,
Stock int not null
);

/*CREANDO PROCEDIMIENTO ALMACENADO LISTADO*/
delimiter //
create procedure ListarProductos()
begin
select * from Productos;
end; //

call ListarProductos();

insert into Productos(IdProducto,Descripcion,PrecioUnidad,Stock) 
values('PRO00001','Televisor',1500.00,10);
insert into Productos(IdProducto,Descripcion,PrecioUnidad,Stock) 
values('PRO00002','Lavadora',1800.00,15);
insert into Productos(IdProducto,Descripcion,PrecioUnidad,Stock) 
values('PRO00003','Refrigeradora',2200.00,5);

/*CREANDO PROCEDIMIENTO ALMACENADO AGREGAR*/
delimiter //
create procedure AgregarProductos
(
IdProducto varchar(20),
Descripcion varchar(20),
PrecioUnidad double,
Stock int
)
begin
insert into Productos(IdProducto,Descripcion,PrecioUnidad,Stock)values(IdProducto,Descripcion,PrecioUnidad,Stock);
end;//

call AgregarProductos('PRO00004','Play Station',4220.00,4);

/*CREANDO PROCEDIMIENTO ALMACENADO MODIFICAR*/
drop procedure ModificarProductos;
delimiter //
create procedure ModificarProductos
(
XIdProducto varchar(20),
XDescripcion varchar(20),
XPrecioUnidad double,
XStock int
)
begin
update Productos set Descripcion=XDescripcion,PrecioUnidad=XPrecioUnidad,Stock=XStock where IdProducto=XIdProducto;
end;//

call ModificarProductos('PRO00001','Monitor',5000.00,15);

/*CREANDO PROCEDIMIENTO ALMACENADO ELIMINAR*/
delimiter //
create procedure EliminarProductos(
XIdProducto varchar(20))
begin
	delete from Productos where IdProducto=XIdProducto;
end;//

call EliminarProductos('PRO00001');

/*CREANDO PROCEDIMIENTO ALMACENADO BUSCAR*/
delimiter //
create procedure BuscarProductos(
XIdProducto varchar(20))
begin
	select * from Productos where IdProducto = XIdProducto;
end;//

call BuscarProductos('PRO00002');

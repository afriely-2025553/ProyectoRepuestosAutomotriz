Drop database if exists DBRepuestosAutomotriz_in5cm; 
create database DBRepuestosAutomotriz_in5cm; 
use DBRepuestosAutomotriz_in5cm; 

create table Proveedores( 
		id_proveedor int auto_increment not null, 
		nombre_proveedor varchar(60) not null, 
		telefono_proveedor int not null, 
		direccion varchar(100) not null, 
		email_proveedor varchar(100) not null, 
		primary key PK_id_proveedor(id_proveedor) 
); 

create table Empleados( 
		id_empleado int auto_increment not null, 
		nombre_empleado varchar(60) not null, 
		apellido_empleado varchar(60) not null, 
		puesto_empleado varchar(20) null, 
		email_empleado varchar(100) not null, 
		primary key PK_id_empleado(id_empleado) 
); 

create table Repuestos( 
		id_repuesto int auto_increment not null, 
		nombre_repuesto varchar(60) not null, 
		categoria_repuesto varchar(60) not null, 
		precio_compra double not null, 
		precio_venta double not null, 
		id_proveedor int not null, 
		primary key PK_id_repuesto(id_repuesto), 
		constraint FK_repuesto_proveedor foreign key (id_proveedor)  
		references proveedores(id_proveedor) on delete cascade 
); 

create table Ventas( 
		id_venta int auto_increment not null, 
		fecha_venta date not null, 
		cantidad int not null, 
		total double not null, 
		id_empleado int not null, 
		id_repuesto int not null, 
		primary key PK_id_venta(id_venta), 
		constraint FK_ventas_empleado foreign key (id_empleado)  
		references Empleados(id_empleado) on delete cascade, 
		constraint FK_ventas_repuestos foreign key (id_repuesto)  
		references Repuestos(id_repuesto) on delete cascade 
);

--Mostrar proveedores--

delimiter //
	create procedure sp_MostrarProveedores()
		Begin 
        select id_proveedor, nombre_proveedor, telefono_proveedor, direccion, email_proveedor from Proveedores;
	End //
delimiter ;


delimiter //
	create procedure sp_IngresarProveedores(in nombre VARCHAR(60),
											in telefono int,
                                            in direccion varchar(100),   
                                            in email varchar(100)
)
		Begin
		insert into Proveedores(nombre_proveedor,telefono_proveedor,
                                direccion,email_proveedor)
				values (nombre, telefono, direccion, email);
End //
delimiter ;


call sp_IngresarProveedores('Distribuidora Central S.A.', 23456789, 'Avenida Reforma 10-20 zona 10, Ciudad de Guatemala', 'ventas@distribuidoracentral.com.gt');
call sp_IngresarProveedores('Suministros del Norte', 78945612, 'Calzada Roosevelt 25-30 zona 11, Mixco', 'contacto@suministrosnorte.com');
call sp_IngresarProveedores('Importadora La Económica', 24589632, '6a Avenida 12-45 zona 1, Ciudad de Guatemala', 'pedidos@laeconomica.com.gt');
call sp_IngresarProveedores('Comercial El Progreso', 58741236, 'Boulevard Liberación 18-50 zona 12', 'info@elprogreso.gt');
call sp_IngresarProveedores('Mayorista San José', 22334455, '4a Calle 8-60 zona 3, Ciudad de Guatemala', 'ventas@mayoristasanjose.com');
call sp_IngresarProveedores('Proveeduría Internacional GT', 24567890, 'Centro Comercial Miraflores, local 205, zona 11', 'compras@pigtl.com.gt');
call sp_IngresarProveedores('Distribuciones Rápidas', 77889900, 'Carretera a El Salvador km 10.5, zona 18', 'servicios@distrapidas.com');
call sp_IngresarProveedores('Almacén Universal', 23698741, '12 Avenida 5-30 zona 9, Ciudad de Guatemala', 'universal@almacen.com.gt');
call sp_IngresarProveedores('Suministros Industriales López', 66554433, 'Anillo Periférico 45-80 zona 7, Mixco', 'lopez@industriales.gt');
call sp_IngresarProveedores('Comercializadora del Pacífico', 24781596, 'Calzada Atanasio Tzul 22-15 zona 12', 'pacifico@comercial.com.gt');
call sp_MostrarProveedores;

-- actualizar Proveedores
delimiter //
	create procedure sp_ActualizarProveedor(in Id int, 
                                        in telefonoNuevo int,
                                        in direccionNueva varchar(100)
)
		begin
		update Proveedores
		set telefono_proveedor = telefonoNuevo,
				direccion = direccionNueva
		Where id_proveedor = Id;
End //

delimiter ;

-- Eliminar Proveedores
Delimiter //
	create procedure sp_EliminarProveedor(in Id int)
		begin
			delete from Proveedores
				where id_proveedor = Id;
end //

Delimiter ;

-- Mostrar Empleados
delimiter //
	create procedure sp_MostrarEmpleados()
		Begin 
        select id_empleado, nombre_empleado, apellido_empleado, puesto_empleado, email_empleado from Empleados;
	End //
delimiter ;

-- insertar empleados
delimiter //
	create procedure sp_IngresarEmpleados ( in nombre VARCHAR(60),
											in apellido varchar(60),
                                            in puesto varchar(20),   
                                            in email varchar(100)
)
		Begin
		insert into Empleados (nombre_empleado, apellido_empleado,
								puesto_empleado, email_empleado)
				values (nombre, apellido, puesto, email);
End //
delimiter ;

call sp_IngresarEmpleados('Mario', 'Martinez', 'gerente', 'mario.martinez@empresa.com');
call sp_IngresarEmpleados('Ana', 'Friely', 'Cajera', 'ana.friely@empresa.com');
call sp_IngresarEmpleados('Luis', 'Calderon', 'Vendedor', 'luis.calderon@empresa.com');
call sp_IngresarEmpleados('María', 'Rodríguez', 'Administradora', 'maria.rodriguez@empresa.com');
call sp_IngresarEmpleados('José', 'Martínez', 'Bodeguero', 'jose.martinez@empresa.com');
call sp_IngresarEmpleados('Laura', 'Fernandez', 'Vendedor', 'laura.fernandez@empresa.com');
call sp_IngresarEmpleados('Pedro', 'Ramírez', 'Cajero', 'pedro.ramirez@empresa.com');
call sp_IngresarEmpleados('Sofía', 'Cruz', 'Vendedora', 'sofia.cruz@empresa.com');
call sp_IngresarEmpleados('Miguel', 'Diaz', 'Supervisor', 'miguel.diaz@empresa.com');
call sp_IngresarEmpleados('Daniela', 'Ortiz', 'Vendedora', 'daniela.ortiz@empresa.com');
call sp_MostrarEmpleados();

-- Actualizar Empleados
delimiter //
create procedure sp_actualizarEmpleado( in p_idEmpleado int,
										in p_nombreEmpleado varchar(60),
										in p_apellidoEmpleado varchar(60),
										in p_puestoEmpleado varchar (20),
										in p_emailEmpleado varchar(100)
)
		begin
		update Empleado set nombre_empleado = p_nombreEmpleado,
							apellido_empleado = p_apellidoEmpleado, 
                            puesto_empleado = p_puestoEmpleado, 
                            email_empleado = p_emailEmpleado
		where id_empleado = p_idEmpleado;
End //
delimiter ;

-- Eliminar Empleado
delimiter //
create procedure sp_eliminarEmpleado(in p_idEmpleado int)
		begin
		delete from Empleados
        where id_empleado = p_idEmpleado;
end //
delimiter ;

-- Mostrar Repuestos
Delimiter //
create procedure sp_listar_repuestos()
begin
	select * from Repuestos;
end //
Delimiter ;

-- Agregar Repuestos
Delimiter //
create procedure sp_agregar_repuesto(in p_nombre varchar(60),
									 in p_categoria varchar(60), 
                                     in p_precio_compra double,
                                     in p_precio_venta double,
                                     in p_id_proveedor int)
BEGIN
	insert into Repuestos(nombre_repuesto, categoria_repuesto, 
						  precio_compra, precio_venta, id_proveedor)
			values (p_nombre, p_categoria,
					p_precio_compra,
                    p_precio_venta, p_id_proveedor);
end //
Delimiter ;
 
call sp_agregar_repuesto('Filtro de Aceite', 'Motor', 25.00, 40.00, 1);
call sp_agregar_repuesto('Bujía', 'Encendido', 15.00, 30.00, 2);
call sp_agregar_repuesto('Pastillas de Freno', 'Frenos', 80.00, 120.00, 3);
call sp_agregar_repuesto('Amortiguador', 'Suspensión', 150.00, 220.00, 4);
call sp_agregar_repuesto('Batería 12V', 'Eléctrico', 300.00, 420.00, 5);
call sp_agregar_repuesto('Correa de Distribución', 'Motor', 90.00, 150.00, 6);
call sp_agregar_repuesto('Radiador', 'Enfriamiento', 350.00, 520.00, 7);
call sp_agregar_repuesto('Alternador', 'Eléctrico', 400.00, 600.00, 8);
call sp_agregar_repuesto('Disco de Freno', 'Frenos', 110.00, 180.00, 9);
call sp_agregar_repuesto('Filtro de Aire', 'Motor', 20.00, 35.00, 10);
call sp_listar_repuestos();
 
 Delimiter //
create procedure sp_actualizar_repuesto(in p_id int,
										in p_nombre varchar(60),
                                        in p_categoria varchar(60),
                                        in p_precio_compra double,
                                        in p_precio_venta double,
                                        in p_id_proveedor int)
begin
	update Repuestos
	set nombre_repuesto = p_nombre,
	    categoria_repuesto = p_categoria,
	    precio_compra = p_precio_compra,
	    precio_venta = p_precio_venta,
	    id_proveedor = p_id_proveedor
	where id_repuesto = p_id;
end //
Delimiter ;

Delimiter //
create procedure sp_eliminar_repuesto(in p_id int)
begin
	delete from Repuestos 
    where id_repuesto = p_id;
end //
Delimiter ;

	-- Ventas
Delimiter //
create procedure sp_listar_ventas()
begin
	select * from Ventas;
end //
Delimiter ;
 
Delimiter //
create procedure sp_agregar_venta(in p_fecha date,in p_cantidad int,in p_total double,in p_id_empleado int,in p_id_repuesto int)
begin
	insert into Ventas(fecha_venta, 
					   cantidad, 
                       total, 
                       id_empleado, 
                       id_repuesto)
		values (p_fecha, 
				p_cantidad,
                p_total,
                p_id_empleado, 
                p_id_repuesto);
end //
Delimiter ;
 
call sp_agregar_venta('2026-02-11', 3, 80.00, 1, 1);
call sp_agregar_venta('2025-12-21', 4, 120.00, 2, 2);
call sp_agregar_venta('2026-01-12', 1, 120.00, 3, 3);
call sp_agregar_venta('2025-11-03', 2, 440.00, 4, 4);
call sp_agregar_venta('2026-01-14', 1, 420.00, 5, 5);
call sp_agregar_venta('2026-02-10', 3, 450.00, 6, 6);
call sp_agregar_venta('2026-01-16', 1, 520.00, 7, 7);
call sp_agregar_venta('2026-01-17', 2, 1200.00, 8, 8);
call sp_agregar_venta('2026-01-18', 2, 360.00, 9, 9);
call sp_agregar_venta('2026-01-25', 5, 175.00, 10, 10);
call sp_listar_ventas();
  
Delimiter //
create procedure sp_actualizar_venta(in p_id int,
									 in p_fecha date,
                                     in p_cantidad int,
                                     in p_total double,
                                     in p_id_empleado int,
                                     in p_id_repuesto int)
begin
	update Ventas
	set fecha_venta = p_fecha,
	    cantidad = p_cantidad,
	    total = p_total,
	    id_empleado = p_id_empleado,
	    id_repuesto = p_id_repuesto
	where id_venta = p_id;
end //
delimiter ;

Delimiter //
create procedure sp_eliminar_venta(in p_id int)
begin
	delete from Ventas where id_venta = p_id;
end //
Delimiter ;

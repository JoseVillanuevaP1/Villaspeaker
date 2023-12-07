INSERT INTO `categoria`(nombre)
VALUES ('Equipos de Sonido'),
       ('Accesorios para Celular'),
       ('Audífonos');

INSERT INTO `cliente`(apellidos, direccion, dni, email, nombres, password)
VALUES ('García', 'Av. Javier Prado 123', '12345678', 'juan.garcia@example.com', 'Juan', 'clave123'),
       ('Díaz', 'Jr. de la Unión 456', '87654321', 'maria.diaz@example.com', 'María', 'clave456'),
       ('Vargas', 'Av. Arequipa 789', '23456789', 'ana.vargas@example.com', 'Ana', 'clave789'),
       ('Pérez', 'Calle Los Pinos 321', '34567890', 'carlos.perez@example.com', 'Carlos', 'clave234'),
       ('López', 'Av. Tacna 987', '45678901', 'laura.lopez@example.com', 'Laura', 'clave567'),
       ('Jhon', 'Av. Javier Prado 123', '73612345', 'jhon.doe@example.com', 'Doe', 'clave123');

INSERT INTO `pago`(fecha, monto)
VALUES ('2023-12-04', 169.97);

INSERT INTO `compra`(fecha_compra, monto, id, idcliente, idpago, estado)
VALUES ('2023-12-04', 169.97, 1, 1, 1, 'pagado');

INSERT INTO `producto`
VALUES (129.99, 50, 6, 1, 'Parlante Bluetooth Cafini', 'parlante.jpg', 'Parlante Resistente al Agua'),
       (79.99, 40, 7, 1, 'Radio portátil con AM/FM', 'radio.jpg', 'Radio Portátil AM/FM'),
       (19.99, 100, 8, 2, 'Funda protectora para smartphone', 'funda.jpg', 'Funda Protectora para Smartphone'),
       (14.99, 80, 9, 2, 'Protector de pantalla de vidrio templado', 'protector_vidrio.jpg',
        'Protector de Pantalla de Vidrio Templado'),
       (69.99, 40, 10, 3, 'Audífonos inalámbricos deportivos', 'audifonos_deportivos.jpg',
        'Audífonos Inalámbricos Deportivos'),
       (49.99, 60, 11, 3, 'Audífonos inalámbricos Gamer', 'audifonos.jpg', 'Audífonos Inalámbricos Gamer');

INSERT INTO `detalle_compra`(cantidad, precio_compra, compra_id, idproducto, importe)
VALUES (1, 129.99, 1, 6, 129.99),
       (2, 19.99, 1, 8, 39.98);
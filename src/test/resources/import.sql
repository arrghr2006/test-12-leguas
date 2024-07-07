INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (1, '1111' ,'B73046', 'DIESEL', false, null);
INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (2, '1112' ,'B74045', 'DIESEL', false, null);
INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (3, '1113' ,'B75048', 'DIESEL', false, null);

INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (4, '1114' ,'B70046', 'GASOLINA', false, null);
INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (5, '1115' ,'B70145', 'GASOLINA', false, null);
INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (6, '1116' ,'B72048', 'GASOLINA', false, null);

INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (7, '1117' ,'B77041', 'ELECTRICO', false, null);
INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (8, '1118' ,'B75145', 'ELECTRICO', true, 'GASOLINA');
INSERT INTO vehiculo(id, vin, matricula, tipo, reconvertir, tipo_reconvertido) VALUES (9, '1119' ,'B77048', 'ELECTRICO', false, null);


INSERT INTO vehiculo_diesel(id, tipo_bomba_inyeccion) VALUES (1, 'LINEAL');
INSERT INTO vehiculo_diesel(id, tipo_bomba_inyeccion) VALUES (2, 'LINEAL');
INSERT INTO vehiculo_diesel(id, tipo_bomba_inyeccion) VALUES (3, 'ROTATORIA');

INSERT INTO vehiculo_gasolina(id, tipos_gasolina) VALUES (4, 'B94 B100');
INSERT INTO vehiculo_gasolina(id, tipos_gasolina) VALUES (5, 'B94 B100');
INSERT INTO vehiculo_gasolina(id, tipos_gasolina) VALUES (6, 'B83 B90 B94 B100');

INSERT INTO vehiculo_electrico(id, tipo_bateria, voltaje, corriente) VALUES (7, 'GEL', 365, 15);
INSERT INTO vehiculo_electrico(id, tipo_bateria, voltaje, corriente) VALUES (8, 'GEL', 375, 15);
INSERT INTO vehiculo_electrico(id, tipo_bateria, voltaje, corriente) VALUES (9, 'LITIO', 380, 18);

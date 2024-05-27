BEGIN TRANSACTION;

DROP TABLE IF EXISTS "billete";
DROP TABLE IF EXISTS "estacion";
DROP TABLE IF EXISTS "viajero";
DROP TABLE IF EXISTS "clase";

CREATE TABLE IF NOT EXISTS "clase" (
	"codigo"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"consumo_minimo_anual"	REAL NOT NULL,
	"porcentaje_adicional"	INTEGER NOT NULL,
	PRIMARY KEY("codigo" AUTOINCREMENT)
);

CREATE TABLE IF NOT EXISTS "viajero" (
	"codigo"	INTEGER NOT NULL,
	"codigo_clase"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"fecha_nacimiento"	TEXT NOT NULL,
	"lugar_residencia"	TEXT NOT NULL,
	"correo"	TEXT NOT NULL,
	"puntos"	INTEGER NOT NULL,
	FOREIGN KEY("codigo_clase") REFERENCES "clase"("codigo"),
	PRIMARY KEY("codigo" AUTOINCREMENT)
);

CREATE TABLE IF NOT EXISTS "estacion" (
	"codigo"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"ubicacion"	TEXT NOT NULL,
	"agno_inauguracion"	INTEGER NOT NULL,
	"vias"	INTEGER NOT NULL,
	PRIMARY KEY("codigo" AUTOINCREMENT)
);

CREATE TABLE IF NOT EXISTS "billete" (
	"codigo"	INTEGER NOT NULL,
	"codigo_viajero"	INTEGER NOT NULL,
	"codigo_estacion_origen"	INTEGER NOT NULL,
	"codigo_estacion_destino"	INTEGER NOT NULL,
	"fecha"	TEXT NOT NULL,
	"hora_salida"	TEXT NOT NULL,
	"hora_llegada"	TEXT NOT NULL,
	"importe"	REAL NOT NULL,
	FOREIGN KEY("codigo_viajero") REFERENCES "viajero"("codigo"),
	FOREIGN KEY("codigo_estacion_origen") REFERENCES "estacion"("codigo"),
	FOREIGN KEY("codigo_estacion_destino") REFERENCES "estacion"("codigo"),
	UNIQUE("codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada"),
	PRIMARY KEY("codigo" AUTOINCREMENT)
);

INSERT INTO "clase" ("codigo","nombre","consumo_minimo_anual","porcentaje_adicional") VALUES (1,'Bronce',300.0,10);
INSERT INTO "clase" ("codigo","nombre","consumo_minimo_anual","porcentaje_adicional") VALUES (2,'Plata',1000.0,25);
INSERT INTO "clase" ("codigo","nombre","consumo_minimo_anual","porcentaje_adicional") VALUES (3,'Oro',3000.0,50);
INSERT INTO "clase" ("codigo","nombre","consumo_minimo_anual","porcentaje_adicional") VALUES (4,'Platino',10000.0,75);

INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (1,1,'Alejandro Ruiz','29/10/1989','Zaragoza, Zaragoza','ar@gmail.com',123);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (2,1,'María Latorre','12/07/1990','Zaragoza, Zaragoza','ml@gmail.com',98);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (3,2,'Diego García','15/02/1982','Calatayud, Zaragoza','dg@hotmail.com',356);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (4,2,'Carlos Pérez','21/03/1985','Huesca, Huesca','cp@yahoo.com',237);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (5,3,'Isabel Hidalgo','19/10/1991','Teruel, Teruel','ih@yahoo.com',567);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (6,3,'Pilar Martínez','09/02/1994','Calatayud, Zaragoza','pm@hotmail.com',702);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (7,1,'Francisco Cruz','05/05/1995','Alcañiz, Teruel','fc@gmail.com',42);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (8,2,'Lucía Serrano','17/04/1999','Monzón, Huesca','ls@hotmail.com',107);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (9,4,'Enrique Sierra','25/12/1987','Zaragoza, Zaragoza','es@gmail.com',1024);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (10,4,'Sofía Navarro','31/12/1992','Huesca, Huesca','sn@hotmail.com',1517);
INSERT INTO "viajero" ("codigo","codigo_clase","nombre","fecha_nacimiento","lugar_residencia","correo","puntos") VALUES (11,1,'Roberto Marín','01/01/1988','Teruel, Teruel','rm@gmail.com',17);

INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (1,'Zaragoza Delicias','Zaragoza',2003,10);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (2,'Goya','Zaragoza',2012,4);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (3,'Huesca','Huesca',2001,6);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (4,'Teruel','Teruel',1901,13);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (5,'Calatayud','Calatayud',1863,6);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (6,'Guadalajara','Guadalajara',1859,9);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (7,'Madrid Puerta de Atocha','Madrid',1992,15);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (8,'Lérida Pirineos','Lérida',1927,6);
INSERT INTO "estacion" ("codigo","nombre","ubicacion","agno_inauguracion","vias") VALUES (9,'Barcelona Sants','Barcelona',1975,14);

INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (1,4,3,1,'19/05/2022','15:00','15:50',14.57);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (2,4,1,3,'26/05/2022','09:30','10:20',14.21);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (3,11,4,1,'19/05/2022','18:00','18:50',15.53);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (4,11,1,4,'26/05/2022','11:30','12:20',15.24);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (5,9,1,7,'31/05/2022','08:30','10:00',54.39);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (6,9,7,9,'03/06/2022','11:00','14:00',92.15);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (7,9,9,1,'06/06/2022','12:30','14:00',45.83);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (8,2,1,3,'17/06/2022','09:30','10:20',14.23);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (9,2,3,1,'01/09/2022','15:00','15:50',14.52);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (10,1,1,4,'17/06/2022','11:30','12:30',15.07);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (11,1,4,1,'01/09/2022','18:00','18:50',15.35);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (12,5,4,1,'01/07/2022','18:00','18:50',15.33);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (13,5,1,3,'08/07/2022','09:30','10:20',14.43);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (14,5,3,4,'15/07/2022','10:30','12:10',27.68);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (15,1,1,7,'20/12/2022','08:30','10:00',58.42);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (16,1,7,1,'10/01/2023','15:00','16:30',52.09);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (17,2,1,9,'20/12/2023','08:30','10:00',47.12);
INSERT INTO "billete" ("codigo","codigo_viajero","codigo_estacion_origen","codigo_estacion_destino","fecha","hora_salida","hora_llegada","importe") VALUES (18,2,9,1,'10/01/2023','15:00','16:30',44.75);

COMMIT;

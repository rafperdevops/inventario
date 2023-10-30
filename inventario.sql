CREATE DATABASE `inventario`;

USE inventario

-- inventario.productos definition

CREATE TABLE `productos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`codigo`)
);

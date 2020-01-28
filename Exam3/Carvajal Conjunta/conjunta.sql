-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-01-2020 a las 18:36:58
-- Versión del servidor: 10.4.6-MariaDB-log
-- Versión de PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `conjunta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicle`
--

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (1,'Nissan','PU1');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (2,'Chevrolet','PU2');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (3,'Toyota','PU3');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (4,'Renault','PU4');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (5,'Ferrari','PU5');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (6,'Mercedes','PU6');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (7,'Peugot','PU7');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (8,'Hyundai','PU8');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (9,'Chevrolet','PU9');
INSERT INTO `vehicle`(`id`, `brand`, `model`) VALUES (10,'Nissan','PU10');
--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

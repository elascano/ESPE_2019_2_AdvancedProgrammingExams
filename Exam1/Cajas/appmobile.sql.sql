-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2019 a las 19:37:11
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `appmobile`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id` int(10) NOT NULL,
  `name_p` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `stock` int(10) NOT NULL,
  `price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `name_p`, `description`, `stock`, `price`) VALUES
(2, 'fanta', 'bebidad', 10, 1),
(3, 'cola', 'coca-cola', 2, 3),
(4, 'cola', 'coca-cola', 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provider`
--

CREATE TABLE `provider` (
  `id` int(10) NOT NULL,
  `name_p` varchar(30) NOT NULL,
  `addres` varchar(30) NOT NULL,
  `telephone` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `provider`
--

INSERT INTO `provider` (`id`, `name_p`, `addres`, `telephone`) VALUES
(1, 'Jefferson', 'Bombona y Haiti', '0898776'),
(4, 'Jefferson', 'Bombona y Haiti', '0898776'),
(1723764021, 'juan', 'pintag', '2384010'),
(1723764032, 'maria', 'quito', '2384019');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `report`
--

CREATE TABLE `report` (
  `id` int(10) NOT NULL,
  `name_pr` varchar(30) NOT NULL,
  `stock` int(10) NOT NULL,
  `price` int(10) NOT NULL,
  `id_p` int(10) NOT NULL,
  `name_p` varchar(30) NOT NULL,
  `addres` varchar(30) NOT NULL,
  `telephone` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `report`
--

INSERT INTO `report` (`id`, `name_pr`, `stock`, `price`, `id_p`, `name_p`, `addres`, `telephone`) VALUES
(1, 'queso', 10, 2, 1723764021, 'juan', 'pintag', '2384010'),
(2, 'fanta', 10, 1, 1723764032, 'maria', 'quito', '2384019');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `provider`
--
ALTER TABLE `provider`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

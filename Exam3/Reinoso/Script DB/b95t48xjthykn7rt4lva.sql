-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: b95t48xjthykn7rt4lva-mysql.services.clever-cloud.com:3306
-- Generation Time: Jan 27, 2020 at 05:41 PM
-- Server version: 8.0.13-3
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b95t48xjthykn7rt4lva`
--

-- --------------------------------------------------------


--
-- Table structure for table `Vehiculos`
--

CREATE TABLE `Vehiculos` (
  `ID` varchar(16) NOT NULL,
  `Brand` varchar(16) NOT NULL,
  `Model` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Vehiculos`
--

INSERT INTO `Vehiculos` (`ID`, `Brand`, `Model`) VALUES
('1', 'chevrolet', 'sail'),
('2', 'mazda', 'xtreme'),
('3', 'kia', 'sportage'),
('4', 'ferrari', 'nitro'),
('5', 'lamborguini', 'aventor'),
('6', 'toyota', 'blazer'),
('7', 'chevrolet', 'spark'),
('8', 'kia', 'sport'),
('9', 'toyota', 'hylux'),
('10', 'mazda', 'bt50');



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

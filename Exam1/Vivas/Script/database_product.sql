-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 30, 2019 at 06:35 PM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_product`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id_product` varchar(16) NOT NULL,
  `name_product` varchar(32) DEFAULT NULL,
  `descri_product` varchar(32) DEFAULT NULL,
  `quantityStock_product` int(8) DEFAULT NULL,
  `price_product` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id_product`, `name_product`, `descri_product`, `quantityStock_product`, `price_product`) VALUES
('1', 'Carne', 'Para comer', 30, 1.2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
INSERT INTO product VALUES ('1','Ladrillo','muy pesado',4,0.5);
INSERT INTO product VALUES ('2','Martillo','muy pesado',4,0.5);
INSERT INTO product VALUES ('3','Clavos','poco pesado',100,0.4);
INSERT INTO product VALUES ('4','Peras','muy rico',99,0.5);
INSERT INTO product  VALUES ('5','Naranjas','muy rico',98,0.6);
INSERT INTO product VALUES ('6','Sandia','muy rico',97,1);
INSERT INTO product VALUES ('7','Guayaba','muy rico',99,1.8);
INSERT INTO product VALUES ('8','Platano','muy rico',10,0.5);
INSERT INTO product VALUES ('9','Guineo','muy rico',11,0.9);
INSERT INTO product VALUES ('10','Zapote','muy rico',12,0.8);
INSERT INTO product VALUES ('11','Chirimoya','muy rico',13,0.7);

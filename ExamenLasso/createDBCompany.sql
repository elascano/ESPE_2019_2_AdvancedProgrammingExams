CREATE DATABASE IF NOT EXISTS `company`;
USE `company`;


CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) 



INSERT INTO company.product (ip, `name`, description, quantity, price) 
	VALUES (1, 'apple', 'food', 2, 2.0)
INSERT INTO company.product (ip, `name`, description, quantity, price) 
	VALUES (2, 'rice', 'food', 3, 3.0)
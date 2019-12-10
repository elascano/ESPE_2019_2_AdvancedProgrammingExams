
Create database company;
use company;

CREATE TABLE `product` (
  `ID_PROD` varchar(12) NOT NULL,
  `ID_PROV` varchar(12) NOT NULL,
  `NAME_PROD` varchar(12) DEFAULT NULL,
  `STOCK_PROD` int(11) DEFAULT NULL,
  `PRICE_PROD` float DEFAULT NULL
) 
use company;
alter table  `product`
add primary key ( `ID_PROD`);

use company;
INSERT INTO `product` (`ID_PROD`, `NAME_PROD`, `DESCRIP_PROD`, `STOCK_PROD`, `PRICE_PROD`) VALUES
('1', 'teclado', 'teclado mecanico', 5, 10),
('2', 'Mouse', 'mouse RGB', 5, 12);
create database product;
use product;
create table product 
(
   id           integer(10) not null,
   name              varchar(50),
   description		varchar(50),
   quantityStock	integer,
   price			float,
   primary key (id)
);

insert into product values(1,'Linterna','Use like ligth',10,1.5);
insert into product values(2,'Casco','For Secure',5,1.00);
--Luis_Benitez
	create table product(
	 id_product char(25),
	 name_product char(25),
	 description_product char(40),
     quantity_stock integer,
     price_product integer
	);

    insert into product values('p1','Clavo','dos pulgadas',25,1);
    insert into product values('p2','Martillo','mango madera',5,5);
    insert into product values('p3','Taladro','electrico',15,15);
    insert into product values('p4','Focos','luz led',2,4);
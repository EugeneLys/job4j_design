create table shops(
	id serial primary key,
	name varchar(255)
);

create table products(
	id serial primary key,
	name varchar(255),
	shops_id int references shops(id)
);

create table customers(
	id serial primary key,
	name varchar(255)
);

create table sales(
	id serial primary key,
	customers_id int references customers(id),
	products_id int references products(id),
	date date
);

insert into shops(name) values
('Ralf Ringer'), ('Mascotte'), ('Belfest'), ('Unichel');
insert into customers(name) values
('Ivan'), ('Petr'), ('Anna'), ('Sergey');
insert into products(name, shops_id) values
('red boots', 1), ('red boots', 2), ('red boots', 3), ('red boots', 4),
('slippers', 2), ('slippers', 3), ('slippers', 4),
('shoes', 3), ('shoes', 4),
('sneakers', 4);
insert into sales(customers_id, products_id, date) values
(1, 1, '01.08.2023'), (1, 2, '02.08.2023'), (2, 3, '03.08.2023'),
(2, 5, '04.08.2023'), (3, 7, '05.08.2023'), (4, 8, '06.08.2023');

create view on_sale
as select s.name as shop, p.name as product 
from products p 
left join shops s on shops_id=s.id 
left join sales on products_id=p.id  
group by s.id, p.name, s.name, sales.date 
having sales.date is null 
order by s.name;

select * from on_sale;
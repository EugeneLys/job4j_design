create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name) values ('cheese'), ('milk'), ('fruit'), ('bread'), ('meat');

insert into product(name, type_id, expired_date, price) values
('chadder', 1, '31.12.2023', 1000), ('hohland', 1, '30.11.2023', 1500), ('parmesan', 1, '31.10.2023', 2000),
('cows milk', 2, '31.08.2023', 100), ('goat milk', 2, '21.08.2023', 200), ('horse milk', 2, '11.09.2023', 300),
('ice cream', 2, '31.12.2023', 199),
('apple', 3, '30.09.2023', 150), ('peach', 3, '31.08.2023', 250), ('banana', 3, '15.09.2023', 125),
('white bread', 4, '30.08.2023', 50), ('grey bread', 4, '31.08.2023', 60), ('baguette', 4, '31.08.2023', 55),
('pork', 5, '30.09.2023', 400), ('beef', 5, '15.10.2023', 500), ('chicken', 5, '10.09.2023', 300);

select * from product 
join type on type_id=type.id 
where type.name = 'cheese';

select * from product
where name like '%ice cream%';

select * from product
where expired_date < '22.08.2023';

select * from product
where price = (select max(price) from product);

select type.name as type, count(product) as quantity from type 
join product on type_id=type.id 
group by type.name;

select * from product 
join type on type_id=type.id 
where type.name = 'cheese' OR type.name = 'milk';

select type.name, count(product) from type 
join product on type_id=type.id 
group by type.name 
having count(product) < 10;

select product.name, type.id, type.name from product 
join type on type_id=type.id 
group by product.name, type.id, type.name
order by type.id asc;
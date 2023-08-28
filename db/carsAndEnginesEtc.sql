create table car_bodies(
	id serial primary key,
	name varchar(255)
);

create table car_engines(
	id serial primary key,
	name varchar(255)
);

create table car_transmissions(
	id serial primary key,
	name varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values
('pickup'), ('minivan'), ('sedan'), ('SUV'), ('coupe');

insert into car_engines(name) values
('M57'), ('Duraterc HE'), ('1JZ'), ('VQ35DE');

insert into car_transmissions(name) values
('Volkswagen 09M'), ('Jatco JF613E'), ('Aisin TB-50LS'), ('A6MF1');

insert into cars(name, body_id, engine_id, transmission_id) values
('Golf', 3, 3, 1), ('Polo', 3, 1, 1), ('X5', 4, 1, 3), ('TT', 5, 4, 2), ('new', 3);

select c.name as name, b.name as body, e.name as engine, t.name as transmission from cars c 
left join car_bodies b on c.body_id=b.id 
left join car_engines e on c.engine_id=e.id 
left join car_transmissions t on c.transmission_id = t.id 
order by engine;

select b.name from car_bodies b left join cars c on c.body_id=b.id where c.name is null;
select e.name from car_engines e left join cars c on c.engine_id=e.id where c.name is null;
select t.name from car_transmissions t left join cars c on c.transmission_id=t.id where c.name is null;

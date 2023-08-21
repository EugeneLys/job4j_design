create table countries(
	id serial primary key,
	name text,
	continent text
);

create table cities(
	id serial primary key,
	name text,
	population int,
	countries_id int references countries(id) unique
);

insert into countries(name, continent) values ('Russia', 'Eurasia');
insert into countries(name, continent) values ('France', 'Eurasia');
insert into countries(name, continent) values ('USA', 'North America');
insert into countries(name, continent) values ('Brazil', 'North America');

insert into cities(name, population, countries_id) values ('Moscow', 10000000, 1);
insert into cities(name, population, countries_id) values ('Paris', 5000000, 2);
insert into cities(name, population, countries_id) values ('New York', 15000000, 3);
insert into cities(name, population, countries_id) values ('San Paolo', 7000000, 4);

select c.name, con.name from cities as c join countries as con on c.countries_id = con.id;
select c.population, con.continent from cities as c join countries as con on c.countries_id = con.id;
select * from cities as c join countries as con on c.countries_id = con.id;

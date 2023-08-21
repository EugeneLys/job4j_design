create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('phone', 15000), ('TV', 30000), ('notebook', 50000);
insert into people(name) values ('Ivan'), ('Petr'), ('Anna');
insert into devices_people(device_id, people_id) values (7, 10), (7, 11), (7, 12);
insert into devices_people(device_id, people_id) values (8, 10), (8, 11);
insert into devices_people(device_id, people_id) values (9, 12);
select avg(price) from devices;


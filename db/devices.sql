create table devices(
    id serial primary key,
    name varchar(255),
    price float);

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
insert into devices_people(device_id, people_id) values (1, 1), (1, 2), (1, 3);
insert into devices_people(device_id, people_id) values (2, 1), (2, 2);
insert into devices_people(device_id, people_id) values (3, 1);

select avg(price) from devices;

select people_id, avg(price) from devices 
join devices_people
on device_id=devices.id
group by people_id;

select people_id, avg(price) from devices 
join devices_people
on device_id=devices.id
group by people_id
having avg(price) > 5000;
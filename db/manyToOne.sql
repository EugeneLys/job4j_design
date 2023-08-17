create table brand(
    id serial primary key,
    name varchar(255)
);

create table models(
    id serial primary key,
    name varchar(255),
    brand_id int references brand(id)
);

insert into brand(name) values ('Ford');
insert into models(name, brand_id) VALUES ('Expedition', 1);
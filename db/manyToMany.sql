create table banks(
    id serial primary key,
    name varchar(255)
);
 
create table clients(
    id serial primary key,
    name varchar(255)
);
 
create table banks_clients(
    id serial primary key,
    bank_id int references banks(id),
    client_id int references clients(id)
);
 
insert into banks(name) values('Sber');
insert into banks(name) values('Raiffaizen');

insert into clients(name) values('Ivanov');
insert into clients(name) values('Petrov');

insert into banks_clients(bank_id, client_id) values (1, 1);
insert into banks_clients(bank_id, client_id) values (1, 2);
insert into banks_clients(bank_id, client_id) values (2, 1);
insert into banks_clients(bank_id, client_id) values (2, 2);
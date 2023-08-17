
create table account(
    id serial primary key,
    login varchar(255)
);

create table email(
    id serial primary key,
    name varchar(255),
    account_id int references account(id) unique
);
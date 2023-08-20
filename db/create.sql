create table users (
    id serial primary key,
    name varchar(255)
);

create table items (
    id serial primary key,
    name text,
    users_id int references users(id)
);

create table rules (
    id serial primary key,
    name varchar(255)
);

create table roles (
    id serial primary key,
    name varchar(255),
    users_id int references users(id)
);

create table rules_roles(
     id serial primary key,
     rules_id int references rules(id),
     roles_id int references roles(id)
 );

create table categories (
    id serial primary key,
    name text,
    items_id int references items(id)
);

create table comments (
    id serial primary key,
    name text,
    items_id int references items(id)
);

create table attachs (
    id serial primary key,
    name text,
    items_id int references items(id)
);

create table states (
    id serial primary key,
    name text,
    items_id int references items(id)
);

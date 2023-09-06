create table books(
	id serial primary key,
	name varchar(100),
	pages integer
);

insert into books (name, pages) values
('Pushkin', 1000), ('Lermontov', 2000), ('Tolstoy', 3000);
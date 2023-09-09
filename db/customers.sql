CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers values
(1, 'John', 'Wick', 33, 'USA'),
(2, 'Jack', 'Smith', 44, 'GB'),
(3, 'Ivan', 'Petrov', 55, 'Russia'),
(4, 'Jan', 'Mare', 33, 'France');

select * from customers where age = (select min(age) from customers); 



CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders values
(1, 10, 1), (2, 20, 2), (3, 30, 3);

select * from customers where id NOT IN (select customer_id from orders);
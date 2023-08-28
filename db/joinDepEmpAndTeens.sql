create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);

insert into departments(name) values ('First department'), ('Second department'), ('Third department');
insert into employees(name, departments_id) values ('Ivan', 1), ('Petr', 1), ('Anna', 1), ('Maksim', 2), ('Sergey', 2);

select * from departments d left join employees e on e.departments_id=d.id;
select * from departments d right join employees e on e.departments_id=d.id;
select * from departments d full join employees e on e.departments_id=d.id;
select * from employees e cross join departments d;

select d.id, d.name from departments d left join employees e on e.departments_id=d.id where e.departments_id is null group by d.id, d.name;

select d.id, d.name, e.id, e.name from departments d left join employees e on e.departments_id=d.id order by e.name;
select d.id, d.name, e.id, e.name from employees e right join departments d on e.departments_id=d.id order by e.name;

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(1)
);

insert into teens(name, gender) 
values ('Anna', 'f'), ('Irina', 'f'), ('Ivan', 'm'), ('Petr', 'm');
select teens.name, t2.name from teens cross join (select teens.name from teens where teens.gender='m') as t2 where teens.gender='f';


insert into fauna(name, avg_age, discovery_date) values ('tiger', 5000, '31.12.1858');
insert into fauna(name, avg_age, discovery_date) values ('blue whale', 31000, '31.12.1694');
insert into fauna(name, avg_age) values ('bear', 11000);
insert into fauna(name, avg_age, discovery_date) values ('swordfish', 4000, '01.01.1758');

select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';

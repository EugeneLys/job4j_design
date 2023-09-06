create table clubs(
	id serial primary key,
	name text,
	budget_mln integer
);

insert into clubs (name, budget_mln) values
('Milan', 100), ('PSG', 200), ('Bavaria', 150);
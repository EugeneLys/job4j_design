insert into roles(name) values ('role one');
insert into rules(name) values ('rule one');
insert into categories(name) values ('category one');
insert into states(name) values ('state one');
insert into users(name, roles_id) values ('Ivan', 5);
insert into items(name, users_id, categories_id, states_id) values ('first item', 6, 5, 5);
insert into rules_roles(rules_id, roles_id) values (5, 5);
insert into comments(name, items_id) values ('comment one', 2);
insert into attachs(name, items_id) values ('attach one',  2);

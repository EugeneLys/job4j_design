insert into users(name) values ('Ivan');
insert into roles(name, users_id) values ('role one', 1);
insert into items(name, users_id) values ('first item', 1);
insert into rules(name) values ('rule one');
insert into rules_roles(rules_id, roles_id) values (1, 1);
insert into categories(name, items_id) values ('category one', 1);
insert into comments(name, items_id) values ('comment one', 1);
insert into attachs(name, items_id) values ('first attach', 1);
insert into states(name, items_id) values ('attach one', 1);
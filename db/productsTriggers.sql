create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5 AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger discount_trigger
    after insert
    on products
    for each row
    execute procedure discount();
	
create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted) and count <= 5;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();



create or replace function impost()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger impost_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure impost();



create or replace function bef_impost()
	returns trigger as
$$
	BEGIN
		update products
		set price = price + price*0.2
		where id = new.id;
		return NEW;
	END;
$$
LANGUAGE 'plpgsql';

create trigger bef_impost_trigger
    before insert 
	on products
    for each row
    execute procedure bef_impost();



create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function fix_price()
    returns trigger as
$$
    BEGIN
        INSERT INTO history_of_price(name, price, date)
		VALUES (new.name, new.price, CURRENT_DATE);
		return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger write_history_trigger
    after insert
    on products
    for each row
    execute procedure fix_price();

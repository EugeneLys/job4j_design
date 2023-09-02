create or replace procedure delete_by_id(p_id integer)
language 'plpgsql'
as $$
    BEGIN
    delete from products where products.id = p_id;
    END
$$;

create or replace function f_delete_if_0()
returns void
language 'plpgsql'
as
$$
    begin
            delete from products where products.count = 0;
    end;
$$;

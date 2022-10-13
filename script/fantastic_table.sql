
create table fantastic_table (
        id bigserial not null primary key,
        brand varchar(50),
        model varchar(50),
        color varchar(50)
);

insert into fantastic_table (id, brand, model, color) values (0, 'Fiat', 'Panda', 'rossa');
insert into fantastic_table (id, brand, model, color) values (1, 'Fiat', 'Panda', 'bianca');
insert into fantastic_table (id, brand, model, color) values (2, 'Fiat', 'Panda', 'verde');

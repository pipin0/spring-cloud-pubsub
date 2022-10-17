create table audio_table (
        id bigserial not null primary key,
        title varchar(100),
        author varchar(100),
        bytes bytea,
        insertion_date bigserial not null
);

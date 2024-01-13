create table client
(
    id   serial
        constraint client_pk
            primary key,
    name text not null,
    note text
);

comment on table client is 'Clienti';

comment on column client.name is 'Identificativo del cliente';

comment on column client.note is 'Informazioni utili o note';

alter table client
    owner to citizix_user;

create table "user"
(
    id        serial
        constraint user_pk
            primary key
                deferrable,
    name      varchar(255) not null,
    password  varchar(255) not null,
    note      text,
    client_id integer      not null
        constraint user_client_id_fk
            references client
);

alter table "user"
    owner to citizix_user;

create table station
(
    id              serial
        constraint station_pk
            primary key,
    name            varchar(255)          not null,
    client_id       integer
        constraint station_client_id_fk
            references client,
    note            text,
    update_required boolean default false not null
);

comment on table station is 'Indica la stazione meteo fisica';

comment on column station.name is 'nome identificativo della stazione';

comment on column station.note is 'note per gli sviluppatori';

alter table station
    owner to citizix_user;

create table sensor
(
    id         serial
        constraint sensor_pk
            primary key,
    name       varchar(255) not null,
    station_id integer      not null
        constraint sensor_station_id_fk
            references station
);

alter table sensor
    owner to citizix_user;

create table sensor_data
(
    id        serial
        constraint sensor_data_pk
            primary key,
    sensor_id integer not null
        constraint sensor_data_sensor_id_fk
            references sensor,
    data      varchar(255),
    note      varchar(255)
);

comment on column sensor_data.data is 'data holder del sensore';

alter table sensor_data
    owner to citizix_user;


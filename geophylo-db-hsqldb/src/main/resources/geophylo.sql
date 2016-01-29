    create sequence hibernate_sequence start with 1 increment by 1;

    create table EarthMapEntity (
        id integer not null,
        data blob(255),
        name varchar(255),
        version integer,
        primary key (id)
    );

    create table EpochEntity (
        id integer not null,
        color varbinary(255),
        olderBound double not null,
        preferred varchar(255),
        rank integer,
        version integer,
        youngerBound double not null,
        broader_id integer,
        earthMap_id integer,
        primary key (id)
    );

    create table EpochEntity_EpochEntity (
        EpochEntity_id integer not null,
        narrower_id integer not null
    );

    create table EpochEntity_names (
        EpochEntity_id integer not null,
        names varchar(255),
        names_KEY varchar(255) not null,
        primary key (EpochEntity_id, names_KEY)
    );

    alter table EpochEntity
        add constraint UK_t26ayxmlr80qrow71oajt3axj unique (preferred);

    alter table EpochEntity_EpochEntity
        add constraint UK_qt54elafsei2d6w8496y8px8v unique (narrower_id);

    alter table EpochEntity
        add constraint FKq0cven0qjtwjg6gij5068w0mt
        foreign key (broader_id)
        references EpochEntity;

    alter table EpochEntity
        add constraint FK67d5bpiikalbyhbx6yydtid9d
        foreign key (earthMap_id)
        references EarthMapEntity;

    alter table EpochEntity_EpochEntity
        add constraint FKasj1uf39agvvfdqpjfki3h569
        foreign key (narrower_id)
        references EpochEntity;

    alter table EpochEntity_EpochEntity
        add constraint FKmkygupc9qv8tmehfm0cr4fq21
        foreign key (EpochEntity_id)
        references EpochEntity;

    alter table EpochEntity_names
        add constraint FKp7inpu9rudhwijabybc74t5c
        foreign key (EpochEntity_id)
        references EpochEntity;

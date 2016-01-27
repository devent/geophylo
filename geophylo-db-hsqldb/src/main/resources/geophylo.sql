    create sequence hibernate_sequence start with 1 increment by 1;

    create table EpochEntity (
        id integer not null,
        olderBound double not null,
        preferred varchar(255),
        rank varchar(255),
        version integer,
        yougherBound double not null,
        primary key (id)
    );

    create table EpochEntity_EpochEntity (
        EpochEntity_id integer not null,
        narrowerEpoch_id integer not null,
        broaderEpoch_id integer not null
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
        add constraint UK_8grvf1lji7twdo8w1vpf8py78 unique (narrowerEpoch_id);

    alter table EpochEntity_EpochEntity
        add constraint UK_4j1ofli5nr0xa5pfn0ood0jxt unique (broaderEpoch_id);

    alter table EpochEntity_EpochEntity
        add constraint FK6e4ru3ll4yyfglcbl7ir8amut
        foreign key (narrowerEpoch_id)
        references EpochEntity;

    alter table EpochEntity_EpochEntity
        add constraint FKmkygupc9qv8tmehfm0cr4fq21
        foreign key (EpochEntity_id)
        references EpochEntity;

    alter table EpochEntity_EpochEntity
        add constraint FKeyhqmwdu99b1ew6k3prgrrpf
        foreign key (broaderEpoch_id)
        references EpochEntity;

    alter table EpochEntity_names
        add constraint FKp7inpu9rudhwijabybc74t5c
        foreign key (EpochEntity_id)
        references EpochEntity;

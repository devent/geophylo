    alter table EpochEntity_EpochEntity
        drop constraint FK6e4ru3ll4yyfglcbl7ir8amut;

    alter table EpochEntity_EpochEntity
        drop constraint FKmkygupc9qv8tmehfm0cr4fq21;

    alter table EpochEntity_EpochEntity
        drop constraint FKeyhqmwdu99b1ew6k3prgrrpf;

    alter table EpochEntity_names
        drop constraint FKp7inpu9rudhwijabybc74t5c;

    drop table EpochEntity if exists;

    drop table EpochEntity_EpochEntity if exists;

    drop table EpochEntity_names if exists;

    drop sequence hibernate_sequence;


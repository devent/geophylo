    alter table EpochEntity
        drop constraint FKq0cven0qjtwjg6gij5068w0mt;

    alter table EpochEntity
        drop constraint FK67d5bpiikalbyhbx6yydtid9d;

    alter table EpochEntity_EpochEntity
        drop constraint FKasj1uf39agvvfdqpjfki3h569;

    alter table EpochEntity_EpochEntity
        drop constraint FKmkygupc9qv8tmehfm0cr4fq21;

    alter table EpochEntity_names
        drop constraint FKp7inpu9rudhwijabybc74t5c;

    drop table EarthMapEntity if exists;

    drop table EpochEntity if exists;

    drop table EpochEntity_EpochEntity if exists;

    drop table EpochEntity_names if exists;

    drop sequence hibernate_sequence;

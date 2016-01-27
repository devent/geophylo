package com.anrisoftware.geophylo.db.hibernate;

import org.hibernate.HibernateException;

@SuppressWarnings("serial")
public class CreateDatabaseException extends GeophyloDatabaseException {

    public CreateDatabaseException(String resource, HibernateException e) {
        super("Error create database", e);
        addContextValue("resource", resource);
    }

}

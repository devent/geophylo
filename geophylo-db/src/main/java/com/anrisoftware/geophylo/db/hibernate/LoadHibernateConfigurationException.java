package com.anrisoftware.geophylo.db.hibernate;

import org.hibernate.HibernateException;

@SuppressWarnings("serial")
public class LoadHibernateConfigurationException extends
        GeophyloDatabaseException {

    public LoadHibernateConfigurationException(String resource,
            HibernateException e) {
        super("Load hibernate configuration error", e);
        addContextValue("resource", resource);
    }

}

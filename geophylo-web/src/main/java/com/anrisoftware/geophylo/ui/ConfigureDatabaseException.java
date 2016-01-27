package com.anrisoftware.geophylo.ui;

import javax.servlet.ServletException;

import com.anrisoftware.geophylo.db.hibernate.LoadHibernateConfigurationException;

@SuppressWarnings("serial")
public class ConfigureDatabaseException extends ServletException {

    public ConfigureDatabaseException(LoadHibernateConfigurationException e) {
        super("Error configure database", e);
    }

}

package com.anrisoftware.geophylo.db.hibernate;

import static com.anrisoftware.geophylo.db.hibernate.HibernateContextProviderLogger._.execute_statement;
import static com.anrisoftware.geophylo.db.hibernate.HibernateContextProviderLogger._.hibernate_configured;

import javax.inject.Singleton;

import com.anrisoftware.globalpom.log.AbstractLogger;

/**
 * Logging for {@link HibernateContextProvider}.
 *
 * @author Erwin Mueller, erwin.mueller@deventm.org
 * @since 1.0
 */
@Singleton
final class HibernateContextProviderLogger extends AbstractLogger {

    enum _ {

        hibernate_configured("Hibernate configured from '{}'"),

        execute_statement("Execute statement: {}");

        private String name;

        private _(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Sets the context of the logger to {@link HibernateContextProvider}.
     */
    public HibernateContextProviderLogger() {
        super(HibernateContextProvider.class);
    }

    void hibernateConfigured(String resource) {
        info(hibernate_configured, resource);
    }

    void executeStatement(String string) {
        trace(execute_statement, string);
    }
}

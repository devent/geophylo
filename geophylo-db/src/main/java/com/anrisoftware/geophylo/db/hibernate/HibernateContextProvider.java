package com.anrisoftware.geophylo.db.hibernate;

import static org.apache.commons.lang3.Validate.notNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.collection.AbstractCollectionPersister;
import org.hibernate.persister.entity.AbstractEntityPersister;

@Singleton
public class HibernateContextProvider implements Provider<SessionFactory> {

    @Inject
    private HibernateContextProviderLogger log;

    private SessionFactory sessionFactory;

    private StandardServiceRegistry serviceRegistry;

    public void loadConfiguration() throws LoadHibernateConfigurationException {
        Configuration config;
        String resource = "hibernate.cfg.xml";
        try {
            config = new Configuration().configure(resource);
            this.serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();
            this.sessionFactory = config.buildSessionFactory(serviceRegistry);
            log.hibernateConfigured(resource);
        } catch (HibernateException e) {
            throw new LoadHibernateConfigurationException(resource, e);
        }
    }

    @Override
    public SessionFactory get() {
        return sessionFactory;
    }

    public Session openSession() {
        return get().openSession();
    }

    /**
     * Creates the tables for the database from the {@code '/geophylo.sql'}
     * resource.
     *
     * @throws ReadResourceException
     * @throws CreateDatabaseException
     */
    public void createDatabase() throws ReadResourceException,
            CreateDatabaseException {
        BootstrapServiceRegistry bootstrap;
        bootstrap = new BootstrapServiceRegistryBuilder().build();
        ClassLoaderService loader;
        loader = bootstrap.getService(ClassLoaderService.class);
        String resource = "/geophylo.sql";
        InputStream stream = loader.locateResourceStream(resource);
        notNull(stream, "resource = null");
        try {
            Session session = openSession();
            Transaction t = session.beginTransaction();
            try {
                try {
                    String sql = IOUtils.toString(stream);
                    String[] split = StringUtils.split(sql, ";");
                    for (String string : split) {
                        string = StringUtils.removePattern(string, "[^\\S ]");
                        string = StringUtils.trim(string);
                        if (!StringUtils.isBlank(string)) {
                            log.executeStatement(string);
                            session.createSQLQuery(string).executeUpdate();
                        }
                    }
                } catch (IOException e) {
                    throw new ReadResourceException(resource, e);
                }
                t.commit();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            throw new CreateDatabaseException(resource, e);
        }
    }

    /**
     * @return List with all the database table names.
     */
    @SuppressWarnings("rawtypes")
    public List<String> getAllTableNames() {
        HashSet<String> tables = new HashSet<String>();
        SessionFactory sessionFactory = get();
        Map<String, ClassMetadata> allClassMetadata = sessionFactory
                .getAllClassMetadata();
        Map allCollectionMetadata = sessionFactory.getAllCollectionMetadata();

        for (String key : allClassMetadata.keySet()) {
            ClassMetadata classMetadata = allClassMetadata.get(key);

            if (classMetadata instanceof AbstractEntityPersister) {
                AbstractEntityPersister persister = (AbstractEntityPersister) classMetadata;
                tables.add(persister.getTableName());
            }
        }

        for (Object key : allCollectionMetadata.keySet()) {
            AbstractCollectionPersister persister = (AbstractCollectionPersister) allCollectionMetadata
                    .get(key);
            tables.add(persister.getTableName());
        }

        return new ArrayList<String>(tables);
    }

}

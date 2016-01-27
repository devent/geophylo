package com.anrisoftware.geophylo.db.hibernate;

import com.anrisoftware.geophylo.db.hibernate.EpochEntity.EpochEntityFactory;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * @see EpochEntityFactory
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 1.0
 */
public class DatabaseEntitiesModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().implement(EpochEntity.class,
                EpochEntity.class).build(EpochEntityFactory.class));
    }

}

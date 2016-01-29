package com.anrisoftware.geophylo.db.hibernate;

import com.anrisoftware.geophylo.db.hibernate.EarthMapEntity.EarthMapEntityFactory;
import com.anrisoftware.geophylo.db.hibernate.EpochEntity.EpochEntityFactory;
import com.anrisoftware.geophylo.db.hibernate.EpochsModel.EpochsModelFactory;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * @see EpochEntityFactory
 * @see EpochsModelFactory
 * @see EarthMapEntityFactory
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 1.0
 */
public class DatabaseEntitiesModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().implement(EpochEntity.class,
                EpochEntity.class).build(EpochEntityFactory.class));
        install(new FactoryModuleBuilder().implement(EpochsModel.class,
                EpochsModel.class).build(EpochsModelFactory.class));
        install(new FactoryModuleBuilder().implement(EarthMapEntity.class,
                EarthMapEntity.class).build(EarthMapEntityFactory.class));
    }

}

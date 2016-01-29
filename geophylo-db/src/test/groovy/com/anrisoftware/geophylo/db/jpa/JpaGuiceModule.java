package com.anrisoftware.geophylo.db.jpa;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class JpaGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("geophylo-test-db"));
        bind(JpaInitializer.class).asEagerSingleton();
    }
}

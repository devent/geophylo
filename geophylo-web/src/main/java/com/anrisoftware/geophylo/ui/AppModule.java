package com.anrisoftware.geophylo.ui;

import com.anrisoftware.geophylo.db.hibernate.DatabaseEntitiesModule;
import com.anrisoftware.geophylo.epochwindow.EpochWindowModule;
import com.anrisoftware.geophylo.resources.ResourcesModule;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        installUi();
        install(new DatabaseEntitiesModule());
        install(new ResourcesModule());
    }

    private void installUi() {
        install(new EpochWindowModule());
    }

}

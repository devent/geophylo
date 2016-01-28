package com.anrisoftware.geophylo.epochwindow;

import com.anrisoftware.geophylo.epochwindow.EpochForm.EpochFormFactory;
import com.anrisoftware.geophylo.epochwindow.EpochProperties.EpochPropertiesFactory;
import com.anrisoftware.geophylo.epochwindow.EpochWindow.EpochWindowFactory;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * @see EpochWindowFactory
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 1.0
 */
public class EpochWindowModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().implement(EpochWindow.class,
                EpochWindow.class).build(EpochWindowFactory.class));
        install(new FactoryModuleBuilder().implement(EpochProperties.class,
                EpochProperties.class).build(EpochPropertiesFactory.class));
        install(new FactoryModuleBuilder().implement(EpochForm.class,
                EpochForm.class).build(EpochFormFactory.class));
    }

}

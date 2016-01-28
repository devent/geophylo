/*
 * Copyright 2015-2016 Erwin Müller <erwin.mueller@deventm.org>
 *
 * This file is part of gsclock-main-resources. All rights reserved.
 */
package com.anrisoftware.geophylo.resources;

import com.anrisoftware.globalpom.mnemonic.MnemonicModule;
import com.anrisoftware.resources.images.images.ImagesResourcesModule;
import com.anrisoftware.resources.images.mapcachedsingle.ResourcesImagesCachedSingleMapModule;
import com.anrisoftware.resources.images.scaling.ResourcesSmoothScalingModule;
import com.anrisoftware.resources.templates.maps.TemplatesDefaultMapsModule;
import com.anrisoftware.resources.templates.templates.TemplatesResourcesModule;
import com.anrisoftware.resources.templates.worker.STDefaultPropertiesModule;
import com.anrisoftware.resources.templates.worker.STWorkerModule;
import com.anrisoftware.resources.texts.defaults.TextsResourcesDefaultModule;
import com.google.inject.AbstractModule;

/**
 * Installs the resources.
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 1.0
 */
public final class ResourcesModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ImagesResourcesModule());
        install(new ResourcesImagesCachedSingleMapModule());
        install(new ResourcesSmoothScalingModule());
        install(new TextsResourcesDefaultModule());
        install(new TemplatesDefaultMapsModule());
        install(new TemplatesResourcesModule());
        install(new STWorkerModule());
        install(new STDefaultPropertiesModule());
        install(new MnemonicModule());
    }

}

/*
 * Copyright 2015-2016 Erwin Müller <erwin.mueller@deventm.org>
 *
 * This file is part of gsclock-main-resources. All rights reserved.
 */
package com.anrisoftware.geophylo.resources;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.anrisoftware.resources.texts.api.Texts;
import com.anrisoftware.resources.texts.api.TextsFactory;
import com.google.inject.Provider;

/**
 * Provides the application text resources.
 *
 * @author Erwin Mueller, erwin.mueller@deventm.org
 * @since 1.0
 */
@Singleton
public class TextsProvider implements Provider<Texts> {

    private static final String RESOURCES_NAME = "Geophylo";

    @Inject
    private TextsFactory textsFactory;

    private Texts texts;

    @Override
    public synchronized Texts get() {
        if (this.texts == null) {
            Thread t = Thread.currentThread();
            ClassLoader cl = t.getContextClassLoader();
            this.texts = textsFactory.create(RESOURCES_NAME, cl);
        }
        return texts;
    }

}

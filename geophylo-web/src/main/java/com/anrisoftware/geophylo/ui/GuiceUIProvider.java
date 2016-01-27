package com.anrisoftware.geophylo.ui;

import javax.inject.Inject;

import com.google.inject.Injector;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;

@SuppressWarnings("serial")
public class GuiceUIProvider extends UIProvider {

    @Inject
    private Injector injector;

    @Override
    public GeophyloUI createInstance(UICreateEvent event) {
        return injector.getInstance(GeophyloUI.class);
    }

    @Override
    public Class<GeophyloUI> getUIClass(UIClassSelectionEvent event) {
        return GeophyloUI.class;
    }
}

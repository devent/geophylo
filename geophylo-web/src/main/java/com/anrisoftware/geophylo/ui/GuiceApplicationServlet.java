package com.anrisoftware.geophylo.ui;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

@SuppressWarnings("serial")
@Singleton
@VaadinServletConfiguration(productionMode = false, ui = GeophyloUI.class, widgetset = "com.anrisoftware.geophylo.GeophyloWidgetset")
public class GuiceApplicationServlet extends VaadinServlet implements
        SessionInitListener {

    protected final GuiceUIProvider applicationProvider;

    @Inject
    public GuiceApplicationServlet(GuiceUIProvider applicationProvider) {
        this.applicationProvider = applicationProvider;
    }

    @Override
    protected void servletInitialized() {
        getService().addSessionInitListener(this);
    }

    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {
        event.getSession().addUIProvider(applicationProvider);
    }

    @WebFilter(filterName = "guiceFilter", urlPatterns = "/*", asyncSupported = true)
    public static class GuiceWebFilter extends GuiceFilter {
    }

    @WebListener
    public static class GuiceServletConfig extends GuiceServletContextListener {

        @Override
        protected Injector getInjector() {
            return Guice.createInjector(new AppModule(), new ServletModule() {
                @Override
                protected void configureServlets() {
                    serve("/*").with(GuiceApplicationServlet.class);
                    filter("/*").through(PersistFilter.class);
                }
            }, new JpaPersistModule("geophylo-hibernate"));
        }
    }

}

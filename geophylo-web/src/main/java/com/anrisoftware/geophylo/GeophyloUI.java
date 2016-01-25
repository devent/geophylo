package com.anrisoftware.geophylo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("geophylo")
@Widgetset("com.anrisoftware.geophylo.GeophyloWidgetset")
public class GeophyloUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        layout.addComponents(name);
        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "GeophyloUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = GeophyloUI.class, productionMode = false)
    public static class GeophyloUIServlet extends VaadinServlet {
    }
}

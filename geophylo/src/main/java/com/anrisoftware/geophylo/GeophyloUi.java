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
public class GeophyloUi extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "GeophyloUiServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = GeophyloUi.class, productionMode = false)
    public static class GeophyloUiServlet extends VaadinServlet {
    }
}

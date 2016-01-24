package com.anrisoftware.geophylo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

/**
 *
 */
@Theme("geophylo")
@Widgetset("com.anrisoftware.geophylo.MyAppWidgetset")
public class GeophyloUi extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        AbsoluteLayout layout = new AbsoluteLayout();
        layout.setWidth(1f, Unit.PERCENTAGE);
        setContent(layout);

        Panel erasPanel = createEras(layout);

        createHadean();

        createArchean(erasPanel);
    }

    private Panel createEras(AbsoluteLayout layout) {
        Panel erasPanel = new Panel();
        layout.addComponent(erasPanel);
        return erasPanel;
    }

    private void createArchean(Panel erasPanel) {
        Panel archeanPanel = new Panel("Archean");
        archeanPanel.setWidth(10, Unit.CM);
        erasPanel.add(archeanPanel);
    }

    private void createHadean() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addComponent(new Label("Hadean"));
        Panel hadeanPanel = new Panel();
        hadeanPanel.setContent(layout);
        hadeanPanel.setWidth(1, Unit.CM);
    }

    @WebServlet(urlPatterns = "/*", name = "GeophyloUiServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = GeophyloUi.class, productionMode = false)
    public static class GeophyloUiServlet extends VaadinServlet {
    }
}

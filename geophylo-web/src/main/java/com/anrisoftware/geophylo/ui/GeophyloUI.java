package com.anrisoftware.geophylo.ui;

import javax.inject.Inject;

import com.anrisoftware.geophylo.mainmenu.MainMenu;
import com.anrisoftware.geophylo.mainwindow.MainWindow;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("geophylo")
public class GeophyloUI extends UI {

    @Inject
    private MainWindow mainWindow;

    @Inject
    private MainMenu mainMenu;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        mainMenu.setUi(this);
        mainMenu.createMenu();
        content.addComponent(mainMenu);

        mainWindow.createWindow();
        content.addComponent(mainWindow);
    }

}

package com.anrisoftware.geophylo.mainmenu;

import javax.inject.Inject;

import com.anrisoftware.geophylo.db.hibernate.EpochEntity;
import com.anrisoftware.geophylo.db.hibernate.EpochEntity.EpochEntityFactory;
import com.anrisoftware.geophylo.epochwindow.EpochWindow;
import com.anrisoftware.geophylo.epochwindow.EpochWindow.EpochWindowFactory;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class AddEpochAction implements MenuBar.Command {

    @Inject
    private EpochWindowFactory epochWindowFactory;

    @Inject
    private EpochEntityFactory epochFactory;

    private UI ui;

    public void setUi(UI ui) {
        this.ui = ui;
    }

    @Override
    public void menuSelected(MenuItem selectedItem) {
        EpochEntity epoch = epochFactory.create();
        EpochWindow epochWindow = epochWindowFactory.create(epoch);
        epochWindow.createWindow();
        ui.addWindow(epochWindow);
    }

}

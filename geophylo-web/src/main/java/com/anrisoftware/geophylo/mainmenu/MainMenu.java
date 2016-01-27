package com.anrisoftware.geophylo.mainmenu;

import javax.inject.Inject;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class MainMenu extends MenuBar {

    @Inject
    private AddEpochAction addEpochAction;

    public void setUi(UI ui) {
        addEpochAction.setUi(ui);
    }

    public MainMenu createMenu() {
        MenuItem geologicalEpochs = addItem("Epochs", null, null);
        geologicalEpochs.addItem("Add Epoch...", null, addEpochAction);
        geologicalEpochs.addItem("Remove Epoch", null, null);
        geologicalEpochs.addItem("Edit Epoch...", null, null);
        return this;
    }
}

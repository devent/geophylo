package com.anrisoftware.geophylo.epochwindow;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
class CancelAction implements ClickListener {

    private EpochWindow epochWindow;

    public void setWindow(EpochWindow epochWindow) {
        this.epochWindow = epochWindow;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        epochWindow.close();
    }

}

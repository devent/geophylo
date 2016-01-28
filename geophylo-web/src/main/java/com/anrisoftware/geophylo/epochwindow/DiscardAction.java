package com.anrisoftware.geophylo.epochwindow;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
class DiscardAction implements ClickListener {

    private EpochForm epochForm;

    public void setEpochForm(EpochForm epochForm) {
        this.epochForm = epochForm;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        epochForm.discard();
    }

}

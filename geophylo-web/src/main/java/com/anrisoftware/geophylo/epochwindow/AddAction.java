package com.anrisoftware.geophylo.epochwindow;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
class AddAction implements ClickListener {

    private EpochForm epochForm;

    private EpochWindow epochWindow;

    public void setEpochForm(EpochForm epochForm) {
        this.epochForm = epochForm;
    }

    public void setWindow(EpochWindow epochWindow) {
        this.epochWindow = epochWindow;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        try {
            epochForm.commit();
            epochWindow.close();
        } catch (CommitException e) {
        } finally {
        }
    }

}

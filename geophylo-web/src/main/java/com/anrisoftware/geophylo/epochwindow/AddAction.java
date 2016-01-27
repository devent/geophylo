package com.anrisoftware.geophylo.epochwindow;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
class AddAction implements ClickListener {

    private FieldGroup binder;

    private EpochWindow epochWindow;

    public void setBinder(FieldGroup binder) {
        this.binder = binder;
    }

    public void setWindow(EpochWindow epochWindow) {
        this.epochWindow = epochWindow;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        try {
            binder.commit();
        } catch (CommitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            epochWindow.close();
        }
    }

}

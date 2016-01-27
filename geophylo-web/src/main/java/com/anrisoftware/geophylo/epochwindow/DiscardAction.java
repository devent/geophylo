package com.anrisoftware.geophylo.epochwindow;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
class DiscardAction implements ClickListener {

    private FieldGroup binder;

    public void setBinder(FieldGroup binder) {
        this.binder = binder;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        binder.discard();
    }

}

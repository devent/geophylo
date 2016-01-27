package com.anrisoftware.geophylo.epochwindow;

import javax.inject.Inject;

import com.anrisoftware.geophylo.db.hibernate.EpochEntity;
import com.anrisoftware.geophylo.epochwindow.EpochProperties.EpochPropertiesFactory;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class EpochWindow extends Window {

    public interface EpochWindowFactory {

        EpochWindow create(EpochEntity epoch);

    }

    private final EpochProperties epoch;

    private Button addButton;

    private Button discardButton;

    private Button cancelButton;

    @Inject
    private AddAction addAction;

    @Inject
    private DiscardAction discardAction;

    @Inject
    private CancelAction cancelAction;

    @Inject
    EpochWindow(@Assisted EpochEntity epoch,
            EpochPropertiesFactory epochPropertiesFactory) {
        this.epoch = epochPropertiesFactory.create(epoch);
    }

    public EpochWindow createWindow() {
        setCaption("Add Epoch");
        setModal(true);
        center();
        FormLayout form = new FormLayout();
        setContent(form);

        FieldGroup binder = new FieldGroup(epoch.getItem());
        form.addComponent(binder.buildAndBind("Preferred", "preferred"));
        form.addComponent(binder.buildAndBind("Rank", "rank"));
        form.addComponent(binder.buildAndBind("Older Bound", "olderBound"));
        form.addComponent(binder.buildAndBind("Yougher Bound", "yougherBound"));

        this.addButton = new Button("Add", addAction);
        addAction.setWindow(this);
        addAction.setBinder(binder);
        form.addComponent(addButton);

        this.discardButton = new Button("Discard", discardAction);
        discardAction.setBinder(binder);
        form.addComponent(discardButton);

        this.cancelButton = new Button("Cancel", cancelAction);
        cancelAction.setWindow(this);
        form.addComponent(cancelButton);

        return this;
    }
}

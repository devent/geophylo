package com.anrisoftware.geophylo.epochwindow;

import javax.inject.Inject;

import com.anrisoftware.geophylo.db.hibernate.EpochEntity;
import com.anrisoftware.geophylo.epochwindow.EpochForm.EpochFormFactory;
import com.anrisoftware.geophylo.epochwindow.EpochProperties.EpochPropertiesFactory;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class EpochWindow extends Window {

    public interface EpochWindowFactory {

        EpochWindow create(EpochEntity epoch);

    }

    private final EpochProperties epoch;

    @Inject
    private transient EpochFormFactory epochFormFactory;

    @Inject
    private AddAction addAction;

    @Inject
    private DiscardAction discardAction;

    @Inject
    private CancelAction cancelAction;

    private Button addButton;

    private Button discardButton;

    private Button cancelButton;

    private EpochForm epochForm;

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
        form.setMargin(true);
        setContent(form);

        this.epochForm = epochFormFactory.create(epoch);

        epochForm.createForm();
        form.addComponent(epochForm);

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        form.addComponent(buttonsLayout);

        this.addButton = new Button("Add", addAction);
        addAction.setWindow(this);
        addAction.setEpochForm(epochForm);
        buttonsLayout.addComponent(addButton);

        this.discardButton = new Button("Discard", discardAction);
        discardAction.setEpochForm(epochForm);
        buttonsLayout.addComponent(discardButton);

        this.cancelButton = new Button("Cancel", cancelAction);
        cancelAction.setWindow(this);
        buttonsLayout.addComponent(cancelButton);

        return this;
    }
}

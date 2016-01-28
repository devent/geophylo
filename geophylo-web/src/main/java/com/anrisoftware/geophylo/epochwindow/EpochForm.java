package com.anrisoftware.geophylo.epochwindow;

import java.util.Arrays;
import java.util.Locale;

import javax.inject.Inject;

import com.anrisoftware.geophylo.db.model.Rank;
import com.anrisoftware.geophylo.resources.TextsProvider;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.validator.DoubleRangeValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
class EpochForm extends CustomComponent {

    interface EpochFormFactory {

        EpochForm create(EpochProperties epoch);

    }

    private final FieldGroup binder;

    @Inject
    private TextsProvider textsProvider;

    @PropertyId("preferred")
    final TextField preferredField = new TextField("Preferred:");

    @PropertyId("rank")
    final ComboBox rankField = new ComboBox("Rank:", Arrays.asList(Rank
            .values()));

    @PropertyId("olderBound")
    final TextField olderBoundField = new TextField("Older Bound:");

    @PropertyId("youngerBound")
    final TextField youngerBoundField = new TextField("Younger Bound:");

    @Inject
    @PropertyId("broaderEpoch")
    BroaderEpochList broaderEpochList;

    @Inject
    @PropertyId("narrowerEpoch")
    NarrowerEpochList narrowerEpochList;

    @Inject
    EpochForm(@Assisted EpochProperties epoch) {
        this.binder = new FieldGroup(epoch);
        setLocale(Locale.getDefault());
    }

    public void commit() throws CommitException {
        binder.commit();
    }

    public void discard() {
        binder.discard();
    }

    public EpochForm createForm() {
        Locale locale = getLocale();
        String notEmptyText = textsProvider.get()
                .getResource("validator_not_empty", locale).getText();
        String mustBeSetText = textsProvider.get()
                .getResource("validator_must_be_set", locale).getText();
        String notNegativeText = textsProvider.get()
                .getResource("validator_not_negative", locale).getText();
        preferredField
                .addValidator(new RegexpValidator("[\\w]+", notEmptyText));
        preferredField.setImmediate(true);
        rankField.addValidator(new NullValidator(mustBeSetText, false));
        rankField.setImmediate(true);
        olderBoundField.addValidator(new DoubleRangeValidator(notNegativeText,
                0d, Double.MAX_VALUE));
        olderBoundField.setImmediate(true);
        youngerBoundField.addValidator(new DoubleRangeValidator(
                notNegativeText, 0d, Double.MAX_VALUE));
        youngerBoundField.setImmediate(true);

        broaderEpochList.createList();
        narrowerEpochList.createList();
        FormLayout layout = new FormLayout();
        layout.addComponent(preferredField);
        layout.addComponent(rankField);
        layout.addComponent(olderBoundField);
        layout.addComponent(youngerBoundField);

        HorizontalLayout epochListLayoyt = new HorizontalLayout();
        layout.addComponent(epochListLayoyt);
        epochListLayoyt.addComponent(broaderEpochList);
        epochListLayoyt.addComponent(narrowerEpochList);

        binder.bindMemberFields(this);
        setCompositionRoot(layout);
        return this;
    }

}

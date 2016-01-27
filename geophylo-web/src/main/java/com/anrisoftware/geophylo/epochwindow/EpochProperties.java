package com.anrisoftware.geophylo.epochwindow;

import javax.inject.Inject;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.anrisoftware.geophylo.db.hibernate.EpochEntity;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;

class EpochProperties {

    interface EpochPropertiesFactory {

        EpochProperties create(EpochEntity epoch);

    }

    private final PropertysetItem item;

    private final EpochEntity epoch;

    @Inject
    EpochProperties(@Assisted EpochEntity epoch) {
        this.epoch = epoch;
        this.item = new PropertysetItem();
        item.addItemProperty("preferred",
                new ObjectProperty<String>(epoch.getPreferred(), String.class));
        item.addItemProperty("rank", new ObjectProperty<String>(
                epoch.getRank(), String.class));
        item.addItemProperty("olderBound",
                new ObjectProperty<Double>(epoch.getOlderBound(), Double.class));
        item.addItemProperty("yougherBound",
                new ObjectProperty<Double>(epoch.getYougherBound(),
                        Double.class));
    }

    public EpochEntity getEpoch() {
        return epoch;
    }

    public PropertysetItem getItem() {
        return item;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(epoch).toString();
    }
}

package com.anrisoftware.geophylo.epochwindow;

import javax.inject.Inject;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.anrisoftware.geophylo.db.hibernate.EpochEntity;
import com.google.inject.assistedinject.Assisted;
import com.vaadin.data.util.BeanItem;

@SuppressWarnings("serial")
class EpochProperties extends BeanItem<EpochEntity> {

    interface EpochPropertiesFactory {

        EpochProperties create(EpochEntity epoch);

    }

    private final EpochEntity epoch;

    @Inject
    EpochProperties(@Assisted EpochEntity epoch) {
        super(epoch);
        this.epoch = epoch;
    }

    public EpochEntity getEpoch() {
        return epoch;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(epoch).toString();
    }
}

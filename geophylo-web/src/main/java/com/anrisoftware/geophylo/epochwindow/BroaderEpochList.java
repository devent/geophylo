package com.anrisoftware.geophylo.epochwindow;

import com.vaadin.ui.ListSelect;

@SuppressWarnings("serial")
class BroaderEpochList extends ListSelect {

    BroaderEpochList createList() {
        setCaption("Select Broader:");
        return this;
    }
}

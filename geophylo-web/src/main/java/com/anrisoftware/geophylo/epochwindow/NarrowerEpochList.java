package com.anrisoftware.geophylo.epochwindow;

import com.vaadin.ui.ListSelect;

@SuppressWarnings("serial")
class NarrowerEpochList extends ListSelect {

    NarrowerEpochList createList() {
        setCaption("Narrower Epoch:");
        return this;
    }
}

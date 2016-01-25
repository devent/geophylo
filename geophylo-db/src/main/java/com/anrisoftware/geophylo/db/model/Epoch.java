package com.anrisoftware.geophylo.db.model;

import java.util.List;
import java.util.Locale;

public interface Epoch {

    Integer getId();

    String getPreferred();

    String getName(Locale locale);

    String getRank();

    double getOlderBound();

    double getYougherBound();

    List<Epoch> getBroader();

    List<Epoch> getNarrower();
}

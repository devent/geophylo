package com.anrisoftware.geophylo.db.model;

import java.util.List;
import java.util.Locale;

public interface Epoch {

    Integer getId();

    String getPreferred();

    String getName(Locale locale);

    Rank getRank();

    double getOlderBound();

    double getYoungerBound();

    List<Epoch> getBroader();

    List<Epoch> getNarrower();
}

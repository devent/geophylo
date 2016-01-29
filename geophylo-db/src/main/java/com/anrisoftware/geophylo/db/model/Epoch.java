package com.anrisoftware.geophylo.db.model;

import java.awt.Color;
import java.util.List;
import java.util.Locale;

public interface Epoch {

    Integer getId();

    String getPreferred();

    String getName(Locale locale);

    Rank getRank();

    double getOlderBound();

    double getYoungerBound();

    Epoch getBroader();

    List<? extends Epoch> getNarrower();

    Color getColor();

    EarthMap getEarthMap();

}

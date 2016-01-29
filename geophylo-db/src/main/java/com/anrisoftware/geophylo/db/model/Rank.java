package com.anrisoftware.geophylo.db.model;

/**
 * Time span in geochronology.
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 1.0
 */
public enum Rank {

    /**
     * 1 total.
     */
    supereon,

    /**
     * 4 total, half a billion years or more.
     */
    eon,

    /**
     * 10 defined, several hundred million years.
     */
    era,

    /**
     * 22 defined, tens to ~one hundred million years.
     */
    period,

    /**
     * 34 defined, tens of millions of years.
     */
    epoch,

    /**
     * 99 defined, millions of years.
     */
    age,

    /**
     * subdivision of an age, not used by the ICS timescale.
     */
    chron,

    glaciation,
}

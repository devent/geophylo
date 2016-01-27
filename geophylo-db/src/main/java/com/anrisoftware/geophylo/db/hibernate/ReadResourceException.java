package com.anrisoftware.geophylo.db.hibernate;

import java.io.IOException;

@SuppressWarnings("serial")
public class ReadResourceException extends GeophyloDatabaseException {

    public ReadResourceException(String resource, IOException e) {
        super("Error read resource", e);
        addContextValue("resource", resource);
    }

}

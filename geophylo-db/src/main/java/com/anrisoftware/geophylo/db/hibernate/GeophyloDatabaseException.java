package com.anrisoftware.geophylo.db.hibernate;

import org.apache.commons.lang3.exception.ContextedException;

@SuppressWarnings("serial")
public class GeophyloDatabaseException extends ContextedException {

    protected GeophyloDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    protected GeophyloDatabaseException(String message) {
        super(message);
    }

}

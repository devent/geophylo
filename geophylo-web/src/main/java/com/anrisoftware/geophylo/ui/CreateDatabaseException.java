package com.anrisoftware.geophylo.ui;

import javax.servlet.ServletException;

@SuppressWarnings("serial")
public class CreateDatabaseException extends ServletException {

    public CreateDatabaseException(Exception e) {
        super("Error creating database", e);
    }

}

package com.anrisoftware.geophylo.db.jpa;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class JpaInitializer {

    private final PersistService persistService;

    @Inject
    JpaInitializer(PersistService service) {
        this.persistService = service;
        persistService.start();
    }

    public void stopService() {
        persistService.stop();
    }
}

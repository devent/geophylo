package com.anrisoftware.geophylo.db.hibernate

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import org.junit.Test

import com.anrisoftware.geophylo.db.jpa.AbstractJpa

@CompileStatic
@Slf4j
class LoadEpochEntitiesTest extends AbstractJpa {

    @Test
    void "insert epoch"() {
        insertEpochs()
    }
}

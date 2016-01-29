package com.anrisoftware.geophylo.db.hibernate

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import javax.inject.Inject
import javax.persistence.EntityManager

import org.junit.After
import org.junit.Before
import org.junit.Test

import com.anrisoftware.geophylo.db.hibernate.EpochEntity.EpochEntityFactory
import com.anrisoftware.geophylo.db.jpa.JpaGuiceModule
import com.anrisoftware.geophylo.db.jpa.JpaInitializer
import com.anrisoftware.geophylo.db.model.Rank
import com.google.inject.Guice

@CompileStatic
@Slf4j
public class EpochEntityTest {

    @Test
    void "insert epoch"() {
        def epoch = epochEntityFactory.create()
        epoch.preferred = 'Precambrian'
        epoch.rank = Rank.eon
        epoch.olderBound = 4600
        epoch.youngerBound = 541
        epoch.names = [:]
        epoch.names << [(Locale.ENGLISH): 'Precambrian']
        epoch.names << [(Locale.GERMAN): 'Präkambrium']
        em.persist epoch
        log.info 'persis {}', epoch
    }

    @Inject
    EpochEntityFactory epochEntityFactory

    @Inject
    EntityManager em

    @Inject
    JpaInitializer jpaInitializer

    @Before
    void setUp() {
        Guice.createInjector(new JpaGuiceModule(), new DatabaseEntitiesModule()).injectMembers(this);
        em.getTransaction().begin();
    }

    @After
    void cleanUp() {
        em.getTransaction().rollback();
        jpaInitializer.stopService();
    }
}

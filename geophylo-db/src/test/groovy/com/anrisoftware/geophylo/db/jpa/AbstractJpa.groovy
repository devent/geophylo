package com.anrisoftware.geophylo.db.jpa

import static com.anrisoftware.globalpom.utils.TestUtils.*
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import javax.inject.Inject
import javax.persistence.EntityManager

import org.junit.After
import org.junit.Before
import org.junit.BeforeClass

import com.anrisoftware.geophylo.db.hibernate.DatabaseEntitiesModule
import com.anrisoftware.geophylo.db.hibernate.EpochEntity
import com.anrisoftware.geophylo.db.hibernate.EpochEntity.EpochEntityFactory
import com.anrisoftware.geophylo.db.hibernate.EpochsModel.EpochsModelFactory
import com.anrisoftware.geophylo.db.resources.Epochs
import com.google.inject.Guice

@Slf4j
@CompileStatic
abstract class AbstractJpa {

    @Inject
    EpochEntityFactory epochEntityFactory

    @Inject
    EpochsModelFactory epochsModelFactory

    @Inject
    EntityManager em

    @Inject
    JpaInitializer jpaInitializer

    @BeforeClass
    static void setupClass() {
        toStringStyle
    }

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

    void insertEpochs() {
        def epochs = new Epochs()
        epochs.binding['epochEntityFactory'] = epochEntityFactory
        List<EpochEntity> epochsList = epochs.run() as List
        epochsList.eachWithIndex { EpochEntity entity, int k ->
            log.info '{}. persist entity {}', k, entity
            em.persist entity
        }
    }
}

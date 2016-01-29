package com.anrisoftware.geophylo.db.hibernate

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import org.junit.Test

import com.anrisoftware.geophylo.db.jpa.AbstractJpa
import com.anrisoftware.geophylo.db.model.Rank

/**
 * @see EpochsModel
 *
 * @author Erwin Müller, erwin.mueller@deventm.de
 * @since 1.0
 */
@Slf4j
@CompileStatic
class EpochsModelTest extends AbstractJpa {

    @Test
    void "retrieve epochs"() {
        insertEpochs()
        def model = epochsModelFactory.create 'countAllEpochs', 'reportAllEpochs'
        List<EpochEntity> entities = []
        model.setPageSize 10
        (0..<model.size).each { int i ->
            def entity = model.getElementAt i
            log.info '{}. entity: {}', i, entity
            entities << entity
        }
        assert entities.size() == 70
    }

    @Test
    void "retrieve ranks"() {
        insertEpochs()
        def testCases = [
            [
                params: [rank: Rank.era],
                expectedSize: 8,
            ],
            [
                params: [rank: Rank.period],
                expectedSize: 14,
            ],
            [
                params: [rank: Rank.epoch],
                expectedSize: 14,
            ],
            [
                params: [rank: Rank.age],
                expectedSize: 27,
            ],
        ]
        testCases.eachWithIndex { Map test, int k ->
            log.info '{}. case: {}', k, test
            def model = epochsModelFactory.create 'countEpochsRank', 'reportEpochsRank', test.params as Map<String, Object>
            List<EpochEntity> entities = []
            model.setPageSize 10
            (0..<model.size).each { int i ->
                def entity = model.getElementAt i
                entities << entity
            }
            assert entities.size() == test.expectedSize
        }
    }
}

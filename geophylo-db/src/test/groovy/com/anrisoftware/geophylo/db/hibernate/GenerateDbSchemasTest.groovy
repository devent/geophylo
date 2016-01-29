package com.anrisoftware.geophylo.db.hibernate

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import org.apache.commons.io.FileUtils
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import com.anrisoftware.geophylo.db.hibernate.SchemaGenerator.Dialect


@Slf4j
@CompileStatic
class GenerateDbSchemasTest {

    @Test
    void "generate schemas"() {
        def generator = new SchemaGenerator('com.anrisoftware.geophylo.db.hibernate', Dialect.HSQL)
        def dir = folder.newFolder()
        def dialect = Dialect.HSQL
        def file = generator.generate(dir)
        assert file.isFile() == true
        log.info "Generated schema: ```{}'''", FileUtils.readFileToString(file)
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder()
}

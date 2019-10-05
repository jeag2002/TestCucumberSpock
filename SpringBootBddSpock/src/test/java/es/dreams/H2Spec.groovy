package es.dreams

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

import spock.lang.Narrative
import spock.lang.Title
import spock.lang.Specification

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType


@Title("Application Specification")
@Narrative("Specification which beans are expected")


//@SpringBootTest(classes = SpockApplication.class)
@SpringBootTest
class H2Spec extends Specification {
	
    EmbeddedDatabase db
    JdbcTemplate jT
	
	
	def "basic selection"(){
		given:
		
		def result = ""
		
		db = new EmbeddedDatabaseBuilder()
		.setName("testdb;MODE=MySQL;DB_CLOSE_ON_EXIT=false")
		.setType(EmbeddedDatabaseType.H2)
		.addScript("schema.sql")
		.addScript("data.sql")
		.build()
		
		jT = new JdbcTemplate(db)
			
		when:
		
		result = jT.queryForObject("select Full_Name from PERSON where id = 1",String.class)
		
		then:
		
		result == "PEPE"
	}
	
}
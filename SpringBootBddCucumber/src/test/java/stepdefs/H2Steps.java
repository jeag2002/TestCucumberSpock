package stepdefs;

import static org.testng.Assert.assertEquals;

import java.text.MessageFormat;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class H2Steps {
	
	
	private EmbeddedDatabase db;
	private JdbcTemplate jT;
	private String result;
	
	private static final String QUERY_H2 = "select Full_Name from PERSON where id = {0}";
	
	
	@Given("a database created")
	public void testDataBaseCreation() {
		
		db = new EmbeddedDatabaseBuilder()
				.setName("testdb;MODE=MySQL;DB_CLOSE_ON_EXIT=false")
				.setType(EmbeddedDatabaseType.H2)
				.addScript("schema.sql")
				.addScript("data.sql")
				.build();
		
		jT = new JdbcTemplate(db);
	}
	
	@When ("^I query (\\d+)$")
    public void i_query(int arg1) throws Throwable {
		
		String msg_sql = MessageFormat.format(QUERY_H2, arg1);
		
		result = "";
		
		try {
			result = jT.queryForObject(msg_sql,String.class);
		}catch(Exception e) {
			
		}
    }
	
	@Then("the result is (.+)$")
    public void the_result_is(String expected) {
        assertEquals(expected, result);
    }

}

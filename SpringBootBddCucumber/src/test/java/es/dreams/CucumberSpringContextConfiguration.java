package es.dreams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.Before;

@SpringBootTest(classes = CucumberApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("integration_test")
@ContextConfiguration

public class CucumberSpringContextConfiguration {
	
	private static final Logger LOG = LoggerFactory.getLogger(CucumberSpringContextConfiguration.class);
	
	 @Before
	 public void setUp() {
	    LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
	 }

}

package stepdefs;



/*
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

import es.dreams.calculator.RpnCalculator;
import io.cucumber.testng.AbstractTestNGCucumberTests;



public class RpnCalculatorTest  extends AbstractTestNGCucumberTests{
	
	private RpnCalculator calc;
	
	@Given("a calculator I just turned on")
	public void a_calculator_I_just_turned_on() {
		calc = new RpnCalculator();
	    throw new cucumber.api.PendingException();
	}

	@When("I add {int} and {int}")
	public void i_add_and(Integer int1, Integer int2) {
        calc.push(int1);
        calc.push(int1);
        calc.push("+");
	    throw new cucumber.api.PendingException();
	}
	
	@Given("^I press (.+)$")
    public void I_press(String what) {
        calc.push(what);
    }
	
	 @After
	 public void after(Scenario scenario) {
	 }
	

	@Then("the result is {int}")
	public void the_result_is(Integer int1) {
		assertEquals(int1, calc.value());
	    throw new cucumber.api.PendingException();
	}

	@Given("the previous entries:")
	public void the_previous_entries(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new cucumber.api.PendingException();
	}	
	
}
*/


import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.testng.Assert.assertEquals;

import es.dreams.calculator.RpnCalculator;
import stepdefs.beans.OperationBean;

public class RpnCalculatorSteps {
	
    private RpnCalculator calc;

    @Given("a calculator I just turned on")
    public void a_calculator_I_just_turned_on() {
        calc = new RpnCalculator();
    }
    
    @When("^I add (\\d+) and (\\d+)$")
    public void i_add_and(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    	calc.push(arg1);
        calc.push(arg2);
        calc.push("+");
    }


    @Given("^I press (.+)$")
    public void I_press(String what) {
        calc.push(what);
    }

    @Then("the result is (\\d+)$")
    public void the_result_is(Integer expected) {
        assertEquals(expected, calc.value());
    }
    
    
    
    @Given("^the previous entries:$")
    public void the_previous_entries(DataTable arg1) throws Throwable {
    	
    	List<OperationBean> ops = arg1.asList(OperationBean.class);
    	
    	ops.forEach(e->{
    		calc.push(e.getFirst());
    		calc.push(e.getSecond());
    		calc.push(e.getOperation());
    	});
    	
    	
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        //throw new PendingException();
    }
    
    

    /*
    @Before("not @foo")
    public void before() {
        System.out.println("Runs before scenarios *not* tagged with @foo");
    }
	*/
    
    
    @After
    public void after(Scenario scenario) {
        // result.write("HELLLLOO");
    }

}

package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.PayrollPage;

public class PayrollSteps extends DriverFactory {

	
	@When("^I am on Payroll page$")
	public void i_am_on_PayrollPage() throws Throwable{
		
		new PayrollPage(driver).NavigateToPayroll();
	}
	
	
	@Then("^I should see No access error message displayed$")
	public void I_should_see_No_access_error() throws Throwable{
		
		new PayrollPage(driver).verifyNoAccessMsg();
		
		
	}

}

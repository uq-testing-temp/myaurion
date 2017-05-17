package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageclasses.EmploymentHistoryPage;
import pageclasses.PersonalDetailsPage;

public class EmploymentHistoryStep extends DriverFactory {
	
	
	
	
	@Given("^I navigate to Employment history page$")
	public void I_navigate_emphistory_page() throws Throwable{
		
		new EmploymentHistoryPage(driver).Navigate_to_empHistoryPage();
		
	}
	
	
	
	@Given("^I select the current placement position$")
	public void I_select_current_placemente() throws Throwable{
		
		new EmploymentHistoryPage(driver).select_Current_Placement();
		
	}

	
	
	@Then("^I should see my current placement details$")
	public void I_see_empl_history_placements() throws Throwable{
		
		new EmploymentHistoryPage(driver).verify_Emp_histor_Current_roleDetails();
		
	}
}

package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.TimesheetPage;
import pageclasses.EmployeeSearchPage;

public class EmployeeSearchSteps extends DriverFactory{



	
	@Given("^I click on change Employee icon$")
	public void I_Click_change_Employee_Icon() throws Throwable{
		
		new EmployeeSearchPage(driver).ChangeEmployeeClick();
		
	}
	
	@Given("^I enter the employee search phrase\"(.*)\"$")
	public void I_Enter_Employee_SearchPhrase(String searchphase)throws Throwable {
		
		new EmployeeSearchPage(driver).EnterSearchText(searchphase);
		
	}
	
	@Given("^I should see the matching search result\"(.*)\"$")
	public void I_Select_the_Result(String toselect) throws Throwable{
		new EmployeeSearchPage(driver).SelectfromSearchResult(toselect);
	}
	
	@Given("^I select the employee from search results\"(.*)\"$")
	public void i_select_employee_from_results(String toselect)throws Throwable{
		new EmployeeSearchPage(driver).SelectfromSearchResult(toselect);
	}
	
	@Then ("^I should see the details of the selected user\"(.*)\"$")
	public void Verify_Selected_User(String EmployeeSeleted) throws Throwable{
		
		new EmployeeSearchPage(driver).verifyUserDetails(EmployeeSeleted);
	}
	
	@Then("^I should see the No results found message$")
	public void I_should_see_No_results_found_message() throws Throwable{
		
		new EmployeeSearchPage(driver).VerifyNoResults();
	}

}

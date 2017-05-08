package stepDefinition;

import cucumber.api.java.en.Given;
import pageclasses.PersonalDetailsPage;

public class PersonalDetailsSteps extends DriverFactory {

	public PersonalDetailsSteps() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Given("^I navigate to Personal page$")
	public void I_navigate_to_Personal_page() throws Throwable{
		
		new PersonalDetailsPage(driver).NavigateToPersonalPage();
		
	}
	
	@Given("^I select to Add a new Emrgency contact$")
	public void Click_Add_New_contact() throws Throwable{
		
		new PersonalDetailsPage(driver).AddNewContact();
	}
	
	@Given("^I Add\"(.*)\"$")
	public void Enter_Details() throws Throwable{
		
		
	}

}

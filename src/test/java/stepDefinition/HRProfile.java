package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageclasses.HRProfilePage;
import pageclasses.PersonalDetailsPage;

public class HRProfile extends DriverFactory {

	public HRProfile() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Given("^I navigate to HR Profile page$")
	public void I_navigate_to_HRProfile_page() throws Throwable{
		
		new HRProfilePage(driver).NavigateToHRProfilePage();
		
	}
	
	
	
	@Then("^I should be able to see the Qualifications,Licences and Inductions details$")
	public void Check_HR_Profile_Details() throws Throwable{
		
		new HRProfilePage(driver).CheckDetailsHRProfile();
		
	}
	
	

}

package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageclasses.PersonalDetailsPage;
import pageclasses.TimesheetPage;

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
	
	@Given("^I Add priority\"(.*)\"$")
	public void Enter_priority(String priority) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_Priority(priority);
		
	}
	
	@Given("^I Add name\"(.*)\"$")
	public void Enter_name(String name) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_Name(name);
	
		
	}
	
	@Given("^I add homephone\"(.*)\"$")
	public void Enter_homephone(String homephone) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_HomePhone(homephone);
		
	}
	
	@Given("^I add mobile\"(.*)\"$")
	public void Enter_Mobile(String mobile) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_MobileNum(mobile);
		
	}
	
	@Given("^I add email\"(.*)\"$")
	public void Enter_Email(String email) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_Email(email);
		
	}
	
	@Given("^I add street\"(.*)\"$")
	public void Enter_Street(String street) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_Street(street);
		
	}
	
	@Given("^I add city\"(.*)\"$")
	public void Enter_city(String city) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_City_Suburb(city);
		
	}
	
	@Given("^I add state\"(.*)\"$")
	public void Enter_State(String state) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_state(state);
		
	}
	
	@Given("^I add comments\"(.*)\"$")
	public void Enter_Comments(String comments) throws Throwable{
		
		new PersonalDetailsPage(driver).Enter_comments(comments);
		
	}
	
	
	@Given("^I select relatioship\"(.*)\"$")
	public void I_Select_Relationship(String relationship) throws Throwable{
		
		new PersonalDetailsPage(driver).Select_Relationship(relationship);
		
	}
	
	
	@Given("^I select postcode\"(.*)\"$")
	public void I_Select_postcode(String postcode) throws Throwable{
		
		new PersonalDetailsPage(driver).Select_postcode(postcode);
		
	}
	
	@Given("^I select country\"(.*)\"$")
	public void I_Select_country(String country) throws Throwable{
		
		new PersonalDetailsPage(driver).Select_country(country);
		
	}
	
	
	@Given("^I click Save button$")
	public void I_click_Save() throws Throwable{
		
		new PersonalDetailsPage(driver).Click_Save();
		
	}
	
	@Given("^I select NextofKin Yes or No\"(.*)\"$")
	public void I_select_nextofKin(String YesNo) throws Throwable{
		
		if(YesNo.equalsIgnoreCase("Yes")){
		new PersonalDetailsPage(driver).Click_Save();
		}
	}
	
	
	
	
	@Then("^I should see the record successfully saved message displayed\"(.*)\"$")
	public void i_should_see_record_saved_message_displayed(String name) throws Throwable {
		new PersonalDetailsPage(driver).Save_success(name);
	}


}

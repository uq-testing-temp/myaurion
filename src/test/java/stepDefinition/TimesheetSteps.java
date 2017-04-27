package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.TimesheetPage;

public class TimesheetSteps extends DriverFactory {
	
	@Given("^I am on timesheet page$")
	public void I_am_on_timesheet_page() throws Throwable {
		new TimesheetPage(driver).timesheet_page();
	}

	@Given("^I select the daily timesheet$")
	public void i_select_the_daily_timesheet() throws Throwable {
		new TimesheetPage(driver).daily_timesheet();
	}
	
	@Given("^I select the date$")
	public void i_select_the_date() throws Throwable {
		new TimesheetPage(driver).select_date();
	}
	
	@Given("^I add contact hours button$")
	public void i_add_contact_hours_button() throws Throwable {
		new TimesheetPage(driver).add_contact_hours();
	}
	
	@Given("^I select contact hours type$")
	public void i_select_contact_hours_type() throws Throwable {
		new TimesheetPage(driver).select_contact_hrs_type();
	}
	
	@Given("^I enter course code as \"([^\"]*)\"$")
	public void i_enter_course_code_as(String code) throws Throwable {
		new TimesheetPage(driver).enter_code(code);
	}
	
	@Given("^I enter start time as \"([^\"]*)\"$")
	public void i_enter_start_time_as(String starttime) throws Throwable {
		new TimesheetPage(driver).enter_start_time(starttime);
	}
	
	@Given("^I enter stop time as \"([^\"]*)\"$")
	public void i_enter_stor_tie_as(String stoptime) throws Throwable {
		new TimesheetPage(driver).enter_stop_time(stoptime);
	}
	
	@Given("^I click on save$")
	public void i_click_on_save() throws Throwable {
		new TimesheetPage(driver).save_close_modal();
	}
	
	@When("^I click on submit timesheet$")
	public void i_click_on_submit_timesheet() throws Throwable {
		new TimesheetPage(driver).submit_timesheet();
	}
	
	@Then("^I should see the timesheet is saved message displayed$")
	public void i_should_see_the_timesheet_is_saved_message_displayed() throws Throwable {
		new TimesheetPage(driver).timesheet_success();
	}
	
	@Given("^I select the timekeeper as \"([^\"]*)\"$")
	public void i_select_the_timekeeper(String time) throws Throwable {
		new TimesheetPage(driver).select_timekeeper(time);
	}
}

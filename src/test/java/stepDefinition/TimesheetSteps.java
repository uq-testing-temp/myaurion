package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.LeavePage;
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
	
	@Given("^I select the date to enter time \"(.*)\"$")
	public void i_select_the_mentioned_date(String date) throws Throwable {
		new TimesheetPage(driver).select_dates(date);
	}
	
	
	
	@Given("^I select another date$")
	public void i_select_another_date() throws Throwable {
		new TimesheetPage(driver).select_otherdate();
	}
	
	@Given("^I add contact hours button$")
	public void i_add_contact_hours_button() throws Throwable {
		new TimesheetPage(driver).add_contact_hours();
	}
	
	
	
	@Given("^I click on detailed view Add button$")
	public void i_add_contact_hours_button_Detailed() throws Throwable {
		new TimesheetPage(driver).DetailedViewAddHrs_Click();
	}
	
	
	
	@Given("^I click on period view Add button$")
	public void i_add_contact_hours_button_periodview() throws Throwable {
		new TimesheetPage(driver).PeriodViewAddHrs_Click();
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
	
	@Given("^I click on Done$")
	public void i_click_on_Done() throws Throwable {
		new TimesheetPage(driver).Click_Done();
	}
	
	@When("^I click on submit timesheet$")
	public void i_click_on_submit_timesheet() throws Throwable {
		new TimesheetPage(driver).submit_timesheet();
	}
	
	
	@Given("^I click on Edit button$")
	public void i_click_on_edit() throws Throwable {
		new TimesheetPage(driver).Edit_timesheet();
	}
	
	@Then("^I should see the timesheet is saved message displayed$")
	public void i_should_see_the_timesheet_is_saved_message_displayed() throws Throwable {
		new TimesheetPage(driver).timesheet_success();
	}
	
	
	
	@Then("^I should see the timesheet Line is saved message displayed$")
	public void i_should_see_the_timesheet_Line_is_saved_message_displayed() throws Throwable {
		new TimesheetPage(driver).timesheet_Update_success();
	}
	
	@Given("^I select the timekeeper as \"([^\"]*)\"$")
	public void i_select_the_timekeeper(String time) throws Throwable {
		new TimesheetPage(driver).select_timekeeper(time);
		
	}
	
	@Given("^I click on SaveandCopy button$")
	public void i_click_on_saveandCopy() throws Throwable {
		new TimesheetPage(driver).save_and_copy();
	}
	
	@Then("^I should see the timesheet not available message displayed$")
	public void i_should_see_the_timesheet_not_available_message_displayed() throws Throwable {
		new TimesheetPage(driver).timesheet_not_available_message();
	}
	
	@When("^I click on View full list$")
	public void i_click_on_view_full_list() throws Throwable {
		new TimesheetPage(driver).ClickViewFullList();
	}
	
	@When("^I select the current timesheet$")
	public void i_select_current_ttimesheet() throws Throwable {
		new TimesheetPage(driver).SelectcurrenttimesheetInlist();
	}
	
	@When("^I select the old timesheet$")
	public void i_select_old_timesheet() throws Throwable {
		new TimesheetPage(driver).SelectcurrenttimesheetInlist();
	}
	
	@When("^I click on Set as Default button and click OK$")
	public void select_set_as_default() throws Throwable{
		new TimesheetPage(driver).SetAsDefault();
	}
	
	@When("^I click on Reset button and click OK$")
	public void Reset_TimeSheet() throws Throwable{
		new TimesheetPage(driver).ResetTimesheet();
		
	}
	
	@When("^I Close the notification$")
	public void I_Close_Notification() throws Throwable{
		
		new TimesheetPage(driver).CloseNotification();
	}
	
	
	@When("^I action the timesheet \"(.*)\"$")
	public void i_action_pending_timesheet(String action) throws Throwable {
		new TimesheetPage(driver).ActionTimeSheer(action);
	}
	
	@When("^I select the view \"(.*)\"$")
	public void i_select_timesheet_view(String view) throws Throwable {
		new TimesheetPage(driver).selectTimesheetView(view);
	}
	
	
	@When("^I click add hours button for date\"(.*)\"$")
	public void i_select_addhrs_button_forDate(String date) throws Throwable {
		new TimesheetPage(driver).AddHrsFordate(date);
	}
	
	
	
	
	@When("^I select the timesheet from full list \"(.*)\"$")
	public void i_select_timesheetfrom_table_forDate(String date) throws Throwable {
		new TimesheetPage(driver).selectTimesheetFromtable(date);
	}
	
	
	@When("^click on show from button$")
	public void i_click_showFrom_button_() throws Throwable {
		new TimesheetPage(driver).Click_ShowFrom();
	}
	
	
	/*@When("^I click on Forward button$")
	public void i_click_forward_button_() throws Throwable {
		new LeavePage(driver).ClickOnForward();
	}
	*/
	
	
	@When("^I perform recall timesheet action$")
	public void i_recall_timesheet_() throws Throwable {
		new TimesheetPage(driver).RecallTimesheet();
	}
	
	
	@Then("^I should see full list of my timesheets$")
	public void i_should_see_full_list_timesheet_displayed() throws Throwable {
		new TimesheetPage(driver).FullListViewTablepresent();
	}
	
	@Then("^I should see the timesheet warning alert message displayed$")
	public void i_should_see_timesheet_WarningAlert() throws Throwable {
		new TimesheetPage(driver).TimesheetErrorAlert();
	}
	
	
	
	@Then("^I should see the timesheet recalled message displayed$")
	public void i_should_see_timesheet_recall_successAlert() throws Throwable {
		new TimesheetPage(driver).timesheet_Recall_success();
	}
	
	
	
	
	
}

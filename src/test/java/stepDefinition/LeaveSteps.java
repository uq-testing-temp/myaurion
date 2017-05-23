package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.LeavePage;

public class LeaveSteps extends DriverFactory {
	
	@When("^I am on a new leave page$")
	public void i_am_on_a_new_leave_page() throws Throwable {
        new LeavePage(driver).new_leave_page();
    }
	
	@When("^I click apply for leave button$")
	public void i_click_apply_for_leave_button() throws Throwable {
		new LeavePage(driver).apply_for_leave_button();
	}
	
	@When("^I select the leave type as \"([^\"]*)\"$")
	public void i_select_the(String ltype) throws Throwable {
		new LeavePage(driver).select_leave_type(ltype);
	}
	
	@When("^I select the duration as \"([^\"]*)\"$")
	public void i_select_the_duration_as(String dur) throws Throwable {
		new LeavePage(driver).select_duration(dur);
	}
	
	@When("^I select the start date\"([^\"]*)\"$")
	public void i_select_the_start_date(String date) throws Throwable {
		new LeavePage(driver).select_startdate(date);
	}
	
	@When("^I select the end date\"([^\"]*)\"$")
	public void i_select_the_end_date(String date) throws Throwable {
		new LeavePage(driver).select_enddate(date);
	}
	
	@When("^I enter the message as \"([^\"]*)\"$")
	public void i_enter_the_message_as(String msg) throws Throwable {
		new LeavePage(driver).enter_message(msg);
	}
	
	@When("^I enter a future date\"([^\"]*)\"$")
	public void i_select_the_future_date(String date) throws Throwable {
		new LeavePage(driver).select_futuredate(date);
	}
	
	@When("^I enter the reference message as \"([^\"]*)\"$")
	public void i_enter_approve_message_as(String msg) throws Throwable {
		new LeavePage(driver).enter_Leave_Approve_message(msg);
	}
	
	@When("^I click submit button$")
	public void i_click_submit_button() throws Throwable {
		new LeavePage(driver).submit();
	}
	
	
	@When("^I click on the Predict button$")
	public void i_click_predict_button() throws Throwable {
		new LeavePage(driver).ClickOnPredictButton();
	}
	
	
	@When("^I am on leave page$")
	public void i_am_on_the_leave_page() throws Throwable {
		new LeavePage(driver).Navigate_to_Leavepgae();
	}
	
	
	@When("^I click on Delete button$")
	public void i_click_Delete_button() throws Throwable {
		new LeavePage(driver).ClickOnDelete();
	}
	
	
	@When("^I click on Approve button$")
	public void i_click_Approve_button() throws Throwable {
		new LeavePage(driver).ClickOnApprove();
	}
	
	
	@When("^I click on Decline button$")
	public void i_click_Decline_button() throws Throwable {
		new LeavePage(driver).ClickOnDecline();
	}
	
	@When("^I click on Return button$")
	public void i_click_Return_button() throws Throwable {
		new LeavePage(driver).ClickOnReturn();
	}
	
	
	
	
	@When("^I click on Forward button$")
	public void i_click_Forward_button() throws Throwable {
		new LeavePage(driver).ClickOnForward();
	}
	
	@When("^I click on Apply for Leave button$")
	public void i_click_apply_leave_button() throws Throwable {
		new LeavePage(driver).ClickApplyForLeaveButton();
	}
	
	@When("^I select my pending leave request$")
	public void i_select_pending_request() throws Throwable {
		new LeavePage(driver).selectPendingRequest();
	}
	
	
	
	@When("^I select my pending leave request from date\"(.*)\"to date\"(.*)\"$")
	public void i_select_pending_request_withdates(String start, String end) throws Throwable {
		new LeavePage(driver).selectPendingRequestBydate(start,end);
	}
	
	
	
	@When("^I action the leave request \"(.*)\"$")
	public void i_action_pending_requests(String action) throws Throwable {
		new LeavePage(driver).ActionLeaveRequest(action);
	}
	
	
	@When("^I select my Approved leave request dated\"(.*)\"$")
	public void i_select_approved_requests(String date) throws Throwable {
		new LeavePage(driver).selectApprovedRequestBydate(date);
	}
	
	
	@Then("^I should see the success message is displayed$")
	public void I_should_see_the_success_message_is_displayed() throws Throwable {
		new LeavePage(driver).success();
	}
	
	
	@Then("^I should see Delete success message displayed$")
	public void I_should_Delete_the_success_message_is_displayed() throws Throwable {
		new LeavePage(driver).Deletesuccess();
	}
	
	
	@Then("^I should see my \"(.*)\" leave balances displayed in days\"(.*)\"\"(.*)\"\"(.*)\"$")
	public void I_should_see_Leave_Balance_is_displayed(String type, String Avail, String Pending, String balance) throws Throwable {
		new LeavePage(driver).verifyLeaveBalance(type, Avail, Pending, balance);
	}
	
	
	
	@Then("^I should see my predicted leave balances displayed$")
	public void I_should_see_predicted_leave_column_is_displayed() throws Throwable {
		new LeavePage(driver).verifyPredictedLeaveDisplay();
	}
	
	
	@Then("^I should see workflow action successful message displayed$")
	public void I_should_WorkFlowAction_success_message_is_displayed() throws Throwable {
		new LeavePage(driver).WorkFlowActionsuccess();
	}
	
	@Then("^I should see Leave reversal successful message displayed$")
	public void I_should_reversal_success_message_is_displayed() throws Throwable {
		new LeavePage(driver).LeaveReversalActionsuccess();
	}
}
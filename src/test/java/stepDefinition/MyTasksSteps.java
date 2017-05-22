package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.When;
import pageclasses.LeavePage;
import pageclasses.MyTasksPage;
import pageclasses.PayrollPage;

public class MyTasksSteps extends DriverFactory {
	


	
	
	@When("^I am on MyTasks page$")
	public void i_am_on_the_MyTasks_page() throws Throwable {
		new MyTasksPage(driver).Navigate_to_Mytasks();
	}
	
	
	
	@When("^I select My tasks action \"(.*)\"$")
	public void I_Select_Mytasks_Action(String Action) throws Throwable{
		
		new MyTasksPage(driver).SelectMyTasks(Action);
	}
	
	
	
	@When("^I click on \"(.*)\"button for \"(.*)\"$")
	public void I_select_latest_old_Items(String WhichOne, String section) throws Throwable{
		
		new MyTasksPage(driver).selectRecent_OldItems(WhichOne,section);
	}
	
	
	
	
	@When("^I select the leave application for dated \"(.*)\"$")
	public void I_select_pending_LeaveApplications(String startdate) throws Throwable{
		
		new MyTasksPage(driver).SelectLeaveToAction(startdate);
	}
	
	@When("^I select the timesheet dated \"(.*)\"and of employee\"(.*)\"$")
	public void I_select_pending_timesheet(String startdate, String EmployeeName) throws Throwable{
		
		new MyTasksPage(driver).SelectTimeSheetoAction(startdate, EmployeeName);
	}

}

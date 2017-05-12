package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.PayrollPage;

public class PayrollSteps extends DriverFactory {

	
	@When("^I am on Payroll page$")
	public void i_am_on_PayrollPage() throws Throwable{
		
		new PayrollPage(driver).NavigateToPayroll();
	}
	
	
	@When("^I select Payroll action \"(.*)\"$")
	public void I_Select_Payroll_Action(String Action) throws Throwable{
		
		new PayrollPage(driver).SelectPayrollSections(Action);
	}
	
			
	@When("^I select the summary for date\"(.*)\"$")
	public void I_Select_summary_for_date(String dateval) throws Throwable{
		
		new PayrollPage(driver).SelectAPaysummary(dateval);
	}
	
	
	@When("^I select \"(.*)\" year summary$")
	public void I_select_specific_Year_summary(String current_previous) throws Throwable{
		
		new PayrollPage(driver).SelectYTDPaysummary(current_previous);
			
		
	}
	
	
	
	@Then("^I should see my pay summary details\"(.*)\"and\"(.*)\"$")
	public void I_should_see_PayDetails(String GrossPay, String Netpay) throws Throwable{
		
		new PayrollPage(driver).VerifyPayDetails(GrossPay,Netpay);;
			
		
	}
	
	
	
	@Then("^I should see No access error message displayed$")
	public void I_should_see_No_access_error() throws Throwable{
		
		new PayrollPage(driver).verifyNoAccessMsg();
			
		
	}
	
	
	@Then("^I should see my year to date summary details$")
	public void I_should_see_YTD_Details() throws Throwable{
		
		new PayrollPage(driver).checkYTDDetails();
			
		
	}
	
	@Then("^I should see summary pdf download link for date\"(.*)\"$")
	public void I_should_see_summary_pdf_download_link(String date) throws Throwable{
		
		new PayrollPage(driver).VerifyATOSummary_link(date);
			
		
	}


}

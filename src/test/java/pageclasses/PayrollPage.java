package pageclasses;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.DriverFactory;
import util.CustomFunctions;

public class PayrollPage extends DriverFactory {
	
	

	public PayrollPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy (xpath = "//*[@id='menu']/span/a[1]")
	private WebElement dashboardlink;
	
	@FindBy(linkText="Payroll")
	private WebElement PayrollLink;
	
	@FindBy(xpath=".//*[@id='main']")
	private WebElement ErrorMsg;
	
	
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Pay Summaries')]") 
	WebElement PaySummaries;
	
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Accounts and Deductions')]") 
	WebElement AccountsDeductions;
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Year to Date')]") 
	WebElement YTD;
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Payment Summaries')]") 
	WebElement ATOPaySummaries;
	
	
	
	@FindBy(xpath=".//*[@id='cells-pay-summaries']")
	WebElement PaySummaryList;
	
	@FindBy(xpath=".//*[@id='T550F285_GROSS']/following-sibling::dfn")
	WebElement GrossAmount;
	
	@FindBy(xpath=".//*[@id='T550F295_NET']/following-sibling::dfn")
	WebElement NetAmount;
	
	
	@FindBy(xpath=".//*[@id='tst-DOC_REQUEST_KEY']/dfn/a")
	WebElement PayAdviceLink;;
	
	
	
	public void NavigateToPayroll() throws Throwable{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		this.dashboardlink.click();
		Thread.sleep(500);
		this.PayrollLink.click();
	}
	
	
	public void verifyNoAccessMsg() throws Throwable{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//String text=ErrorMsg.getAttribute("Text");
		//Assert.assertFalse(text.trim().equalsIgnoreCase("Error: You do not have access to this function for the selected person."));
		Assert.assertTrue(ErrorMsg.isDisplayed());
	}
	
	
	
	public void SelectPayrollSections(String section) throws Throwable{
		
		if(section=="Accounts and Deductions"){
			CustomFunctions.CustomClick(this.AccountsDeductions, 5);
			
		}
		else if(section=="Year to Date"){
			CustomFunctions.CustomClick(this.YTD, 5);
			
		}
		
		else if(section.equalsIgnoreCase("Pay Summaries")){
			CustomFunctions.CustomClick(this.PaySummaries, 5);
			
		}
		
		else if(section=="ATO Payment Summaries"){
			CustomFunctions.CustomClick(this.ATOPaySummaries, 5);
			
		}
		
		
	}
	
	//String GrossPay=null;
	public void SelectAPaysummary(String strvalue) throws Throwable{
		
		CustomFunctions.SelectFromList(this.PaySummaryList, strvalue);
		
	}
	
	public void VerifyPayDetails(String gross, String net) throws Throwable{
		
		CustomFunctions.CustomAssertTrue("Thr Gross amount same as expected ", this.GrossAmount.getText().equals(gross));
		CustomFunctions.CustomAssertTrue("Thr Net amount same as expected ", this.NetAmount.getText().equals(net));
		CustomFunctions.CustomAssertTrue("The Pay Advice PDF link found", this.PayAdviceLink.isEnabled());
		
		
		
	}
	
	
	

}

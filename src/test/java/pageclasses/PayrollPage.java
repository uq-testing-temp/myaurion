package pageclasses;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.DriverFactory;

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
	

}

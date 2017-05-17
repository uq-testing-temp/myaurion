package pageclasses;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import stepDefinition.DriverFactory;
import util.CustomFunctions;

public class HRProfilePage extends DriverFactory {
	

	public HRProfilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath=".//*[@id='menu']/span/.//a[contains(text(),'Employee')]")
	WebElement EmployeeMenu;
	
	@FindBy(xpath=".//*[@id='menu-my-aurion-list']/li[2]/.//a[contains(text(),'HR Profile')]") 
	WebElement HRProfileMenu;
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Qualifications')]") 
	WebElement QualificationsSection;
	
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Licences')]") 
	WebElement LicencesSection;
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Inductions')]") 
	WebElement Inductions;
	
	
	
	
public void NavigateToHRProfilePage() throws Throwable{

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(3000);
		CustomFunctions.CustomClick(EmployeeMenu, 5);
				
		CustomFunctions.CustomClick(this.HRProfileMenu, 5);
		
	}

public void CheckDetailsHRProfile() throws Throwable{
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(2000);
	
	Assert.assertTrue("Qualifications section is visible",this.QualificationsSection.isDisplayed());
	Assert.assertTrue("Licences section is visible", this.LicencesSection.isDisplayed());
	Assert.assertTrue("Inductions section is visible", this.Inductions.isDisplayed());
	
	CustomFunctions.PrintScreenShot();
	
	//CustomFunctions.CustomAssertTrue("Qualifications section is visible",this.QualificationsSection.isDisplayed());
}
	

}

package pageclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.DriverFactory;
import util.CustomFunctions;

public class MyTasksPage extends DriverFactory {


	
public MyTasksPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	@FindBy (xpath = "//*[@id='menu']/span/a[1]")
	private WebElement dashboardlink;
	
	@FindBy(linkText="My Tasks")
	private WebElement MyTasksLink;
	
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Leave Applications')]") 
	WebElement LeaveApplications;
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Leave Reversals')]") 
	WebElement Leave_Reversals;
	
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Mail')]") 
	WebElement Mails;
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Training Applications')]") 
	WebElement TrainingApplications;
	
	@FindBy(xpath=".//*[@id='application']/.//span[contains(text(),'Timesheet Approvals')]") 
	WebElement TimesheetApprovals;
	
	
	
	
public void Navigate_to_Mytasks() throws Throwable {
        
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.dashboardlink,5);
		
		CustomFunctions.CustomClick(this.MyTasksLink,5);
    }



public void SelectMyTasks(String section) throws Throwable{
	
	if(section.equalsIgnoreCase("Mail")){
		CustomFunctions.CustomClick(this.Mails, 5);
		
	}
	else if(section.equalsIgnoreCase("Leave Applications")){
		CustomFunctions.CustomClick(this.LeaveApplications, 5);
		
	}
	
	else if(section.equalsIgnoreCase("Leave Reversals")){
		CustomFunctions.CustomClick(this.Leave_Reversals, 5);
		
	}
	
	else if(section.equalsIgnoreCase("Training Applications")){
		CustomFunctions.CustomClick(this.TrainingApplications, 5);
		
	}
	
	else if(section.equalsIgnoreCase("Timesheet Approvals")){
		CustomFunctions.CustomClick(this.TimesheetApprovals, 5);
		
	}
	
	
	
}




public void selectRecent_OldItems(String latest_old, String section) throws Throwable{
	
	CustomFunctions.CustomClick(driver.findElement(By.xpath(".//*[@id='application']/.//span[contains(text(),'"+section+"')]/../../.././/a[contains(text(),'"+latest_old+"')]")), 5);
	
}



public void SelectLeaveToAction(String startDate) throws Throwable{
	
	CustomFunctions.CustomClick(driver.findElement(By.xpath(".//*[@id='application']/.//span[contains(text(),'Leave Applications')]/../../following-sibling::div/.//div[contains(text(),'"+startDate+"')]")), 10);
	
}

public void SelectTimeSheetoAction(String startDate, String EmployeeName) throws Throwable{
	
	CustomFunctions.CustomClick(driver.findElement(By.xpath(".//*[@id='application']/.//span[contains(text(),'Timesheet Approvals')]/../../following-sibling::div/.//div[contains(text(),'"+startDate+"')]//preceding-sibling::div[contains(text(),'"+EmployeeName+"')]")), 10);
	
}

}

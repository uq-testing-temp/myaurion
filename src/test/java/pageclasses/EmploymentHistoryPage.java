package pageclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.DriverFactory;
import util.CustomFunctions;
import util.DebugLog;

public class EmploymentHistoryPage extends DriverFactory {

	public EmploymentHistoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(xpath=".//*[@id='menu']/span/.//a[contains(text(),'Employee')]")
	WebElement EmployeeMenu;
	
	@FindBy(xpath=".//*[@id='menu-my-aurion-list']/.//a[contains(text(),'Employment History')]")
	WebElement EmpHistoryMenuItem;
	
	@FindBy(xpath=".//*[@id='employmenthistories-list']/.//td[contains(text(),'Current')]")
	WebElement CurrentPlacement;
	

	@FindBy(xpath="	.//a[contains(text(),'Current Role')]")
	WebElement CurrentRoleTab;
	
	@FindBy(xpath="	.//a[contains(text(),'Placement')]")
	WebElement PlacementTab;
	
	
	@FindBy(id="panel-current")
	WebElement CurrentRolePanel;
	
	
	
	
	
	 public void Navigate_to_empHistoryPage() throws Throwable {
	        
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			CustomFunctions.CustomClick(this.EmployeeMenu,5);
			
			CustomFunctions.CustomClick(this.EmpHistoryMenuItem,5);
	    }
	 
	 
	 public void select_Current_Placement() throws Throwable {
	        
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	    	try{
	    		CustomFunctions.WaitForObjectEnabledExplicit(CurrentPlacement, 10);
			CustomFunctions.CustomClick(this.CurrentPlacement,5);
	    	}
	    	catch(Exception e){
	    		DebugLog.LogInfo.warn("Couldn't find any current placement rows: "+e.toString());
	    		
	    	}
	    	
			
	    }
	 
	 public void verify_Emp_histor_Current_roleDetails() throws Throwable{
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Boolean allfound=false;
		 CustomFunctions.CustomClick(this.CurrentRoleTab,5);
		 CustomFunctions.CustomAssertTrue("Current Role tab is opened", this.CurrentRolePanel.isDisplayed());
		 
		 String[] detailsections={"Payroll Details","Work Pattern","Supervisor Details"};
		 
		 for(String section:detailsections){
			 
			 for(WebElement h2tag:this.CurrentRolePanel.findElements(By.xpath("/.//h2"))){
				 
				 if(h2tag.getText().equalsIgnoreCase(section)){
					 
					 //DebugLog.LogInfo.info("'"+section+"' found");
	    				allfound=true;
					 
				 }
				 
			 }
			 CustomFunctions.CustomAssertTrue("'"+section+"' found", allfound);
		 }
		 
		 
		 
	 }
	
	

}

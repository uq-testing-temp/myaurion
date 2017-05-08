package pageclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.*;

import stepDefinition.DriverFactory;

public class PersonalDetailsPage extends DriverFactory {

	public PersonalDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
		 new CustomFunctions(driver);
	}
	
	
	@FindBy(xpath=".//*[@id='menu']/span/.//a[contains(text(),'Employee')]")
	WebElement EmployeeMenu;
	
	@FindBy(xpath=".//*[@id='menu-my-aurion-list']/li[1]/.//a[contains(text(),'Personal')]")
	WebElement PersonalMenuItem;
	
	@FindBy(xpath=".//button[contains(text(),'+ Add')]")
	WebElement AddEmergencyContact;
	
	@FindBy(id="T006F010_PRIORITY")
	WebElement Priority;
	
	@FindBy(id="T006F025_NAME")
	WebElement Name;
	
	@FindBy(id="T006F020_RELATIONSHIP_CODE")
	WebElement Relationship;
	
	@FindBy(id="T006F060_HOME_PHONE_NO")
	WebElement HomePhone;
	
	@FindBy(id="T006F100_MOBILE_PHONE")
	WebElement Mobile;
	
	@FindBy(id="T006F065_WORK_PHONE_NO")
	WebElement WorkPhone;
	
	@FindBy(id="T006F105_EMAIL")
	WebElement Email;
	
	@FindBy(id="T006F040_ADDRESS")
	WebElement Street;
	
	@FindBy(id="T006F085_POSTCODE")
	WebElement Postcode;
	
	@FindBy(id="T006F070_COMMENTS")
	WebElement Comments;
	
	@FindBy(id="T006F075_SUBURB")
	WebElement Suburb;
	
	@FindBy(id="T006F080_STATE")
	WebElement State;
	
	@FindBy(id="T006F095_COUNTRY_CODE")
	WebElement Country;
	
	
	
	
public void NavigateToPersonalPage() throws Throwable{
		
		
		CustomFunctions.CustomClick(EmployeeMenu, 5);
		CustomFunctions.CustomClick(this.PersonalMenuItem, 5);
		
	}

public void AddNewContact() throws Throwable{
	
	CustomFunctions.CustomClick(AddEmergencyContact, 5);
	
}


public void Enter_Priority(String priority) throws Throwable{
	
	this.EnterDetails(this.Priority, priority);
}


public void Enter_Name(String Name) throws Throwable{
	
	this.EnterDetails(this.Name, Name);
}


public void Enter_HomePhone(String homephone) throws Throwable{
	
	this.EnterDetails(this.HomePhone, homephone);
}


public void Enter_MobileNum(String WorkNum) throws Throwable{
	
	this.EnterDetails(this.WorkPhone, WorkNum);
}


public void Enter_Email(String email) throws Throwable{
	
	this.EnterDetails(this.Email, email);
}


public void Enter_Street(String street) throws Throwable{
	
	this.EnterDetails(this.Street, street);
}





public void EnterDetails(WebElement element, String Text) throws Throwable{
	
	CustomFunctions.Clear_And_SetValueinTextBox(element, Text);
	
}
	

}

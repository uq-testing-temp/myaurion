package pageclasses;

import java.util.concurrent.TimeUnit;
import java.util.function.LongToIntFunction;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import util.*;
import util.DebugLog;

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
	
	@FindBy(xpath=".//button[contains(text(),'Update')]")
	WebElement UpdateBtn;
	
	@FindBy(id="T006F010_PRIORITY")
	WebElement Priority;
	
	@FindBy(id="T006F025_NAME")
	WebElement Name;
	
	@FindBy(xpath=".//label[contains(text(),'Preferred Name')]/../.././/input")
	WebElement PrefName;
	
	@FindBy(id="T006F020_RELATIONSHIP_CODE")
	WebElement Relationship;
	
	@FindBy(xpath=".//label[contains(text(),'Home')]/../.././/input")
	WebElement HomePhone;
	
	@FindBy(xpath=".//label[contains(text(),'Mobile')]/../.././/input")
	WebElement Mobile;
	
	@FindBy(xpath=".//label[contains(text(),'Work')]/../.././/input")
	WebElement WorkPhone;
	
	@FindBy(xpath=".//label[contains(text(),'Email')]/../.././/input")
	WebElement Email;
	
	@FindBy(xpath=".//label[contains(text(),'Fax')]/../.././/input")
	WebElement Fax;
	
	@FindBy(xpath=".//label[contains(text(),'Post-nominals')]/../.././/input")
	WebElement PostNominalTextbox;
	
	@FindBy(id="T000F040_ADDRESS")
	WebElement Pers_Street;
	
	@FindBy(id="T000F075_POSTCODE")
	WebElement Pers_Postcode;
	
		
	@FindBy(id="T000F065_SUBURB")
	WebElement Pers_Suburb;
	
	@FindBy(id="T000F070_STATE")
	WebElement Pers_State;
	
	@FindBy(id="T000F270_COUNTRY_CODE")
	WebElement Pers_Country;
	
	@FindBy(id="T000F300_POSTAL_IS_HOME")
	WebElement Pers_SameAsHomeAddressChkBox;
	
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
	
	@FindBy(name="save")
	WebElement SaveBtn;
	
	@FindBy(xpath=".//*[@id='notification']/.//h1[contains(text(),'Save')]")
	private WebElement successcheck;
	
	@FindBy(id="T006F035_NEXT_OF_KIN_FLAG")
	WebElement nextofKinCheckbox;
	
public void NavigateToPersonalPage() throws Throwable{
		
		
		CustomFunctions.CustomClick(EmployeeMenu, 5);
		
		
		CustomFunctions.CustomClick(this.PersonalMenuItem, 5);
		
	}

public void AddNewContact() throws Throwable{
	
	CustomFunctions.CustomClick(AddEmergencyContact, 5);
	
	
}


public void UpdatePrsnlDetails() throws Throwable{
	
	CustomFunctions.CustomClick(this.UpdateBtn, 5);
	
	
}

public void Enter_Priority(String priority) throws Throwable{
	
	this.EnterDetails(this.Priority, priority);
}


public void Enter_Name(String Name) throws Throwable{
	
	this.EnterDetails(this.Name, Name);
}


public void Enter_Preferred_Name(String Name) throws Throwable{
	
	this.EnterDetails(this.PrefName, Name);
}

public void Enter_HomePhone(String homephone) throws Throwable{
	
	this.EnterDetails(this.HomePhone, homephone);
}


public void Enter_WorkPhone(String workphone) throws Throwable{
	
	this.EnterDetails(this.WorkPhone, workphone);
}


public void Enter_fax(String fax) throws Throwable{
	
	this.EnterDetails(this.Fax, fax);
}

public void Enter_MobileNum(String WorkNum) throws Throwable{
	
	this.EnterDetails(this.Mobile, WorkNum);
}


public void Enter_Email(String email) throws Throwable{
	
	this.EnterDetails(this.Email, email);
}


public void Enter_Street(String street) throws Throwable{
	
	this.EnterDetails(this.Street, street);
}

public void Enter_Street_Address(String street) throws Throwable{
	
	this.EnterDetails(this.Pers_Street, street);
}

public void Enter_Post_Nominals(String strval) throws Throwable{
	
	this.EnterDetails(this.PostNominalTextbox, strval);
}



public void Enter_City_Suburb(String city) throws Throwable{
	
	this.EnterDetails(this.Suburb, city);
}


public void Enter_state(String state) throws Throwable{
	
	this.EnterDetails(this.State, state);
}


public void Enter_comments(String comments) throws Throwable{
	
	this.EnterDetails(this.Comments, comments);
}


public void Click_Save() throws Throwable{
	
	CustomFunctions.CustomClick(this.SaveBtn, 5);
	
}



public void Select_address_SameAs() throws Throwable{
	
	CustomFunctions.CustomClick(this.Pers_SameAsHomeAddressChkBox, 5);
	
}

public void Select_Relationship(String relationship) throws Throwable{
	
	CustomFunctions.InstantSearchSelect(this.Relationship, relationship, relationship);
	
}

public void Select_postcode(String postcode) throws Throwable{
	
	CustomFunctions.InstantSearchSelect(this.Postcode, postcode, postcode);
	
}

public void Select_Prsnl_postcode(String postcode) throws Throwable{
	
	if(!this.Pers_Postcode.getAttribute("value").equalsIgnoreCase(postcode)){
	CustomFunctions.InstantSearchSelect(this.Pers_Postcode, postcode, postcode);
	}
}


public void Select_country(String country) throws Throwable{
	
	CustomFunctions.InstantSearchSelect(this.Country, country, country);
	
}

public void ClickSave() throws Throwable{
	
	CustomFunctions.CustomClick(this.SaveBtn, 5);
	
}

public void selectnextofKincheckbox() throws Throwable{
	
	CustomFunctions.CustomClick(nextofKinCheckbox, 5);;
}


public void Save_success(String Name) throws Throwable {
	Thread.sleep(2000);
	try{
	boolean success = successcheck.isDisplayed();
	Assert.assertTrue(success);
	
	WebElement newcontact= driver.findElement(By.xpath(".//*[@id='T006F010_PRIORITY-list']/.//td[contains(text(),'"+Name+"')]"));
	CustomFunctions.CustomAssertTrue("New contact added is visible", newcontact.isDisplayed());
	}
	catch(ElementNotFoundException e){
		DebugLog.LogInfo.warn("Something Wrong"+e.toString());;
	}
}



public void Contact_Save_Success(String prefName, String workph, String fax, String homeph, String mobil, String email, String postcode) throws Throwable{
	
	if (successcheck.isDisplayed()){
		
		/*
		System.out.println(prefName+" "+driver.findElement(By.xpath(".//span[contains(text(),'Preferred Name')]/../dfn")).getText());
		System.out.println(workph+" "+driver.findElement(By.xpath(".//span[contains(text(),'Work')]/../dfn")).getText());
		System.out.println(fax+" "+driver.findElement(By.xpath(".//*[@id='tst-fax']/dfn")).getText());
		System.out.println(homeph+" "+driver.findElement(By.xpath(".//*[@id='tst-home']/dfn")).getText());
		System.out.println(postcode+" "+driver.findElement(By.xpath(".//*[@id='tst-street-address']/dfn")).getText());
		System.out.println(email+" "+driver.findElement(By.xpath(".//*[@id='tst-email']/dfn")).getText());
		System.out.println(mobil+" "+driver.findElement(By.xpath("//*[@id='tst-mobile']/dfn")).getText());
		*/
		
		
		CustomFunctions.CustomAssertTrue("Preferred Name updated and displayed as '"+prefName, driver.findElement(By.xpath(".//span[contains(text(),'Preferred Name')]/../dfn")).getText().equals(prefName));
		CustomFunctions.CustomAssertTrue("Work number updated and displayed as "+workph, driver.findElement(By.xpath(".//span[contains(text(),'Work')]/../dfn")).getText().equals(workph));
		CustomFunctions.CustomAssertTrue("Fax number updated and displayed as "+fax, driver.findElement(By.xpath(".//*[@id='tst-fax']/dfn")).getText().equals(fax));
		CustomFunctions.CustomAssertTrue("Home number updated and displayed as "+homeph, driver.findElement(By.xpath(".//*[@id='tst-home']/dfn")).getText().equals(homeph));
		CustomFunctions.CustomAssertTrue("Mobile number updated and displayed as "+mobil, driver.findElement(By.xpath(".//*[@id='tst-mobile']/dfn")).getText().equals(mobil));
		CustomFunctions.CustomAssertTrue("Email updated and displayed as "+email, driver.findElement(By.xpath(".//*[@id='tst-email']/dfn")).getText().equals(email));
		CustomFunctions.CustomAssertTrue("Postcode updated and displayed as "+postcode, driver.findElement(By.xpath(".//*[@id='tst-street-address']/dfn")).getText().contains(postcode));
		
		
		
		

		
		
		
	}
	
	
}


public void EnterDetails(WebElement element, String Text) throws Throwable{
	
	CustomFunctions.Clear_And_SetValueinTextBox(element, Text);
	
}
	

}

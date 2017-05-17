package pageclasses;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import stepDefinition.DriverFactory;

public class EmployeeSearchPage extends DriverFactory {
	
	

	public EmployeeSearchPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
}
	
	
	
	@FindBy(xpath=".//*[@id='context-search-bar']/button")
	WebElement ChangeEmployeeIcon;
	
	@FindBy(id="aurion-context-selector-input")
	WebElement EmpSearchBox;
	
	@FindBy(id="aurion-context-selector-search-results")
	WebElement EmpSearchResults;
	
	@FindBy(xpath=".//*[@id='context-search-bar']/div/div/span[1]")
	WebElement SelectedEmpName;
	
	@FindBy(xpath=".//*[@id='aurion-context-selector-search-results']/h4/em")
	WebElement NoResultsMsg;
	
	
	
	
		public void ChangeEmployeeClick() throws Throwable{
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.ChangeEmployeeIcon.click();
		
	}
		
		public void EnterSearchText(String searchphrase) throws Throwable{
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			this.EmpSearchBox.sendKeys(searchphrase);
						
		}
		
		public void SelectfromSearchResult(String Toselect) throws Throwable{
			
			WebDriverWait wait= new WebDriverWait(driver,30);
			try{
			this.EmpSearchResults=wait.until(ExpectedConditions.visibilityOf(EmpSearchResults));
			WebElement result= driver.findElement(By.xpath(".//*[contains(text(),'"+Toselect+"')]"));
			
			if(result.isDisplayed()){
				result.click();
			}
			
			}
			catch(ElementNotFoundException e){
				
				
			}
			Thread.sleep(1000);
			
		}
		
		
		public void verifyUserDetails(String SelectedEmployee) throws Throwable{
			
			//SelectfromSearchResult(SelectedEmployee);
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Thread.sleep(2000);
			//Assert.assertTrue(SelectedEmpName.getAttribute("Text").equalsIgnoreCase(SelectedEmployee));
			
			WebElement result= driver.findElement(By.xpath(".//*[@id='context-search-bar']/div/div/span[contains(text(),'"+SelectedEmployee+"')]"));
			
			Assert.assertTrue(result.isDisplayed());
				
		
			
		}
		
		
		public void VerifyNoResults() throws Throwable{
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Assert.assertTrue(this.NoResultsMsg.isDisplayed());
			
		}

}

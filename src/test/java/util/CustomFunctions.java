package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinition.DriverFactory;

public class CustomFunctions extends DriverFactory {
	
	public static int timeout=10;

	public CustomFunctions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//Custom Wait
	public static void CustomWait(int duration){
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	//Custom click function- Pass in the webElement and Time out parameter
	public static void CustomClick(WebElement Element, int timeout) throws InterruptedException{
		
		CustomWait(timeout);
		System.out.println("Clicking on "+Element.toString());
		if(Element.isEnabled()){
		Element.click();
		}
		else{
			Thread.sleep(2000);
			Element.click();
			
		}
				
		
	}
	
	
	// this method is to clear the field and set the text into the text box
	public static void Clear_And_SetValueinTextBox(WebElement Element, String Text) throws Throwable{
		
		System.out.println("Entering '"+Text+"' "+"into the field '"+Element.toString()+"'");
		CustomWait(timeout);
		
		WaitForObjectEnabled(Element, timeout);
		
		if(!Element.isEnabled()){
			
			System.out.println("Object is not enabled.");
			
		}
		else if(Element.isEnabled()){
			
			Element.clear();
			Element.sendKeys(Text);
		}
		
	}
	
	
	//This method is to wait until the element is enabled
	public static void WaitForObjectEnabled(WebElement Element, int duration) throws Throwable{
		
		WebDriverWait wait= new WebDriverWait(driver, duration);
		Element=wait.until(ExpectedConditions.elementToBeClickable(Element));
		//Element=wait.until(ExpectedConditions.visibilityOf(Element));
		
		while(!Element.isEnabled()){
			
			Thread.sleep(500);
		}
		
		
	}
	
	
	
	
public static void WaitForObjectEnabledExplicit(WebElement Element, int duration) throws Throwable{
		
		WebDriverWait wait= new WebDriverWait(driver, duration);
		Element=wait.until(ExpectedConditions.elementToBeClickable(Element));
}
	


	
	//This method is to select an option from the select box/dropdown
	public static void SelectoptionFromDropdown(WebElement Element, String OptiontoSelect) {
		
		Select selectbox= new Select (Element);
		
		try{
		selectbox.selectByValue(OptiontoSelect);
		}
		
		catch(ElementNotVisibleException e){
			
			System.out.println("Option not present in the select box"+e.toString());
		}
		
		
		
		/*for(WebElement option: selectbox.getOptions()){
			
			if(option.getAttribute("Value").equals(OptiontoSelect)){
				
				selectbox.selectByValue(OptiontoSelect);
			}
			
		
		
	}*/



	}
	
	
	
	//This method is to traverse through the table 
	
	public static void TraverseTable( WebElement Table, String Column, String row){
		
		
		
		
		
	}

}

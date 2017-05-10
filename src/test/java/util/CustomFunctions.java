package util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.xml.DOMConfigurator;

import stepDefinition.DriverFactory;

public class CustomFunctions extends DriverFactory {
	
	public static int timeout=10;
	
	public CustomFunctions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
		DOMConfigurator.configure("Log4j.xml");

		
	}
	
	
	
	//Custom Wait
	public static void CustomWait(int duration){
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	//Custom click function- Pass in the webElement and Time out parameter
	public static void CustomClick(WebElement Element, int timeout) throws InterruptedException{
		
		CustomWait(timeout);
		//System.out.println("Clicking on "+Element.toString());
		DebugLog.LogInfo.info("Clicking on" +Element.toString());
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
		
		//System.out.println("Entering '"+Text+"' "+"into the field '"+Element.toString()+"'");
		
		DebugLog.LogInfo.info("Entering '"+Text+"' "+"into the field '"+Element.toString()+"'");
		CustomWait(timeout);
		
		WaitForObjectEnabled(Element, timeout);
		
		if(!Element.isEnabled()){
			
			//System.out.println("Object is not enabled.");
			DebugLog.LogInfo.info("Object is not enabled. '" +Element.toString()+"'");
			
		}
		else if(Element.isEnabled()){
			
			Element.clear();
			DebugLog.LogInfo.info("Entering the text: '"+Text +"' Into the field '"+Element);
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
			
			DebugLog.LogInfo.warn("Option '"+OptiontoSelect+"' not present in the select box '"+Element+"'"+e.toString());
			//System.out.println("Option not present in the select box"+e.toString());
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
	
	
	
	public static void InstantSearchSelect(WebElement searchField, String SearchText, String whatToSelect) throws Throwable{
		
		CustomFunctions.Clear_And_SetValueinTextBox(searchField, SearchText);
		Boolean found=false;
		
		
		WebElement parent= searchField.findElement(By.xpath("../.."));
		//CustomFunctions.CustomWait(5);
		CustomFunctions.WaitForObjectEnabledExplicit(parent, 10);
		Thread.sleep(4000);
		List<WebElement> searchresults= parent.findElements(By.tagName("span"));
		
		for (WebElement result:searchresults){
			
			System.out.println(result.getText());
			
			if(result.getText().equalsIgnoreCase(whatToSelect)){
				
				
				DebugLog.LogInfo.info("Found the resut and selecting it '"+whatToSelect);
				result.click();
				found=true;
				break;
			}
			
		}
		if(!found){
			System.out.println(whatToSelect+"' Not found in results");
			DebugLog.warning("Couldn't find the result '"+whatToSelect);
			
		}
		
		
		
	}

}
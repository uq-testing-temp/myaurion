package util;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import util.*;

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
		DebugLog.LogInfo.info("Clicking on" +Element.toString().trim());
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
		try{
		WaitForObjectEnabled(Element, timeout);
		
		if(!Element.isEnabled()){
			
			//System.out.println("Object is not enabled.");
			DebugLog.LogInfo.info("Object is not enabled. '" +Element.toString().trim()+"'");
			
		}
		else if(Element.isEnabled()){
			
			Element.clear();
			Thread.sleep(500);
			DebugLog.LogInfo.info("Entering the text: '"+Text +"' Into the field '"+Element);
			Element.click();
			Element.sendKeys(Text);
			Element.click();
			
		}
		}
		catch(Throwable t){
			if(t instanceof TimeoutException){
				
				DebugLog.LogInfo.warn("Couldn't find the element '"+Element+ t.toString());
			}
			
			if(t instanceof NoSuchElementException){
				
				DebugLog.LogInfo.warn("Couldn't find the element '"+Element+ t.toString());
			}
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
		//selectbox.selectByVisibleText(OptiontoSelect);
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
	
	public static Boolean Table_SelectCellbyText( WebElement Table, String strval) throws Throwable{
		
		Boolean found=false;
	
		CustomFunctions.WaitForObjectEnabledExplicit(Table, 10);
		
		//List<WebElement> row= Table.findElements(By.xpath(".//tr"));
		
		for (WebElement row:Table.findElements(By.xpath(".//tr"))){
			
			for (WebElement col:Table.findElements(By.xpath(".//td"))){
				
				
				if(col.getText().equals(strval)){
					
					DebugLog.LogInfo.info("Found the cell with text and selecting it '"+strval+"'");
					CustomFunctions.CustomClick(col, 3);
					found=true;
					break;
					
				}
				
			}
			if(found=true){		break;}
			
		}
		
		if(found=false){DebugLog.LogInfo.info("Couldn't find the item "+strval);}
		
		
		
		return found;
		
		
	}
	
	
	
	//This method is to traverse through the table 
	
		public static void Table_SelectCellbyTextXYZ( WebElement Table, String strval) throws Throwable{
			
			Boolean found=false;
		
			CustomFunctions.WaitForObjectEnabledExplicit(Table, 10);
			
			//List<WebElement> row= Table.findElements(By.xpath(".//tr"));
			
			for (WebElement row:Table.findElements(By.xpath(".//tr"))){
				
				for (WebElement col:Table.findElements(By.xpath(".//td"))){
					
					
					if(col.getText().equals(strval)){
						
						
						DebugLog.LogInfo.info("Found the cell with text and selecting it '"+strval+"'");
						//CustomFunctions.CustomClick(col, 3);
						found=true;
						//break;
						
							if(row.findElement(By.xpath(".//td[@data-th='Date From']")).getText().equalsIgnoreCase("11/07/2017")){
								
							}
						
						
						
						
					}
					
				}
				if(found=true){		break;}
				
			}
			
			if(found=false){DebugLog.LogInfo.info("Couldn't find the item "+strval);}
			
			
			
			
			
			
		}
	
	
	
	
	
	public static void selectPendingLeaveRequestBydate(WebElement Table, String startdate, String Enddate) throws Throwable{
		
		//String strval="Pending";
		Boolean found=false;
		
		CustomFunctions.WaitForObjectEnabledExplicit(Table, 10);
		
		//List<WebElement> row= Table.findElements(By.xpath(".//tr"));
		
		for (WebElement row:Table.findElements(By.xpath(".//tr"))){
			
			for (WebElement col:Table.findElements(By.xpath(".//td"))){
				
				
				if(col.getText().equals("Pending")){
					
					
					//for(WebElement fromcell: row.findElements(By.xpath(".//td[@data-th='Date From']"))){
					String startdatecell=row.findElement(By.xpath(".//td[@data-th='Date From']")).getText();
					System.out.println(startdatecell);
						 if (startdatecell.equals(startdate)){
							 
							 //for(WebElement tocell: row.findElements(By.xpath(".//td[@data-th='Date To']"))){
							
								 if (row.findElement(By.xpath("/.//td[@data-th='Date To']")).getText().equals(Enddate)){
									 
									 
									 DebugLog.LogInfo.info("Found the pending leave request for date from '"+startdate+"' to '"+Enddate+"'");
										CustomFunctions.CustomClick(col, 3);
										found=true;
										break;
									 
								 			}
								// }
						 }
					//}
					
					
					
				}
				
			}
			if(found=true){		break;}
			
		}
		
		if(found=false){DebugLog.LogInfo.info("Couldn't find the item "+"Pending");}
		
		
		
		
	}
	
	
	
	
	
	
	public static void SelectFromList(WebElement List, String entrytoselect) throws Throwable{
		
		Boolean found=false;
		//String grosspay=null;
		
		//WebElement NextBtn= driver.findElement(By.xpath(".//*[contains(text(),'Next')]"));
		
		CustomFunctions.WaitForObjectEnabledExplicit(List, 10);
		
		do{
		List<WebElement> VisibleListItems= List.findElements(By.xpath(".//h2"));
			
		for (WebElement item: VisibleListItems){
			
			System.out.println(item.getText());
				if(item.getText().equalsIgnoreCase(entrytoselect)){
				
				
				DebugLog.LogInfo.info("Found the resut and selecting it '"+entrytoselect);
				//grosspay=driver.findElement(By.xpath("../following-sibling::div/.//div[contains(text(),'Gross')]/following-sibling::div")).getText();
				
				item.click();
				found=true;
				break;
			}
				
			
			
			
		}
		if(found==false){
		if(driver.findElement(By.xpath(".//*[contains(text(),'Next')]")).isEnabled()){
			CustomFunctions.CustomClick(driver.findElement(By.xpath(".//*[contains(text(),'Next')]")), 5);
			Thread.sleep(5000);
		}
		if(!driver.findElement(By.xpath(".//*[contains(text(),'Next')]")).isEnabled()){
			
			DebugLog.LogInfo.info("Couldn't find the item "+entrytoselect);
			break;
		}
		}
		   }while(found==false);
		
		//return grosspay;
	}
	
	
	
public static Boolean verifyIntheList(WebElement List, String entrytoselect) throws Throwable{
		
		Boolean found=false;
		//String grosspay=null;
		
		//WebElement NextBtn= driver.findElement(By.xpath(".//*[contains(text(),'Next')]"));
		
		CustomFunctions.WaitForObjectEnabledExplicit(List, 10);
		
		do{
		List<WebElement> VisibleListItems= List.findElements(By.xpath(".//h2"));
			
		for (WebElement item: VisibleListItems){
			
			System.out.println(item.getText());
				if(item.getText().equalsIgnoreCase(entrytoselect)){
				
				
				DebugLog.LogInfo.info("Found the resut and selecting it '"+entrytoselect);
				//grosspay=driver.findElement(By.xpath("../following-sibling::div/.//div[contains(text(),'Gross')]/following-sibling::div")).getText();
				
				//item.click();
				found=true;
				break;
			}
				
			
			
			
		}
		if(found==false){
		if(driver.findElement(By.xpath(".//*[contains(text(),'Next')]")).isEnabled()){
			CustomFunctions.CustomClick(driver.findElement(By.xpath(".//*[contains(text(),'Next')]")), 5);
			Thread.sleep(5000);
		}
		if(!driver.findElement(By.xpath(".//*[contains(text(),'Next')]")).isEnabled()){
			
			DebugLog.LogInfo.info("Couldn't find the item "+entrytoselect);
			break;
		}
		}
		   }while(found==false);
		
		return found;
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
	
	
	public static void PrintScreenShot() throws Throwable{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String date= now.toString();
		date=date.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(date);
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(".//target/screenshots//"+date+".jpg"));
	
	}
	
 public static void PrintScreenShotWithScenarioName(String testname) throws Throwable{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String date= now.toString();
		date=date.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(date);
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C://MyAurionTestScreenshots//"+testname+""+date+".jpg"));
		FileUtils.copyFile(scrFile, new File(".//target/screenshots//"+testname+""+date+".jpg"));
		
	
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public static void CustomAssertTrue(String message, boolean condition) throws Throwable{
		
		String screnprintAtPass= new PropertyReader().readProperty("ScreenshotOnPass");
		
		DebugLog.LogInfo.info(message);
		try{
		Assert.assertTrue(condition);
		if(screnprintAtPass.equalsIgnoreCase("true")){
		PrintScreenShot();}
		}
		catch(NoSuchElementException e){
			DebugLog.LogInfo.warn("The Assert failed. Element not found");
			//PrintScreenShot();
		}
		
	}
	
	
	
	public static void verifyLeaveBalancedata(WebElement Table,String rowtext, String bal, String pend, String avail)throws Throwable{
		
		
		CustomFunctions.WaitForObjectEnabledExplicit(Table, 10);
		Boolean found=false;
		
for (WebElement row:Table.findElements(By.xpath(".//tr"))){
			
					List<WebElement> list=row.findElements(By.xpath(".//td"));
					
					for(int i=0;i<list.size();i++){
						
						if(list.get(i).getText().equalsIgnoreCase(rowtext)){
							
							found=true;
							
							String balance=list.get(i+1).getText();
							String pending=list.get(i+3).getText();
							String Available=list.get(i+5).getText();
							
							CustomFunctions.CustomAssertTrue(rowtext+" balance is as expected"+balance, balance.equals(bal));
							CustomFunctions.CustomAssertTrue(rowtext+" pending is as expected"+pending, pending.equals(pend));
							CustomFunctions.CustomAssertTrue(rowtext+" Available is as expected"+Available, Available.equals(avail));
							break;
						}
						
					}
					
				
					
					
					
				
				
			
			
			
		}
				if(found=true){	DebugLog.LogInfo.warn(rowtext+ "type of leave not found in the list");	}
		
		
	}

}

package pageclasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinition.DriverFactory;
import util.CustomFunctions;
import util.DebugLog;

public class TimesheetPage extends DriverFactory {
	
	@FindBy (xpath = "//*[@id='menu']/span/a[1]")
	private WebElement dashboardlink;
	
	@FindBy (xpath = "//*[@id='menu-dashboard-list']/li[2]/a")
	private WebElement timesheetlink;
	
	@FindBy (id = "tabDaily")
	private WebElement dailytimesheet;
	
	@FindBy (xpath = ".//*[@id='section1__N026F025_DATE__']")
	private WebElement selectdate;
	
	@FindBy (xpath = "//*[@id='section1']/header/div[1]/span")
	private WebElement addcontacthrs;
	
	@FindBy ( xpath = "//*[@id='section1']/div/div/button")
	private WebElement addhrsbutton;
	
	
	@FindBy ( xpath = ".//*[@id='panelDetailed']/div[2]/button")
	private WebElement DetaileViewaddhrsbutton;
	
	@FindBy ( xpath = "//*[@id='section1__N026F020_TIME_TYPE__']")
	private WebElement selecthrstype;
	
	@FindBy ( xpath = "//*[@id='section1__N026F135_COMMENTS__']")
	private WebElement entercode;
	
	@FindBy ( xpath = "//*[@id='section1__N026F030_TIME_FROM__']")
	private WebElement fromtime;
	
	@FindBy ( xpath = "//*[@id='section1__N026F050_TIME_TO__']")
	private WebElement totime;
	
	@FindBy ( xpath = "//*[@id='button-close-modal']")
	private WebElement savemodal;
	
	@FindBy ( xpath = "//*[@id='timekeeper-workflow']/div/div/div[1]/button")
	private WebElement submitbutton;
	
	@FindBy ( xpath = "//*[@id='N900F050_MESSAGE_TEXT']")
	private WebElement sendtomsg;
	
	@FindBy ( xpath = "//*[@id='save']")
	private WebElement save;
	
	@FindBy(xpath=".//*[@id='notification']/.//*[contains(text(),'Timesheet line was saved.')]")
	private WebElement TimeSheetSavesuccessmsg;
	
	@FindBy(xpath=".//*[@id='notification']/.//h2[contains(text(),'Timesheet has been sent.')]")
	private WebElement successcheck;
	
	@FindBy(xpath=".//*[@id='notification']/.//*[contains(text(),'Timesheet was recalled.')]")
	private WebElement Recallsuccessmsg;
	
	@FindBy ( xpath = "//*[@id='timekeeper_period_select_chosen']/div/div/input")
	private WebElement timekeeper;	
	
	@FindBy(xpath=".//*[contains(text(),'No results found')]")
	private WebElement Noresultmsg;
	
	@FindBy(partialLinkText="View full list")
	private WebElement ViewFullListBtn;
	
	@FindBy(id="timekeeperforms-list")
	private WebElement FullListTable;
	
	
	@FindBy(xpath=".//*[@id='timekeeperforms-list_filter']/label/input")
	private WebElement FullListFilterBox;
		
	@FindBy (xpath=".//*[@class='notification alert-warning']")
	private WebElement AlertWarning;
	
	@FindBy (xpath=".//*[@class='section-error-indicator']")
	private WebElement haserrors;
	
	@FindBy ( xpath = "//*[@id='button-close-copy-modal']")
	private WebElement SaveandCopyBtn;
	
	@FindBy(xpath=".//*[@id='timekeeperforms-list']/tbody/.//*[contains(text(),'Current')]")
	private WebElement CurrentRow;
	
	@FindBy(name="set-as-default")
	private WebElement SetAsDefaultBtn;
	
	@FindBy(xpath=".//*[@id='timekeeper-workflow']/.//button[contains(text(),'Reset')]")
	private WebElement ResetBtn;
	
	
	@FindBy(xpath=".//button[contains(text(),'Show form')]")
	private WebElement ShowformBtn;
	
	
	@FindBy(xpath=".//button[contains(text(),'Recall')]")
	private WebElement RecallBtn;
	
	@FindBy(xpath=".//a[contains(text(),'Forward')]")
	private WebElement ForwardBtn;
	
	
	@FindBy(id="notification-close")
	private WebElement CloseNotificationBtn;
	
	@FindBy(xpath=".//a[contains(text(),'Approve')]")
	private WebElement ApproveBtn;
	
	@FindBy(xpath=".//a[contains(text(),'Return')]")
	private WebElement ReturnBtn;
	
	@FindBy(xpath=".//a[contains(text(),'Decline')]")
	private WebElement DeclineBtn;
	
	@FindBy(xpath=".//a[contains(text(),'Daily')]")
	private WebElement DailyTab;
	
	@FindBy(xpath=".//a[contains(text(),'Period')]")
	private WebElement Periodtab;
	
	@FindBy(xpath=".//a[contains(text(),'Detailed')]")
	private WebElement DetailedTab;
	
	@FindBy(xpath=".//a[contains(text(),'Summary')]")
	private WebElement SummaryTab;
	
	@FindBy(xpath=".//a[contains(text(),'Edit')]")
	private WebElement EditBtn;
	
	@FindBy(xpath=".//a[contains(text(),'Done')]")
	private WebElement DoneBtn;
	
	@FindBy(xpath=".//table[@class='table table-bordered table-timekeeper-weekly table-sm']")
	private WebElement PeriodViewEditTable;
	
	@FindBy(xpath=".//table[@class='table table-bordered table-timekeeper-weekly table-sm']/.//tr[2]/td[3]")
	private WebElement PeriodAddHrsBtn;
	

	
	
	public TimesheetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
       
    }
    
    public void timesheet_page() throws Throwable {
    	 Thread.sleep(2000);
		 dashboardlink.click();
		 timesheetlink.click();
	 }
    
    public void select_timekeeper(String time) throws Throwable {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(".//*[@id='timekeeper_period_select_chosen']/a/span")).click();
    	timekeeper.sendKeys(time);
    	timekeeper.sendKeys(Keys.ENTER);
    }
    
    public void daily_timesheet() throws Throwable {
    	Thread.sleep(2000);
    	dailytimesheet.click();
    }
   
    public void select_date() throws Throwable {
    	Thread.sleep(2000);
    	Select dateselectBox = new Select(selectdate);
        int dateselectOptions = dateselectBox.getOptions().size();
        dateselectBox.selectByIndex(dateselectOptions - 1);
   }
    
    
    
    public void select_dates(String date) throws Throwable {
    	Thread.sleep(2000);
    	//Select dateselectBox = new Select(selectdate);
    	CustomFunctions.SelectoptionFromDropdown(selectdate, date);
       // int dateselectOptions = dateselectBox.getOptions().size();
        //dateselectBox.selectByIndex(dateselectOptions - 1);
   }
    
    public void select_otherdate() throws Throwable {
    	Thread.sleep(2000);
    	Select dateselectBox = new Select(selectdate);
        int dateselectOptions = dateselectBox.getOptions().size();
        dateselectBox.selectByIndex(dateselectOptions - 2);
   }
    
    public void add_contact_hours() throws Throwable {
    	Thread.sleep(3000);
    	addcontacthrs.click();
    	addhrsbutton.click();
    }
    
    public void DetailedViewAddHrs_Click() throws Throwable{
    	
    	CustomFunctions.CustomClick(DetaileViewaddhrsbutton, 10);
    }
    
 public void PeriodViewAddHrs_Click() throws Throwable{
    	
    	CustomFunctions.CustomClick(this.PeriodAddHrsBtn, 10);
    }
    
    public void select_contact_hrs_type() throws Throwable {
    	Thread.sleep(2000);
    	Select typeselectBox = new Select(selecthrstype);
        int typeselectOptions = typeselectBox.getOptions().size();
        typeselectBox.selectByIndex(typeselectOptions - 1);
    }
    
    public void enter_code(String code) throws Throwable {
    	Thread.sleep(2000);
    	entercode.clear();
    	entercode.sendKeys(code);
    }
    
    public void enter_start_time(String starttime) throws Throwable {
    	Thread.sleep(2000);
    	fromtime.clear();
    	fromtime.sendKeys(starttime);
    }
    
    public void enter_stop_time(String stoptime) throws Throwable {
    	Thread.sleep(2000);
    	totime.clear();
    	totime.sendKeys(stoptime);
    	Thread.sleep(8000);
    }
    
    public void save_close_modal() throws Throwable {
    	Thread.sleep(2000);
    	savemodal.click();
    }
    
    public void submit_timesheet() throws Throwable {
    	Thread.sleep(2000);
    	submitbutton.click();
    }
    
    public void Edit_timesheet() throws Throwable {
    	//Thread.sleep(2000);
    	CustomFunctions.CustomClick(this.EditBtn, 10);
    }
    
    public void Click_Done() throws Throwable {
    	//Thread.sleep(2000);
    	CustomFunctions.WaitForObjectEnabledExplicit(this.DoneBtn, 20);
    	CustomFunctions.CustomClick(this.DoneBtn, 10);
    }
    
    public void Click_on_Forward() throws Throwable {
    	//Thread.sleep(2000);
    	CustomFunctions.WaitForObjectEnabledExplicit(this.ForwardBtn, 20);
    	CustomFunctions.CustomClick(this.ForwardBtn, 10);
    }
   
    public void timesheet_success() throws Throwable {
    	Thread.sleep(2000);
    	boolean success = successcheck.isDisplayed();
    	Assert.assertTrue(success);
    }
    
    
    
    public void timesheet_Update_success() throws Throwable {
    	
    	CustomFunctions.CustomAssertTrue("Time sheet line saved success message Displayed", this.TimeSheetSavesuccessmsg.isDisplayed());
    	
    }
    
    public void timesheet_not_available_message() throws Throwable {
    	Thread.sleep(2000);
    	boolean success = Noresultmsg.isDisplayed();
    	Assert.assertTrue(success);
    }
    
    public void ClickViewFullList() throws Throwable {
    	Thread.sleep(2000);
    	ViewFullListBtn.click();
    }
    
    public void SelectcurrenttimesheetInlist() throws Throwable {
    	Thread.sleep(2000);
    	CurrentRow.click();
    }
    
      
    
    public void FullListViewTablepresent() throws Throwable {
    	Thread.sleep(2000);
    	boolean success = FullListTable.isDisplayed();
    	Assert.assertTrue(success);
    	
    }
    
    public void TimesheetErrorAlert() throws Throwable {
    	Thread.sleep(3000);
    	boolean success = AlertWarning.isDisplayed();
    	Assert.assertTrue(success);
    	
    }
    
    public void save_and_copy() throws Throwable {
    	Thread.sleep(2000);
    	SaveandCopyBtn.click();
    }
    
    
    public void SetAsDefault() throws Throwable {
    	Thread.sleep(2000);
    	this.SetAsDefaultBtn.click();
    	Alert alert= driver.switchTo().alert();
    	alert.accept();
    }
    
    public void ResetTimesheet() throws Throwable{
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	this.ResetBtn.click();
    	Alert alert= driver.switchTo().alert();
    	alert.accept();
    	
    }
    
    public void CloseNotification() throws Throwable{
    	Thread.sleep(2000);
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	this.CloseNotificationBtn.click();
    	
    }
    
    
    
    
   public void ActionTimeSheer(String Action) throws Throwable{
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	if(Action.equalsIgnoreCase("approve")){
    	
    		CustomFunctions.CustomClick(this.ApproveBtn, 10);
    		
    	}
    	if(Action.equalsIgnoreCase("decline")){
        	
    		CustomFunctions.CustomClick(this.DeclineBtn, 10);
    		
    	}
    	if(Action.equalsIgnoreCase("return")){
        	
    		CustomFunctions.CustomClick(this.ReturnBtn, 10);
    		
    	}
    	
    	
    	
    }
   
   
   public void selectTimesheetView(String view) throws Throwable{
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   if(view.equalsIgnoreCase("Daily")){
	    	
   		CustomFunctions.CustomClick(this.DailyTab, 10);
   		
   	}
   	if(view.equalsIgnoreCase("period")){
       	
   		CustomFunctions.CustomClick(this.Periodtab, 10);
   		
   	}
   	if(view.equalsIgnoreCase("Detailed")){
       	
   		CustomFunctions.CustomClick(this.DetailedTab, 10);
   		
   	}
   	
   	if(view.equalsIgnoreCase("Summary")){
       	
   		CustomFunctions.CustomClick(this.SummaryTab, 10);
   		
   	}
	   
   }
   
   
   
   public void AddHrsFordate(String date){
   
	   if(date==null){
		   
		   DebugLog.LogInfo.warn("No date provided so test is expected to fail");
		   
	   }
	   
	   else{
		   
		   List<WebElement> dateHeaders= this.PeriodViewEditTable.findElements(By.xpath(".//th"));
		   
		   for(WebElement thtag:dateHeaders){
			   
			   if(thtag.getText().equalsIgnoreCase(date)){
				   
			   }
			   
		   }
		   
		   
		   
	   }
	   
   }
   
   
   public void selectTimesheetFromtable(String strval) throws Throwable{
	
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   if(!CustomFunctions.Table_SelectCellbyText(FullListTable, strval)){
		   
		   CustomFunctions.Clear_And_SetValueinTextBox(this.FullListFilterBox, strval);
		   CustomFunctions.WaitForObjectEnabledExplicit(FullListTable, 10);
		   if(CustomFunctions.Table_SelectCellbyText(FullListTable, strval)){
			   DebugLog.LogInfo.warn("Timesheet not found for the date: "+strval);
		   }
		   
	   }
	   
   }
   
   
   public void Click_ShowFrom() throws Throwable {
   	
   	CustomFunctions.WaitForObjectEnabledExplicit(this.ShowformBtn, 10);
   	CustomFunctions.CustomClick(this.ShowformBtn, 5);
   }
   
   
   
   public void RecallTimesheet() throws Throwable {
	   	
	   CustomFunctions.WaitForObjectEnabledExplicit(this.RecallBtn, 10);
	   	CustomFunctions.CustomClick(this.RecallBtn, 5);
	   }
   
   
   public void timesheet_Recall_success() throws Throwable {
   
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	boolean success = this.Recallsuccessmsg.isDisplayed();
   	Assert.assertTrue(success);
   }
	   
   
    
    
    
}

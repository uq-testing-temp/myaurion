package pageclasses;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinition.DriverFactory;

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
	
	@FindBy ( xpath = "//*[@id='notification']")
	private WebElement successcheck;
	
	@FindBy ( xpath = "//*[@id='timekeeper_period_select_chosen']/div/div/input")
	private WebElement timekeeper;	
	
	@FindBy(xpath=".//*[contains(text(),'No results found')]")
	private WebElement Noresultmsg;
	
	@FindBy(partialLinkText="View full list")
	private WebElement ViewFullListBtn;
	
	@FindBy(id="timekeeperforms-list")
	private WebElement FullListTable;
		
	@FindBy (xpath=".//*[@class='notification alert-warning']")
	private WebElement AlertWarning;
	
	@FindBy (xpath=".//*[@class='section-error-indicator']")
	private WebElement haserrors;
	
	
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
    
    public void add_contact_hours() throws Throwable {
    	Thread.sleep(2000);
    	addcontacthrs.click();
    	addhrsbutton.click();
    }
    
    public void select_contact_hrs_type() throws Throwable {
    	Thread.sleep(2000);
    	Select typeselectBox = new Select(selecthrstype);
        int typeselectOptions = typeselectBox.getOptions().size();
        typeselectBox.selectByIndex(typeselectOptions - 1);
    }
    
    public void enter_code(String code) throws Throwable {
    	Thread.sleep(2000);
    	entercode.sendKeys(code);
    }
    
    public void enter_start_time(String starttime) throws Throwable {
    	Thread.sleep(2000);
    	fromtime.sendKeys(starttime);
    }
    
    public void enter_stop_time(String stoptime) throws Throwable {
    	Thread.sleep(2000);
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
   
    public void timesheet_success() throws Throwable {
    	Thread.sleep(2000);
    	boolean success = successcheck.isDisplayed();
    	Assert.assertTrue(success);
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
    
    
    
    
}

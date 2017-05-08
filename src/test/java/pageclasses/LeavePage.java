package pageclasses;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.DriverFactory;

public class LeavePage extends DriverFactory {
	
	@FindBy(id="pagehead-control")
    private WebElement applyforleavebttn;
	
	@FindBy(id="N901F015_LTYPE_TCODE")
	private WebElement leavetype;
	
	@FindBy(id="N901F020_DAYS")
	private WebElement duration;
	
	@FindBy(id="N901F025_DATE_FROM-ct")
	private WebElement startdate;
	
	@FindBy(id="N901F030_DATE_TO-ct")
	private WebElement enddate;
	
	@FindBy(css="span.flatpickr-next-month > svg")
	private WebElement nextmonth;
	
	@FindBy(xpath="//*[@id='N901F030_DATE_TO-ct']/div[2]/div[1]/div/div[1]/span[3]/svg/path")
	private WebElement ednextmonth;
	
	@FindBy(xpath="//div[@id='N901F025_DATE_FROM-ct']/div[2]/div/div/div[2]/div/div[2]/span[24]")
	private WebElement sdate;
	
	@FindBy(xpath="//div[@id='N901F030_DATE_TO-ct']/div[2]/div/div/div[2]/div/div[2]/span[31]")
	private WebElement edate;
	
	@FindBy(id="N900F050_MESSAGE_TEXT")
	private WebElement message;
	
	@FindBy(id="save")
	private WebElement submit;
	
	@FindBy(id="application")
	private WebElement successmsg;
	
    public LeavePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void new_leave_page() throws Throwable {
        driver.get("http://myaurionupgrdev.hr.uq.edu.au/leave/new");
    }
    
    public void apply_for_leave_button() throws Throwable {
    	applyforleavebttn.click();
    	Thread.sleep(2000);
    }
    
    public void select_leave_type(String ltype) throws Throwable {
    	Thread.sleep(2000);
    	WebElement select = leavetype;
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if(ltype.equals(option.getText()))
                option.click();
        }
    }
    
    public void select_duration(String dur) throws Throwable {
    	Thread.sleep(2000);
    	WebElement select = duration;
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if(dur.equals(option.getText()))
                option.click();
        }
    }
    
    public void select_startdate() throws Throwable {
    	
    	Thread.sleep(2000);
    	startdate.click();
    	sdate.click();
    }
    
    public void select_enddate() throws Throwable {
    	Thread.sleep(2000);
    	enddate.click();
    	edate.click();
    	
    }
    
    public void enter_message(String msg) throws Throwable {
    	Thread.sleep(2000);
    	message.sendKeys(msg);
    }
    
    public void submit() throws Throwable {
    	Thread.sleep(2000);
    	submit.click();
    }
    
    public void success() throws Throwable {
    	boolean successmessage = successmsg.isDisplayed();
    	Assert.assertTrue(successmessage);
    }
    
}

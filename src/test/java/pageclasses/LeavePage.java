package pageclasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.DriverFactory;
import util.CustomFunctions;
import util.DebugLog;

public class LeavePage extends DriverFactory {
	
	@FindBy(id="pagehead-control")
    private WebElement applyforleavebttn;
	
	
	@FindBy (xpath = "//*[@id='menu']/span/a[1]")
	private WebElement dashboardlink;
	
	@FindBy(linkText="Leave")
	private WebElement LeaveLink;
	
	@FindBy(id="N901F015_LTYPE_TCODE")
	private WebElement leavetype;
	
	@FindBy(id="N901F020_DAYS")
	private WebElement duration;
	
	@FindBy(xpath=".//*[@id='N901F025_DATE_FROM-ct']/div[2]/input")
	private WebElement startdate;
	
	@FindBy(xpath=".//*[@id='N901F030_DATE_TO-ct']/div[2]/input")
	private WebElement enddate;
	
	
	@FindBy(xpath=".//*[@id='panel-balances']/form/div[1]/div/div/input")
	private WebElement futuredate;
	
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
	
	@FindBy(id="N902F035_REPLY_MESSAGE")
	private WebElement LeaveApprovemessage;
	
	
	@FindBy(id="save")
	private WebElement submit;
	
	
	@FindBy(xpath=".//*[@id='notification']/.//h2[contains(text(),'Leave request has been sent.')]")
	private WebElement successmsg;
	
	@FindBy(xpath=".//*[@id='notification']/.//h2[contains(text(),'Delete Successful')]")
	private WebElement DeletSuccess;
	
	@FindBy(xpath=".//*[@id='notification']/.//h2[contains(text(),'Workflow action successful.')]")
	private WebElement WorkFlowActionSuccessMsg;
	
	
	@FindBy(xpath=".//*[@id='notification']/.//h2[contains(text(),'Leave reversal has been sent.')]")
	private WebElement LeaveReversalSuccessMsg;
	
	@FindBy(id="notification-close")
	private WebElement CloseNotificationBtn;
	
	
	
	@FindBy(xpath=".//table[@id='panel-history-list']")
	private WebElement LeaveHistoryTable;
	
	@FindBy(xpath=".//*[@href='leave/new']")
	private WebElement ApplyForLeaveBtn;
	
	
	@FindBy(xpath=".//button[contains(text(),'Approve')]")
	private WebElement ApproveLeaveBtn;
	
	@FindBy(xpath=".//button[contains(text(),'Decline')]")
	private WebElement DeclineLeaveBtn;
	
	@FindBy(xpath=".//button[contains(text(),'Return')]")
	private WebElement ReturnLeaveBtn;
	
	@FindBy(xpath=".//*[contains(text(),'Forward')]")
	private WebElement ForwardLeaveBtn;
	
	@FindBy(xpath=".//button[contains(text(),'Reverse')]")
	private WebElement ReverseLeaveBtn;
	
	
	@FindBy(xpath=".//*[@id='leave-balances-container']/div/table[1]")
	private WebElement ViewLeaveBalTable;
	
	@FindBy(xpath=".//table[@class='table table-hover table-striped table-ess-leave']")
	private WebElement LeaveBalanceTable;
	
	@FindBy(id="btnDelete")
	private WebElement DeleteBtn;
	
	@FindBy(id="btnPredictLeave")
	private WebElement PredictLeaveBtn;
	
	
	
	
	@FindBy(name="approve")
	private WebElement ApproveBtn;
	
	@FindBy(name="return")
	private WebElement ReturnBtn;
	
	@FindBy(name="decline")
	private WebElement DeclineBtn;
	
	@FindBy(name="forward")
	private WebElement ForwardBtn;
	
	
	
    public LeavePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void new_leave_page() throws Throwable {
        driver.get("http://myaurionupgrdev.hr.uq.edu.au");
    }
    
    public void Navigate_to_Leavepgae() throws Throwable {
        
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.dashboardlink,5);
		
		CustomFunctions.CustomClick(this.LeaveLink,5);
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
    
    public void select_startdate(String date) throws Throwable {
    	
    	Thread.sleep(2000);
    	startdate.sendKeys(date);
    	startdate.sendKeys(Keys.TAB);
    	//JavascriptExecutor js= (JavascriptExecutor) driver;
    	//js.executeScript(, arg1)
    	//js.executeScript("document.getElementById('N901F025_DATE_FROM-ct').setAttribute('Text','"+date+"')");
    	//CustomFunctions.Clear_And_SetValueinTextBox(this.startdate, date);
    	//sdate.click();
    }
    
    public void select_enddate(String date) throws Throwable {
    	Thread.sleep(2000);
    	enddate.sendKeys(date);
    	enddate.sendKeys(Keys.TAB);
    	
    	//JavascriptExecutor js= (JavascriptExecutor) driver;
    	//js.executeScript("document.getElementById('N901F030_DATE_TO-ct').setAttribute('Text','"+date+"')");
    	
    	//js.executeScript("startdate.setAttribute('Text','"+date+"')");
    	//edate.click();
    	//CustomFunctions.Clear_And_SetValueinTextBox(this.enddate, date);
    	
    }
    
    public void select_futuredate(String date) throws Throwable {
    	
    	this.futuredate.sendKeys(date);
    	futuredate.sendKeys(Keys.TAB);
    	
    	//JavascriptExecutor js= (JavascriptExecutor) driver;
    	//js.executeScript("document.getElementById('N901F030_DATE_TO-ct').setAttribute('Text','"+date+"')");
    	
    	//js.executeScript("startdate.setAttribute('Text','"+date+"')");
    	//edate.click();
    	//CustomFunctions.Clear_And_SetValueinTextBox(this.enddate, date);
    	
    }
    
    public void enter_message(String msg) throws Throwable {
    	Thread.sleep(2000);
    	message.sendKeys(msg);
    }
    
    public void enter_Leave_Approve_message(String msg) throws Throwable {
    	CustomFunctions.Clear_And_SetValueinTextBox(LeaveApprovemessage, msg);
    }
    
    
    
    public void submit() throws Throwable {
    	Thread.sleep(2000);
    	submit.click();
    }
    
    public void success() throws Throwable {
    	
    	boolean successmessage = successmsg.isDisplayed();
    	//Assert.assertTrue(successmessage);
    	CustomFunctions.CustomAssertTrue("Success message Displayed", successmessage);
    	
    }
    
    
    
    
 public void Deletesuccess() throws Throwable {
    	
    	boolean successmessage = this.DeletSuccess.isDisplayed();
    	//Assert.assertTrue(successmessage);
    	CustomFunctions.CustomAssertTrue("Delete Success message Displayed", successmessage);
    	
    }
 
 
 public void WorkFlowActionsuccess() throws Throwable {
 	
 	boolean successmessage = this.WorkFlowActionSuccessMsg.isDisplayed();
 	//Assert.assertTrue(successmessage);
 	CustomFunctions.CustomAssertTrue("WorkFlow Action Success message Displayed", successmessage);
 	
 }
 
 public void LeaveReversalActionsuccess() throws Throwable {
	 	
	 	boolean successmessage = this.LeaveReversalSuccessMsg.isDisplayed();
	 	//Assert.assertTrue(successmessage);
	 	CustomFunctions.CustomAssertTrue("LeaveReversal Success message Displayed", successmessage);
	 	
	 }
    
    public void selectPendingRequest() throws Throwable{
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	CustomFunctions.Table_SelectCellbyText(this.LeaveHistoryTable,"Pending");
    	    	
    }
    
    public void verifyPredictedLeaveDisplay() throws Throwable{
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//CustomFunctions.Table_SelectCellbyText(this.LeaveHistoryTable,"Pending");
    	String [] columnnames= {"Type","Days","Hours","Rate", "Predicted"};
    	Boolean allfound=false;
    	
    	for(String i:columnnames){
    		
    		for(WebElement header:this.LeaveBalanceTable.findElements(By.xpath(".//th"))){
    			if(header.getText().equalsIgnoreCase(i)){
    				//DebugLog.LogInfo.info("'"+i+"'column found");
    				allfound=true;
    			}
    		
    	}
    		CustomFunctions.CustomAssertTrue("'"+i+"'column found", allfound);
    	}
    }
    
    
    
 public void selectPendingRequestBydate(String start, String End) throws Throwable{
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	CustomFunctions.selectPendingLeaveRequestBydate(LeaveHistoryTable, start, End);
    	//CustomFunctions.Table_SelectCellbyText(this.LeaveHistoryTable,"Pending");
    	    	
    }
    
 
 public void selectApprovedRequestBydate(String startdate) throws Throwable{
 	
 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	//CustomFunctions.selectPendingLeaveRequestBydate(LeaveHistoryTable, startdate);
 	CustomFunctions.Table_SelectCellbyText(this.LeaveHistoryTable,startdate);
 	    	
 }
 
    public void ClickOnDelete() throws Throwable{
    
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	CustomFunctions.CustomClick(DeleteBtn, 10);
    }
    
    public void ClickOnPredictButton() throws Throwable{
        
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	CustomFunctions.CustomClick(this.PredictLeaveBtn, 10);
    }
    
    
    public void ClickOnApprove() throws Throwable{
        
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	CustomFunctions.CustomClick(this.ApproveLeaveBtn, 10);
    }
    
public void ClickOnDecline() throws Throwable{
        
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	CustomFunctions.CustomClick(this.DeclineLeaveBtn, 10);
    }

public void ClickOnReturn() throws Throwable{
    
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	CustomFunctions.CustomClick(this.ReturnLeaveBtn, 10);
}
    
public void ClickOnForward() throws Throwable{
    
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	CustomFunctions.CustomClick(this.ForwardLeaveBtn, 10);
}
    public void ClickApplyForLeaveButton() throws Throwable{
    
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	CustomFunctions.CustomClick(this.ApplyForLeaveBtn, 10);
    }
    
    
    public void ActionLeaveRequest(String Action) throws Throwable{
    	
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
    	
    	if(Action.equalsIgnoreCase("reverse")){
        	
    		CustomFunctions.CustomClick(this.ReverseLeaveBtn, 10);
    		
    	}
    	
    }
    
    public void verifyLeaveBalance(String type, String Avail, String Pending, String balance) throws Throwable{
    	
    	if(type.equalsIgnoreCase("Recreational")){
    		
    		CustomFunctions.verifyLeaveBalancedata(this.ViewLeaveBalTable, "Recreation", balance, Pending, Avail);
    		
    	}
    	
    	if(type.equalsIgnoreCase("Personal")){
    		
    		CustomFunctions.verifyLeaveBalancedata(this.ViewLeaveBalTable, "Personal (Sick & Carer's)", balance, Pending, Avail);
    		
    	}
    	
    	if(type.equalsIgnoreCase("Sick")){
    		
    		CustomFunctions.verifyLeaveBalancedata(this.ViewLeaveBalTable, "Sick (additional)", balance, Pending, Avail);
    	}
    	
    	if(type.equalsIgnoreCase("Carer")){
    		
    		
    		CustomFunctions.verifyLeaveBalancedata(this.ViewLeaveBalTable, "Carer's (non-cumulative)", balance, Pending, Avail);
    		
    	}
    	
	if(type.equalsIgnoreCase("Long Service")){
    		
    		
    		CustomFunctions.verifyLeaveBalancedata(this.ViewLeaveBalTable, "Long Service", balance, Pending, Avail);
    		
    	}
    	
    	
    }
    
}

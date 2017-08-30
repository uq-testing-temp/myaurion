package pageclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.DriverFactory;
import util.CustomFunctions;

public class TrainingCoursesPage extends DriverFactory {
	
	@FindBy(id="pagehead-control")
    private WebElement applyforleavebttn;
	
	@FindBy (xpath = "//*[@id='menu']/span/a[3]")
	private WebElement talentLink;
	
	@FindBy(linkText="Training & Courses")
	private WebElement trainingCoursesLink;
	
	@FindBy (xpath = "//*[@id='main']/section[2]/section[1]/header/div[2]/span[2]")
	private WebElement requestCoursesLink;

	@FindBy (xpath = "//*[@id='cells-requested-courses']/li/div/a")
	private WebElement addButton;
	
	//@FindBy (xpath = "//*[@id='18352']/td[1]")            RL01
	@FindBy (xpath = ".//*[@id='18603']/td[5]")
	private WebElement course;
	
	@FindBy (id = "T900_CODES")
	private WebElement reasonBox;
	
	@FindBy (xpath = "//*[@id='T900_CODES']/option[2]")
	private WebElement generalReason;

	@FindBy (id = "btnApply")
	private WebElement applyButton;
	
	@FindBy (id = "save")
	private WebElement submitButton;
	
	@FindBy (id = "btnSearch")
	private WebElement searchButton;
	
	@FindBy(id="notificationSubtitle")
	private WebElement successmsg;
	
	@FindBy(xpath="//*[@id='course-form']/header/h1")
	private WebElement program;
	

	public TrainingCoursesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        
    }


    public void Navigate_training_courses_page() throws Throwable {
        
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.talentLink,5);
		
		CustomFunctions.CustomClick(this.trainingCoursesLink,5);
    }
    


	public void selectTrainingActionRequestedCourses() throws Throwable {
	   	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			CustomFunctions.CustomClick(this.requestCoursesLink,5);
		
	}

	public void add_button() throws Throwable {
	   	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.addButton,5);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void selectProgram() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CustomFunctions.CustomClick(this.course,5);		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	public void selectGeneralInterest() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.reasonBox,5);
		CustomFunctions.CustomClick(this.generalReason,5);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	}


	public void apply() throws Throwable {
	   	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.applyButton,5);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}


	public void submit() throws Throwable {
	   	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.submitButton,5);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);		
	}


	public void searchButton() throws Throwable {
	   	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		CustomFunctions.CustomClick(this.searchButton,5);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
  
    public void successOrOverlap() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	CustomFunctions.CustomAssertTrue("Success message Displayed", successmsg.isDisplayed());
    	
    }


	public void seeTheProgramm() throws Throwable {
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	CustomFunctions.CustomAssertTrue("The course Displayed", program.isDisplayed());
		
	}
    
}

package stepDefinition;

import org.junit.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageclasses.DashboardPage;
import pageclasses.LandingPage;
import util.CustomFunctions;
import util.DebugLog;
import util.PropertyReader;

public class LoginSteps extends DriverFactory {

	
	
    @Before
    public void beforeScenario(Scenario scenario) {
        driver = new DriverFactory().getDriver();
        
       String scenarioname=scenario.getName();
       DebugLog.StartTest(scenarioname);
        
    }

    @After
    public void afterScenario(Scenario scenario) throws Throwable {
    	 String scenarioname=scenario.getName();
    	
    	
    	if(!scenario.isFailed()){
    		DebugLog.LogInfo.info(scenarioname+"Test Passed");
    		
    	String screnprintAtPass= new PropertyReader().readProperty("ScreenshotOnPass");
    	if(screnprintAtPass.equalsIgnoreCase("true")){
    		CustomFunctions.PrintScreenShotWithScenarioName(scenarioname);}
    	}
    	
    	
    	
    	try{
    	if(scenario.isFailed()){
    		DebugLog.LogInfo.warn("'"+scenarioname +"':  Test Failed");
    		scenarioname=scenarioname+"Failed";
    		CustomFunctions.PrintScreenShotWithScenarioName(scenarioname);
    	}
    	 
    	}
    	
    	finally{
        new DriverFactory().destroyDriver();}
    	
    	DebugLog.EndTest(scenarioname);
    }

    @Given("^I am on myAurion login page$")
    public void setup() throws Throwable {
        new LandingPage(driver).login_page();
    }

    @When("^I enter username as \"(.*)\"$")
    public void enterUsername(String username) throws Throwable {
        new LandingPage(driver).I_enter_username_as(username);
    }

    @When ("^I enter password as \"(.*)\"$")
    public void enterPassword(String password) throws Throwable {
        new LandingPage(driver).I_enter_password_as(password);
    }

    @When ("^I click Login button$")
    public void clickLoginButton() throws Throwable {
        new LandingPage(driver).I_click_login_button();
    }

    @Then ("^I should be logged in$")
    public void I_should_be_logged_in() throws Throwable {
        new DashboardPage(driver).I_should_be_logged_in();
    }

    @Then ("I should not be logged in$")
    public void I_should_not_be_logged_in() throws Throwable {
        new LandingPage(driver).I_should_not_be_logged_in();
    }
    
    @When("^I get the environment from the environmental variable$")
    public void env_var() throws Throwable {

    	Assert.assertFalse("Env varialbe is available", LandingPage.URLIsFromENV());
    	
    }
    
    @Then("^I should see 200 returned$")
    public void i_should_see_200_returned() throws Throwable {

    	Assert.assertTrue("Environment returns 200-OK", LandingPage.get200());
    }
    
    @Then("^I am able to take screenshots$")
    public void i_am_able_to_take_screenshots() throws Throwable {
    	
    	Assert.assertTrue(CustomFunctions.PrintScreenShotWithScenarioName("screenshotTest"));
    }
}

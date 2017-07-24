package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;

import pageclasses.DashboardPage;
import pageclasses.LandingPage;
import util.CustomFunctions;
import util.DebugLog;
import util.PropertyReader;

public class MenuJourneySteps extends DriverFactory {

	
	
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

	@Then("^I should be able to go through all links$")
	public boolean i_should_be_able_to_go_through_all_links() throws Throwable {
		TODO: 
		return true;
	}
}

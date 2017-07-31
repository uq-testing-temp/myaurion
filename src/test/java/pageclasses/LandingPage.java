package pageclasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.it.Data;
import stepDefinition.DriverFactory;
import util.*;

public class LandingPage extends DriverFactory{
	
		
    @FindBy(id="username")
    private WebElement usernamefield;

    @FindBy(id="password")
    private WebElement passwordfield;

    @FindBy(id="login-button")
    private WebElement loginbutton;
    
             

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        new CustomFunctions(driver);
    }
   

    public void login_page() throws Throwable {
    	
    	String URL= new PropertyReader().readProperty("URL");
    	
    
    	//DebugLog.StartTest("");
        driver.get(URL);
        driver.manage().window().maximize();
        
    }

    public void I_enter_username_as(String username) throws Throwable {
        usernamefield.sendKeys(username);
    }

    public void I_enter_password_as(String password) throws Throwable {
        passwordfield.sendKeys(password);
    }

    public void I_click_login_button() throws Throwable {
     
		//  loginbutton.click();
        CustomFunctions.CustomClick(loginbutton, 10);
        
        
    }

    public void I_should_not_be_logged_in() throws Throwable {
        boolean loginbuttonDisplayed = loginbutton.isDisplayed();
        Assert.assertTrue(loginbuttonDisplayed);
    }


    
    
	public static String readURL() {
		Boolean envVariableisPresent = true;
    	String URLENV = System.getenv("URLENV");
    	if (URLENV == null || URLENV.isEmpty()) {
    		envVariableisPresent = false;
    		URLENV = new PropertyReader().readProperty("URLENV");
    	}
    	Assert.assertTrue("Environmental variable is present",  envVariableisPresent);
		return URLENV;
	}


	public static boolean URLIsFromENV() {

		String URLENV = System.getenv("URLENV");
		if (URLENV.isEmpty()) {
			URLENV = new PropertyReader().readProperty("URL");
		}
		
		return URLENV.isEmpty();
	}


	public static boolean get200() {

		String URLENV = System.getenv("URLENV");
    	if (URLENV == null || URLENV.isEmpty()) {
    		URLENV = new PropertyReader().readProperty("URL");
    	}
    	
    	return isAccessable(URLENV, 10);
	}
	
	public static boolean isAccessable(String url, int timeout) {
	    url = url.replaceFirst("https", "http");  

	    try {
	        HttpURLConnection connection = (HttpURLConnection) new URL(url)
	                .openConnection();
	        connection.setConnectTimeout(timeout);
	        connection.setReadTimeout(timeout);
	        connection.setRequestMethod("HEAD");
	        int responseCode = connection.getResponseCode();
	        if (responseCode != 200) {
	            return false;
	        }
	    } catch (IOException exception) {
	        return false;
	    }
	    return true;
	}
}

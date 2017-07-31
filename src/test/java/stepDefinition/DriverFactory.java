package stepDefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import util.PropertyReader;

public class DriverFactory {

    protected static WebDriver driver;

    public  DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    @SuppressWarnings("unused")
	private void createNewDriverInstanceDebug() {
        String browser = new PropertyReader().readProperty("browser");
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } 
        /*else if(browser.equals("firefox")){
        	driver=new FirefoxDriver();
        }
        
        else if(browser.equals("IE")){
        	driver=new IEDriver();
        }*/
        else {
            System.out.println("I cannot read browser type");
        }
    }

    private void createNewDriverInstance() {

    	String browser = new PropertyReader().readProperty("browser");
        if (browser.equals("chrome")) {
        	
        	DesiredCapabilities capability = DesiredCapabilities.chrome();
        	
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("test-type");
        	options.addArguments("start-maximized");
        	options.addArguments("--js-flags=--expose-gc");  
        	options.addArguments("--enable-precise-memory-info"); 
        	options.addArguments("--disable-popup-blocking");
        	options.addArguments("--disable-default-apps");
        	options.addArguments("test-type=browser");
        	options.addArguments("disable-infobars");

        	String seleniumPort = System.getenv("SELENIUM_PORT");
        	if (seleniumPort == null || seleniumPort.isEmpty()) {
        		driver = new ChromeDriver(options);
        	} else {
                try {
                	driver = new RemoteWebDriver(new URL("http://localhost:" + seleniumPort + "/wd/hub"), capability);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
        		} catch (MalformedURLException e) {
        			e.printStackTrace();
        		}
        	}
        } else {
            System.out.println("I cannot read browser type");
        }
        
        
    }
    
    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
    	//DebugLog.LogInfo.info("End of this test");
        driver.quit();
        driver = null;
    }
}

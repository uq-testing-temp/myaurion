package pageclasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.DriverFactory;

public class LandingPage extends DriverFactory{

    @FindBy(id="username")
    private WebElement usernamefield;

    @FindBy(id="password")
    private WebElement passwordfield;

    @FindBy(id="login-button")
    private WebElement loginbutton;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login_page() throws Throwable {
        driver.get("http://myaurion11cf.hr.uq.edu.au/");
        driver.manage().window().maximize();
    }

    public void I_enter_username_as(String username) throws Throwable {
        usernamefield.sendKeys(username);
    }

    public void I_enter_password_as(String password) throws Throwable {
        passwordfield.sendKeys(password);
    }

    public void I_click_login_button() throws Throwable {
        loginbutton.click();
    }

    public void I_should_not_be_logged_in() throws Throwable {
        boolean loginbuttonDisplayed = loginbutton.isDisplayed();
        Assert.assertTrue(loginbuttonDisplayed);
    }
}

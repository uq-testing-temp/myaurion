package pageclasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.DriverFactory;

public class DashboardPage extends DriverFactory{

    @FindBy(id="context-search-bar")
            private WebElement contextSearchBar;

    public DashboardPage(WebDriver driver){
           PageFactory.initElements(driver, this);
    }

    public void I_should_be_logged_in() throws Throwable {
        boolean signOutLinkDisplayed = contextSearchBar.isDisplayed();
        Assert.assertTrue(signOutLinkDisplayed);
    }
}

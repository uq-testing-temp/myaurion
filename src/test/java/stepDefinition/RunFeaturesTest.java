package stepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/features/", tags = "@manoj1",
                  format = {"pretty", "html:target/Destination"})
public class RunFeaturesTest {
}
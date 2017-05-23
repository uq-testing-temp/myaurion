package stepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/features/", tags = "@Automated",
                  format = {"pretty", "html:target/Destination", "json:target/cucumber-json-report.json"})
public class RunFeaturesTest {
}
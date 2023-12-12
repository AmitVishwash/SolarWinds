package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue="stepdef",
        monochrome = true,
        stepNotifications = true,
        plugin = {"pretty","json:target/cucumber.json","html:target/cucumber.html"},
        publish = true
)
public class TestRunner {
}

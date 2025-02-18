package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = "stepDefinitions",
        plugin = {"html:target/AutomationTest_Report","pretty"},
        tags = "@TDD"
)

public class runAutomation {
}

package stepDefinitions;

import config.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void before(){
        driver = Environment.getInstance().getDriver();
    }

    @After
    public void after(Scenario scenario){
        if (scenario.isFailed()) {
            driver.manage().deleteAllCookies(); // Clear cookies if test fails
        }
        Environment.getInstance().quitDriver();
    }
}

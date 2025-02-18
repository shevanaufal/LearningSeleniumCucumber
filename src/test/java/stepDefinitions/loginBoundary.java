package stepDefinitions;

import config.environment;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginBoundary {
    WebDriver driver = environment.getInstance().getDriver();
    @Then("user should see (.*) as expected_result$")
    public void user_should_see_expected_result(String expectedResult){
        if (expectedResult.equals("expected_result")){
            String products = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
            Assert.assertEquals(products,"Products");
        } else {
            String ErrorLogin = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
            Assert.assertEquals(ErrorLogin,"Epic sadface: Username and password do not match any user in this service");
        }
    }
}

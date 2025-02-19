package stepDefinitions;

import config.Environment;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.CredentialsPage;

public class LoginBoundary {
    WebDriver driver = Environment.getInstance().getDriver();
    CredentialsPage loginPage = new CredentialsPage(driver);

    @Then("user should see (.*) as expected_result$")
    public void userShouldSeeExpectedResultAsExpectedResult(String expectedResult){
        if (expectedResult.equals("expected_result")){
            String products = loginPage.loginVerified();
            Assert.assertEquals(products,"Products");
        } else {
            String errorLogin = loginPage.loginError();
            Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorLogin);
        }
    }
}

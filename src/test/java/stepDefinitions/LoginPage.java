package stepDefinitions;

import config.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import pageObject.CredentialsPage;

public class LoginPage {
    WebDriver driver = Environment.getInstance().getDriver();
    CredentialsPage loginPage = new CredentialsPage(driver);

    @Given("sauce demo login page$")
    public void sauceDemoLoginPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String loginAssert = loginPage.saucedemoTitle();
        Assert.assertEquals("Swag Labs", loginAssert);
    }

    @When("user input (.*) as username$")
    public void userInputUsernameAsUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input (.*) as password$")
    public void userInputPasswordAsPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }
    @Then("user verify (.*) login$")
    public void userVerifyStatusLogin(String status) {
        if (status.equals("success")){
            String products = loginPage.loginVerified();
            Assert.assertEquals("Products", products);
        } else {
            String errorLogin = loginPage.loginError();
            Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorLogin);
        }
    }
}


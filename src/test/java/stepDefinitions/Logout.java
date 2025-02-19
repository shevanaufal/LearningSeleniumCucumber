package stepDefinitions;

import config.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.CredentialsPage;

public class Logout {
    WebDriver driver = Environment.getInstance().getDriver();
    CredentialsPage logoutAction = new CredentialsPage(driver);

    @Then("click burger button")
    public void clickBurgerButton() {
        logoutAction.clickBurgerMenu();
    }

    @And("click logout button")
    public void clickLogoutButton() {
        logoutAction.clickLogout();
    }

    @Then("user successfully logout")
    public void userSuccessfullyLogout() {
        String loginAssert = logoutAction.saucedemoTitle();
        Assert.assertEquals(loginAssert, "Swag Labs");
    }
}

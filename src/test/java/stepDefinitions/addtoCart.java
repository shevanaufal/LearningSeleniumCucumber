package stepDefinitions;

import config.environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addtoCart {
    WebDriver driver = environment.getInstance().getDriver();
    @And("click addtocart button")
    public void click_addtocart_button() {
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("cart will increase")
    public void cart_will_increase() {
        String cartAssert = driver.findElement(By.xpath("//span[@class='shopping_cart_badge' and text()='1']")).getText();
        Assert.assertEquals(cartAssert, "1");
    }
}

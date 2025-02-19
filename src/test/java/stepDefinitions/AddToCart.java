package stepDefinitions;

import config.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.ProductPage;

public class AddToCart {
    WebDriver driver = Environment.getInstance().getDriver();
    ProductPage productPage = new ProductPage(driver);

    @And("click addtocart button")
    public void clickAddToCartButton() {
        productPage.clickAddToCart();
    }

    @Then("cart will increase")
    public void cartWillIncrease() {
        String cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals("1", cartItemCount);
    }
}

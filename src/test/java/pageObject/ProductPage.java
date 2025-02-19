package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver driver;

    private final By addToCartButton = By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartItemCount() {
        return driver.findElement(shoppingCartBadge).getText();
    }
}

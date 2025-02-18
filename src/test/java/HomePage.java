import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    WebDriver driver;
    By backpackItem =By.xpath("//a[@id='item_4_title_link']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateBackpackDisplated(){
        assertTrue(driver.findElement(backpackItem).isDisplayed());
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemo {
    @Test
    public void locatorTest(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name"));
        driver.findElement(By.xpath("//*[@id=\"password\"]"));
        driver.findElement(By.id("login-button"));
    }
    @Test
    public void browserMethodTest(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();

        System.out.println("Title pada halaman web: " + title);
        System.out.println("URL saat ini pada halaman web: " + currentURL);

    }
    @Test
    public void webElementMethod() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);
    }
    @Test
    public void navigationMethodTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.navigate().refresh();
        driver.navigate().to("https://www.jayjay.co/");
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Title pada halaman web: " + title);
        System.out.println("URL saat ini pada halaman web: " + currentURL);
    }
    @Test
    public void implicityWaitTest() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


    }
    @Test
    public void explicityWaitTest() {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#user-name")));
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='item_4_title_link']")));
        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText());
    }
    @Test
    public void fluentWaitTest(){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='item_4_title_link']")));
        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText());
    }
}

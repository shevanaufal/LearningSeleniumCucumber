import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Selenium {

    @Test
    public void helloJayjay(){
        //Inisialisasi Browser Driver
        WebDriver driver = WebDriverManager.chromedriver().create();
        //Nagivate URL
        driver.get("https://jayjay.co/");

        //Get Element
        String text = driver.findElement(By.xpath("//div[@class='content-info']/h1")).getText().replaceAll("\\n", " ").replaceAll("\\s+", " ").trim();

        //Assertion
        assertEquals("Belajar dari para ahli terbaik berdasarkan program Eropa", text);
    }
}

package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CredentialsPage {
    private final WebDriver driver;

    private final By titleProduct = By.xpath("//span[contains(text(), 'Products')]");
    private final By errorDataNotMatch = By.xpath("//h3[@data-test=\"error\"]");
    private final By loginLogo = By.xpath("//div[@class=\"login_logo\"]");
    private final By usernameAccount = By.id("user-name");
    private final By passwordAccount = By.id("password");
    private final By loginButton = By.xpath("//input[@id=\"login-button\"]");
    private final By burgerButton = By.xpath("//button[text()=\"Open Menu\"]");
    private final By logoutButton = By.xpath("//a[@id=\"logout_sidebar_link\"]");

    public CredentialsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inputUsername(String username) {
        driver.findElement(usernameAccount).sendKeys(username);
    }
    public void inputPassword(String password) {
        driver.findElement(passwordAccount).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public String loginVerified(){
        return driver.findElement(titleProduct).getText();
    }
    public String loginError() {
        return driver.findElement(errorDataNotMatch).getText();
    }
    public String saucedemoTitle() {
        return driver.findElement(loginLogo).getText();
    }
    public void clickBurgerMenu(){
        driver.findElement(burgerButton).click();
    }
    public void clickLogout(){
        driver.findElement(logoutButton).click();
    }
}

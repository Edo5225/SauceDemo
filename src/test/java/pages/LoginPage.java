package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.name("password");
    private final By SIGN_UP_BUTTON = By.cssSelector("[class*=submit]");
    private final By ERROR_MESSAGE = By.xpath("//h3[@data-test = 'error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseURL);
    }

    public void login (String user, String password) {
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SIGN_UP_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}

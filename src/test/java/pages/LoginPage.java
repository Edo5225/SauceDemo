package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.name("password");
    private final By SIGN_UP_BUTTON = By.cssSelector("[class*=submit]");
    private final By ERROR_MESSAGE = By.xpath("//h3[@data-test = 'error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public void open() {
        log.info("Opening login page with URL: {}", baseURL);
        driver.get(baseURL);
    }

    @Step("Вход в систему с именем пользователя {user} и паролем {password}")
    public void login(String user, String password) {
        log.info("Attempting login with user: {}, password: {}", user, password);
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SIGN_UP_BUTTON).click();
        log.info("Login button clicked");
    }

    public String getErrorMessage() {
        log.info("Retrieving error message from login page");
        String message = driver.findElement(ERROR_MESSAGE).getText();
        log.info("Retrieved error message: {}", message);
        return message;
    }
}

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private final By FIRST_NAME_INPUT = By.xpath("//input[@placeholder='First Name']");

    public boolean checkFirstNameInput () {
        return driver.findElement(FIRST_NAME_INPUT).isDisplayed();
    }
}

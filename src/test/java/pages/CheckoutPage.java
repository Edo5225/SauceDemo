package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By FIRST_NAME_INPUT = By.xpath("//input[@placeholder='First Name']");

    public boolean checkFirstNameInput() {
        log.info("Checking visibility of First Name input field");
        return driver.findElement(FIRST_NAME_INPUT).isDisplayed();
    }
}


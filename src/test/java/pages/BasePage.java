package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public String baseURL = "https://www.saucedemo.com/";
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void clickJS(WebElement element) {
        js.executeScript("arguments[0].click;", element);
    }

}

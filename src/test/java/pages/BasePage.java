package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public String baseURL = "https://www.saucedemo.com/";
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}

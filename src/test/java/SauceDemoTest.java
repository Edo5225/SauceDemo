import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

public class SauceDemoTest {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void locators (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("error-message-container"));
        driver.findElement(By.cssSelector("[class*=submit]")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
        String actual_sum = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();
        String actual_name = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
        softAssert.assertEquals(actual_name, "Sauce Labs Backpack");
        softAssert.assertEquals(actual_sum, "$29.99");
    }
}

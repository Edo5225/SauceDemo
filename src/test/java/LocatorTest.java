import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;

public class LocatorTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
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
        driver.findElement(By.tagName("div"));
        driver.findElement(By.linkText("Sauce Labs Onesie"));
        driver.findElement(By.partialLinkText("Sauce"));
        driver.findElement(By.xpath("//footer[@class='footer']"));
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.xpath("//div[contains(@class,'logo')]"));
        driver.findElement(By.xpath("//div[contains(text(),'t-shirt is perfect')]"));
        driver.findElement(By.xpath("//*[text()='Products']//ancestor::div[@class='header_secondary_container']"));
        driver.findElement(By.xpath("//div/following::span[1]"));
        driver.findElement(By.xpath("//span/preceding::div[@class='primary_header']"));
        driver.findElement(By.xpath("//span/parent::div[@class='header_secondary_container']"));
        driver.findElement(By.xpath("//div[@class='header_secondary_container']/descendant::span"));
        driver.findElement(By.xpath("//div[@class='header_secondary_container' and @data-test='secondary-header']"));
        driver.findElement(By.cssSelector(".inventory_item_price"));
        driver.findElement(By.cssSelector(".inventory_item_price.inventory_item_price"));
        driver.findElement(By.cssSelector(".inventory_item_price.inventory_item_price"));
        driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));
        driver.findElement(By.cssSelector("#item_1_title_link"));
        driver.findElement(By.cssSelector("footer"));
        driver.findElement(By.cssSelector("footer.footer"));
        driver.findElement(By.cssSelector("[class=footer]"));
        driver.findElement(By.cssSelector("[class~=title]"));
        driver.findElement(By.cssSelector("[class|=bm-burger]"));
        driver.findElement(By.cssSelector("[class^=app_]"));
        driver.findElement(By.cssSelector("[class^=app_]"));
        driver.findElement(By.cssSelector("[class$=_logo]"));
        driver.findElement(By.cssSelector("[class*=burger]"));
    }
}

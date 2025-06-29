package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CardPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;
    ProductsPage productsPage;
    LoginPage loginPage;
    CardPage cardPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        softAssert = new SoftAssert();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cardPage = new CardPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
}
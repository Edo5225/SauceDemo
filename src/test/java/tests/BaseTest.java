package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pages.CardPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;
import java.util.HashMap;
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    ProductsPage productsPage;
    LoginPage loginPage;
    CardPage cardPage;
    CheckoutPage checkoutPage;
@Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
    if(browser.equalsIgnoreCase("chrome")){
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
    } else if(browser.equalsIgnoreCase("firefox")){
        driver = new FirefoxDriver();
    }
        softAssert = new SoftAssert();
        driver.manage().timeouts() .implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cardPage = new CardPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
}
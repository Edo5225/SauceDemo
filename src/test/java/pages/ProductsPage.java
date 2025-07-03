package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By TITLE = By.className("title");
    private final By ADD_TO_CART_BACKPACK_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private final By ADD_TO_CART_BIKE_BUTTON = By.id("add-to-cart-sauce-labs-bike-light");
    private final By ADD_TO_CART_T_SHIRT_BUTTON = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By CART_LINK = By.id("shopping_cart_container");

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void addToCartBackpack() {
        driver.findElement(ADD_TO_CART_BACKPACK_BUTTON).click();
    }
    public void addToCartBike () {
        driver.findElement(ADD_TO_CART_BIKE_BUTTON).click();
    }

    public void addToCartTSHIRT () {
        driver.findElement(ADD_TO_CART_T_SHIRT_BUTTON).click();
    }

    public void openCart () {
        driver.findElement(CART_LINK).click();
    }
}

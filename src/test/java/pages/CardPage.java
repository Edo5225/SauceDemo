package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CardPage extends BasePage{

    public CardPage(WebDriver driver) {
        super(driver);
    }

    //Title
    private final By TITLE = By.className("title");
    //Локаторы кнопок
    private final By BACKPACK_REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private final By BIKE_REMOVE_BUTTON = By.id("remove-sauce-labs-bike-light");
    private final By T_SHIRT_REMOVE_BUTTON = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By CONTINUE_SHOPPING_BUTTON = By.xpath("//button[@data-test='continue-shopping']");
    // Локаторы параметров продуктов
    private final By ITEM_PRICE = By.xpath("//div[@data-test='inventory-item-price']");
    private final By ITEM_NAME = By.xpath("//div[@data-test='inventory-item-name']");
    //Локаторы продуктов
    private final By BIKE_ITEM = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private final By BACKPACK_ITEM = By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By T_SHIRT_ITEM = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");

    public String checkTitle () {
        return driver.findElement(TITLE).getText();
    }

    public int sumItem () {
       return driver.findElements(ITEM_NAME).size();
   }

    public String checkItemBikeName() {
        return driver.findElement(BIKE_ITEM).getText();
    }

    public String checkItemBackpackName() {
        return driver.findElement(BACKPACK_ITEM).getText();
    }

    public String checkItemTShirtName() {
        return driver.findElement(T_SHIRT_ITEM).getText();
    }

    public List<WebElement> getItemCost () {
        return driver.findElements(ITEM_PRICE);
    }

    public void removeItemBike () {
        driver.findElement(BIKE_REMOVE_BUTTON).click();
    }

    public void continueShopping () {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void moveToCheckout () {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}

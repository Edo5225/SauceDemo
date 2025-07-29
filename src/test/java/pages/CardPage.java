package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class CardPage extends BasePage {

    public CardPage(WebDriver driver) {
        super(driver);
    }

    // Title
    private final By TITLE = By.className("title");

    // Локаторы кнопок
    private final By BACKPACK_REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private final By BIKE_REMOVE_BUTTON = By.id("remove-sauce-labs-bike-light");
    private final By T_SHIRT_REMOVE_BUTTON = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By CONTINUE_SHOPPING_BUTTON = By.xpath("//button[@data-test='continue-shopping']");

    // Локаторы параметров продуктов
    private final By ITEM_PRICE = By.xpath("//div[@data-test='inventory-item-price']");
    private final By ITEM_NAME = By.xpath("//div[@data-test='inventory-item-name']");

    // Локаторы продуктов
    private final By BIKE_ITEM = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private final By BACKPACK_ITEM = By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By T_SHIRT_ITEM = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");

    public String checkTitle() {
        log.info("Retrieving cart page title");
        String title = driver.findElement(TITLE).getText();
        log.info("Page title: {}", title);
        return title;
    }

    public int sumItem() {
        log.info("Counting items in cart");
        int count = driver.findElements(ITEM_NAME).size();
        log.info("Number of items in cart: {}", count);
        return count;
    }

    public String checkItemBikeName() {
        log.info("Checking name of bike item");
        String name = driver.findElement(BIKE_ITEM).getText();
        log.info("Bike item name: {}", name);
        return name;
    }

    public String checkItemBackpackName() {
        log.info("Checking name of backpack item");
        String name = driver.findElement(BACKPACK_ITEM).getText();
        log.info("Backpack item name: {}", name);
        return name;
    }

    public String checkItemTShirtName() {
        log.info("Checking name of T-shirt item");
        String name = driver.findElement(T_SHIRT_ITEM).getText();
        log.info("T-shirt item name: {}", name);
        return name;
    }

    public List<WebElement> getItemCost() {
        log.info("Getting list of item prices");
        List<WebElement> prices = driver.findElements(ITEM_PRICE);
        log.info("Number of prices found: {}", prices.size());
        return prices;
    }

    @Step("Удаляем из корзины товар Bike")
    public void removeItemBike() {
        log.info("Removing bike item from cart");
        driver.findElement(BIKE_REMOVE_BUTTON).click();
    }

    @Step("Переход из корзины на страницу товаров")
    public void continueShopping() {
        log.info("Clicking 'Continue Shopping' button");
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Переход из корзины на страницу Checkout")
    public void moveToCheckout() {
        log.info("Clicking 'Checkout' button");
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}

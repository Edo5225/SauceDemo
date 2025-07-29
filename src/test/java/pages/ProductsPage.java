package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Checking if Products page is opened");
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Добавление в корзину рюкзака")
    public void addToCartBackpack() {
        log.info("Adding backpack to cart");
        driver.findElement(ADD_TO_CART_BACKPACK_BUTTON).click();
    }

    @Step("Добавление в корзину велосипеда")
    public void addToCartBike () {
        log.info("Adding bike to cart");
        driver.findElement(ADD_TO_CART_BIKE_BUTTON).click();
    }

    @Step("Добавление в корзину футболки")
    public void addToCartTSHIRT () {
        log.info("Adding T-shirt to cart");
        driver.findElement(ADD_TO_CART_T_SHIRT_BUTTON).click();
    }

    @Step("Открытие корзины")
    public void openCart () {
        log.info("Opening cart");
        driver.findElement(CART_LINK).click();
    }
}

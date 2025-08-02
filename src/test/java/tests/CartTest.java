package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest{

    @Test(testName = "Проверка названия продуктов")
    public void checkMultipleItemName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartTSHIRT();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        softAssert.assertEquals(cardPage.checkItemBikeName(), "Sauce Labs Bike Light", "Название не соответствует");
        softAssert.assertEquals(cardPage.checkItemTShirtName(), "Sauce Labs Bolt T-Shirt", "Название не соответствует");
        softAssert.assertEquals(cardPage.checkItemBackpackName(), "Sauce Labs Backpack", "Название не соответствует");
        softAssert.assertAll();
    }

    @Test(testName = "Проверка количества товаров в корзине")
    public void checkSumItem () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        softAssert.assertEquals(cardPage.sumItem(), 2, "Количество товаров не соответствует");
        softAssert.assertAll();
    }

    @Test (testName = "Проверка стоимости товаров")
    public void checkItemCost() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        softAssert.assertEquals(cardPage.getItemCost().get(0).getText(), "$9.99", "Цена не соответствует");
        softAssert.assertEquals(cardPage.getItemCost().get(1).getText(), "$29.99", "Цена не соответствует");
        softAssert.assertAll();
    }
    @Test (testName = "Проверка возможности удаления продуктов из корзины")
    public void checkRemoveItem () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartTSHIRT();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        softAssert.assertEquals(cardPage.sumItem(), 3, "Количество товаров не соответствует");
        cardPage.removeItemBike();
        softAssert.assertEquals(cardPage.sumItem(), 2, "Количество товаров не соответствует");
        softAssert.assertAll();
    }
    @Test(testName = "Переход из корзины на страницу товаров")
    public void checkContinueShopping () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.openCart();
        cardPage.checkTitle();
        softAssert.assertEquals(cardPage.sumItem(), 1, "Количество товаров не соответствует");
        cardPage.continueShopping();
        productsPage.isPageOpened();
        softAssert.assertAll();
    }
    @Test(testName = "Проверка перехода на страницу Checkout")
    public void checkCheckout () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.openCart();
        cardPage.checkTitle();
        softAssert.assertEquals(cardPage.sumItem(), 1, "Количество товаров не соответствует");
        cardPage.moveToCheckout();
        softAssert.assertEquals(checkoutPage.checkFirstNameInput(), true, "Не удалось перейти на страницу Checkout");
        softAssert.assertAll();
    }
}

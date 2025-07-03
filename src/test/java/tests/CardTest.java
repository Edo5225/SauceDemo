package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CardTest extends BaseTest{

    @Test
    public void checkMultipleItemName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartTSHIRT();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        assertEquals(cardPage.checkItemBikeName(), "Sauce Labs Bike Light", "Название не соответствует");
        assertEquals(cardPage.checkItemTShirtName(), "Sauce Labs Bolt T-Shirt", "Название не соответствует");
        assertEquals(cardPage.checkItemBackpackName(), "Sauce Labs Backpack", "Название не соответствует");
    }

    @Test
    public void checkSumItem () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        assertEquals(cardPage.sumItem(), 2, "Количество товаров не соответствует");
    }

    @Test
    public void checkItemCost() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        assertEquals(cardPage.getItemCost().get(0).getText(), "$9.99", "Цена не соответствует");
        assertEquals(cardPage.getItemCost().get(1).getText(), "$29.99", "Цена не соответствует");
    }
    @Test
    public void checkRemoveItem () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.addToCartTSHIRT();
        productsPage.addToCartBackpack();
        productsPage.openCart();
        cardPage.checkTitle();
        assertEquals(cardPage.sumItem(), 3, "Количество товаров не соответствует");
        cardPage.removeItemBike();
        assertEquals(cardPage.sumItem(), 2, "Количество товаров не соответствует");
    }
    @Test
    public void checkContinueShopping () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.openCart();
        cardPage.checkTitle();
        assertEquals(cardPage.sumItem(), 1, "Количество товаров не соответствует");
        cardPage.continueShopping();
        productsPage.isPageOpened();
    }
    @Test
    public void checkCheckout () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.openCart();
        cardPage.checkTitle();
        assertEquals(cardPage.sumItem(), 1, "Количество товаров не соответствует");
        cardPage.moveToCheckout();
        assertTrue(checkoutPage.checkFirstNameInput(), "Не удалось перейти на страницу Checkout");
    }
}

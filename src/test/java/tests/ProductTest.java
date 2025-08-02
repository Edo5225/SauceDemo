package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest{

    @Test(testName = "Тест перехода на страницу корзины")
    public void checkMoveToCart () {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.addToCartBike();
        productsPage.openCart();
        softAssert.assertEquals(cardPage.checkTitle(), "Your Cart", "Наименование тайтла не соответствует");
    }

    @Test(testName = "Тест добавления товара в корзину")
    public void checkAddedItemToCart () {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.addToCartBike();
        productsPage.openCart();
        cardPage.checkItemBikeName();
    }
}

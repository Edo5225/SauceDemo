package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest{

    @Test
    public void checkMoveToCart () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.openCart();
        assertEquals(cardPage.checkTitle(), "Your Cart", "Наименование тайтла не соответствует");
    }

    @Test
    public void checkAddedItemToCart () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCartBike();
        productsPage.openCart();
        cardPage.checkItemBikeName();
    }
}

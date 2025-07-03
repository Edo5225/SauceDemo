package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{

    @Test(priority = 1, description = "Проверка входа без пароля", invocationCount = 1, testName = "Негативный тест логина без пароля")
    public void checkLoginWithoutPassword(){
        loginPage.open();
        loginPage.login("standart_user", "");
        softAssert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Сообщение не соответствует");
        softAssert.assertAll();
    }
    @Test(testName = "Тест авторизации без логина")
    public void checkLoginWithoutUserName(){
        loginPage.open();
        loginPage.login("", "secret_sauce");
        softAssert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Сообщение не соответствует");
        softAssert.assertAll();

    }
    @Test(testName = "Авторизация с невалидными данными")
    public void checkLoginWithNegativeValue(){
        loginPage.open();
        loginPage.login("test", "test");
        softAssert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Сообщение не соответствует");
        softAssert.assertAll();
    }

    @Test(testName = "Авторизация с валидными данными")
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertFalse(productsPage.isPageOpened());
        softAssert.assertAll();
    }
    @DataProvider (name = "LoginData")
    public  Object[][] loginData() {
        return new Object[][]{
                {"standart_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"test","test","Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @Test(dataProvider="LoginData")
    public void checkNegative(String user, String password, String expected_message) {
        loginPage.open();
        loginPage.login(user, password);
        softAssert.assertEquals(loginPage.getErrorMessage(), expected_message, "Сообщение не соответствует");
        softAssert.assertAll();
    }
}

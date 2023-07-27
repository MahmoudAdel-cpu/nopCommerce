package TestPages;

import Base.TestBase;
import Pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PurchaceTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    ConfirmRegisterPage confirmRegisterPage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @BeforeTest
    public void setup() throws InterruptedException {
        initialization();
    }
    @Test
    public void purchasingScenario(){
        homePage = new HomePage(page);
        homePage.clickonRegister();
        registerPage = new RegisterPage(page);
        registerPage.selectGender().
                enterFName(prop.getProperty("firstname")).
                enterLName(prop.getProperty("lastname")).
                selectDateOfBirth(
                        prop.getProperty("day"),
                        prop.getProperty("month"),
                        prop.getProperty("year")).
                enterEmail(prop.getProperty("email")).
                enterPassword(prop.getProperty("password"),
                        prop.getProperty("password"));
        confirmRegisterPage = registerPage.clickOnRegisterBTN();
        confirmRegisterPage.getConfirmationMessgae();
        homePage = confirmRegisterPage.clickOnConfirmButton();
        homePage.clickonlogin();
        loginPage = new LoginPage(page);
        loginPage.enterLoginEmail(prop.getProperty("email")).
                enterLoginPassword(prop.getProperty("password")).
                clickOnLoginBTN();
        homePage.categoriesHover().
                getDesktops();
        productsPage = new ProductsPage(page);
        productsPage.clickOnLenovoProduct().
                addLenovoProductToCart().
                editQuantity(prop.getProperty("quantity")).
                addLenovoProductToCart();
        homePage.clickOnShoppingCart();
        shoppingCartPage = new ShoppingCartPage(page);
        shoppingCartPage.checkTerms().
                clickOnCheckoutBTN();
        checkoutPage = new CheckoutPage(page);
        checkoutPage.BillingDetails(prop.getProperty("country"),
                (prop.getProperty("city")),
                (prop.getProperty("address")),
                (prop.getProperty("zipCode")),
                (prop.getProperty("phone"))).
                SelectShippingMethod().
                SelectPaymentMethod();
    }
}

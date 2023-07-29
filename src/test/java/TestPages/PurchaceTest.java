package TestPages;

import Base.PlaywrightFactory;
import Pages.*;
import Utils.helperFNCs;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.helperFNCs.startTracing;

public class PurchaceTest extends PlaywrightFactory {
    HomePage homePage;
    RegisterPage registerPage;
    ConfirmRegisterPage confirmRegisterPage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void startTrace(){
        startTracing();
    }
    @Test
    @Description("Order an item with logged-in user, and confirm order with specific payment method")
    @Severity(SeverityLevel.CRITICAL)
    public void purchasingScenario(){
        homePage = new HomePage(page);
        homePage.clickonRegister();
        registerPage = new RegisterPage(page);
        registerPage.selectGender().
                enterFName(prop.getProperty("purchasefname")).
                enterLName(prop.getProperty("purchaselname")).
                selectDateOfBirth(
                        prop.getProperty("day"),
                        prop.getProperty("month"),
                        prop.getProperty("year")).
                enterEmail(prop.getProperty("purchasemail")).
                enterPassword(prop.getProperty("password"),
                        prop.getProperty("password"));
        confirmRegisterPage = registerPage.clickOnRegisterBTN();
        confirmRegisterPage.getConfirmationMessgae();
        homePage = confirmRegisterPage.clickOnConfirmButton();
        homePage.clickonlogin();
        loginPage = new LoginPage(page);
        loginPage.enterLoginEmail(prop.getProperty("purchasemail")).
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
                SelectPaymentMethod().
                confirmOrder().
                getConfirmationMSG();
    }
    @AfterMethod
    public void endTracing(){
        helperFNCs.endTracing("PurchasingTrace");
    }
}

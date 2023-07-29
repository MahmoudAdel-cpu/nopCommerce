package TestPages;

import Base.PlaywrightFactory;
import Pages.HomePage;
import Pages.LenovoProductPage;
import Pages.ProductsPage;
import Pages.ShoppingCartPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.helperFNCs.endTracing;
import static Utils.helperFNCs.startTracing;

public class ShoppingCartPageTest extends PlaywrightFactory {
    HomePage homePage;
    ProductsPage productsPage;
    LenovoProductPage lenovoProductPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void startTrace(){
        startTracing();
    }

    @Test
    @Description("Adding item to cart and agree on terms")
    public void shopping(){
        homePage = new HomePage(page);
        homePage.categoriesHover().
                getDesktops();
        productsPage = new ProductsPage(page);
        productsPage.clickOnLenovoProduct();
        lenovoProductPage = new LenovoProductPage(page);
        lenovoProductPage.addLenovoProductToCart();
        homePage.clickOnShoppingCart();
        shoppingCartPage = new ShoppingCartPage(page);
        shoppingCartPage.checkTerms();
    }
    @AfterMethod
    public void endTrace(){
        endTracing("AddingToCartTrace");
    }
}

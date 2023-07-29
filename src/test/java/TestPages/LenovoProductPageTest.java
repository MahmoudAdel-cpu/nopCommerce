package TestPages;

import Base.PlaywrightFactory;
import Pages.HomePage;
import Pages.LenovoProductPage;
import Pages.ProductsPage;
import Utils.helperFNCs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utils.helperFNCs.startTracing;

public class LenovoProductPageTest extends PlaywrightFactory {
    HomePage homePage;
    LenovoProductPage lenovoProductPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void startTrace(){
        startTracing();
    }
    @Test
    public void addingLenovoToCart(){
        homePage = new HomePage(page);
        homePage.categoriesHover().
                getDesktops();
        productsPage = new ProductsPage(page);
        productsPage.clickOnLenovoProduct();
        lenovoProductPage = new LenovoProductPage(page);
        lenovoProductPage.editQuantity(prop.getProperty("quantity")).
                addLenovoProductToCart();
    }
    @AfterMethod
    public void endTracing(){
        helperFNCs.endTracing("LenovoTrace");
    }
}

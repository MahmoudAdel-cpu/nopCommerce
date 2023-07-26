package TestPages;

import Base.TestBase;
import Pages.HomePage;
import Pages.LenovoProductPage;
import Pages.ProductsPage;
import Pages.ShoppingCartPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingCartPageTest extends TestBase {
    HomePage homePage;
    ProductsPage productsPage;
    LenovoProductPage lenovoProductPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeTest
    public void setup() throws InterruptedException {
        initialization();
    }
    @Test
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
}

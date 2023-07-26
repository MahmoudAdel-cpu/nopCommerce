package TestPages;

import Base.TestBase;
import Pages.HomePage;
import Pages.LenovoProductPage;
import Pages.ProductsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LenovoProductPageTest extends TestBase {
    HomePage homePage;
    LenovoProductPage lenovoProductPage;
    ProductsPage productsPage;

    @BeforeTest
    public void setup() throws InterruptedException {
        initialization();
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
}

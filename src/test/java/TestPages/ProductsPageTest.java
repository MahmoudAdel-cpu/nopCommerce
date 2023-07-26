package TestPages;

import Base.TestBase;
import Pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductsPageTest extends TestBase {

    HomePage homePage;
    @BeforeTest
    public void setup() throws InterruptedException {
        initialization();
    }
    @Test
    public void hoverOncat(){
        homePage = new HomePage(page);
        homePage.categoriesHover();
    }
}

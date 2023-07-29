package TestPages;

import Base.PlaywrightFactory;
import Pages.HomePage;
import Utils.helperFNCs;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utils.helperFNCs.startTracing;

public class CategoriesHover extends PlaywrightFactory {
    HomePage homePage;

    @BeforeMethod
    public void startTrace(){
        startTracing();
    }
    @Test
    @Description("Show Desktops items")
    public void getDesktopsProducts(){
        homePage = new HomePage(page);
        homePage.categoriesHover().
                getDesktops();
    }
    @AfterMethod
    public void endTracing(){
        helperFNCs.endTracing("DesktopItemsTrace");
    }
}

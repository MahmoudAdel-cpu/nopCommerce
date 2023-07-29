package TestPages;

import Base.PlaywrightFactory;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Utils.helperFNCs.endTracing;
import static Utils.helperFNCs.startTracing;

public class LoginPageTest extends PlaywrightFactory {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void startTrace(){
        startTracing();
    }
    @Test
    @Description("Login with data I entered while registering")
    public void validateLogin(){
        homePage  = new HomePage(page);
        loginPage = new LoginPage(page);
        homePage.clickonlogin();
        loginPage.enterLoginEmail(prop.getProperty("email")).
                enterLoginPassword(prop.getProperty("password")).
                clickOnLoginBTN();
    }
    @AfterMethod
    public void endTrace(){
        endTracing("LoginTrace");
    }
}

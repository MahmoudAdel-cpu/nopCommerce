package TestPages;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void setup() throws InterruptedException {
        initialization();
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
}

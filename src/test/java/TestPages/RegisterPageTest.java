package TestPages;
import Base.PlaywrightFactory;
import Pages.ConfirmRegisterPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utils.helperFNCs.endTracing;
import static Utils.helperFNCs.startTracing;

public class RegisterPageTest extends PlaywrightFactory {
    RegisterPage registerPage;
    HomePage homePage;
    ConfirmRegisterPage confirmRegisterPage;


    @BeforeMethod
    public void startTrace(){
        startTracing();
    }
    @Test
    @Description("Register with valid data")
    public void ValidateRegister(){
        homePage = new HomePage(page);
        registerPage = new RegisterPage(page);
        confirmRegisterPage = new ConfirmRegisterPage(page);
        homePage.clickonRegister();
        registerPage.selectGender().
                enterFName(prop.getProperty("firstname")).
                enterLName(prop.getProperty("lastname")).
                selectDateOfBirth(
                prop.getProperty("day"),
                prop.getProperty("month"),
                prop.getProperty("year")).
                enterEmail(prop.getProperty("email")).
                enterPassword(prop.getProperty("password"), prop.getProperty("password"));
        confirmRegisterPage = registerPage.clickOnRegisterBTN();
        confirmRegisterPage.getConfirmationMessgae();
        homePage = confirmRegisterPage.clickOnConfirmButton();
    }
    @AfterMethod
    public void endTrace(){
        endTracing("RegisterTrace");
    }
}

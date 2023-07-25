package TestPages;
import Base.TestBase;
import Pages.ConfirmRegisterPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    RegisterPage registerPage;
    HomePage homePage;
    ConfirmRegisterPage confirmRegisterPage;


    @BeforeTest
    public void setup() throws InterruptedException {
        initialization();
    }
    @Test
    @Description("Validate Register")
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
}

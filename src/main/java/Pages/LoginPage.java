package Pages;

import Base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage extends PlaywrightFactory {

    Page page;

    public LoginPage (Page page){
        this.page = page;
    }

    private String emailField = "//input[@id='Email']";
    private String passwordField = "//input[@id='Password']";
    private String loginBTN = "//button[normalize-space()='Log in']";

    @Step
    public LoginPage enterLoginEmail(String email){
        page.fill(emailField, email);
        return this;
    }
     @Step
    public LoginPage enterLoginPassword(String password){
        page.fill(passwordField, password);
        return this;
    }
    @Step
    public LoginPage clickOnLoginBTN(){
        page.click(loginBTN);
        return this;
    }
}

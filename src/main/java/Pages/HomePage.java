package Pages;

import Base.TestBase;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage extends TestBase {

    Page page;

    private String loginBTN = "//a[normalize-space()='Log in']";
    private String registerBTN = "//a[normalize-space()='Register']";

    public HomePage(Page page) {
        this.page = page;
    }

    @Step
    public HomePage clickonlogin(){
        page.click(loginBTN);
        return this;
    }
    @Step
    public HomePage clickonRegister(){
        page.click(registerBTN);
        return this;
    }
}

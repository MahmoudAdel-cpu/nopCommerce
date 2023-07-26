package Pages;

import Base.TestBase;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage extends TestBase {

    Page page;

    private String loginBTN = "//a[normalize-space()='Log in']";
    private String registerBTN = "//a[normalize-space()='Register']";
    private String catHover = "//ul[@class=\"top-menu notmobile\"]/li/a";
    private String desktopsCategory = "(//a[normalize-space()='Desktops'])[1]";

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
    @Step
    public HomePage categoriesHover(){
        ElementHandle categories = page.querySelector(catHover);
        categories.hover();
        return this;
    }
    public HomePage getDesktops(){
        page.click(desktopsCategory);
        return this;
    }
}

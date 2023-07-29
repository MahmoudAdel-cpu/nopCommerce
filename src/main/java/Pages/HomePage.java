package Pages;

import Base.PlaywrightFactory;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage extends PlaywrightFactory {

    Page page;

    private String loginBTN = "//a[normalize-space()='Log in']";
    private String registerBTN = "//a[normalize-space()='Register']";
    private String catHover = "//ul[@class=\"top-menu notmobile\"]/li/a";
    private String desktopsCategory = "(//a[normalize-space()='Desktops'])[1]";
    private String shoppingCartIcon = "//span[@class='cart-label']";

    public HomePage(Page page) {
        this.page = page;
    }

    @Step
    public HomePage clickonlogin(){
        page.click(loginBTN);
        return this;
    }
    @Step("click on")
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
    public HomePage clickOnShoppingCart(){
        page.click(shoppingCartIcon);
        return this;
    }
}

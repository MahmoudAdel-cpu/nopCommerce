package Pages;

import Base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LenovoProductPage extends PlaywrightFactory {

    Page page;
    private String productQuantity = "(//input[@id='product_enteredQuantity_3'])";
    private String addToCartBTN = "//button[@id='add-to-cart-button-3']";

    public LenovoProductPage (Page page){
        this.page = page;
    }
    @Step
    public LenovoProductPage editQuantity(String quantity){
        page.fill(productQuantity,quantity);
        return this;
    }
    @Step
    public LenovoProductPage addLenovoProductToCart(){
        page.click(addToCartBTN);
        return this;
    }
}

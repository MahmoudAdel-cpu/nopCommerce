package Pages;

import Base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class ShoppingCartPage extends PlaywrightFactory {

    Page page;
    private String termOfServce = "//input[@id='termsofservice']";
    private String checkoutBTN = "//button[@id='checkout']";

    public ShoppingCartPage(Page page) {
        this.page = page;
    }

    @Step
    public ShoppingCartPage checkTerms() {
        page.click(termOfServce);
        if (page.locator(termOfServce).isChecked()) {
            System.out.println("Agreed with terms of service");
        } else {
            System.out.println("Did not agree with terms of service");
        }
        return this;
    }
    public ShoppingCartPage clickOnCheckoutBTN(){
        page.click(checkoutBTN);
        return this;
    }
}

package Pages;

import Base.TestBase;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import io.qameta.allure.Step;

public class CheckoutPage extends TestBase {

    Page page;
     private String countrySelector = "//select[@id='BillingNewAddress_CountryId']";
     private String myCity = "//input[@id='BillingNewAddress_City']";
     private String myAddress = "//input[@id='BillingNewAddress_Address1']";
     private String stateZipCode = "//input[@id='BillingNewAddress_ZipPostalCode']";
     private String myPhoneNumber = "//input[@id='BillingNewAddress_PhoneNumber']";
     private String contineBTN = "button[onclick='Billing.save()']";
     private String shippingMethod = "//input[@id='shippingoption_0']";
     private String shippingMethodContinueBTN = "//button[@class='button-1 shipping-method-next-step-button']";
     private String moneyOrderMethod = "//input[@id='paymentmethod_0']";
     private String creditCardMethod = "//input[@id='paymentmethod_1']";
     private String paymentContinueBTN = "//button[@class='button-1 payment-method-next-step-button']";
    private String cardHolderName = "//input[@id='CardholderName']";
    private String cardNumber = "//input[@id='CardNumber']";
    private String expMonthDate = "//select[@id='ExpireMonth']";
    private String expYearDate = "//select[@id='ExpireYear']";
    private String cardCode = "//input[@id='CardCode']";
    private String savePaymentMethodBTN = "//button[@class='button-1 payment-info-next-step-button']";
    public CheckoutPage (Page page){
        this.page = page;
    }
    public CheckoutPage BillingDetails(String country,String address,String city, String zipCode,String phoneNumber){
        page.waitForSelector(countrySelector);
        ElementHandle countries = page.querySelector(countrySelector);
        countries.selectOption(new SelectOption().setLabel(country));
        page.fill(myAddress, address);
        page.fill(myCity, city);
        page.fill(stateZipCode, zipCode);
        page.fill(myPhoneNumber, phoneNumber);
        page.click(contineBTN);
        return this;
    }
    @Step
    public CheckoutPage SelectShippingMethod(){
        page.click(shippingMethod);
        page.click(shippingMethodContinueBTN);
        return this;
    }

    public CheckoutPage creditCardPaymentSceanrio(String holder, String number, String month, String year, String code){
        page.click(creditCardMethod);
        page.click(paymentContinueBTN);
        page.fill(cardHolderName,holder);
        page.fill(cardNumber,number);
        ElementHandle expiryMonth = page.querySelector(expMonthDate);
        ElementHandle expiryYear = page.querySelector(expYearDate);
        expiryMonth.selectOption(new SelectOption().setLabel(month));
        expiryYear.selectOption(new SelectOption().setLabel(year));
        page.fill(cardCode,code);
        page.click(savePaymentMethodBTN);
        return this;
    }
    @Step
    public CheckoutPage SelectPaymentMethod(){
        //page.click(moneyOrderMethod); // Money order method
        page.click(creditCardMethod); // Credit card method
        if (page.locator(moneyOrderMethod).isChecked()){
            String savePaymentMethodBTN = "//button[@class='button-1 payment-method-next-step-button']";
            page.click(savePaymentMethodBTN);
        }
        else {
            creditCardPaymentSceanrio(prop.getProperty("cardHolderName"),
                    prop.getProperty("cardNumber"),
                    prop.getProperty("expMonth"),
                    prop.getProperty("expYear"),
                    prop.getProperty("cardCode"));
        }
        return this;
    }
}

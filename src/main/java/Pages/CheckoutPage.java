package Pages;

import Base.TestBase;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class CheckoutPage extends TestBase {

    Page page;
     private String countrySelector = "//select[@id='BillingNewAddress_CountryId']";
     private String myCity = "//input[@id='BillingNewAddress_City']";
     private String myAddress = "//input[@id='BillingNewAddress_Address1']";
     private String stateZipCode = "//input[@id='BillingNewAddress_ZipPostalCode']";
     private String myPhoneNumber = "//input[@id='BillingNewAddress_PhoneNumber']";
     private String contineBTN = "button[onclick='Billing.save()']";
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
        return this;
    }

}

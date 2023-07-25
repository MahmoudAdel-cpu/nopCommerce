package Pages;

import Base.TestBase;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import io.qameta.allure.Step;

public class RegisterPage extends TestBase {
    Page page;

    private String maleGender = "//input[@id='gender-male']";
    private String femaleGener = "//input[@id='gender-female']";
    private String firstName = "//input[@id='FirstName']";
    private String lastName = "//input[@id='LastName']";
    private String dateOfBirth = "//select[@name='DateOfBirthDay']";
    private String monthOfBirth = "//select[@name='DateOfBirthMonth']";
    private String yearOfBirth = "//select[@name='DateOfBirthYear']";
    private String emailField = "//input[@id='Email']";
    private String passwordField = "//input[@id='Password']";
    private String confirmPasswordField = "//input[@id='ConfirmPassword']";
    private String registerBTN = "//button[@id='register-button']";

    public RegisterPage (Page page){
        this.page = page;
    }

    @Step
    public RegisterPage selectGender(){
        page.click(maleGender);
        return this;
    }
    @Step
    public RegisterPage enterFName(String FName){
        page.fill(firstName, FName);
        return this;
    }
    @Step
    public RegisterPage enterLName(String LName){
        page.fill(lastName, LName);
        return this;
    }
    @Step
    public RegisterPage selectDateOfBirth(String day, String month, String year) {
        // Wait for the element to be available before accessing it
        page.waitForSelector(dateOfBirth);
        page.waitForSelector(monthOfBirth);
        page.waitForSelector(yearOfBirth);
        ElementHandle DOB = page.querySelector(dateOfBirth);
        ElementHandle MOB = page.querySelector(monthOfBirth);
        ElementHandle YOB = page.querySelector(yearOfBirth);
        if (DOB != null && MOB != null && YOB != null) {
            DOB.selectOption(new SelectOption().setLabel(day));
            MOB.selectOption(new SelectOption().setLabel(month));
            YOB.selectOption(new SelectOption().setLabel(year));
        } else {
            System.out.println("Elements not found!");
            // Handle the error or throw an exception
        }
        return this;
    }
    @Step
    public RegisterPage enterEmail(String email){
        page.fill(emailField,email);
        return this;
    }
    @Step
    public RegisterPage enterPassword(String password, String confirmPassword){
        page.fill(passwordField,password);
        page.fill(confirmPasswordField,confirmPassword);
        return this;
    }
    @Step
    public ConfirmRegisterPage clickOnRegisterBTN(){
        page.click(registerBTN);
        return new ConfirmRegisterPage(page);
    }
}

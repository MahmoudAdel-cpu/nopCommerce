package Pages;

import Base.TestBase;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ConfirmRegisterPage extends TestBase {

    Page page;
    private String confirmMessage = "//div[@class='result']";
    private String confirmButton = "//a[normalize-space()='Continue']";
    public ConfirmRegisterPage(Page page){
        this.page = page;
    }
    @Step
    public ConfirmRegisterPage getConfirmationMessgae(){
        page.waitForSelector(confirmMessage);
        assertThat(page.locator(confirmMessage)).hasText("Your registration completed");
        return this;
    }
    @Step
    public HomePage clickOnConfirmButton(){
        page.click(confirmButton);
        return new HomePage(page);
    }
}

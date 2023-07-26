package Pages;

import Base.TestBase;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class ProductsPage extends TestBase {

    Page page;
    private String lenovoProduct = "//h2[@class='product-title']//a[contains(text(),'Lenovo IdeaCentre 600 All-in-One PC')]";

    public ProductsPage (Page page){
        this.page = page;
    }

    @Step
    public LenovoProductPage clickOnLenovoProduct(){
        page.click(lenovoProduct);
        return new LenovoProductPage(page);
    }
}

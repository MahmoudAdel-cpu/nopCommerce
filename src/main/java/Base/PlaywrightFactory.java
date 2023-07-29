package Base;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    public static Page page;
    public static Browser browser;
    public static BrowserContext browserContext;
    public static Properties prop;

    public static Playwright playwright;
    final static private String propPath = "C:\\Users\\LAPTOP WORLD\\IdeaProjects\\nopCommerce\\src\\main\\resources\\Config\\config.properties";

    public PlaywrightFactory(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream(propPath);
            prop.load(ip);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @BeforeTest
    public static void initialization() throws InterruptedException {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")){
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            browserContext = browser.newContext();
            page = browserContext.newPage();
            page.navigate(prop.getProperty("url"));
            page.waitForLoadState(LoadState.NETWORKIDLE);

        } else { playwright = Playwright.create();
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            browserContext = browser.newContext();
            page = browserContext.newPage();
            page.navigate(prop.getProperty("url"));
            page.waitForLoadState(LoadState.NETWORKIDLE);
        }
    }
    @AfterTest
    public void tearDown(){
        page.close();
    }

}

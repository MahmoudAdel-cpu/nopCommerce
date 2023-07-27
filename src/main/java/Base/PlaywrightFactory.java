package Base;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class TestBase {

    public static Page page;
    public static Browser browser;
    public static BrowserContext browserContext;
    public static Properties prop;

    public static Playwright playwright;

    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\LAPTOP WORLD\\IdeaProjects\\nopCommerce\\src\\main\\resources\\Config\\config.properties");
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
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

        } else { playwright = Playwright.create();
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            browserContext = browser.newContext();
            page = browserContext.newPage();
            page.navigate(prop.getProperty("url"));
            page.waitForLoadState(LoadState.NETWORKIDLE);
            page.setDefaultTimeout(90000);

        }
    }
    public void SS(String ScreenshotReportname,String screenshotFoldername) throws IOException{
        String path = "C:\\Users\\LAPTOP WORLD\\IdeaProjects\\nopCommerce\\screenshots\\";
        // Capture screenshot
        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));

        // Save screenshot to a file
        File screenshotFile = new File(path + screenshotFoldername + ".png");
        FileUtils.writeByteArrayToFile(screenshotFile, screenshot);

        // Attach screenshot to Allure report
        Allure.addAttachment(ScreenshotReportname, "image/png", FileUtils.openInputStream(screenshotFile), "png");
    }
    @AfterTest
    public void tearDown(){
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
    }

}

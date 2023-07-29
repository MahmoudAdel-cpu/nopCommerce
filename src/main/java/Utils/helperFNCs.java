package Utils;

import Base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class helperFNCs extends PlaywrightFactory {
    static final private String tracePath = "C:\\Users\\LAPTOP WORLD\\IdeaProjects\\nopCommerce\\TraceView\\";
    static final private String extension = ".zip";
    public static void startTracing(){
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }
    public static void endTracing(String testTraceName){

        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get(tracePath + testTraceName + extension)));
    }
    public static void takeScreenshot(String ScreenshotReportname,String screenshotFoldername)throws IOException {

            String path = "C:\\Users\\LAPTOP WORLD\\IdeaProjects\\nopCommerce\\screenshots\\";
            // Capture screenshot
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));

            // Save screenshot to a file
            File screenshotFile = new File(path + screenshotFoldername + ".png");
            FileUtils.writeByteArrayToFile(screenshotFile, screenshot);

            // Attach screenshot to Allure report
            Allure.addAttachment(ScreenshotReportname, "image/png", FileUtils.openInputStream(screenshotFile), "png");
        }

    }


package PageObjects;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Utils extends BasePage {

    public void takeScreenshot(String filePath) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(filePath);
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
        }
    }
}

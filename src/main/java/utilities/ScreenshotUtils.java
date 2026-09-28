package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.Driverfactory;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    // Save PNG locally (optional)
    public static String captureScreenshot(String testName) {

        testName = testName.trim()
                .replaceAll("[^a-zA-Z0-9 _-]", "_");

        String time = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

        String fileName = testName + "_" + time + ".png";

        String folder = System.getProperty("user.dir")
                + File.separator + "Screenshots";

        File screenshotFolder = new File(folder);

        if (!screenshotFolder.exists()) {
            screenshotFolder.mkdirs();
        }

        File destination = new File(screenshotFolder, fileName);

        File source = ((TakesScreenshot) Driverfactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination.getAbsolutePath();
    }

    // Base64 for Extent Report
    public static String captureScreenshotBase64() {

        String base64 = ((TakesScreenshot) Driverfactory.getDriver())
                .getScreenshotAs(OutputType.BASE64);

        return "data:image/png;base64," + base64;
    }
    
}
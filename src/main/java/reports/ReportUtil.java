package reports;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import reports.ExtentTestManager;
import utilities.ScreenshotUtils;

public class ReportUtil {

    public static void logPage(String pageName) {

        try {

            if (ExtentTestManager.getTest() == null) {
                return;
            }

            String fileName =
                    ExtentTestManager.getTestCaseId()
                    + "_"
                    + pageName;

            ScreenshotUtils.captureScreenshot(fileName);

            String base64 =
                    ScreenshotUtils.captureScreenshotBase64();

            ExtentTestManager.getTest()
                    .info(
                            pageName,
                            MediaEntityBuilder
                                    .createScreenCaptureFromBase64String(
                                            base64,
                                            pageName)
                                    .build());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public static void logInfo(String message) {

        if (ExtentTestManager.getTest() == null) {
            return;
        }

        ExtentTestManager.getTest()
                .info(message);
    }


    public static void logPass(String message) {

        try {

            ExtentTest test =
                    ExtentTestManager.getTest();

            if (test == null) {

                System.out.println(
                        "ERROR: ExtentTest is NULL for: "
                        + message);

                return;
            }

            String fileName =
                    ExtentTestManager.getTestCaseId()
                    + "_Screenshot";

            ScreenshotUtils.captureScreenshot(fileName);

            String base64 =
                    ScreenshotUtils.captureScreenshotBase64();

            test.pass(
                    message,
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    base64,
                                    "Screenshot")
                            .build());

            System.out.println(
                    "Screenshot attached successfully for: "
                    + message);

        } catch (Exception e) {

            System.out.println(
                    "Screenshot attachment failed for: "
                    + message);

            e.printStackTrace();

            if (ExtentTestManager.getTest() != null) {

                ExtentTestManager.getTest()
                        .pass(message);
            }
        }
    }


    public static String getFullPageScreenshot(WebDriver driver) {

        try {

            /*
             * Selenium generic screenshot.
             * Works with Chrome, Edge and Firefox.
             */
            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);

            return java.util.Base64
                    .getEncoder()
                    .encodeToString(screenshot);

        } catch (Exception e) {

            System.out.println(
                    "Unable to capture screenshot: "
                    + e.getMessage());

            return null;
        }
    }


    public static void attachFullPageScreenshot(
            WebDriver driver,
            String message) {

        ExtentTest extentTest =
                ExtentTestManager.getTest();

        if (extentTest == null) {

            System.out.println(
                    "ExtentTest is NULL.");

            return;
        }

        try {

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;


            WebElement scrollElement =
                    (WebElement) js.executeScript(

                            "let elements = document.querySelectorAll('*');"
                            + "let candidate = null;"
                            + "let maxHeight = 0;"

                            + "for (let el of elements) {"

                            + "    let style = window.getComputedStyle(el);"

                            + "    if ((style.overflowY === 'auto' "
                            + "        || style.overflowY === 'scroll')"

                            + "        && el.scrollHeight > el.clientHeight"

                            + "        && el.scrollHeight > maxHeight) {"

                            + "        candidate = el;"
                            + "        maxHeight = el.scrollHeight;"

                            + "    }"

                            + "}"

                            + "return candidate;"
                    );


          
            if (scrollElement == null) {

                System.out.println(
                        "Scrollable element not found. "
                        + "Using browser window.");

                scrollElement =
                        (WebElement) js.executeScript(
                                "return document.documentElement;");
            }


            long scrollHeight =
                    ((Number) js.executeScript(
                            "return arguments[0].scrollHeight;",
                            scrollElement))
                    .longValue();


            long clientHeight =
                    ((Number) js.executeScript(
                            "return arguments[0].clientHeight;",
                            scrollElement))
                    .longValue();


            System.out.println(
                    "=================================");

            System.out.println(
                    "FULL PAGE SCREENSHOT");

            System.out.println(
                    "Scroll Height : "
                    + scrollHeight);

            System.out.println(
                    "Client Height : "
                    + clientHeight);

            System.out.println(
                    "Browser : "
                    + driver.getClass().getSimpleName());

            System.out.println(
                    "=================================");


            js.executeScript(
                    "arguments[0].scrollTop = 0;",
                    scrollElement);


            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);


            String base64Screenshot =
                    java.util.Base64
                            .getEncoder()
                            .encodeToString(screenshot);


            if (base64Screenshot == null
                    || base64Screenshot.isEmpty()) {

                extentTest.warning(
                        "Screenshot data is empty.");

                return;
            }


            extentTest.pass(
                    message,
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    base64Screenshot,
                                    message)
                            .build());


            System.out.println(
                    "Full page screenshot attached successfully.");


        } catch (Exception e) {

            System.out.println(
                    "Unable to capture full page screenshot.");

            System.out.println(
                    "Browser = "
                    + driver.getClass().getSimpleName());

            e.printStackTrace();


            if (ExtentTestManager.getTest() != null) {

                ExtentTestManager.getTest()
                        .warning(
                                "Screenshot failed: "
                                + e.getMessage());
            }
        }
    }


    public static void logFail(String message) {

        try {

            if (ExtentTestManager.getTest() == null) {
                return;
            }

            String fileName =
                    ExtentTestManager.getTestCaseId()
                    + "_Failure";

            ScreenshotUtils.captureScreenshot(fileName);

            String base64 =
                    ScreenshotUtils.captureScreenshotBase64();

            ExtentTestManager.getTest()
                    .fail(
                            message,
                            MediaEntityBuilder
                                    .createScreenCaptureFromBase64String(
                                            base64,
                                            "Failure")
                                    .build());

        } catch (Exception e) {

            if (ExtentTestManager.getTest() != null) {

                ExtentTestManager.getTest()
                        .fail(message);
            }
        }
    }
}
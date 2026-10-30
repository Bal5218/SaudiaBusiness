package reports;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.chrome.ChromeDriver;




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


    public static void logIfNotBlank(String label, String value) {

        if (label != null
                && !label.trim().isEmpty()
                && value != null
                && !value.trim().isEmpty()) {

            logInfo(label.trim() + " : " + value.trim());
        }
    }
    public static void logInfo(String message) {

        if (ExtentTestManager.getTest() == null
                || message == null
                || message.trim().isEmpty()) {
            return;
        }

        String cleanMessage = message.trim();

        // "Industry :" jaise blank label logs ko skip karega
        int colonIndex = cleanMessage.indexOf(':');

        if (colonIndex >= 0) {
            String value = cleanMessage.substring(colonIndex + 1).trim();

            if (value.isEmpty()) {
                return;
            }
        }

        ExtentTestManager.getTest().info(cleanMessage);
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


//    public static void attachFullPageScreenshot(
//            WebDriver driver,
//            String message) {
//
//        ExtentTest extentTest =
//                ExtentTestManager.getTest();
//
//        if (extentTest == null) {
//
//            System.out.println(
//                    "ExtentTest is NULL.");
//
//            return;
//        }
//
//        try {
//
//            JavascriptExecutor js =
//                    (JavascriptExecutor) driver;
//
//
//            WebElement scrollElement =
//                    (WebElement) js.executeScript(
//
//                            "let elements = document.querySelectorAll('*');"
//                            + "let candidate = null;"
//                            + "let maxHeight = 0;"
//
//                            + "for (let el of elements) {"
//
//                            + "    let style = window.getComputedStyle(el);"
//
//                            + "    if ((style.overflowY === 'auto' "
//                            + "        || style.overflowY === 'scroll')"
//
//                            + "        && el.scrollHeight > el.clientHeight"
//
//                            + "        && el.scrollHeight > maxHeight) {"
//
//                            + "        candidate = el;"
//                            + "        maxHeight = el.scrollHeight;"
//
//                            + "    }"
//
//                            + "}"
//
//                            + "return candidate;"
//                    );
//
//
//          
//            if (scrollElement == null) {
//
//                System.out.println(
//                        "Scrollable element not found. "
//                        + "Using browser window.");
//
//                scrollElement =
//                        (WebElement) js.executeScript(
//                                "return document.documentElement;");
//            }
//
//
//            long scrollHeight =
//                    ((Number) js.executeScript(
//                            "return arguments[0].scrollHeight;",
//                            scrollElement))
//                    .longValue();
//
//
//            long clientHeight =
//                    ((Number) js.executeScript(
//                            "return arguments[0].clientHeight;",
//                            scrollElement))
//                    .longValue();
//
//
//            System.out.println(
//                    "=================================");
//
//            System.out.println(
//                    "FULL PAGE SCREENSHOT");
//
//            System.out.println(
//                    "Scroll Height : "
//                    + scrollHeight);
//
//            System.out.println(
//                    "Client Height : "
//                    + clientHeight);
//
//            System.out.println(
//                    "Browser : "
//                    + driver.getClass().getSimpleName());
//
//            System.out.println(
//                    "=================================");
//
//
//            js.executeScript(
//                    "arguments[0].scrollTop = 0;",
//                    scrollElement);
//
//
//            byte[] screenshot =
//                    ((TakesScreenshot) driver)
//                            .getScreenshotAs(OutputType.BYTES);
//
//
//            String base64Screenshot =
//                    java.util.Base64
//                            .getEncoder()
//                            .encodeToString(screenshot);
//
//
//            if (base64Screenshot == null
//                    || base64Screenshot.isEmpty()) {
//
//                extentTest.warning(
//                        "Screenshot data is empty.");
//
//                return;
//            }
//
//
//            extentTest.pass(
//                    message,
//                    MediaEntityBuilder
//                            .createScreenCaptureFromBase64String(
//                                    base64Screenshot,
//                                    message)
//                            .build());
//
//
//            System.out.println(
//                    "Full page screenshot attached successfully.");
//
//
//        } catch (Exception e) {
//
//            System.out.println(
//                    "Unable to capture full page screenshot.");
//
//            System.out.println(
//                    "Browser = "
//                    + driver.getClass().getSimpleName());
//
//            e.printStackTrace();
//
//
//            if (ExtentTestManager.getTest() != null) {
//
//                ExtentTestManager.getTest()
//                        .warning(
//                                "Screenshot failed: "
//                                + e.getMessage());
//            }
//        }
//    }

public static void attachFullPageScreenshot(
        WebDriver driver,
        String message) {

    ExtentTest extentTest = ExtentTestManager.getTest();

    if (extentTest == null) {
        System.out.println("ExtentTest is NULL.");
        return;
    }

    try {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Save styles and expand the largest scrollable element.
        // This is useful when the booking form has an inner scrollbar.
        js.executeScript(
            "window.__screenshotOriginalStyles = [];" +
            "let elements = [...document.querySelectorAll('*')];" +
            "let candidates = elements.filter(el => " +
            "el.scrollHeight > el.clientHeight + 5 && " +
            "(getComputedStyle(el).overflowY === 'auto' || " +
            " getComputedStyle(el).overflowY === 'scroll'));" +
            "candidates.sort((a,b) => b.scrollHeight-a.scrollHeight);" +
            "let el = candidates[0];" +
            "if(el) {" +
            " let s = el.style;" +
            " window.__screenshotOriginalStyles.push([" +
            "el, s.height, s.maxHeight, s.overflowY]);" +
            " s.setProperty('height', el.scrollHeight + 'px', 'important');" +
            " s.setProperty('max-height', 'none', 'important');" +
            " s.setProperty('overflow-y', 'visible', 'important');" +
            "}" +
            "return el ? el.scrollHeight : 0;"
        );

        // Get the full document dimensions.
        Map<String, Object> metrics =
                (Map<String, Object>) ((ChromeDriver) driver)
                        .executeCdpCommand(
                                "Page.getLayoutMetrics",
                                new HashMap<>());

        Map<String, Object> contentSize =
                (Map<String, Object>) metrics.get("cssContentSize");

        double width = ((Number) contentSize.get("width")).doubleValue();
        double height = ((Number) contentSize.get("height")).doubleValue();

        Map<String, Object> clip = new HashMap<>();
        clip.put("x", 0);
        clip.put("y", 0);
        clip.put("width", width);
        clip.put("height", height);
        clip.put("scale", 1);
        System.out.println("Screenshot width: " + width);
        System.out.println("Screenshot height: " + height);
        Map<String, Object> params = new HashMap<>();
        params.put("format", "png");
        params.put("captureBeyondViewport", true);
        params.put("fromSurface", true);
        params.put("clip", clip);

        Map<String, Object> result =
                ((ChromeDriver) driver).executeCdpCommand(
                        "Page.captureScreenshot", params);

        String base64Screenshot = (String) result.get("data");

        if (base64Screenshot == null || base64Screenshot.isEmpty()) {
            extentTest.warning("Full-page screenshot data is empty.");
            return;
        }

        extentTest.pass(
                message,
                MediaEntityBuilder
                        .createScreenCaptureFromBase64String(
                                base64Screenshot, null)
                        
                        
                        .build());

        System.out.println("CDP full-page screenshot attached.");

    } catch (Exception e) {
        extentTest.warning(
                "Full-page screenshot failed: " + e.getMessage());
        e.printStackTrace();

    } finally {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "if(window.__screenshotOriginalStyles) {" +
                "window.__screenshotOriginalStyles.forEach(a => {" +
                "a[0].style.height = a[1];" +
                "a[0].style.maxHeight = a[2];" +
                "a[0].style.overflowY = a[3];" +
                "});" +
                "delete window.__screenshotOriginalStyles;" +
                "}"
            );
        } catch (Exception e) {
            System.out.println("Could not restore screenshot styles.");
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
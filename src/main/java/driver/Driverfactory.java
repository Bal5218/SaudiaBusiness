package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class Driverfactory {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private Driverfactory() {
    }

    public static WebDriver initializeDriver(String browser) {

        WebDriver webDriver;

        if ("chrome".equalsIgnoreCase(browser)) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--guest");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            webDriver = new ChromeDriver(options);

        } else if ("edge".equalsIgnoreCase(browser)) {

            EdgeOptions options = new EdgeOptions();

            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            webDriver = new EdgeDriver(options);

        } else if ("firefox".equalsIgnoreCase(browser)) {

            FirefoxOptions options = new FirefoxOptions();

            webDriver = new FirefoxDriver(options);

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }

        driver.set(webDriver);

        return webDriver;
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        WebDriver webDriver = driver.get();

        if (webDriver != null) {

            webDriver.quit();

         //  driver.remove();
        }
    }
}
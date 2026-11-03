package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driver.Driverfactory;
import utilities.ConfigReader;

public class BaseClass {

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser)
            throws Throwable {

        WebDriver currentDriver =
                Driverfactory.initializeDriver(browser);

        currentDriver.manage().window().maximize();

        currentDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        currentDriver.get(ConfigReader.getproperty("url"));

        System.out.println(
                "Browser initialized | Thread ID: "
                + Thread.currentThread().getId()
        );
    }

    protected WebDriver getDriver() {

        return Driverfactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        System.out.println(
                "Closing browser | Thread ID: "
                + Thread.currentThread().getId()
        );

        Driverfactory.quitDriver();
    }
}
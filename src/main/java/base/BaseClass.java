package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import credentialPage.LoginPage;
import driver.Driverfactory;
import utilities.ConfigReader;

public class BaseClass {

    public WebDriver driver;

    private LoginPage loginPage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws Throwable {

        System.out.println("====================================");
        System.out.println("Browser = " + browser);
        System.out.println("Thread  = " + Thread.currentThread().getId());
        System.out.println("====================================");

        driver = Driverfactory.initializeDriver(browser);

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigReader.getproperty("url"));

        loginPage = new LoginPage(driver);

        loginPage.clickLogin();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        System.out.println("====================================");
        System.out.println("Closing Browser");
        System.out.println("Thread = " + Thread.currentThread().getId());
        System.out.println("====================================");

        Driverfactory.quitDriver();

        driver = null;
    }
    //commit code
    system.out.println("something");
}



//
//package base;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//import credentialPage.LoginPage;
//import driver.Driverfactory;
//import utilities.ConfigReader;
//
//public class BaseClass {
//
//    public WebDriver driver;
//
//    private LoginPage loginPage;
//
//    @Parameters("browser")
//    @BeforeMethod
//    public void setup(@Optional("chrome") String browser)
//            throws Throwable {
//
//        driver = Driverfactory.initializeDriver(browser);
//
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts()
//                .implicitlyWait(Duration.ofSeconds(10));
//
//        driver.get(ConfigReader.getproperty("url"));
//
//        loginPage = new LoginPage(driver);
//
////        loginPage.clickLogin(data.getLoginRole());
//
//        System.out.println("Login completed. Reusing same session.");
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//
//        Driverfactory.quitDriver();
//
//        driver = null;
//
//        System.out.println("Browser closed after all test methods.");
//    }
//}

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

    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser)
            throws Throwable {

        driver = Driverfactory.initializeDriver(browser);

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigReader.getproperty("url"));

        System.out.println("Browser initialized successfully.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        Driverfactory.quitDriver();

        driver = null;

        System.out.println("Browser closed after test method.");
    }
}

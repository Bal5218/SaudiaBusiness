//package credentialPage;
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.support.FindBy;
//
//
//import base.BasePage;
//import reports.ExtentTestManager;
//import utilities.ConfigReader;
//import utilities.WebdriverUtility;
//
//public class LoginPage extends BasePage{
//
//	
//	private WebdriverUtility webdriverUtility;
//
//	public LoginPage(WebDriver driver) {
//		super(driver);
//		 webdriverUtility = new WebdriverUtility(driver);
//		
//	}
//	
//	 @FindBy(xpath = "//a[@href='/login']")
//	    private WebElement prestLoginBtn;
//
//		@FindBy(xpath = "//a[@role='button' and normalize-space()='Login']")
//	    private WebElement uatLoginBtn;
//
//
//		@FindBy(xpath = "//div[@role='heading' and contains(.,'Enter password')]")
//	    private WebElement Passwordheading;
//
//
//		 @FindBy(xpath = "//input[@formcontrolname='email']")
//	    private WebElement presitEmailTxtbox;
//
//
//		//  @FindBy(xpath = "//input[@class='input c8adb483d c3b10bad1' and @id='username']")
//	    // private WebElement UatEmailTxtbox;
//@FindBy(id = "username")
//private WebElement UatEmailTxtbox;
//	    @FindBy(xpath = "//input[@class='form-control ltr_override input ext-input text-box ext-text-box']")
//	    private WebElement SignInEmailtxtbox;
//
//		@FindBy(xpath = "//input[@class='form-control input ext-input text-box ext-text-box show-reveal-password ext-show-reveal-password']")
//	    private WebElement SignInpasswordtxtbox;
//
//	    @FindBy(xpath="//input[@id='mat-input-1']")
//	    private WebElement PresitPasswordTextbox;
//
//		@FindBy(xpath="//input[@name='password' and @type='password']")
//	    private WebElement UatPasswordTextbox;
//
//		 @FindBy(xpath="//button[@class='c0bc5f06e ce04d888b cfe5b89c1 cd009d33f _button-login-id' and contains(.,'Continue')]")
//	    private WebElement emailContinuebtn;
//	 @FindBy(xpath="//button[@class='c0bc5f06e ce04d888b cfe5b89c1 cd009d33f _button-login-password' and contains(.,'Continue')]")
//	    private WebElement PasswordContinuebtn;
//	
//		@FindBy(xpath="//button[@type='submit'and text()='Continue']")
//	    private WebElement codeContinuebtn;
//	
//	
//		 @FindBy(xpath = "//button[@type='submit' and contains(@class,'button--primary-large') and .//span[normalize-space()='Login']]")
//		    private WebElement PresItUserLoginbtn;
//		 
//		 @FindBy(xpath = "//button[contains(@class,'mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable') and contains(normalize-space(.),'Accept')]")
//                  private WebElement AcceptCookieBtn;
//		 
//		  private void SignIn() {
//		
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//By signInHeading = By.xpath("//div[@role='heading' and normalize-space()='Sign in']");
//By Nextbtn = By.xpath("//input[@id='idSIButton9']");
//    By passwordHeading = By.xpath("//div[@role='heading' and contains(.,'Enter password')]");
//
//
//
//if (!driver.findElements(signInHeading).isEmpty()) {
//
//webdriverUtility.waitForVisibility(SignInEmailtxtbox);
//
//
//
//String signInmail=ConfigReader.getproperty("signEmail"); 
//
//
//                    SignInEmailtxtbox.clear();
//
//                SignInEmailtxtbox.sendKeys(signInmail);
//
//				webdriverUtility.click(Nextbtn);
//			
//}
//if (!driver.findElements(passwordHeading).isEmpty()||SignInpasswordtxtbox.isDisplayed()){
//	webdriverUtility.waitForVisibility(SignInpasswordtxtbox);
//
//String signInpassword=ConfigReader.getproperty("signPassword"); 
//
//SignInpasswordtxtbox.clear();
//
//SignInpasswordtxtbox.sendKeys(signInpassword);
//
//webdriverUtility.click(Nextbtn);
//
//
//
//
//}
//		  }
//
//		public void Login(String role) throws Throwable{
//
//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
//			
//		String url = ConfigReader.getproperty("url");
//		ExtentTestManager.setRuntimePnr(
//		        ExtentTestManager.getTestCaseId(),
//		        url
//		);
//
//		
//		String email = ConfigReader.getproperty("Email");
//		ExtentTestManager.setRuntimePnr(
//		        ExtentTestManager.getTestCaseId(),
//		        email
//		);
//		
//		String password = ConfigReader.getproperty("Password");
//		
//		System.out.println("Login role: " + role);
//	    System.out.println("Login email: " + email);
//
//if (url.contains("uat")) {
//wait1.until(ExpectedConditions.elementToBeClickable(uatLoginBtn));
//    webdriverUtility.click(uatLoginBtn);
//wait1.until(ExpectedConditions.elementToBeClickable(UatEmailTxtbox));
//UatEmailTxtbox.clear();
//UatEmailTxtbox.sendKeys(email);
//System.out.println("email is :"+email);
//
//webdriverUtility.click(emailContinuebtn);
//wait1.until(ExpectedConditions.elementToBeClickable(UatPasswordTextbox));
//UatPasswordTextbox.clear();
//UatPasswordTextbox.sendKeys(password);
//System.out.println(password);
//webdriverUtility.click(PasswordContinuebtn);
//
//
//// Click Continue button: maximum 10 attempts
//boolean isClicked = false;
//
//By continueLocator = By.xpath(
//    "//button[@type='submit' and @name='action' and normalize-space(.)='Continue']"
//);
//
//WebDriverWait otpWait =
//        new WebDriverWait(driver, Duration.ofSeconds(300));
//
//
//otpWait.until(ExpectedConditions.elementToBeClickable(continueLocator));
//
//System.out.println("OTP Continue button clicked.");
//
//By invalidCodeMessage = By.xpath(
//    "//*[contains(normalize-space(.),'code you entered is invalid')]"
//);
//
//try {
//    new WebDriverWait(driver, Duration.ofSeconds(5))
//            .until(ExpectedConditions.visibilityOfElementLocated(invalidCodeMessage));
//
//    throw new RuntimeException(
//        "Server rejected the OTP. Check the latest email code."
//    );
//
//} catch (org.openqa.selenium.TimeoutException e) {
//    System.out.println(
//        "Invalid OTP message not detected. Verify whether login succeeded."
//    );
//}
////wait2.until(ExpectedConditions.elementToBeClickable(codeContinuebtn));
////codeContinuebtn.click();
//
//
//} else {
//    webdriverUtility.click(prestLoginBtn);
//
//	wait1.until(ExpectedConditions.elementToBeClickable(presitEmailTxtbox));
//	presitEmailTxtbox.clear();
//	presitEmailTxtbox.sendKeys(email);
//	wait1.until(ExpectedConditions.elementToBeClickable(PresitPasswordTextbox));
//	PresitPasswordTextbox.clear();
//	PresitPasswordTextbox.sendKeys(password);
//	webdriverUtility.click(PresItUserLoginbtn);
//	
//}
//}	
//
//
//
//
//
//
//
//
////		   
////	    public void clickLogin() throws Throwable {
////
////		String url = ConfigReader.getproperty("url");
////
////		
////                if (url.contains("uat")) {
////                     SignIn();
////					   Login();
////
////               }                 else {
////                    Login();   
////
////
////
////		
////}
////
////		}
//		public void clickLogin(String role) throws Throwable {
//
//		    String url = ConfigReader.getproperty("url");
//
//		    if (url.contains("uat")) {
//		        SignIn();
//		        Login(role);
//		    } else {
//		        Login(role);
//		    }
//		}
//	    
//	    private String getRoleProperty(String role, String type) {
//
//	        String prefix;
//
//	        switch (role.trim().toLowerCase()) {
//
//	            case "admin":
//	                prefix = "admin";
//	                break;
//
//	            case "ta":
//	                prefix = "ta";
//	                break;
//
//	            case "employee":
//	                prefix = "employee";
//	                break;
//
//	            default:
//	                throw new IllegalArgumentException(
//	                        "Invalid LoginRole: " + role);
//	        }
//
//	        String value = ConfigReader.getproperty(prefix + type);
//
//	        if (value == null || value.trim().isEmpty()) {
//	            throw new IllegalStateException(
//	                    "Missing property: " + prefix + type);
//	        }
//
//	        return value.trim();
//	    }
//	}
//		

package credentialPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import reports.ExtentTestManager;
import utilities.ConfigReader;
import utilities.WebdriverUtility;

public class LoginPage extends BasePage {

    private WebdriverUtility webdriverUtility;

    public LoginPage(WebDriver driver) {
        super(driver);
        webdriverUtility = new WebdriverUtility(driver);
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement prestLoginBtn;

    @FindBy(xpath = "//a[@role='button' and normalize-space()='Login']")
    private WebElement uatLoginBtn;

    @FindBy(xpath = "//div[@role='heading' and contains(.,'Enter password')]")
    private WebElement Passwordheading;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement presitEmailTxtbox;

    @FindBy(id = "username")
    private WebElement UatEmailTxtbox;

    @FindBy(xpath = "//input[@class='form-control ltr_override input ext-input text-box ext-text-box']")
    private WebElement SignInEmailtxtbox;

    @FindBy(xpath = "//input[@class='form-control input ext-input text-box ext-text-box show-reveal-password ext-show-reveal-password']")
    private WebElement SignInpasswordtxtbox;

    @FindBy(xpath = "//input[@id='mat-input-1']")
    private WebElement PresitPasswordTextbox;

    @FindBy(xpath = "//input[@name='password' and @type='password']")
    private WebElement UatPasswordTextbox;

    @FindBy(xpath = "//button[@class='c0bc5f06e ce04d888b cfe5b89c1 cd009d33f _button-login-id' and contains(.,'Continue')]")
    private WebElement emailContinuebtn;

    @FindBy(xpath = "//button[@class='c0bc5f06e ce04d888b cfe5b89c1 cd009d33f _button-login-password' and contains(.,'Continue')]")
    private WebElement PasswordContinuebtn;

    @FindBy(xpath = "//button[@type='submit' and text()='Continue']")
    private WebElement codeContinuebtn;

    @FindBy(xpath = "//button[@type='submit' and contains(@class,'button--primary-large') and .//span[normalize-space()='Login']]")
    private WebElement PresItUserLoginbtn;

    @FindBy(xpath = "//button[contains(@class,'mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable') and contains(normalize-space(.),'Accept')]")
    private WebElement AcceptCookieBtn;


    // Select credentials according to Excel LoginRole
    private String getRoleProperty(String role, String type) {

        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "LoginRole is empty in Excel.");
        }

        String prefix;

        switch (role.trim().toLowerCase()) {

            case "admin":
                prefix = "admin";
                break;

            case "ta":
                prefix = "ta";
                break;

            case "employee":
                prefix = "employee";
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid LoginRole: " + role);
        }

        String propertyKey = prefix + type;
        String value = ConfigReader.getproperty(propertyKey);

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException(
                    "Missing property: " + propertyKey);
        }

        return value.trim();
    }


    // Existing SSO sign-in
    private void SignIn() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        By signInHeading = By.xpath(
                "//div[@role='heading' and normalize-space()='Sign in']");

        By nextBtn = By.xpath("//input[@id='idSIButton9']");

        By passwordHeading = By.xpath(
                "//div[@role='heading' and contains(.,'Enter password')]");

        if (!driver.findElements(signInHeading).isEmpty()) {

            String signInMail =
                    ConfigReader.getproperty("signEmail");

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@class='form-control ltr_override input ext-input text-box ext-text-box']")));

            SignInEmailtxtbox.clear();
            SignInEmailtxtbox.sendKeys(signInMail);

            webdriverUtility.click(nextBtn);
        }

        if (!driver.findElements(passwordHeading).isEmpty()
                || !driver.findElements(By.xpath(
                    "//input[@class='form-control input ext-input text-box ext-text-box show-reveal-password ext-show-reveal-password']"
                )).isEmpty()) {

            wait.until(ExpectedConditions.visibilityOf(
                    SignInpasswordtxtbox));

            String signInPassword =
                    ConfigReader.getproperty("signPassword");

            SignInpasswordtxtbox.clear();
            SignInpasswordtxtbox.sendKeys(signInPassword);

            webdriverUtility.click(nextBtn);
        }
    }


    // Login according to role
    public void Login(String role) throws Throwable {

        WebDriverWait wait1 =
                new WebDriverWait(driver, Duration.ofSeconds(50));

        String url = ConfigReader.getproperty("url");
        
    

        String email = getRoleProperty(role, "Email");
        
        String password = getRoleProperty(role, "Password");
        
        ExtentTestManager.getTest().info(
                "Application URL : " + url
        );

        ExtentTestManager.getTest().info(
                "Login Role : " + role
        );

        ExtentTestManager.getTest().info(
                "Login Email : " + email
        );

        System.out.println("Login role: " + role);
        System.out.println("Login email: " + email);

        // UAT login
        if (url.toLowerCase().contains("uat")) {

            wait1.until(ExpectedConditions.elementToBeClickable(
                    uatLoginBtn));

            webdriverUtility.click(uatLoginBtn);

            wait1.until(ExpectedConditions.elementToBeClickable(
                    UatEmailTxtbox));

            UatEmailTxtbox.clear();
            UatEmailTxtbox.sendKeys(email);

            webdriverUtility.click(emailContinuebtn);

            wait1.until(ExpectedConditions.elementToBeClickable(
                    UatPasswordTextbox));

            UatPasswordTextbox.clear();
            UatPasswordTextbox.sendKeys(password);

            webdriverUtility.click(PasswordContinuebtn);

            // Wait for the OTP Continue control.
            // This does not enter an OTP automatically.
            By continueLocator = By.xpath(
                    "//button[@type='submit' and @name='action' "
                    + "and normalize-space(.)='Continue']");

            WebDriverWait otpWait =
                    new WebDriverWait(driver, Duration.ofSeconds(300));

            otpWait.until(ExpectedConditions.elementToBeClickable(
                    continueLocator));

            System.out.println(
                    "OTP Continue button is available.");

            By invalidCodeMessage = By.xpath(
                    "//*[contains(normalize-space(.),"
                    + "'code you entered is invalid')]");

            try {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOfElementLocated(
                                invalidCodeMessage));

                throw new RuntimeException(
                        "Server rejected the OTP. Check the latest code.");

            } catch (TimeoutException e) {
                System.out.println(
                        "Invalid OTP message not detected. "
                        + "Verify login status.");
            }

        } else {

            // Presit login
            wait1.until(ExpectedConditions.elementToBeClickable(
                    prestLoginBtn));

            webdriverUtility.click(prestLoginBtn);

            wait1.until(ExpectedConditions.elementToBeClickable(
                    presitEmailTxtbox));

            presitEmailTxtbox.clear();
            presitEmailTxtbox.sendKeys(email);

            wait1.until(ExpectedConditions.elementToBeClickable(
                    PresitPasswordTextbox));

            PresitPasswordTextbox.clear();
            PresitPasswordTextbox.sendKeys(password);

            webdriverUtility.click(PresItUserLoginbtn);
        }
    }


    // Public entry point
    public void clickLogin(String role) throws Throwable {

        String url = ConfigReader.getproperty("url");

        if (url != null && url.toLowerCase().contains("uat")) {
            SignIn();
        }

        Login(role);
    }
}
	    	
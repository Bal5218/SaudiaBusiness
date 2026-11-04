package credentialPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;


import base.BasePage;

import utilities.ConfigReader;
import utilities.WebdriverUtility;

public class LoginPage extends BasePage{

	
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


		 @FindBy(xpath = "//input[@class='input caa71d818 c7db392d1' and @id='username']")
	    private WebElement UatEmailTxtbox;

	    @FindBy(xpath = "//input[@class='form-control ltr_override input ext-input text-box ext-text-box']")
	    private WebElement SignInEmailtxtbox;

		@FindBy(xpath = "//input[@class='form-control input ext-input text-box ext-text-box show-reveal-password ext-show-reveal-password']")
	    private WebElement SignInpasswordtxtbox;

	    @FindBy(xpath="//input[@id='mat-input-1']")
	    private WebElement PresitPasswordTextbox;

		@FindBy(xpath="//div[@class='c5cdc91ba c00b2e702 password ca9325ae5 ulp-field c384c12f1'and contains(.,'Password ')]")
	    private WebElement UatPasswordTextbox;

		 @FindBy(xpath="//button[@class='c3e773acf cc4752a31 cbf1ac32b c0686068e _button-login-id' and contains(.,'Continue')]")
	    private WebElement Continuebtn;
	
	
		 @FindBy(xpath = "//button[@type='submit' and contains(@class,'button--primary-large') and .//span[normalize-space()='Login']]")
		    private WebElement PresItUserLoginbtn;
		 
		 @FindBy(xpath = "//button[contains(@class,'mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable') and contains(normalize-space(.),'Accept')]")
                  private WebElement AcceptCookieBtn;
		 
		  private void SignIn() {
		
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
By signInHeading = By.xpath("//div[@role='heading' and normalize-space()='Sign in']");
By Nextbtn = By.xpath("//input[@id='idSIButton9']");
    By passwordHeading = By.xpath("//div[@role='heading' and contains(.,'Enter password')]");



if (!driver.findElements(signInHeading).isEmpty()) {

webdriverUtility.waitForVisibility(SignInEmailtxtbox);



String signInmail=ConfigReader.getproperty("signEmail"); 


                    SignInEmailtxtbox.clear();

                SignInEmailtxtbox.sendKeys(signInmail);

				webdriverUtility.click(Nextbtn);
			
}
if (!driver.findElements(passwordHeading).isEmpty()||SignInpasswordtxtbox.isDisplayed()){
	webdriverUtility.waitForVisibility(SignInpasswordtxtbox);

String signInpassword=ConfigReader.getproperty("signPassword"); 

SignInpasswordtxtbox.clear();

SignInpasswordtxtbox.sendKeys(signInpassword);

webdriverUtility.click(Nextbtn);




}
		  }

		public void Login(){

WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
			
		String url = ConfigReader.getproperty("url");
		String email = ConfigReader.getproperty("Email");
		String password = ConfigReader.getproperty("Password");
		
		

if (url.contains("uat")) {
wait1.until(ExpectedConditions.elementToBeClickable(uatLoginBtn));
    webdriverUtility.click(uatLoginBtn);
wait1.until(ExpectedConditions.elementToBeClickable(UatEmailTxtbox));
UatEmailTxtbox.clear();
UatEmailTxtbox.sendKeys(email);

webdriverUtility.click(Continuebtn);
wait1.until(ExpectedConditions.elementToBeClickable(UatPasswordTextbox));
UatPasswordTextbox.clear();
UatPasswordTextbox.sendKeys(password);
webdriverUtility.click(Continuebtn);

} else {
    webdriverUtility.click(prestLoginBtn);

	wait1.until(ExpectedConditions.elementToBeClickable(presitEmailTxtbox));
	presitEmailTxtbox.clear();
	presitEmailTxtbox.sendKeys(email);
	wait1.until(ExpectedConditions.elementToBeClickable(PresitPasswordTextbox));
	PresitPasswordTextbox.clear();
	PresitPasswordTextbox.sendKeys(password);
	webdriverUtility.click(PresItUserLoginbtn);
	
}
}	








		   
	    public void clickLogin() throws Throwable {

		String url = ConfigReader.getproperty("url");

		
                if (url.contains("uat")) {
                     SignIn();
					   Login();

               }                 else {
                    Login();   



		
}

		}
	}
		
		    	
package credentialPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import reports.ReportUtil;
import utilities.ConfigReader;
import utilities.WebdriverUtility;

public class LoginPage extends BasePage{

	
	private WebdriverUtility webdriverUtility;

	public LoginPage(WebDriver driver) {
		super(driver);
		 webdriverUtility = new WebdriverUtility(driver);
		
	}
	
	 @FindBy(xpath = "//a[@href='/login']")
	    private WebElement LoginLink;

	    @FindBy(xpath = "//input[@formcontrolname='email']")
	    private WebElement EmailTxtbox;

	    @FindBy(xpath="//input[@id='mat-input-1']")
	    private WebElement PasswordTextbox;
	
	
		 @FindBy(xpath = "//button[@type='submit' and contains(@class,'button--primary-large') and .//span[normalize-space()='Login']]")
		    private WebElement Loginbtn;
		 
		 
		 
		  private void enterUsername() {
		

		        webdriverUtility.waitForVisibility(EmailTxtbox);

		        String email = ConfigReader.getproperty("Email");

		        System.out.println("Email : " + email);

		        EmailTxtbox.clear();
		        EmailTxtbox.sendKeys(email);
		    }


		    private void enterPassword() {

		        webdriverUtility.waitForVisibility(PasswordTextbox);

		        String password = ConfigReader.getproperty("Password");

		        System.out.println("Password : " + password);

		        PasswordTextbox.clear();
		        PasswordTextbox.sendKeys(password);
		    }


		    public void clickLogin() throws Throwable {
		    	
		    	  webdriverUtility.click(LoginLink);
				 
		Thread.sleep(3000);

		        enterUsername();
		Thread.sleep(5000);
		        enterPassword();

		        webdriverUtility.waitForVisibility(Loginbtn);
		        
		        
		        Thread.sleep(6000);



		        
		        webdriverUtility.click(Loginbtn);
		     
		        
		        ReportUtil.logPage("Login Page");
		    }
}
		

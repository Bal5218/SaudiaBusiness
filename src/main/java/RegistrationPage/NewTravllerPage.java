package RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import modeles.CompanyprofileData;
import reports.ReportUtil;
import utilities.ConfigReader;
import utilities.TestDataGenerator;
import utilities.WebdriverUtility;

public class NewTravllerPage extends BasePage {
	
	private WebdriverUtility webdriverutility;
	
	public NewTravllerPage(WebDriver driver) {
		
		super(driver);
		
		webdriverutility=new WebdriverUtility(driver);
	}

	@FindBy(xpath = "//button[contains(@class,'menu-label') and normalize-space()='GTM CORPORATE']")
	private WebElement GTMCorporatebtn;

	@FindBy(xpath = "(//a[contains(.,'Travelers')])[1]")
	private WebElement TravelersLink;
	
	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement AddTravellerbtn;
	
//	
//	@FindBy(xpath = "//span[contains(.,' Add traveler ')]")
//	private WebElement AdddTRavelerBtn;
//	
	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--secondary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement UploadBulkTravellersBtn;
	
	@FindBy(xpath = "//ng-select[@formcontrolname='Nationality']")
	private WebElement NationalityDropdown;
	
	@FindBy(xpath = "//input[@formcontrolname='dateOfBirth']")
	private WebElement DOBCalender;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='title']")
	private WebElement titleDropdown;
	
	@FindBy(xpath = "//ng-select[@formcontrolname='residence']")
	private WebElement PlaceOfResidenceDropdown;
	
	@FindBy(xpath = "//input[@formcontrolname='identityNumber']")
	private WebElement PassportTextBox;
	

	@FindBy(xpath = "//input[@formcontrolname='docExpiary']")
	private WebElement PassportExpirydateTextBox;
	
	@FindBy(xpath = "//input[@formcontrolname='firstname']")
	private WebElement FirstNameTextbox;
	
	@FindBy(xpath = "//input[@formcontrolname='lastname']")
	private WebElement LastNameTextbox;
	
	@FindBy(xpath = "//mat-radio-group[@formcontrolname='gender']")
	private WebElement genderRadioGroup;
	
	@FindBy(xpath = "//input[@formcontrolname='empCode']")
	private WebElement EmployeeNumberTextbox;
	
	@FindBy(xpath = "//input[@formcontrolname='email']")
	private WebElement EmailTextBox;
	
	
	@FindBy(xpath = "//ng-select[@formcontrolname='countryCode']")
	private WebElement countryCodeDropdown;
	
	
	@FindBy(xpath = "//input[@formcontrolname='mobileNumber']")
	private WebElement mobileNumberTxtbox;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='department']")
	private WebElement departmentDropdown;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='branch']")
	private WebElement OfficeLocationDropdwn;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='designation']")
	private WebElement DesignationDropdwn;
	
	@FindBy(xpath = "//mat-radio-group[@formcontrolname='userType']")
	private WebElement UserTypeRadiobtn;
	
	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement acceptCookieBtn;
	
	
	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small d-flex align-items-center justify-content-center gap-2 mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement SendInvitebtn;
	
	
//	@FindBy(xpath = "//mat-form-field[@class='mat-mdc-form-field mat-mdc-form-field-type-mat-input mat-mdc-form-field-has-icon-suffix mat-form-field-appearance-fill mat-primary ng-pristine ng-invalid mat-form-field-invalid ng-touched mat-form-field-hide-placeholder']")
//	private WebElement Email_textbox;
	
	@FindBy(xpath = "//input[@formcontrolname='emailAddress']")
	private WebElement Email_textbox;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement PasswordTxtbox;
	
	@FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
	private WebElement confirmPasswordTxtbox;
	
	@FindBy(xpath = "//mat-checkbox[@formcontrolname='acceptTerms']")
	private WebElement AcceptChkbox;

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='agreeConcent']")
	private WebElement Agreechkbox;
	
	@FindBy(xpath = "//mat-checkbox[@formcontrolname='acceptPrivacy']")
	private WebElement Offerchkbox;

	
	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-large mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement GenrateToken;
	
	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement Savebtn;
	
	@FindBy(xpath = "//h4[contains(.,' Profile successfully created!')]")
	private WebElement Profielselectedtxt;
	

	@FindBy(xpath = "(//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable'])[2]")
	private WebElement ThisIsmeText;

	public void AddTraveller(CompanyprofileData data) throws Throwable {
	
		
		
		webdriverutility.click(GTMCorporatebtn);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		   wait.until(ExpectedConditions.elementToBeClickable(TravelersLink));
		    webdriverutility.click(TravelersLink);
		
		wait.until(ExpectedConditions.elementToBeClickable(AddTravellerbtn));
		
		  webdriverutility.click(AddTravellerbtn);
		
		Thread.sleep(3000);
		
		webdriverutility.selectNgOptionByVisibleText(NationalityDropdown, data.getNationality().trim());
		
		
		webdriverutility.selectNgOptionByVisibleText(PlaceOfResidenceDropdown, data.getPlaceofResidence().trim());
		
		webdriverutility.click(acceptCookieBtn);
		
		webdriverutility.selectDOBDate(DOBCalender,data.getDOB().trim());
		
		webdriverutility.sendKeys(PassportTextBox,data.getPassport());
		
		webdriverutility.selectPassportExpiryDate(PassportExpirydateTextBox, data.getPassportExpiryDate().trim());
		
		
		webdriverutility.selectMatOptionByVisibleText(titleDropdown, data.getTitle().trim());
		
		String FirstName = TestDataGenerator.generateFirstName(
			    data.getFirstName().trim()
			);
	
	
		webdriverutility.sendKeys(FirstNameTextbox, FirstName);
		System.out.println(FirstName);
		ReportUtil.logPass(FirstName);
		
		webdriverutility.sendKeys(LastNameTextbox, data.getLastname().trim());
		

		selectGender(data);

		String EmployeeNumber = TestDataGenerator.generateEmployeeNumber(
			    data.getEmployeeNumber().trim()
			);
	
		webdriverutility.sendKeys(EmployeeNumberTextbox, EmployeeNumber);
		
		String email = TestDataGenerator.generateEmail(
			    data.getEmail().trim()
			);
	
		webdriverutility.sendKeys(EmailTextBox, email);
		Thread.sleep(3000);
		webdriverutility.selectNgOptionByVisibleText(countryCodeDropdown, data.getcountrycode().trim());
		
		webdriverutility.sendKeys(mobileNumberTxtbox, data.getMobileNo().trim());
		
		webdriverutility.selectMatOptionByVisibleText(OfficeLocationDropdwn, data.getOffice_Location_Name().trim());
		
		Thread.sleep(3000);
		
		webdriverutility.selectMatOptionByVisibleText(departmentDropdown, data.getDepartment_Name().trim());
		
		webdriverutility.selectMatOptionByVisibleText(DesignationDropdwn, data.getDesignation().trim());
		
		Thread.sleep(5000);
		
	
		
		selectUserType(data);	
		
		ReportUtil.logPass("All data eneterd");
		webdriverutility.click(SendInvitebtn);
		
		Thread.sleep(4000);
		String url=ConfigReader.getproperty("url1");
		
		driver.get(url);
		
		ReportUtil.logPass("Generate token page open");
		Thread.sleep(3000);
		
		webdriverutility.sendKeys(Email_textbox, email);
		
		ReportUtil.logPass("email entered to Add traveller ");
		
		webdriverutility.click(GenrateToken);
		
		Thread.sleep(3000);
		String password =
		        TestDataGenerator.generatePassword(   data.getPassword().trim());
		             
		       

		System.out.println("Generated Password : " + password);

		webdriverutility.sendKeys(PasswordTxtbox, password);
		       
		webdriverutility.sendKeys(confirmPasswordTxtbox, password);
		
	
		webdriverutility.click(AcceptChkbox);
	
		webdriverutility.click(Agreechkbox);
		
		webdriverutility.click(Offerchkbox);
		
		

		webdriverutility.click(Savebtn);
		
		ReportUtil.logPass("profile successfully submitted");
		
		webdriverutility.click(ThisIsmeText);
			
			
			
		}
	
	public void selectGender(CompanyprofileData data) {

	    String gender = data.getGender().trim();

	    WebElement genderOption = genderRadioGroup.findElement(
	        By.xpath(".//mat-radio-button[@value='" + gender + "']")
	    );

	    genderOption.click();
	}
	public void selectUserType(CompanyprofileData data) {

	    String User = data.getUserType().trim();

	    WebElement UserOption = UserTypeRadiobtn.findElement(
	        By.xpath(".//mat-radio-button[.//label[normalize-space()='" 
	                + User + "']]")
	    );

	    UserOption.click();
	}
	}
		
		
		
		
		
	
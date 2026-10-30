package RegistrationPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import modeles.CompanyprofileData;
import reports.ReportUtil;
import utilities.TestDataGenerator;
import utilities.WebdriverUtility;
import org.testng.Assert;
public class CompnayProfilepage extends BasePage {

	private WebdriverUtility webdriverutility;

	public CompnayProfilepage(WebDriver driver) {
		super(driver);
		webdriverutility = new WebdriverUtility(driver);
	}

	@FindBy(xpath = "//li[@fragment='corporate']//button[contains(@class,'menu-label')]")
	private WebElement GtmcorporateBtn;

	@FindBy(xpath = "//a[@href='/cam/company-management/company-details']")
	private WebElement CompanyProfileLink;

	@FindBy(xpath = "//button[@class='button-as-span link']")
	private WebElement EditLink;
	
	@FindBy(xpath = "(//mat-icon[normalize-space()='delete'])[1]")
	private WebElement DeleteLink;

	@FindBy(xpath = "//input[@formcontrolname='companyName']")
	private WebElement CompanyTextBox;

	@FindBy(xpath = "//mat-select[@formcontrolname='natureofBusiness']")
	private WebElement IndustryDropdown;

	@FindBy(xpath = "//input[@formcontrolname='registrationID']")
	private WebElement resgistrationIdTxtbox;

	@FindBy(xpath = "//input[@formcontrolname='taxNo']")
	private WebElement TaxidentificationNumberTxtbox;

	@FindBy(xpath = "//ng-select[@formcontrolname='countryName']")
	private WebElement countryDropdown;

	@FindBy(xpath = "//input[@id='mat-input-14']")
	private WebElement DistrictTextBox;

	@FindBy(xpath = "//ng-select[@formcontrolname='cityName']")
	private WebElement cityDropdown;

	@FindBy(xpath = "//input[@id='mat-input-15']")
	private WebElement postalcodeTextbox;

	@FindBy(xpath = "//input[@id='mat-input-16']")
	private WebElement BuildingNumberTextbox;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	private WebElement StreetAdressTextbox;

	@FindBy(xpath = "//input[@formcontrolname='emailAddress']")
	private WebElement EmailAdressTextbox;

	@FindBy(xpath = "//ng-select[@formcontrolname='countryCode']")
	private WebElement CountrycodeDropdown;

	@FindBy(xpath = "//input[@formcontrolname='mobileNo']")
	private WebElement MobilenoTextbox;

	@FindBy(xpath = "//mat-select[@id='mat-select-1']")
	private WebElement LanguageDropdown;

	@FindBy(xpath = "//mat-select[@id='mat-select-2']")
	private WebElement Number_Of_EmployeesDropdwn;

	@FindBy(xpath = "//div[@id='mat-select-value-3']")
	private WebElement Estimated_TravelBudgetDrpdown;

	@FindBy(xpath = "//button[.//span[normalize-space()='Save changes']]")
	private WebElement Savechangesbtn;

	@FindBy(xpath = "//button[.//span[normalize-space()='Accept']]")
	private WebElement acceptCookieButton;

	@FindBy(xpath = "//*[contains(normalize-space(),'Company profile details updated successfully')]")
	private WebElement CompanyProfileSuccessMsg;

	// office Location

	@FindBy(xpath = "//button[contains(@class,'custom-tree-child') and normalize-space()='Office location information']")
	private WebElement OfficeLocation;

	@FindBy(xpath = "//a[.//mat-icon[normalize-space()='add'] and contains(normalize-space(), 'Add new')]")
	private WebElement AdNewbutton;

	@FindBy(xpath = "(//mat-icon[normalize-space()='delete'])[1]")
	private WebElement Deletebtn;
	@FindBy(xpath = "//button[.//span[normalize-space()='Confirm']]")
	private WebElement Confrmbtn;

	@FindBy(xpath = "//a[@class='onclick-cell primary-link']")
	private WebElement subEditLink;

	@FindBy(xpath = "//div[@class='mdc-form-field mat-internal-form-field' ]//input[@id='mat-radio-2-input']")
	private WebElement ActiveRadiobtn;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Corporate Office location Name']]//input")
	private WebElement Corporate_Office_LocationName;

	@FindBy(xpath = "//input[@formcontrolname='branchCode']")
	private WebElement OfficeLocationCodeTxtbox;

	@FindBy(xpath = "//input[@formcontrolname='branchEmailAddress']")
	private WebElement OfficeEmailAddressTxtbox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Street Address']]//input")
	private WebElement StreetAddress;
	
	@FindBy(xpath = "//*[contains(.,'Office location updated successfully.')]")
	private WebElement OfficeLocationUpdatedMsg;

	@FindBy(xpath = "//*[contains(.,'Office location deleted successfully')]")
	private WebElement OfficeLocationDeletedMsg;
//	    @FindBy(xpath="//ng-select[@formcontrolname='countryRegion']")
//	    private WebElement CountryRegionDropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='countryRegion']")
	private WebElement CountryRegionDropdown;

	@FindBy(xpath = "//ng-select[@bindvalue='cityName']")
	private WebElement OfficeLocationCityDropdown;

	@FindBy(xpath = "//mat-form-field[.//mat-label[contains(normalize-space(),'Postal Code')]]//input")
	private WebElement OfficeLocationPostalCode;

	@FindBy(xpath = "//mat-form-field[.//mat-label[contains(normalize-space(),'Phone')]]//input")
	private WebElement PhoneNumberTextBox;

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small no-focus mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement Savebtn;

	@FindBy(xpath = "//div[contains(normalize-space(),'Office location information has been saved successfully')]")
	private WebElement OfficeLocationSuccessMsg;
	
	@FindBy(xpath = "//*[contains(.,'Office location cannot be deleted. Users are still assigned to this branch.')]")
	private WebElement DeleteRestrictionMsg;

	// Cost Centre overview

	@FindBy(xpath = "//button[contains(@class,'custom-tree-child') and normalize-space()='Cost center overview']")
	private WebElement Cost_Centre_Overview;
	
	
//	    @FindBy(xpath="//a[@class='link' and contains(.,'Add new')]")
//	    private WebElement AddNewLink;
//	    
	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Cost Center Name']]//input")
	private WebElement Cost_Centre_Name_TxtBox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Cost Center Code']]//input")
	private WebElement Cost_Centre_Code_TxtBox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Associate with Office location']]//div[contains(@class,'mat-mdc-text-field-wrapper')]")
	private WebElement Associate_with_Office_location_Dropdown;

	@FindBy(xpath = "//mat-checkbox[@id='mat-mdc-checkbox-1']")
	private WebElement Chkbox;

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement SavebtnForAll;

	@FindBy(xpath = "//div[contains(normalize-space(),'Cost center added successfully')]")
	private WebElement CostCenterSuccessMsg;
	
	@FindBy(xpath = "//*[normalize-space(text())='Cost center updated successfully.']")
	private WebElement CostCenterUpdatedMsg;

	// project Details

	@FindBy(xpath = "//button[.//div[normalize-space()='Project details' or normalize-space()='Projects']]")
	private WebElement Project_DetailsBtn;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Project name']]//input")
	private WebElement Project_Name_TxtBox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Project code']]//input")
	private WebElement Project_Code_TxtBox;

	@FindBy(xpath = "//*[contains(normalize-space(),'Project details added successfully')]")
	private WebElement ProjectSuccessMsg;

	@FindBy(xpath = "//*[contains(normalize-space(),'Project details already exist')]")
	private WebElement ProjectAlreadyExistMsg;
	
	@FindBy(xpath = "//*[normalize-space(text())='Project details updated successfully.']")
	private WebElement ProjectUpdatedMsg;
	
	
	@FindBy(xpath = "(//mat-icon[normalize-space()='Delete'])[1]")
	private WebElement ProjectDeletebtn;
	// corporate cards

	@FindBy(xpath = "//button[contains(@class,'custom-tree-child') and normalize-space()='Corporate cards']")
	private WebElement Corporate_cardsBtn;

	@FindBy(xpath = "//mat-icon[text()='Delete']")
	private WebElement DeleteCorporateCardBtn;

	@FindBy(xpath = "//*[normalize-space()='No corporate cards added']")
	private WebElement NoCorporateCardsMsg;

	@FindBy(xpath = "//mat-icon[@aria-label='close button']")
	private WebElement Crossebtn;

	@FindBy(xpath = "//input[@formcontrolname='cardName']")
	private WebElement Card_NickNameTxtBox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Billing option']]")
	private WebElement Billing_optn_dropdown;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Card brand']]")
	private WebElement Card_Brand_Dropdown;

	@FindBy(xpath = "//input[@formcontrolname='cardHolderName']")
	private WebElement CradHolder_NameTxtbox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Card number']]//input")
	private WebElement Crad_Number_Txtbox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Expiry month']]")
	private WebElement Expiry_Month_Dropdwn;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Expiry year']]")
	private WebElement Expiry_Year_Dropdwn;

	@FindBy(xpath = "//mat-radio-button[.//label[normalize-space()='Physical Card']]")
	private WebElement Physical_card_Radiobtn;

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='islodge']")
	private WebElement Lodge_Chk_Box;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Rule applied on']]")
	private WebElement Ruled_Applied_Dropdown;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Product']]")
	private WebElement Product_Dropdown;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Select Corporate(s)']]")
	private WebElement Select_corporate_Dropdown;
	
	@FindBy(xpath = "//li[@fragment='corporate']//button[contains(@class,'menu-label')]")
	private WebElement CorporateCheckbox;


	@FindBy(xpath = "//button[contains(@class,'custom-tree-child') and contains(normalize-space(), 'Business unit')]")
	private WebElement Business_Unit_Overviewbtn;

	@FindBy(xpath = "//a[@class='link' and contains(.,'Add new')]")
	private WebElement AddNewLink;
	
	

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Business unit code']]//input")
	private WebElement Businessunit_code;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Business unit name']]//input")
	private WebElement Business_Unit_name;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Business unit manager']]//input")
	private WebElement Business_unit_Manager;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Business unit email']]//input")
	private WebElement Business_unit_mail;

	@FindBy(xpath = "//input[@formcontrolname='businessUnitContactNo']")
	private WebElement Business_unit_ContactNumber;
	
	@FindBy(xpath = "(//button[@class='onclick-cell primary-link button-as-span'])[1]")
	private WebElement BusinessUnitEdit;


	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Associate with Office location']]")
	private WebElement Associate_with_officeLocation_dropdown;

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small button--primary-small-custom-width mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement Corporate_cardConfirm;
	
	@FindBy(xpath = "//div[contains(normalize-space(),'Corporate card has been saved successfully')]")
	private WebElement CorporatecardSuccessMsg;
	
	@FindBy(xpath = "//div[contains(normalize-space(),'Corporatecard Already Exist')]")
	private WebElement CorporatecardAlreadyExistmsg;

	private String registrationId;
	private String taxId;
	private String postalCode;
	private String buildingNumber;
	public static String email;
	private String project;
	private String projectcode;
	private static String officeLocation;
	private String OfficeLocationCode;
	private String costCenterName;
	private String costCenterCode;
	public static  String CategoryCode;
	public static String CategoryName;
	public static String TripType;
	public static  String TravelCategory;
	private String BusinessUnitname;
	private String BusinessUnitcode;


	public void companyProfiledetails(CompanyprofileData data) throws Throwable {

		// Generate dynamic data
//		registrationId = TestDataGenerator.generateCompanyRegistrationId();
//
//		taxId = TestDataGenerator.generateTaxIdentificationNumberNumeric();
//
//		buildingNumber = TestDataGenerator.generateBuildingNumber();
//
//		email = TestDataGenerator.generateCompanyEmail();
//
//		project = TestDataGenerator.generateProjectName(data.getProject_Name().trim());
//
//		projectcode = TestDataGenerator.generateProjectCode(data.getProject_Code().trim());
//
//		officeLocation = TestDataGenerator.generateOfficeLocation(data.getOffice_Location_Name().trim());
//
//		OfficeLocationCode = TestDataGenerator.generateOfficeLocationcode(data.getOffice_Location_Code().trim());
//
//		costCenterName = TestDataGenerator.generateCostCenterName(data.getCost_Center_Name().trim());
//
//		costCenterCode = TestDataGenerator.generateCostCenterCode(data.getCost_Center_Code().trim());
//		CategoryCode= TestDataGenerator.generateCategoryCode(data.getCategoryCode().trim());
//		
//	
//		BusinessUnitname=  TestDataGenerator.generateUniqueBusinessUnitName(data.getBusiness_Unit_name().trim());
//		
//		BusinessUnitcode= TestDataGenerator.generateBusinessunit_code(data.getBusinessunit_code().trim());
//		
//		
//		CategoryName= TestDataGenerator.generateCategoryName(data.getCategoryCode().trim());
//		TripType=data.getTripType();
//		 TravelCategory=TestDataGenerator.generateTravelCategory(data.getTravelCategory()).trim();

		// CompanyDetails(data);
		  

	Enterdetails(data);

		//OfficeLocation(data);
//	fillCostoverView(data);
//	EnterprojectDetails(data);
//	CorporateCards(data);
//		BusinessUnitOverviewDetails(data);
//
//		TravelProfilingPage TravelProfilingPage = new TravelProfilingPage(driver);
//	TravelProfilingPage.DepartmentDetails(data, CategoryName,CategoryCode,officeLocation,TripType,TravelCategory);
//		
		
//	NewTravllerPage NewTravllerPage=new NewTravllerPage(driver);
//		
//	NewTravllerPage.AddTraveller(data, officeLocation);

	}

	public void Enterdetails(CompanyprofileData data) throws Throwable {
		   prepareTestData(data);
		   
		   
		   
		webdriverutility.click(GtmcorporateBtn);
		Thread.sleep(3000);

		webdriverutility.click(CompanyProfileLink);
		Thread.sleep(3000);

		// Close cookie banner
		try {
			if (acceptCookieButton.isDisplayed()) {
				webdriverutility.click(acceptCookieButton);
			}
		} catch (Exception e) {
			System.out.println("Cookie banner is not displayed.");
		}


		webdriverutility.click(EditLink);

		//webdriverutility.sendKeys(CompanyTextBox, data.getCompany_Name().trim());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(IndustryDropdown, data.getIndustry().trim());

//		Thread.sleep(3000);

	//	webdriverutility.sendKeys(resgistrationIdTxtbox, registrationId);

//		Thread.sleep(3000);

//		webdriverutility.sendKeys(TaxidentificationNumberTxtbox, taxId);

		Thread.sleep(3000);

		webdriverutility.selectNgOptionByVisibleText(countryDropdown, data.getCountry());

		Thread.sleep(3000);

		webdriverutility.sendKeys(DistrictTextBox, data.getDistrict());

		Thread.sleep(3000);

		webdriverutility.selectNgOptionByVisibleText(cityDropdown, data.getCity());

		Thread.sleep(3000);

		webdriverutility.sendKeys(postalcodeTextbox, data.getPostalCode().trim());

		Thread.sleep(3000);

		webdriverutility.sendKeys(BuildingNumberTextbox, buildingNumber);
		

		Thread.sleep(3000);

		webdriverutility.sendKeys(StreetAdressTextbox, data.getStreet_address());

		Thread.sleep(3000);

		webdriverutility.sendKeys(EmailAdressTextbox, email);

		Thread.sleep(3000);

		webdriverutility.selectNgOptionByVisibleText(CountrycodeDropdown, data.getcountrycode());

		Thread.sleep(3000);

		webdriverutility.sendKeys(MobilenoTextbox, data.getMobileNo());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(LanguageDropdown, data.getLanguage().trim());

		webdriverutility.selectMatOptionByVisibleText(Number_Of_EmployeesDropdwn, data.getNoOfEmployees());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Estimated_TravelBudgetDrpdown,
				data.getEstimated_Annual_TravelBudget());
		ReportUtil.logPass("Company details Added");
		Thread.sleep(5000);

		webdriverutility.click(Savechangesbtn);

		Thread.sleep(2000);

		String actualMessage = CompanyProfileSuccessMsg.getText().trim();

		if (actualMessage.contains("Company profile details updated successfully")) {

			ReportUtil.logPass("Validation Passed: ");

		} else {

			ReportUtil.logFail("Validation Failed. Actual message: ");
		}

	}

	public void OfficeLocation(CompanyprofileData data) throws Throwable {
		   prepareTestData(data);
		   officeLocation = TestDataGenerator.generateOfficeLocation(data.getOffice_Location_Name().trim());
		   
		   System.out.println(officeLocation);
	           
	                    
		webdriverutility.click(GtmcorporateBtn);
		Thread.sleep(3000);

		webdriverutility.click(CompanyProfileLink);
		Thread.sleep(3000);

		// Close cookie banner
		try {
			if (acceptCookieButton.isDisplayed()) {
				webdriverutility.click(acceptCookieButton);
			}
		} catch (Exception e) {
			System.out.println("Cookie banner is not displayed.");
		}


		webdriverutility.click(OfficeLocation);

		Thread.sleep(3000);

		String action = data.getOfficeLocationAction().trim();

		if (action.equalsIgnoreCase("Add new")) {

			webdriverutility.click(AdNewbutton);

			Thread.sleep(3000);

			fillOfficeLocationDetails(data);

		} else if (action.equalsIgnoreCase("edit")) {

			webdriverutility.click(subEditLink);
			Thread.sleep(3000);

			fillOfficeLocationDetails(data);
			
			
		}
	 else if (action.equalsIgnoreCase("delete")) {

	    webdriverutility.click(DeleteLink);
	    webdriverutility.click(Confrmbtn);

	    String expectedMessage =
	        "Office location cannot be deleted. Users are still assigned to this branch.";

	    try {
	        Thread.sleep(1000);

	        By deleteErrorMsg = By.xpath(
	            "//*[contains(text(),'Office location cannot be deleted.')]"
	        );

	        WebDriverWait wait = new WebDriverWait(
	            driver, Duration.ofSeconds(10)
	        );

	        wait.until(
	            ExpectedConditions.presenceOfElementLocated(deleteErrorMsg)
	        );

	        List<WebElement> messages = driver.findElements(deleteErrorMsg);

	        boolean messageFound = false;

	        for (WebElement message : messages) {
	            if (message.isDisplayed()
	                    && message.getText().trim().equals(expectedMessage)) {

	                messageFound = true;
	                break;
	            }
	        }

	        Assert.assertTrue(
	            messageFound,
	            "Exact delete restriction message was not found"
	        );

	        System.out.println("PASS: Delete restriction message validated.");
	        ReportUtil.logPass("Delete restriction message validated successfully");

	    } catch (TimeoutException e) {
	        ReportUtil.logFail("Delete restriction message was not displayed");
	        Assert.fail("Expected delete restriction message was not displayed.", e);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        Assert.fail("Thread interrupted while validating delete message.", e);
	    }

	} else {
	    System.out.println("Invalid Office Location action: " + action);
	}


}

	private void fillOfficeLocationDetails(CompanyprofileData data) throws Throwable {
		String action = data.getOfficeLocationAction().trim();

		// Active
		// webdriverutility.click(ActiveRadiobtn);

		Thread.sleep(1000);

		// Office Location Name
		webdriverutility.sendKeys(Corporate_Office_LocationName, officeLocation);
	ReportUtil.logIfNotBlank("officeLocation Name", data.getOffice_Location_Name());

		Thread.sleep(1000);

		webdriverutility.sendKeys(OfficeLocationCodeTxtbox, OfficeLocationCode);
		
		ReportUtil.logIfNotBlank("officeLocation code", data.getOffice_Location_Code());

		// Street Address
		webdriverutility.sendKeys(StreetAddress, data.getStreet_address());

		Thread.sleep(1000);

		// Country
		webdriverutility.selectNgOptionByVisibleText(CountryRegionDropdown, data.getCountry().trim());

		Thread.sleep(1000);

		// City
		webdriverutility.selectNgOptionByVisibleText(OfficeLocationCityDropdown, data.getCity());

		// Phone
		Thread.sleep(1000);
		webdriverutility.sendKeys(PhoneNumberTextBox, data.getPhone_Number());
		ReportUtil.logIfNotBlank("Phone Number", data.getPhone_Number());

		Thread.sleep(1000);
		// Postal Code
		webdriverutility.sendKeys(OfficeLocationPostalCode, data.getOffice_Location_postal_code().trim());
		
		ReportUtil.logIfNotBlank("OfficeLocation Postal Code", data.getOffice_Location_postal_code());

		Thread.sleep(1000);

		webdriverutility.sendKeys(OfficeEmailAddressTxtbox, email);
		
		ReportUtil.logIfNotBlank(" Email", data.getEmail());

		ReportUtil.logPass("Office location details Added");

		Thread.sleep(1000);

		// Save


webdriverutility.click(Savebtn);

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

if (action.equalsIgnoreCase("Add")
        || action.equalsIgnoreCase("Add new")) {

    try {
        WebElement successMsg = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(normalize-space(.),"
                    + "'Office location information has been saved successfully')]")
            )
        );

        String actualMessage = successMsg.getText().trim();

        Assert.assertTrue(
            actualMessage.contains("Office location"),
            "Office location add success message is incorrect. Actual: "
                + actualMessage
        );

        ReportUtil.logIfNotBlank("Office Location Name", officeLocation);
        ReportUtil.logIfNotBlank("Office Location Code", OfficeLocationCode);
        ReportUtil.logIfNotBlank("Street Address", data.getStreet_address());
        ReportUtil.logIfNotBlank("Country", data.getCountry());
        ReportUtil.logIfNotBlank("City", data.getCity());
        ReportUtil.logIfNotBlank("Phone Number", data.getPhone_Number());

        ReportUtil.logIfNotBlank(
            "Postal Code",
            data.getOffice_Location_postal_code()
        );

        ReportUtil.logIfNotBlank("Office Email", email);

        ReportUtil.logPass("Office location added successfully");

    } catch (TimeoutException e) {

        ReportUtil.logFail(
            "Office location add success message not displayed"
        );

        Assert.fail("Office location was not added successfully", e);
    }

} else if (action.equalsIgnoreCase("Edit")) {

    try {
        WebElement successMsg = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(normalize-space(.),"
                    + "'Office location updated successfully')]")
            )
        );

        String actualMessage = successMsg.getText().trim();

        Assert.assertTrue(
            actualMessage.contains("Office location updated successfully"),
            "Office location update message did not match. Actual: "
                + actualMessage
        );

        ReportUtil.logPass("Office location updated successfully");

    } catch (TimeoutException e) {

        ReportUtil.logFail("Office location edit validation failed");

        Assert.fail("Office location was not updated successfully", e);
    }
}
	}




	public void fillCostoverView(CompanyprofileData data) throws Throwable {

	    prepareTestData(data);

	    String action = data.getOfficeLocationAction().trim();

	    if (officeLocation == null || officeLocation.isBlank()) {
	        throw new IllegalStateException(
	            "Office Location name available nahi hai."
	        );
	    }

	    System.out.println("Office Location to associate: " + officeLocation);
	    System.out.println("Cost Center action: [" + action + "]");

	    webdriverutility.click(GtmcorporateBtn);
	    Thread.sleep(2000);

	    webdriverutility.click(CompanyProfileLink);
	    Thread.sleep(2000);

	    try {
	        if (acceptCookieButton.isDisplayed()) {
	            webdriverutility.click(acceptCookieButton);
	        }
	    } catch (Exception e) {
	        System.out.println("Cookie banner is not displayed.");
	    }

	    webdriverutility.click(Cost_Centre_Overview);
	    Thread.sleep(2000);

	    if (action.equalsIgnoreCase("Add new")) {

	        webdriverutility.click(AdNewbutton);
	        Thread.sleep(2000);

	        filldetailsCostoverView(data);

	    } else if (action.equalsIgnoreCase("Edit")) {

	        webdriverutility.click(subEditLink);
	        Thread.sleep(2000);

	        filldetailsCostoverView(data);

	    } else if (action.equalsIgnoreCase("Delete")) {

	        webdriverutility.click(DeleteLink);
	        webdriverutility.click(Confrmbtn);

	        String expectedMessage = "Cost Center record deleted successfully.";

	        By deleteSuccessMsg = By.xpath(
	            "//*[normalize-space(text())='" + expectedMessage + "']"
	        );

	        try {
	            WebDriverWait wait = new WebDriverWait(
	                driver, Duration.ofSeconds(10)
	            );

	            WebElement successMessage = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(deleteSuccessMsg)
	            );

	            Assert.assertEquals(
	                successMessage.getText().trim(),
	                expectedMessage,
	                "Cost Center delete message did not match"
	            );

	            ReportUtil.logPass("Cost Center record deleted successfully");

	        } catch (TimeoutException e) {
	            ReportUtil.logFail("Cost Center delete success message not displayed");
	            Assert.fail("Cost Center delete validation failed", e);
	        }

	    } else {
	        Assert.fail("Invalid Cost Center action: [" + action + "]");
	    }
	}



	
	public void filldetailsCostoverView(CompanyprofileData data) throws Throwable {

	    String action = data.getOfficeLocationAction().trim();

	    WebDriverWait wait = new WebDriverWait(
	        driver, Duration.ofSeconds(20)
	    );

	    webdriverutility.sendKeys(Cost_Centre_Name_TxtBox, costCenterName);
	    
	    ReportUtil.logIfNotBlank("costcentreName", data.getCost_Center_Name());
	    
	    webdriverutility.sendKeys(Cost_Centre_Code_TxtBox, costCenterCode);
	    
	    ReportUtil.logIfNotBlank("costCentre Code", data.getCost_Center_Code());
	    
	    // Check whether the required Office Location is already selected
	    By selectedLocation = By.xpath(
	        "//*[contains(@class,'mat-mdc-chip')"
	        + " or contains(@class,'mat-chip')]"
	        + "[.//*[normalize-space()='" + officeLocation + "']"
	        + " or normalize-space(.)='" + officeLocation + "']"
	    );

	    boolean alreadySelected = !driver.findElements(selectedLocation)
	        .stream()
	        .filter(WebElement::isDisplayed)
	        .toList()
	        .isEmpty();

	    if (!alreadySelected) {

	        // Open the dropdown only if the location is not selected
	        wait.until(ExpectedConditions.elementToBeClickable(
	            Associate_with_Office_location_Dropdown
	        )).click();

	        By requiredOption = By.xpath(
	            "//mat-option[normalize-space(.)='" + officeLocation + "']"
	        );

	        WebElement option = wait.until(
	            ExpectedConditions.elementToBeClickable(requiredOption)
	        );
	        option.click();
	    }

	    // Click outside the dropdown to close it
	    webdriverutility.click(Cost_Centre_Name_TxtBox);

	    // Save
	    wait.until(ExpectedConditions.elementToBeClickable(
	        SavebtnForAll
	    )).click();

	    String expectedMessage;

	    if (action.equalsIgnoreCase("Add new")) {
	        expectedMessage = "Cost center added successfully.";
	    } else if (action.equalsIgnoreCase("Edit")) {
	        expectedMessage = "Cost center updated successfully.";
	    } else {
	        Assert.fail("Invalid Cost Center form action: [" + action + "]");
	        return;
	    }

	    By successMsgLocator = By.xpath(
	        "//*[contains(translate(normalize-space(.),"
	        + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),"
	        + "'" + expectedMessage.toLowerCase() + "')]"
	    );

	    WebElement successMsg = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(successMsgLocator)
	    );

	    Assert.assertTrue(
	        successMsg.getText().trim().toLowerCase()
	            .contains(expectedMessage.toLowerCase()),
	        "Cost Center success message did not match"
	    );

	    ReportUtil.logPass(expectedMessage);
	}
	public void fillProjects(CompanyprofileData data) throws Throwable {

	    prepareTestData(data);

	    String action = data.getOfficeLocationAction().trim();

	    webdriverutility.click(GtmcorporateBtn);
	    webdriverutility.click(CompanyProfileLink);

	    try {
	        if (acceptCookieButton.isDisplayed()) {
	            webdriverutility.click(acceptCookieButton);
	        }
	    } catch (Exception e) {
	        System.out.println("Cookie banner is not displayed.");
	    }

	    webdriverutility.click(Project_DetailsBtn);

	    if (action.equalsIgnoreCase("Add new")) {

	        webdriverutility.click(AdNewbutton);
	        filldetailsProjects(data);

	    } else if (action.equalsIgnoreCase("Edit")) {

	        webdriverutility.click(subEditLink);
	        filldetailsProjects(data);

	    } else if (action.equalsIgnoreCase("Delete")) {

	        webdriverutility.click(ProjectDeletebtn);
	        webdriverutility.click(Confrmbtn);

	        String expectedMessage =
	            "Project cannot be deleted. Users are still assigned to this project.";

	        By deleteErrorMsg = By.xpath(
	            "//*[normalize-space(text())="
	            + "'Project cannot be deleted. Users are still assigned to this project.']"
	        );

	        WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	        try {
	            WebElement errorMessage = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(deleteErrorMsg)
	            );

	            Assert.assertEquals(
	                errorMessage.getText().trim(),
	                expectedMessage,
	                "Project delete restriction message did not match"
	            );

	            System.out.println("PASS: Project delete restriction validated.");

	            ReportUtil.logPass(
	                "Project cannot be deleted because users are assigned to it"
	            );

	        } catch (TimeoutException e) {
	            ReportUtil.logFail(
	                "Project delete restriction message was not displayed"
	            );

	            Assert.fail(
	                "Expected project delete restriction message was not displayed.",
	                e
	            );
	        }

	    } else {
	        Assert.fail("Invalid Project action: [" + action + "]");
	    }
	}
	
	public void filldetailsProjects(CompanyprofileData data) throws Throwable {

	    String action = data.getOfficeLocationAction().trim();

	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(10));

	    webdriverutility.sendKeys(Project_Name_TxtBox, project);
	    
	    ReportUtil.logIfNotBlank("project Name", data.getProject_Name());

		Thread.sleep(3000);

		webdriverutility.sendKeys(Project_Code_TxtBox, projectcode);
		
		ReportUtil.logIfNotBlank("project code", data.getProject_Code());

		ReportUtil.logPass("Project details Added");

	    webdriverutility.click(SavebtnForAll);

	    if (action.equalsIgnoreCase("Add")
	            || action.equalsIgnoreCase("Add new")) {

	        try {
	            WebElement successMsg = wait.until(
	                ExpectedConditions.visibilityOf(ProjectSuccessMsg)
	            );

	            Assert.assertTrue(
	                successMsg.getText().trim()
	                    .contains("Project details added successfully."),
	                "Project add success message did not match"
	            );

	            ReportUtil.logPass("Project added successfully");

	        } catch (TimeoutException e) {
	            ReportUtil.logFail("Project add success message was not displayed");
	            Assert.fail("Project was not added successfully", e);
	        }

	    } else if (action.equalsIgnoreCase("Edit")) {

	        try {
	            WebElement successMsg = wait.until(
	                ExpectedConditions.visibilityOf(ProjectUpdatedMsg)
	            );

	            Assert.assertTrue(
	                successMsg.getText().trim()
	                    .contains("Project details updated successfully."),
	                "Project update success message did not match"
	            );

	            ReportUtil.logPass("Project updated successfully");

	        } catch (TimeoutException e) {
	            ReportUtil.logFail("Project update success message was not displayed");
	            Assert.fail("Project was not updated successfully", e);
	        }
	    }
	}
	
	
	
	

	public void CorporateCards(CompanyprofileData data) throws InterruptedException {
		
		
		
		   prepareTestData(data);
		webdriverutility.click(GtmcorporateBtn);
		Thread.sleep(3000);

		webdriverutility.click(CompanyProfileLink);
		Thread.sleep(3000);

		// Close cookie banner
		try {
			if (acceptCookieButton.isDisplayed()) {
				webdriverutility.click(acceptCookieButton);
			}
		} catch (Exception e) {
			System.out.println("Cookie banner is not displayed.");
		}


		webdriverutility.click(Corporate_cardsBtn);
		

		try {

			if (NoCorporateCardsMsg.isDisplayed()) {

				

				ReportUtil.logPass("No corporate cards added.");

				webdriverutility.click(AddNewLink);

			}

		} catch (Exception e) {

			

			ReportUtil.logPass("Corporate card already exists. Deleting existing card.");

			webdriverutility.click(DeleteCorporateCardBtn);

			Thread.sleep(3000);

			webdriverutility.click(Corporate_cardConfirm);

			Thread.sleep(3000);

			webdriverutility.click(AddNewLink);
		}

		Thread.sleep(3000);
		webdriverutility.click(Crossebtn);

		Thread.sleep(3000);

		webdriverutility.sendKeys(Card_NickNameTxtBox, data.getCard_Name().trim());
		
		ReportUtil.logIfNotBlank("Card Name", data.getCard_Name());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Billing_optn_dropdown, data.getBilling_Option().trim());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Card_Brand_Dropdown, data.getCard_Brand().trim());
		
		ReportUtil.logIfNotBlank("Card Brand", data.getCard_Brand());

		Thread.sleep(3000);

		webdriverutility.sendKeys(CradHolder_NameTxtbox, data.getCard_HolderName().trim());
		
		ReportUtil.logIfNotBlank("Card Holder Name", data.getCard_HolderName());

		Thread.sleep(3000);

		webdriverutility.sendKeys(Crad_Number_Txtbox, data.getCard_Number().trim());
		
		ReportUtil.logIfNotBlank("Card Number", data.getCard_Number());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Expiry_Month_Dropdwn, data.getExpiry_month().trim());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Expiry_Year_Dropdwn, data.getExpiry_year().trim());

		Thread.sleep(3000);

		webdriverutility.click(Physical_card_Radiobtn);

		Thread.sleep(3000);

		// webdriverutility.click(Lodge_Chk_Box);

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Ruled_Applied_Dropdown, data.getRule_applied_on().trim());
		
		webdriverutility.selectMatCheckbox(Select_corporate_Dropdown,By.xpath("//mat-checkbox[normalize-space(following-sibling::text())='N95 corp']"));

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Product_Dropdown, data.getProduct().trim());

//		Thread.sleep(3000);
//		webdriverutility.selectMatOptionByVisibleText(Select_corporate_Dropdown, data.getCompany_Name());

		
		

webdriverutility.click(SavebtnForAll);


WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

try {
    By duplicateLocator = By.xpath(
        "//*[contains(normalize-space(.), 'This card is already saved with Saudia Business.')]"
    );

    WebElement duplicateMessage = wait.until(
        ExpectedConditions.visibilityOfElementLocated(duplicateLocator)
    );

    System.out.println("Duplicate message: " + duplicateMessage.getText());

    ReportUtil.logPass(
        "Corporate card validation passed: Duplicate card message displayed."
    );

} catch (TimeoutException e) {
    ReportUtil.logFail(
        "Corporate card validation failed: Duplicate message not found."
    );
    throw e;
}
	}


public void BusinessUnit(CompanyprofileData data)
        throws InterruptedException {

    String action = data.getOfficeLocationAction().trim();

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(20));

    webdriverutility.click(GtmcorporateBtn);
    webdriverutility.click(CompanyProfileLink);

    try {
        if (acceptCookieButton.isDisplayed()) {
            webdriverutility.click(acceptCookieButton);
        }
    } catch (Exception e) {
        System.out.println("Cookie banner is not displayed.");
    }

    webdriverutility.click(Business_Unit_Overviewbtn);

    // Add New, Edit and Delete actions
    if (action.equalsIgnoreCase("Add new")
            || action.equalsIgnoreCase("Add")) {

        // Supports Add New as button, link or role=button
       
    	By addNew = By.xpath("//a[normalize-space()='Add new']");

    	WebElement element = wait.until(
    	    ExpectedConditions.visibilityOfElementLocated(addNew)
    	);

    	((JavascriptExecutor) driver).executeScript(
    	    "arguments[0].scrollIntoView({block:'center'});", element
    	);

    	wait.until(ExpectedConditions.elementToBeClickable(addNew)).click();
        BusinessUnitOverviewDetails(data);

    } else if (action.equalsIgnoreCase("Edit")) {

        WebElement editButton = wait.until(
                ExpectedConditions.elementToBeClickable(BusinessUnitEdit)
        );

        editButton.click();

        BusinessUnitOverviewDetails(data);

    } else if (action.equalsIgnoreCase("Delete")) {

        WebElement deleteButton = wait.until(
                ExpectedConditions.elementToBeClickable(ProjectDeletebtn)
        );

        deleteButton.click();

        WebElement confirmButton = wait.until(
                ExpectedConditions.elementToBeClickable(Confrmbtn)
        );

        confirmButton.click();

        String expectedMessage =
                "Business Unit record deleted successfully.";

        By deleteSuccessMsg = By.xpath(
                "//*[normalize-space(.)='"
                + expectedMessage + "']"
        );

        try {
            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            deleteSuccessMsg
                    )
            );

            Assert.assertEquals(
                    successMessage.getText().trim(),
                    expectedMessage,
                    "Business Unit delete message did not match"
            );

            System.out.println(
                    "PASS: Business Unit deleted successfully."
            );

            ReportUtil.logPass(
                    "Business Unit record deleted successfully"
            );

        } catch (TimeoutException e) {

            ReportUtil.logFail(
                    "Business Unit delete success message was not displayed"
            );

            Assert.fail(
                    "Expected Business Unit delete success message "
                    + "was not displayed.",
                    e
            );
        }

    } else {

        Assert.fail(
                "Invalid Business Unit action: [" + action + "]"
        );
    }
}


public void BusinessUnitOverviewDetails(CompanyprofileData data)
        throws InterruptedException {

    prepareTestData(data);

    String action = data.getOfficeLocationAction().trim();

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(20));

    webdriverutility.sendKeys(Businessunit_code, BusinessUnitcode);
    webdriverutility.sendKeys(Business_Unit_name, BusinessUnitname);

    webdriverutility.sendKeys(
            Business_unit_Manager,
            data.getBusiness_unit_Manager().trim()
    );

    webdriverutility.sendKeys(Business_unit_mail, email);

    webdriverutility.sendKeys(
            Business_unit_ContactNumber,
            data.getBusiness_unit_ContactNumber().trim()
    );

    // 1. Click the actual Select input to open Office Location dropdown
 // 1. Office Location field ke andar actual Select input locate karein
    By selectOfficeLocation = By.xpath(
        "//mat-form-field[.//mat-label[normalize-space()='Associate with Office location']]//input"
    );

    WebElement selectInput = wait.until(
        ExpectedConditions.elementToBeClickable(selectOfficeLocation)
    );

    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        selectInput
    );

    selectInput.click();

    // 2. Required Office Location select karein
    By officeLocationOption = By.xpath(
        "//mat-option[normalize-space(.)='"
        + officeLocation.trim() + "']"
    );

    WebElement option = wait.until(
        ExpectedConditions.elementToBeClickable(officeLocationOption)
    );

    option.click();

    // 3. Save click karein
    WebElement saveButton = wait.until(
        ExpectedConditions.elementToBeClickable(SavebtnForAll)
    );

    saveButton.click();

    // 4. Validate Add/Edit success message
    String expectedMessage;

    if (action.equalsIgnoreCase("Add")
            || action.equalsIgnoreCase("Add new")) {

        expectedMessage = "Business unit added successfully.";

    } else if (action.equalsIgnoreCase("Edit")) {

        expectedMessage = "Business unit updated successfully.";

    } else {
        Assert.fail("Invalid Business Unit form action: [" + action + "]");
        return;
    }

    By successMsgLocator = By.xpath(
            "//*[contains(normalize-space(.),'"
                    + expectedMessage + "')]"
    );

    try {
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        successMsgLocator
                )
        );

        Assert.assertTrue(
                successMessage.getText().contains(expectedMessage),
                "Business Unit success message did not match. Actual: "
                        + successMessage.getText()
        );

        ReportUtil.logPass(expectedMessage);

    } catch (TimeoutException e) {

        ReportUtil.logFail(
                "Business Unit success message was not displayed"
        );

        Assert.fail(
                "Business Unit operation was not successful: " + action,
                e
        );
    }
}

	public void prepareTestData(CompanyprofileData data) {
		 

	    registrationId =
	            TestDataGenerator.generateCompanyRegistrationId();

	    taxId =
	            TestDataGenerator.generateTaxIdentificationNumberNumeric();

	    buildingNumber =
	            TestDataGenerator.generateBuildingNumber();

	    email =
	            TestDataGenerator.generateCompanyEmail();

	    project =
	            TestDataGenerator.generateProjectName(
	                    data.getProject_Name().trim());

	    projectcode =
	            TestDataGenerator.generateProjectCode(
	                    data.getProject_Code().trim());

//	    officeLocation =
//	            TestDataGenerator.generateOfficeLocation(
//	                    data.getOffice_Location_Name().trim());

	    OfficeLocationCode =
	            TestDataGenerator.generateOfficeLocationcode(
	                    data.getOffice_Location_Code().trim());

	    costCenterName =
	            TestDataGenerator.generateCostCenterName(
	                    data.getCost_Center_Name().trim());

	    costCenterCode =
	            TestDataGenerator.generateCostCenterCode(
	                    data.getCost_Center_Code().trim());

	    CategoryCode =
	            TestDataGenerator.generateCategoryCode(
	                    data.getCategoryCode().trim());

	    BusinessUnitname =
	            TestDataGenerator.generateUniqueBusinessUnitName(
	                    data.getBusiness_Unit_name().trim());

	    BusinessUnitcode =
	            TestDataGenerator.generateBusinessunit_code(
	                    data.getBusinessunit_code().trim());

	    CategoryName =
	            TestDataGenerator.generateCategoryName(
	                    data.getCategoryCode().trim());

	    TripType = data.getTripType();

	    TravelCategory =
	            TestDataGenerator.generateTravelCategory(
	                    data.getTravelCategory()).trim();
	}
	public static String getEmail() {
	    return email;
	}
	public static String getOfficeLocation() {
	    return officeLocation;
	}
	public static String getTravelCategory() {
	    return TravelCategory;
	}
	public static String getCategoryName() {
	    return CategoryName;
	}
	public static String getCategoryCode() {
	    return CategoryCode;
	}
	public static String getTripType() {
	    return TripType;
	}

}

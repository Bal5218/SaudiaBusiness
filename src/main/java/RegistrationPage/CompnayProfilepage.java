package RegistrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import modeles.CompanyprofileData;
import reports.ReportUtil;
import utilities.TestDataGenerator;
import utilities.WebdriverUtility;

public class CompnayProfilepage extends BasePage {

	private WebdriverUtility webdriverutility;

	public CompnayProfilepage(WebDriver driver) {
		super(driver);
		webdriverutility = new WebdriverUtility(driver);
	}

	@FindBy(xpath = "//button[contains(@class,'menu-label') and normalize-space()='GTM CORPORATE']")
	private WebElement GtmcorporateBtn;

	@FindBy(xpath = "//a[@href='/cam/company-management/company-details']")
	private WebElement CompanyProfileLink;

	@FindBy(xpath = "//button[@class='button-as-span link']")
	private WebElement EditLink;

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

	@FindBy(xpath = "//a[@class='onclick-cell primary-link']")
	private WebElement OfficeLocationEditLink;

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

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Associate with Office location']]")
	private WebElement Associate_with_Office_location_Dropdown;

	@FindBy(xpath = "//mat-checkbox[@id='mat-mdc-checkbox-1']")
	private WebElement Chkbox;

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement SavebtnForAll;

	@FindBy(xpath = "//div[contains(normalize-space(),'Cost center added successfully')]")
	private WebElement CostCenterSuccessMsg;
	// project Details

	@FindBy(xpath = "//button[contains(@class,'custom-tree-child') and normalize-space()='Project details']")
	private WebElement Project_DetailsBtn;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Project name']]//input")
	private WebElement Project_Name_TxtBox;

	@FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Project code']]//input")
	private WebElement Project_Code_TxtBox;

	@FindBy(xpath = "//*[contains(normalize-space(),'Project details added successfully')]")
	private WebElement ProjectSuccessMsg;

	@FindBy(xpath = "//*[contains(normalize-space(),'Project details already exist')]")
	private WebElement ProjectAlreadyExistMsg;
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
	private String email;
	private String project;
	private String projectcode;
	private String officeLocation;
	private String OfficeLocationCode;
	private String costCenterName;
	private String costCenterCode;
	private String CategoryCode;
	private String CategoryName;
	private String TripType;
	private String TravelCategory;

	public void companyProfiledetails(CompanyprofileData data) throws Throwable {

		// Generate dynamic data
		registrationId = TestDataGenerator.generateCompanyRegistrationId();

		taxId = TestDataGenerator.generateTaxIdentificationNumberNumeric();

		buildingNumber = TestDataGenerator.generateBuildingNumber();

		email = TestDataGenerator.generateCompanyEmail();

		project = TestDataGenerator.generateProjectName(data.getProject_Name().trim());

		projectcode = TestDataGenerator.generateProjectCode(data.getProject_Code().trim());

		officeLocation = TestDataGenerator.generateOfficeLocation(data.getOffice_Location_Name().trim());

		OfficeLocationCode = TestDataGenerator.generateOfficeLocationcode(data.getOffice_Location_Code().trim());

		costCenterName = TestDataGenerator.generateCostCenterName(data.getCost_Center_Name().trim());

		costCenterCode = TestDataGenerator.generateCostCenterCode(data.getCost_Center_Code().trim());
		CategoryCode= TestDataGenerator.generateCategoryCode(data.getCategoryCode().trim());
		CategoryName= TestDataGenerator.generateCategoryName(data.getCategoryCode().trim());
		TripType=data.getTripType();
		 TravelCategory=TestDataGenerator.generateTravelCategory(data.getTravelCategory()).trim();

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

		// Company Details

//	Enterdetails(data);
//
//		OfficeLocation(data);
//
//	fillCostoverView(data);
//		EnterprojectDetails(data);
//		CorporateCards(data);
	//	BusinessUnitOverviewDetails(data);
//
//		TravelProfilingPage TravelProfilingPage = new TravelProfilingPage(driver);
//	TravelProfilingPage.DepartmentDetails(data, CategoryName,CategoryCode,officeLocation,TripType,TravelCategory);
//		
		
	NewTravllerPage NewTravllerPage=new NewTravllerPage(driver);
		
		NewTravllerPage.AddTraveller(data);

	}

	public void Enterdetails(CompanyprofileData data) throws Throwable {

		webdriverutility.click(EditLink);

		webdriverutility.sendKeys(CompanyTextBox, data.getCompany_Name().trim());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(IndustryDropdown, data.getIndustry().trim());

		Thread.sleep(3000);

		webdriverutility.sendKeys(resgistrationIdTxtbox, registrationId);

		Thread.sleep(3000);

		webdriverutility.sendKeys(TaxidentificationNumberTxtbox, taxId);

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

		webdriverutility.click(OfficeLocation);

		Thread.sleep(3000);

		String action = data.getOfficeLocationAction().trim();

		if (action.equalsIgnoreCase("Add new")) {

			webdriverutility.click(AdNewbutton);

			Thread.sleep(3000);

			fillOfficeLocationDetails(data);

		} else if (action.equalsIgnoreCase("edit")) {

			webdriverutility.click(OfficeLocationEditLink);

			Thread.sleep(3000);

			fillOfficeLocationDetails(data);

		} else {

			System.out.println("Invalid Office Location action: " + action);
		}
	}

	private void fillOfficeLocationDetails(CompanyprofileData data) throws Throwable {

		// Active
		// webdriverutility.click(ActiveRadiobtn);

		Thread.sleep(1000);

		// Office Location Name
		webdriverutility.sendKeys(Corporate_Office_LocationName, officeLocation);

		Thread.sleep(1000);

		webdriverutility.sendKeys(OfficeLocationCodeTxtbox, OfficeLocationCode);

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

		Thread.sleep(1000);
		// Postal Code
		webdriverutility.sendKeys(OfficeLocationPostalCode, data.getOffice_Location_postal_code().trim());

		Thread.sleep(1000);

		webdriverutility.sendKeys(OfficeEmailAddressTxtbox, email);

		ReportUtil.logPass("Office location details Added");

		Thread.sleep(1000);

		// Save

		webdriverutility.click(Savebtn);

		Thread.sleep(2000);

		if (OfficeLocationSuccessMsg.isDisplayed()) {

			ReportUtil.logPass("Office location added successfully");

		} else {

			ReportUtil.logFail("Office location validation failed");
		}

	}

	public void fillCostoverView(CompanyprofileData data) throws Throwable {

		webdriverutility.click(Cost_Centre_Overview);
		Thread.sleep(3000);
		webdriverutility.click(AddNewLink);

		Thread.sleep(3000);
		webdriverutility.sendKeys(Cost_Centre_Name_TxtBox, costCenterName);

		Thread.sleep(3000);

		webdriverutility.sendKeys(Cost_Centre_Code_TxtBox, costCenterCode);

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Associate_with_Office_location_Dropdown, officeLocation);

		ReportUtil.logPass(" Cost Added successful");

		webdriverutility.click(SavebtnForAll);

		Thread.sleep(2000);

		if (CostCenterSuccessMsg.isDisplayed()) {

			ReportUtil.logPass("Cost center added successfully");

		} else {

			ReportUtil.logFail("Cost center validation failed");
		}

	}

	public void EnterprojectDetails(CompanyprofileData data) throws InterruptedException {

		webdriverutility.click(Project_DetailsBtn);

		Thread.sleep(3000);

		webdriverutility.click(AddNewLink);

		Thread.sleep(3000);

		webdriverutility.sendKeys(Project_Name_TxtBox, project);

		Thread.sleep(3000);

		webdriverutility.sendKeys(Project_Code_TxtBox, projectcode);

		ReportUtil.logPass("Project details Added");

		webdriverutility.click(SavebtnForAll);

		try {

			if (ProjectSuccessMsg.isDisplayed()) {

				String message = ProjectSuccessMsg.getText().trim();

				System.out.println("Project added: ");

				ReportUtil.logPass("Project details added successfully: ");

			} else if (ProjectAlreadyExistMsg.isDisplayed()) {

				String message = ProjectAlreadyExistMsg.getText().trim();

				System.out.println("Project already exists: ");

				ReportUtil.logFail("Project details were not added: ");

			}

		} catch (Exception e) {

			ReportUtil.logFail("Project details validation failed: ");

		}
	}

	public void CorporateCards(CompanyprofileData data) throws InterruptedException {

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

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Billing_optn_dropdown, data.getBilling_Option().trim());

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Card_Brand_Dropdown, data.getCard_Brand().trim());

		Thread.sleep(3000);

		webdriverutility.sendKeys(CradHolder_NameTxtbox, data.getCard_HolderName().trim());

		Thread.sleep(3000);

		webdriverutility.sendKeys(Crad_Number_Txtbox, data.getCard_Number().trim());

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

		Thread.sleep(3000);

		webdriverutility.selectMatOptionByVisibleText(Product_Dropdown, data.getProduct().trim());

		Thread.sleep(3000);
		webdriverutility.selectMatOptionByVisibleText(Select_corporate_Dropdown, data.getCompany_Name());

		
		webdriverutility.click(SavebtnForAll);

		try {

			if (CorporatecardSuccessMsg.isDisplayed()) {

				String message = CorporatecardSuccessMsg.getText().trim();

				

				ReportUtil.logPass("Corporate card  details added successfully: ");

			} else if (CorporatecardAlreadyExistmsg.isDisplayed()) {

				String message = CorporatecardAlreadyExistmsg.getText().trim();

				ReportUtil.logFail("Corporate card already exists: ");

			}

		} catch (Exception e) {

			ReportUtil.logFail("Corporate card already exists: ");

		}
	}
		



	public void BusinessUnitOverviewDetails(CompanyprofileData data) throws InterruptedException {

		webdriverutility.click(Business_Unit_Overviewbtn);
		;

		Thread.sleep(3000);
		webdriverutility.click(AddNewLink);

		Thread.sleep(3000);
		webdriverutility.sendKeys(Businessunit_code, data.getBusinessunit_code().trim());

		Thread.sleep(3000);
		webdriverutility.sendKeys(Business_Unit_name, data.getBusiness_Unit_name().trim());

		Thread.sleep(3000);

		webdriverutility.sendKeys(Business_unit_Manager, data.getBusiness_unit_Manager().trim());

		Thread.sleep(3000);
		webdriverutility.sendKeys(Business_unit_mail, data.getBusiness_unit_mail().trim());

		Thread.sleep(3000);
		webdriverutility.sendKeys(Business_unit_ContactNumber, data.getBusiness_unit_ContactNumber().trim());

		Thread.sleep(3000);
		webdriverutility.selectMatOptionByVisibleText(Associate_with_Office_location_Dropdown, officeLocation);

		ReportUtil.logPass("BusinessUnitOverviewDetails");

		Thread.sleep(5000);
		webdriverutility.click(SavebtnForAll);

	}

}

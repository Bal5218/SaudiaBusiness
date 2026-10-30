package flightBookingPage;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;

import base.BasePage;

import modeles.FlightBookingData;
import reports.ExtentTestManager;
import reports.ReportUtil;
import utilities.ExcelUtil;
import utilities.Ipathconstant;
import utilities.WebdriverUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class FlightBookingForAllPaxPage extends BasePage {

	private WebdriverUtility webdriverutility;

	public FlightBookingForAllPaxPage(WebDriver driver) {
		super(driver);

		webdriverutility = new WebdriverUtility(driver);

	}
//	@FindBy(xpath = "//a[@aria-label='Go to homepage']")
//	private WebElement Saudialogo;
	
	@FindBy(xpath = "//app-passenger-selector//button[.//span[normalize-space()='Continue']]")
	private WebElement Continuebtn;

	private By saudiaLogo =
	        By.xpath("//a[@aria-label='Go to homepage']");
	
	@FindBy(xpath = "//mat-radio-button[.//*[normalize-space()='Round trip']]")
	private WebElement roundTripRadioBtn;

	@FindBy(xpath = "//mat-radio-button[.//*[normalize-space()='One way']]")
	private WebElement OnewayRadiobtn;

	@FindBy(xpath = "//mat-radio-button[.//*[normalize-space()='Multi-city']]")
	private WebElement MulticityRadioBtn;

	@FindBy(xpath = "(//input[@formcontrolname='fromLocationControl'])[1]")
	private WebElement FromTxtbox;

	@FindBy(xpath = "(//input[@formcontrolname='toLocationControl'])[1]")
	private WebElement TotxtBox;

	@FindBy(xpath = "(//mat-form-field[.//*[normalize-space()='Departure date']]//mat-icon)[1]")
	private WebElement DepartureCalendaricon;

	@FindBy(xpath = "(//mat-form-field[.//*[normalize-space()='Departure date']]//input)[1]")
	private WebElement departureDateInput;

	@FindBy(xpath = "//mat-form-field[.//*[normalize-space()='Return date']]//mat-icon")
	private WebElement returnCalendar;

	@FindBy(xpath = "//mat-form-field[.//*[normalize-space()='Return date']]//input")
	private WebElement returnDateInput;

	@FindBy(xpath = "(//mat-form-field[.//*[normalize-space()='Departure date']]//mat-icon)[2]")
	private WebElement DepartureCalendaricon2;

	@FindBy(xpath = "(//mat-form-field[.//*[normalize-space()='Departure date']]//input)[2]")
	private WebElement departureDateInput2;
	
	@FindBy(xpath = "(//mat-form-field[.//*[normalize-space()='Departure date']]//mat-icon)[3]")
	private WebElement DepartureCalendaricon3;

	@FindBy(xpath = "(//mat-form-field[.//*[normalize-space()='Departure date']]//input)[3]")
	private WebElement departureDateInput3;

	@FindBy(xpath = "//div[contains(@class,'calendar-popup')]//button[normalize-space()='Continue']")
	private WebElement calendarContinueBtn;


	@FindBy(xpath = "//mat-radio-button[.//label[normalize-space()='Employee']]")
	private WebElement EmployeeRadiobtn;

	@FindBy(xpath = "//mat-radio-button[.//label[normalize-space()='Guest traveler']]")
	private WebElement GuestTravellerRadioBtn;

	@FindBy(xpath = "//mat-radio-button[.//label[normalize-space()='Multiple travelers']]")
	private WebElement MultipleTravellerRadioBtn;

	// Trip Category

	// @FindBy(xpath = "//mat-radio-button[.//*[normalize-space()='Business trip']]")
	// private WebElement BusinessTripRadioBtn;

	// @FindBy(xpath = "//mat-radio-button[.//*[normalize-space()='Family trip']]")
	// private WebElement FamilyTripRadioBtn;
	By FamilyTripRadioBtn = By.xpath(
    "//mat-radio-button[.//*[normalize-space()='Family trip']]"
);
By BusinessTripRadioBtn = By.xpath(
    "//mat-radio-button[.//*[normalize-space()='Business trip']]"
);


	// @FindBy(xpath = "//button[normalize-space()='Apply selection']")
	// private WebElement ApplySelectionBtn;
//   

// private By ApplySelectionBtn = By.xpath(
//     "//app-trip-selector//button[.//span[normalize-space()='Apply selection']]"
// );

By ApplySelectionBtn = By.xpath(
    "//button[normalize-space(.)='Apply selection' " +
    "or .//span[normalize-space()='Apply selection']]"
);



	@FindBy(xpath = "//mat-form-field[.//label[contains(normalize-space(.),'Passengers and cabin')]]")
	private WebElement PassengerDetailDropdown;

	@FindBy(xpath = "//div[contains(@class,'age-details')][.//p[normalize-space()='Adults']]//button[.//mat-icon[normalize-space()='Add']]")
	private WebElement adultPlusBtn;

	@FindBy(xpath = "//div[contains(@class,'age-details')][.//p[normalize-space()='Children']]//button[.//mat-icon[normalize-space()='Add']]")
	private WebElement childPlusBtn;

	@FindBy(xpath = "//div[contains(@class,'age-details')][.//p[normalize-space()='Infants on lap']]//button[.//mat-icon[normalize-space()='Add']]")
	private WebElement infantLapPlusBtn;
	
	

//	@FindBy(xpath = "//mat-form-field[.//label[contains(normalize-space(.),'Booking details')]]")
//	private WebElement TravelCalssDropdown;
	
	@FindBy(xpath = "//mat-form-field[.//label[" +
	        "contains(normalize-space(.),'Booking details') " +
	        "or contains(normalize-space(.),'Trip type')]]")
	private WebElement TravelCalssDropdown;
	
	@FindBy(xpath = "//mat-form-field[.//label[contains(normalize-space(),'Employee details')]]//input")
	private WebElement EmployeeDetailsTextbox;

	@FindBy(xpath = "//div[@id='mat-autocomplete-2']")
	private WebElement EmployeeDetailssuggestion;
	
	@FindBy(xpath = "//button[contains(@class,'add-multicity-flight') and .//span[normalize-space()='Add flight']]")
	private WebElement AddFlightbtn;

//	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
//	private WebElement acceptCookieBtn;

	@FindBy(xpath = "//button[contains(@class,'button--primary-small') and .//span[normalize-space()='Accept']]")
	private WebElement acceptCookieBtn;

//	private WebElement EmployeeDetailsTextBox;

	@FindBy(xpath = "//button[contains(@class,'mdc-button mat-mdc-button-base button--primary-large search mdc-button--unelevated mat-mdc-unelevated-button mat-unthemed _mat-animation-noopable')]")
	private WebElement SearchFlightbtn;

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-large step-button mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement ContinueToPassengerBtn;
	// proceed to payemnt page

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--secondary-large mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement ContinueToPaymentBtn;

	@FindBy(xpath = "//mat-expansion-panel-header[@aria-controls='cdk-accordion-child-19']")
	private WebElement ContinueToExtrasBtn;
	
	
	
	


	
	
	
	

//	@FindBy(xpath = "//div[normalize-space()='SADAD']")
//	private WebElement SdadRadiobtn;
	private By SdadRadiobtn = By.xpath(
		    "//mat-expansion-panel-header[.//mat-panel-title[normalize-space()='SADAD']]");


//		private By sadadRadio = By.xpath(
//		    "//mat-expansion-panel"
//		  + "[.//mat-expansion-panel-header//mat-panel-title[normalize-space()='SADAD']]"
//		  + "//mat-radio-button"
//		);
//	private By termsCheckbox = By
//			.xpath("//mat-checkbox[contains(.,\"By continuing, you agree to Saudia's Terms and Conditions\")]");


private By termsCheckbox = By
		.xpath("//label[contains(.,'Terms and Conditions')]");

	// Pay jow btn

@FindBy(xpath = "//button[.//span[normalize-space()='Pay now'] and not(contains(@class,'d-none'))]")
private WebElement Paynowbtn;



	private By basicFareSelectBtn = By.xpath("(//*[contains(normalize-space(.),'Basic') "
			+ "and not(.//*[contains(normalize-space(.),'Basic')])]"
			+ "/ancestor::*[.//button[normalize-space()='Select']][1]" + "//button[normalize-space()='Select'])[1]");

	private By firstExpandFareBtn = By
			.xpath("(//button[contains(@class,'expand-button') and @aria-label='expand more'])[1]");

	private By secondExpandFareBtn = By
			.xpath("(//div[contains(@class,'flight-class-wrap') " + "and contains(@class,'guest_card')])[2]"
					+ "//button[contains(@class,'expand-button') " + "and @aria-label='expand more']");
	private By bookingHoldMsg = By.xpath(
			"//div[contains(@class,'toast-msg__hold')]//span[@class='toast-header' and normalize-space()='This booking is on hold.']");

	// tct page
	// private By bookingReference = By.xpath("(//div[contains(@class,'pnr-wrapper__data')]"
	// 		+ "[.//p[normalize-space()='Booking reference']]" + "//p[contains(@class,'pnr-info')])[1]");

	By bookingReference = By.xpath(
    "//*[normalize-space()='Booking reference']/following::p[1]"
);


	private By airlineBookingReference = By.xpath("(//div[contains(@class,'pnr-wrapper__data')]"
			+ "[.//p[normalize-space()='Airline booking reference']]" + "//p[contains(@class,'pnr-info')])[1]");
	private By allExpandFareBtns = By
			.xpath("//button[contains(@class,'expand-button') " + "and @aria-label='expand more']");
	// Adult1

	@FindBy(xpath = "(//mat-select[@formcontrolname='title'])[1]")
	private WebElement AdultTitleDropdown;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	private WebElement FirstNameTextBox;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	private WebElement LastNameTextBox;

	@FindBy(xpath = "//input[@formcontrolname='DOB']")
	private WebElement DOBInputTextbox;

	@FindBy(xpath = "//ng-select[@formcontrolname='countryControl']")
	private WebElement NationalityDropdown;

	@FindBy(xpath = "//input[@formcontrolname='PPNo']")
	private WebElement PasspoertTextBox;

	@FindBy(xpath = "//input[@formcontrolname='PPExpiry']")
	private WebElement ExpiryDateInput;

	@FindBy(xpath = "//ng-select[@formcontrolname='issuingCountry']")
	private WebElement IssueCountryDropdown;
	
//
//			@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
//			private WebElement NextPassengerBtn;

	private By NextPassengerBtn = By.xpath("//button[normalize-space()='Next passenger']");

	// Adult2

	// Adult 2
	@FindBy(xpath = "(//mat-select[@formcontrolname='title'])[1]")
	private WebElement Adult2TitleDropdown;


	// Multicity

	@FindBy(xpath = "(//input[@formcontrolname='fromLocationControl'])[2]")
	private WebElement SecondFromTxtbox;

	@FindBy(xpath = "(//input[@formcontrolname='toLocationControl'])[2]")
	private WebElement secondTotxtBox;
	
	@FindBy(xpath = "(//input[@formcontrolname='toLocationControl'])[3]")
	
	private WebElement thirdTotxtBox;

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement AdultApplyselectionbtn;
	
	//depaendent
	@FindBy(xpath = "//button[contains(normalize-space(.),'Add dependent')]")
	private WebElement addDependentBtn;
	
	private By savedDependentsPopup =   By.xpath("//h3[normalize-space()='Saved Dependents']");
	     
	private By dependentSearchBox =    By.xpath("//mat-dialog-container//input");
	    

	
	@FindBy(xpath = "//mat-dialog-actions//button[.//span[contains(@class,'mdc-button__label') and normalize-space()='Add']]")
	private WebElement Addbtn;
	
	@FindBy(xpath = "(//div[contains(@class,'multicity-flight-view-button')]//button[.//span[normalize-space()='Select trip']])[1]")
	private WebElement SelectTripbtn;
	
	@FindBy(xpath = "//button[contains(@class,'continue__cta') and .//span[normalize-space()='Select & Continue']]")
	private WebElement selectAndContinueBtn;
	
	private By savedCardsHeader = By.xpath(
		    "//mat-expansion-panel-header" +
		    "[.//mat-panel-title[normalize-space()='Saved cards']]"
		);
	private By savedCardRadio = By.xpath(
		    "//mat-radio-group[@formcontrolname='selectedCardId']" +
		    "//mat-radio-button[1]"
		);
	@FindBy(xpath = "(//mat-form-field[.//mat-label[normalize-space()='Security code']]//input)[1]")
	private WebElement securityCodeTextbox;
	
	 private By savedCards =   By.xpath("//label[contains(normalize-space(),'Saved cards')]");
	         

	    private By differentCard =  By.xpath("//mat-expansion-panel-header[.//mat-panel-title[normalize-space()='Use a different card']]");
	          

	    private By sadad =    By.xpath("//label[contains(normalize-space(),'SADAD')]");
	        

	    private By cardNumber =By.xpath("//input[@formcontrolname='cardNumber']");
	      

	    private By expiryMonth =By.xpath("//mat-select[@formcontrolname='expiryMonth']");

	     
	    private By expiryYear =By.xpath("//mat-select[@formcontrolname='expiryYear']");
	          

	    private By cardName =By.xpath("//input[@formcontrolname='cardHolder']");
	        

	    private By securityCode =   By.xpath("//input[@formcontrolname='cvv']");
	    
	    private By VisaCardRadiobtn =   By.xpath("//mat-radio-group[@formcontrolname='selectedCardId']");
	    
	    
//	    
//	    @FindBy(xpath = "//input[contains(@placeholder,'Enter Code Here')]")
//		private WebElement OtpTextbox;
//		
//	    @FindBy(xpath = "//input[@value='SUBMIT']")
//	  		private WebElement Submitbtn;
	  		
	    private By OtpTextbox =
	            By.xpath("//input[@name='challengeDataEntry']");

	    private By Submitbtn =
	            By.xpath("//input[@type='submit' and @value='SUBMIT']");

	    private By cardinalIframe =
	            By.id("Cardinal-CCA-IFrame");

	          By guestTravelerRadio = By.xpath(
	             "//mat-radio-button[.//*[normalize-space()='Guest traveler']]"
	     );


//	    private By terms = By.xpath("//input[@type='checkbox']");
//	           
//
//	    private By payNow =  By.xpath("//button[normalize-space()='Pay now']");
	          
	
//	@FindBy(xpath = "//div[contains(@class,'delete-passenger-form-wrapper')]")
//	private WebElement AllChkbox;
//
//	private By dependentPopup =  By.xpath("//h3[normalize-space()='Saved Dependents']");
//	        
	
	
	
	//paymemnt from sadad
	    @FindBy(xpath = "//button[normalize-space(.)='Book & Manage']")
	    private WebElement BookandManagebtn;
		 
	    @FindBy(xpath = "(//span[contains(.,'Manage')])[1]")
		private WebElement Managebtn;
	    
	    @FindBy(xpath = "//button[contains(.,' Pay now ')]")
	  		private WebElement SadadPaynowbtn;
	  		 
	    @FindBy(xpath = "//*[contains(text(),'Please wait while your payment is being processed')]")
	    private WebElement processingPopup;
	
	
	
	

//			private By applySelectionBtn =
//			        By.xpath("//button[normalize-space()='Apply selection']");
	    
	    
	    public void FlightBookingForAllPax(FlightBookingData data) throws Throwable {
	    	

	        // =====================================================
	        // 1. GET BASIC DATA
	        // =====================================================
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
          wait.until(ExpectedConditions.elementToBeClickable(saudiaLogo));
	        webdriverutility.click(saudiaLogo);

	        String tripType = data.getTripType().trim();
	        String Traveller = data.getTravellerType().trim();
	        String tripCategory = data.getTripCategory().trim();

	        System.out.println("========================================");
	        System.out.println("TRIP TYPE      = " + tripType);
	        System.out.println("TRAVELLER TYPE = " + Traveller);
	        System.out.println("TRIP CATEGORY  = " + tripCategory);
	        System.out.println("========================================");


	        // =====================================================
	        // 2. SELECT TRIP TYPE
	        // =====================================================

	        TripType(data);

	        Thread.sleep(3000);

	        webdriverutility.click(acceptCookieBtn);
	        // =====================================================
	        // 3. ENTER FLIGHT SEARCH DETAILS
	        // =====================================================

	        if (tripType.equalsIgnoreCase("One Way")) {

	            System.out.println("===== ONE WAY SEARCH =====");

	            selectDeparturecity(data);

	            Thread.sleep(3000);

	            selectArrivalcity(data);

	        
	            
Thread.sleep(1000);
	            webdriverutility.selectPikadayDate(
	                    DepartureCalendaricon,
	                    departureDateInput,
	                    data.getDeparturedate(),
	                    false,
	                    null
	            );
	     
	        }

	        
else if (tripType.equalsIgnoreCase("Round trip")) {

    System.out.println("===== ROUND TRIP SEARCH =====");

    selectDeparturecity(data);
    selectArrivalcity(data);

//    webdriverutility.click(acceptCookieBtn);
Thread.sleep(1000);
    webdriverutility.selectRoundTripDates(
        DepartureCalendaricon,
        data.getDeparturedate(),
        data.getReturndate()
    );

    // Do not call closeRoundTripCalendar() here


	           // webdriverutility.closeRoundTripCalendar();

	        }

	        else if (tripType.equalsIgnoreCase("Multi-city")) {

	            System.out.println("===== MULTI-CITY SEARCH =====");

	            MultiCityDetails(data);
	        }

	        else {

	            throw new IllegalArgumentException(
	                    "Unsupported trip type: " + tripType
	            );
	        }


	        // =====================================================
	        // 4. TRAVELLER TYPE
	        // =====================================================

	     

	       // TravellerType(data);
	        System.out.println("Traveller variable = [" + Traveller + "]");
	        System.out.println("POJO Traveller Type = ["
	                + data.getTravellerType() + "]");
	        System.out.println("Test Case ID = [" + data.getTestCaseId() + "]");

	     // =====================================================
	     // 4. TRAVELLER TYPE
	     // =====================================================

	     System.out.println("Traveller = [" + Traveller + "]");
	     System.out.println("Trip Category = [" + tripCategory + "]");

	  // =====================================================
	  // 4. TRAVELLER TYPE & TRIP CATEGORY
	  // =====================================================

	  if (!Traveller.isEmpty()) {

	      TravellerType(data);

	      ReportUtil.logIfNotBlank(
	              "Traveller Type : ",
	              Traveller
	      );

	  } else if (tripCategory.equalsIgnoreCase("Family trip")) {

	      System.out.println(
	              "Blank Traveller + Family Trip detected."
	      );

	      // First select Family Trip
	      selectTripCategory(data);

	      // Then select passenger counts from Excel
	      selectFamilyPassengerCounts(data);

	  } else {

	      System.out.println(
	              "Traveller Type is blank. Skipping."
	      );
	  }



	System.out.println("Clicked outside Booking Details.");
	        // =====================================================
	        // 5. EMPLOYEE DETAILS
	        // =====================================================
//	if (Traveller != null
//	        && Traveller.equalsIgnoreCase("Employee")) {
//
//
//    String employeeEmail = data.getEmployeedetails();
//System.out.println("Traveller = " + Traveller);
//System.out.println("Employee details from Excel = "
//        + data.getEmployeedetails());
//    if (employeeEmail == null || employeeEmail.trim().isEmpty()) {
//        throw new IllegalArgumentException(
//                "Employee details is blank in Excel.");
//    }
//
//    employeeEmail = employeeEmail.trim();
//    if (webdriverutility.isElementDisplayed(EmployeeDetailsTextbox)) {
//    wait.until(ExpectedConditions.elementToBeClickable(
//            EmployeeDetailsTextbox));
//
//    EmployeeDetailsTextbox.click();
//    EmployeeDetailsTextbox.clear();
//    EmployeeDetailsTextbox.sendKeys(employeeEmail);
//    ReportUtil.logIfNotBlank(
//    	    "Employee Details : ", employeeEmail);
//    ReportUtil.attachFullPageScreenshot(
//            driver,
//            "Search data is entered"
//    );
//
//    System.out.println("Employee details entered: " + employeeEmail);
//	            By employeeSuggestion = By.xpath(
//	                    "//mat-option[@role='option']"
//	                  + "[.//*[contains(normalize-space(),'"
//	                  + employeeEmail
//	                  + "')]]"
//	            );
//
//	            webdriverutility.clickWithRetry(
//	                    employeeSuggestion
//	            );
//	        }
//}
	      
	if (Traveller.equalsIgnoreCase("Employee")) {

	    String employeeEmail = data.getEmployeedetails();

	    if (employeeEmail != null
	            && !employeeEmail.trim().isEmpty()) {

	        employeeEmail = employeeEmail.trim();

	        if (webdriverutility.isElementDisplayed(
	                EmployeeDetailsTextbox)) {

	            wait.until(ExpectedConditions.elementToBeClickable(
	                    EmployeeDetailsTextbox));

	            EmployeeDetailsTextbox.click();
	            EmployeeDetailsTextbox.clear();
	            EmployeeDetailsTextbox.sendKeys(employeeEmail);

	            ReportUtil.logIfNotBlank(
	                    "Employee Details : ",
	                    employeeEmail
	            );

	            ReportUtil.attachFullPageScreenshot(
	                    driver,
	                    "Search data is entered"
	            );

	            By employeeSuggestion = By.xpath(
	                    "//mat-option[@role='option']"
	                    + "[.//*[contains(normalize-space(),'"
	                    + employeeEmail + "')]]"
	            );

	            webdriverutility.clickWithRetry(employeeSuggestion);
	        }

	    } else {

	        System.out.println(
	                "Employee Details blank. Skipping employee details."
	        );
	    }
	}


	        // =====================================================
	        // 6. WAIT FOR SEARCH BUTTON
	        // =====================================================

	        webdriverutility.waitForVisibility(
	                SearchFlightbtn
	        );
	        ReportUtil.attachFullPageScreenshot(
	                driver,
	                "Search data is entered"
	        );
	     

	        Thread.sleep(7000);


	        // =====================================================
	        // 7. CLICK SEARCH FLIGHT
	        // =====================================================

	        clickSearchButton();

//	        Actions actions = new Actions(driver);
//
//	        actions
//	                .moveToElement(SearchFlightbtn)
//	                .pause(Duration.ofMillis(500))
//	                .click()
//	                .perform();
	        // =====================================================
	        // 8. RESULT PAGE FLOW
	        // =====================================================

	        if (tripType.equalsIgnoreCase("Multi-city")) {

	            // =================================================
	            // MULTI-CITY RESULT PAGE
	            // =================================================

	            System.out.println("========================================");
	            System.out.println("MULTI-CITY RESULT FLOW");
	            System.out.println("========================================");

	            handleMultiCityResultFlow();


	            // =================================================
	            // AFTER SELECT & CONTINUE
	            // WE ARE ON PASSENGER PAGE
	            // =================================================

	            System.out.println(
	                    "Multi-city passenger page opened."
	            );


	            // =================================================
	            // EMPLOYEE + FAMILY TRIP
	            // =================================================

	            if (Traveller.equalsIgnoreCase("Employee")
	                    && tripCategory.equalsIgnoreCase("Family trip") || tripCategory.equalsIgnoreCase("Family trip")){

	                System.out.println(
	                        "Employee + Family Trip detected."
	                );

	                System.out.println(
	                        "Waiting for Dependent section..."
	                );

	             


	                // ---------------------------------------------
	                // ADD DEPENDENTS FROM EXCEL
	                // ---------------------------------------------
Thread.sleep(3000);
	                Adddependent(data);

	                System.out.println(
	                        "Multi-city dependents completed successfully."
	                );
	            }


	            // =================================================
	            // GUEST TRAVELER
	            // =================================================

	            else if (Traveller.equalsIgnoreCase("Guest traveler")) {

	                System.out.println(
	                        "Guest traveler detected."
	                );

	             Thread.sleep(3000)	  ;              Adultdetails(data);
	            }


	            // =================================================
	            // CONTINUE TO PAYMENT
	            // =================================================

	            System.out.println(
	                    "Waiting for Continue to Payment..."
	            );

	            WebDriverWait paymentWait =
	                    new WebDriverWait(
	                            driver,
	                            Duration.ofSeconds(120)
	                    );

	            paymentWait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            ContinueToPaymentBtn
	                    )
	            );

	            System.out.println(
	                    "Continue to Payment is clickable."
	            );

	            ReportUtil.logPass(
	                    "Passenger/Dependent details completed"
	            );

	            Thread.sleep(3000);

	            webdriverutility.click(
	                    ContinueToPaymentBtn
	            );

	            System.out.println(
	                    "Continue to Payment clicked."
	            );
	        }


	        // =====================================================
	        // 9. ONE WAY / ROUND TRIP RESULT FLOW
	        // =====================================================

	        else {

	            handleNormalFareFlow(tripType);


	            // =================================================
	            // PASSENGER PAGE
	            // =================================================

	            System.out.println(
	                    "Passenger page opened."
	            );


	            // =================================================
	            // EMPLOYEE + FAMILY TRIP
	            // =================================================

//	            if (Traveller.equalsIgnoreCase("Employee")
//	                    && tripCategory.equalsIgnoreCase("Family trip")) {
//
//	                System.out.println(
//	                        "Employee + Family Trip detected."
//	                );
//
//	              Thread.sleep(3000);
//
//	                Adddependent(data);
//	            }

	         // FAMILY TRIP - ADD SAVED DEPENDENTS

	            if (tripCategory.equalsIgnoreCase("Family trip")) {

	                System.out.println("Family Trip detected.");

	                Thread.sleep(3000);

	                String dependentNames = data.getdependentName();

	                if (dependentNames != null
	                        && !dependentNames.trim().isEmpty()) {

	                    System.out.println("Adding saved dependents from Excel.");

	                    Adddependent(data);

	                    System.out.println(
	                            "All saved dependents added successfully."
	                    );

	                } else {

	                    System.out.println(
	                            "Dependent name is blank. Skipping dependent selection."
	                    );
	                }
	            }
	            // =================================================
	            // GUEST TRAVELER
	            // =================================================

	            else if (Traveller.equalsIgnoreCase("Guest traveler")) {

	                Adultdetails(data);
	            }
	            
	            else if (Traveller.equalsIgnoreCase(" Multiple travelers ")) {

	                Adultdetails(data);
	            }
	            

	            // =================================================
	            // CONTINUE TO PAYMENT
	            // =================================================

	            webdriverutility.waitForVisibility(
	                    ContinueToPaymentBtn
	            );

	            ReportUtil.attachFullPageScreenshot(driver,  "Passenger details completed");

	            Thread.sleep(8000);

	            webdriverutility.click(
	                    ContinueToPaymentBtn
	            );
	        }


	        // =====================================================
	        // 10. PAYMENT PAGE
	        // =====================================================

	        webdriverutility.scrollToBottom();

	        String parentWindow =
	                driver.getWindowHandle();


	        // =====================================================
	        // 11. SELECT PAYMENT METHOD
	        // =====================================================

	        selectPaymentMethod(data);

	      


	        try {

	            Thread.sleep(2000);

	        } catch (InterruptedException e) {

	            Thread.currentThread().interrupt();
	        }


	        // =====================================================
	        // 12. HANDLE NEW WINDOW
	        // =====================================================

	        if (driver.getWindowHandles().size() > 1) {

	            for (String window :
	                    driver.getWindowHandles()) {

	                if (!window.equals(parentWindow)) {

	                    driver.switchTo().window(window);

	                    System.out.println(
	                            "New window found: "
	                                    + driver.getCurrentUrl()
	                    );

	                    driver.close();

	                    System.out.println(
	                            "New window closed."
	                    );

	                    break;
	                }
	            }

	            driver.switchTo().window(parentWindow);
	        }


	        // =====================================================
	        // 13. BOOKING CONFIRMATION
	        // =====================================================

	        By bookingConfirmed = By.xpath(
	                "//*[normalize-space()='Booking confirmed']"
	        );

	        WebDriverWait wait1 =
	                new WebDriverWait(
	                        driver,
	                        Duration.ofSeconds(120)
	                );

	        wait1.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        bookingConfirmed
	                )
	        );

	        System.out.println(
	                "Booking confirmed successfully."
	        );


	        // =====================================================
	        // 14. GET PNR
	        // =====================================================

	        WebElement pnrElement =
	                wait1.until(
	                        ExpectedConditions.visibilityOfElementLocated(
	                                bookingReference
	                        )
	                );

	        String pnr =
	                pnrElement.getText().trim();

	        System.out.println(
	                "PNR = " + pnr
	        );

	        Assert.assertFalse(
	                pnr.isEmpty(),
	                "PNR was not generated."
	        );

	    }
	private void handleNormalFareFlow(
	        String tripType) throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(
	                    driver,
	                    Duration.ofSeconds(90)
	            );


	    // =====================================================
	    // WAIT FOR FLIGHT RESULTS
	    // =====================================================

	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    allExpandFareBtns
	            )
	    );


	    System.out.println(
	            "Flight results loaded."
	    );


	    printAllExpandButtons();

	    clickExpandButton(0);


	    System.out.println(
	            "Flight 0 expanded."
	    );

	    System.out.println(
	            "Waiting for Basic fare..."
	    );


	    // =====================================================
	    // BASIC FARE
	    // =====================================================

	    WebDriverWait fareWait =
	            new WebDriverWait(
	                    driver,
	                    Duration.ofSeconds(120)
	            );


	    fareWait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    basicFareSelectBtn
	            )
	    );


	    System.out.println(
	            "Basic fare displayed."
	    );


	    ReportUtil.attachFullPageScreenshot(
	            driver,
	            "Result page is dipalyed"
	    );


	    webdriverutility.click(
	            basicFareSelectBtn
	    );


	    // =====================================================
	    // ROUND TRIP - SECOND FLIGHT
	    // =====================================================

	    if (tripType.equalsIgnoreCase("Round trip")) {

	        Thread.sleep(3000);

	        printAllExpandButtons();

	        clickExpandButton(0);

	        Thread.sleep(2000);

	        webdriverutility.waitForVisibility(
	                basicFareSelectBtn
	        );

	        webdriverutility.clickWithRetry(
	                basicFareSelectBtn
	        );
	    }


	    // =====================================================
	    // CONTINUE TO PASSENGER
	    // =====================================================

	    WebDriverWait wait3 =
	            new WebDriverWait(
	                    driver,
	                    Duration.ofSeconds(120)
	            );


	    wait3.until(
	            ExpectedConditions.elementToBeClickable(
	                    ContinueToPassengerBtn
	            )
	    );


	    System.out.println(
	            "Continue to Passenger is clickable."
	    );


	    webdriverutility.click(
	            ContinueToPassengerBtn
	    );


	    System.out.println(
	            "Passenger page opened."
	    );
	}	
	
	
private void handleMultiCityResultFlow() throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(
	                    driver,
	                    Duration.ofSeconds(60)
	            );


	    System.out.println(
	            "========================================"
	    );

	    System.out.println(
	            "       MULTI-CITY RESULT FLOW"
	    );

	    System.out.println(
	            "========================================"
	    );


	    // =====================================================
	    // 1. WAIT FOR SELECT TRIP
	    // =====================================================

	    System.out.println(
	            "Waiting for Select Trip button..."
	    );

	    WebElement selectTrip =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            SelectTripbtn
	                    )
	            );

	    System.out.println(
	            "Select Trip button is visible."
	    );


	    // Scroll
	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            selectTrip
	    );

	    Thread.sleep(1000);


	    // =====================================================
	    // 2. CLICK SELECT TRIP
	    // =====================================================

	    try {

	        selectTrip.click();

	    } catch (ElementClickInterceptedException e) {

	        System.out.println(
	                "Select Trip normal click intercepted."
	        );

	        System.out.println(
	                "Using JavaScript click."
	        );

	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].click();",
	                selectTrip
	        );
	    }


	    System.out.println(
	            "Select Trip clicked successfully."
	    );


	    // =====================================================
	    // 3. WAIT FOR SELECT & CONTINUE
	    // =====================================================

	    System.out.println(
	            "Waiting for Select & Continue button..."
	    );


	    WebElement selectContinue =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            selectAndContinueBtn
	                    )
	            );


	    System.out.println(
	            "Select & Continue button is visible."
	    );


	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            selectContinue
	    );

	    Thread.sleep(1000);


	    // =====================================================
	    // 4. CLICK SELECT & CONTINUE
	    // =====================================================

	    try {

	        selectContinue.click();

	    } catch (ElementClickInterceptedException e) {

	        System.out.println(
	                "Select & Continue normal click intercepted."
	        );

	        System.out.println(
	                "Using JavaScript click."
	        );

	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].click();",
	                selectContinue
	        );
	    }


	    System.out.println(
	            "Select & Continue clicked successfully."
	    );


	    


	    Thread.sleep(3000);

	    System.out.println(
	            "Multi-city passenger page loading..."
	    );
	}

	public void MultiCityDetails(FlightBookingData data) throws Throwable {

	    System.out.println("===== MULTI CITY BOOKING STARTED =====");

	    // =====================================================
	    // SEGMENT 1
	    // =====================================================

	    System.out.println("----- SEGMENT 1 -----");

	    System.out.println("From : " + data.getFrom());
	    System.out.println("To   : " + data.getTo());
	    System.out.println("Date : " + data.getDeparturedate());

	    selectDeparturecity(data);

	    Thread.sleep(2000);

	    selectArrivalcity(data);

	    Thread.sleep(5000);

	    webdriverutility.selectPikadayDate(
	            DepartureCalendaricon,
	            departureDateInput,
	            data.getDeparturedate(),
	            false,
	            null
	    );
	    new Actions(driver)
        .moveToElement(EmployeeDetailsTextbox)
        .perform();

System.out.println("Mouse moved away from calendar.");

	    // =====================================================
	    // ADDITIONAL SEGMENTS FROM EXCEL
	    // =====================================================

	    String[] toCities =
	            data.getMultiCityTo().split(";");

	    String[] dates =
	            data.getMultiCityDepartureDate().split(";");


	    // =====================================================
	    // VALIDATE DATA
	    // =====================================================
webdriverutility.click(acceptCookieBtn);
	    if (toCities.length != dates.length) {

	        throw new RuntimeException(
	                "Multi-city data mismatch. " +
	                "Destinations = " + toCities.length +
	                ", Dates = " + dates.length
	        );
	    }


	    // =====================================================
	    // SEGMENT 2 / SEGMENT 3
	    // =====================================================

	    for (int i = 0; i < toCities.length; i++) {

	        String destination = toCities[i].trim();

	        String date = dates[i].trim();

	        int segmentNumber = i + 2;


	        System.out.println(
	                "----- SEGMENT " + segmentNumber + " -----"
	        );

	        System.out.println(
	                "To   : " + destination
	        );

	        System.out.println(
	                "Date : " + date
	        );


	        // =================================================
	        // SEGMENT 2
	        // =================================================

	        if (segmentNumber == 2) {

	            selectCity(
	                    secondTotxtBox,
	                    destination
	            );

	            webdriverutility.selectPikadayDate(
	                    DepartureCalendaricon2,
	                    departureDateInput2,
	                    date,
	                    false,
	                    data.getDeparturedate()
	            );
	        }


	        // =================================================
	        // SEGMENT 3
	        // =================================================

	        else if (segmentNumber == 3) {

	            // ---------------------------------------------
	            // CLICK ADD FLIGHT
	            // ---------------------------------------------

	            System.out.println("Adding Segment 3...");

	            WebDriverWait wait =
	                    new WebDriverWait(driver, Duration.ofSeconds(20));

	            wait.until(
	                    ExpectedConditions.elementToBeClickable(AddFlightbtn)
	            );

	            AddFlightbtn.click();

	            System.out.println("Add Flight clicked successfully");


	            // ---------------------------------------------
	            // WAIT FOR SEGMENT 3 TO APPEAR
	            // ---------------------------------------------

	            wait.until(
	                    ExpectedConditions.visibilityOf(thirdTotxtBox)
	            );

	            System.out.println("Segment 3 opened successfully");


	            // ---------------------------------------------
	            // SELECT SEGMENT 3 DESTINATION
	            // ---------------------------------------------

	            selectCity(
	                    thirdTotxtBox,
	                    destination
	            );


	            // ---------------------------------------------
	            // SELECT SEGMENT 3 DATE
	            // ---------------------------------------------

	            webdriverutility.selectPikadayDate(
	                    DepartureCalendaricon3,
	                    departureDateInput3,
	                    date,
	                    false,
	                    dates[i - 1]
	            );
	        }
	        
	    }


	    System.out.println(
	            "===== MULTI CITY BOOKING COMPLETED ====="
	    );
//	    webdriverutility.click(SelectTripbtn);
//	    
//	    Thread.sleep(5000);
//	    webdriverutility.click(selectAndContinueBtn);
	}
	public void TripType(FlightBookingData data) throws Throwable {

		String tripdetails = data.getTripType().trim();

		System.out.println("===== SELECTING TRIP TYPE: " + tripdetails + " =====");

		if (tripdetails.equalsIgnoreCase("Round trip")) {

			webdriverutility.click(roundTripRadioBtn);

			Thread.sleep(2000);

		} else if (tripdetails.equalsIgnoreCase("One way")) {

			webdriverutility.click(OnewayRadiobtn);

			Thread.sleep(2000);

		} else if (tripdetails.equalsIgnoreCase("Multi-city")) {

			webdriverutility.click(MulticityRadioBtn);

			Thread.sleep(2000);

		} else {

			throw new IllegalArgumentException("Unsupported trip type: " + tripdetails);
		}
	}

	public void selectDeparturecity(FlightBookingData data) throws Throwable {

		selectCity(FromTxtbox, data.getFrom());
	}

	public void selectArrivalcity(FlightBookingData data) throws Throwable {

		selectCity(TotxtBox, data.getTo());
	}

public void TravellerType(FlightBookingData data) throws Throwable {
	
	

    String traveller = data.getTravellerType().trim();
    String tripCategory = data.getTripCategory().trim();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    System.out.println("Traveller    = " + traveller);
    System.out.println("TripCategory = " + tripCategory);

    // 1. Open Booking Details
    wait.until(ExpectedConditions.elementToBeClickable(TravelCalssDropdown));
    webdriverutility.click(TravelCalssDropdown);

    // 2. Select Traveller Type
    if (traveller.equalsIgnoreCase("Employee")) {

        wait.until(ExpectedConditions.elementToBeClickable(EmployeeRadiobtn));
        webdriverutility.click(EmployeeRadiobtn);

        System.out.println("Employee selected.");

    } else if (traveller.equalsIgnoreCase("Multiple travelers")) {

        wait.until(ExpectedConditions.elementToBeClickable(MultipleTravellerRadioBtn));
        webdriverutility.click(MultipleTravellerRadioBtn);

        System.out.println("Multiple travelers selected.");

    } else if (traveller.equalsIgnoreCase("Guest traveler")) {

        WebElement guestRadio = wait.until(
        		
                ExpectedConditions.elementToBeClickable(guestTravelerRadio));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", guestRadio);

        System.out.println("Guest traveler selected.");

        // Guest traveler: Business trip is selected automatically.
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[normalize-space()='Business trip']")));

        // Apply Selection
        WebElement applySelection = wait.until(
                ExpectedConditions.elementToBeClickable(ApplySelectionBtn ));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                applySelection);

		
        applySelection.click();
//
//        System.out.println(
//                tripCategory + ": Apply Selection clicked.");
//
//        // Wait until Booking Details panel closes
//        wait.until(
//                ExpectedConditions.attributeToBe(
//                        TravelCalssDropdown,
//                        "aria-expanded",
//                        "false"
//                )
//        );
      
//        wait.until(ExpectedConditions.elementToBeClickable(
//                PassengerDetailDropdown
//        ));
//
//        webdriverutility.click(PassengerDetailDropdown);
//        System.out.println("Booking Details panel closed.");   
        boolean passengerPanelOpen =
                driver.findElements(By.xpath(
                    "//div[contains(@class,'age-details')]"
                    + "[.//p[normalize-space()='Adults']]"
                    + "//button"
                )).stream().anyMatch(WebElement::isDisplayed);

        if (!passengerPanelOpen) {

            WebElement passengerDropdown = wait.until(
                    ExpectedConditions.visibilityOf(PassengerDetailDropdown)
            );

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    passengerDropdown
            );

            try {

                wait.until(ExpectedConditions.elementToBeClickable(
                        PassengerDetailDropdown
                ));

                PassengerDetailDropdown.click();

            } catch (ElementClickInterceptedException e) {

                System.out.println(
                        "Normal click intercepted. Trying JavaScript click."
                );

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();",
                        PassengerDetailDropdown
                );
            }
        }

        // Wait until passenger controls are actually visible
        wait.until(ExpectedConditions.visibilityOf(adultPlusBtn));

        System.out.println("Passengers and cabin opened successfully.");
        // Open Passengers and Cabin
        wait.until(ExpectedConditions.elementToBeClickable(
                PassengerDetailDropdown));

        webdriverutility.click(PassengerDetailDropdown);

        System.out.println("Passengers and cabin opened.");

        // Select Adult Count
        
        
        
        
        
        int adults = parsePassengerCount(data.getAdults());

        System.out.println("Guest adults = " + adults);

        if (adults < 1) {
            throw new IllegalArgumentException(
                    "Guest traveler must have at least one adult.");
        }

        if (adults > 1) {
        	wait.until(ExpectedConditions.elementToBeClickable(adultPlusBtn));

            webdriverutility.clickMultipleTimes(
                    adultPlusBtn, adults - 1);
        }

        // Continue
        wait.until(ExpectedConditions.visibilityOf(Continuebtn));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                Continuebtn);

        wait.until(ExpectedConditions.elementToBeClickable(Continuebtn));
        Continuebtn.click();

        System.out.println(
                "Guest traveler passenger selection completed successfully.");

        return;

    } else {
        throw new IllegalArgumentException(
                "Invalid Traveller Type: " + traveller);
    }

    // 3. Employee and Multiple Travelers: Select Trip Category
    
  
   
By tripCategoryLocator;

if (tripCategory.equalsIgnoreCase("Business trip")) {

    tripCategoryLocator = BusinessTripRadioBtn;

} else if (tripCategory.equalsIgnoreCase("Family trip")) {

    tripCategoryLocator = FamilyTripRadioBtn;

} else {

    throw new IllegalArgumentException(
            "Invalid Trip Category: " + tripCategory);
}
wait.until(ExpectedConditions.elementToBeClickable(
        TravelCalssDropdown));

webdriverutility.click(TravelCalssDropdown);


WebElement categoryRadio = wait.until(
        ExpectedConditions.elementToBeClickable(
                tripCategoryLocator));

((JavascriptExecutor) driver).executeScript(
        "arguments[0].click();", categoryRadio);

System.out.println("Trip category selected: " + tripCategory);
  




// 4. Apply Selection — common for both categories

WebElement applySelection = wait.until(
        ExpectedConditions.elementToBeClickable(
                ApplySelectionBtn));

((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        applySelection);

applySelection.click();


System.out.println(
        tripCategory + ": Apply Selection clicked."
);

// Wait for Booking Details panel to close
wait.until(ExpectedConditions.invisibilityOfElementLocated(
        By.xpath("//mat-radio-button[.//*[normalize-space()='Business trip']]")
));

System.out.println("Booking Details closed.");

//Close any open calendar by clicking outside the popup
((JavascriptExecutor) driver).executeScript(
     "document.body.click();"
);

System.out.println("Clicked outside the calendar.");

//Close Booking Details only if it is still open
//boolean categoryStillVisible =
//     driver.findElements(tripCategoryLocator)
//           .stream()
//           .anyMatch(WebElement::isDisplayed);
//
//if (categoryStillVisible) {
//
// webdriverutility.click(TravelCalssDropdown);
//
// wait.until(
//         ExpectedConditions.invisibilityOfElementLocated(
//                 tripCategoryLocator)
// );
//
// System.out.println("Booking Details closed.");
//
//} else {
// System.out.println("Booking Details already closed.");
//}
//Verify Employee Details field
WebElement employeeDetails = wait.until(
 ExpectedConditions.visibilityOfElementLocated(
     By.xpath(
         "//mat-form-field[.//label[contains(normalize-space(.),'Employee details')]]"
     )
 )
);

System.out.println(
 "Employee Details visible = "
 + employeeDetails.isDisplayed()
);
////Close Booking Details only if it is still open
//if (driver.findElements(BusinessTripRadioBtn)
//       .stream()
//       .anyMatch(WebElement::isDisplayed)) {
//
// webdriverutility.click(TravelCalssDropdown);
//
// wait.until(
//     ExpectedConditions.invisibilityOfElementLocated(
//         BusinessTripRadioBtn
//     )
// );
//
// System.out.println("Booking Details closed.");
//}
// 5. Read Passenger Counts from Excel
if (traveller.equalsIgnoreCase("Employee")
        && tripCategory.equalsIgnoreCase("Family trip")) {

int adults = parsePassengerCount(data.getAdults());
int children = parsePassengerCount(data.getChildren());
int infants = parsePassengerCount(data.getInfant());

System.out.println("Adults   = " + adults);
System.out.println("Children = " + children);
System.out.println("Infants  = " + infants);
wait.until(ExpectedConditions.elementToBeClickable(
        PassengerDetailDropdown));
webdriverutility.click(PassengerDetailDropdown);


if (adults < 1 || children < 0 || infants < 0) {
    throw new IllegalArgumentException(
            "Invalid passenger counts in Excel.");
}

// 6. Open Passengers and Cabin


System.out.println("Passengers and cabin opened.");


//7. Select Adults
if (adults > 1) {
	   wait.until(ExpectedConditions.elementToBeClickable(adultPlusBtn));
       webdriverutility.clickMultipleTimes(adultPlusBtn, adults - 1);
}

System.out.println("Adult count handled: " + adults);
// 8. Select Children

if (children > 0) {
	 wait.until(ExpectedConditions.elementToBeClickable(childPlusBtn));
     webdriverutility.clickMultipleTimes(childPlusBtn, children);
}

// 9. Select Infants

if (infants > 0) {
	  wait.until(ExpectedConditions.elementToBeClickable(infantLapPlusBtn));
      webdriverutility.clickMultipleTimes(infantLapPlusBtn, infants);
}

// 10. Click Continue

wait.until(ExpectedConditions.visibilityOf(Continuebtn));

((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        Continuebtn);

wait.until(ExpectedConditions.elementToBeClickable(Continuebtn));

Continuebtn.click();

System.out.println(
        tripCategory + ": Passenger selection completed successfully.");

} else {
    System.out.println("Passenger count increase skipped for: "
            + traveller + " + " + tripCategory);
}
	 // =========================================================
	 // GUEST TRAVELER
	 // =========================================================

	 if (traveller.equalsIgnoreCase("Guest traveler")) {

	     System.out.println(
	             "===== GUEST TRAVELER SELECTION STARTED ====="
	     );

	     WebDriverWait wait2=
	             new WebDriverWait(driver, Duration.ofSeconds(30));

	     // ---------------------------------------------------------
	     // 1. OPEN BOOKING DETAILS
	     // ---------------------------------------------------------

	     wait2.until(
	             ExpectedConditions.elementToBeClickable(
	                     TravelCalssDropdown
	             )
	     );

	     ((JavascriptExecutor) driver).executeScript(
	             "arguments[0].scrollIntoView({block:'center'});",
	             TravelCalssDropdown
	     );

	     TravelCalssDropdown.click();

	     System.out.println(
	             "Traveller dropdown opened."
	     );

	     // ---------------------------------------------------------
	     // 2. SELECT GUEST TRAVELER
	     // ---------------------------------------------------------

	    //  By guestTravelerRadio = By.xpath(
	    //          "//mat-radio-button[.//*[normalize-space()='Guest traveler']]"
	    //  );

	     WebElement guestRadio = wait.until(
	             ExpectedConditions.visibilityOfElementLocated(
	                     guestTravelerRadio
	             )
	     );

	     ((JavascriptExecutor) driver).executeScript(
	             "arguments[0].scrollIntoView({block:'center'});",
	             guestRadio
	     );

	     wait.until(
	             ExpectedConditions.elementToBeClickable(
	                     guestTravelerRadio
	             )
	     );

	     ((JavascriptExecutor) driver).executeScript(
	             "arguments[0].click();",
	             guestRadio
	     );

	     System.out.println(
	             "Guest traveler selected."
	     );

	     // ---------------------------------------------------------
	     // 3. BUSINESS TRIP
	    
	     By businessTripText = By.xpath(
	             "//*[normalize-space()='Business trip']"
	     );

	     wait.until(
	             ExpectedConditions.visibilityOfElementLocated(
	                     businessTripText
	             )
	     );

	     System.out.println(
	             "Business trip is displayed automatically."
	     );

	   
	     // ---------------------------------------------------------
	     // 5. OPEN PASSENGERS AND CABIN
	     // ---------------------------------------------------------

	     wait.until(ExpectedConditions.invisibilityOfElementLocated(
	    	        By.xpath("//div[contains(@class,'calendar-popup') " +
	    	                 "and contains(@class,'homepageCalender')]")
	    	));

	    	wait.until(ExpectedConditions.elementToBeClickable(
	    	        PassengerDetailDropdown
	    	));

	    	webdriverutility.click(PassengerDetailDropdown);

	     System.out.println(
	             "Passengers and cabin opened."
	     );

	     // ---------------------------------------------------------
	     // 6. ADULT COUNT
	     // ---------------------------------------------------------

	    //  int adults = Integer.parseInt(
	    //          data.getAdults().trim()
	    //  );
	     int adults = parsePassengerCount(data.getAdults());
	     System.out.println(
	             "No. of adults: " + adults
	     );

	     if (adults > 1) {

	         wait.until(
	                 ExpectedConditions.visibilityOf(
	                         adultPlusBtn
	                 )
	         );

	         webdriverutility.clickMultipleTimes(
	                 adultPlusBtn,
	                 adults - 1
	         );

	         System.out.println(
	                 "Additional adults selected: "
	                 + (adults - 1)
	         );
	     }

	     // ---------------------------------------------------------
	     // 7. CONTINUE
	     // ---------------------------------------------------------

	     wait.until(
	             ExpectedConditions.visibilityOf(
	                     Continuebtn
	             )
	     );

	     ((JavascriptExecutor) driver).executeScript(
	             "arguments[0].scrollIntoView({block:'center'});",
	             Continuebtn
	     );

	     wait.until(
	             ExpectedConditions.elementToBeClickable(
	                     Continuebtn
	             )
	     );

	     Continuebtn.click();

	     System.out.println(
	             "Guest traveler passenger selection completed successfully."
	     );
	 }
	 }
	private int parsePassengerCount(String value) {
    if (value == null || value.trim().isEmpty()) {
        return 0;
    }
    return Integer.parseInt(value.trim());
}

	private void selectCity(WebElement cityTextbox, String city) throws Throwable {

		String cleanCity = city.replace('\u00A0', ' ').replaceAll("\\s+", " ").trim();

		String cityName = cleanCity.split(",")[0].trim();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// 1. Wait for textbox
		wait.until(ExpectedConditions.visibilityOf(cityTextbox));

		// 2. Scroll textbox into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", cityTextbox);

		// 3. Click textbox
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cityTextbox);

		// 4. Clear existing value
		cityTextbox.clear();

		// 5. Enter city
		cityTextbox.sendKeys(cityName);

		System.out.println("Entered city: " + cityName);

		// 6. Locate ONLY the autocomplete suggestion
		By citySuggestion = By.xpath("//div[contains(@class,'cdk-overlay-pane')]" + "//mat-option[@role='option']"
				+ "[.//div[contains(@class,'custom-combobox__label')" + " and starts-with(normalize-space(.),'"
				+ cityName + "')]]");

		// 7. Wait until suggestion is visible
		WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(citySuggestion));

		System.out.println("Suggestion found: " + suggestion.getText());

		// 8. Scroll suggestion into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", suggestion);

		Thread.sleep(500);

		String suggestionText = suggestion.getText();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", suggestion);

		System.out.println("Suggestion clicked: " + suggestionText);

		// 10. Wait until autocomplete disappears / value is populated
		wait.until(driver -> {

			String value = cityTextbox.getAttribute("value");

			return value != null && !value.trim().isEmpty() && value.toLowerCase().startsWith(cityName.toLowerCase());
		});

		// 11. Verify selected value
		String actualValue = cityTextbox.getAttribute("value");

		if (actualValue == null || actualValue.trim().isEmpty()) {

			throw new RuntimeException(
					"City was NOT selected. " + "Expected: " + cleanCity + " | Actual: " + actualValue);
		}

		System.out.println("City selected successfully: " + actualValue);

	}

	public void Adultdetails(FlightBookingData data) throws Throwable {

		int adults = Integer.parseInt(data.getAdults().trim());

		webdriverutility.selectMatOptionByVisibleText(AdultTitleDropdown, data.getAdult1Title().trim());

		Thread.sleep(3000);

		webdriverutility.sendKeys(FirstNameTextBox, data.getAdult1FirstName().trim());

		Thread.sleep(3000);

		webdriverutility.sendKeys(LastNameTextBox, data.getAdult1LastName().trim());

		Thread.sleep(3000);

		webdriverutility.selectDateAndConfirm(DOBInputTextbox, data.getAdult1DOB().trim());

		Thread.sleep(3000);

		webdriverutility.selectNgOptionByVisibleText(NationalityDropdown, data.getAdult1Nationality());

		Thread.sleep(3000);

		webdriverutility.sendKeys(PasspoertTextBox, data.getAdult1PassportNumber().trim());

		Thread.sleep(3000);

		webdriverutility.selectPassportExpiryDate(ExpiryDateInput, data.getAdult1PassportExpiry().trim());

		Thread.sleep(3000);

		webdriverutility.selectNgOptionByVisibleText(IssueCountryDropdown, data.getAdult1Issuingcountry().trim());

		Thread.sleep(5000);

		if (adults > 1) {

			webdriverutility.click(NextPassengerBtn);

			// Wait for Adult 2 form
			Thread.sleep(8000);
			webdriverutility.selectMatOptionByVisibleText(AdultTitleDropdown, data.getAdult2Title().trim());

			Thread.sleep(3000);

			webdriverutility.sendKeys(FirstNameTextBox, data.getAdult2FirstName().trim());

			Thread.sleep(3000);

			webdriverutility.sendKeys(LastNameTextBox, data.getAdult2LastName().trim());

			Thread.sleep(3000);

			webdriverutility.selectDateAndConfirm(DOBInputTextbox, data.getAdult2DOB().trim());

			Thread.sleep(1000);

			// Adult 2 Nationality
			webdriverutility.selectNgOptionByVisibleText(NationalityDropdown, data.getAdult2Nationality().trim());

			Thread.sleep(1000);

			// Adult 2 Passport
			webdriverutility.sendKeys(PasspoertTextBox, data.getAdult2PassportNumber().trim());

			Thread.sleep(1000);

			// Adult 2 Passport Expiry
			webdriverutility.selectPassportExpiryDate(ExpiryDateInput, data.getAdult2PassportExpiry().trim());

			Thread.sleep(1000);

			// Adult 2 Issuing Country
			webdriverutility.selectNgOptionByVisibleText(IssueCountryDropdown, data.getAdult2Issuingcountry().trim());

			Thread.sleep(2000);

			webdriverutility.click(AdultApplyselectionbtn);
		} else {
			webdriverutility.click(AdultApplyselectionbtn);
		}

	}

	public void selectTripCategory(FlightBookingData data)
	        throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(60));

	    String tripCategory = data.getTripCategory().trim();

	    // 1. Close calendar popup
	   
	    ((JavascriptExecutor) driver).executeScript(
	            "document.body.click();"
	    );


	    System.out.println("Calendar popup closed.");

	    // 2. Open Trip Type dropdown
	    By tripTypeDropdown = By.xpath(
	            "//mat-form-field[.//*[normalize-space()='Trip type']]"
	    );

	    WebElement dropdown = wait.until(
	            ExpectedConditions.elementToBeClickable(tripTypeDropdown)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            dropdown
	    );

	    dropdown.click();

	    System.out.println("Trip Type dropdown opened.");

	    // 3. Select category
	    By tripCategoryLocator;

	    if (tripCategory.equalsIgnoreCase("Business trip")) {

	        tripCategoryLocator = BusinessTripRadioBtn;

	    } else if (tripCategory.equalsIgnoreCase("Family trip")) {

	        tripCategoryLocator = FamilyTripRadioBtn;

	    } else {

	        throw new IllegalArgumentException(
	                "Invalid Trip Category: " + tripCategory
	        );
	    }

	    WebElement categoryRadio = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    tripCategoryLocator
	            )
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();",
	            categoryRadio
	    );

	    System.out.println("Selected category: " + tripCategory);

	    // 4. Apply selection
	    WebElement applySelection = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    ApplySelectionBtn
	            )
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            applySelection
	    );

	    applySelection.click();

	    // 5. Wait until category popup closes
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            tripCategoryLocator
	    ));

	    System.out.println(
	            tripCategory + " applied successfully."
	    );
	}


	
//	public void Adultdetails(FlightBookingData data) throws Throwable {
//
//	    int adults = Integer.parseInt(data.getAdults().trim());
//
//	    for (int i = 1; i <= adults; i++) {
//
//	        System.out.println("Filling Adult " + i);
//
//	        // Fill current adult details
//	        webdriverutility.selectMatOptionByVisibleText(
//	                AdultTitleDropdown,
//	                getAdultTitle(data, i));
//
//	        webdriverutility.sendKeys(
//	                FirstNameTextBox,
//	                getAdultFirstName(data, i));
//
//	        webdriverutility.sendKeys(
//	                LastNameTextBox,
//	                getAdultLastName(data, i));
//
//	        webdriverutility.selectDateAndConfirm(
//	                DOBInputTextbox,
//	                getAdultDOB(data, i));
//
//	        webdriverutility.selectNgOptionByVisibleText(
//	                NationalityDropdown,
//	                getAdultNationality(data, i));
//
//	        webdriverutility.sendKeys(
//	                PasspoertTextBox,
//	                getAdultPassport(data, i));
//
//	        webdriverutility.selectPassportExpiryDate(
//	                ExpiryDateInput,
//	                getAdultPassportExpiry(data, i));
//
//	        webdriverutility.selectNgOptionByVisibleText(
//	                IssueCountryDropdown,
//	                getAdultIssueCountry(data, i));
//
//	        // Move to next adult
//	        if (i < adults) {
//	            webdriverutility.click(NextPassengerBtn);
//	            Thread.sleep(2000);
//	        }
//	    }
//
//	    webdriverutility.click(AdultApplyselectionbtn);
//	}
	private void printAllExpandButtons() {

		List<WebElement> expandButtons = driver.findElements(allExpandFareBtns);

		System.out.println("Total expand buttons found = " + expandButtons.size());

		for (int i = 0; i < expandButtons.size(); i++) {

			WebElement button = expandButtons.get(i);

			System.out.println("Expand button [" + i + "]" + " | displayed = " + button.isDisplayed() + " | enabled = "
					+ button.isEnabled());
		}
	}

	private void clickExpandButton(int index) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		List<WebElement> expandButtons = wait.until(driver -> driver.findElements(allExpandFareBtns));

		System.out.println("Total expand buttons = " + expandButtons.size());

		if (index < 0 || index >= expandButtons.size()) {

			throw new RuntimeException(
					"Invalid expand button index: " + index + ". Total buttons found: " + expandButtons.size());
		}

		WebElement button = expandButtons.get(index);

		System.out.println("Clicking expand button index: " + index);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

		Thread.sleep(500);

		try {

			wait.until(ExpectedConditions.elementToBeClickable(button)).click();

		} catch (Exception e) {

			System.out.println("Normal click failed. Using JS click.");

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
		}

		System.out.println("Expand button [" + index + "] clicked successfully.");
	}
	public void clickSearchButton() throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(30));

	    By searchFlightBtn = By.xpath(
	            "//div[contains(@class,'submit-btn') "
	          + "and not(contains(@class,'submit-btn-mobile'))]"
	          + "//button[@type='submit' "
	          + "and .//span[normalize-space()='Search flights']]"
	    );

	    By calendarPopup = By.xpath(
	            "//div[contains(@class,'calendar-popup') "
	          + "and contains(@class,'homepageCalender')]"
	    );

	    By calendarContinueBtn = By.xpath(
	            "//div[contains(@class,'calendar-popup') "
	          + "and contains(@class,'homepageCalender')]"
	          + "//button[normalize-space()='Continue']"
	    );

	    // =====================================================
	    // 1. CHECK WHETHER CALENDAR IS STILL OPEN
	    // =====================================================

	    List<WebElement> calendars =
	            driver.findElements(calendarPopup);

	    if (!calendars.isEmpty()
	            && calendars.get(0).isDisplayed()) {

	        System.out.println(
	                "Calendar is still open. Closing calendar before Search."
	        );

	        WebElement continueButton =
	                wait.until(
	                        ExpectedConditions.elementToBeClickable(
	                                calendarContinueBtn
	                        )
	                );

	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView({block:'center'});",
	                continueButton
	        );

	        try {
	            continueButton.click();

	        } catch (ElementClickInterceptedException e) {

	            System.out.println(
	                    "Calendar Continue normal click intercepted. "
	                  + "Using JS click."
	            );

	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].click();",
	                    continueButton
	            );
	        }
	        System.out.println(
	                "Calendar Continue clicked."
	        );

	        // VERY IMPORTANT
	        wait.until(
	                ExpectedConditions.invisibilityOfElementLocated(
	                        calendarPopup
	                )
	        );

	        System.out.println(
	                "Calendar closed successfully."
	        );
	    }

	    // =====================================================
	    // 2. WAIT FOR LOADER / OVERLAY IF YOUR APPLICATION HAS ONE
	    // =====================================================

	    By loaderOverlay =
	            By.cssSelector("div.loader-overlay");

	    wait.until(
	            ExpectedConditions.invisibilityOfElementLocated(
	                    loaderOverlay
	            )
	    );

	    // =====================================================
	    // 3. RELOCATE SEARCH BUTTON
	    // =====================================================

	    WebElement searchButton =
	            wait.until(
	                    ExpectedConditions.refreshed(
	                            ExpectedConditions.elementToBeClickable(
	                                    searchFlightBtn
	                            )
	                    )
	            );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center', inline:'center'});",
	            searchButton
	    );

	    Thread.sleep(500);

	    // =====================================================
	    // 4. CLICK SEARCH
	    // =====================================================

	    try {

	        searchButton.click();

	        System.out.println(
	                "Search button clicked successfully."
	        );

	    } catch (ElementClickInterceptedException e) {

	        System.out.println(
	                "Search click intercepted. Re-locating and retrying..."
	        );

	        wait.until(
	                ExpectedConditions.invisibilityOfElementLocated(
	                        calendarPopup
	                )
	        );

	        wait.until(
	                ExpectedConditions.invisibilityOfElementLocated(
	                        loaderOverlay
	                )
	        );

	        WebElement freshSearchButton =
	                wait.until(
	                        ExpectedConditions.refreshed(
	                                ExpectedConditions.elementToBeClickable(
	                                        searchFlightBtn
	                                )
	                        )
	                );

	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
	                freshSearchButton
	        );

	        Thread.sleep(300);

	        freshSearchButton.click();

	        System.out.println(
	                "Search button clicked successfully after retry."
	        );
	    }
	}
	private void clickReview() throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement reviewButton = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//button[normalize-space()='Review']")
	            )
	    );

	    reviewButton.click();
ReportUtil.logPass("These Dependents are going to Add");
	    System.out.println("Review clicked.");
	}


	private void Adddependent(
	        String dependentNames,
	        String priorities) throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(30));

	    // =====================================================
	    // 1. ADD DEPENDENT BUTTON
	    // =====================================================

	    By addDependentLocator =
	            By.xpath("//button[contains(normalize-space(.),'Add dependent')]");

	    By loaderLocator =
	            By.cssSelector("div.loader-overlay");

	    System.out.println("========================================");
	    System.out.println("Waiting for Add dependent section...");
	    System.out.println("========================================");

	    // Wait until page loader disappears
	    wait.until(
	            ExpectedConditions.invisibilityOfElementLocated(
	                    loaderLocator
	            )
	    );

	    System.out.println("Loader disappeared.");

	    // Get fresh Add dependent button
	    WebElement addDependent =
	            wait.until(
	                    ExpectedConditions.refreshed(
	                            ExpectedConditions.elementToBeClickable(
	                                    addDependentLocator
	                            )
	                    )
	            );

	    System.out.println("Add dependent button is ready.");

	    // Scroll to button
	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            addDependent
	    );

	    Thread.sleep(500);

	    // Check loader again after scroll/render
	    wait.until(
	            ExpectedConditions.invisibilityOfElementLocated(
	                    loaderLocator
	            )
	    );

	    // Get fresh element again
	    addDependent =
	            wait.until(
	                    ExpectedConditions.refreshed(
	                            ExpectedConditions.elementToBeClickable(
	                                    addDependentLocator
	                            )
	                    )
	            );

	    // Click Add dependent
	    try {

	        addDependent.click();

	        System.out.println(
	                "Add dependent clicked successfully."
	        );

	    } catch (ElementClickInterceptedException e) {

	        System.out.println(
	                "Add dependent click intercepted."
	        );

	        System.out.println(
	                "Waiting for loader to disappear..."
	        );

	        // Wait for overlay to disappear
	        wait.until(
	                ExpectedConditions.invisibilityOfElementLocated(
	                        loaderLocator
	                )
	        );

	        // Re-locate fresh button
	        addDependent =
	                wait.until(
	                        ExpectedConditions.refreshed(
	                                ExpectedConditions.elementToBeClickable(
	                                        addDependentLocator
	                                )
	                        )
	                );

	        addDependent.click();

	        System.out.println(
	                "Add dependent clicked successfully after loader disappeared."
	        );
	    }

	    // =====================================================
	    // 2. WAIT FOR SAVED DEPENDENTS POPUP
	    // =====================================================

	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    savedDependentsPopup
	            )
	    );

	    System.out.println(
	            "Saved Dependents popup opened successfully."
	    );

	    // =====================================================
	    // 3. READ EXCEL DATA
	    // =====================================================

	    String[] names =
	            dependentNames.split(";");

	    String[] priorityList =
	            priorities.split(";");

	    // Validate names and priorities
	    if (names.length != priorityList.length) {

	        throw new RuntimeException(
	                "Dependent data mismatch. Names = "
	                        + names.length
	                        + ", Priorities = "
	                        + priorityList.length
	        );
	    }

	    // =====================================================
	    // 4. PROCESS EACH DEPENDENT
	    // =====================================================

	    for (int i = 0; i < names.length; i++) {

	        String name =
	                names[i].trim();

	        String priority =
	                priorityList[i].trim();

	        System.out.println("================================");
	        System.out.println(
	                "Processing name = " + name
	        );
	        System.out.println(
	                "Processing priority = " + priority
	        );
	        System.out.println("================================");

	        // =================================================
	        // SEARCH DEPENDENT
	        // =================================================

	        WebElement searchBox =
	                wait.until(
	                        ExpectedConditions.elementToBeClickable(
	                                dependentSearchBox
	                        )
	                );

	        searchBox.click();

	        searchBox.sendKeys(
	                Keys.CONTROL,
	                "a"
	        );

	        searchBox.sendKeys(
	                Keys.BACK_SPACE
	        );

	        Thread.sleep(300);

	        searchBox.sendKeys(name);

	        System.out.println(
	                "Entered search = " + name
	        );

	        // =================================================
	        // SELECT DEPENDENT FROM AUTOCOMPLETE
	        // =================================================

	        By dependentOption =
	                By.xpath(
	                        "//mat-option[@role='option']"
	                      + "[.//strong[contains("
	                      + "translate(normalize-space(.),"
	                      + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
	                      + "'abcdefghijklmnopqrstuvwxyz'),"
	                      + "translate('"
	                      + name
	                      + "',"
	                      + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
	                      + "'abcdefghijklmnopqrstuvwxyz')"
	                      + ")]]"
	                );

	        WebElement result =
	                wait.until(
	                        ExpectedConditions.elementToBeClickable(
	                                dependentOption
	                        )
	                );

	        result.click();

	        System.out.println(
	                "Autocomplete clicked for = " + name
	        );

	        Thread.sleep(500);

	        // =================================================
	        // FIND DEPENDENT ROW
	        // =================================================

	        WebElement row =
	                wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(
	                                By.xpath(
	                                        "//div[contains(@class,'passenger-list')][contains("
	                                      + "translate(.,"
	                                      + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
	                                      + "'abcdefghijklmnopqrstuvwxyz'),"
	                                      + "translate('"
	                                      + name
	                                      + "',"
	                                      + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
	                                      + "'abcdefghijklmnopqrstuvwxyz')"
	                                      + ")]"
	                                )
	                        )
	                );

	        System.out.println(
	                "Dependent row found for = " + name
	        );

	        // =================================================
	        // CLICK STATUS / PRIORITY DROPDOWN
	        // =================================================

	        WebElement status =
	                wait.until(
	                        ExpectedConditions.elementToBeClickable(
	                                By.xpath(
	                                        "//div[contains(@class,'delete-passenger-form-list')][contains("
	                                      + "translate(normalize-space(.),"
	                                      + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
	                                      + "'abcdefghijklmnopqrstuvwxyz'),"
	                                      + "translate('"
	                                      + name
	                                      + "',"
	                                      + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
	                                      + "'abcdefghijklmnopqrstuvwxyz')"
	                                      + ")]"
	                                      + "//mat-select"
	                                )
	                        )
	                );

	        status.click();

	        System.out.println(
	                "Status clicked for = " + name
	        );

	        Thread.sleep(500);

	        // =================================================
	        // FIND PRIORITY OPTION
	        // =================================================

	        List<WebElement> options =
	                driver.findElements(
	                        By.xpath(
	                                "//mat-option[@role='option']"
	                        )
	                );

	        WebElement requiredOption = null;

	        String uiPriority =
	                priority.replace("-", " - ");

	        for (WebElement option : options) {

	            if (!option.isDisplayed()) {
	                continue;
	            }

	            String optionText =
	                    option.getText()
	                            .replace("\u00A0", " ")
	                            .replaceAll("\\s+", " ")
	                            .trim();

	            System.out.println(
	                    "Available option = ["
	                            + optionText
	                            + "]"
	            );

	            if (optionText.equalsIgnoreCase(
	                    uiPriority)) {

	                requiredOption = option;
	                break;
	            }
	        }

	        // =================================================
	        // VALIDATE PRIORITY
	        // =================================================

	        if (requiredOption == null) {

	            throw new RuntimeException(
	                    "Priority not found = "
	                            + uiPriority
	                            + " for "
	                            + name
	            );
	        }

	        // =================================================
	        // SELECT PRIORITY
	        // =================================================

	        requiredOption.click();

	        System.out.println(
	                "Priority selected = "
	                        + priority
	                        + " for "
	                        + name
	        );

	        Thread.sleep(500);
	    }

	    System.out.println(
	            "========================================"
	    );

	    System.out.println(
	            "All dependents processed successfully."
	    );

	    System.out.println(
	            "========================================"
	    );
	
	    // ==========================================
	    // 8. REVIEW
	    // ==========================================

	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath(
	                            "//button[normalize-space()='Review']"
	                    )
	            )
	    ).click();

	    System.out.println(
	            "All Excel dependents selected successfully."
	    );
	    webdriverutility.click(Addbtn);
	}

private void selectFamilyPassengerCounts(FlightBookingData data)
        throws Throwable {

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(40));

    // Read passenger counts from Excel
    int adults = parsePassengerCount(data.getAdults());
    int children = parsePassengerCount(data.getChildren());
    int infants = parsePassengerCount(data.getInfant());

    System.out.println("===== FAMILY PASSENGER SELECTION =====");
    System.out.println("Adults   = " + adults);
    System.out.println("Children = " + children);
    System.out.println("Infants  = " + infants);

    // Validate Excel data
    if (adults < 1 || children < 0 || infants < 0) {
        throw new IllegalArgumentException(
                "Invalid Family Trip passenger counts in Excel.");
    }

    // Open Passengers and Cabin
    wait.until(ExpectedConditions.elementToBeClickable(
            PassengerDetailDropdown));

    webdriverutility.click(PassengerDetailDropdown);

    System.out.println("Passengers and cabin opened.");

    // Adult default count = 1
    if (adults > 1) {

        wait.until(ExpectedConditions.elementToBeClickable(
                adultPlusBtn));

        webdriverutility.clickMultipleTimes(
                adultPlusBtn, adults - 1);
    }

    // Select Children
    if (children > 0) {

        wait.until(ExpectedConditions.elementToBeClickable(
                childPlusBtn));

        webdriverutility.clickMultipleTimes(
                childPlusBtn, children);
    }

    // Select Infants on lap
    if (infants > 0) {

        wait.until(ExpectedConditions.elementToBeClickable(
                infantLapPlusBtn));

        webdriverutility.clickMultipleTimes(
                infantLapPlusBtn, infants);
    }

    System.out.println("Family passenger counts selected successfully.");

    // Click Continue
    wait.until(ExpectedConditions.visibilityOf(Continuebtn));

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            Continuebtn);

    wait.until(ExpectedConditions.elementToBeClickable(
            Continuebtn));

    Continuebtn.click();

    System.out.println(
            "Family Trip passenger selection completed.");
}

	private void Adddependent(FlightBookingData data)
	        throws Throwable {

	    String dependentNames = data.getdependentName();
	    String priorities = data.getPriority();

	    Adddependent(dependentNames, priorities);
	}

	
	
	
	
	public void selectPaymentMethod(FlightBookingData data) throws Throwable {

		String paymentMethod = data.getPaymentMethod().trim();

		String[] methods = paymentMethod.split("\\|");

		String initialMethod = methods[0].trim();

	    System.out.println("Payment Method from Excel = [" + initialMethod + "]");
	    
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(80));
	    if (initialMethod.equalsIgnoreCase("SADAD")) {

	        selectSadad(data);

	    } 
	   
	
	    
	    else if (initialMethod.equalsIgnoreCase("Saved cards")) {

	    	selectSavedCard(data);

	    } else if (initialMethod.equalsIgnoreCase("Use a different card")) {

	        selectOthersCard(data);

	    } else {

	        throw new IllegalArgumentException(
	                "Unsupported payment method: " + paymentMethod
	        );
	    }
//	    ExtentTestManager.getTest()
//        .info("<b>payment method :</b> " + paymentMethod);
		WebElement pnrElement = wait.until(
	    		ExpectedConditions.visibilityOfElementLocated(
	    		bookingReference));

	    		String pnr = pnrElement.getText().trim();
	    		
	    		ExtentTestManager.setRuntimePnr(
	    		        ExtentTestManager.getTestCaseId(),
	    		        pnr
	    		);

	    		// Existing logging remains unchanged
	    	

	    		System.out.println("PNR = " + pnr);
	    		 
	    		Assert.assertFalse(
	    		pnr.isEmpty(),
	    		"PNR was not generated.");
	    		System.out.println("STEP 1: Booking confirmed");
	    		System.out.println("STEP 2: PNR extracted = " + pnr);

	    		ExcelUtil.updateExcelCell(
	    			    Ipathconstant.excelfile_path,
	    			    "FlightBookingData",
	    			    data.getTestCaseId(),
	    			    "PNR",
	    			    pnr
	    			);
	    		System.out.println(Ipathconstant.excelfile_path);

	    		ReportUtil.logPass("Booking reference saved successfully");
	    
	    
	}
	
	private void selectSavedCard(FlightBookingData data) throws Throwable {
		By amexCardLocator = By.xpath(
			    "//mat-radio-group[@formcontrolname='selectedCardId']"
			    + "//mat-radio-button[.//*[contains(normalize-space(.),"
			    + "'American Express')]]"
			);


	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(60));

	    String paymentMethod = data.getPaymentMethod().trim();
	    String SavedCardName=data.getSavedCardName().trim();

	    WebElement savedPanel = wait.until(
	            ExpectedConditions.elementToBeClickable(savedCardsHeader)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            savedPanel
	    );

	    savedPanel.click();
	    System.out.println("Saved cards panel opened.");

	    if (SavedCardName.equalsIgnoreCase("American Express")) {
	    	WebElement card = wait.until(
	    		    ExpectedConditions.elementToBeClickable(amexCardLocator)
	    		);

	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView({block:'center'});",
	                card
	        );

	        card.click();
	        System.out.println("American Express selected.");

	        // American Express Security Code
//	        WebElement securityCode = wait.until(
//	                ExpectedConditions.visibilityOf(securityCodeTextbox)
//	        );
//
//	        ((JavascriptExecutor) driver).executeScript(
//	                "arguments[0].scrollIntoView({block:'center'});",
//	                securityCode
//	        );
//
//	        wait.until(ExpectedConditions.elementToBeClickable(securityCode));
//
//	        securityCode.click();
//	        securityCode.sendKeys(data.getSecurityCode());

	        System.out.println("American Express security code entered.");

	    } else if (SavedCardName.equalsIgnoreCase("Visa")) {

	        webdriverutility.click(VisaCardRadiobtn);

	        System.out.println("Visa card selected.");

	    } else {
	        throw new IllegalArgumentException(
	                "Unsupported payment method: " + paymentMethod
	        );
	    }

	    WebElement terms = wait.until(
	            ExpectedConditions.elementToBeClickable(termsCheckbox)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            terms
	    );

	    terms.click();
	    System.out.println("Terms and Conditions selected.");

	    WebElement payNow = wait.until(
	            ExpectedConditions.elementToBeClickable(Paynowbtn)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            payNow
	    );

	    Thread.sleep(5000);

	    payNow.click();

	    System.out.println("Pay Now clicked.");
	
	    // Cardinal 3DS OTP
	  //  handleCardinalFrame(data);
	    
	    
	    
	    
	    
	    

//	    System.out.println("Pay Now clicked.");
//
//
//
//	    wait.until(
//	            ExpectedConditions.frameToBeAvailableAndSwitchToIt(
//	                    By.id("Cardinal-CCA-IFrame")
//	            )
//	    );
//
//	    System.out.println("Switched to Cardinal OTP iframe.");
//
//
//	
//
//	    WebElement otpBox = wait.until(
//	            ExpectedConditions.visibilityOfElementLocated(
//	                    By.xpath("//input[@name='challengeDataEntry']")
//	            )
//	    );
//
//	    String otp = data.getOTP().trim();
//
//	    System.out.println("OTP = " + otp);
//
//	    otpBox.clear();
//	    otpBox.sendKeys(otp);
//
//	    System.out.println("OTP entered successfully.");
//
//
//	    WebElement submit = wait.until(
//	            ExpectedConditions.elementToBeClickable(
//	                    By.xpath("//input[@type='submit' and @value='SUBMIT']")
//	            )
//	    );
//
//	    submit.click();
//
//	    System.out.println("OTP Submit clicked.");
//
//
//	  
//	    driver.switchTo().defaultContent();
//
//	    System.out.println("Switched back to main page.");
//


	    By bookingConfirmed =
	            By.xpath("//*[normalize-space()='Booking confirmed']");

	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    bookingConfirmed
	            )
	    );

	    System.out.println("Booking confirmed successfully.");

		WebElement pnrElement = wait.until(
	    		ExpectedConditions.visibilityOfElementLocated(
	    		bookingReference));

	    		String pnr = pnrElement.getText().trim();

	    		System.out.println("PNR = " + pnr);

	    		Assert.assertFalse(
	    		pnr.isEmpty(),
	    		"PNR was not generated.");
	    		System.out.println("STEP 1: Booking confirmed");
	    		System.out.println("STEP 2: PNR extracted = " + pnr);

	    		ExcelUtil.updateExcelCell(
	    			    Ipathconstant.excelfile_path,
	    			    "FlightBookingData",
	    			    data.getTestCaseId(),
	    			    "PNR",
	    			    pnr
	    			);
	    		System.out.println(Ipathconstant.excelfile_path);

	    		ReportUtil.logPass("PNR saved successfully: " + pnr);
	    
	}
	

	private void selectSadad(FlightBookingData data) throws Throwable {
		
		String paymentMethod = data.getPaymentMethod().trim();

		String[] methods = paymentMethod.split("\\|");

		String initialMethod = methods[0].trim();
		String secondMethod = methods[1].trim();
	 

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(30));

	    // 1. Select SADAD
	    WebElement sadadPanel =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            SdadRadiobtn
	                    )
	            );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            sadadPanel
	    );

	    sadadPanel.click();

	    System.out.println("SADAD payment method selected.");

	    // 2. Select Terms
	    WebElement terms =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            termsCheckbox
	                    )
	            );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            terms
	    );

	    terms.click();

	    System.out.println(
	            "Terms and Conditions clicked."
	    );

	    // 3. Pay Now
	 // 3. Pay Now
	    try {
	        By payNowLocator = By.xpath(
	            "//button[.//span[normalize-space()='Pay now'] and not(contains(@class,'d-none'))]"
	        );

	        WebElement payNow = wait.until(
	            ExpectedConditions.presenceOfElementLocated(payNowLocator)
	        );

	        System.out.println("Pay Now displayed: " + payNow.isDisplayed());
	        System.out.println("Pay Now enabled: " + payNow.isEnabled());

	        System.out.println(
	            "Pay Now HTML: " + payNow.getAttribute("outerHTML")
	        );

	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            payNow
	        );

	        wait.until(
	            ExpectedConditions.elementToBeClickable(payNow)
	        );

	        payNow.click();

	        System.out.println("Pay Now clicked successfully.");

	    } catch (TimeoutException e) {

	        try {
	            Alert alert = driver.switchTo().alert();

	            System.out.println(
	                "Application alert: " + alert.getText()
	            );

	            alert.accept();

	        } catch (NoAlertPresentException ignored) {
	            System.out.println("No browser alert present.");
	        }

	        throw e;
	    }
	    
	    WebDriverWait wait2 =
	            new WebDriverWait(driver, Duration.ofSeconds(90));

	    wait2.until(ExpectedConditions.invisibilityOf(processingPopup));

	    System.out.println(
	            "Pay Now clicked."
	    );
	    WebDriverWait wait1 =
	            new WebDriverWait(driver, Duration.ofSeconds(60));

	    WebElement bookManage = wait1.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//button[normalize-space(.)='Book & Manage']")
	            )
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            bookManage
	    );

	    wait.until(
	            ExpectedConditions.elementToBeClickable(bookManage)
	    );

	    bookManage.click();
	    
	    webdriverutility.click(Managebtn);
	    
	    webdriverutility.click(SadadPaynowbtn);
	    
	    if (secondMethod.equalsIgnoreCase("Saved cards")) {

	    	selectSavedCard(data);

	    } else if (secondMethod.equalsIgnoreCase("Use a different card")) {

	        selectOthersCard(data);

	    } else {

	        throw new IllegalArgumentException(
	                "Unsupported payment method: " + paymentMethod
	        );
	    }
	    
	    
	}
//	public String getBookingReference() {
//
//	    WebDriverWait wait =
//	            new WebDriverWait(driver, Duration.ofSeconds(30));
//
//	    wait.until(
//	            ExpectedConditions.visibilityOf(bookingReference));
//
//	    String pnr = bookingReference.getText().trim();
//
//	    System.out.println("Booking PNR = " + pnr);
//
//	    return pnr;
//	}
	private void selectOthersCard(FlightBookingData data) throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(30));

	    WebElement cardOption = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(differentCard)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            cardOption
	    );

	    // Check whether "Use a different card" is already expanded
	    String expanded = cardOption.getAttribute("aria-expanded");

	    System.out.println(
	            "Use a different card aria-expanded = " + expanded
	    );

	    // Click ONLY when it is closed
	    if (!"true".equalsIgnoreCase(expanded)) {

	        wait.until(
	                ExpectedConditions.elementToBeClickable(cardOption)
	        );

	        cardOption.click();

	        System.out.println(
	                "Use a different card was closed, so it was opened."
	        );

	    } else {

	        System.out.println(
	                "Use a different card is already open. No click required."
	        );
	    }

	    // Now wait for card number field
	    WebElement cardNumberField = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(cardNumber)
	    );

	    cardNumberField.clear();
	    cardNumberField.sendKeys(data.getCardNumber());

	    WebElement cardNameField = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(cardName)
	    );

	    cardNameField.clear();
	    cardNameField.sendKeys(data.getCardHolderName());

	    System.out.println("Card number and card holder entered.");

	    // Expiry Month
	    WebElement month = wait.until(
	            ExpectedConditions.elementToBeClickable(expiryMonth)
	    );

	    month.click();

	    By monthOption = By.xpath(
	            "//mat-option[normalize-space()='"
	            + data.getExpirymonth().trim()
	            + "']"
	    );

	    wait.until(
	            ExpectedConditions.elementToBeClickable(monthOption)
	    ).click();

	    // Expiry Year
	    WebElement year = wait.until(
	            ExpectedConditions.elementToBeClickable(expiryYear)
	    );

	    year.click();

	    By yearOption = By.xpath(
	            "//mat-option[normalize-space()='"
	            + data.getExpiryYear().trim()
	            + "']"
	    );

	    wait.until(
	            ExpectedConditions.elementToBeClickable(yearOption)
	    ).click();

	    // CVV
	    WebElement cvv = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(securityCode)
	    );

	    cvv.clear();
	    cvv.sendKeys(data.getSecurityCode());

	    System.out.println("Card payment details entered.");
	    ReportUtil.attachFullPageScreenshot(driver, "Other card details entered");
	    
	    webdriverutility.click(termsCheckbox);
	    
	    webdriverutility.click(Paynowbtn);

	
	}
	private void handleCardinalFrame(FlightBookingData data) throws Throwable {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(60));

	    try {

	        System.out.println("Waiting for Cardinal OTP iframe...");

	        // Switch to Cardinal iframe
	        wait.until(
	                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
	                        cardinalIframe
	                )
	        );

	        System.out.println(
	                "Switched to Cardinal OTP iframe successfully."
	        );

	        // Wait for OTP textbox
	        WebElement otpBox =
	                wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(
	                                OtpTextbox
	                        )
	                );

	        String otp = data.getOTP().trim();

	        System.out.println("OTP = " + otp);

	        otpBox.clear();
	        otpBox.sendKeys(otp);

	        System.out.println(
	                "OTP entered successfully."
	        );

	        // Submit OTP
	        WebElement submit =
	                wait.until(
	                        ExpectedConditions.elementToBeClickable(
	                                Submitbtn
	                        )
	                );

	        submit.click();

	        System.out.println(
	                "OTP Submit clicked successfully."
	        );

	    } finally {

	        // VERY IMPORTANT
	        driver.switchTo().defaultContent();

	        System.out.println(
	                "Switched back to main page."
	        );
	    }
	}
	public void selectSavedCard(String cardName) {

	    WebElement card = driver.findElement(
	        By.xpath("//mat-radio-group[@formcontrolname='selectedCardId']"
	               + "//mat-radio-button[.//*[contains(normalize-space(),'"
	               + cardName + "')]]")
	    );

	    new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(card))
	            .click();

	    System.out.println("Selected card: " + cardName);
	}
	}

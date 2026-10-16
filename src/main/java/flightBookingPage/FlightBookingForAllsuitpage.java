

package flightBookingPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import base.BasePage;
import modeles.FlightBookingData;
import reports.ReportUtil;
import utilities.WebdriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightBookingForAllsuitpage extends BasePage {


private WebdriverUtility webdriverutility;

	public FlightBookingForAllsuitpage(WebDriver driver) {
		super(driver);

		webdriverutility = new WebdriverUtility(driver);






    }
    
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

	@FindBy(xpath = "//mat-radio-button[.//*[normalize-space()='Business trip']]")
	private WebElement BusinessTripRadioBtn;

	@FindBy(xpath = "//mat-radio-button[.//*[normalize-space()='Family trip']]")
	private WebElement FamilyTripRadioBtn;

	@FindBy(xpath = "//button[normalize-space()='Apply selection']")
	private WebElement ApplySelectionBtn;

	@FindBy(xpath = "//mat-form-field[.//label[contains(normalize-space(.),'Passengers and cabin')]]")
	private WebElement PassengerDetailDropdown;

	@FindBy(xpath = "//div[contains(@class,'age-details')][.//p[normalize-space()='Adults']]//button[.//mat-icon[normalize-space()='Add']]")
	private WebElement adultPlusBtn;

	@FindBy(xpath = "//div[contains(@class,'age-details')][.//p[normalize-space()='Children']]//button[.//mat-icon[normalize-space()='Add']]")
	private WebElement childPlusBtn;

	@FindBy(xpath = "//div[contains(@class,'age-details')][.//p[normalize-space()='Infants on lap']]//button[.//mat-icon[normalize-space()='Add']]")
	private WebElement infantLapPlusBtn;

	@FindBy(xpath = "//mat-form-field[.//label[contains(normalize-space(.),'Booking details')]]")
	private WebElement TravelCalssDropdown;

	@FindBy(xpath = "//mat-form-field[.//label[contains(normalize-space(),'Employee details')]]//input")
	private WebElement EmployeeDetailsTextbox;

	@FindBy(xpath = "//div[@id='mat-autocomplete-2']")
	private WebElement EmployeeDetailssuggestion;
	
	@FindBy(xpath = "//button[contains(@class,'add-multicity-flight') and .//span[normalize-space()='Add flight']]")
	private WebElement AddFlightbtn;

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
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

	@FindBy(xpath = "//button[.//span[normalize-space()='Pay now']]")
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
	private By bookingReference = By.xpath("(//div[contains(@class,'pnr-wrapper__data')]"
			+ "[.//p[normalize-space()='Booking reference']]" + "//p[contains(@class,'pnr-info')])[1]");

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

	@FindBy(xpath = "//ng-select[@placeholder='Nationality']")
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



	public void searFlightForAll(FlightBookingData data)throws Throwable{



	        // =====================================================
	        // 1. GET BASIC DATA
	        // =====================================================

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


	        // =====================================================
	        // 3. ENTER FLIGHT SEARCH DETAILS
	        // =====================================================

	        if (tripType.equalsIgnoreCase("One Way")) {

	            System.out.println("===== ONE WAY SEARCH =====");

	            selectDeparturecity(data);

	            Thread.sleep(3000);

	            selectArrivalcity(data);

	            webdriverutility.click(acceptCookieBtn);
	            

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

	            Thread.sleep(6000);

	            selectArrivalcity(data);

	            webdriverutility.click(acceptCookieBtn);

	            Thread.sleep(8000);
	            webdriverutility.selectRoundTripDates(
	                    DepartureCalendaricon,
	                    data.getDeparturedate(),
	                    data.getReturndate()
	            );

	            webdriverutility.closeRoundTripCalendar();

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

	        Thread.sleep(8000);

	        TravellerType(data);


	        // =====================================================
	        // 5. EMPLOYEE DETAILS
	        // =====================================================

	        if (Traveller.equalsIgnoreCase("Employee")) {

	            String employeeEmail =
	                    data.getEmployeedetails().trim();

	            webdriverutility.sendKeys(
	                    EmployeeDetailsTextbox,
	                    employeeEmail
	            );

	            By employeeSuggestion = By.xpath(
	                    "//mat-option[@role='option']"
	                  + "[.//*[contains(normalize-space(),'"
	                  + employeeEmail
	                  + "')]]"
	            );

	            webdriverutility.clickWithRetry(
	                    employeeSuggestion
	            );
                ReportUtil.attachFullScreenScreenshotwithurl(
        "Search data is entered"
);

	        }
	             	
	


	        // =====================================================
	        // 6. WAIT FOR SEARCH BUTTON
	        // =====================================================

	        webdriverutility.waitForVisibility(
	                SearchFlightbtn
	        );

	       

	        Thread.sleep(7000);


	        // =====================================================
	        // 7. CLICK SEARCH FLIGHT
	        // =====================================================

	        clickSearchButton();

    }


    public void selectDeparturecity(FlightBookingData data) throws Throwable {

		selectCity(FromTxtbox, data.getFrom());
	}

	public void selectArrivalcity(FlightBookingData data) throws Throwable {

		selectCity(TotxtBox, data.getTo());
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
	
    
	public void TravellerType(FlightBookingData data) throws Throwable {

	    String Traveller = data.getTravellerType().trim();
	    String TripCategory = data.getTripCategory().trim();

	    System.out.println("Traveller    = " + Traveller);
	    System.out.println("TripCategory = " + TripCategory);

	 

	    if (Traveller.equalsIgnoreCase("Employee")) {

	    

	        webdriverutility.click(TravelCalssDropdown);

	       

	        if (!EmployeeRadiobtn.getAttribute("class").contains("checked")) {

	            webdriverutility.click(EmployeeRadiobtn);

	        }
	        

	        else if (Traveller.equalsIgnoreCase(" Multiple travelers ")) {

		    

		        webdriverutility.click(TravelCalssDropdown);

		       
	        }
		        else  if (!EmployeeRadiobtn.getAttribute("class").contains("checked")) {

		            webdriverutility.click(MultipleTravellerRadioBtn );

		        }
	        

	      
	        if (TripCategory.equalsIgnoreCase("Business trip")) {

	            if (!BusinessTripRadioBtn.getAttribute("class").contains("checked")) {

	                webdriverutility.click(BusinessTripRadioBtn);

	            }

	            // Business trip does NOT need passenger count here.
	            webdriverutility.click(ApplySelectionBtn);

	        }

	        else if (TripCategory.equalsIgnoreCase("Family trip")) {

	       

	            if (!FamilyTripRadioBtn.getAttribute("class").contains("checked")) {

	                webdriverutility.click(FamilyTripRadioBtn);

	            }

	            System.out.println("Family trip selected.");

	      

	            int adults = parsePassengerCount(data.getAdults());
	            int children = parsePassengerCount(data.getChildren());
	            int infants = parsePassengerCount(data.getInfant());

	            System.out.println("Adults   = " + adults);
	            System.out.println("Children = " + children);
	            System.out.println("Infants  = " + infants);

	          
	            webdriverutility.click(ApplySelectionBtn);

	            
	            WebDriverWait wait =
	                    new WebDriverWait(driver, Duration.ofSeconds(30));

	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            PassengerDetailDropdown
	                    )
	            );

	            webdriverutility.click(PassengerDetailDropdown);

	            System.out.println("Passengers and cabin opened.");

	           

	            wait.until(
	                    ExpectedConditions.visibilityOf(adultPlusBtn)
	            );

	           

	            if (adults > 1) {

	                webdriverutility.clickMultipleTimes(
	                        adultPlusBtn,
	                        adults - 1
	                );
	            }

	           
	            if (children > 0) {

	                wait.until(
	                        ExpectedConditions.visibilityOf(childPlusBtn)
	                );

	                webdriverutility.clickMultipleTimes(
	                        childPlusBtn,
	                        children
	                );
	            }

	          

	            if (infants > 0) {

	                wait.until(
	                        ExpectedConditions.visibilityOf(infantLapPlusBtn)
	                );

	                webdriverutility.clickMultipleTimes(
	                        infantLapPlusBtn,
	                        infants
	                );
	            }

	            

	            wait.until(
	                    ExpectedConditions.visibilityOf(Continuebtn)
	            );

	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].scrollIntoView({block:'center'});",
	                    Continuebtn
	            );

	            wait.until(
	                    ExpectedConditions.elementToBeClickable(Continuebtn)
	            );

	            System.out.println(
	                    "Clicking Continue after passenger selection..."
	            );

	            Continuebtn.click();

	            System.out.println(
	                    "Passenger selection completed successfully."
	            );
	        }

	        else {

	            throw new IllegalArgumentException(
	                    "Invalid Trip Category for Employee: "
	                    + TripCategory
	            );
	        }
	    }

	   
	 
	 // =========================================================
	 // GUEST TRAVELER
	 // =========================================================

	 else if (Traveller.equalsIgnoreCase("Guest traveler")) {

	     System.out.println(
	             "===== GUEST TRAVELER SELECTION STARTED ====="
	     );

	     WebDriverWait wait =
	             new WebDriverWait(driver, Duration.ofSeconds(30));

	     // ---------------------------------------------------------
	     // 1. OPEN BOOKING DETAILS
	     // ---------------------------------------------------------

	     wait.until(
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

	     By guestTravelerRadio = By.xpath(
	             "//mat-radio-button[.//*[normalize-space()='Guest traveler']]"
	     );

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
	     // 4. APPLY SELECTION
	     // ---------------------------------------------------------

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

	     System.out.println(
	             "Apply selection clicked."
	     );

	     // ---------------------------------------------------------
	     // 5. OPEN PASSENGERS AND CABIN
	     // ---------------------------------------------------------

	     WebElement passengerDropdown = wait.until(
	             ExpectedConditions.elementToBeClickable(
	                     PassengerDetailDropdown
	             )
	     );

	     ((JavascriptExecutor) driver).executeScript(
	             "arguments[0].scrollIntoView({block:'center'});",
	             passengerDropdown
	     );

	     passengerDropdown.click();

	     System.out.println(
	             "Passengers and cabin opened."
	     );

	     // ---------------------------------------------------------
	     // 6. ADULT COUNT
	     // ---------------------------------------------------------

	     int adults = Integer.parseInt(
	             data.getAdults().trim()
	     );

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
}
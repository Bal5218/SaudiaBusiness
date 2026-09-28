package flightBookingPage;

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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.BasePage;
import modeles.FlightBookingData;
import reports.ReportUtil;
import utilities.WebdriverUtility;

public class FlightBookingForAllPaxPage extends BasePage {

	private WebdriverUtility webdriverutility;

	public FlightBookingForAllPaxPage(WebDriver driver) {
		super(driver);

		webdriverutility = new WebdriverUtility(driver);

	}
//	@FindBy(xpath = "//a[@aria-label='Go to homepage']")
//	private WebElement Saudialogo;
	
	
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
//
//	@FindBy(xpath = "//div[normalize-space()='SADAD']")
//	private WebElement SdadRadiobtn;

	private By SdadRadiobtn = By.xpath(
		    "//mat-expansion-panel-header[.//*[normalize-space()='SADAD']]"
		);
	
	private By termsCheckbox = By
			.xpath("//mat-checkbox[contains(.,\"By continuing, you agree to Saudia's Terms and Conditions\")]");

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

	@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
	private WebElement AdultApplyselectionbtn;

//			private By applySelectionBtn =
//			        By.xpath("//button[normalize-space()='Apply selection']");

	public void FlightBookingForAllPax(FlightBookingData data) throws Throwable {
		
		webdriverutility.click(saudiaLogo);

		String tripType = data.getTripType().trim();

		TripType(data);

		Thread.sleep(3000);
		if (tripType.equalsIgnoreCase("One Way")) {

			selectDeparturecity(data);
			Thread.sleep(3000);
			selectArrivalcity(data);

			webdriverutility.selectPikadayDate(DepartureCalendaricon, departureDateInput, data.getDeparturedate(),
					false);

		} else if (tripType.equalsIgnoreCase("Round trip")) {

			selectDeparturecity(data);

			selectArrivalcity(data);

			webdriverutility.click(acceptCookieBtn);

			webdriverutility.selectRoundTripDates(DepartureCalendaricon, data.getDeparturedate(), data.getReturndate());
			webdriverutility.closeRoundTripCalendar();
		}

		else if (tripType.equalsIgnoreCase("Multi-city")) {

			MultiCityDetails(data);
		}

		// Trip Type

		// TripType(data);

		// From Textbox

		// Thread.sleep(4000);

		TravellerType(data);
		String Traveller = data.getTravellerType().trim();

		if (Traveller.equalsIgnoreCase("Employee")) {

			String employeeEmail = data.getEmployeedetails().trim();

			webdriverutility.sendKeys(EmployeeDetailsTextbox, employeeEmail);

			By employeeSuggestion = By.xpath(
					"//mat-option[@role='option']" + "[.//*[contains(normalize-space(),'" + employeeEmail + "')]]");

			// Thread.sleep(4000);

			webdriverutility.clickWithRetry(employeeSuggestion);

		webdriverutility.waitForVisibility(acceptCookieBtn);
		webdriverutility.click(acceptCookieBtn);
		

		}

//	
//	webdriverutility.scrollToTop();
//	
//   ReportUtil.logPass("search data is entered");
		
		

		webdriverutility.waitForVisibility(SearchFlightbtn);

		ReportUtil.attachFullPageScreenshot(driver, "Search data is entered");

		clickSearchButton();
	

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		try {

		    wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            allExpandFareBtns
		        )
		    );

		    System.out.println("Flight results loaded");

		} catch (TimeoutException e) {

		    System.out.println("Flight results NOT loaded within 60 seconds");

		    ReportUtil.attachFullPageScreenshot(
		        driver,
		        "Flight Result Timeout"
		    );

		    throw e;
		}
		
		printAllExpandButtons();
		clickExpandButton(0);

		System.out.println("Flight 0 expanded. Waiting for Basic fare...");

		WebDriverWait fareWait =
		        new WebDriverWait(driver, Duration.ofSeconds(120));

		try {

		    fareWait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            basicFareSelectBtn
		        )
		    );

		    System.out.println("Basic fare displayed.");

		} catch (TimeoutException e) {

		    System.out.println(
		        "Basic fare NOT displayed after 120 seconds."
		    );

		    ReportUtil.attachFullPageScreenshot(
		        driver,
		        "Basic Fare Timeout"
		    );

		    throw e;
		}
		ReportUtil.logPass("Result page is displayed");

		webdriverutility.click(basicFareSelectBtn);

		if (tripType.equalsIgnoreCase("Round trip")) {

			Thread.sleep(3000);

		
			printAllExpandButtons();

			clickExpandButton(1);

			Thread.sleep(2000);

			webdriverutility.waitForVisibility(basicFareSelectBtn);

			webdriverutility.clickWithRetry(basicFareSelectBtn);
		} else if (tripType.equalsIgnoreCase("Multi-city")) {

			Thread.sleep(3000);

			printAllExpandButtons();

			clickExpandButton(1);

			Thread.sleep(2000);

			webdriverutility.waitForVisibility(basicFareSelectBtn);

			webdriverutility.clickWithRetry(basicFareSelectBtn);

		}
		WebDriverWait wait3 =
		        new WebDriverWait(driver, Duration.ofSeconds(120));

		wait3.until(
		    ExpectedConditions.elementToBeClickable(
		        ContinueToPassengerBtn
		    )
		);

		System.out.println("Continue to Passenger is clickable.");

		webdriverutility.click(ContinueToPassengerBtn);

		System.out.println("Passenger page opened.");

		if (Traveller.equalsIgnoreCase("Guest traveler")) {
		    Adultdetails(data);
		}
		webdriverutility.waitForVisibility(ContinueToPaymentBtn);
		ReportUtil.attachFullPageScreenshot(driver, "Passenger page is displayed");

		webdriverutility.click(ContinueToPaymentBtn);

		

		webdriverutility.scrollToBottom();

		String parentWindow = driver.getWindowHandle();

		wait.until(ExpectedConditions.elementToBeClickable(SdadRadiobtn));

		webdriverutility.click(SdadRadiobtn);

		ReportUtil.logPass("Payment page is displayed");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		if (driver.getWindowHandles().size() > 1) {

			for (String window : driver.getWindowHandles()) {

				if (!window.equals(parentWindow)) {

					driver.switchTo().window(window);

					System.out.println("New window found: " + driver.getCurrentUrl());

					driver.close();

					System.out.println("New window closed.");

					break;
				}
			}

			driver.switchTo().window(parentWindow);

		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(termsCheckbox));

		wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));

		webdriverutility.click(termsCheckbox);

		wait.until(ExpectedConditions.elementToBeClickable(Paynowbtn));

		webdriverutility.click(Paynowbtn);

		// Wait until Booking Status page is reached
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait1.until(ExpectedConditions.urlContains("BookingStatus"));

		// Now validate the hold message
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@class,'toast-msg__hold')]//span[normalize-space()='This booking is on hold.']")));

		Assert.assertTrue(driver.findElement(By
				.xpath("//div[contains(@class,'toast-msg__hold')]//span[normalize-space()='This booking is on hold.']"))
				.isDisplayed(), "Booking hold message is not displayed.");

		String pnr = driver.findElement(bookingReference).getText().trim();

		ReportUtil.logPass("  pnr generated successfully: " + "    " + pnr);

	}


	public void MultiCityDetails(FlightBookingData data) throws Throwable {

		System.out.println("===== MULTI CITY BOOKING STARTED =====");

		System.out.println("----- SEGMENT 1 -----");

		System.out.println("From : " + data.getFrom());
		System.out.println("To   : " + data.getTo());
		System.out.println("Date : " + data.getDeparturedate());

		// Select first From city
		selectDeparturecity(data);

		Thread.sleep(3000);

		// Select first To city
		selectArrivalcity(data);

		Thread.sleep(3000);

		// Wait for first departure date field
		webdriverutility.waitForVisibility(departureDateInput);

		// Select first departure date
		webdriverutility.selectPikadayDate(DepartureCalendaricon, departureDateInput, data.getDeparturedate(), false);

		System.out.println("SEGMENT 1 DATE SELECTED = " + data.getDeparturedate());

		Thread.sleep(3000);

		System.out.println("----- SEGMENT 2 -----");

		System.out.println("To   : " + data.getMultiCityTo2());

		System.out.println("Date : " + data.getMultiCityDepartureDate2());

		// Select second To city
		selectCity(secondTotxtBox, data.getMultiCityTo2());

		Thread.sleep(3000);

		webdriverutility.waitForVisibility(departureDateInput2);

		System.out.println("Second departure date field is visible.");

		System.out.println("Selecting Segment 2 date = " + data.getMultiCityDepartureDate2());

		// Select SECOND departure date
		webdriverutility.selectPikadayDate(DepartureCalendaricon2, departureDateInput2,
				data.getMultiCityDepartureDate2(), false);

		System.out.println("SEGMENT 2 DATE SELECTED = " + data.getMultiCityDepartureDate2());

		Thread.sleep(2000);

		System.out.println("===== MULTI CITY BOOKING COMPLETED =====");

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

		String Traveller = data.getTravellerType().trim();
		String TripCategory = data.getTripCategory().trim();

		webdriverutility.click(TravelCalssDropdown);

		if (Traveller.equalsIgnoreCase("Employee")) {

			if (!EmployeeRadiobtn.getAttribute("class").contains("checked")) {

				webdriverutility.click(EmployeeRadiobtn);
			}

			if (TripCategory.equalsIgnoreCase("Business trip")) {

				if (!BusinessTripRadioBtn.getAttribute("class").contains("checked")) {

					Thread.sleep(3000);
					webdriverutility.click(BusinessTripRadioBtn);
				}

			} else if (TripCategory.equalsIgnoreCase("Family trip")) {

				if (!FamilyTripRadioBtn.getAttribute("class").contains("checked")) {

					webdriverutility.click(FamilyTripRadioBtn);
				}
				int adults = Integer.parseInt(data.getAdults().trim());
				int children = Integer.parseInt(data.getChildren().trim());
				int Infants = Integer.parseInt(data.getInfant().trim());

				webdriverutility.clickMultipleTimes(adultPlusBtn, adults - 1);
				Thread.sleep(3000);

				webdriverutility.clickMultipleTimes(childPlusBtn, children);

				Thread.sleep(3000);
				webdriverutility.clickMultipleTimes(infantLapPlusBtn, Infants);

			}
			webdriverutility.click(ApplySelectionBtn);

		} else if (Traveller.equalsIgnoreCase("Guest traveler")) {

			webdriverutility.click(GuestTravellerRadioBtn);
			webdriverutility.click(acceptCookieBtn);
			webdriverutility.click(PassengerDetailDropdown);
			;
			int adults = Integer.parseInt(data.getAdults().trim());
			System.out.println("no. of adults:" + adults);

			webdriverutility.clickMultipleTimes(adultPlusBtn, adults - 1);

		} else if (Traveller.equalsIgnoreCase(" Multiple travelers ")) {

			webdriverutility.click(MultipleTravellerRadioBtn);

			int adults = Integer.parseInt(data.getAdults().trim());

			webdriverutility.clickMultipleTimes(adultPlusBtn, adults - 1);

		}

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
			Thread.sleep(5000);
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
	public void clickSearchButton() {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement searchButton =
	            wait.until(ExpectedConditions.visibilityOf(SearchFlightbtn));

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            searchButton);

	    wait.until(ExpectedConditions.elementToBeClickable(searchButton));

	    try {

	        searchButton.click();

	        System.out.println("Search button clicked normally");

	    } catch (ElementClickInterceptedException e) {

	        System.out.println(
	                "Normal click intercepted. Using JS click.");

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", searchButton);
	    }
	}

}

package utilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class WebdriverUtility {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;

	public WebdriverUtility(WebDriver driver) {

		if (driver == null) {
			throw new IllegalArgumentException("WebDriver cannot be null");
		}
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		action = new Actions(driver);
	}

	// **************** WAIT METHODS ****************
	@FindBy(xpath = "//div[contains(@class,'calendar-popup')]//button[normalize-space()='Continue']")
	private WebElement calendarContinueBtn;

	public void waitForVisibility(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForClickable(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForInvisibility(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForTitleContains(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void waitForMatOptionToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector("div.cdk-overlay-container mat-option")));
	}

	public void click(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		for (int i = 0; i < 3; i++) {

			try {

				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				element.click();
				return;

			} catch (Exception e) {

				System.out.println("Retry Click : " + (i + 1));
				System.out.println("Exception : " + e.getClass().getSimpleName());
				System.out.println("Message : " + e.getMessage());

				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					return;
				} catch (Exception ex) {
					System.out.println("JS Click Failed : " + ex.getMessage());
				}
			}
		}
	}

	public void sendKeys(WebElement element, String value) {

		int attempts = 0;

		while (attempts < 3) {

			try {

				waitForVisibility(element);
				element.clear();
				element.sendKeys(value);
				return;

			} catch (StaleElementReferenceException e) {

				attempts++;
			}
		}

		throw new RuntimeException("Unable to send keys due to StaleElementReferenceException.");
	}
	public WebElement waitForClickable(By locator, int seconds) {

	    WebDriverWait customWait =
	            new WebDriverWait(driver, Duration.ofSeconds(seconds));

	    return customWait.until(
	            ExpectedConditions.elementToBeClickable(locator)
	    );
	}
	public void clear(WebElement element) {

		int attempts = 0;

		while (attempts < 3) {

			try {

				waitForVisibility(element);
				element.clear();
				return;

			} catch (StaleElementReferenceException e) {

				attempts++;
			}
		}

		throw new RuntimeException("Unable to clear element due to StaleElementReferenceException.");
	}

	public String getText(WebElement element) {
		int attempts = 0;

		while (attempts < 3) {

			try {

				waitForVisibility(element);
				return element.getText();
			} catch (StaleElementReferenceException e) {

				attempts++;
			}
		}

		throw new RuntimeException("Unable to get text due to StaleElementReferenceException.");
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	// **************** DROPDOWN ****************

	public void selectByVisibleText(WebElement element, String text) {

		int attempts = 0;

		while (attempts < 3) {

			try {

				waitForVisibility(element);
				new Select(element).selectByVisibleText(text);

				return;
			} catch (StaleElementReferenceException e) {

				attempts++;
			}
		}

		throw new RuntimeException("Unable to select dropdown value due to StaleElementReferenceException.");
	}

	public void selectByValue(WebElement element, String value) {
		int attempts = 0;

		while (attempts < 3) {

			try {
				waitForVisibility(element);

				new Select(element).selectByValue(value);

				return;

			} catch (StaleElementReferenceException e) {

				attempts++;
			}
		}

		throw new RuntimeException("Unable to select dropdown value due to StaleElementReferenceException.");
	}
	public void selectNgOptionByVisibleText(WebElement dropdown, String optionText) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    String text = optionText.trim();

	    // Open dropdown
	    WebElement select = wait.until(
	        ExpectedConditions.elementToBeClickable(dropdown)
	    );

	    select.click();

	    // If searchable input is available, enter the value
	    List<WebElement> inputs = dropdown.findElements(By.xpath(".//input"));

	    if (!inputs.isEmpty() && inputs.get(0).isDisplayed()) {
	        WebElement input = inputs.get(0);
	        input.clear();
	        input.sendKeys(text);
	    }

	    // Find option by its displayed text
	    By optionLocator = By.xpath(
	        "//ng-dropdown-panel//div[contains(@class,'ng-option')]" +
	        "//span[contains(normalize-space(),'" + text + "')]"
	    );

	    WebElement option = wait.until(
	        ExpectedConditions.elementToBeClickable(optionLocator)
	    );

	    option.click();

	    System.out.println("Selected Ng Option : " + text);
	}
	public void click(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		element.click();
	}

	public void selectMatOptionByVisibleText(WebElement matSelect, String optionText) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Click mat-select
		WebElement select = wait.until(ExpectedConditions.elementToBeClickable(matSelect));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", select);

		select.click();

		By optionLocator = By.xpath("//mat-option[normalize-space(.)='" + optionText.trim() + "']");

		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

		option.click();

		System.out.println("Selected Mat Option : " + optionText);
	}

	public void acceptCookieIfPresent() throws TimeoutException {

		By acceptCookieBtn = By
				.xpath("//mat-card[contains(@class,'cookie-banner')]" + "//button[normalize-space()='Accept']");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieBtn));

		acceptBtn.click();

		System.out.println("Cookie banner accepted.");
	}

	public void clickWithRetry(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		for (int i = 1; i <= 3; i++) {

			try {

				WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

				// Scroll element to center of screen
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView({block:'center', inline:'center'});", clickableElement);

				Thread.sleep(500);

				clickableElement.click();

				return;

			} catch (StaleElementReferenceException e) {

				System.out.println("Retry " + i + " - StaleElementReferenceException");

			} catch (ElementClickInterceptedException e) {

				System.out.println("Retry " + i + " - ElementClickInterceptedException");

				// Try JavaScript click as fallback
				try {

					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

					return;

				} catch (Exception jsException) {

					System.out.println("JS click failed: " + jsException.getMessage());
				}

			} catch (Exception e) {

				System.out.println("Retry " + i + " - " + e.getClass().getSimpleName());
			}
		}

		throw new RuntimeException("Unable to click element after 3 attempts.");
	}

	public void clickWithRetry(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		for (int i = 0; i < 3; i++) {

			try {

				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

				element.click();

				return;

			} catch (StaleElementReferenceException e) {

			}
		}

		throw new RuntimeException("Unable to click element.");
	}

	public void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	// **************** ACTIONS ****************

	public void moveToElement(WebElement element) {
		action.moveToElement(element).perform();
	}

	public void doubleClick(WebElement element) {
		action.doubleClick(element).perform();
	}

	public void rightClick(WebElement element) {
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		action.dragAndDrop(source, target).perform();
	}

	public void pressEnter() {
		action.sendKeys(Keys.ENTER).perform();
	}

	public void pressTab() {
		action.sendKeys(Keys.TAB).perform();
	}

	public void pressArrowDown() {
		action.sendKeys(Keys.ARROW_DOWN).perform();
	}
	// **************** JAVASCRIPT ****************

	public void jsClick(WebElement element) {

		int attempts = 0;

		while (attempts < 3) {

			try {

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				js.executeScript("arguments[0].click();", element);

				return;

			} catch (StaleElementReferenceException e) {

				attempts++;
			}
		}

		throw new RuntimeException("Unable to JS click element due to StaleElementReferenceException.");
	}

	public void smartClick(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		for (int i = 1; i <= 3; i++) {

			try {

				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

				wait.until(ExpectedConditions.elementToBeClickable(locator));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				element.click();

				System.out.println("Clicked normally");
				return;

			} catch (Exception e1) {

				try {

					WebElement element = driver.findElement(locator);

					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

					System.out.println("Clicked using JavaScript");
					return;

				} catch (Exception e2) {

					try {

						WebElement element = driver.findElement(locator);

						Actions actions = new Actions(driver);

						actions.moveToElement(element).pause(Duration.ofMillis(500)).click().perform();

						System.out.println("Clicked using Actions");
						return;

					} catch (Exception e3) {

						System.out.println("Retry : " + i);

						driver.switchTo().defaultContent();

						driver.switchTo().frame("login");
						driver.switchTo().frame("main");
						driver.switchTo().frame("frm2");
					}
				}
			}
		}

		throw new RuntimeException("Unable to click element : " + locator);
	}

	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
	}

	// **************** ALERT ****************

	public void acceptAlert() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void scrollToElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}

	public void switchToChildWindow(String parentWindow) {

		for (String windowHandle : driver.getWindowHandles()) {

			if (!windowHandle.equals(parentWindow)) {

				driver.switchTo().window(windowHandle);

				return;
			}
		}

		throw new RuntimeException("Child window not found");
	}

	public void clickMultipleTimes(WebElement button, int count) {

		for (int i = 0; i < count; i++) {
			click(button);
		}
	}

	public void closeNewWindowIfOpened(String parentWindow) {

		long endTime = System.currentTimeMillis() + 5000;

		while (System.currentTimeMillis() < endTime) {

			Set<String> windows = driver.getWindowHandles();

			// If only parent window exists, keep checking
			if (windows.size() > 1) {

				for (String handle : windows) {

					if (!handle.equals(parentWindow)) {

						driver.switchTo().window(handle);

						System.out.println("New window found: " + driver.getCurrentUrl());

						driver.close();

						System.out.println("New window closed.");

						break;
					}
				}

				break;
			}

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}

		// ALWAYS return to original window
		driver.switchTo().window(parentWindow);

		System.out.println("Current window: " + driver.getCurrentUrl());
	}

	public void closeNewWindowAndReturnToParent(String parentWindow) throws TimeoutException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait only for a short time for a new window
		boolean newWindowOpened = wait.until(d -> d.getWindowHandles().size() > 1);

		if (newWindowOpened) {

			System.out.println("New window detected. Total windows = " + driver.getWindowHandles().size());

			for (String handle : driver.getWindowHandles()) {

				if (!handle.equals(parentWindow)) {

					driver.switchTo().window(handle);

					System.out.println("Closing new window: " + driver.getCurrentUrl());

					driver.close();

					break;
				}
			}
		}

		// Always return to parent
		driver.switchTo().window(parentWindow);

		System.out.println("Current window after cleanup: " + driver.getCurrentUrl());
	}
	public void selectPikadayDate(
	        WebElement calendarIcon,
	        WebElement dateInput,
	        String targetDateString,
	        boolean roundTrip,
	        String referenceDateString) throws Throwable {

	    // ============================================================
	    // TARGET DATE
	    // ============================================================

	    LocalDate targetDate =
	            parseInputDate(targetDateString);

	    int targetDay =
	            targetDate.getDayOfMonth();

	    YearMonth targetMonth =
	            YearMonth.from(targetDate);


	    // ============================================================
	    // REFERENCE DATE
	    //
	    // Normal departure:
	    // referenceDateString = null
	    //
	    // Multi-city Segment 2:
	    // referenceDateString = Segment 1 departure date
	    // ============================================================

	    YearMonth referenceMonth = null;

	    if (referenceDateString != null
	            && !referenceDateString.trim().isEmpty()) {

	        LocalDate referenceDate =
	                parseInputDate(referenceDateString);

	        referenceMonth =
	                YearMonth.from(referenceDate);
	    }


	    System.out.println(
	            "==================================================");

	    System.out.println(
	            "Selecting Date : " + targetDateString);

	    System.out.println(
	            "Target Month   : " + targetMonth);

	    System.out.println(
	            "Target Day     : " + targetDay);

	    System.out.println(
	            "Round Trip     : " + roundTrip);

	    System.out.println(
	            "Reference Date : " + referenceDateString);

	    System.out.println(
	            "Reference Month: " + referenceMonth);

	    System.out.println(
	            "==================================================");


	    WebDriverWait wait =
	            new WebDriverWait(
	                    driver,
	                    Duration.ofSeconds(20));


	    // ============================================================
	    // CALENDAR POPUP
	    // ============================================================

	    By calendarPopup =
	            By.xpath(
	                    "//div[contains(@class,'calendar-popup') "
	                    + "and contains(@class,'homepageCalender')]");


	    // ============================================================
	    // OPEN CALENDAR
	    // ============================================================

	    WebElement icon =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            calendarIcon));


	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].scrollIntoView({block:'center'});",
	                    icon);

	    Thread.sleep(300);


	    try {

	        icon.click();

	    } catch (Exception e) {

	        System.out.println(
	                "Normal calendar click failed. "
	                + "Using JS click.");

	        ((JavascriptExecutor) driver)
	                .executeScript(
	                        "arguments[0].click();",
	                        icon);
	    }


	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    calendarPopup));


	    System.out.println(
	            "Calendar opened.");


	    // ============================================================
	    // STEP 1
	    //
	    // IF REFERENCE MONTH IS PROVIDED,
	    // FIRST MOVE CALENDAR TO REFERENCE MONTH.
	    //
	    // Example:
	    //
	    // Segment 1 = 14-Oct-2026
	    // Calendar opens = Sep-2026
	    //
	    // Sep -> NEXT -> Oct
	    //
	    // Once Oct is reached, this loop STOPS.
	    // ============================================================

	    if (referenceMonth != null) {

	        boolean referenceMonthReached = false;


	        for (int attempt = 0; attempt < 24; attempt++) {

	            WebElement calendar =
	                    wait.until(
	                            ExpectedConditions
	                                    .visibilityOfElementLocated(
	                                            calendarPopup));


	            List<YearMonth> displayedMonths =
	                    getDisplayedMonths(
	                            calendar.getText());


	            System.out.println(
	                    "Reference navigation - displayed months = "
	                    + displayedMonths);

	            System.out.println(
	                    "Reference month = "
	                    + referenceMonth);


	            if (displayedMonths.isEmpty()) {

	                throw new RuntimeException(
	                        "Unable to read calendar month.");
	            }


	            // ====================================================
	            // REFERENCE MONTH FOUND
	            // ====================================================

	            if (displayedMonths.contains(
	                    referenceMonth)) {

	                System.out.println(
	                        "Reference month reached: "
	                        + referenceMonth);

	                referenceMonthReached = true;

	                break;
	            }


	            YearMonth firstDisplayed =
	                    displayedMonths.get(0);

	            YearMonth lastDisplayed =
	                    displayedMonths.get(
	                            displayedMonths.size() - 1);


	            // ====================================================
	            // REFERENCE MONTH IS BEFORE
	            // ====================================================

	            if (referenceMonth.isBefore(
	                    firstDisplayed)) {

	                System.out.println(
	                        "Reference month is BEFORE "
	                        + "current calendar month.");

	                clickPreviousMonth(
	                        calendar,
	                        wait);

	                Thread.sleep(700);

	                continue;
	            }


	            // ====================================================
	            // REFERENCE MONTH IS AFTER
	            // ====================================================

	            if (referenceMonth.isAfter(
	                    lastDisplayed)) {

	                System.out.println(
	                        "Reference month is AFTER "
	                        + "current calendar month.");

	                clickNextMonth(
	                        calendar,
	                        wait);

	                Thread.sleep(700);

	                continue;
	            }
	        }


	        if (!referenceMonthReached) {

	            throw new RuntimeException(
	                    "Unable to reach reference month: "
	                    + referenceMonth);
	        }
	    }


	    // ============================================================
	    // STEP 2
	   

	    boolean targetMonthReached = false;


	    for (int attempt = 0; attempt < 24; attempt++) {

	        WebElement calendar =
	                wait.until(
	                        ExpectedConditions
	                                .visibilityOfElementLocated(
	                                        calendarPopup));


	        List<YearMonth> displayedMonths =
	                getDisplayedMonths(
	                        calendar.getText());


	        System.out.println(
	                "Target navigation - displayed months = "
	                + displayedMonths);

	        System.out.println(
	                "Target month = "
	                + targetMonth);


	        if (displayedMonths.isEmpty()) {

	            throw new RuntimeException(
	                    "Unable to read calendar month.");
	        }


	        // ========================================================
	        // TARGET MONTH FOUND
	        // ========================================================

	        if (displayedMonths.contains(
	                targetMonth)) {

	            System.out.println(
	                    "Target month found: "
	                    + targetMonth);

	            targetMonthReached = true;

	            break;
	        }


	        YearMonth firstDisplayed =
	                displayedMonths.get(0);

	        YearMonth lastDisplayed =
	                displayedMonths.get(
	                        displayedMonths.size() - 1);


	        // ========================================================
	        // TARGET MONTH IS BEFORE
	        // ========================================================

	        if (targetMonth.isBefore(
	                firstDisplayed)) {

	            System.out.println(
	                    "Target month is BEFORE "
	                    + "displayed month.");

	            clickPreviousMonth(
	                    calendar,
	                    wait);

	            Thread.sleep(700);

	            continue;
	        }


	        // ========================================================
	        // TARGET MONTH IS AFTER
	        // ========================================================

	        if (targetMonth.isAfter(
	                lastDisplayed)) {

	            System.out.println(
	                    "Target month is AFTER "
	                    + "displayed month.");

	            clickNextMonth(
	                    calendar,
	                    wait);

	            Thread.sleep(700);

	            continue;
	        }
	    }


	    // ============================================================
	    // TARGET MONTH MUST BE REACHED
	    // ============================================================

	    if (!targetMonthReached) {

	        throw new RuntimeException(
	                "Unable to reach target month "
	                + targetMonth);
	    }


	    // ============================================================
	    // GET FINAL CALENDAR
	    // ============================================================

	    WebElement calendar =
	            wait.until(
	                    ExpectedConditions
	                            .visibilityOfElementLocated(
	                                    calendarPopup));


	    List<YearMonth> finalMonths =
	            getDisplayedMonths(
	                    calendar.getText());


	    System.out.println(
	            "Final displayed months = "
	            + finalMonths);


	    if (!finalMonths.contains(
	            targetMonth)) {

	        throw new RuntimeException(
	                "Unable to reach target month "
	                + targetMonth
	                + ". Displayed = "
	                + finalMonths);
	    }


	    // ============================================================
	    // FIND TARGET DATE
	    // ============================================================

	    WebElement dateElement =
	            findDateElementInsideCorrectMonth(
	                    calendar,
	                    targetMonth,
	                    targetDay);


	    if (dateElement == null) {

	        throw new RuntimeException(
	                "Target date "
	                + targetDay
	                + " not found inside "
	                + targetMonth
	                + ". Date may be disabled/unavailable.");
	    }


	    // ============================================================
	    // SCROLL TO DATE
	    // ============================================================

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].scrollIntoView({block:'center'});",
	                    dateElement);

	    Thread.sleep(300);


	    // ============================================================
	    // CLICK DATE
	    // ============================================================

	    try {

	        wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        dateElement));

	        dateElement.click();

	        System.out.println(
	                "Date clicked normally.");

	    } catch (Exception e) {

	        System.out.println(
	                "Normal date click failed. "
	                + "Using JS click.");

	        ((JavascriptExecutor) driver)
	                .executeScript(
	                        "arguments[0].click();",
	                        dateElement);
	    }


	    System.out.println(
	            "Successfully clicked date: "
	            + targetDateString);


	    Thread.sleep(500);


	    // ============================================================
	    // ROUND TRIP
	    // ============================================================

	    if (roundTrip) {

	        System.out.println(
	                "Round Trip = TRUE");

	        System.out.println(
	                "Departure selected.");

	        System.out.println(
	                "Calendar remains OPEN "
	                + "for return date.");

	        return;
	    }


	    // ============================================================
	    // VERIFY DATE INPUT
	    // ============================================================

	    try {

	        wait.until(driver -> {

	            try {

	                String value =
	                        dateInput.getAttribute("value");


	                System.out.println(
	                        "Date input value = "
	                        + value);


	                return value != null
	                        && value.contains(
	                                String.valueOf(targetDay));

	            } catch (StaleElementReferenceException e) {

	                return false;
	            }
	        });

	    } catch (Exception e) {

	        System.out.println(
	                "Date input verification failed: "
	                + e.getMessage());
	    }


	    System.out.println(
	            "Date selected successfully: "
	            + dateInput.getAttribute("value"));
	}	private void clickPreviousMonth(
	        WebElement calendar,
	        WebDriverWait wait) {

	    By previousButton =
	            By.xpath(
	                    ".//button["
	                    + ".//mat-icon["
	                    + "normalize-space()='arrow_back'"
	                    + " or normalize-space()='keyboard_arrow_left'"
	                    + " or normalize-space()='chevron_left'"
	                    + "]"
	                    + "]");

	    WebElement previous =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            calendar.findElement(
	                                    previousButton)));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    previous);
	}
	
	private void clickNextMonth(
	        WebElement calendar,
	        WebDriverWait wait) {

	    By nextButton =
	            By.xpath(
	                    ".//button["
	                    + ".//mat-icon["
	                    + "normalize-space()='arrow_forward'"
	                    + " or normalize-space()='keyboard_arrow_right'"
	                    + " or normalize-space()='chevron_right'"
	                    + "]"
	                    + "]");

	    WebElement next =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            calendar.findElement(
	                                    nextButton)));

	    ((JavascriptExecutor) driver)
	            .executeScript(
	                    "arguments[0].click();",
	                    next);
	}
	private YearMonth parseCalendarMonth(String calendarText) {

	    // FORMAT 1: September 2026
	    DateTimeFormatter fullFormatter =
	            new DateTimeFormatterBuilder()
	                    .parseCaseInsensitive()
	                    .appendPattern("MMMM yyyy")
	                    .toFormatter(Locale.ENGLISH);

	    Pattern fullPattern = Pattern.compile(
	            "(January|February|March|April|May|June|July|August|"
	            + "September|October|November|December)"
	            + "\\s+\\d{4}",
	            Pattern.CASE_INSENSITIVE
	    );

	    Matcher fullMatcher = fullPattern.matcher(calendarText);

	    if (fullMatcher.find()) {

	        String monthYear = fullMatcher.group().trim();

	        System.out.println("Parsed FULL calendar month = " + monthYear);

	        return YearMonth.parse(monthYear, fullFormatter);
	    }


	    // FORMAT 2: Sep 2026
	    DateTimeFormatter shortFormatter =
	            new DateTimeFormatterBuilder()
	                    .parseCaseInsensitive()
	                    .appendPattern("MMM yyyy")
	                    .toFormatter(Locale.ENGLISH);

	    Pattern shortPattern = Pattern.compile(
	            "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)"
	            + "\\s+\\d{4}",
	            Pattern.CASE_INSENSITIVE
	    );

	    Matcher shortMatcher = shortPattern.matcher(calendarText);

	    if (shortMatcher.find()) {

	        String monthYear = shortMatcher.group().trim();

	        System.out.println("Parsed SHORT calendar month = " + monthYear);

	        return YearMonth.parse(monthYear, shortFormatter);
	    }

	    throw new RuntimeException(
	            "Unable to parse calendar month from text: " + calendarText
	    );
	}
	

	private LocalDate parseInputDate(String date) {

		String value = date == null ? "" : date.trim();

		String[] patterns = { "dd-MMM-yyyy", "dd-MM-yyyy", "d-MMM-yyyy", "dd/MM/yyyy", "yyyy-MM-dd" };

		for (String pattern : patterns) {

			try {

				DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
						.appendPattern(pattern).toFormatter(Locale.ENGLISH);

				return LocalDate.parse(value, formatter);

			} catch (Exception ignored) {
				// Try next format
			}
		}

		throw new IllegalArgumentException("Unsupported date format: [" + date + "]");
	}

	public void selectRoundTripDates(WebElement departureCalendarIcon, String departureDate, String returnDate)
			throws Throwable {

		System.out.println("===== ROUND TRIP DATE SELECTION STARTED =====");

		LocalDate departure = parseInputDate(departureDate);
		LocalDate returnDt = parseInputDate(returnDate);

		if (returnDt.isBefore(departure)) {
			throw new IllegalArgumentException("Return date cannot be before departure date");
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By calendarPopup = By
				.xpath("//div[contains(@class,'calendar-popup') " + "and contains(@class,'homepageCalender')]");

		
		// 1. OPEN DEPARTURE CALENDAR ONLY ONCE
		

		System.out.println("Opening DEPARTURE calendar...");

		WebElement departureIcon = wait.until(ExpectedConditions.elementToBeClickable(departureCalendarIcon));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", departureIcon);

		wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		System.out.println("Departure calendar OPENED.");

		
		// 2. SELECT DEPARTURE
		

		System.out.println("Selecting DEPARTURE: " + departureDate);

		selectDateFromOpenCalendar(calendarPopup, departure, "DEPARTURE");

		System.out.println("Departure selected: " + departureDate);

		// 3. SAME CALENDAR -> SELECT RETURN
		

		System.out.println("Selecting RETURN from SAME calendar: " + returnDate);

		selectDateFromOpenCalendar(calendarPopup, returnDt, "RETURN");

		System.out.println("Return selected: " + returnDate);

		System.out.println("Both departure and return dates selected.");

		System.out.println("===== ROUND TRIP DATE SELECTION COMPLETED =====");
	}

	public void closeRoundTripCalendar() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By calendarPopup = By
				.xpath("//div[contains(@class,'calendar-popup') " + "and contains(@class,'homepageCalender')]");

		By bookingDetailsField = By.xpath("//mat-form-field[.//*[contains(normalize-space(.),'Booking details')]]");

		// Check whether calendar is actually open
		List<WebElement> calendars = driver.findElements(calendarPopup);

		if (calendars.isEmpty()) {
			System.out.println("Round trip calendar is already closed.");
			return;
		}

		if (!calendars.get(0).isDisplayed()) {
			System.out.println("Round trip calendar is already closed.");
			return;
		}

		System.out.println("Calendar still open. Clicking outside calendar...");

		WebElement bookingDetails = wait.until(ExpectedConditions.presenceOfElementLocated(bookingDetailsField));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", bookingDetails);

		Thread.sleep(300);

		// Click the actual form-field outside the calendar
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookingDetails);

		// Give Angular time to process outside click
		Thread.sleep(500);

		// Verify calendar closed
		boolean closed = wait.until(ExpectedConditions.invisibilityOfElementLocated(calendarPopup));

		if (closed) {
			System.out.println("Round trip calendar CLOSED successfully.");
		}
	}

	private void selectDateFromOpenCalendar(By calendarPopupLocator, LocalDate targetDate, String dateType)
			throws Throwable {

		int targetDay = targetDate.getDayOfMonth();

		YearMonth targetMonth = YearMonth.from(targetDate);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		for (int attempt = 0; attempt < 24; attempt++) {

			WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopupLocator));

			String calendarText = calendar.getText();

			List<YearMonth> displayedMonths = getDisplayedMonths(calendarText);

			System.out.println(dateType + " search: Looking for [" + targetMonth + "]. Displayed months on UI: "
					+ displayedMonths);

			
			// TARGET MONTH FOUND
			

			if (displayedMonths.contains(targetMonth)) {

				WebElement dateElement = findDateElementInsideCorrectMonth(calendar, targetMonth, targetDay);

				if (dateElement == null) {

					throw new RuntimeException(dateType + " date not found: " + targetDay);
				}

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
						dateElement);

				Thread.sleep(300);

				try {

					dateElement.click();

				} catch (Exception e) {

					((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement);
				}

				System.out.println("Successfully clicked " + dateType + " date: " + targetDay);

				Thread.sleep(700);

				return;
			}

			
			// NAVIGATION
			
			if (displayedMonths.isEmpty()) {

				throw new RuntimeException("Unable to parse calendar month: " + calendarText);
			}

			YearMonth firstDisplayed = displayedMonths.get(0);

			YearMonth lastDisplayed = displayedMonths.get(displayedMonths.size() - 1);

			// Previous
			if (targetMonth.isBefore(firstDisplayed)) {

				By previousButton = By.xpath(".//button[.//mat-icon[" + "normalize-space()='arrow_back' "
						+ "or normalize-space()='keyboard_arrow_left' " + "or normalize-space()='chevron_left'" + "]]");

				WebElement previous = calendar.findElement(previousButton);

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", previous);

				Thread.sleep(700);

				continue;
			}

			// Next
			if (targetMonth.isAfter(lastDisplayed)) {

				By nextButton = By.xpath(".//button[.//mat-icon[" + "normalize-space()='arrow_forward' "
						+ "or normalize-space()='keyboard_arrow_right' " + "or normalize-space()='chevron_right'"
						+ "]]");

				WebElement next = calendar.findElement(nextButton);

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", next);

				Thread.sleep(700);

				continue;
			}
		}

		throw new RuntimeException("Unable to select " + dateType + " date: " + targetDate);
	}

	private List<YearMonth> getDisplayedMonths(String calendarText) {

		List<YearMonth> months = new ArrayList<>();

		
		// FULL MONTHS
		

		Pattern fullPattern = Pattern.compile("\\b(January|February|March|April|May|June|July|August|"
				+ "September|October|November|December)" + "\\s+\\d{4}\\b", Pattern.CASE_INSENSITIVE);

		Matcher fullMatcher = fullPattern.matcher(calendarText);

		while (fullMatcher.find()) {

			try {

				YearMonth month = parseCalendarMonth(fullMatcher.group());

				if (!months.contains(month)) {
					months.add(month);
				}

			} catch (Exception ignored) {
			}
		}

		
		// SHORT MONTHS
		

		Pattern shortPattern = Pattern.compile("\\b(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)" + "\\s+\\d{4}\\b",
				Pattern.CASE_INSENSITIVE);

		Matcher shortMatcher = shortPattern.matcher(calendarText);

		while (shortMatcher.find()) {

			try {

				YearMonth month = parseCalendarMonth(shortMatcher.group());

				if (!months.contains(month)) {
					months.add(month);
				}

			} catch (Exception ignored) {
			}
		}

		return months;
	}

	private WebElement findDateElementInsideCorrectMonth(WebElement calendarPopup, YearMonth targetMonth,
			int targetDay) {

		String fullMonthText = targetMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " "
				+ targetMonth.getYear();

		String shortMonthText = targetMonth.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " "
				+ targetMonth.getYear();

		By monthHeaderLocator = By.xpath(
				".//*[normalize-space(.)='" + fullMonthText + "' or normalize-space(.)='" + shortMonthText + "']");

		List<WebElement> monthHeaders = calendarPopup.findElements(monthHeaderLocator);

		for (WebElement monthHeader : monthHeaders) {

			WebElement current = monthHeader;

			for (int level = 0; level < 8; level++) {

				try {

					List<WebElement> dates = current.findElements(By.xpath(".//td["
							+ "not(contains(@class,'disabled')) " + "and not(contains(@class,'is-disabled'))" + "]"
							+ "[.//span[normalize-space()='" + targetDay + "']" + " or .//div[normalize-space()='"
							+ targetDay + "']" + " or normalize-space()='" + targetDay + "']"));

					for (WebElement date : dates) {

						if (date.isDisplayed()) {
							return date;
						}
					}

					current = current.findElement(By.xpath(".."));

				} catch (Exception e) {
					break;
				}
			}
		}

		return null;
	}

    

	public void waitForAttributeValue(WebElement element, String attribute, String expectedValue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.attributeToBe(element, attribute, expectedValue));
	}

	// in case of Guest Add Dob

	public void selectDateAndConfirm(WebElement calendarIcon, String date) throws Throwable {

		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yyyy")
				.toFormatter(Locale.ENGLISH);

		LocalDate targetDate = LocalDate.parse(date.trim(), formatter);

		int targetDay = targetDate.getDayOfMonth();
		int targetYear = targetDate.getYear();

		String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		
		// 1. OPEN CALENDAR
		

		wait.until(ExpectedConditions.elementToBeClickable(calendarIcon)).click();

		By calendarPopup = By.xpath("//div[contains(@class,'calendar-popup')]");

		WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		// 2. SELECT YEAR
		

		By yearElement = By.xpath(".//*[normalize-space(text())='" + targetYear + "']");

		wait.until(ExpectedConditions.elementToBeClickable(calendar.findElement(yearElement))).click();

		System.out.println("Selected Year : " + targetYear);

		
		// 3. SELECT MONTH
		

		By monthElement = By.xpath(".//*[normalize-space(text())='" + targetMonth + "']");

		wait.until(ExpectedConditions.elementToBeClickable(calendar.findElement(monthElement))).click();

		System.out.println("Selected Month : " + targetMonth);

		
		// 4. SELECT DAY
		

		By dayElement = By
				.xpath(".//div[contains(@class,'day-cell')]" + "[.//div[normalize-space(text())='" + targetDay + "']]");

		WebElement day = wait.until(ExpectedConditions.elementToBeClickable(calendar.findElement(dayElement)));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", day);

		day.click();

		System.out.println("Selected Day : " + targetDay);

	
		// 5. CLICK CONFIRM


		By confirmButton = By.xpath(".//button[.//span[normalize-space()='Confirm']]");

		WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(calendar.findElement(confirmButton)));

		confirm.click();

		System.out.println("Date Selected Successfully : " + date);

		
		// 6. WAIT FOR CALENDAR TO CLOSE
	

		wait.until(ExpectedConditions.invisibilityOfElementLocated(calendarPopup));
	}

	public void selectPassportExpiryDate(WebElement calendarIcon, String date) throws Throwable {

		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yyyy")
				.toFormatter(Locale.ENGLISH);

		LocalDate targetDate = LocalDate.parse(date.trim(), formatter);

		int targetDay = targetDate.getDayOfMonth();
		int targetYear = targetDate.getYear();

		String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By calendarPopup = By.xpath("//div[contains(@class,'calendar-popup')]");

		
		// 1. OPEN CALENDAR
	

		wait.until(ExpectedConditions.elementToBeClickable(calendarIcon)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		System.out.println("=================================");
		System.out.println("Passport Expiry Date : " + date);
		System.out.println("Target Year          : " + targetYear);
		System.out.println("Target Month         : " + targetMonth);
		System.out.println("Target Day           : " + targetDay);
		System.out.println("=================================");

	
		// 2. CLICK CURRENT MONTH/YEAR
	

		WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		List<WebElement> elements = calendar.findElements(By.xpath(".//*"));

		WebElement monthYearHeader = null;

		for (WebElement element : elements) {

			String text = element.getText().trim();

			if (text.matches("(?i)(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)\\s+\\d{4}")) {

				monthYearHeader = element;
				break;
			}
		}

		if (monthYearHeader == null) {
			throw new RuntimeException("Current Month/Year header not found");
		}

		System.out.println("Current Calendar : " + monthYearHeader.getText());

		monthYearHeader.click();

		// =====================================================
		// 3. SELECT YEAR
		// =====================================================

		calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		By yearLocator = By.xpath(".//*[normalize-space(text())='" + targetYear + "']");

		WebElement yearElement = wait.until(ExpectedConditions.elementToBeClickable(calendar.findElement(yearLocator)));

		System.out.println("Clicking Year : " + targetYear);

		yearElement.click();

		// =====================================================
		// 4. SELECT MONTH
		// =====================================================

		calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		By monthLocator = By.xpath(".//*[normalize-space(translate(text()," + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
				+ "'abcdefghijklmnopqrstuvwxyz'))='" + targetMonth.toLowerCase() + "']");

		WebElement monthElement = wait
				.until(ExpectedConditions.elementToBeClickable(calendar.findElement(monthLocator)));

		System.out.println("Clicking Month : " + targetMonth);

		monthElement.click();

		// =====================================================
		// 5. WAIT UNTIL TARGET MONTH/YEAR CALENDAR IS DISPLAYED
		// =====================================================

		String expectedHeader = targetMonth.toUpperCase() + " " + targetYear;

		wait.until(driver -> {

			try {

				WebElement cal = driver.findElement(calendarPopup);

				String text = cal.getText();

				return text.toUpperCase().contains(expectedHeader);

			} catch (Exception e) {

				return false;
			}
		});

		System.out.println("Target Calendar Displayed : " + expectedHeader);

		
		// 6. SELECT TARGET DAY
		

		calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		
		By dayLocator = By.xpath(".//div[contains(@class,'day-grid')]" + "//*[normalize-space(text())='" + targetDay
				+ "' " + "and not(*)]");

		System.out.println("Searching Day : " + targetDay);

		List<WebElement> dayElements = calendar.findElements(dayLocator);

		System.out.println("Matching day elements : " + dayElements.size());

		WebElement targetDayElement = null;

		for (WebElement day : dayElements) {

			if (day.isDisplayed()) {

				System.out.println("Found visible day : " + day.getText());

				targetDayElement = day;
				break;
			}
		}

		if (targetDayElement == null) {

			throw new RuntimeException("Day " + targetDay + " not found in calendar " + expectedHeader);
		}

		System.out.println("Day element found : " + targetDayElement.getText());

		// Bring it into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", targetDayElement);

		// Click
		wait.until(ExpectedConditions.visibilityOf(targetDayElement));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetDayElement);

		System.out.println("Selected Day : " + targetDay);
	
		// 7. CLICK CONFIRM
	

		calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

		By confirmLocator = By.xpath(".//button[.//span[normalize-space()='Confirm']]");

		WebElement confirmButton = wait
				.until(ExpectedConditions.elementToBeClickable(calendar.findElement(confirmLocator)));

		System.out.println("Clicking Confirm");

		confirmButton.click();

		
		// 8. WAIT FOR CALENDAR TO CLOSE
		

		wait.until(ExpectedConditions.invisibilityOfElementLocated(calendarPopup));

		System.out.println("Passport Expiry Date Selected Successfully : " + date);
	}
	
	public void selectDOBDate(WebElement dobInput, String dob) throws Exception {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(30));

	    DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern(
	                    "dd-MMM-yyyy",
	                    Locale.ENGLISH
	            );

	    // =====================================================
	    // 1. PARSE DOB
	    // =====================================================

	    LocalDate targetDate =
	            LocalDate.parse(dob.trim(), formatter);

	    int targetYear =
	            targetDate.getYear();

	    Month targetMonth =
	            targetDate.getMonth();

	    int targetDay =
	            targetDate.getDayOfMonth();

	    String targetMonthShort =
	            targetMonth.getDisplayName(
	                    TextStyle.SHORT,
	                    Locale.ENGLISH
	            );

	    System.out.println("=================================");
	    System.out.println("DOB          : " + dob);
	    System.out.println("Target Year  : " + targetYear);
	    System.out.println("Target Month : " + targetMonthShort);
	    System.out.println("Target Day   : " + targetDay);
	    System.out.println("=================================");


	    // =====================================================
	    // 2. OPEN DOB CALENDAR
	    // =====================================================

	    WebElement input =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            dobInput
	                    )
	            );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            input
	    );

	    input.click();

	    System.out.println("DOB calendar opened");


	    // =====================================================
	    // 3. CALENDAR POPUP
	    // =====================================================

	    By calendar =
	            By.xpath(
	                    "//app-date-of-birth-calendar" +
	                    "//div[contains(@class,'calendar-popup')]"
	            );

	    wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    calendar
	            )
	    );


	    // =====================================================
	    // 4. CALENDAR HEADER
	    // =====================================================

	    By headerLocator =
	            By.xpath(
	                    "//app-date-of-birth-calendar" +
	                    "//div[contains(@class,'calendar-popup')]" +
	                    "//div[contains(@class,'calendar-header')]"
	            );


	    // =====================================================
	    // 5. PREVIOUS / NEXT
	    // =====================================================

	    By previousButton =
	            By.xpath(
	                    "//app-date-of-birth-calendar" +
	                    "//div[contains(@class,'calendar-popup')]" +
	                    "//div[contains(@class,'calendar-header')]" +
	                    "//button[1]"
	            );

	    By nextButton =
	            By.xpath(
	                    "//app-date-of-birth-calendar" +
	                    "//div[contains(@class,'calendar-popup')]" +
	                    "//div[contains(@class,'calendar-header')]" +
	                    "//button[last()]"
	            );


	    // =====================================================
	    // 6. SELECT YEAR
	    // =====================================================

	    System.out.println(
	            "Initial Calendar Header : "
	                    + driver.findElement(headerLocator).getText()
	    );


	    By targetYearLocator =
	            By.xpath(
	                    "//app-date-of-birth-calendar" +
	                    "//div[contains(@class,'calendar-popup')]" +
	                    "//*[normalize-space(text())='"
	                    + targetYear
	                    + "']"
	            );


	    List<WebElement> yearElements =
	            driver.findElements(targetYearLocator);


	    System.out.println(
	            "Target Year : "
	                    + targetYear
	    );

	    System.out.println(
	            "Year elements found : "
	                    + yearElements.size()
	    );


	    WebElement targetYearElement = null;


	    for (WebElement element : yearElements) {

	        try {

	            if (element.isDisplayed()) {

	                targetYearElement = element;

	                System.out.println(
	                        "Visible year found : "
	                                + element.getText()
	                );

	                break;
	            }

	        } catch (StaleElementReferenceException e) {

	            System.out.println(
	                    "Year element became stale."
	            );
	        }
	    }


	    if (targetYearElement == null) {

	        throw new RuntimeException(
	                "Target DOB year not found : "
	                        + targetYear
	        );
	    }


	    // =====================================================
	    // CLICK YEAR
	    // =====================================================

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            targetYearElement
	    );

	    Thread.sleep(300);

	    System.out.println(
	            "Clicking Year : "
	                    + targetYear
	    );


	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();",
	            targetYearElement
	    );


	    // Wait until year view disappears
	    wait.until(driver -> {

	        try {

	            String header =
	                    driver.findElement(headerLocator)
	                            .getText()
	                            .trim();

	            return !header.matches(
	                    "\\d{4}\\s*-\\s*\\d{4}"
	            );

	        } catch (Exception e) {

	            return false;
	        }
	    });


	    Thread.sleep(500);


	    System.out.println(
	            "Year selected successfully : "
	                    + targetYear
	    );

	    System.out.println(
	            "Calendar after Year : "
	                    + driver.findElement(headerLocator)
	                            .getText()
	    );


	    // =====================================================
	    // 7. SELECT MONTH
	    // =====================================================

	    System.out.println(
	            "Looking for Month : "
	                    + targetMonthShort
	    );


	  


	    By targetMonthLocator =
	            By.xpath(
	                    "//app-date-of-birth-calendar" +
	                    "//div[contains(@class,'calendar-popup')]" +
	                    "//*[normalize-space(text())='"
	                    + targetMonthShort
	                    + "']"
	            );


	    List<WebElement> monthElements =
	            driver.findElements(
	                    targetMonthLocator
	            );


	    System.out.println(
	            "Month elements found : "
	                    + monthElements.size()
	    );


	    WebElement targetMonthElement = null;


	    for (WebElement element : monthElements) {

	        try {

	            if (element.isDisplayed()) {

	                targetMonthElement = element;

	                System.out.println(
	                        "Target month found : "
	                                + element.getText()
	                );

	                break;
	            }

	        } catch (StaleElementReferenceException e) {

	            System.out.println(
	                    "Month element became stale."
	            );
	        }
	    }


	    if (targetMonthElement == null) {

	        throw new RuntimeException(
	                "Target DOB month not found : "
	                        + targetMonthShort
	        );
	    }


	    // =====================================================
	    // CLICK MONTH
	    // =====================================================

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            targetMonthElement
	    );

	    Thread.sleep(300);


	    System.out.println(
	            "Clicking Month : "
	                    + targetMonthShort
	    );


	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();",
	            targetMonthElement
	    );


	    // Wait for day calendar
	    Thread.sleep(700);


	    System.out.println(
	            "Calendar after Month : "
	                    + driver.findElement(headerLocator)
	                            .getText()
	    );


	    // =====================================================
	    // 8. SELECT DAY
	    // =====================================================

	 // =====================================================
	 // 8. SELECT DAY
	 // =====================================================

	 System.out.println(
	         "Looking for DOB Day : " + targetDay
	 );


	 // -----------------------------------------------------
	 // Find day inside the CURRENT calendar day grid
	 // -----------------------------------------------------

	 By targetDayLocator =
	         By.xpath(
	                 "//app-date-of-birth-calendar" +
	                 "//div[contains(@class,'calendar-popup')]" +
	                 "//div[contains(@class,'day-grid')]" +
	                 "//*[normalize-space(text())='" +
	                 targetDay +
	                 "']"
	         );


	 List<WebElement> dayElements =
	         driver.findElements(targetDayLocator);


	 System.out.println(
	         "Matching day elements : "
	                 + dayElements.size()
	 );


	 WebElement targetDayElement = null;


	 // -----------------------------------------------------
	 // Find visible day
	 // -----------------------------------------------------

	 for (WebElement element : dayElements) {

	     try {

	         if (element.isDisplayed()) {

	             String text =
	                     element.getText().trim();

	             System.out.println(
	                     "Visible day found : ["
	                             + text
	                             + "]"
	             );

	             if (text.equals(String.valueOf(targetDay))) {

	                 targetDayElement = element;

	                 break;
	             }
	         }

	     } catch (StaleElementReferenceException e) {

	         System.out.println(
	                 "Day element became stale. Searching again."
	         );
	     }
	 }


	 // -----------------------------------------------------
	 // Validate
	 // -----------------------------------------------------

	 if (targetDayElement == null) {

	     throw new RuntimeException(
	             "DOB day not found in current month: "
	                     + targetDay
	     );
	 }


	 // =====================================================
	 // CLICK TARGET DAY
	 // =====================================================

	 System.out.println(
	         "Target DOB Day Found : "
	                 + targetDay
	 );


	 ((JavascriptExecutor) driver).executeScript(
	         "arguments[0].scrollIntoView({block:'center'});",
	         targetDayElement
	 );


	 Thread.sleep(300);


	 // -----------------------------------------------------
	 // Try normal click first
	 // -----------------------------------------------------

	 try {

	     wait.until(
	             ExpectedConditions.elementToBeClickable(
	                     targetDayElement
	             )
	     );

	     targetDayElement.click();

	     System.out.println(
	             "Normal click successful for day : "
	                     + targetDay
	     );

	 } catch (Exception e) {

	     System.out.println(
	             "Normal click failed. Using JavaScript click."
	     );

	     ((JavascriptExecutor) driver).executeScript(
	             "arguments[0].click();",
	             targetDayElement
	     );
	 }


	 Thread.sleep(500);


	 System.out.println(
	         "DOB Day Selected : "
	                 + targetDay
	 );

	    // =====================================================
	    // CLICK DAY
	    // =====================================================

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            targetDayElement
	    );

	    Thread.sleep(300);


	    wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    targetDayElement
	            )
	    );


	    System.out.println(
	            "Clicking Day : "
	                    + targetDay
	    );


	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();",
	            targetDayElement
	    );


	    Thread.sleep(500);


	    System.out.println(
	            "DOB Day selected : "
	                    + targetDay
	    );


	    // =====================================================
	    // 9. CLICK CONFIRM
	    // =====================================================

	    By confirmLocator =
	            By.xpath(
	                    "//app-date-of-birth-calendar" +
	                    "//div[contains(@class,'calendar-popup')]" +
	                    "//button[normalize-space()='Confirm']"
	            );


	    WebElement confirm =
	            wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            confirmLocator
	                    )
	            );


	    System.out.println(
	            "Clicking Confirm"
	    );


	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();",
	            confirm
	    );


	    System.out.println("=================================");
	    System.out.println(
	            "DOB Selected Successfully : "
	                    + dob
	    );
	    System.out.println("=================================");
	}
	

	public void waitForLoaderToDisappear() throws TimeoutException {

	    By loaderLocator =
	            By.cssSelector("div.loader-overlay");

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(
		        ExpectedConditions.invisibilityOfElementLocated(
		                loaderLocator
		        )
		);

		System.out.println("Loader disappeared successfully.");
	}





}
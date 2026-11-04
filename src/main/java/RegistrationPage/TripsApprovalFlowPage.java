package RegistrationPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import modeles.CompanyprofileData;
import reports.ReportUtil;
import utilities.WebdriverUtility;

public class TripsApprovalFlowPage extends BasePage {

private WebdriverUtility webdriverutility;
	public TripsApprovalFlowPage(WebDriver driver) {
		super(driver);
		
		webdriverutility=new WebdriverUtility(driver);
		
	}

     @FindBy(xpath = "//a[contains(.,'Trips Approval')]")
	    private WebElement TripsApprovalbtn;


		 @FindBy(xpath = "//button[contains(.,'GTM CORPORATE')] ")
		    private WebElement GTMCorporatebtn;

        @FindBy(xpath = "(//a[contains(.,'Travelers')])[1]")
	private WebElement TravelersLink;

             @FindBy(xpath = "//a[contains(.,'Add new')]")
		    private WebElement AddNewLink;

              @FindBy(xpath = "//mat-select[@formcontrolname='productType']")
		    private WebElement ProductDropdown;
		
                @FindBy(xpath = "//mat-select[@formcontrolname='travelCategory']")
		    private WebElement TravelCategoryDropdown;
		
               @FindBy(xpath = "//mat-select[@formcontrolname='workFlowAppliedOn']")
		    private WebElement WorkFlowToDropdown;

            
              
 @FindBy(xpath = "//mat-option[@class='mat-mdc-option mdc-list-item mat-mdc-option-active' and contains(.,' Business ')]")
		    private WebElement TravelcategoryOption;

 @FindBy(xpath = "//mat-option[@class='mat-mdc-option mdc-list-item mat-mdc-option-active' and normalize-space(.)='Corporate']")
		    private WebElement WorkFlowAppliesOption;
 @FindBy(xpath = "//mat-form-field[.//mat-label[normalize-space()='Select Corporate(s)']]")
		    private WebElement SelectCorporate;

@FindBy(xpath = "//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable' and contains(.,'Save and continue')]")
		    private WebElement Saveandcontinuebtn;

			@FindBy(xpath = "//mat-select[@formcontrolname='totalApprovals']")
		    private WebElement TotalApproversDropdown;

			@FindBy(xpath = "//input[@data-control-name='inPolicyApproverIDL1']")
		    private WebElement InPolicyLevel1Nametxtbox;

           @FindBy(xpath = "//input[@data-control-name='inPolicyApproverIDL2']")
		    private WebElement InPolicyLevel2Nametxtbox;

			 @FindBy(xpath = "//input[@data-control-name='outPolicyApproverIDL1']")
		    private WebElement outPolicyLevel1Nametxtbox;



			 @FindBy(xpath = "//input[@data-control-name='outPolicyApproverIDL2']")
		    private WebElement outPolicyLevel2Nametxtbox;


			@FindBy(xpath = "//button[@mat-ripple-loader-class-name='mat-mdc-button-ripple' and contains(.,'Save workflow')]")
		    private WebElement SaveworkFlowbtn;

public void TripsApproval(CompanyprofileData data){


webdriverutility.click(GTMCorporatebtn);

WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
wait.until(ExpectedConditions.elementToBeClickable(TravelersLink));
webdriverutility.click(TravelersLink);
List<WebElement> employeeNames = driver.findElements(
    By.xpath("//table//tbody/tr/td[2]"));

String name1 = employeeNames.get(0).getText().trim();
ReportUtil.logInfo(name1);
String name2 = employeeNames.get(1).getText().trim();
ReportUtil.logInfo(name2);
String name3 = employeeNames.get(2).getText().trim();
ReportUtil.logInfo(name3);
String name4 = employeeNames.get(3).getText().trim();
ReportUtil.logInfo(name4);

System.out.println("Name 1: " + name1);
System.out.println("Name 2: " + name2);
System.out.println("Name 3: " + name3);
System.out.println("Name 4: " + name4);



webdriverutility.click(GTMCorporatebtn);


wait.until(ExpectedConditions.elementToBeClickable(TripsApprovalbtn));
webdriverutility.click(TripsApprovalbtn);

webdriverutility.click(AddNewLink);

wait.until(ExpectedConditions.elementToBeClickable(ProductDropdown));
webdriverutility.click(ProductDropdown);

String product=data.getProduct().trim();
String xpath= "//mat-option[normalize-space(.)='"  + product + "']";
 WebElement productoption = wait.until(ExpectedConditions.elementToBeClickable( By.xpath(xpath)));
        
          productoption.click();    

      
wait.until(ExpectedConditions.elementToBeClickable(TravelCategoryDropdown));

webdriverutility.click(TravelCategoryDropdown);

String TravelCategory=data.getTravelCategory().trim();
String TravelCategoryxpath= "//mat-option[normalize-space(.)='"  + TravelCategory + "']";
 WebElement TravelCategoryoption = wait.until(ExpectedConditions.elementToBeClickable( By.xpath(TravelCategoryxpath)));
TravelCategoryoption.click();
wait.until(ExpectedConditions.elementToBeClickable(WorkFlowToDropdown));

webdriverutility.click(WorkFlowToDropdown);

String Workflowappliesto=data.getRule_applied_on().trim();
String Workflowappliestoxpath= "//mat-option[normalize-space(.)='"  + Workflowappliesto + "']";
 WebElement Workflowappliestoption = wait.until(ExpectedConditions.elementToBeClickable( By.xpath(Workflowappliestoxpath)));
Workflowappliestoption.click();


String corporate = data.getCompany_Name().trim();
System.out.println(corporate);

wait.until(
        ExpectedConditions.elementToBeClickable(SelectCorporate)
);
SelectCorporate.click();

String corporateXpath ="//mat-option[contains(normalize-space(.),'" + corporate + "')]";
        
       

WebElement corporateOption = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
                By.xpath(corporateXpath)
        )
);
 

corporateOption.click();

   ReportUtil.logPass("All dta enterd in trips approval ");
       

wait.until(ExpectedConditions.elementToBeClickable(Saveandcontinuebtn));

webdriverutility.click(Saveandcontinuebtn);


String approvalFlow = data.getApprovalFlow().trim();

String approvalFlowxpath = "//label[normalize-space()='" + approvalFlow + "']";



WebElement approvalFlowradioLabel = wait.until(
        ExpectedConditions.elementToBeClickable(
                By.xpath(approvalFlowxpath)
        )
);

approvalFlowradioLabel.click();

ReportUtil.logInfo("Approval flow selected: " + approvalFlow);


String totalApprovers = data.getTotalApprovers().trim();

System.out.println(
    "Total Approvers from Excel = [" + totalApprovers + "]"
);
wait.until(ExpectedConditions.elementToBeClickable(
        TotalApproversDropdown));

TotalApproversDropdown.click();

String totalApproversxpath =
        "//mat-option[normalize-space(.)='" 
        + totalApprovers + "']";

WebElement approverOption = wait.until(
        ExpectedConditions.elementToBeClickable(
                By.xpath(totalApproversxpath)
        )
);

approverOption.click();

ReportUtil.logInfo(
        "Total approvers selected: " + totalApprovers);






int count = Integer.parseInt(totalApprovers);

System.out.println("Total Approvers = " + count);

if (count >= 1) {

    selectApprover(InPolicyLevel1Nametxtbox, name1);

    wait.until(ExpectedConditions.elementToBeClickable(
            outPolicyLevel1Nametxtbox));

    selectApprover(outPolicyLevel1Nametxtbox, name3);
}

if (count >= 2) {

    wait.until(ExpectedConditions.elementToBeClickable(
            InPolicyLevel2Nametxtbox));

    selectApprover(InPolicyLevel2Nametxtbox, name2);

    wait.until(ExpectedConditions.elementToBeClickable(
            outPolicyLevel2Nametxtbox));

    selectApprover(outPolicyLevel2Nametxtbox, name4);
}

wait.until(ExpectedConditions.elementToBeClickable(
        SaveworkFlowbtn));

System.out.println("All approvers selected. Clicking Save workflow.");

webdriverutility.click(SaveworkFlowbtn);
}







private void selectApprover(WebElement textbox, String name) {

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(30));

    System.out.println("Starting approver selection");
    System.out.println("Name = [" + name + "]");
    System.out.println("Textbox = [" +
            textbox.getAttribute("data-control-name") + "]");

    // Step 1: Wait for textbox visibility
    wait.until(ExpectedConditions.visibilityOf(textbox));

    // Step 2: Scroll textbox into the center of viewport
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
            textbox);

    wait.until(ExpectedConditions.elementToBeClickable(textbox));

    // Step 3: Click textbox using mouse interaction
    new Actions(driver)
            .moveToElement(textbox)
            .click()
            .perform();

    textbox.clear();
    textbox.sendKeys(name);

    System.out.println("Name typed: " + name);

    // Step 4: Find matching autocomplete suggestion
    By suggestionLocator = By.xpath(
            "//mat-option[contains(translate(normalize-space(.)," +
            "'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," +
            "'abcdefghijklmnopqrstuvwxyz')," +
            "'" + name.toLowerCase() + "')]"
    );

    WebElement suggestion = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    suggestionLocator)
    );

    System.out.println("Suggestion found: " +
            suggestion.getText());

    // Step 5: Scroll suggestion into view and click
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            suggestion);

    wait.until(ExpectedConditions.elementToBeClickable(
            suggestionLocator));

    driver.findElement(suggestionLocator).click();

    // Step 6: Verify selected name
    wait.until(d -> {
        String value = textbox.getAttribute("value");

        return value != null &&
                value.trim().equalsIgnoreCase(name.trim());
    });

    System.out.println("Approver selected successfully: " + name);
    ReportUtil.logInfo("Approver selected: " + name);
}



}
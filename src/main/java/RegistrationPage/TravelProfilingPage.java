package RegistrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import modeles.CompanyprofileData;
import reports.ReportUtil;
import utilities.TestDataGenerator;
import utilities.WebdriverUtility;

public class TravelProfilingPage extends BasePage {
	
private WebdriverUtility webdriverutility;
	public TravelProfilingPage(WebDriver driver) {
		super(driver);
		
		webdriverutility=new WebdriverUtility(driver);
		
	}
		
	  @FindBy(xpath = "//div[@class='custom-tree-heading' and contains(.,'Traveler profile ')]")
	    private WebElement Travellerprofilling;


		 @FindBy(xpath = "//button[contains(@class,'custom-tree-child') and .//div[contains(@class,'custom-tree-heading') and normalize-space()='Departments']]")
		    private WebElement Departmentbtn;
		
		 @FindBy(xpath="//a[@class='link' and contains(.,'Add new')]")
		    private WebElement AddNewLink;
		    
		 @FindBy(xpath="//mat-form-field[.//mat-label[normalize-space()='Select Office location']]")
		  private WebElement Select_Office_LocationName;
		    
		 @FindBy(xpath="//mat-form-field[.//mat-label[normalize-space()='Department name']]//input")
		    private WebElement Department_name_TxtBox;
		    
		  
		    @FindBy(xpath="//button[@class='mdc-button mat-mdc-button-base button--primary-small mat-mdc-button mat-unthemed _mat-animation-noopable']")
		    private WebElement SavebtnForAll;
		    
		    @FindBy(xpath="//*[contains(normalize-space(),'Department information has been saved successfully')]")
		    private WebElement DepartmentSuccessMsg;
		    //Designation
		    
		    @FindBy(xpath = "//button[contains(@class,'custom-tree-child') and .//div[contains(@class,'custom-tree-heading') and normalize-space()='Designation name']]")
		    private WebElement Designationbtn;
		    @FindBy(xpath="//a[.//mat-icon[normalize-space()='add'] and contains(normalize-space(), 'Add new')]")
		    private WebElement AddNewbutton;
		    
		    @FindBy(xpath="//mat-form-field[.//mat-label[normalize-space()='Add designation']]//input")
		    private WebElement Add_Designation_Textbox;
			    
		    @FindBy(xpath="//mat-form-field[.//mat-label[normalize-space()='Associate with Office location']]//input")
		    private WebElement Associate_with_Office_location;
			    
		    
		    @FindBy(xpath="//*[contains(normalize-space(),'Designation added successfully')]")
		    private WebElement DesignationSuccessMsg;
		    
		  //Employee Grade
		    
		    @FindBy(xpath="//button[contains(@class,'custom-tree-child') and normalize-space()='Employee grade']")
		    private WebElement Employee_Grade_Btn;
			    
		    
		    
		    @FindBy(xpath="//mat-form-field[.//mat-label[normalize-space()='Category Name']]//input")
		    private WebElement Category_Name_TextBox;

		    @FindBy(xpath="//mat-form-field[.//mat-label[normalize-space()='Category code']]//input")
		    private WebElement Category_Code_TextBox;
		    
		    @FindBy(xpath="//*[contains(normalize-space(),'Employee grade added successfully')]")
		    private WebElement EmployeegradeSuccessMsg;
		    
		    
		    //Travel Category
		    @FindBy(xpath="//button[contains(@class,'custom-tree-child') and .//div[contains(@class,'custom-tree-heading') and normalize-space()='Travel categories']]")
		    private WebElement Travel_categorybtn;
		    
		    @FindBy(xpath="//mat-form-field[.//mat-label[normalize-space()='Travel categories']]//input")
		    private WebElement Travel_categoriesTxt_box;
		    
		    @FindBy(xpath="//input[@formcontrolname='travelCategoryCode']")
		    private WebElement travelCategoryCode_Txt_box;
		    
		    @FindBy(xpath="//mat-radio-button[.//label[normalize-space()='Business Trip']]")
		    private WebElement BusinessRadiobtn;
		    
		    @FindBy(xpath="//mat-radio-button[@id='mat-radio-9']")
		    private WebElement FamilyTrip_RadioBtn;
		    
		    @FindBy(xpath="//mat-radio-button[@id='mat-radio-10']")
		    private WebElement Guest_User_RadioBtn;
		    
		    @FindBy(xpath="//mat-radio-button[.//label[normalize-space()='No']]")
		    private WebElement No_RadioBtn;
		    
		    @FindBy(xpath="//*[contains(normalize-space(),'Travel category added successfully')]")
		    private WebElement TravelCategorySuccessMsg;
		    
		    
		    
		    
		    public static  String DepartmentName;
		    public static String Designation;
		  
		
		
		 public void DepartmentDetails(CompanyprofileData data) throws Throwable {
			 
			 
			 DepartmentName = TestDataGenerator.generateDepartment_Name(
					    data.getDepartment_Name().trim()
					);

					System.out.println("Created Department Name: [" + DepartmentName + "]");
			 System.out.println(DepartmentName);
			  Designation=TestDataGenerator.generateDesignation(data.getDesignation().trim());
			  System.out.println("Created Department Name: [" + Designation + "]");

		     String officeLocation = CompnayProfilepage.getOfficeLocation();
		     String TravelCategory = CompnayProfilepage.getTravelCategory();
		     String CategoryName = CompnayProfilepage.getCategoryName();
		     String CategoryCode = CompnayProfilepage.getCategoryCode();
		     String TripType = CompnayProfilepage.getTripType();

			 
			 webdriverutility.click(Travellerprofilling);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.click(Departmentbtn);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.click(AddNewLink);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.selectMatOptionByVisibleText(Select_Office_LocationName,  officeLocation);
			 
			 Thread.sleep(3000);
			 webdriverutility.sendKeys(Department_name_TxtBox,DepartmentName);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.click(SavebtnForAll);
				Thread.sleep(2000);
			 
				if (DepartmentSuccessMsg.isDisplayed()) {

	    		    ReportUtil.logPass("Department information has been saved successfully");

	    		} else {

	    		    ReportUtil.logFail("Department validation failed");
	    		}
	    		
			 Thread.sleep(3000);
			 webdriverutility.click(Designationbtn);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.click(AddNewbutton);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.sendKeys(Add_Designation_Textbox,Designation );
			 
			 Thread.sleep(3000);
			 
			 
			 
			 webdriverutility.selectMatOptionByVisibleText(Associate_with_Office_location, officeLocation);
			 
				
			 webdriverutility.waitForClickable(SavebtnForAll);
	    		
	    		Thread.sleep(5000);
	    		webdriverutility.click(SavebtnForAll);
	    	
	    		Thread.sleep(2000);
				 
				if (DesignationSuccessMsg.isDisplayed()) {

	    		    ReportUtil.logPass("Designation added successfully");

	    		} else {

	    		    ReportUtil.logFail("Designation validation failed");
	    		}
	    		
				EmployeeGradeDetails(data);
	    		
				TravelCategoryDetails(data);
			 
			 
			 
			 
			 
		 }
		 public void EmployeeGradeDetails(CompanyprofileData data) throws Throwable {
			       
			   String CategoryName = CompnayProfilepage.getCategoryName();
			     String CategoryCode = CompnayProfilepage.getCategoryCode();
			 
			     String officeLocation = CompnayProfilepage.getOfficeLocation();
			 
			 webdriverutility.click(Employee_Grade_Btn);
			 
			 Thread.sleep(3000);
			 
			 
			 webdriverutility.click(AddNewLink);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.sendKeys(Category_Name_TextBox,CategoryName );
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.sendKeys(Category_Code_TextBox, CategoryCode);
			 
			 webdriverutility.selectMatOptionByVisibleText(Associate_with_Office_location, officeLocation);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.click(SavebtnForAll);
			 Thread.sleep(2000);
			 
				if (EmployeegradeSuccessMsg.isDisplayed()) {

	    		    ReportUtil.logPass("Employee grade added successfully");

	    		} else {

	    		    ReportUtil.logFail("Department validation failed");
	    		}
			 
			 
		 }
		 
		 public void TravelCategoryDetails(CompanyprofileData data) throws Throwable {
			 
			 String TravelCategory = CompnayProfilepage.getTravelCategory();
		     String CategoryCode = CompnayProfilepage.getCategoryCode();
		     String TripType = CompnayProfilepage.getTripType();
			 webdriverutility.click(Travel_categorybtn);
			 
			 Thread.sleep(3000);
			 
			 webdriverutility.click(AddNewLink);
			 
			 Thread.sleep(3000);
			 webdriverutility.sendKeys(Travel_categoriesTxt_box, TravelCategory);
			 
			 Thread.sleep(3000);
			 webdriverutility.sendKeys(travelCategoryCode_Txt_box, CategoryCode);
			 
			 TripType=data.getTripType();
			 if(TripType.equalsIgnoreCase("Business Trip")) {
				 
				 
				 webdriverutility.click(BusinessRadiobtn);
				 
			 }
			 else if(TripType.equalsIgnoreCase("Family Trip")) {
				 
				 webdriverutility.click(FamilyTrip_RadioBtn);
				 
				 
				 
			 }else if(TripType.equalsIgnoreCase("Guest User")){
				 
				 webdriverutility.click(Guest_User_RadioBtn);
				
				 
				 
			 }
				 
			 
			 webdriverutility.click(No_RadioBtn);
				 
			 Thread.sleep(3000);
			 
			 webdriverutility.click(SavebtnForAll);
			 
			 
			 Thread.sleep(2000);
			 
				if (TravelCategorySuccessMsg.isDisplayed()) {

	    		    ReportUtil.logPass("Travel category added  successfully");

	    		} else {

	    		    ReportUtil.logFail("Travel category  failed");
	    		}
			 
					 
			
		 }
			 
			public static String getDepartmentName() {
			    return DepartmentName;
			}
			public static String getDesignation() {
			    return Designation;
			}
 
			 
		 
		 
		 
		    
		
	

}

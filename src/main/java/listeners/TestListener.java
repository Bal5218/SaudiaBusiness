package listeners;

import java.util.Arrays;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import driver.Driverfactory;
import modeles.CompanyprofileData;
import modeles.FlightBookingData;
import reports.ExtentTestManager;
import utilities.ScreenshotUtils;


public class TestListener implements ITestListener {


	@Override
	public void onStart(ITestContext context) {

	    System.out.println("===== TEST SUITE STARTED =====");

	    ExtentTestManager.getReport();
	}


	@Override
	public void onTestStart(ITestResult result) {

	    System.out.println("===== onTestStart Called =====");

	    // GET DATAPROVIDER PARAMETERS
	    Object[] parameters = result.getParameters();

	    if (parameters.length == 0) {

	        System.out.println(
	                "No DataProvider parameters found.");

	        return;
	    }

	    Object data = parameters[0];


	  
	    // GET TEST CASE ID
	
	    String testCaseId =
	            getTestCaseId(data);


	    // GET TEST NAME
	    

	    String testName =
	            getTestName(data);


	   
	    // GET DESCRIPTION
	    

	    String description =
	            getDescription(data);


	  
	    // CREATE DISPLAY NAME
	  

	    String displayName;


	   
	    // FLIGHT BOOKING
	   

	    if (data instanceof FlightBookingData) {

	        FlightBookingData flightData =
	                (FlightBookingData) data;

	        String tripType =
	                flightData.getTripType() == null
	                ? ""
	                : flightData.getTripType().trim();


	        // Convert Excel value into report value
	        if (tripType.equalsIgnoreCase("One way")) {

	            tripType = "Oneway";

	        } else if (tripType.equalsIgnoreCase("Round trip")) {

	            tripType = "Roundtrip";
	        }


	        displayName =
	                "[" + testCaseId
	                + "(" + tripType + ")]";
	    }


	   
	    // OTHER TESTS
	   

	    else {

	        displayName =
	                testName
	                + " - ["
	                + testCaseId
	                + "] - "
	                + description;
	    }


	   
	    // CREATE EXTENT TEST
	  

	    ExtentReports report =
	            ExtentTestManager.getReport();

	    ExtentTest extentTest =
	            report.createTest(displayName);


	
	    // STORE CURRENT TEST
	  

	    ExtentTestManager.setTestCaseId(
	            testCaseId);

	    ExtentTestManager.setTest(
	            extentTest);


	    
	    // SESSION ID
	  

	    try {

	        if (Driverfactory.getDriver() != null) {

	            String sessionId =
	                    ((RemoteWebDriver)
	                            Driverfactory.getDriver())
	                            .getSessionId()
	                            .toString();

	            extentTest.info(
	                    "<b>Session ID :</b> "
	                    + sessionId);
	        }

	    } catch (Exception e) {

	        System.out.println(
	                "Unable to get Session ID");
	    }


	   
	    // CATEGORY / AUTHOR / DEVICE
	 

	    extentTest.assignCategory(
	            testName);

	    extentTest.assignAuthor(
	            "Ravi Bhushan");

	    extentTest.assignDevice(
	            "Chrome");


	   
	    // COMPANY PROFILE DATA
	    

	    if (data instanceof CompanyprofileData) {

	        CompanyprofileData companyData =
	                (CompanyprofileData) data;

	        logCompanyProfileData(
	                extentTest,
	                companyData);
	    }


	  
	    // FLIGHT BOOKING DATA
	 

	    if (data instanceof FlightBookingData) {

	        FlightBookingData flightData =
	                (FlightBookingData) data;

	        logFlightBookingData(
	                extentTest,
	                flightData);
	    }
	}
   
    // TEST SUCCESS
   

    @Override
    public void onTestSuccess(
            ITestResult result) {

        try {

            ExtentTest test =
                    ExtentTestManager.getTest();

            if (test == null) {
                return;
            }

            test.pass(
                    MarkupHelper.createLabel(
                            "[" + ExtentTestManager.getTestCaseId()
                            + "] TEST PASSED",
                            ExtentColor.GREEN
                    )
            );
          
            // SUCCESS SCREENSHOT
            

            String fileName =
                    ExtentTestManager.getTestCaseId()
                    + "_Success";

            ScreenshotUtils.captureScreenshot(
                    fileName);

            String base64 =
                    ScreenshotUtils
                            .captureScreenshotBase64();


            test.pass(
                    "Test Passed Successfully",
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    base64,
                                    "Success Screenshot")
                            .build());


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            ExtentTestManager.removeTest();
        }
    }


   
    // TEST FAILURE
    

    @Override
    public void onTestFailure(
            ITestResult result) {

        try {

            ExtentTest test =
                    ExtentTestManager.getTest();

            if (test == null) {
                return;
            }

            test.fail(
                    MarkupHelper.createLabel(
                            "[" + ExtentTestManager.getTestCaseId()
                            + "] TEST FAILED",
                            ExtentColor.RED
                    )
            );
            
            // EXCEPTION
           

            if (result.getThrowable() != null) {

                test.fail(
                        result.getThrowable());
            }


         // FAILURE SCREENSHOT
          
            String fileName =
                    ExtentTestManager.getTestCaseId()
                    + "_Failure";

            ScreenshotUtils.captureScreenshot(
                    fileName);

            String base64 =
                    ScreenshotUtils
                            .captureScreenshotBase64();


            test.fail(
                    "Failure Screenshot",
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    base64,
                                    "Failure Screenshot")
                            .build());


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            ExtentTestManager.removeTest();
        }
    }


  
    // TEST SKIPPED
   

    @Override
    public void onTestSkipped(
            ITestResult result) {

        try {

            ExtentTest test =
                    ExtentTestManager.getTest();

            if (test == null) {
                return;
            }


            String base64 =
                    ScreenshotUtils
                            .captureScreenshotBase64();


            test.skip(
                    "Test Skipped",
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    base64,
                                    "Skipped Screenshot")
                            .build());


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            ExtentTestManager.removeTest();
        }
    }


   
    // SUITE FINISH
    
    @Override
    public void onFinish(
            ITestContext context) {

        System.out.println(
                "===== TEST SUITE FINISHED =====");

        ExtentTestManager.unload();
    }


  
    // LOG COMPANY PROFILE DATA
   


private void logCompanyProfileData(
        ExtentTest test,
        CompanyprofileData data) {

    // Ye dono details har test case mein dikhen
    test.info("<b>Test Case ID :</b> "
            + formatValue(data.getTestCaseID()));

    test.info("<b>Test Case Description :</b> "
            + formatValue(data.getTestCaseDescripton()));

    String testCaseId = formatValue(data.getTestCaseID()).trim();

    // TC01 mein existing behaviour rakhein
    if (testCaseId.equalsIgnoreCase("TC01")) {

        test.info("<b>Industry :</b> "
                + formatValue(data.getIndustry()));

        test.info("<b>Company Registration ID :</b> "
                + formatValue(data.getCompany_registration_ID()));

        test.info("<b>Tax Identification Number :</b> "
                + formatValue(data.getTax_identification_number()));

        test.info("<b>Country :</b> "
                + formatValue(data.getCountry()));

        test.info("<b>District :</b> "
                + formatValue(data.getDistrict()));

        test.info("<b>City :</b> "
                + formatValue(data.getCity()));

        test.info("<b>Postal Code :</b> "
                + formatValue(data.getPostalCode()));

        test.info("<b>Building Number :</b> "
                + formatValue(data.getBuildingNumber()));

        test.info("<b>Street Address :</b> "
                + formatValue(data.getStreet_address()));

        test.info("<b>Company Email :</b> "
                + formatValue(data.getCompany_email()));

        test.info("<b>Country Code :</b> "
                + formatValue(data.getcountrycode()));

        test.info("<b>Mobile Number :</b> "
                + formatValue(data.getMobileNo()));

        test.info("<b>No Of Employees :</b> "
                + formatValue(data.getNoOfEmployees()));

        test.info("<b>Estimated Annual Travel Budget :</b> "
                + formatValue(data.getEstimated_Annual_TravelBudget()));

    } else {

        // TC01 ke alawa blank fields ko skip karein
        logFieldIfNotBlank(test, "Industry", data.getIndustry());

        logFieldIfNotBlank(test, "Company Registration ID",
                data.getCompany_registration_ID());

        logFieldIfNotBlank(test, "Tax Identification Number",
                data.getTax_identification_number());

        logFieldIfNotBlank(test, "Country", data.getCountry());

        logFieldIfNotBlank(test, "District", data.getDistrict());

        logFieldIfNotBlank(test, "City", data.getCity());

        logFieldIfNotBlank(test, "Postal Code", data.getPostalCode());

        logFieldIfNotBlank(test, "Building Number",
                data.getBuildingNumber());

        logFieldIfNotBlank(test, "Street Address",
                data.getStreet_address());

        logFieldIfNotBlank(test, "Company Email",
                data.getCompany_email());

        logFieldIfNotBlank(test, "Country Code",
                data.getcountrycode());

        logFieldIfNotBlank(test, "Mobile Number",
                data.getMobileNo());

        logFieldIfNotBlank(test, "No Of Employees",
                data.getNoOfEmployees());

        logFieldIfNotBlank(test, "Estimated Annual Travel Budget",
                data.getEstimated_Annual_TravelBudget());
    }
}

private void logFieldIfNotBlank(
        ExtentTest test,
        String label,
        Object value) {

    if (value != null && !value.toString().trim().isEmpty()) {
        test.info("<b>" + label + " :</b> "
                + value.toString().trim());
    }
}


 // LOG FLIGHT BOOKING DATA

    private void logFlightBookingData(
            ExtentTest test,
            FlightBookingData data) {

        test.info(
                "<b>Test Case ID :</b> "
                + data.getTestCaseId());

      
        test.info(
                "<b>Trip Type :</b> "
                + data.getTripType());

        // Line 1 - From and To
        test.info(
                "<b>From :</b> " + data.getFrom()
                + " &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; "
                + "<b>To :</b> " + data.getTo());

        // Line 2 - Departure and Return
        if (data.getTripType().equalsIgnoreCase("One way")) {

            test.info(
                    "<b>Departure Date :</b> "
                    + data.getDeparturedate());

        } else {

            test.info(
                    "<b>Departure Date :</b> "
                    + data.getDeparturedate()
                    + " &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; "
                    + "<b>Return Date :</b> "
                    + data.getReturndate());
        }

        logFieldIfNotBlank(
                test,
                "Traveller Type",
                data.getTravellerType()
        );
        logFieldIfNotBlank(
                test,
                "Employee Details",
                data.getEmployeedetails()
        );

        test.info(
                "<b>Payment Method :</b> "
                + data.getPaymentMethod());
        test.info(
                "<b>PNR :</b> "
                + ExtentTestManager.getPnrMarker(
                        data.getTestCaseId()
                )
        );

     
    }
   
    // GET TEST CASE ID
   

 private String getTestCaseId(Object data) {

	    if (data instanceof CompanyprofileData) {

	        CompanyprofileData companyData =
	                (CompanyprofileData) data;

	        return formatValue(
	                companyData.getTestCaseID());
	    }

	    if (data instanceof FlightBookingData) {

	        FlightBookingData flightData =
	                (FlightBookingData) data;

	        return formatValue(
	                flightData.getTestCaseId());
	    }

	    return "";
	}

    
    // GET TEST NAME
 private String getTestName(Object data) {

	    if (data instanceof CompanyprofileData) {

	        return "Company Profile";
	    }

	    if (data instanceof FlightBookingData) {

	        return "Flight Booking";
	    }

	    return "Unknown Test";
	}

  
    // GET DESCRIPTION
  
 private String getDescription(Object data) {

	    if (data instanceof CompanyprofileData) {

	        CompanyprofileData companyData =
	                (CompanyprofileData) data;

	        return formatValue(
	                companyData.getTestCaseDescripton());
	    }
   return "";
	}
  
    // FORMAT VALUE
    
    private String formatValue(
            Object value) {

        if (value == null) {
            return "";
        }

        if (value instanceof String[]) {

            return String.join(
                    ", ",
                    (String[]) value);
        }

        if (value instanceof Object[]) {

            return Arrays.toString(
                    (Object[]) value);
        }

        return value.toString();
    }


   
    // OTHER TESTNG METHOD


    @Override
    public void onTestFailedButWithinSuccessPercentage(
            ITestResult result) {
    }
}
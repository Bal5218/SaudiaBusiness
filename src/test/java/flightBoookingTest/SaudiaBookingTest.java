package flightBoookingTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import RegistrationPage.CompnayProfilepage;
import RegistrationPage.NewTravllerPage;
import RegistrationPage.TravelProfilingPage;
import base.BaseClass;
import flightBookingPage.FlightBookingForAllPaxPage;
import listeners.TestListener;
import modeles.CompanyprofileData;
import modeles.FlightBookingData;
import utilities.DataproviderUtil;

@Listeners(TestListener.class)
public class SaudiaBookingTest extends BaseClass {

    @Test(enabled=false,
        dataProvider = "CompanyProfileData",
        dataProviderClass = DataproviderUtil.class
//        retryAnalyzer = listeners.RetryAnalyser.class
    )
    public void CompnayProfile(CompanyprofileData data) throws Throwable {

    	RegistrationPage.NewTravllerPage NewTravllerPage =
                new NewTravllerPage(driver);

    	NewTravllerPage.AddTraveller(data);
    }
    
    
//    @Test(
//            dataProvider = "CompanyProfileData",
//            dataProviderClass = DataproviderUtil.class
//     //     retryAnalyzer = listeners.RetryAnalyser.class
//        )
//        public void TravelProfiling(CompanyprofileData data) throws Throwable {
//
//    	TravelProfilingPage TravelProfilingPage = new TravelProfilingPage(driver);
//
//                   
//    	TravelProfilingPage.DepartmentDetails(data);;
//        }
//
//    @Test(
//         dataProvider = "FlightBookingData",
//          dataProviderClass = DataproviderUtil.class
//    // retryAnalyzer = listeners.RetryAnalyser.class
//    )
//    
//    
//    public void FlightBookingForAllPaxPage(FlightBookingData data) throws Throwable {
//
//    	FlightBookingForAllPaxPage FlightBookingForAllPaxPage =
//                new FlightBookingForAllPaxPage(driver);
//
//    	FlightBookingForAllPaxPage.FlightBookingForAllPax(data);
//    }

    @Test(
    	    dataProvider = "FlightBookingData",
    	    dataProviderClass = DataproviderUtil.class
    	 // retryAnalyzer = listeners.RetryAnalyser.class
    	)
    	public void flightBookingTest(
    	      FlightBookingData data) throws Throwable {

    	    FlightBookingForAllPaxPage flightBookingPage =
    	            new FlightBookingForAllPaxPage(driver);

    	    flightBookingPage.FlightBookingForAllPax(data);
    	}
}
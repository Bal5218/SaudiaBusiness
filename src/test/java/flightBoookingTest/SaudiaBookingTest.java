package flightBookingTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import RegistrationPage.TripsApprovalFlowPage;
import base.BaseClass;
import flightBookingPage.FlightBookingForAllPaxPage;
import flightBookingPage.FlightBookingForAllsuitpage;
import listeners.TestListener;
import modeles.CompanyprofileData;
import modeles.FlightBookingData;
import utilities.DataproviderUtil;





@Listeners(TestListener.class)
public class SaudiaBookingTest extends BaseClass {

    @Test(
        dataProvider = "CompanyProfileData",
        dataProviderClass = DataproviderUtil.class
//        retryAnalyzer = listeners.RetryAnalyser.class
    )
    public void CompanyProfile(CompanyprofileData data) throws Throwable {
TripsApprovalFlowPage TripsApprovalFlowPage =
                new TripsApprovalFlowPage(driver);

    	TripsApprovalFlowPage.TripsApproval(data);
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
public void flightBookingTest(FlightBookingData data)
        throws Throwable {

    System.out.println("========== FLIGHT BOOKING TEST STARTED ==========");
    System.out.println("FlightBookingData received: " + data);

    FlightBookingForAllPaxPage flightBookingPage =
            new FlightBookingForAllPaxPage(driver);

    flightBookingPage.FlightBookingForAllPax(data);

    System.out.println("========== FLIGHT BOOKING TEST FINISHED ==========");
}

		


// @Test(
//     dataProvider = "FlightSearchSmokeData",
//     dataProviderClass = DataproviderUtil.class,
//     groups = {"Smoke"}
// )
// public void flightSearchSmokeTest(FlightBookingData data)
//         throws Throwable {

//     FlightBookingForAllsuitpage page =
//             new FlightBookingForAllsuitpage(driver);

//     page.searFlightForAll(data);
// }

}

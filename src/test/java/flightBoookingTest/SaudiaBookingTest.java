package flightBoookingTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import RegistrationPage.CompnayProfilepage;
import RegistrationPage.NewTravllerPage;
import RegistrationPage.TravelProfilingPage;
import base.BaseClass;
import credentialPage.LoginPage;
import flightBookingPage.FlightBookingForAllPaxPage;
import listeners.TestListener;
import modeles.CompanyprofileData;
import modeles.FlightBookingData;
import utilities.DataproviderUtil;

@Listeners(TestListener.class)
public class SaudiaBookingTest extends BaseClass {

//    @Test(priority = 1,
//        dataProvider = "CompanyProfileData",
//        dataProviderClass = DataproviderUtil.class
////        retryAnalyzer = listeners.RetryAnalyser.class
//    )
//    public void CompnayProfile(CompanyprofileData data) throws Throwable {
//
//    	CompnayProfilepage CompnayProfilepage =
//                new CompnayProfilepage(driver);
//
//    	CompnayProfilepage.Enterdetails(data);
////    	
////  
////    	
////    	
//   }
////    
////
////
//@Test(
//    priority = 2,
//    dataProvider = "CompanyProfileData",
//    dataProviderClass = DataproviderUtil.class
//)
//public void OfficeLocationAddTest(CompanyprofileData data)
//        throws Throwable {
//
//    CompnayProfilepage page = new CompnayProfilepage(driver);
//    page.OfficeLocation(data);
//}
////
//@Test(
//    priority = 3,
//    dataProvider = "CompanyProfileData",
//    dataProviderClass = DataproviderUtil.class
//)
//public void OfficeLocationEditTest(CompanyprofileData data)
//        throws Throwable {
//
//    CompnayProfilepage page = new CompnayProfilepage(driver);
//    page.OfficeLocation(data);
//}
////
//@Test(
//    priority = 4,
//    dataProvider = "CompanyProfileData",
//    dataProviderClass = DataproviderUtil.class
//)
//public void OfficeLocationDeleteTest(CompanyprofileData data)
//        throws Throwable {
//
//    CompnayProfilepage page = new CompnayProfilepage(driver);
//    page.OfficeLocation(data);
//}
//
//
//@Test(
//    priority = 5,
//    dataProvider = "CompanyProfileData",
//    dataProviderClass = DataproviderUtil.class
//)
//public void CostCenterOverviewAddTest(CompanyprofileData data)
//        throws Throwable {
//
//    CompnayProfilepage page = new CompnayProfilepage(driver);
//    page.fillCostoverView(data);
//}
//
//@Test(
//    priority = 6,
//    dataProvider = "CompanyProfileData",
//    dataProviderClass = DataproviderUtil.class
//)
//public void CostCenterOverviewEditTest(CompanyprofileData data)
//        throws Throwable {
//
//    CompnayProfilepage page = new CompnayProfilepage(driver);
//    page.fillCostoverView(data);
//}
//
//@Test(
//    priority = 7,
//    dataProvider = "CompanyProfileData",
//    dataProviderClass = DataproviderUtil.class
//)
//public void CostCenterOverviewDeleteTest(CompanyprofileData data)
//        throws Throwable {
//
//    CompnayProfilepage page = new CompnayProfilepage(driver);
//    page.fillCostoverView(data);
//}
//
//	@Test(
//		    priority = 8,
//		    dataProvider = "CompanyProfileData",
//		    dataProviderClass = DataproviderUtil.class
//		)
//		public void ProjectsAddTest(CompanyprofileData data)
//		        throws Throwable {
//
//		    CompnayProfilepage page = new CompnayProfilepage(driver);
//		    page.fillProjects(data);
//		}
//	@Test(
//		    priority = 9,
//		    dataProvider = "CompanyProfileData",
//		    dataProviderClass = DataproviderUtil.class
//		)
//		public void ProjectsEditTest(CompanyprofileData data)
//		        throws Throwable {
//
//		    CompnayProfilepage page = new CompnayProfilepage(driver);
//		    page.fillProjects(data);
//		}
//	@Test(
//		    priority = 10,
//		    dataProvider = "CompanyProfileData",
//		    dataProviderClass = DataproviderUtil.class
//		)
//		public void ProjectsDeleteTest(CompanyprofileData data)
//		        throws Throwable {
//
//		    CompnayProfilepage page = new CompnayProfilepage(driver);
//		    page.fillProjects(data);
//		}
//    @Test(
//            priority = 11,
//            dataProvider = "CompanyProfileData",
//            dataProviderClass = DataproviderUtil.class
//        )
//        public void CorporateCardsTest(CompanyprofileData data)
//                throws Throwable {
//
//            CompnayProfilepage page =
//                    new CompnayProfilepage(driver);
//
//            page.CorporateCards(data);
//        }
//  @Test(
//    priority = 12,
//    dataProvider = "CompanyProfileData",
//    dataProviderClass = DataproviderUtil.class
//)
//public void BusinessUnitsAddTest(CompanyprofileData data)
//        throws Throwable {
//
//    CompnayProfilepage page =
//        new CompnayProfilepage(driver);
//
//    page.BusinessUnit(data);
//}
//  @Test(
//		    priority = 13,
//		    dataProvider = "CompanyProfileData",
//		    dataProviderClass = DataproviderUtil.class
//		)
//		public void BusinessUnitsEditTest(CompanyprofileData data)
//		        throws Throwable {
//
//		    CompnayProfilepage page =
//		        new CompnayProfilepage(driver);
//
//		    page.BusinessUnit(data);
//		}
//  @Test(
//		    priority = 14,
//		    dataProvider = "CompanyProfileData",
//		    dataProviderClass = DataproviderUtil.class
//		)
//		public void BusinessUnitsDeleteTest(CompanyprofileData data)
//		        throws Throwable {
//
//		    CompnayProfilepage page =
//		        new CompnayProfilepage(driver);
//
//		    page.BusinessUnit(data);
//		}
//    
//    
//    
//    
//    
//   
//    @Test(
//            priority = 7,
//            dataProvider = "CompanyProfileData",
//            dataProviderClass = DataproviderUtil.class
//        )
//        public void TravelProfilingTest(CompanyprofileData data)
//                throws Throwable {
//
//    	TravelProfilingPage page =
//                    new TravelProfilingPage(driver);
//
//            page.DepartmentDetails(data);
//        }
//    @Test(
//            priority = 8,
//            dataProvider = "CompanyProfileData",
//            dataProviderClass = DataproviderUtil.class
//        )
//        public void NewTravellerTest(CompanyprofileData data)
//                throws Throwable {
//
//    	NewTravllerPage page =
//                    new NewTravllerPage(driver);
//
//            page.AddTraveller(data);
//        }
//    
    
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
//retryAnalyzer = listeners.RetryAnalyser.class
    	)
    	public void flightBookingTest(
    	      FlightBookingData data) throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.clickLogin(data.getLoginRole());
    	    FlightBookingForAllPaxPage flightBookingPage =
    	            new FlightBookingForAllPaxPage(driver);

    	    flightBookingPage.FlightBookingForAllPax(data);
    	}
}
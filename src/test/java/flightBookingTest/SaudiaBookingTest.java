
package flightBookingTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import RegistrationPage.TripsApprovalFlowPage;
import base.BaseClass;
import credentialPage.LoginPage;
import flightBookingPage.FlightBookingForAllPaxPage;
import listeners.TestListener;
import modeles.CompanyprofileData;
import modeles.FlightBookingData;
import utilities.DataproviderUtil;

@Listeners(TestListener.class)
public class SaudiaBookingTest extends BaseClass {

    // Company Profile Test - preserved from FlightFamilyPR

    @Test(
        dataProvider = "CompanyProfileData",
        dataProviderClass = DataproviderUtil.class
    )
    public void CompanyProfile(CompanyprofileData data)
            throws Throwable {

        TripsApprovalFlowPage tripsApprovalPage =
                new TripsApprovalFlowPage(getDriver());

        tripsApprovalPage.TripsApproval(data);
    }

    // Flight Booking Test - updated version from main

    @Test(
        dataProvider = "FlightBookingData",
        dataProviderClass = DataproviderUtil.class,
        retryAnalyzer = listeners.RetryAnalyser.class
    )
    public void flightBookingTest(FlightBookingData data)
            throws Throwable {

        LoginPage loginPage = new LoginPage(getDriver());

loginPage.clickLogin();

        FlightBookingForAllPaxPage flightBookingPage =
                new FlightBookingForAllPaxPage(getDriver());

        flightBookingPage.FlightBookingForAllPax(data);
    }
}

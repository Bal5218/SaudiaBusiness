package utilities;

import org.testng.annotations.DataProvider;

public class DataproviderUtil {

    @DataProvider(name = "CompanyProfileData")
    public static Object[][] companyProfileData() {

        ExcelUtil.openExcel("BookingRegistrationdata");

        Object[][] excelData = ExcelUtil.getExcelData();

        Object[][] testData =
                new Object[excelData.length][1];

        for (int i = 0; i < excelData.length; i++) {

            testData[i][0] =
                    ExcelUtil.getCompanyprofileData(excelData[i]);
        }

        ExcelUtil.closeExcel();

        return testData;
    }


    @DataProvider(name = "FlightBookingData")
    public static Object[][] flightBookingData() {

        ExcelUtil.openExcel("FlightBookingData");

        Object[][] excelData =
                ExcelUtil.getExcelData();

        Object[][] testData =
                new Object[excelData.length][1];

        for (int i = 0; i < excelData.length; i++) {

            testData[i][0] =
                    ExcelUtil.getFlightBookingData(excelData[i]);
        }

        ExcelUtil.closeExcel();

        return testData;
    }
}
package utilities;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;


import modeles.CompanyprofileData;

public class DataproviderUtil {

    @DataProvider(name = "CompanyProfileData")
    public static Object[][] companyProfileData(Method method) {

        String testCaseId = getTestCaseId(method.getName());

        ExcelUtil.openExcel(
            Ipathconstant.excelfile_path1,
            "BookingRegistrationdata"
        );

        try {
            Object[][] excelData = ExcelUtil.getExcelData();
            List<Object[]> filteredData = new ArrayList<>();

            for (Object[] row : excelData) {

                if (row.length > 0
                        && testCaseId.equalsIgnoreCase(
                            String.valueOf(row[0]).trim())) {

                    CompanyprofileData data =
                            ExcelUtil.getCompanyprofileData(row);

                    filteredData.add(new Object[]{data});
                }
            }

            if (filteredData.isEmpty()) {
                throw new RuntimeException(
                    "Excel mein TestCaseID nahi mila: " + testCaseId
                );
            }

            return filteredData.toArray(new Object[0][]);

        } finally {
            ExcelUtil.closeExcel();
        }
    }

    


    @DataProvider(name = "FlightBookingData",parallel = false)
    public static Object[][] flightBookingData() {

        ExcelUtil.openExcel(
                Ipathconstant.excelfile_path,
                "FlightBookingData"
        );

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

private static String getTestCaseId(String methodName) {

    switch (methodName) {

        case "CompnayProfile":
            return "TC01";

        case "OfficeLocationAddTest":
            return "TC02";

        case "OfficeLocationEditTest":
            return "TC03";

        case "OfficeLocationDeleteTest":
            return "TC04";

        case "CostCenterOverviewAddTest":
            return "TC05";

        case "CostCenterOverviewEditTest":
            return "TC06";

        case "CostCenterOverviewDeleteTest":
            return "TC07";

        case "ProjectsAddTest":
            return "TC08";

        case "ProjectsEditTest":
            return "TC09";

        case "ProjectsDeleteTest":
            return "TC10";
        case "CorporateCardsTest":
            return "TC11";

        case "BusinessUnitsAddTest":
            return "TC12";

        case "BusinessUnitsEditTest":
            return "TC13";

        case "BusinessUnitsDeleteTest":
            return "TC14";
        case "TravelProfilingTest":
            return "TC15";

        case "NewTravellerTest":
            return "TC16";
            

        default:
            throw new IllegalArgumentException(
                "Test method mapping nahi mili: " + methodName
            );
    }
}

}
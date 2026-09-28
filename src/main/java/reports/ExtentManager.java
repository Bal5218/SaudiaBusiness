package reports;

import com.aventstack.extentreports.ExtentReports;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {}

    public static ExtentReports getExtentReport() {

        if (extent == null) {

            extent = ExtentReport.createReport();

        }

        return extent;
    }

}
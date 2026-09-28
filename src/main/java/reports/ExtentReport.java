package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

    private ExtentReport() {}

    public static ExtentReports createReport() {

        String reportName =
                "ExtentReport_"
                        + new SimpleDateFormat("ddMMyyyy_HHmmss")
                        .format(new Date())
                        + ".html";

        String path =
                System.getProperty("user.dir")
                        + "/Reports/"
                        + reportName;

        ExtentSparkReporter spark =
                new ExtentSparkReporter(path);

        spark.config().setDocumentTitle("Travel Automation Framework");

        spark.config().setReportName("Flight Booking Automation");

        spark.config().setTimelineEnabled(true);

        ExtentReports extent = new ExtentReports();

        extent.attachReporter(spark);

        extent.setSystemInfo("Framework", "Hybrid");

        extent.setSystemInfo("Automation", "Selenium Java");

        extent.setSystemInfo("Tester", "Ravi Bhushan Kumar");

        extent.setSystemInfo("Environment", "QA");

        return extent;
    }

}
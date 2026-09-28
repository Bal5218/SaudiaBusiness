package reports;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestManager {

  
    private static ExtentReports extentReports;

    

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

   

    private static final ThreadLocal<String> testCaseId =
            new ThreadLocal<>();


    

    public static synchronized ExtentReports getReport() {

        if (extentReports == null) {

            String outputDirectory =
                    System.getProperty("user.dir")
                    + File.separator
                    + "test-output";

            File directory =
                    new File(outputDirectory);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String reportPath =
                    outputDirectory
                    + File.separator
                    + "TravelAutomationReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo(
                    "Application",
                    "Travel Automation"
            );

            extentReports.setSystemInfo(
                    "Browser",
                    "Chrome"
            );

            extentReports.setSystemInfo(
                    "Author",
                    "Ravi Bhushan"
            );
        }

        return extentReports;
    }

   

    public static void setTest(ExtentTest extentTest) {

        test.set(extentTest);
    }


    

    public static ExtentTest getTest() {

        return test.get();
    }


   
    public static void setTestCaseId(String id) {

        testCaseId.set(id);
    }


    
    public static String getTestCaseId() {

        String id = testCaseId.get();

        return id == null ? "NA" : id;
    }


    
    public static void removeTest() {

        test.remove();

        testCaseId.remove();
    }


    

    public static synchronized void unload() {

        System.out.println(
                "===== Flushing Travel Automation Report ====="
        );

        if (extentReports != null) {

            extentReports.flush();

          
        }

        test.remove();

        testCaseId.remove();
    }
}
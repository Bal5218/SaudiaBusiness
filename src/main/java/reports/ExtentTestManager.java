
package reports;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestManager {

    private static ExtentReports extentReports;

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    private static final ThreadLocal<String> testCaseId =
            new ThreadLocal<>();

    // Store runtime PNR values against Test Case ID
    private static final Map<String, String> runtimePnrs =
            new ConcurrentHashMap<>();

    // =====================================================
    // GET REPORT
    // =====================================================

    public static synchronized ExtentReports getReport() {

        if (extentReports == null) {

            String outputDirectory =
                    System.getProperty("user.dir")
                    + File.separator
                    + "test-output";

            File directory = new File(outputDirectory);

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

    // =====================================================
    // PNR PLACEHOLDER
    // =====================================================

    public static String getPnrMarker(String id) {

        String safeId = id == null
                ? "NA"
                : id.replaceAll("[^A-Za-z0-9_-]", "_");

        return "__RUNTIME_PNR_" + safeId + "__";
    }

    // =====================================================
    // SAVE RUNTIME PNR
    // =====================================================

    public static void setRuntimePnr(
            String id,
            String pnr) {

        if (id != null
                && pnr != null
                && !pnr.trim().isEmpty()) {

            runtimePnrs.put(id, pnr.trim());
        }
    }

    // =====================================================
    // HTML ESCAPE
    // =====================================================

    private static String escapeHtml(String value) {

        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }

    // =====================================================
    // UPDATE PNR IN GENERATED REPORT
    // =====================================================

    private static void updateRuntimePnrsInReport() {

        Path reportPath = Path.of(
                System.getProperty("user.dir"),
                "test-output",
                "TravelAutomationReport.html"
        );

        try {

            if (!Files.exists(reportPath)) {

                System.out.println(
                        "Report file not found: " + reportPath
                );

                return;
            }

            String html = Files.readString(
                    reportPath,
                    StandardCharsets.UTF_8
            );

            for (Map.Entry<String, String> entry
                    : runtimePnrs.entrySet()) {

                String marker =
                        getPnrMarker(entry.getKey());

                String pnr =
                        escapeHtml(entry.getValue());

                html = html.replace(marker, pnr);
            }

            Files.writeString(
                    reportPath,
                    html,
                    StandardCharsets.UTF_8
            );

            System.out.println(
                    "Runtime PNR values updated in report."
            );

        } catch (Exception e) {

            System.err.println(
                    "Unable to update runtime PNR in report."
            );

            e.printStackTrace();
        }
    }

    // =====================================================
    // SET / GET CURRENT TEST
    // =====================================================

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    // =====================================================
    // SET / GET TEST CASE ID
    // =====================================================

    public static void setTestCaseId(String id) {
        testCaseId.set(id);
    }

    public static String getTestCaseId() {

        String id = testCaseId.get();

        return id == null ? "NA" : id;
    }

    // =====================================================
    // REMOVE CURRENT TEST
    // =====================================================

    public static void removeTest() {

        test.remove();
        testCaseId.remove();
    }

    // =====================================================
    // FLUSH REPORT
    // =====================================================

    public static synchronized void unload() {

        System.out.println(
                "===== Flushing Travel Automation Report ====="
        );

        if (extentReports != null) {

            extentReports.flush();

            // Replace PNR placeholders after report generation
            updateRuntimePnrsInReport();
        }

        test.remove();
        testCaseId.remove();
    }
}

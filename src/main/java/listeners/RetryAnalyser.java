package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import modeles.CompanyprofileData;

public class RetryAnalyser implements IRetryAnalyzer {

    private int count = 0;

    private static final int MAX_RETRY = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (count < MAX_RETRY) {

            count++;

            Object[] parameters = result.getParameters();

            if (parameters.length > 0) {

                Object obj = parameters[0];

                if (obj instanceof CompanyprofileData) {

                    CompanyprofileData data =
                            (CompanyprofileData) obj;

                    System.out.println(
                            "Retrying Company Profile Test Case : "
                            + data.getTestCaseID());

                    System.out.println(
                            "Description : "
                            + data.getTestCaseDescripton());
                }
            }

            return true;
        }

        return false;
    }
}
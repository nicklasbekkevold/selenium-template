package org.example.project.listeners;

import org.example.project.utils.StepLogger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_TRIES = 1;
    private int tries = 0;

    /**
     * Determine if test should be retried
     *
     * @param testResult the result of the test method that just ran
     * @return true if the test method has to be retried, false otherwise
     */
    @Override
    public boolean retry(ITestResult testResult) {
        StepLogger.info(testResult.getTestName() + " test failed");
        return !testResult.isSuccess() && tries++ < MAX_TRIES;
    }
}
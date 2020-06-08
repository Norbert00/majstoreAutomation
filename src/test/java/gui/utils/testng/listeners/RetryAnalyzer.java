package gui.utils.testng.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_NUMBER_OF_RETRIES = 2;
    Logger logManager = LogManager.getLogger(RetryAnalyzer.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < MAX_NUMBER_OF_RETRIES) {
                count++;
                logManager.info("Retrying test method {}!", iTestResult.getName());
                return true;
            }
        }
        logManager.info("Test method {} will be not retried!", iTestResult.getName());
        return false;
    }
}

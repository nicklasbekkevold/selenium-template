package org.example.project.listeners;

import io.qameta.allure.Attachment;
import org.example.project.SeleniumTest;
import org.example.project.utils.StepLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.getLifecycle;


public class TestListener implements ITestListener {


    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    private static String getTestMethodName(ITestResult testResult) {
        return testResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveFailureScreenShot(final WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        StepLogger.info(getTestMethodName(result) + " test failed");

        Object testClass = result.getInstance();
        WebDriver driver = ((SeleniumTest) testClass).getDriver();
        if (driver != null) {
            StepLogger.info("Screenshot captured for test case: " + getTestMethodName(result));
            getLifecycle().addAttachment("Screenshot", "image/png", "png", new ByteArrayInputStream(saveFailureScreenShot(driver)));
        }

        saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
    }
}

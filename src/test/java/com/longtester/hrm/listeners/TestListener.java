package com.longtester.hrm.listeners;

import com.longtester.helpers.CaptureHelper;
import com.longtester.mail.EmailSender;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    static int count_totalTCs;
    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;

    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("********** RUN STARTED **********");
    }

    @Override
    public void onFinish(ITestContext arg0) {
        System.out.println("********** RUN FINISHED **********");
        System.out.println("Total TCs: " + count_totalTCs);
        System.out.println("Passed TCs: " + count_passedTCs);
        System.out.println("Failed TCs: " + count_failedTCs);
        System.out.println("Skipped TCs: " + count_skippedTCs);
        EmailSender.sendMail();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test case: " + iTestResult.getMethod().getMethodName() + " is starting...");
        count_totalTCs++;
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test case: " + iTestResult.getMethod().getMethodName() + " is passed.");
        count_passedTCs++;
        CaptureHelper.takeFullScreenshot(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test case: " + iTestResult.getMethod().getMethodName() + " is failed.");
        count_failedTCs++;
        CaptureHelper.takeFullScreenshot(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test case: " + iTestResult.getMethod().getMethodName() + " is skipped.");
        count_skippedTCs++;
    }
}


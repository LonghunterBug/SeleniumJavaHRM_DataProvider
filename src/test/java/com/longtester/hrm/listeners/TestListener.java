package com.longtester.hrm.listeners;

import com.longtester.helpers.CaptureHelper;
import com.longtester.helpers.PropertiesHelper;
import com.longtester.mail.EmailSender;
import com.longtester.utils.LogUtils;
import org.openqa.selenium.bidi.log.Log;
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
        LogUtils.info("********** RUN STARTED **********");
    }

    @Override
    public void onFinish(ITestContext arg0) {
        LogUtils.info("********** RUN FINISHED **********");
        LogUtils.info("📊 Test Summary:");
        LogUtils.info("✅ Total TCs: " + count_totalTCs);
        LogUtils.info("✅ Passed TCs: " + count_passedTCs);
        LogUtils.info("❌ Failed TCs: " + count_failedTCs);
        LogUtils.info("⚠ Skipped TCs: " + count_skippedTCs);
        if (PropertiesHelper.getValue("SEND_EMAIL_TO_USERS").equalsIgnoreCase("yes")) {
            EmailSender.sendMail();
            LogUtils.info("📧 Sending result email to users...");
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogUtils.info("Test case: " + iTestResult.getMethod().getMethodName() + " is starting...");
        count_totalTCs++;
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info("✅ Test case: " + iTestResult.getMethod().getMethodName() + " is passed.");
        count_passedTCs++;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LogUtils.error("❌ Test case: " + iTestResult.getMethod().getMethodName() + " is failed.");
        LogUtils.error("📄 Reason: " + iTestResult.getThrowable());
        count_failedTCs++;
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LogUtils.warn("⚠ Test case: " + iTestResult.getMethod().getMethodName() + " is skipped.");
        LogUtils.warn("📄 Reason: " + iTestResult.getThrowable());
        count_skippedTCs++;
    }
}


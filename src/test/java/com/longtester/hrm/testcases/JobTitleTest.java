package com.longtester.hrm.testcases;

import com.longtester.helpers.CaptureHelper;
import com.longtester.hrm.common.BaseTest;
import com.longtester.hrm.common.DataTest;
import com.longtester.hrm.dataproviders.DataProviderFactory;
import com.longtester.hrm.pages.BasePage;
import com.longtester.hrm.pages.JobTitlePage;
import com.longtester.hrm.pages.LoginPage;
import com.longtester.hrm.pages.UserMangementPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JobTitleTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    JobTitlePage jobTitlePage;
    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage();
        basePage = new BasePage();
        jobTitlePage = new JobTitlePage();
    }
    @Test(priority = 1,dataProvider = "addJobTitleData",dataProviderClass = DataProviderFactory.class)
    public void testAddJobTitle(String username, String password, String jobtitle) {
        loginPage.loginHRM(username, password);
        basePage.clickMenuAdmin();
        jobTitlePage.addJobTitle(jobtitle);
        basePage.verifySuccessMessageIsDisplayed();
        jobTitlePage.verifyJobTitleIsDisplayedInTable(jobtitle);
    }
    @Test(priority = 2,dataProvider = "editJobTitleData",dataProviderClass = DataProviderFactory.class)
    public void testEditJobTitle(String username, String password, String jobtitle, String jobtitleupdated) {
        loginPage.loginHRM(username, password);
        basePage.clickMenuAdmin();
        jobTitlePage.addJobTitle(jobtitle);
        jobTitlePage.editJobTitle(jobtitle,jobtitleupdated);
        basePage.verifySuccessMessageIsDisplayed();
        jobTitlePage.verifyJobTitleIsDisplayedInTable(jobtitleupdated);
    }
    @Test(priority = 3,dataProvider = "deleteJobTitleData",dataProviderClass = DataProviderFactory.class)
    public void testDeleteJobTitle(String username, String password, String jobtitle){
        loginPage.loginHRM(username, password);
        basePage.clickMenuAdmin();
        jobTitlePage.addJobTitle(jobtitle);
        jobTitlePage.deleteJobTitle(jobtitle);
        basePage.verifySuccessMessageIsDisplayed();
        jobTitlePage.verifyJobTitleNotDisplayedInTable(jobtitle);

    }
}

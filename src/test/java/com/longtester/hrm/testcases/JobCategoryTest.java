package com.longtester.hrm.testcases;

import com.longtester.hrm.common.BaseTest;
import com.longtester.hrm.common.DataTest;
import com.longtester.hrm.dataproviders.DataProviderFactory;
import com.longtester.hrm.pages.BasePage;
import com.longtester.hrm.pages.JobCategoryPage;
import com.longtester.hrm.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobCategoryTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    JobCategoryPage jobCategoryPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage();
        basePage = new BasePage();
        jobCategoryPage = new JobCategoryPage();
    }
    @Test(priority = 1,dataProvider = "addJobCategoryData",dataProviderClass = DataProviderFactory.class)
    public void testAddJobCategory(String username, String password, String category) {
        loginPage.loginHRM(username, password);
        basePage.clickMenuAdmin();
        jobCategoryPage.addJobCategory(category);
        basePage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryIsDisplayedInTable(category);
    }
    @Test(priority = 2,dataProvider = "editJobCategoryData",dataProviderClass = DataProviderFactory.class)
    public void testEditJobCategory(String username, String password, String category, String categoryupdated) {
        loginPage.loginHRM(username, password);
        basePage.clickMenuAdmin();
        jobCategoryPage.addJobCategory(category);
        jobCategoryPage.editJobCategory(category,categoryupdated);
        basePage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryIsDisplayedInTable(categoryupdated);
    }
    @Test(priority = 3,dataProvider = "deleteJobCategoryData",dataProviderClass = DataProviderFactory.class)
    public void testDeleteJobCategory(String username, String password, String category){
        loginPage.loginHRM(username, password);
        basePage.clickMenuAdmin();
        jobCategoryPage.addJobCategory(category);
        jobCategoryPage.deleteJobCategory(category);
        basePage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryNotDisplayedInTable(category);
    }
}

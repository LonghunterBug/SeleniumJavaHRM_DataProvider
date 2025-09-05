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
    public void testAddJobCategory(String username, String password, String jobcategory) {
        loginPage.loginHRM(username, password);
        basePage.clickMenuAdmin();
        jobCategoryPage.addJobCategory(jobcategory);
        basePage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryIsDisplayedInTable(jobcategory);
    }
    @Test(priority = 2)
    public void testEditJobCategory() {
        loginPage.loginHRM("Admin", "admin123");
        basePage.clickMenuAdmin();
        jobCategoryPage.editJobCategory(DataTest.job_category);
        basePage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryIsDisplayedInTable(DataTest.job_category_edit);
    }
    @Test(priority = 3)
    public void testDeleteJobCategory(){
        loginPage.loginHRM("Admin", "admin123");
        basePage.clickMenuAdmin();
        jobCategoryPage.deleteJobCategory(DataTest.job_category_edit);
        basePage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryNotDisplayedInTable(DataTest.job_category_edit);
    }
}

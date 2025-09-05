package com.longtester.hrm.testcases;

import com.longtester.hrm.common.BaseTest;
import com.longtester.hrm.common.DataTest;
import com.longtester.hrm.dataproviders.DataProviderFactory;
import com.longtester.hrm.pages.BasePage;
import com.longtester.hrm.pages.EmployeeDetailPage;
import com.longtester.hrm.pages.EmployeePage;
import com.longtester.hrm.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    EmployeePage employeePage;
    EmployeeDetailPage employeeDetailPage;
    @BeforeMethod
    public void initPage(){
        loginPage = new LoginPage();
        basePage = new BasePage();
        employeePage = new EmployeePage();
        employeeDetailPage = new EmployeeDetailPage();
    }
    @Test(dataProvider = "addEmployee", dataProviderClass = DataProviderFactory.class)
    public void testAddNewEmployee(String login_username, String login_password,
                                   String firstname, String middlename, String lastname,
                                   String id){
        loginPage.loginHRM(login_username,login_password);
        basePage.clickMenuPIM();
        employeePage.addNewEmployee(firstname,middlename,lastname,id);
        basePage.verifySuccessMessageIsDisplayed();
        basePage.clickMenuPIM();
        employeePage.verifyEmployeeIsDisplayedInTable(id);
    }
    @Test(dataProvider = "E2E", dataProviderClass = DataProviderFactory.class)
    public void testMainFlow(String login_username, String login_password,
                             String firstname, String middlename, String lastname,
                             String id, String drivernumber, String gender,
                             String jobtitle, String jobcategory){
        loginPage.loginHRM(login_username,login_password);
        basePage.clickMenuPIM();
        employeePage.addNewEmployee(firstname,middlename,lastname,id);
        basePage.clickMenuPIM();
        employeePage.verifyEmployeeIsDisplayedInTable(id);
        employeePage.clickEdit();
        employeeDetailPage.updatePersonalDetail(drivernumber,gender);
        employeeDetailPage.updateJob(jobtitle,jobcategory);
        employeeDetailPage.clickMenuPersonalDetail();
        employeeDetailPage.verifyPersonalDetailUpdated(drivernumber,gender);
        employeeDetailPage.clickMenuJob();
        employeeDetailPage.verifyJobUpdated(jobtitle,jobcategory);

    }
}

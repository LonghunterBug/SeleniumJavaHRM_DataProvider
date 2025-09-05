package com.longtester.hrm.testcases;

import com.longtester.hrm.common.BaseTest;
import com.longtester.hrm.common.DataTest;
import com.longtester.hrm.dataproviders.DataProviderFactory;
import com.longtester.hrm.pages.BasePage;
import com.longtester.hrm.pages.LoginPage;
import com.longtester.hrm.pages.UserMangementPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserManagementTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    UserMangementPage userMangementPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage();
        basePage = new BasePage();
        userMangementPage = new UserMangementPage();
    }
    @Test(priority = 1,dataProvider = "addUser",dataProviderClass = DataProviderFactory .class)
    public void testAddNewUser(String login_username, String login_password,
                               String role, String status, String employeename,
                               String username, String password, String confirmpassword){
        loginPage.loginHRM(login_username,login_password);
        basePage.clickMenuAdmin();
        userMangementPage.addNewUser(role,status,employeename,username,password,confirmpassword);
        basePage.verifySuccessMessageIsDisplayed();
        userMangementPage.verifyUserIsDisplayedInTable(username);
    }
    @Test(priority = 2)
    public void testLoginSuccessWithRegisteredAccount(){
        loginPage.loginHRM(DataTest.username_addnew,DataTest.password_addnew);
        basePage.verifyMainMenuDisplayed();
    }
    @Test(priority = 3)
    public void testLoginFailWithInvalidCredential(){
        loginPage.loginHRM(DataTest.username_addnew,"");
        loginPage.verifyErrorInvalidCredentialDisplayed();
    }
    @Test(priority = 4,dataProvider = "editUser",dataProviderClass = DataProviderFactory.class)
    public void testEditUser(String login_username, String login_password,
                             String role, String status, String employeename,
                             String username, String password, String confirmpassword, String status_updated){
        loginPage.loginHRM(login_username,login_password);
        basePage.clickMenuAdmin();
        userMangementPage.addNewUser(role,status,employeename,username,password,confirmpassword);
        userMangementPage.editStatusEmployeeName(username,status_updated);
        basePage.verifySuccessMessageIsDisplayed();
        userMangementPage.verifyStatusEmployeeNameIsUpdated(username,status_updated);
    }
    @Test(priority = 5)
    public void testDeleteUser(){
        loginPage.loginHRM("Admin","admin123");
        basePage.clickMenuAdmin();
        userMangementPage.deleteUser(DataTest.username_addnew);
        basePage.verifySuccessMessageIsDisplayed();
        userMangementPage.verifyUserNotDisplayedInTable(DataTest.username_addnew);
    }
}

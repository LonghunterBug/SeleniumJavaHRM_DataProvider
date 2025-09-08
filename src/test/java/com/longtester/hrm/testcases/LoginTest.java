package com.longtester.hrm.testcases;

import com.longtester.helpers.CaptureHelper;
import com.longtester.hrm.common.BaseTest;
import com.longtester.hrm.dataproviders.DataProviderFactory;
import com.longtester.hrm.pages.BasePage;
import com.longtester.hrm.pages.LoginPage;
import com.longtester.hrm.pages.UserMangementPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage();
        basePage = new BasePage();
    }

    @Test(dataProvider = "data_provider_loginsuccess",dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String username,String password){
        loginPage.loginHRM(username,password);
        basePage.verifyMainMenuDisplayed();
    }
    @Test(dataProvider = "data_provider_loginfail",dataProviderClass = DataProviderFactory.class)
    public void testLoginFailWithInvalidCredential(String username, String password){
        loginPage.loginHRM(username,password);
        loginPage.verifyErrorInvalidCredentialDisplayed();
        CaptureHelper.takeFullScreenshot("loginFail");
    }
    @Test(dataProvider = "data_provider_loginfail1",dataProviderClass = DataProviderFactory.class)
    public void testLoginFailWithoutInputRequired(String username, String password){
        loginPage.loginHRM(username,password);
        loginPage.verifyErrorInputRequirDisplayed();
    }
}

package com.longtester.hrm.pages;

import com.longtester.helpers.PropertiesHelper;
import com.longtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private By inputUserName = By.xpath("//input[@placeholder='Username']");
    private By inputPassword = By.xpath("//input[@placeholder='Password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By alertErrorInvalidCredential = By.xpath("//p[normalize-space()='Invalid credentials']");
    private By alertErrorInputRequire = By.xpath("//span[contains(@class,'input-field-error-message')]");

    public void loginHRM(String username, String password){
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.setText(inputUserName,username);
        WebUI.setText(inputPassword,password);
        WebUI.clickElement(buttonLogin);
    }
    public void verifyErrorInvalidCredentialDisplayed(){
        WebUI.verifyDisplay(alertErrorInvalidCredential,WebUI.isElementDisplayed(alertErrorInvalidCredential),"Error invalid credentials not display");
        WebUI.verifyEqual(WebUI.getElementText(alertErrorInvalidCredential),"Invalid credentials","Error invalid credentials not match with expected");
    }
    public void verifyErrorInputRequirDisplayed(){
        WebUI.verifyDisplay(alertErrorInputRequire,WebUI.isElementDisplayed(alertErrorInputRequire),"Error input required not display");
        WebUI.verifyEqual(WebUI.getElementText(alertErrorInputRequire),"Required","Error input required not match with expected");
    }
}

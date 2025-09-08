package com.longtester.hrm.common;

import com.longtester.driver.DriverManager;
import com.longtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;


public class BaseTest {

    @BeforeMethod
    public void openBrowser(){
        WebDriver driver;// khao báo driver cục bộ
        driver = new ChromeDriver();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        if(DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
        }
    }
}

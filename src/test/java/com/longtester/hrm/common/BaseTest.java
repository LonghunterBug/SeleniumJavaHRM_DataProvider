package com.longtester.hrm.common;

import com.longtester.driver.DriverManager;
import com.longtester.helpers.PropertiesHelper;
import com.longtester.hrm.listeners.TestListener;
import com.longtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.sql.Driver;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeSuite
    public void runConfig(){
        PropertiesHelper.loadAllFiles();
    }
    @BeforeMethod
    public void openBrowser(){
        WebDriver driver;// khao báo driver cục bộ
        String browser = PropertiesHelper.getValue("BROWSER").trim().toLowerCase();
        ChromeOptions options = new ChromeOptions();
        boolean isHeadless = PropertiesHelper.getValue("HEADLESS").equalsIgnoreCase("true");

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(isHeadless){
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--window-size=1920,1080");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                driver = new ChromeDriver(); // mặc định Chrome không headless
        }
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

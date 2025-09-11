package com.longtester.hrm.dataproviders;

import com.longtester.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "data_provider_loginsuccess")
    public Object[][] dataLoginSuccess() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/HRM.xlsx","Login","TC01");
        return data;
    }
    @DataProvider(name = "data_provider_loginfail")
    public Object[][] dataLoginFail(){
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/HRM.xlsx","Login","TC02");
        return data;
    }
    @DataProvider(name = "data_provider_loginfail1")
    public Object[][] dataLoginFailWithoutInput(){
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/HRM.xlsx","Login","TC03");
        return data;
    }
   // Data for Job Title
    @DataProvider(name = "addJobTitleData")
    public Object[][] addJobTitleData() {
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Login", "TC01");
        Object[][] jobTitleData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Job Title","TC01");

        Object[][] result = new Object[jobTitleData.length][3];
        for (int i = 0; i < jobTitleData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = jobTitleData[i][0]; // job title
        }
        return result;
    }
    @DataProvider(name = "editJobTitleData")
    public Object[][] editJobTitleData(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Login", "TC01");
        Object[][] jobTitleData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Job Title", "TC02");
        Object[][] result = new Object[jobTitleData.length][4];
        for (int i = 0; i < jobTitleData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = jobTitleData[i][0]; // job title
            result[i][3] = jobTitleData[i][1]; // job title updated
        }
        return result;
    }
    @DataProvider(name = "deleteJobTitleData")
    public Object[][] deleteJobTitleData(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Login", "TC01");
        Object[][] jobTitleData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Job Title", "TC03");
        Object[][] result = new Object[jobTitleData.length][3];
        for (int i = 0; i < jobTitleData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = jobTitleData[i][0]; // job title
        }
        return result;
    }
    // Data for Job Category
    @DataProvider(name = "addJobCategoryData")
    public Object[][] addJobCategoryData() {
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Login", "TC01");
        Object[][] jobCategoryData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Job Category","TC01");

        Object[][] result = new Object[jobCategoryData.length][3];
        for (int i = 0; i < jobCategoryData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = jobCategoryData[i][0]; // job category
        }
        return result;
    }
    @DataProvider(name = "editJobCategoryData")
    public Object[][] editJobCategoryData(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Login", "TC01");
        Object[][] jobCategoryData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Job Category", "TC02");
        Object[][] result = new Object[jobCategoryData.length][4];
        for (int i = 0; i < jobCategoryData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = jobCategoryData[i][0]; // job category
            result[i][3] = jobCategoryData[i][1]; // job category updated
        }
        return result;
    }
    @DataProvider(name = "deleteJobCategoryData")
    public Object[][] deleteJobCategoryData(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Login", "TC01");
        Object[][] jobCategoryData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx", "Job Category", "TC03");
        Object[][] result = new Object[jobCategoryData.length][3];
        for (int i = 0; i < jobCategoryData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = jobCategoryData[i][0]; // job category
        }
        return result;
    }

    // Data for User Management
    @DataProvider(name = "addUser")
    public Object[][] addNewUser(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx","Login","TC01");
        Object[][] userData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx","User Management");
        Object[][] result = new Object[userData.length][8];
        for (int i = 0; i < userData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = userData[i][0]; // role
            result[i][3] = userData[i][1]; // status
            result[i][4] = userData[i][2]; // employee name
            result[i][5] = userData[i][3]; // username
            result[i][6] = userData[i][4]; // password
            result[i][7] = userData[i][5]; // confirm password
        }
        return result;
    }
    @DataProvider(name = "editUser")
    public Object[][] editNewUser(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx","Login","TC01");
        Object[][] userData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx","User Management","TC04");
        Object[][] result = new Object[userData.length][9];
        for (int i = 0; i < userData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = userData[i][0]; // role
            result[i][3] = userData[i][1]; // status
            result[i][4] = userData[i][2]; // employee name
            result[i][5] = userData[i][3]; // username
            result[i][6] = userData[i][4]; // password
            result[i][7] = userData[i][5]; // confirm password
            result[i][8] = userData[i][6]; // status updated
        }
        return result;
    }
    // Data for Employee
    @DataProvider(name = "addEmployee")
    public Object[][] addNewEmployee(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] loginData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx","Login","TC01");
        Object[][] employeeData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx","Employee");
        Object[][] result = new Object[employeeData.length][6];
        for (int i = 0; i < employeeData.length; i++) {
            result[i][0] = loginData[0][0]; // username
            result[i][1] = loginData[0][1]; // password
            result[i][2] = employeeData[i][0]; // firstname
            result[i][3] = employeeData[i][1]; // middlename
            result[i][4] = employeeData[i][2]; // lastname
            result[i][5] = employeeData[i][3]; // ID
        }
        return result;
    }
    @DataProvider(name = "E2E")
    public Object[][] E2Eflow(){
        ExcelHelper excel = new ExcelHelper();
        Object[][] E2EData = excel.getExcelData("src/test/resources/testdata/HRM.xlsx","E2E","TC03");
        return E2EData;
    }
}

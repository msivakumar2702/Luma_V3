package com.luma.testCases;

import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.pageObjects.CreateNewCustomerAccountpage;
import com.luma.pageObjects.HomePage1;
import com.luma.pageObjects.MyAccountPage;
import com.luma.utilities.ExcelUtils;
import com.luma.utilities.FilePaths;
import com.luma.utilities.LumaUtils;
import com.luma.utilities.TestDataUtils;


public class TC_001_CreateAccount extends BaseClass{

	LumaUtils lu;
	
    @Test(invocationCount = 3,groups={"master","sanity"})
    public void createCusAcc() {
        // Generate dynamic data
        String firstName = TestDataUtils.generateFirstName();
        String lastName = TestDataUtils.generateLastName();
        String email = TestDataUtils.generateEmail(firstName, lastName);
        String pwd = TestDataUtils.password;
        

        // Navigate to the account creation page
        HomePage1 hp = new HomePage1(driver);
        hp.clickCreateAnAccountLink();

        // Fill in the account details
        CreateNewCustomerAccountpage cnca = new CreateNewCustomerAccountpage(driver);
        cnca.setFirstName(firstName);
        cnca.setLastName(lastName);
        cnca.setEmail(email);
        cnca.setpassword(pwd);
        cnca.setCnfPassword(pwd);
        cnca.clickCreateAccountBtn();

        // Set Excel file path
        ExcelUtils.setFilePath(FilePaths.CUSTOMER_DETAILS_EXCEL);
        

        // Write customer data to Excel
        ExcelUtils.writeCustomerDataToExcel(firstName, lastName, email, pwd);

        // Logout
        MyAccountPage ma = new MyAccountPage(driver);
        ma.clickOnDropDownArrow();
        ma.clickSignOutLink();
    }
}

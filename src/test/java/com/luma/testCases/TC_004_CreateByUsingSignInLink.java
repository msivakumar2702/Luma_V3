package com.luma.testCases;

import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.pageObjects.CreateNewCustomerAccountpage;
import com.luma.pageObjects.CustomerLoginPage;
import com.luma.pageObjects.HomePage;
import com.luma.pageObjects.MyAccountPage;
import com.luma.utilities.TestDataUtils;

public class TC_004_CreateByUsingSignInLink extends BaseClass {

	String firstName = TestDataUtils.generateFirstName();
	String lastName = TestDataUtils.generateLastName();
	String email = TestDataUtils.generateEmail(firstName, lastName);
	String pwd = TestDataUtils.password;

	@Test(groups = { "regression" })
	public void createCusBysignin() {
		HomePage hp = new HomePage(driver);

		hp.clickSignInLink();

		CustomerLoginPage clp = new CustomerLoginPage(driver);
		clp.clickcreateAccountBtn();
		// Fill in the account details
		CreateNewCustomerAccountpage cnca = new CreateNewCustomerAccountpage(driver);
		cnca.setFirstName(firstName);
		cnca.setLastName(lastName);
		cnca.setEmail(email);
		cnca.setpassword(pwd);
		cnca.setCnfPassword(pwd);
		cnca.clickCreateAccountBtn();

		// Set Excel file path
		// ExcelUtils.setFilePath(FilePaths.CUSTOMER_DETAILS_EXCEL);

		// Write customer data to Excel
		// ExcelUtils.writeCustomerDataToExcel(firstName, lastName, email, pwd);

		// Logout
		MyAccountPage ma = new MyAccountPage(driver);
		ma.clickOnDropDownArrow();
		ma.clickSignOutLink();

	}

}

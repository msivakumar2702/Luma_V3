package com.luma.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.pageObjects.CustomerLoginPage;
import com.luma.pageObjects.DashBoardPage;
import com.luma.pageObjects.HomePage;
import com.luma.utilities.DataProviders;

public class TC_002_login extends BaseClass {

    // DataProvider will be used here to fetch the login credentials
    @Test(dataProvider = "LoginData1", dataProviderClass = DataProviders.class, groups="dataDriven")
    public void verifyLogin(String firstName, String lastName, String email, String pwd) throws InterruptedException {
   // public void verifyLogin() { 
        // Navigate to the home page and click on SignIn link
        HomePage hp = new HomePage(driver);
        hp.clickSignInLink();
        
        // Navigate to the login page
        CustomerLoginPage clp = new CustomerLoginPage(driver);
        
        // Use data from DataProvider (email and password)
        clp.setEmail(email);
        clp.setpassword(pwd);
        clp.clicksignBtn();
        
        //User confirmation
        
        DashBoardPage dp = new DashBoardPage(driver);
       String welComeCnfMsg = dp.welcomeCnfMsg();
       
       //Thread.sleep(3000);
		//System.out.println(cnfMsg);
		Assert.assertEquals(welComeCnfMsg,("Welcome, " + firstName + " " + lastName + "!"));
		
		dp.clickOnDropDownArrow();
		//Thread.sleep(3000);
		dp.clickSignOutLink();
		//Thread.sleep(5000);
		
		String signOutCnfMsg =dp.signOutCnfMsg();
		System.out.println(signOutCnfMsg);
		Assert.assertEquals(signOutCnfMsg, "You are signed out");
		
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed

	        // Locate the message element
	      //  By messageLocator = dp.signOutCnfMsg(); // Replace with the actual ID or locator

	        
	       


        
        // Add verification steps as needed to ensure the login is successful
        
    }
}

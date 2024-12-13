package com.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends BasePage {
	
	public CustomerLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement txtPwd;
	
	@FindBy(xpath="(//button[@id='send2']/span)[1]")
	WebElement btnSignIn;
	
	@FindBy(xpath="(//span[contains(text(),'Create an Account')])[1]")
	WebElement btnCreateAccount;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setpassword(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	
	public void clicksignBtn() {
		btnSignIn.click();
	}
	
	public void clickcreateAccountBtn() {
		btnCreateAccount.click();
	}

}

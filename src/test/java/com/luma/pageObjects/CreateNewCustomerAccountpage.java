package com.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerAccountpage extends BasePage {
	
	public CreateNewCustomerAccountpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement txtLastName;
	
	@FindBy(id="email_address")
	WebElement txtEmail;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="password-confirmation")
	WebElement txtCnfpassword;
	
	@FindBy(xpath="//button[contains(@class, 'submit')]/span")
	WebElement btnCreateAccount;
	
	
	public void setFirstName(String Fname) {
		txtFirstName.sendKeys(Fname);
	}
	
	public void setLastName(String Lname) {
		txtLastName.sendKeys(Lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setCnfPassword(String pwd) {
		txtCnfpassword.sendKeys(pwd);
	}
	
	public void clickCreateAccountBtn() {
		btnCreateAccount.click();
	}
}

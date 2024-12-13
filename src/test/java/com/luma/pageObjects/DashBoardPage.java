package com.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage{
	
	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[contains(@class, 'page-wrapper')]/child::header//ul[1]//span[@class='logged-in']")
	WebElement cnfMsg;
	
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement btnDownArrow;

	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement signOutLink;
	
	@FindBy(xpath="//span[normalize-space()='You are signed out']")
	WebElement signOutCnfMsg;
	
	
	public String welcomeCnfMsg() {
		try {
			
			//WaitUtils.waitForElementToDisappear(driver, 3, cnfMsg);
		return cnfMsg.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
		
	
	public void clickOnDropDownArrow() {
		//clickWhenClickable(btnDownArrow, 5);
		btnDownArrow.click();
	}
	
	public void clickSignOutLink() {
		//clickWhenClickable(signOutLink, 5);
		signOutLink.click();
	}
	
	public String signOutCnfMsg() {
		
		 
		try {
			String msg = signOutCnfMsg.getText();
		//	WaitUtils.waitForElementToDisappear(5, signOutCnfMsg);
			Thread.sleep(5000);
			
		return msg;
		}
		catch (Exception e) {
			return e.getMessage();
		}
		
		
		
	}

}

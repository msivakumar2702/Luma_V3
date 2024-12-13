package com.luma.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//div[contains(@data-bind, 'prepareMessageForHtml')]")
	WebElement cnfMsg;
	
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement btnDownArrow;

	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement signOutLink;
	
	
	public void clickOnDropDownArrow() {
		//clickWhenClickable(btnDownArrow, 5);
		btnDownArrow.click();
	}
	
	public void clickSignOutLink() {
		//clickWhenClickable(signOutLink, 5);
		signOutLink.click();
	}
	
	
	public String confirmMsg() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement visibleCnfMsg = wait.until(
	            ExpectedConditions.visibilityOf(cnfMsg)
	        );
	        return visibleCnfMsg.getText();
	    } catch (Exception e) {
	        return "Error retrieving confirmation message: " + e.getMessage();
	    }
	}

	
}

package com.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopppingCartPage extends BasePage {
	
	public ShopppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='action action-delete']")
	WebElement btnDeleteItem;
	
	@FindBy(xpath="//p[contains(normalize-space(), 'You have no')]")
	WebElement cnfMsg;
	
	public void clickDeleteItem() {
		btnDeleteItem.click();
	}
	
	public String noItemCnfMsg() {
		try {
			
			//WaitUtils.waitForElementToDisappear(driver, 3, cnfMsg);
		return cnfMsg.getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}

}

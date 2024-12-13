package com.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[contains(@class, 'panel')]//a[normalize-space()='Create an Account']")
	WebElement createAnAccountLink;
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signInLink;
	
	@FindBy(xpath="//span[normalize-space()='Men']")
	WebElement memMenu;
	
	@FindBy(xpath="//a[@id='ui-id-17']")
	WebElement topsSubmenu;
	
	@FindBy(xpath="//a[@id='ui-id-19']//span[contains(text(),'Jackets')]")
	WebElement jacketsOptions;
	
	@FindBy(xpath="//a[@id='ui-id-20']//span[contains(text(),'Hoodies & Sweatshirts')]")
	WebElement hdAndSsOptions;
	
	public void clickCreateAnAccountLink() {
		createAnAccountLink.click();
	}
	
	public void clickSignInLink() {
		signInLink.click();
	}
	Actions action = new Actions(driver);
	public void toHoverMemMenu()  {
		
		action.moveToElement(memMenu).perform();
	}
	public void toHoverTopsSubMenu() {
		
		//Thread.sleep(3000);
		action.moveToElement(topsSubmenu).perform();
	}
	public void toClickJacketsOption() {
		jacketsOptions.click();
	}
		
	public void toClickHdAndSsOption() {
		hdAndSsOptions.click();
	}
	}


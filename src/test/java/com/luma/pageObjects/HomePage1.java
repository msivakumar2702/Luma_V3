package com.luma.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage1 extends BasePage {

	public HomePage1(WebDriver driver) {
		super(driver);
	}

	// Existing locators and methods
	@FindBy(xpath = "//div[contains(@class, 'panel')]//a[normalize-space()='Create an Account']")
	WebElement createAnAccountLink;

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signInLink;

	@FindBy(xpath = "//span[normalize-space()='Men']")
	WebElement memMenu;

	@FindBy(xpath = "//span[normalize-space()='Women']")
	WebElement womenMenu;

	@FindBy(xpath = "//span[normalize-space()='Gear']")
	WebElement gearMenu;

	@FindBy(xpath = "//a[@id='ui-id-17']")
	WebElement menTopsSubmenu;
	@FindBy(xpath="//a[@id='ui-id-18']")
	WebElement menBottomSubmenu;
	
	@FindBy(xpath="//a[@id='ui-id-9']")
	WebElement womenTopSubmenu;
	
	@FindBy(xpath="//a[@id='ui-id-10']")
	WebElement womenBottomSubmenu;

	@FindBy(xpath = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')]")
	WebElement menJacketsOptions;
	
	@FindBy(xpath="//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
	WebElement womenJacketsOptions;

	@FindBy(xpath = "//a[@id='ui-id-12']//span[contains(text(),'Hoodies & Sweatshirts')]")
	WebElement womenHdAndSsOptions;
	
	@FindBy(xpath = "//a[@id='ui-id-20']//span[contains(text(),'Hoodies & Sweatshirts')]")
	WebElement menHdAndSsOptions;
	
	@FindBy(xpath="//a[@id='ui-id-21']//span[contains(text(),'Tees')]")
	WebElement menTeesOtion;
	
	@FindBy(xpath="//a[@id='ui-id-13']//span[contains(text(),'Tees')]")
	WebElement womenTeesOtion;
	
	@FindBy(xpath="//span[normalize-space()='Tanks']")
	WebElement menTanks;
	
	@FindBy(xpath="//span[normalize-space()='Bras & Tanks']")
	WebElement womenBrasAndTanks;
	
	@FindBy(xpath="//a[@id='ui-id-25']")
	WebElement bagsMenu;
	
	@FindBy(xpath="//a[@id='ui-id-26']")
	WebElement fitnessMenu;
	
	@FindBy(xpath="//a[@id='ui-id-27']")
	WebElement watchesMenu;

	Actions action = new Actions(driver);

	public void clickCreateAnAccountLink() {
		createAnAccountLink.click();
	}

	public void clickSignInLink() {
		signInLink.click();
	}

	// including in if condition based on customer input he can select items

	public void toHoverMenu(String section, String subSec, String product) {

		if (section.equalsIgnoreCase("men")) {
			action.moveToElement(memMenu).perform();
			if (subSec.equalsIgnoreCase("tops")) {
				
				action.moveToElement(menTopsSubmenu).perform();
				
				if(product.equalsIgnoreCase("jackets")) {
					
					menJacketsOptions.click();
					
				}
				else if (product.equalsIgnoreCase("Hoodies and Sweatshirts")) {
					menHdAndSsOptions.click();
				}
				else if (product.equalsIgnoreCase("tees")) {
					menTeesOtion.click();
					
				}
				else if (product.equalsIgnoreCase("tanks")) {
					menTanks.click();
				}
				else {
					System.out.println("product not found");
				}
				
			} else if (subSec.equalsIgnoreCase("bottoms")) {
				action.moveToElement(menBottomSubmenu).perform();
				
				if(product.equalsIgnoreCase("pants")) {
					
				}
				else if (product.equalsIgnoreCase("shorts")) {
					
				}
				else {
					System.out.println("product not found");
				}
			}

			else {
				System.out.println("sub section not found");
			}

		} else if (section.equalsIgnoreCase("women")) {
			
			action.moveToElement(womenMenu).perform();
			
			if (subSec.equalsIgnoreCase("tops")) {
				action.moveToElement(womenTopSubmenu).perform();
				if(product.equalsIgnoreCase("jackets")) {
					
				}
				else if (product.equalsIgnoreCase("Hoodies and Sweatshirts")) {
					
				}
				else if (product.equalsIgnoreCase("tees")) {
					
				}
				else if (product.equalsIgnoreCase("bars & tanks")) {
					 
				}
				else {
					System.out.println("product not found");
				}
				
				
				
				
			} else if (subSec.equalsIgnoreCase("bottoms")) {
				action.moveToElement(womenBottomSubmenu).perform();
				
				if(product.equalsIgnoreCase("pants")) {
					
				}
				else if (product.equalsIgnoreCase("shorts")) {
					
				}
				else {
					System.out.println("product not found");
				}

			}

			else {
				System.out.println("sub section not found");
			}

			
			
		} 
		else if (section.equalsIgnoreCase("gear")) {

			if (subSec.equalsIgnoreCase("Bags")) {
				bagsMenu.click();

			} else if (subSec.equalsIgnoreCase("Fitness equipment")) {
				fitnessMenu.click();
			} else if (subSec.equalsIgnoreCase("watches")) {
				watchesMenu.click();
			}
			
		} else {
			System.out.println("Section not found");
		}
	}

	public void toHoverTopsSubMenu(String subSec) {

		if (subSec.equalsIgnoreCase("men")) {
			action.moveToElement(womenTopSubmenu).perform();
		} else if (subSec.equalsIgnoreCase("women")) {

		} else if (subSec.equalsIgnoreCase("gear")) {

		}
	}
/*
	public void toClickJacketsOption() {
		jacketsOptions.click();
	}

	public void toClickHdAndSsOption() {
		hdAndSsOptions.click();
	}
*/
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBox;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List<WebElement> searchResults;

	public void enterSearchText(String text) {
		searchBox.sendKeys(text);
	}

	public void waitForSearchResults() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
	}

	public void selectItemByText(String itemText) {
		for (WebElement result : searchResults) {
			if (result.getText().equals(itemText)) {
				result.click();
				break;
			}
		}
	}

}

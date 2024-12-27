package com.luma.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public MenuConditionHandler menuConditionHandler;

	public HomePage(WebDriver driver) {

		super(driver);
		this.menuConditionHandler = new MenuConditionHandler();
	}

	// Locators
	@FindBy(xpath = "//div[contains(@class, 'panel')]//a[normalize-space()='Create an Account']")
	WebElement createAnAccountLink;

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signInLink;

	@FindBy(xpath = "//span[normalize-space()='Men']")
	WebElement menMenu;

	@FindBy(xpath = "//span[normalize-space()='Women']")
	WebElement womenMenu;

	@FindBy(xpath = "//span[normalize-space()='Gear']")
	WebElement gearMenu;

	@FindBy(xpath = "//a[@id='ui-id-17']")
	WebElement menTopsSubmenu;

	@FindBy(xpath = "//a[@id='ui-id-18']")
	WebElement menBottomSubmenu;

	@FindBy(xpath = "//a[@id='ui-id-9']")
	WebElement womenTopsSubmenu;

	@FindBy(xpath = "//a[@id='ui-id-10']")
	WebElement womenBottomSubmenu;

	@FindBy(xpath = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')]")
	WebElement menJacketsOptions;

	@FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
	WebElement womenJacketsOptions;

	@FindBy(xpath = "//a[@id='ui-id-12']//span[contains(text(),'Hoodies & Sweatshirts')]")
	WebElement womenHdAndSsOptions;

	@FindBy(xpath = "//a[@id='ui-id-20']//span[contains(text(),'Hoodies & Sweatshirts')]")
	WebElement menHdAndSsOptions;

	@FindBy(xpath = "//a[@id='ui-id-21']//span[contains(text(),'Tees')]")
	WebElement menTeesOption;

	@FindBy(xpath = "//a[@id='ui-id-13']//span[contains(text(),'Tees')]")
	WebElement womenTeesOption;

	@FindBy(xpath = "//span[normalize-space()='Tanks']")
	WebElement menTanks;

	@FindBy(xpath = "//span[normalize-space()='Bras & Tanks']")
	WebElement womenBrasAndTanks;

	@FindBy(xpath = "//a[@id='ui-id-25']")
	WebElement bagsMenu;

	@FindBy(xpath = "//a[@id='ui-id-26']")
	WebElement fitnessMenu;

	@FindBy(xpath = "//a[@id='ui-id-27']")
	WebElement watchesMenu;

	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBox;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List<WebElement> searchResults;

	Actions action = new Actions(driver);

	// Methods
	public void clickCreateAnAccountLink() {
		createAnAccountLink.click();
	}

	public void clickSignInLink() {
		signInLink.click();
	}

	public void enterSearchText(String text) {
		searchBox.sendKeys(text);
	}

	public void hoverAndSelect(String section, String subSection, String product) {
		WebElement menu = menuConditionHandler.getMenu(section, this);
		WebElement submenu = menuConditionHandler.getSubmenu(section, subSection, this);
		WebElement productOption = menuConditionHandler.getProductOption(section, product, this);

		if (menu != null) {
			action.moveToElement(menu).perform();
			if (submenu != null) {
				action.moveToElement(submenu).perform();
				if (productOption != null) {
					productOption.click();
				} else {
					System.out.println("Product not found: " + product);
				}
			} else {
				System.out.println("Subsection not found: " + subSection);
			}
		} else {
			System.out.println("Section not found: " + section);
		}
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

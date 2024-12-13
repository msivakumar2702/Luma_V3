package com.luma.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JaketTopsMenPage extends BasePage {

    public JaketTopsMenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='base']")
    WebElement pageConfMsg;

    @FindBy(xpath = "//div[contains(@class, 'opt-398')]//div[contains(@class, 'swatch-option') and contains(@class, 'text')]")
    List<WebElement> sizesOfItem;
    
    @FindBy(xpath="//div[@class='swatch-opt-398']//div[contains(@class, 'swatch-option color')]")
    List<WebElement> colorOfItem;
    
    @FindBy(xpath="(//span[contains(text(),'Add to Cart')])[3]")
    WebElement btnAddToCart;
    
    @FindBy(linkText="shopping cart")
    WebElement linkShippingcart;

    // Method to return the size options
    public List<WebElement> getSizeOptions() {
        return sizesOfItem;
    }
    
    public List<WebElement> getColourOptions() {
        return colorOfItem;
    }
    
    public void clickAddToCartBtn() {
    	btnAddToCart.click();
    }
    
    public void clickShippingCartLink() {
    	linkShippingcart.click();
    }
}

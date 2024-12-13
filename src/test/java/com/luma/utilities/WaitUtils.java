package com.luma.utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.luma.base.BaseClass;

public class WaitUtils extends BaseClass{

	/*
	public static void waitForElementToDisappear(WebDriver driver,WebElement cnfMsg, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        
        wait.until(ExpectedConditions.visibilityOf(cnfMsg));
        //wait.until(ExpectedConditions.invisibilityOf(signOutCnfMsg));
        
        //System.out.println("Element has disappeared!");
    }
    
	
    public static void waitForElementToDisappear( int timeoutInSeconds, WebElement signOutCnfMsg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        
        //wait.until(ExpectedConditions.visibilityOf(cnfMsg));
        wait.until(ExpectedConditions.invisibilityOf(signOutCnfMsg));
        
        //System.out.println("Element has disappeared!");
    }
    */
}

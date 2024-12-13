package com.luma.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.luma.pageObjects.JaketTopsMenPage;

public class LumaUtils {

    public static void selectSize(String size, JaketTopsMenPage jtp) {
        List<WebElement> sizeOptions = jtp.getSizeOptions(); // Access the size options via the instance
        boolean sizeSelected = false;

        for (WebElement option : sizeOptions) {
            if (option.getText().trim().equalsIgnoreCase(size)) {
                option.click(); // Click the matching size option
                System.out.println("Size " + size + " was selected successfully.");
                sizeSelected = true;
                break; // Exit loop once size is selected
            }
        }

        if (!sizeSelected) {
            System.out.println("Size " + size + " is not available.");
            throw new RuntimeException("Size " + size + " is not available.");
        }
    }

    public static void selectColour(String colour, JaketTopsMenPage jtp, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> colourOptions = jtp.getColourOptions();
        boolean colourSelected = false;

        for (WebElement option : colourOptions) {
            // Retrieve the color name from "aria-label"
            String actualColour = option.getDomAttribute("aria-label"); 
           // System.out.println("Checking colour: " + actualColour); // Debug log

            if (actualColour != null && actualColour.trim().equalsIgnoreCase(colour)) {
                wait.until(ExpectedConditions.elementToBeClickable(option)).click(); // Wait and click
                System.out.println("Colour " + colour + " was selected successfully.");
                colourSelected = true;
                break; // Exit loop once colour is selected
            }
        }

        if (!colourSelected) {
            System.out.println("Colour " + colour + " is not available.");
            throw new RuntimeException("Colour " + colour + " is not available.");
        }
    }
}

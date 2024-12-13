package com.luma.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestDataUtils {

    public static String password = "P@55word";

    // Generate first name
    public static String generateFirstName() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z') // Define the range
                .build();
        String fname = generator.generate(4); // Length of 4 characters
        return fname + "Fn";
    }

    // Generate last name
    public static String generateLastName() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z') // Define the range
                .build();
        String lname = generator.generate(4); // Length of 4 characters
        return lname + "Ln";
    }

    // Generate email address
    public static String generateEmail(String firstName, String lastName) {
        final String EMAIL_DOMAIN = "@gmail.com";
        return firstName + lastName + EMAIL_DOMAIN;
    }

    // Method to capture screenshot
    public String captureScreen(WebDriver driver, String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // Take screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Use the screenshot path from FilePaths class
        String targetFilePath = FilePaths.SCREENSHOT_DIRECTORY + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        // Save the screenshot
        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}

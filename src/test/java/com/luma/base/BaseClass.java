package com.luma.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.luma.utilities.FilePaths;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "master", "sanity", "regression", "dataDriven" })
	@Parameters({ "browser", "os" })
	public void setup(String br, String os) throws IOException {
		FileReader file = new FileReader(FilePaths.TEST_DATA_PROPERTIES);
		p = new Properties();
		p.load(file);

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(FilePaths.AD_BLOCKER_EXTENSION)); // Add AdBlocker

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			} 
			else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching OS");
				return;
			}

			switch (br.toLowerCase()) {
			case ("chrome"):
				cap.setBrowserName("chrome");
				break;
			case ("edge"):
				cap.setBrowserName("MicrosoftEdge");
				break;
			case ("firefox"):
				cap.setBrowserName("firefox");
				break;
			
			default:
				System.out.println("No matching browser");
				return;
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),cap);

		}
		else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name");
				return;
			}

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "master", "sanity", "regression", "dataDriven" })
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		// Create timestamp for unique screenshot filenames
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

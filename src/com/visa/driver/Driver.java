package com.visa.driver;
import java.io.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.visa.utility.ReadPropertyValues;

import com.visa.utility.*;

@Test(groups = {"mandatory"})
public class Driver {
	
	public static WebDriver driver;


	//	Open Browser 
	public static Logger logger = ConfigureLog4j.getConigLogger("");
	@BeforeClass
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		ReadPropertyValues rpDrv = new ReadPropertyValues();
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				
				String gecoFilePath = rpDrv.getPropValues("GecoFilePath");
				gecoFilePath = Utility.getFullPath(gecoFilePath);
				System.setProperty("webdriver.gecko.driver", gecoFilePath);
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				String chromDrvrPath = rpDrv.getPropValues("ChromeDriverPath");
				chromDrvrPath = Utility.getFullPath(chromDrvrPath);
				System.setProperty("webdriver.chrome.driver",
						chromDrvrPath);
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				String ieDrvrPath = rpDrv.getPropValues("IEDriverPath");
				ieDrvrPath = Utility.getFullPath(ieDrvrPath);
				System.setProperty("webdriver.ie.driver",
						ieDrvrPath);
				driver = new InternetExplorerDriver();
			}
			logger.info("Browser Opened");
		
		} catch (WebDriverException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Navigate to website 
	@Parameters({ "baseURL" })
	public void openWebSite(String baseURL)
	{
		driver.get(baseURL);
		logger.info("Navigated to website");
	}
	
    // Close the Browser
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		logger.info("Browser Closed");
	}
}
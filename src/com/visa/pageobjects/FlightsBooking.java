/**
 * 
 */
package com.visa.pageobjects;

/**
 * @author Ravi Kumar
 *
 */


import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.visa.driver.Driver;
import com.visa.utility.Utility;



public class FlightsBooking {
	
	  static WebDriver driver = Driver.driver;
	  static Logger logger = Driver.logger;
	  static String stepName;
	  static String mainWindow = driver.getWindowHandle();

      public void searchFlight(String fromDest,String toDest, String deprtDt,String returnDt,String adult,String child) throws IOException
      {
    	  // Finding the elements on Flight search page. 
    	  
    	  WebElement flightTab = driver.findElement(By.xpath("html/body/div[3]/div[3]/div/ul/li[2]/a"));
    	  flightTab.click();
    	  logger.info("Navigated to Flight search page");
    	  
    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	  
    	  WebElement elmLoc = driver.findElement(By.xpath(".//*[@id='wego-flights-searchform']/div[1]/div/input"));
    	 // Select fromDropDn = new Select(elmLoc);	

    	  WebElement elmChckIn = driver.findElement(By.xpath(".//*[@id='wego-flights-searchform']/div[2]/div/input"));
    	//  Select toDropDn = new Select(elmChckIn);	
    	  
    	  WebElement elmChckOut = driver.findElement(By.name("wg_outbound_date"));
    	  WebElement elmReturnDt = driver.findElement(By.name("wg_inbound_date"));
    	  
    	  WebElement noAdlts = driver.findElement(By.xpath(".//*[@id='wg_adult']"));
    	  Select dropdownAdult = new Select(noAdlts);	 
    	  
    	  WebElement noChldrs = driver.findElement(By.xpath(".//*[@id='wg_children']"));
    	  Select dropdownChild= new Select(noChldrs);
    	  
    	  WebElement srchBtn = driver.findElement(By.xpath(".//*[@id='search-button']"));
    	  
    	// Entering values in the fields on Hotel search page. 
    	  elmLoc.clear();
    	  elmLoc.sendKeys(fromDest);
    	  WebDriverWait wait = new WebDriverWait(driver, 15);
    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ui-active-menuitem']")));
    	  WebElement mnItm = driver.findElement(By.xpath(".//*[@id='ui-active-menuitem']"));
    	  mnItm.click();
    	  
    	  logger.info("From Location entered on Flight search page");
    	  
    	  elmChckIn.clear();
    	  elmChckIn.sendKeys(toDest);

    	  WebDriverWait wait2 = new WebDriverWait(driver, 15);
    	  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ui-active-menuitem']")));
    	  WebElement mnItm2 = driver.findElement(By.xpath(".//*[@id='ui-active-menuitem']"));
    	  mnItm2.click();
    	  logger.info("To Location entered on Flight search page");
    	  

    	  elmChckOut.clear();
    	  elmChckOut.sendKeys(deprtDt);
    	  logger.info("Departure Date entered on Flight search page");
    	  
    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	  elmReturnDt.clear();
    	  elmReturnDt.sendKeys(deprtDt);
    	  logger.info("Return Date entered on Flight search page");
    	  
    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	  dropdownAdult.selectByVisibleText(adult);
    	  logger.info("No of Adults on Flight search page");
    	  
    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	  dropdownChild.selectByVisibleText(child);
    	  logger.info("No of Childrens on Flight search page");
    	  //noAdlts.sendKeys(adult);
    	  //noChldrs.sendKeys(child);
    	  stepName = "Serach_Flight_Data_Entry";
    	  Utility.captureScreenShot(driver, stepName);
    	  
    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	  srchBtn.click();  
    	  logger.info("Search Button clicked Flight search page");
    	  
    	  stepName = "Serach_Flight_Search_Done";
    	  Utility.captureScreenShot(driver, stepName);
    	  
      }
      
 //// Method to verify the flight search result.
	public void verifyFlightSearchResults(String result) 
      {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Set<String> handles = driver.getWindowHandles();  
			for (String handle : handles) {
				if (!handle.equals(mainWindow)) {
		          driver.switchTo().window(handle);
		          break;
				}
			}
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
    	  if(result.equals("No Result"))
    	  {
    		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		  WebElement noResultElmt = driver.findElement(By.xpath("html/body/div[5]/div[3]/div/h1"));
    		  String actulNoReslText = noResultElmt.getText();
    		  Assert.assertEquals(actulNoReslText,"No Results!!","No Results found & matching");
    		  logger.info("No Results found on searching Flight");
    	  }
    	  else
    	  {  	
    		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		  WebDriverWait wait = new WebDriverWait(driver, 15);
    		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='results-airline']/div[1]/div[1]/span[2]")));
    		  WebElement firstHotelElmt = driver.findElement(By.xpath(".//*[@id='results-airline']/div[1]/div[1]/span[2]"));
    		  String actulReslText = firstHotelElmt.getText();
    		  Assert.assertEquals(actulReslText.trim(),result.trim(),"Results found & matching");
    		  logger.info("Flights found on searching Flight");
    	  }
    	  driver.navigate().back();
    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      }
	
	
	public static void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.className("ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all"));
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().contains(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public static void selectOptionWithIndex(int indexToSelect) {
		
		try {
			WebElement autoOptions = driver.findElement(By.className("ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all"));
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
		        if(indexToSelect<=optionsToSelect.size()) {
		        	System.out.println("Trying to select based on index: "+indexToSelect);
		           optionsToSelect.get(indexToSelect).click();
		        }
		} 		
		catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	
}

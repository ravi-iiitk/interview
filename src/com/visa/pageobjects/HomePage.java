package com.visa.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.visa.driver.Driver;
import com.visa.utility.Utility;



public class HomePage {
	  static WebDriver driver = Driver.driver;
	  static Logger logger = Driver.logger;
	  static String stepName;
	 // final String  fullClassName=this.getClass().getCanonicalName();
	//  public final org.apache.log4j.Logger logger =  ConfigureLog4j.getConigLogger(fullClassName);
      public void searchHotel(String location,String checkin, String checkout,String adult,String child) throws IOException
      {
    	  // Finding the elements on Hotel search page. 
    	  WebElement elmLoc = driver.findElement(By.xpath(".//*[@id='HOTELS']/div/form/div[1]/div/div/input"));
    	  WebElement elmChckIn = driver.findElement(By.xpath(".//*[@id='dpd1']/div/input"));
    	  WebElement elmChckOut = driver.findElement(By.xpath(".//*[@id='dpd2']/div/input"));
    	  WebElement noAdlts = driver.findElement(By.xpath(".//*[@id='adults']"));
    	  Select dropdownAdult = new Select(noAdlts);	  
    	  WebElement noChldrs = driver.findElement(By.xpath(".//*[@id='child']"));
    	  Select dropdownChild= new Select(noChldrs);
    	  WebElement srchBtn = driver.findElement(By.xpath(".//*[@id='HOTELS']/div/form/div[6]/div/button"));
    	  
    	// Entering values in the fields on Hotel search page. 
    	  elmLoc.sendKeys(location);
    	  logger.info("Location entered on Hotel search page");
    	  elmChckIn.clear();
    	  elmChckIn.sendKeys(checkin);
    	  logger.info("Check In Date entered on Hotel search page");
    	  elmChckOut.clear();
    	  elmChckOut.sendKeys(checkout);
    	  logger.info("Check Out Date entered on Hotel search page");
    	  dropdownAdult.selectByVisibleText(adult);
    	  logger.info("No of Adults on Hotel search page");
    	  dropdownChild.selectByVisibleText(child);
    	  logger.info("No of Childrens on Hotel search page");
    	  //noAdlts.sendKeys(adult);
    	  //noChldrs.sendKeys(child);
    	  stepName = "Serach_Hotel_Data_Entry";
    	  Utility.captureScreenShot(driver, stepName);
    	  
    	  srchBtn.click();  
    	  logger.info("Search Button clicked Hotel search page");
    	  
    	  stepName = "Serach_Hotel_Search_Done";
    	  Utility.captureScreenShot(driver, stepName);
    	  
      }
      

	public void verifyHotelSearchResults(String result) 
      {
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	  if(result.equals("No Result"))
    	  {
    		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		  WebElement noResultElmt = driver.findElement(By.xpath("html/body/div[5]/div[3]/div/h1"));
    		  String actulNoReslText = noResultElmt.getText();
    		  Assert.assertEquals(actulNoReslText,"No Results!!","No Results found & matching");
    		  logger.info("No Results found on searching hotel");
    	  }
    	  else
    	  {  	
    		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		  WebDriverWait wait = new WebDriverWait(driver, 15);
    		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[2]/h4/a/b")));
    		  WebElement firstHotelElmt = driver.findElement(By.xpath("html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[2]/h4/a/b"));
    		  String actulReslText = firstHotelElmt.getText();
    		  Assert.assertEquals(actulReslText,result,"Results found & matching");
    		  logger.info("Hotels found on searching hotel");
    	  }
    	  driver.navigate().back();
    	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      }
	public void doSignUp(String firstName, String lastName,String mobNumber,String emailId,String password) throws IOException
	{
		WebElement myAccountElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/a"));
		myAccountElmt.click();
		logger.info("My Account cliked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement sinUPElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/ul/li[2]/a"));
		sinUPElmt.click();
		logger.info("SignUp cliked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement firtNameELm = driver.findElement(By.xpath(".//*[@id='headersignupform']/div[3]/input"));
		firtNameELm.sendKeys(firstName);;
		logger.info("First Name entered");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement lstNameElmt = driver.findElement(By.xpath(".//*[@id='headersignupform']/div[4]/input"));
		lstNameElmt.sendKeys(lastName);;
		logger.info("Last Name entered");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement mobNoElmt = driver.findElement(By.xpath(".//*[@id='headersignupform']/div[5]/input"));
		mobNoElmt.sendKeys(mobNumber);
		logger.info("Mobile number entered");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement emlIdelmt = driver.findElement(By.xpath(".//*[@id='headersignupform']/div[6]/input"));
		emlIdelmt.sendKeys(emailId);
		logger.info("Email Id entred");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement pwdFld = driver.findElement(By.xpath(".//*[@id='headersignupform']/div[7]/input"));
		pwdFld.sendKeys(password);
		logger.info("Password entered");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement pwdConfFld = driver.findElement(By.xpath(".//*[@id='headersignupform']/div[8]/input"));
		pwdConfFld.sendKeys(password);
		logger.info("Confirm Password entered");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		stepName = "SignUp_Data_Entry";
		Utility.captureScreenShot(driver, stepName);
		
		WebElement signUpBtn = driver.findElement(By.xpath(".//*[@id='headersignupform']/div[9]/button"));
		signUpBtn.click();
		logger.info("SignUp button Clicked");
		
		stepName = "SignUp_Done";
		Utility.captureScreenShot(driver, stepName);
		
	}
	
	public void verifySignUP(String result)
	{
		if(result.equals("Success"))
		{   
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath("html/body/div[3]/div[3]/div/div[1]/ul/li[1]/a")).size() != 0){
				logger.info("SignUp Sucessfull : Test Case Passed");
			}else{
				logger.info("SignUp Failed : Test Case Failed");
			}
		}
		else
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath(".//*[@id='headersignupform']/div[2]/div")).size() != 0){
				logger.info("SignUp Failed : Test Case Passed");
			}else{
				logger.info("SignUp Sucessfull : Test Case Failed");
			}
		}
		WebElement myAccountElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/a"));
		myAccountElmt.click();
		logger.info("My Account cliked");
		
		WebElement logoutElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/ul/li[2]/a"));
		logoutElmt.click();
		logger.info("Logout cliked");
	}
	public void doSignIn(String userID, String password) throws IOException
	{
		WebElement myAccountElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/a"));
		myAccountElmt.click();
		logger.info("My Account cliked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement sininElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/ul/li[1]/a"));
		sininElmt.click();
		logger.info("SignUp cliked");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='loginfrm']/div[4]/div/div[1]/input")));
		
		WebElement emaildIdElm = driver.findElement(By.xpath(".//*[@id='loginfrm']/div[4]/div/div[1]/input"));
		emaildIdElm.clear();
		emaildIdElm.sendKeys(userID);
		logger.info("Emaild Id entered");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement pwdInpELmt = driver.findElement(By.xpath(".//*[@id='loginfrm']/div[4]/div/div[2]/input"));
		pwdInpELmt.clear();
		pwdInpELmt.sendKeys(password);
		logger.info("Password entered");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		stepName = "SignIn_Data_Entry";
		Utility.captureScreenShot(driver, stepName);
		
		WebElement signInBtn = driver.findElement(By.xpath(".//*[@id='loginfrm']/div[4]/button"));
		signInBtn.click();
		logger.info("SignIn button Clicked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		stepName = "SignIn_Done";
		Utility.captureScreenShot(driver,stepName);
		
	}
	
	public void verifySignIn(String result)
	{
		if(result.equals("Success"))
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  		  	WebDriverWait wait = new WebDriverWait(driver, 15);
  		  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='txt']")));
  		  
			if(driver.findElements(By.xpath(".//*[@id='txt']")).size() != 0){
				logger.info("Login Sucessfull : Test Case Passed");
			}else{
				logger.equals("Login Failed : Test Case Failed");
			}
		}
		else
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			if(driver.findElements(By.xpath(".//*[@id='loginfrm']/div[1]/div")).size() != 0){
				logger.info("Login Failed : Test Case Passed");
			}else{
				logger.equals("Login Sucessfull : Test Case Failed");
			}
		}
		
		WebElement myAccountElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/a"));
		myAccountElmt.click();
		logger.info("My Account cliked");
		
		WebElement logoutElmt = driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul[2]/li[2]/ul/li[2]/a"));
		logoutElmt.click();
		logger.info("Logout cliked");
		
	}

}

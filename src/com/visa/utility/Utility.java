package com.visa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.visa.driver.Driver;



public class Utility {
	//static WebDriver driver = Driver.driver;
	static Logger logger = Driver.logger;
    public static String getFullPath(String halfPath)
    {
    	String currentDir = System.getProperty("user.dir");
    	currentDir=currentDir.replace("\\", "\\\\");
    	return  currentDir+halfPath;
    }
    
    public static void captureScreenShot(WebDriver driver,String stepName) throws IOException
    {
    	
    	// Take screenshot and store as a file format
    	ReadPropertyValues rpDrv = new ReadPropertyValues();
    	String scrnShotFldrPath = rpDrv.getPropValues("ScreenshotFolderPath");
    	scrnShotFldrPath = getFullPath(scrnShotFldrPath);
    	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           
    	try 
    	{
    	// now copy the  screenshot to desired location using copyFile method
    	 
    	FileUtils.copyFile(src, new File(scrnShotFldrPath+stepName+System.currentTimeMillis()+".png")); 
    	} 
    	catch (IOException e)
    	{
    	  logger.error(e.getMessage()) ;
    	}
    }
}

package com.visa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.Logger;
import com.visa.driver.Driver;
import jxl.read.biff.BiffException;

public class HomePageTCRun {
	static Logger logger = Driver.logger;
	
	@Test(groups = { "smoke", "home" })
	public void searchHotelTC1() throws BiffException, IOException
	{
		HomePageTC hmpgTC1 = new HomePageTC();	
		hmpgTC1.validateHotelSearch(1);
		logger.info("Functional Test for hotel search executed taking first data row from Data sheet");
		//HomePageTC hmpgTC2 = new HomePageTC();
		//hmpgTC2.validateHotelSearch();
	}
	
	@Test(groups = { "regression", "home" })
	public void searchHotelTC2() throws BiffException, IOException
	{
		HomePageTC hmpgTC2 = new HomePageTC();
		hmpgTC2.validateHotelSearch(2);
		logger.info("Functional Test for hotel search executed taking second data row from Data sheet");

	}
	@Test(groups = { "smoke", "home" })
	public void signUpTC1() throws BiffException, IOException
	{
		HomePageTC hmpgTC3 = new HomePageTC();
		hmpgTC3.validateSignUp(1);
		logger.info("Functional Test for SignUp executed taking first data row from Data sheet");
	}
	@Test(groups = { "smoke", "home" })
	public void signInTC1() throws BiffException, IOException
	{
		HomePageTC hmpgTC4 = new HomePageTC();
		hmpgTC4.validateLogin(1);
		logger.info("Functional Test for Sign In executed taking first data row from Data sheet");
	}

}

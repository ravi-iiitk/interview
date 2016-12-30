

package com.visa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.Logger;


import com.visa.driver.Driver;
import jxl.read.biff.BiffException;

public class FlightSearchTCRun {
	static Logger logger = Driver.logger;
	
	@Test(groups = { "smoke", "flight" })
	public void flightSearchTC1() throws BiffException, IOException
	{
		FlightSearchTC fltSrchTC1 = new FlightSearchTC();	
		fltSrchTC1.validateFlightSearch(1);
		logger.info("Functional Test for Flight search executed taking first data row from Data sheet");
	}

}

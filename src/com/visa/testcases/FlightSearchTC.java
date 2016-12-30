/**
 * 
 */
package com.visa.testcases;

/**
 * @author Ravi Kumar
 *
 */


import java.io.IOException;


import com.visa.pageobjects.FlightsBooking;
import com.visa.utility.*;

import jxl.read.biff.BiffException;


public class FlightSearchTC {
	ReadExcelFile rdXls = new ReadExcelFile();
	
	
	public void validateFlightSearch(int row) throws BiffException, IOException 
	{
		String dataSheet= "flightsearch";
		String frmLoc = rdXls.readExcel(dataSheet, row, 0);
		String toLoc = rdXls.readExcel(dataSheet, row, 1);
		String depDt= rdXls.readExcel(dataSheet, row, 2);
		String retDt= rdXls.readExcel(dataSheet, row, 3);
		String adult= rdXls.readExcel(dataSheet, row, 4);
		String child= rdXls.readExcel(dataSheet, row, 5);
		String result= rdXls.readExcel(dataSheet, row, 6);
		System.out.println(result);
		FlightsBooking flghtObj1= new FlightsBooking();
		flghtObj1.searchFlight(frmLoc,toLoc, depDt, retDt, adult, child);
		flghtObj1.verifyFlightSearchResults(result);	
	}
}
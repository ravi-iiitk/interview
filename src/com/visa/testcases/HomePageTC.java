package com.visa.testcases;

import java.io.IOException;


import com.visa.pageobjects.HomePage;
import com.visa.utility.*;

import jxl.read.biff.BiffException;


public class HomePageTC {
	ReadExcelFile rdXls = new ReadExcelFile();
	
	
	public void validateHotelSearch(int row) throws BiffException, IOException 
	{
		String location = rdXls.readExcel("hotelsearch", row, 0);
		String checkin= rdXls.readExcel("hotelsearch", row, 1);
		String checkout= rdXls.readExcel("hotelsearch", row, 2);
		String adult= rdXls.readExcel("hotelsearch", row, 3);
		String child= rdXls.readExcel("hotelsearch", row, 4);
		String result= rdXls.readExcel("hotelsearch", row, 5);
		System.out.println(result);
		HomePage hpObj1 = new HomePage();
		hpObj1.searchHotel(location, checkin, checkout, adult, child);
		hpObj1.verifyHotelSearchResults(result);	
	}
	
	public void validateSignUp(int row) throws BiffException, IOException
	{
		String dataSheet = "signup";
		String firstName = rdXls.readExcel(dataSheet, row, 0);
		String lastName= rdXls.readExcel(dataSheet, row, 1);
		String mobNumber= rdXls.readExcel(dataSheet, row, 2);
		String emailId= rdXls.readExcel(dataSheet, row, 3);
		String password= rdXls.readExcel(dataSheet, row, 4);
		String result= rdXls.readExcel(dataSheet, row, 5);
		HomePage hpObj2 = new HomePage();
		hpObj2.doSignUp(firstName, lastName, mobNumber, emailId, password);
		hpObj2.verifySignUP(result);
	}
	
	public void validateLogin(int row) throws BiffException, IOException
	{
		String dataSheet = "login";
		String userID = rdXls.readExcel(dataSheet, row, 0);
		String password= rdXls.readExcel(dataSheet, row, 1);
		String result= rdXls.readExcel(dataSheet, row, 2);
		HomePage hpObj2 = new HomePage();
		hpObj2.doSignIn(userID, password);
		hpObj2.verifySignIn(result);
	}
}

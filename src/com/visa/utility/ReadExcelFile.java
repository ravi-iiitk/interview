/**
 * 
 */
package com.visa.utility;

/**
 * @author Ravi Kumar
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelFile {
	
	public String  readExcel(String dataSheet,int row,int col) throws BiffException, IOException {
		ReadPropertyValues rp = new ReadPropertyValues();
		String FilePath = rp.getPropValues("DataSheetFilePath");
		FilePath = Utility.getFullPath(FilePath);
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet(dataSheet);

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		if(row>totalNoOfRows || col>totalNoOfCols)
			return null;
		else
			return sh.getCell(col, row).getContents();
			
	}
}

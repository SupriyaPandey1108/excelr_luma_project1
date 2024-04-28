package Utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
public static Object[][] getData(String filePath, String sheetName) {
		
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rcount = sheet.getLastRowNum();
		int ccount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rcount+1][ccount];
		for (int row = 0; row <= rcount; row++) {
			for (int col = 0; col < ccount; col++) {
				data[row][col] = sheet.getRow(row).getCell(col).getStringCellValue();
			}
			
		}
		
		return data;
	}


}

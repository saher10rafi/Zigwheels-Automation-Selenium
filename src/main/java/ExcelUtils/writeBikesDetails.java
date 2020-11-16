package ExcelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeBikesDetails {
	
	public void bikeDetails(String[] name, String[] Price,String[] date ) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		Properties prop = null;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("BikeDetails");
		//iterating rows and printing the headphones with price
		for (int i = 0; i <6; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(name[i]);
			row.createCell(1).setCellValue(Price[i]);
			row.createCell(2).setCellValue(date[i]);
		}
		sheet.autoSizeColumn(0);
		//Writing the output to Excel file using FileOutputStream
		try {
			fos = new FileOutputStream("UpcomingBikes.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

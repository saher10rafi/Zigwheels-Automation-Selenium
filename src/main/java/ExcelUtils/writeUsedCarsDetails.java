package ExcelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeUsedCarsDetails {
	
	public void CarDetails(String[] carsmodels,int count) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet1 = null;
		XSSFRow row = null;
		Properties prop = null;
		workbook = new XSSFWorkbook();
		sheet1 = workbook.createSheet("UsedCarsDetails");
	
		
		//iterating rows and printing the headphones with price
		for (int i = 0; i < count; i++) {
			row = sheet1.createRow(i);
		
			row.createCell(0).setCellValue(carsmodels[i]);
			
		}
		sheet1.autoSizeColumn(0);
		//Writing the output to Excel file using FileOutputStream
		try {
			fos = new FileOutputStream("UsedCars.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

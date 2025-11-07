package excelhandling;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelwriting2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\Venkatesh Yedla\\eclipse-workspace\\TestAutomation\\TestData\\Testdata3.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet= workbook.createSheet("Venkat");
		 XSSFRow row = sheet.createRow(0);
		 
		 row.createCell(0).setCellValue(1);
		 row.createCell(1).setCellValue(2);
		 row.createCell(2).setCellValue(3);
		
		 XSSFRow row1 = sheet.createRow(1);
		 row1.createCell(0).setCellValue(4);
		 row1.createCell(1).setCellValue(5);
		 
		 workbook.write(file);
		 workbook.close();
		 file.close();
	}

}
